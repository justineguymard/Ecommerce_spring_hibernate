package fr.adaming.service;

import fr.adaming.entities.Admin;

public interface IAdminService {
	
	public Admin getAdminByMail(String mail);

}
