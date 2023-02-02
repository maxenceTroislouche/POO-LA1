package TP1;

import TP1.Modeles.Circuit;
import TP1.Utilitaires.ApiDataAccess;
import org.json.simple.JSONObject;

public class Main {
    public static void main(String[] args) {
        // Effectue la requête à l'API
        JSONObject obj = ApiDataAccess.requeteObjet("http://ergast.com/api/f1/circuits.json?limit=1000", "GET");

        // Transforme l'objet JSON en circuits
        Circuit.getCircuitsAPI(obj);

        // Affiche la liste de circuits
        System.out.println(Circuit.getLesCircuitsAPI());
    }
}