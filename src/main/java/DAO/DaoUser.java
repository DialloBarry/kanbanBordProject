package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;

import domainKanban.Fiche;
import domainKanban.User;
import jpa.EntityManagerHelper;

public class DaoUser extends GenericDaoJpaImpl<User, Long> {
	public List<User> getAllUser(){
		String query="select u from User as u";
		return EntityManagerHelper.getEntityManager().createQuery(query, User.class).getResultList();
		
	}
	
	public User getUserByID(long id){
		String query="select u from User as u where u.id = :id";
		return EntityManagerHelper.getEntityManager().createQuery(query, User.class).setParameter("id", id).getSingleResult();
		
	}
	
	
	
	public void saveUser(User user) {
		for(Fiche f : user.getFiche()) {
			f.setUser(user);
		}
		EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();
		t.begin();
		EntityManagerHelper.getEntityManager().persist(user);
		t.commit();
	}
	
	 public void deleteUser(Long id) {
	        EntityManagerHelper.beginTransaction();
	        EntityManagerHelper.getEntityManager().remove(this.getUserByID(id));
	        EntityManagerHelper.commit();        
	    }


}
