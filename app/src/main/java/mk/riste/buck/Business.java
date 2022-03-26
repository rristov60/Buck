package mk.riste.buck;

public class Business {
    String name;
    String address;
    double latitude;
    double longitude;
    String eMail;
    String telephone;
    String webSite;
    Category category;
    int image;


    public Business(String name, String address, double latitude, double longitude,
                    String eMail, String telephone, String webSite, Category category,
                    int image) {
        this.name = name;
        this.address = address;
        this.latitude = latitude;
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

    public Category getCategory() {
        return category;
    }

    public int getImage() {
        return image;
    }
}

 enum Category{
    Industry,
     Fun,
    Education,
    Services
}