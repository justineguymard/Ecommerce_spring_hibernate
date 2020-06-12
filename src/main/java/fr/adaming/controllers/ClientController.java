package fr.adaming.controllers;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;
import fr.adaming.entities.Commande;
import fr.adaming.entities.LigneCommande;
import fr.adaming.entities.Produit;
import fr.adaming.service.IAdminService;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IClientService;
import fr.adaming.service.ICommandeService;
import fr.adaming.service.ILigneCommandeService;
import fr.adaming.service.IProduitService;

@Controller
@RequestMapping("admin/clctrl")
@Scope("session")
public class ClientController {
	
	
	@Autowired
	private IAdminService aService;
	@Autowired
	private ICategorieService ctService;
	@Autowired
	private IProduitService pService;
	@Autowired
	private IClientService clService;
	@Autowired
	private ICommandeService cdService;
	@Autowired
	private ILigneCommandeService lcService;

	
	private Admin admin;

	@PostConstruct
	public void init() {

		// r�cup�rer le context de spring security
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		// r�cup�rer le mail du formateur connect�
		String mail = auth.getName();

		// appel de la m�thode service pour r�cup�rer toutes les infos du formateur
		// connect�

		this.admin = aService.getAdminByMail(mail);

	}

	@RequestMapping(value = "/liste", method = RequestMethod.GET)
	public String afficheListe(ModelMap modele) {

		// r�cup�rer la liste
		List<Categorie> listeCategorie = ctService.getAllCategorie();
		List<Produit> listeProduit = pService.getAllProduit();
		List<Client> listeClient = clService.getAllClients();
		List<Commande> listeCommande = cdService.getAllCommandes();
		List<LigneCommande> listeLigneCommande = lcService.getAllLigneCommande();

		// l'ajouter dans le modele MVC
		modele.addAttribute("categories", listeCategorie);
		modele.addAttribute("produits", listeProduit);
		modele.addAttribute("clients", listeClient);
		modele.addAttribute("commandes", listeCommande);
		modele.addAttribute("lignesCommandes", listeLigneCommande);

		return "1_1_adminConsultation";
	}
	
	// ======================================= 2: fonctionnalit� ajouter Categorie
		// a: la m�thode pour afficher le formulaire d'ajout et lui associer une
		// cat�gorie
		@GetMapping(value = "/displayAddCl")
		public String afficheAjouter(Model modele) {

			// ajouter une categorie dans le modele mvc
			modele.addAttribute("clajout", new Categorie());

			return "3_adminAjoutClient";
		}

		// b: la m�thode pour traiter le formulaire d'ajout
		@PostMapping(value = "/submitAddCl")
		public String soumettreAjout(@ModelAttribute("lajout") Client client) {

			// appel de la m�thode service pour ajouter la categorie dans la bd
			Client verif = clService.addClient(client);

			if (verif != null) {
				return "redirect:liste";
			} else {
				return "redirect:displayAddCl";
			}
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
