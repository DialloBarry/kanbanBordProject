package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;

import domainKanban.Fiche;
import domainKanban.Section;
import domainKanban.User;
import jpa.EntityManagerHelper;
 public class DaoSection extends GenericDaoJpaImpl<Section, Long> {
	Section section = new Section();
	public List<Section> getAllSessions(){
		String query= "select s from Section as s";
		return EntityManagerHelper.getEntityManager().createQuery(query, Section.class).getResultList();
	}
	public void saveSession(Section section) {
		for(Fiche f : section.getFiche()) {
			f.setSection(section);
		}
		EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();
		t.begin();
		EntityManagerHelper.getEntityManager().persist(section);
		t.commit();
	}
	public Section getSectionByID(long id){
		String query="select s from  Section as s where s.id = :id";
		return EntityManagerHelper.getEntityManager().createQuery(query, Section.class).setParameter("id", id).getSingleResult();

		
	}
	
	 public void deleteSection(Long id) {
	        EntityManagerHelper.beginTransaction();
	        EntityManagerHelper.getEntityManager().remove(this.getSectionByID(id));
	        EntityManagerHelper.commit();        
	    }

}
