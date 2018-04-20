package org.project.domaine;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Classe abstraite Compte avec les attributs numCompte, solde, dateOuverture.
 * 
 * @author Clothilde et Morane
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Compte {

	/**
	 * id d'un Compte est numCompte
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int numCompte;

	private double solde;

	/**
	 * La table compte relier à la table client par un OneToOne
	 */
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "idClient")
	private Client client;

	private Date dateOuverture;

	public Compte(double solde, Date dateOuverture) {
		this.solde = solde;
		this.dateOuverture = dateOuverture;
	}

	public Compte(double solde) {
		super();
		this.solde = solde;
	}

	public Compte() {
	}

	public int getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Date getDateOuverture() {
		return dateOuverture;
	}

	public void setDateOuverture(Date dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Compte [numCompte=" + numCompte + ", solde=" + solde + ", dateOuverture=" + dateOuverture + "]";
	}

}
