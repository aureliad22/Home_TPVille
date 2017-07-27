/**
 * @author oreade
 * @date 27 juil. 2017
 * @version Home_TPVille V1.0
 */
package fr.eni_ecole.jee.manip.xml;

import java.io.StringReader;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.helpers.DefaultHandler;

import NET.webserviceX.www.GlobalWeatherSoapProxy;
import fr.eni_ecole.jee.beans.Ville;

/**
 * @author oreade
 * @date 27 juil. 2017
 * @version Home_TPVille V1.0
 */
public class TraiterXML {

	public List<Ville> listerFromXml(String paysChoisi) {
		
		List<Ville> listeVillesFromXml = null;
		AnalyseurXML monAnalyseur;
		SAXParserFactory fabrique=SAXParserFactory.newInstance(); 
		
		try{
			SAXParser analyseurSAX=fabrique.newSAXParser(); 
			monAnalyseur=new AnalyseurXML(); 
			GlobalWeatherSoapProxy meteo = new GlobalWeatherSoapProxy();
			analyseurSAX.parse(new InputSource(new StringReader(meteo.getCitiesByCountry(paysChoisi)))			
								, (DefaultHandler)monAnalyseur);
			listeVillesFromXml = monAnalyseur.getListeVilles();
			
		}catch(Exception e){ 
			e.printStackTrace();
		}
		return listeVillesFromXml;
	}

}
