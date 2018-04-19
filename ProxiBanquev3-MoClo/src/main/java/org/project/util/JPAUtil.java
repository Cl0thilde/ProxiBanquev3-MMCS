package org.project.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	public final static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("my-pu");
}
