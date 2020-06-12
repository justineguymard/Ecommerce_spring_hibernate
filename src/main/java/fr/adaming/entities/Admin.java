package fr.adaming.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "admins")
public class Admin implements Serializable {

	// attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_admin")
	private int id;
	private String mail;
	private String mdp;
	private int active;
	
	// asso uml en java
	@OneToMany(mappedBy="admin")
	private List<Role> listeRoles;

	// constructeur
	public Admin() {
		super();
	}

	public Admin(String mail, String mdp) {
		super();
		this.mail = mail;
		this.mdp = mdp;
	}

	public Admin(int id, String mail, String mdp) {
		super();
		this.id = id;
		this.mail = mail;
		this.mdp = mdp;
	}

	// getter et setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public List<Role> getListeRoles() {
		return listeRoles;
	}

	public void setListeRoles(List<Role> listeRoles) {
		this.listeRoles = listeRoles;
	}

	// redef
	@Override
	public String toString() {
		return "Admin [id=" + id + ", mail=" + mail + ", mdp=" + mdp + ", active=" + active + "]";
	}

}
