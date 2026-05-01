package hibernateIntro.intro;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.hibernate.Transaction;

import org.hibernate.Session;


public class Main {
	public static void main(String[] args) {
		
		Students std = new Students();
		
		std.setStdId(1);
		std.setCity("Pune");
		std.setName("Ajay");
		
		Configuration config = new Configuration();
		config.addAnnotatedClass(hibernateIntro.intro.Students.class);
		config.configure("hibernate.cfg.xml");
		
		SessionFactory sf = config.buildSessionFactory();
		Session ss = sf.openSession();
		
		Transaction t =  ss.beginTransaction();
		
		ss.persist(std);
		t.commit();
		ss.close();
		sf.close();
		
		}
}
