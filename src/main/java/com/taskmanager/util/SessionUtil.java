package com.taskmanager.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * util class to give session 
 * @author sunny
 *
 */
public class SessionUtil {

	@SuppressWarnings("deprecation")
	public static Session getSession() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		return session;
	}
	
}
