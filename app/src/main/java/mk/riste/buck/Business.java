package mk.riste.buck;

public class Business {
    String name;
    String address;
    String description;
    double latitude;
    double longitude;
    String eMail;
    String telephone;
    String webSite;
    String category;
    int image;


    public Business(String name, String address, String description, double latitude, double longitude,
                    String eMail, String telephone, String webSite, String category,
                    int image) {
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.description = description;
        this.longitude = longitude;
        this.eMail = eMail;
        this.telephone = telephone;
        this.webSite = webSite;
        this.category = category;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String geteMail() {
        return eMail;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getWebSite() {
        return webSite;
    }

    public String getCategory() {
        return category;
    }

    public int getImage() {
        return image;
    }

    public String getDescription() { return description; }
}

 enum Category{
    Industry,
     Fun,
    Education,
    Services
}