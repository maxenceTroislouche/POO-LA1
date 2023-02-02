package TP1.Utilitaires;

import TP1.Modeles.Circuit;
import TP1.Modeles.Location;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class JSONUtil {
    public static <T> List<T> lectureFichierJSON(String nomFichier, Class<T> classe) {
        try {
            // On récupère l'objet contenu dans le fichier JSON
            String jsonContent = Files.readString(Path.of(nomFichier));
            JSONParser parser = new JSONParser();
            JSONObject obj = (JSONObject) parser.parse(jsonContent);

            // Action à faire selon la classe passée en paramètre
            switch (classe.getSimpleName()) {
                case "Circuit":
                    // Nos objets sont dans l'array qui a pour clé : CircuitTable
                    JSONObject MRData = (JSONObject) obj.get("MRData");
                    JSONObject circuitTable = (JSONObject) MRData.get("CircuitTable");
                    JSONArray circuits = (JSONArray) circuitTable.get("Circuits");
                    List<Circuit> listeCircuits = new ArrayList<>();

                    // On parcours l'array
                    for (Object c : circuits) {
                        JSONObject circuitObj = (JSONObject) c;
                        JSONObject locationObj = (JSONObject) circuitObj.get("Location");

                        // Création d'une location
                        Location location = new Location(
                                (String) circuitObj.get("circuitName"),
                                (String) locationObj.get("lat"),
                                (String) locationObj.get("long"),
                                (String) locationObj.get("locality"),
                                (String) locationObj.get("country")
                        );
                        // Création d'un circuit
                        listeCircuits.add(new Circuit(
                                (String) circuitObj.get("circuitId"),
                                (String) circuitObj.get("circuitName"),
                                (String) circuitObj.get("url"),
                                location
                        ));
                    }
                    // On retourne la liste
                    return (List<T>) listeCircuits;
                default: break;
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}