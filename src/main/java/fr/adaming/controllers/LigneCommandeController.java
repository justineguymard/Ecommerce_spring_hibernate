package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;
import fr.adaming.entities.Commande;
import fr.adaming.entities.LigneCommande;
import fr.adaming.entities.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IClientService;
import fr.adaming.service.ICommandeService;
import fr.adaming.service.ILigneCommandeService;
import fr.adaming.service.IProduitService;

@Controller
@RequestMapping("/admin/lcctrl")
@Scope("session")
public class LigneCommandeController {
	

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

	// ======================================= 1: fonctionnalit� r�cup�rer la liste
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
	@GetMapping(value = "/displayAddLC")
	public String afficheAjouter(Model modele) {

		// ajouter une categorie dans le modele mvc
		modele.addAttribute("lcajout", new LigneCommande());

		return "4_adminAjoutLC";
	}

	// b: la m�thode pour traiter le formulaire d'ajout
	@PostMapping(value = "/submitAddLC")
	public String soumettreAjout(@ModelAttribute("lcajout") LigneCommande lignecommande, @ModelAttribute("prodLC") Produit produit, @ModelAttribute("catLC") Commande commande) {

		// appel de la m�thode service pour ajouter la categorie dans la bd
		int verif = lcService.addLigneCommande(lignecommande, produit, commande);

		if (verif != 0) {
			return "redirect:liste";
		} else {
			return "redirect:displayAddLC";
		}
	}

	// ======================================= 3: fonctionnalit� update Categorie
	// a: la m�thode pour afficher le formulaire d'ajout et lui associer une
	// cat�gorie
	@RequestMapping(value = "/displayUpdateLC", method = RequestMethod.GET)
	public ModelAndView afficheModifier() {

		return new ModelAndView("4_adminModifLC", "lcmodif", new LigneCommande());
	}

	// b: la m�thode pour traiter le formulaire d'ajout
	@PostMapping(value = "/submitUpdateLC")
	public String soumettreModif(@ModelAttribute("lcmodif") LigneCommande lignecommande, RedirectAttributes rda) {

		// appel de la m�thode service pour ajouter l'�tudiant dans la bd
		int verif = lcService.updateLigneCommande(lignecommande);

		if (verif != 0) {
			return "redirect:liste";
		} else {
			// afficher un message d'erreur
			String message = "La modification a �chou�e !";
			rda.addFlashAttribute("msg", message);
			return "redirect:displayUpdateLC";
		}
	}

	// ======================================= 4: fonctionnalit� delete Categorie
	// a: la m�thode pour afficher le formulaire d'ajout et lui associer une
	// categorie
	@GetMapping(value = "/displayDeleteLC")
	public String afficheSupprimer() {

		return "4_adminSupprLC";
	}

	// b: la m�thode pour traiter le formulaire d'ajout
	@PostMapping(value = "/submitDeleteLC")
	public String soumettreSuppr(Model modele, @RequestParam("pId") int id) {

		LigneCommande lignecommande = new LigneCommande();

		lignecommande.setId(id);

		// appel de la m�thode service pour ajouter l'�tudiant dans la bd
		int verif = lcService.deleteLigneCommande(lignecommande);

		if (verif != 0) {
			return "redirect:liste";
		} else {
			modele.addAttribute("msg", "La suppression a �chou�e!");
			return "4_adminSupprLC";
		}
	}

}
