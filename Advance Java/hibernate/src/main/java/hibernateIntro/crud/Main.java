package hibernateIntro.crud;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.hibernate.Transaction;

import org.hibernate.Session;

public class Main {
	public static void main(String[] args) {

		Students std = new Students();

		Configuration config = new Configuration();
		config.addAnnotatedClass(hibernateIntro.crud.Students.class);
		config.configure("hibernate.cfg.xml");
//		config.configure(); // if default name hibernate.cjs.xml
		
		SessionFactory sf = config.buildSessionFactory();
		Session ss = sf.openSession();

		Transaction t = ss.beginTransaction();

// 	 1) Reading data
//	    Students st = ss.get(Students.class, 1); // deprecated
//		Student st = ss.load(); // Single row
//		Students st = ss.find(Students.class, 1);
//		System.out.println(st);

// 	 2) Inserting data
//		std.setStId(1);
//		std.setStName("Ajay");
//		std.setStCity("Barshi");
//		
//		ss.save(std); // deprecated
//		ss.persist(std);

//	 3) Updating data  // Requires object finding first
//		std.setStId(1);
//		std.setStCity("Barshi");
//		std.setStName("Ajay");
//		
//		ss.update(std); // deprecated
//		ss.merge(std);
		
//	 4) Deleting data // Requires object finding first
		
//		ss.delete(st); // deprecated
//		ss.remove(st); // requires to insert object
		
//		t.commit();
//		ss.close();
//		sf.close();

	}
}
