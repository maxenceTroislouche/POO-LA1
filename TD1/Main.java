package TD1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Location uneLocalisation = new Location("IG2I", "50.4351° N", "2.8235° E", "Lens", "France");
        Location adelaide = new Location("Adelaide Street TD1.Circuit", "-34.9272", "138.167", "Adelaide", "Australia");
        Location albert_park = new Location("Albert Park Grand Prix TD1.Circuit", "-37.8497", "144.968", "Melbourne", "Australia");
        Location essarts = new Location("Rouen-Les-Essarts", "49.3306", "1.00458", "Rouen", "France");
        Location lemans = new Location("Le Mans", "47.95", "0.224231", "Le mans", "France");

        ArrayList<Location> listeLocalisations = new ArrayList<>();
        listeLocalisations.add(uneLocalisation);
        listeLocalisations.add(adelaide);
        listeLocalisations.add(albert_park);
        listeLocalisations.add(essarts);
        listeLocalisations.add(lemans);

        Circuit adelaideStreetCircuit = new Circuit(adelaide, "adelaide", adelaide.getLocation(), "http://en.wikipedia.org/wiki/Adelaide_Street_Circuit");
        Circuit albertParkGrandPrixCircuit = new Circuit(albert_park, "albert_park", albert_park.getLocation(), "http://en.wikipedia.org/wiki/Melbourne_Grand_Prix_Circuit");
        Circuit RouenLesEssarts = new Circuit(essarts, "essarts", essarts.getLocation(), "http://en.wikipedia.org/wiki/Rouen-Les-Essarts");
        Circuit LeMans = new Circuit(lemans, "lemans", lemans.getLocation(), "http://en.wikipedia.org/wiki/Circuit_de_la_Sarthe#Bugatti_Circuit");
        Circuit IG2I = new Circuit(uneLocalisation, "ig2i", "Grand Prix de l'IG2I", "http://ig2i.fr");

        ArrayList<Circuit> listeCircuits = new ArrayList<>();
        listeCircuits.add(adelaideStreetCircuit);
        listeCircuits.add(albertParkGrandPrixCircuit);
        listeCircuits.add(RouenLesEssarts);
        listeCircuits.add(LeMans);
        listeCircuits.add(IG2I);

        System.out.println(uneLocalisation.toString());
        System.out.println("Number of locations : " + Location.getNbLocations());
        System.out.println(uneLocalisation.estLeSeulEmplacementDeSonPays());
    }
}