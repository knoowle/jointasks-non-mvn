package com.jointasks.tests;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jointasks.model.Account;
import com.jointasks.util.HibernateUtil;

public class HibernateTest {
	
	private static SessionFactory sessionFactory;
	
	@BeforeClass
	public static void init() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	@AfterClass
	public static void destory() {
		sessionFactory.close();
	}
	
	@Test
	public void testAddAccount() {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Account a = new Account();
		session.save(a);
		transaction.commit();
	}
}
