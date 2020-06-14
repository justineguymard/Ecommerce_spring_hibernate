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
@RequestMapping("/admin/prodctrl")
@Scope("session")
public class ProduitController {

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

	private Categorie categorie;

	// ======================================= 1: fonctionnalité récupérer la liste
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

	// ======================================= 2: fonctionnalité ajouter Produit
	// a: la méthode pour afficher le formulaire d'ajout et lui associer un produit
	@GetMapping(value = "/displayAddProd")
	public ModelAndView afficheAjouter(Model modele) {

		return new ModelAndView("1_2_adminAjoutProduit", "prodajout", new Produit());
	}

	// b: la méthode pour traiter le formulaire d'ajout
	@PostMapping(value = "/submitAddProd")
	public String soumettreAjout(@ModelAttribute("prodajout") Produit produit) {

		// appel de la méthode service pour ajouter la categorie dans la bd
		int verif = pService.addProduit(produit, categorie);

		if (verif != 0) {
			return "redirect:liste";
		} else {
			return "redirect:displayAddProd";
		}
	}

	// ======================================= 3: fonctionnalité update Produit
	// a: la méthode pour afficher le formulaire d'ajout et lui associer un produit
	@RequestMapping(value = "/displayUpdateProd", method = RequestMethod.GET)
	public ModelAndView afficheMofifier() {

		return new ModelAndView("1_3_adminModifProduit", "prodmodif", new Produit());
	}

	// b: la méthode pour traiter le formulaire d'ajout
	@PostMapping(value = "/submitUpdateProd")
	public String soumettreModif(@ModelAttribute("prodmodif") Produit produit, RedirectAttributes rda) {

		// appel de la méthode service pour ajouter l'étudiant dans la bd
		int verif = pService.updateProduit(produit);

		if (verif != 0) {
			return "redirect:liste";
		} else {
			// afficher un message d'erreur
			String message = "La modification a échouée !";
			rda.addFlashAttribute("msg", message);
			return "redirect:displayUpdateProd";
		}
	}

	// ======================================= 4: fonctionnalité delete Produit
	// a: la méthode pour afficher le formulaire d'ajout et lui associer un produit
	@GetMapping(value = "/displayDeleteProd")
	public String afficheSupprimer() {

		return "1_4_adminSupprProduit";
	}

	// b: la méthode pour traiter le formulaire d'ajout
	@PostMapping(value = "/submitDeleteProd")
	public String soumettreSuppr(Model modele, @RequestParam("pId") Long id) {

		Produit produit = new Produit();

		produit.setIdProduit(id);

		// appel de la méthode service pour ajouter le produit dans la bd
		int verif = pService.deleteProduit(produit);

		if (verif != 0) {
			return "redirect:liste";
		} else {
			modele.addAttribute("msg", "La suppression a échouée!");
			return "1_4_adminSupprProduit";
		}
	}

	// ======================================= 5: fonctionnalité search Produit par
	// Catégorie
	// a: la méthode pour afficher le formulaire d'ajout et lui associer un produit
	@GetMapping(value = "/displaySearchProdByCat")
	public String afficheChercher() {

		return "1_5_adminRechercheProduitByCategorie";
	}

	// b: la méthode pour traiter le formulaire d'ajout
	@GetMapping(value = "/submitSearchProdByCat")
	public String soumettreRechercher(Model modele, @RequestParam("pNom") String nom) {

		Categorie categorie = new Categorie();

		categorie.setNomCategorie(nom);

		// appel de la méthode service pour ajouter l'étudiant dans la bd
		List<Produit> pOut = pService.searchProduitByCategorie(categorie);

		if (pOut != null) {

			// ajouter l'étudiant dans le modele MVC
			modele.addAttribute("prodsearch", pOut);
			return "1_5_adminRechercheProduitByCategorie";

		} else {

			modele.addAttribute("msg", "La catégorie n'existe pas!");
			return "1_5_adminRechercheProduitByCategorie";
		}
	}

	// ======================================= 6: fonctionnalité search Produit par
	// Nom
	// a: la méthode pour afficher le formulaire d'ajout et lui associer un produit
	@GetMapping(value = "/displaySearchProdByName")
	public String afficheChercher1() {

		return "1_5_adminRechercheProduitByName";
	}

	// b: la méthode pour traiter le formulaire d'ajout
	@GetMapping(value = "/submitSearchProdByName")
	public String soumettreRechercher1(Model modele, @RequestParam("pNom") String designation) {

		Produit produit = new Produit();

		produit.setDesignation(designation);

		// appel de la méthode service pour ajouter l'étudiant dans la bd
		List<Produit> pOut = pService.searchProduitByName(designation);

		if (pOut != null) {

			// ajouter l'étudiant dans le modele MVC
			modele.addAttribute("prodsearch", pOut);
			return "1_5_adminRechercheProduitByName";

		} else {
			modele.addAttribute("msg", "La catégorie n'existe pas!");
			return "1_5_adminRechercheProduitByName";
		}
	}

	// ======================================= 7: fonctionnalité search Produit
	// a: la méthode pour afficher le formulaire d'ajout et lui associer une
	// catégorie
	@GetMapping(value = "/displaySearchProd")
	public String afficheChercher3() {

		return "1_3_adminModifProduit";
	}

	// b: la méthode pour traiter le formulaire d'ajout
	@GetMapping(value = "/submitSearchProd")
	public String soumettreRechercher(Model modele, @RequestParam("pNom") String designation,
			@RequestParam(value = "pLien", required = false) String updateLink) {

		Produit produit = new Produit();

		produit.setDesignation(designation);

		// appel de la méthode service pour ajouter l'étudiant dans la bd
		Produit pOut = pService.searchProduit(produit);

		if (pOut != null) {

			if (updateLink != null) {
				modele.addAttribute("prodmodif", pOut);
			}

			// ajouter l'étudiant dans le modele MVC
			modele.addAttribute("prodsearch", pOut);
			return "1_3_adminModifProduit";

		} else {
			modele.addAttribute("msg", "La catégorie n'existe pas!");
			return "1_3_adminModifProduit";
		}
	}

}
