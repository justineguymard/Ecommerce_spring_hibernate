package fr.adaming.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping(value = "/login")
	public String afficheLogin() {
		
		return "1_0_adminLogin";
	}
	
	@GetMapping(value = "/echec")
	public String afficheEchecLogin(Model modele) {
		
		// ajouter le message d'erreur dans le modele MVC
		modele.addAttribute("msg", "Le login ou mot de passe erron�(s) !");
		
		return "1_0_adminLogin";
	}
	
	@GetMapping(value = "/denied")
	public String afficheDeniedPage() {
		return "denied";
	}
	
	@GetMapping(value = "/toLogOut")
	public String seDeconnecter(Model modele) {
		
		// ajouter le message de d�connexion
		modele.addAttribute("msg", "Vous �tes d�connect� !");
		
		return "0_accueilSite";
	}

}
