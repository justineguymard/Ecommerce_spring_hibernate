package fr.adaming.dao;

import java.util.List;

import fr.adaming.entities.Commande;

public interface ICommandeDao {
	
	public List<Commande> getAllCommandes ();
	
	public Commande addCommande (Commande commandeIn);
	
	public Commande updateCommande (Commande commandeIn);
	
	public Commande deleteCommande (Commande commandeIn);
	
	public Commande searchCommandeByID (Commande commandeIn);
	
	public List<Commande> searchCommandeByDate (Commande commandeIn);
	
	public Commande searchCommandeByID(int id);
	
	
	

}
