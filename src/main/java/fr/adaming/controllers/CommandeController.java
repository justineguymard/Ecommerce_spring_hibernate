package fr.adaming.controllers;

import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
@RequestMapping("admin/comctrl/")
@Scope("session")
public class CommandeController {

	
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

		// appel de la m�thode service pour r�cup�rer toutes les infos de l'admin
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
		@GetMapping(value = "/displayAddCom")
		public String afficheAjouter(Model modele) {

			// ajouter une categorie dans le modele mvc
			modele.addAttribute("comajout", new Commande());
			

			return "2_adminAjoutCommande";
		}

		// b: la m�thode pour traiter le formulaire d'ajout
		@PostMapping(value = "/submitAddCl")
		public String soumettreAjout(@ModelAttribute("comajout") Commande commande) {

			// appel de la m�thode service pour ajouter la categorie dans la bd
			Client verif = clService.addClient(client);
			cdService.addCommande(commandeIn, clientIn)

			if (clientverif != null && commandeverif != null) {
				return "redirect:liste";
			} else {
				return "redirect:displayAddCl";
			}
		}

	
	
		// ======================================= 3: fonctionnalit� update client
		@RequestMapping(value = "/displayUpdateCom", method = RequestMethod.GET)
		public ModelAndView afficheMofifier() {

			return new ModelAndView("2_adminModifCommande", "commodif", new Commande());
		}

		// b: la m�thode pour traiter le formulaire d'ajout
		@PostMapping(value = "/submitUpdateCom")
		public String soumettreModif(@ModelAttribute("commodif") Commande commande, RedirectAttributes rda) {

			// appel de la m�thode service pour ajouter l'�tudiant dans la bd
			Commande verif = cdService.updateCommande(commande);

			if (verif != null) {
				return "redirect:liste";
			} else {
				// afficher un message d'erreur
				String message = "La modification a �chou�e !";
				rda.addFlashAttribute("msg", message);
				return "redirect:displayUpdateCom";
			}
		}

		// ======================================= 4: fonctionnalit� delete Categorie
		// a: la m�thode pour afficher le formulaire d'ajout et lui associer une
		// categorie
		@GetMapping(value = "/displayDeleteCom")
		public String afficheSupprimer() {

			return "2_adminSupprCommande";
		}

		// b: la m�thode pour traiter le formulaire d'ajout
		@PostMapping(value = "/submitDeleteCom")
		public String soumettreSuppr(Model modele, @RequestParam("pId") int id) {

			Commande commande = new Commande();
			commande.setIdCommande(id);
			

			// appel de la m�thode service pour ajouter l'�tudiant dans la bd
			Commande verif = cdService.deleteCommande(commande);

			if (verif != null) {
				return "redirect:liste";
			} else {
				modele.addAttribute("msg", "La suppression a �chou�e!");
				return "2_adminSupprCommande";
			}
		}

		// ======================================= 5: fonctionnalit� search Cat�gorie
		// a: la m�thode pour afficher le formulaire d'ajout et lui associer une
		// cat�gorie
		@GetMapping(value = "/displaySearchNameCom")
		public String afficheChercher() {
			
			return "2_adminRechCommandeByDate";
		}

		// b: la m�thode pour traiter le formulaire d'ajout
		@GetMapping(value = "/submitSearchDateCom")
		public String soumettreRechercher(Model modele, @RequestParam("pDate") Date date,
				@RequestParam(value = "pLien", required = false) String updateLink) {

			Commande commande = new Commande();
			commande.setDateCommande(date);
		

			// appel de la m�thode service pour ajouter l'�tudiant dans la bd
			List<Commande> verif = cdService.searchCommandeByDate(commande);

			if (verif.size() != 0) {

				if (updateLink != null) {
					modele.addAttribute("comByDate", verif);
				}

				// ajouter l'�tudiant dans le modele MVC
				modele.addAttribute("cmdSearchDate", verif);
				return "2_adminRechCommandeByDate";
			} else {
				modele.addAttribute("msg", "Aucune commande pass�e le "+date+".");
				return "2_adminRechCommandeByDate";
			}
		}
		
		// ======================================= 5: fonctionnalit� search Cat�gorie
		// a: la m�thode pour afficher le formulaire d'ajout et lui associer une
		// cat�gorie
		@GetMapping(value = "/displaySearchIDCom")
		public String afficheChercher2() {
			
			return "2_adminRechCommandeByID";
		}

		// b: la m�thode pour traiter le formulaire d'ajout
		@GetMapping(value = "/submitSearchIDCom")
		public String soumettreRechercher2(Model modele, @RequestParam("pId") int id,
				@RequestParam(value = "pLien", required = false) String updateLink) {

			Commande commande = new Commande();
			
			commande.setIdCommande(id);
			

			// appel de la m�thode service pour ajouter l'�tudiant dans la bd
			Commande verif = cdService.searchCommandeByID(commande);
			
			if (verif != null) {

				if (updateLink != null) {
					modele.addAttribute("cmdByID", verif);
				}

				// ajouter l'�tudiant dans le modele MVC
				modele.addAttribute("cmdSearchID", verif);
				return "2_adminRechCommandeByID";
			} else {
				modele.addAttribute("msg", "Cette commande n'existe pas.");
				return "2_adminRechCommandeByID";
			}
		}

	}

