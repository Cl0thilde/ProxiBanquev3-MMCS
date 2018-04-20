package org.project.service;

import org.project.domaine.CompteCourant;

/**
 * @author Morane & Clothilde
 *
 */

public interface ProxiBanqueSI {

	public void virementCompteACompte(CompteCourant c1, CompteCourant c2);

	public double simulationCredit(double montantEmprunt, int dureeMois, double tauxInteret);
}
