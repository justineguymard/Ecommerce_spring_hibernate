package fr.adaming.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MonController {
	
	@GetMapping(value = "/welcomeSite")
	public String afficheAccueil() {
		
		return "0_accueilSite";
	}
	
	@RequestMapping(value = "/admin/gestion", method = RequestMethod.GET)
	public String afficheAdmin(ModelMap modele) {
		
		// recuperer le context de spring security
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		// ajouter le login de l'utilisateur connecté
		String mail = auth.getName();
		
		// ajouter le login dans le modele mvc
		modele.addAttribute("login", mail);
		
		modele.addAttribute("msg", "Vous êtes dans un espace administrateur");
		
		return "1_1_adminConsultation";
	}
	
//	@RequestMapping(value = "/public/client", method = RequestMethod.GET)
//	public String afficheClient(ModelMap modele) {
//		
//		modele.addAttribute("msg", "Vous êtes dans un espace client");
//		
//		return "accueilClient";
//	}

}
