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
public class Pays implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nom;

	/**
	 * Constructeur.
	 */
	public Pays() {
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
}
