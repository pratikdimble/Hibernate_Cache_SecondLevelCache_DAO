package com.pratik.DAO;


import org.hibernate.Session;

import com.pratik.domain.product;
import com.pratik.utility.HibernateUtil;

public class DAO_IMPL implements DAO_Interface {

@Override
public void list() {
	Session ses=null;
	//get the session
	ses=HibernateUtil.getSession();

	System.out.println("\n\t***gets from Database software and keeps in cache***\n");
	product p=ses.get(product.class,11);
	System.out.println(p);
	System.out.println("\n\t***gets from cache***\n");
	product p1=ses.get(product.class,11);
	System.out.println(p1);
	//remove from cache
	ses.clear();
	System.out.println("\n\t***Removing from cache...Wait-->>>***\n");	
	try {
		Thread.sleep(5000);
	}catch (Exception e) {
		e.printStackTrace();
	}

	System.out.println("\n\t***Again gets from Database software and keeps in cache***\n");
	product p2=ses.get(product.class,11);
	System.out.println(p2);
	
	//close the session
	HibernateUtil.closeSession(ses);
	
	
	//return list;
}
	
	
}//class close
