package fr.adaming.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.entities.Admin;

@Repository
public class AdminDaoImpl implements IAdminDao {

	// Declaration d'un attribut SessionFactory
	private SessionFactory sf;

	// le setter pour l'injection de dependance
	@Autowired
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Transactional(readOnly = true)

	@Override
	public Admin getAdminByMail(String mail) {
		
		// recuperer la session de hibernate
		Session s = sf.getCurrentSession();

		// Construire la requete HQL
		String req = "FROM Admin a WHERE a.mail=:pMail";

		// Creation d'un objet de type Query afin d'envoyer la requete HQL
		Query query = s.createQuery(req);

		// passage des params
		query.setParameter("pMail", mail);

		return (Admin) query.uniqueResult();
	}

}
