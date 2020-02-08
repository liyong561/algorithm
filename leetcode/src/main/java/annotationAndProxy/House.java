package annotationAndProxy;

public class House {
    String id;
    String location;
    Renter renter;

    public House(String id, String location, Renter renter) {
        this.id = id;
        this.location = location;
        this.renter = renter;
    }
}
