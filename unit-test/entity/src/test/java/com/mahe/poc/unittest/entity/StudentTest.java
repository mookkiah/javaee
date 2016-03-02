package com.mahe.poc.unittest.entity;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentTest {

	
	static String persistenceUnit = "UnitTestEntity-Persistence";
	
	private static EntityManagerFactory mEmf;
	/** The entity manager that persists and queries the DB. */
	private static EntityManager mEntityManager;

	@BeforeClass
	public static void initTestFixture() throws Exception {
	    // Get the entity manager for the tests.
	    mEmf = Persistence.createEntityManagerFactory(persistenceUnit);
	    mEntityManager = mEmf.createEntityManager();
	}

	 /**
	 * Cleans up the session.
	 */
	@AfterClass
	public static void closeTestFixture() {
	    mEntityManager.close();
	    mEmf.close();
	}
	
	@Test
	public void test1_Save(){
		Student student = new Student();
		student.setFirstName("Mahendran");
		student.setLastName("Mookkiah");
		student.setBirthDate(new Date());
		
		EntityTransaction trx = mEntityManager.getTransaction();

		   //Start the transaction
		   trx.begin();
		   //Persist the object in the DB
		   mEntityManager.merge(student);
		   //Commit and end the transaction
		   trx.commit();
	}
	
	@Test
	public void test2_Read(){
	    
	    Student student = mEntityManager.createQuery("FROM Student S WHERE S.firstName LIKE :studentFirstName", Student.class)
				.setParameter("studentFirstName", "Mahendran")
		        .getResultList().get(0);
		Assert.assertTrue("Mookkiah".equals(student.getLastName()));
	}
	
	@Test
	public void test3_Delete(){
	    
	    Student student = mEntityManager.createQuery("FROM Student S WHERE S.firstName LIKE :studentFirstName", Student.class)
				.setParameter("studentFirstName", "Mahendran")
		        .getResultList().get(0);
	    
	    EntityTransaction trx = mEntityManager.getTransaction();

		   //Start the transaction
		   trx.begin();
		   //Persist the object in the DB
		   mEntityManager.remove(student);
		   //Commit and end the transaction
		   trx.commit();
	}
}
