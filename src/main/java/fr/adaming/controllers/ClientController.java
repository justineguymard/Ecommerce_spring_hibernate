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

		// récupérer le context de spring security
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		// récupérer le mail du formateur connecté
		String mail = auth.getName();

		// appel de la méthode service pour récupérer toutes les infos de l'admin
		// connecté

		this.admin = aService.getAdminByMail(mail);

	}

	@RequestMapping(value = "/liste", method = RequestMethod.GET)
	public String afficheListe(ModelMap modele) {

		// récupérer la liste
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
	
	// ======================================= 2: fonctionnalité ajouter Categorie
		// a: la méthode pour afficher le formulaire d'ajout et lui associer une
		// catégorie
		@GetMapping(value = "/displayAddCl")
		public String afficheAjouter(Model modele) {

			// ajouter une categorie dans le modele mvc
			modele.addAttribute("clajout", new Client());

			return "3_adminAjoutClient";
		}

		// b: la méthode pour traiter le formulaire d'ajout
		@PostMapping(value = "/submitAddCl")
		public String soumettreAjout(@ModelAttribute("clajout") Client client) {

			// appel de la méthode service pour ajouter la categorie dans la bd
			Client verif = clService.addClient(client);

			if (verif != null) {
				return "redirect:liste";
			} else {
				return "redirect:displayAddCl";
			}
		}

	
	
		// ======================================= 3: fonctionnalité update client
		@RequestMapping(value = "/displayUpdateCl", method = RequestMethod.GET)
		public ModelAndView afficheMofifier() {

			return new ModelAndView("3_adminModifClient", "clmodif", new Client());
		}

		// b: la méthode pour traiter le formulaire d'ajout
		@PostMapping(value = "/submitUpdateCl")
		public String soumettreModif(@ModelAttribute("clmodif") Client client, RedirectAttributes rda) {

			// appel de la méthode service pour ajouter l'étudiant dans la bd
			Client verif = clService.updateClient(client);

			if (verif != null) {
				return "redirect:liste";
			} else {
				// afficher un message d'erreur
				String message = "La modification a échouée !";
				rda.addFlashAttribute("msg", message);
				return "redirect:displayUpdateCat";
			}
		}

		// ======================================= 4: fonctionnalité delete Categorie
		// a: la méthode pour afficher le formulaire d'ajout et lui associer une
		// categorie
		@GetMapping(value = "/displayDeleteCl")
		public String afficheSupprimer() {

			return "3_adminSupprClient";
		}

		// b: la méthode pour traiter le formulaire d'ajout
		@PostMapping(value = "/submitDeleteCl")
		public String soumettreSuppr(Model modele, @RequestParam("pId") int id) {

			Client client = new Client();

			client.setIdClient(id);
			
			// appel de la méthode service pour ajouter l'étudiant dans la bd
			
			Client verif = clService.deleteClient(client);

			if (verif != null) {
				return "redirect:liste";
			} else {
				modele.addAttribute("msg", "La suppression a échouée!");
				return "3_adminSupprClient";
			}
		}

		// ======================================= 5: fonctionnalité search Catégorie
		// a: la méthode pour afficher le formulaire d'ajout et lui associer une
		// catégorie
		@GetMapping(value = "/displaySearchNameCl")
		public String afficheChercher() {
			
			return "3_adminRechClientByName";
		}

		// b: la méthode pour traiter le formulaire d'ajout
		@GetMapping(value = "/submitSearchNameCl")
		public String soumettreRechercher(Model modele, @RequestParam("pNom") String nom,
				@RequestParam(value = "pLien", required = false) String updateLink) {

			
			Client client = new Client();
	
			client.setNomClient(nom);

			// appel de la méthode service pour ajouter l'étudiant dans la bd
			List<Client> clOut = clService.searchClientByNom(client);

			if (clOut != null) {

				if (updateLink != null) {
					modele.addAttribute("clByName", clOut);
				}

				// ajouter l'étudiant dans le modele MVC
				modele.addAttribute("clSearchName", clOut);
				return "3_adminRechercheClientByName";
			} else {
				modele.addAttribute("msg", "Ce client n'existe pas.");
				return "3_adminRechercheClientByName";
			}
		}
		
		// ======================================= 5: fonctionnalité search Catégorie
		// a: la méthode pour afficher le formulaire d'ajout et lui associer une
		// catégorie
		@GetMapping(value = "/displaySearchIDCl")
		public String afficheChercher2() {
			
			return "3_adminRechercheClientByID";
		}

		// b: la méthode pour traiter le formulaire d'ajout
		@GetMapping(value = "/submitSearchIDCl")
		public String soumettreRechercher2(Model modele, @RequestParam("pId") int id,
				@RequestParam(value = "pLien", required = false) String updateLink) {

			
			Client client = new Client();
	
			client.setIdClient(id);

			// appel de la méthode service pour ajouter l'étudiant dans la bd
			Client clOut = clService.searchClientByID(client);
			
			if (clOut != null) {

				if (updateLink != null) {
					modele.addAttribute("clByID", clOut);
				}

				// ajouter l'étudiant dans le modele MVC
				modele.addAttribute("clSearchID", clOut);
				return "3_adminRechercheClientByID";
			} else {
				modele.addAttribute("msg", "Ce client n'existe pas.");
				return "3_adminRechercheClientByID";
			}
		}

	}
