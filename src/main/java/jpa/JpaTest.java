package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class JpaTest {
	
	public JpaTest(EntityManager manager) {
		
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		EntityManagerFactory factory =   
//	 			 Persistence.createEntityManagerFactory("example");
//			EntityManager managers = factory.createEntityManager();
//			JpaTest test = new JpaTest(managers);

		EntityManager manager = EntityManagerHelper.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();


		try {
//			User user= new User();
//			user.setName("Diallo");
//			Tache coder= new Tache();
//			coder.setUer(user);
//			List<Tache> tache= new ArrayList<Tache>();
//			
//			tache.add(coder);
//			user.setTache(tache);
//			manager.persist(tache);
//			manager.persist(user);
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();


		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		//		factory.close();
	}


}
