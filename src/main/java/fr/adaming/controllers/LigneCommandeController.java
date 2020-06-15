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

	// ======================================= 2: fonctionnalité ajouter Categorie
	// a: la méthode pour afficher le formulaire d'ajout et lui associer une
	// catégorie
	@GetMapping(value = "/displayAddCat")
	public String afficheAjouter(Model modele) {

		// ajouter une categorie dans le modele mvc
		modele.addAttribute("catajout", new Categorie());

		return "1_2_adminAjoutCategorie";
	}

	// b: la méthode pour traiter le formulaire d'ajout
	@PostMapping(value = "/submitAddCat")
	public String soumettreAjout(@ModelAttribute("catajout") Categorie categorie) {

		// appel de la méthode service pour ajouter la categorie dans la bd
		int verif = ctService.addCategorie(categorie);

		if (verif != 0) {
			return "redirect:liste";
		} else {
			return "redirect:displayAddCat";
		}
	}

	// ======================================= 3: fonctionnalité update Categorie
	// a: la méthode pour afficher le formulaire d'ajout et lui associer une
	// catégorie
	@RequestMapping(value = "/displayUpdateCat", method = RequestMethod.GET)
	public ModelAndView afficheMofifier() {

		return new ModelAndView("1_3_adminModifCategorie", "catmodif", new Categorie());
	}

	// b: la méthode pour traiter le formulaire d'ajout
	@PostMapping(value = "/submitUpdateCat")
	public String soumettreModif(@ModelAttribute("catmodif") Categorie categorie, RedirectAttributes rda) {

		// appel de la méthode service pour ajouter l'étudiant dans la bd
		int verif = ctService.updateCategorie(categorie);

		if (verif != 0) {
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
	@GetMapping(value = "/displayDeleteCat")
	public String afficheSupprimer() {

		return "1_4_adminSupprCategorie";
	}

	// b: la méthode pour traiter le formulaire d'ajout
	@PostMapping(value = "/submitDeleteCat")
	public String soumettreSuppr(Model modele, @RequestParam("pId") Long id) {

		Categorie categorie = new Categorie();

		categorie.setIdCategorie(id);

		// appel de la méthode service pour ajouter l'étudiant dans la bd
		int verif = ctService.deleteCategorie(categorie);

		if (verif != 0) {
			return "redirect:liste";
		} else {
			modele.addAttribute("msg", "La suppression a échouée!");
			return "1_4_adminSupprCategorie";
		}
	}

}
