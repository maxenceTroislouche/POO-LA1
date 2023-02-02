package TP1.Utilitaires;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;

public class ApiDataAccess {
    public static JSONObject requeteObjet(String url, String methode) {
        try {
            HashSet<String> methodePossibles = new HashSet<>();
            methodePossibles.add("GET");
            methodePossibles.add("POST");
            methodePossibles.add("DELETE");
            methodePossibles.add("PUT");

            if (!methodePossibles.contains(methode)) {
                System.err.println("requeteObjet : la méthode passée en paramètre ne correspond pas à une méthode HTTP (GET, POST, PUT, DELETE)");
                return null;
            }

            // Création de l'objet url, à partir de la string passée en paramètre
            URL urlObject = new URL(url);

            HttpURLConnection httpConnection = (HttpURLConnection) urlObject.openConnection();
            httpConnection.setRequestMethod(methode);

            // Gestion erreurs lors de la requête
            if (httpConnection.getResponseCode() != 200) {
                System.err.println("requeteObjet : la requête a échoué !");
                System.err.println(httpConnection.getResponseMessage());
            } else {
                BufferedReader br = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
                String strCurrentLine;
                String stringResponse = "";
                while ((strCurrentLine = br.readLine()) != null) {
                    stringResponse += strCurrentLine;
                }
                br.close();
                httpConnection.disconnect();
                JSONParser parser = new JSONParser();
                return (JSONObject) parser.parse(stringResponse);
            }
        } catch (MalformedURLException e) {
            System.err.println("requeteObjet : l'url n'a pas le bon format !");
            return null;
        } catch (IOException e) {
            System.err.println("requeteObjet : la connexion HTTP a échoué !");
            throw new RuntimeException(e);
        } catch (ParseException e) {
            System.err.println("requeteObjet : Erreur lors du parsing en JSON de la réponse");
            throw new RuntimeException(e);
        }
        return null;
    }
}
