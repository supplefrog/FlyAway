package com.FlyAway.config;

import java.util.Properties;

import com.FlyAway.entities.Admin;
import com.FlyAway.entities.Airline;
import com.FlyAway.entities.Booking;
import com.FlyAway.entities.Flight;
import com.FlyAway.entities.Payment;
import com.FlyAway.entities.Place;
import com.FlyAway.entities.User;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

public class HibConfig {

	public static SessionFactory getSessionFactory() {

		Configuration configuration = new Configuration();
		Properties properties = new Properties();
		// Data source properties
		properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		properties.put(Environment.URL, "jdbc:mysql://localhost:3306/flyawaydb");
		properties.put(Environment.USER, "root");
		properties.put(Environment.PASS, "root");
		// Hibernate properties
		properties.put(Environment.SHOW_SQL, "true");
		properties.put(Environment.HBM2DDL_AUTO, "update");
		properties.put(Environment.FORMAT_SQL, true);
		configuration.setProperties(properties);
		configuration.addAnnotatedClass(Admin.class);
		configuration.addAnnotatedClass(Airline.class);
		configuration.addAnnotatedClass(Booking.class);
		configuration.addAnnotatedClass(Flight.class);
		configuration.addAnnotatedClass(Payment.class);
		configuration.addAnnotatedClass(Place.class);
		configuration.addAnnotatedClass(User.class);
		SessionFactory factory = configuration.buildSessionFactory();
		return factory;

	}
}