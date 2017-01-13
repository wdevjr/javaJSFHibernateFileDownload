package br.com.warhjr.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

	private static SessionFactory factory;
	
	static {
		Configuration configuration = new AnnotationConfiguration();
		configuration.configure();
		
		factory = configuration.buildSessionFactory();
	}
	
	public static Session getSession() {
		return factory.openSession();
	}
}
