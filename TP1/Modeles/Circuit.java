package TP1.Modeles;

import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Circuit implements Comparable<Circuit> {
    private static ArrayList<Circuit> lesCircuitsAPI;
    private Location location;
    private String circuitId;
    private String circuitName;
    private String url;

    public Circuit(String url, String circuitId, String circuitName, Location location) {
        this.location = location;
        this.circuitId = circuitId;
        this.circuitName = circuitName;
        this.url = url;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public static void getCircuitsAPI(JSONObject jsonObject) {
        lesCircuitsAPI = new ArrayList<>();

        // Nos objets sont dans l'array qui a pour clé : CircuitTable
        JSONObject MRData = (JSONObject) jsonObject.get("MRData");
        JSONObject circuitTable = (JSONObject) MRData.get("CircuitTable");
        JSONArray circuits = (JSONArray) circuitTable.get("Circuits");
        Gson gson = new Gson();

        // On parcourt l'array
        for (Object c : circuits) {
            JSONObject circuitObj = (JSONObject) c;
            JSONObject locationObj = (JSONObject) circuitObj.get("Location");
            Location location = gson.fromJson(String.valueOf(locationObj), Location.class);
            Circuit circuit = gson.fromJson(String.valueOf(circuitObj), Circuit.class);
            circuit.setLocation(location);
            lesCircuitsAPI.add(circuit);
        }
        // On trie la liste avec comme méthode : compareTo
        lesCircuitsAPI.sort(Circuit::compareTo);
    }

    public static ArrayList<Circuit> getLesCircuitsAPI() {
        return new ArrayList<>(lesCircuitsAPI);
    }

    @Override
    public String toString() {
        return "Circuit{" +
                "location=" + location.toString() +
                ", circuitId='" + circuitId + '\'' +
                ", circuitName='" + circuitName + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    @Override
    public int compareTo(Circuit o) {
        return location.getPays().compareTo(o.location.getPays());
    }
}
