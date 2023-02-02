package TD2.Modeles;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Objects;

public class Location implements InformationGenerale {
    private String location;
    @SerializedName(value="lat")
    private String latitude;
    @SerializedName(value="long")
    private String longitude;
    @SerializedName(value="locality")
    private String ville;
    @SerializedName(value="country")
    private String pays;
    private static int nbLocations = 0;

    private static final HashMap<String, Integer> nbLocationsParPays = new HashMap<>();

    public Location(String location, String latitude, String longitude, String ville, String pays) {
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.ville = ville;
        this.pays = pays;
        nbLocations++;
        nbLocationsParPays.merge(this.pays, 1, Integer::sum);
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public static int getNbLocations() {
        return nbLocations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location1 = (Location) o;
        return Objects.equals(location, location1.location) && Objects.equals(latitude, location1.latitude) && Objects.equals(longitude, location1.longitude) && Objects.equals(ville, location1.ville) && Objects.equals(pays, location1.pays);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, latitude, longitude, ville, pays);
    }

    @Override
    public String toString() {
        return "TD1.Location{" +
                "location='" + location + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", ville='" + ville + '\'' +
                ", pays='" + pays + '\'' +
                '}';
    }

    @Override
    public boolean estLeSeulEmplacementDeSonPays() {
        return nbLocationsParPays.get(this.pays) == 1;
    }
}
