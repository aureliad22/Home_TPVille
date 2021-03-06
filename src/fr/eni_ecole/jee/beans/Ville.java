/**
 * @author oreade
 * @date 27 juil. 2017
 * @version Home_TPVille V1.0
 */
package fr.eni_ecole.jee.beans;

import java.io.Serializable;

/**
 * @author oreade
 * @date 27 juil. 2017
 * @version Home_TPVille V1.0
 */
public class Ville implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nom;
	private String pays;

	/**
	 * Constructeur.
	 */
	public Ville() {
		super();
	}

	/**
	 * Getter pour nom.
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter pour nom.
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter pour pays.
	 * @return the pays
	 */
	public String getPays() {
		return pays;
	}

	/**
	 * Setter pour pays.
	 * @param pays the pays to set
	 */
	public void setPays(String pays) {
		this.pays = pays;
	}
}
