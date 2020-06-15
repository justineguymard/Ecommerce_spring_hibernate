package fr.adaming.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
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

		// récupérer le context de spring security
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		// récupérer le mail du formateur connecté
		String mail = auth.getName();

		// appel de la méthode service pour récupérer toutes les infos de l'admin
		// connecté

		this.admin = aService.getAdminByMail(mail);

	}
	

	@InitBinder // cette annotation permets de definir la méthode à appeler lors d'une
				// conversion des donénes
	public void initBinding(WebDataBinder binder) {
		// l'objet de type WebDataBinder permet de lier les params de la requete aux
		// attributs de l'objet java
		// specifier le format String de la date à convertir en java.util.Date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// forcer la méthode de conversion à lever une exception de type parseException
		// si la date reçue ne correspond pas au pattern
		sdf.setLenient(false);

		// la méthode registerCustomEditor permet de configurer la conversion du param
		// de la requete recue au tyoe de l'attribut concernés
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
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
	@GetMapping(value = "/displayAddCom")
	public String afficheAjouter() {

		return "2_adminAjoutCommande";
	}

	// b: la méthode pour traiter le formulaire d'ajout
	@GetMapping(value = "/submitAddCom")
	public String soumettreAjout(Model model, @RequestParam("pDate") Date dateIn, 
			@RequestParam("pIdCl") int idClIn) {

		Client client = new Client();
		client.setIdClient(idClIn);
		// appel de la méthode service pour ajouter la categorie dans la bd
		Client clientverif = clService.searchClientByID(client);
		
		Commande commande = new Commande();
		commande.setDateCommande(dateIn);
		System.out.println("\n\n==========="+commande+" :::: "+clientverif);

		if (clientverif != null) {

			Commande commandeverif = cdService.addCommande(commande, clientverif);

			if (commandeverif != null) {
				return "redirect:liste";
			} else {
				return "redirect:displayAddCl";
			}
		}
		else {
			return "redirect:displayAddCl";
		}
		
	}

	// ======================================= 3: fonctionnalité update client
	@RequestMapping(value = "/displayUpdateCom", method = RequestMethod.GET)
	public ModelAndView afficheMofifier() {

		return new ModelAndView("2_adminModifCommande", "commodif", new Commande());
	}

	// b: la méthode pour traiter le formulaire d'ajout
	@PostMapping(value = "/submitUpdateCom")
	public String soumettreModif(@ModelAttribute("commodif") Commande commande, RedirectAttributes rda) {

		// appel de la méthode service pour ajouter l'étudiant dans la bd
		Commande verif = cdService.updateCommande(commande);

		if (verif != null) {
			return "redirect:liste";
		} else {
			// afficher un message d'erreur
			String message = "La modification a échouée !";
			rda.addFlashAttribute("msg", message);
			return "redirect:displayUpdateCom";
		}
	}
	
	@GetMapping(value = "/submitUpdateCom")
	public String soumettreAjout(Model model, @RequestParam("pId") int idCom, 
			@RequestParam("pDate") Date dateIn, 
			@RequestParam("pIdCl") int idCl) {

		Client client = new Client();
		client.setIdClient(idCl);
		// appel de la méthode service pour ajouter la categorie dans la bd
		Client clientverif = clService.searchClientByID(client);
		
		
		Commande commande = new Commande();
		commande.setIdCommande(idCom);
		commande.setDateCommande(dateIn);
		commande.setClient(clientverif);
				
		System.out.println("\n\n==========="+commande+" :::: "+clientverif);

		if (clientverif != null) {

			Commande commandeverif = cdService.updateCommande(commande);
			System.out.println("\n ===" +commandeverif);

			if (commandeverif != null) {
				return "redirect:liste";
			} else {
				model.addAttribute("msg", "La modification a échouée !");
				
				return "redirect:displayUpdateCom";
			} 
		}else {
			model.addAttribute("msg","Pas de client !");
		return "redirect:displayUpdateCom";
		}
		
	}

	// ======================================= 4: fonctionnalité delete Categorie
	// a: la méthode pour afficher le formulaire d'ajout et lui associer une
	// categorie
	@GetMapping(value = "/displayDeleteCom")
	public String afficheSupprimer() {

		return "2_adminSupprCommande";
	}

	// b: la méthode pour traiter le formulaire d'ajout
	@PostMapping(value = "/submitDeleteCom")
	public String soumettreSuppr(Model modele, @RequestParam("pId") int id) {

		Commande commande = new Commande();
		commande.setIdCommande(id);

		// appel de la méthode service pour ajouter l'étudiant dans la bd
		Commande verif = cdService.deleteCommande(commande);

		if (verif != null) {
			return "redirect:liste";
		} else {
			modele.addAttribute("msg", "La suppression a échouée!");
			return "2_adminSupprCommande";
		}
	}

	// ======================================= 5: fonctionnalité search Catégorie
	// a: la méthode pour afficher le formulaire d'ajout et lui associer une
	// catégorie
	@GetMapping(value = "/displaySearchDateCom")
	public String afficheChercher() {

		return "2_adminRechCommandeByDate";
	}

	// b: la méthode pour traiter le formulaire d'ajout
	@GetMapping(value = "/submitSearchDateCom")
	public String soumettreRechercher(Model modele, @RequestParam("pDate") Date date,
			@RequestParam(value = "pLien", required = false) String updateLink) {

		Commande commande = new Commande();
		commande.setDateCommande(date);

		// appel de la méthode service pour ajouter l'étudiant dans la bd
		List<Commande> verif = cdService.searchCommandeByDate(commande);

		if (verif.size() != 0) {

			if (updateLink != null) {
				modele.addAttribute("comByDate", verif);
			}

			// ajouter l'étudiant dans le modele MVC
			modele.addAttribute("cmdSearchDate", verif);
			return "2_adminRechCommandeByDate";
		} else {
			modele.addAttribute("msg", "Aucune commande passée le " + date + ".");
			return "2_adminRechCommandeByDate";
		}
	}

	// ======================================= 5: fonctionnalité search Catégorie
	// a: la méthode pour afficher le formulaire d'ajout et lui associer une
	// catégorie
	@GetMapping(value = "/displaySearchIDCom")
	public String afficheChercher2() {

		return "2_adminRechCommandeByID";
	}

	// b: la méthode pour traiter le formulaire d'ajout
	@GetMapping(value = "/submitSearchIDCom")
	public String soumettreRechercher2(Model modele, @RequestParam("pId") int id,
			@RequestParam(value = "pLien", required = false) String updateLink) {

		Commande commande = new Commande();

		commande.setIdCommande(id);

		// appel de la méthode service pour ajouter l'étudiant dans la bd
		Commande verif = cdService.searchCommandeByID(commande);

		if (verif != null) {

			if (updateLink != null) {
				modele.addAttribute("cmdByID", verif);
			}

			// ajouter l'étudiant dans le modele MVC
			modele.addAttribute("cmdSearchID", verif);
			return "2_adminRechCommandeByID";
		} else {
			modele.addAttribute("msg", "Cette commande n'existe pas.");
			return "2_adminRechCommandeByID";
		}
	}

}
