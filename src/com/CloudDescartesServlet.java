package com;

import java.io.IOException;

import javax.servlet.http.*;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Transaction;

@SuppressWarnings("serial")
public class CloudDescartesServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		DatastoreService dataStore = DatastoreServiceFactory.getDatastoreService();
		
		Entity etudiant = new Entity("Etudiant");
		etudiant.setProperty("nom", "Tintin");
		etudiant.setProperty("age", 20);
		
		Transaction tx = dataStore.beginTransaction();
	
		dataStore.put(etudiant);
	
		tx.commit();
		
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
	public void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
}
