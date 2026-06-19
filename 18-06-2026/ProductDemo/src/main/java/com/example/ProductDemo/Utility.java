package com.example.ProductDemo;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class Utility {
	private static SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Product.class).buildSessionFactory();
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public static void closeSessionFactory() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}
}