package com.springboot.demo.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


@Configuration
public class HibernateUtilConfig {
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Bean
	public SessionFactory getSessionFactory() {
		if (entityManagerFactory.unwrap(SessionFactory.class) ==null) {
			throw new NullPointerException("factory is not a hibernate factory");
		}
		return entityManagerFactory.unwrap(SessionFactory.class);
	}
	}


