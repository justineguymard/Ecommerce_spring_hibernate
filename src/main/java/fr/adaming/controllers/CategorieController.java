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
@RequestMapping("/admin/catctrl")
@Scope("session")
public class CategorieController {
	
	@Autowired
	private IAdminService aService;
	@Autowired
	private ICategorieService cService;

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

	// ======================================= 1: fonctionnalit� r�cup�rer la liste
	@RequestMapping(value = "/liste", method = RequestMethod.GET)
	public String afficheListe(ModelMap modele) {

		// r�cup�rer la liste
		List<Categorie> listeCategorie = cService.getAllCategorie();

		// l'ajouter dans le modele MVC
		modele.addAttribute("categories", listeCategorie);

		return "1_1_adminConsultation";
	}

}
