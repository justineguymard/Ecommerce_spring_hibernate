package fr.adaming.controllers;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.service.IAdminService;
import fr.adaming.service.ICategorieService;

@Controller
@RequestMapping("/actrl")
@Scope("session")
public class AdminController {

	@Autowired
	private IAdminService aService;
	@Autowired
	private ICategorieService cService;

	private Admin admin;

	@PostConstruct
	public void init() {

		// récupérer le context de spring security
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		// récupérer le mail du formateur connecté
		String mail = auth.getName();

		// appel de la méthode service pour récupérer toutes les infos du formateur
		// connecté

		this.admin = aService.getAdminByMail(mail);

	}

	// ======================================= 1: fonctionnalité récupérer la liste
	@RequestMapping(value = "/liste", method = RequestMethod.GET)
	public String afficheListe(ModelMap modele) {

		// récupérer la liste
		List<Categorie> listeCategorie = cService.getAllCategorie();

		// l'ajouter dans le modele MVC
		modele.addAttribute("categories", listeCategorie);

		return "1_1_adminConsultation";
	}

}
