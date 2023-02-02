package TD1;

public class Circuit {
    private Location location;
    private String circuitId;
    private String circuitName;
    private String url;

    public Circuit(Location location, String circuitId, String circuitName, String url) {
        this.location = location;
        this.circuitId = circuitId;
        this.circuitName = circuitName;
        this.url = url;
    }
}
