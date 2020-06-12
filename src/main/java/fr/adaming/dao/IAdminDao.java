package fr.adaming.dao;

import fr.adaming.entities.Admin;

public interface IAdminDao {
	
	public Admin getAdminByMail(String mail);

}
