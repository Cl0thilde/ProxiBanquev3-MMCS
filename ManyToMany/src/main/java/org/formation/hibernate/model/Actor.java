package org.formation.hibernate.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Actor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idActor;
	private String name;

	@ManyToMany(mappedBy = "actors")
	private Set<Movie> movies = new HashSet<>();

	public Actor() {

	}

	public Actor(String name) {
		super();
		this.name = name;
	}

	public int getIdActor() {
		return idActor;
	}

	public void setIdActor(int idActor) {
		this.idActor = idActor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Movie> getMovies() {
		return movies;
	}

	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}

	@Override
	public String toString() {
		return "Actor [idActor=" + idActor + ", name=" + name + "]";
	}

	public void addMovie(Movie movie) {
		movies.add(movie);
		movie.getActors().add(this);
	}

	public void removeMovie(Movie movie) {
		movies.remove(movie);
		movie.getActors().remove(this);
	}
}
