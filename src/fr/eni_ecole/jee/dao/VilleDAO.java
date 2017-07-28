/**
 * @author oreade
 * @date 27 juil. 2017
 * @version Home_TPVille V1.0
 */
package fr.eni_ecole.jee.dao;

import java.io.StringReader;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.helpers.DefaultHandler;

import NET.webserviceX.www.GlobalWeatherSoap;
import NET.webserviceX.www.GlobalWeatherSoapProxy;
import fr.eni_ecole.jee.beans.Ville;

/**
 * @author oreade
 * @date 27 juil. 2017
 * @version Home_TPVille V1.0
 */
public class VilleDAO {

	public List<Ville> listerFromXml(String country) throws Exception {
		
		List<Ville> listeVillesFromXml = null;
		AnalyseurXML monAnalyseur;
		SAXParserFactory fabrique = SAXParserFactory.newInstance(); 
		
		try{
			SAXParser analyseurSAX=fabrique.newSAXParser(); 
			monAnalyseur = new AnalyseurXML(); 
			GlobalWeatherSoap meteo = new GlobalWeatherSoapProxy();
			String contenuXml = meteo.getCitiesByCountry(country);
			analyseurSAX.parse(new InputSource(new StringReader(contenuXml))			
								, (DefaultHandler)monAnalyseur);
			listeVillesFromXml = monAnalyseur.getListeVilles();
			
		}catch(Exception e){ 
			throw new Exception("Les villes sont inaccessibles actuellement.");		
		}
		return listeVillesFromXml;
	}

}
