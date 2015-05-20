package model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the activite database table.
 * 
 */
@Entity
@NamedQuery(name="Activite.findAll", query="SELECT a FROM Activite a")
public class Activite implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ActivitePK id;

	private int nbloc;

	//bi-directional many-to-one association to Sejour
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="NumSej")
	private Sejour sejour;

	//bi-directional many-to-one association to Sport
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CodeSport")
	private Sport sport;

	public Activite() {
	}

	public ActivitePK getId() {
		return this.id;
	}

	public void setId(ActivitePK id) {
		this.id = id;
	}

	public int getNbloc() {
		return this.nbloc;
	}

	public void setNbloc(int nbloc) {
		this.nbloc = nbloc;
	}

	public Sejour getSejour() {
		return this.sejour;
	}

	public void setSejour(Sejour sejour) {
		this.sejour = sejour;
	}

	public Sport getSport() {
		return this.sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

}