package fr.adaming.dao;

import java.util.List;

import fr.adaming.entities.Client;


public interface IClientDao {
	
	public List<Client> getAllClients ();
	
	public Client addClient (Client clientIn);
	
	public Client updateClient (Client clientIn);
	
	public Client deleteClient (Client clientIn);
	
	public Client searchClientByID (Client clientIn);
	
	public List<Client> searchClientByNom (Client clientIn);
	

}
