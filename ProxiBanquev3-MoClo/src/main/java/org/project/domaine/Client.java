package org.project.domaine;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idClient;

	private String nom;

	private String prenom;

	@Embedded
	private Adresse adresse;
	private String telephone;
	private String email;
	//
	// @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	// @JoinColumn(name = "idConseiller", unique = true)
	// private Conseiller conseiller;

	// @OneToOne(mappedBy = "client", cascade = { CascadeType.PERSIST,
	// CascadeType.REMOVE })
	// @OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	// @JoinColumn(name = "numCompte")
	// private CompteCourant compteCourant;

	// @OneToOne(mappedBy = "client", cascade = { CascadeType.PERSIST,
	// CascadeType.REMOVE })
	// @OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	// @JoinColumn(name = "numCompte")
	// private CompteEpargne compteEpargne;

	//
	// public Client(int idClient, Adresse adresse, String telephone, String email,
	//// Conseiller conseiller,
	// CompteCourant compteCourant, CompteEpargne compteEpargne) {
	// super();
	// this.idClient = idClient;
	// this.adresse = adresse;
	// this.telephone = telephone;
	// this.email = email;
	// this.conseiller = conseiller;
	// this.compteCourant = compteCourant;
	// this.compteEpargne = compteEpargne;
	// }

	public Client() {

	}

	public Client(String nom, String prenom, Adresse adresse, String telephone, String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// public Conseiller getConseiller() {
	// return conseiller;
	// }
	//
	// public void setConseiller(Conseiller conseiller) {
	// this.conseiller = conseiller;
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

	// public CompteCourant getCompteCourant() {
	// return compteCourant;
	// }
	//
	// public void setCompteCourant(CompteCourant compteCourant) {
	// this.compteCourant = compteCourant;
	// }
	//
	// public CompteEpargne getCompteEpargne() {
	// return compteEpargne;
	// }
	//
	// public void setCompteEpargne(CompteEpargne compteEpargne) {
	// this.compteEpargne = compteEpargne;
	// }

	// public void addCompteCourant(CompteCourant compteCourant) {
	// compteCourant.setClient(this);
	// this.setCompteCourant(compteCourant);
	//
	// }
	//
	// public void addCompteEpargne(CompteEpargne compteEpargne) {
	// compteEpargne.setClient(this);
	// this.setCompteEpargne(compteEpargne);
	// }

}
