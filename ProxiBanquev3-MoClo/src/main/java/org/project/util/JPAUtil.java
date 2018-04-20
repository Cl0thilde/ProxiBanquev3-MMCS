package org.project.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Morane & Clothilde
 *
 */

/**
 * Classe utilitaire permettant de créer l'EntityManagerFactory utilisable dans
 * toutes les autres classes
 *
 */
public class JPAUtil {
	public final static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("my-pu");
}
