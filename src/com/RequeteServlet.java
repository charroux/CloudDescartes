package com;

import java.io.IOException;

import javax.servlet.http.*;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.appengine.api.datastore.Query.FilterOperator;

@SuppressWarnings("serial")
public class RequeteServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		DatastoreService dataStore = DatastoreServiceFactory.getDatastoreService();
	
		Filter propertyFilter =  new FilterPredicate("age", FilterOperator.GREATER_THAN_OR_EQUAL, 20		);
		Query query = new Query("Etudiant").setFilter(propertyFilter);
		
		PreparedQuery pq = dataStore.prepare(query);
		for (Entity result : pq.asIterable()) {
				System.out.println(result.getProperty("nom"));
		}
	}
	
}
