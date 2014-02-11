/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wkhim.gsb_android.modele;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author wkhim
 */
public class DAO {

    public static List<String> getLesDeps() {
        List<String> lesDeps = new ArrayList<String>();
        String url = "http://gaemedecins.appspot.com/Controleur/medParDep/listeDep";
        try {
            URL myURL;
            myURL = new URL(url);
            Document doc;
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db;
            db = dbf.newDocumentBuilder();
            doc = db.parse(myURL.openStream());
            org.w3c.dom.Element racine = doc.getDocumentElement();
            NodeList listeDep = racine.getElementsByTagName("Departement");
            for (int i = 0; i < listeDep.getLength(); i++) {
                Node unDep = listeDep.item(i);
                NodeList lesProprietes = unDep.getChildNodes();
                for (int j = 0; j < lesProprietes.getLength(); j++) {
                    if (lesProprietes.item(j).getNodeName().equals("num")) {
                        lesDeps.add(lesProprietes.item(j).getTextContent().trim());
                        break;
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesDeps;
    }

    public static List<String> getLesMedsParDep(String Dep) {
        List<String> lesMeds = new ArrayList<String>();
        String url = "http://gaemedecins.appspot.com/Controleur/medParDep/listeMed/" + Dep;
        try {
            URL myURL;
            myURL = new URL(url);
            Document doc;
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db;
            db = dbf.newDocumentBuilder();
            doc = db.parse(myURL.openStream());
            org.w3c.dom.Element racine = doc.getDocumentElement();
            NodeList listeMed = racine.getElementsByTagName("Medecin");
            for (int i = 0; i < listeMed.getLength(); i++) {
                Node medecin = listeMed.item(i);
                NodeList lesProprietes = medecin.getChildNodes();
                for (int j = 0; j < lesProprietes.getLength(); j++) {
                    if (lesProprietes.item(j).getNodeName().equals("nom")) {
                        lesMeds.add(lesProprietes.item(j).getTextContent().trim());
                        break;
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesMeds;
    }
}
