package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;

import domainKanban.Fiche;
import domainKanban.Section;
import domainKanban.User;
import jpa.EntityManagerHelper;

public class DaoFiches extends GenericDaoJpaImpl<Fiche, Long> {


	// pour faire des insert
	//	EntityManagerHelper.getEntityManager() point d'entree a la base de donnees
	public void saveFiche(Fiche fiche) {
		EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();
		t.begin();
		EntityManagerHelper.getEntityManager().persist(fiche);
		t.commit();
	}
	public List<Fiche> getAllFiches(){
		// un select * en jpa
		String query="select fich from  Fiche as fich  ";
		return EntityManagerHelper.getEntityManager().createQuery(query, Fiche.class).getResultList();

	}
	public Fiche getFicheByID(Long id){
		return EntityManagerHelper.getEntityManager().find(Fiche.class, id);
		
	}
	

	 public List<Fiche> finFicheByUserName(String name) {
	        return EntityManagerHelper.getEntityManager().createNamedQuery("touteslesfichesparnom", Fiche.class)
	                .setParameter("name", name).getResultList();

	    }
	
	 public void deleteFiche(Long id) {
	        EntityManagerHelper.beginTransaction();
	        EntityManagerHelper.getEntityManager().remove(this.getFicheByID(id));
	        EntityManagerHelper.commit();        
	    }

}
