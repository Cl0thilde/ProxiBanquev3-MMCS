package org.projet.domaine;

import javax.persistence.Embeddable;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Inheritance;
//import javax.persistence.InheritanceType;

//@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Embeddable
public class Personne {
	// @Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	// private int idPersonne;
	private String nom;
	private String prenom;

	public Personne() {

	}

	public Personne(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	// public Personne(int idPersonne, String nom, String prenom) {
	// super();
	// this.idPersonne = idPersonne;
	// this.nom = nom;
	// this.prenom = prenom;
	// }

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + "]";
	}

	// public int getIdPersonne() {
	// return idPersonne;
	// }
	//
	// public void setIdPersonne(int idPersonne) {
	// this.idPersonne = idPersonne;
	// }

}
