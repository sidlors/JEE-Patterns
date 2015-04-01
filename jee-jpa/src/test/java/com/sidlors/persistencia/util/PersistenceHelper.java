package com.sidlors.persistencia.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.eclipse.persistence.internal.jpa.EntityManagerFactoryImpl;
import org.eclipse.persistence.internal.sessions.DatabaseSessionImpl;
import org.eclipse.persistence.sessions.Session;

public class PersistenceHelper {
	
    private static  EntityManager entityManager=null;
    
    static {
    	entityManager= Persistence.createEntityManagerFactory("jpaTest").
            createEntityManager();
    }
    
    public static EntityManager getEntityManager() { 
        return entityManager ;
    }
    
    
    public static void clearDatabase() {
    	
    }
}