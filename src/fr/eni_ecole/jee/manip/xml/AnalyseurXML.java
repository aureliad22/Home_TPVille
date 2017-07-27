/**
 * @author oreade
 * @date 27 juil. 2017
 * @version Home_TPVille V1.0
 */
package fr.eni_ecole.jee.manip.xml;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import fr.eni_ecole.jee.beans.Ville;

/**
 * @author oreade
 * @date 27 juil. 2017
 * @version Home_TPVille V1.0
 */
public class AnalyseurXML extends DefaultHandler {
	private List<Ville> listeVilles;
	private String baliseEnCours;
	private Ville villeEnCoursDeLecture;

	/**
	 * Getter pour listeVilles.
	 * 
	 * @return the listeVilles
	 */
	public List<Ville> getListeVilles() {
		return listeVilles;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.xml.sax.helpers.DefaultHandler#startDocument()
	 */
	@Override
	public void startDocument() throws SAXException {
		this.listeVilles = new ArrayList<>();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String,
	 *      java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		this.baliseEnCours = qName;
		
		if("city".equalsIgnoreCase(qName)){
			this.villeEnCoursDeLecture = new Ville();
			this.villeEnCoursDeLecture.setNom("");		
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String,
	 *      java.lang.String, java.lang.String)
	 */
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		this.baliseEnCours = null;
		if("city".equalsIgnoreCase(qName)){
			this.listeVilles.add(this.villeEnCoursDeLecture);
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
	 */
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if("city".equalsIgnoreCase(baliseEnCours)){
			char[] lectureEnCours = Arrays.copyOfRange(ch, start, start+length);
			this.villeEnCoursDeLecture.setNom(this.villeEnCoursDeLecture.getNom() + new String(lectureEnCours));
		}
	}
}
