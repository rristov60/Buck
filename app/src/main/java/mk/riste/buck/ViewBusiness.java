package mk.riste.buck;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class ViewBusiness extends AppCompatActivity implements LocationListener {
    String name;
    String address;
    String description;
    double latitude;
    double longitude;
    String eMail;
    String telephone;
    String webSite;
    int image;
    String provider = "myLocation";
    LocationManager locationManager;
    TextView businessName;
    TextView businessAddress;
    TextView businessDescription;
    TextView businessTelephone;
    TextView businessEmail;
    ImageView businessLogo;
    Button viewOnGoogleMaps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_business);

        businessName = findViewById(R.id.textViewBusinessName);
        businessAddress = findViewById(R.id.textViewBusinessAddress);
        businessDescription = findViewById(R.id.textViewBusinessDescription);
        businessTelephone = findViewById(R.id.textViewBusinessTelephone);
        businessEmail = findViewById(R.id.textViewBusinessEmail);
        businessLogo = findViewById(R.id.imageViewBusinessLogo);
        viewOnGoogleMaps = findViewById(R.id.btnViewOnGoogleMaps);

        LocationManager service = (LocationManager) getSystemService(LOCATION_SERVICE);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);



        Bundle b = getIntent().getExtras();
        name = b.getString("name");
        address = b.getString("address");
        latitude = b.getDouble("latitude");
        longitude = b.getDouble("longitude");
        eMail = b.getString("eMail");
        telephone = b.getString("telephone");
        webSite = b.getString("webSite");
        image = b.getInt("image"); // this might be changed to string later, we will see
        description = b.getString("description");

        businessName.setText(name);
        businessAddress.setText(address);
        businessDescription.setText(description);
        businessTelephone.setText(telephone);
        businessEmail.setText(eMail);
        businessLogo.setImageResource(image);

        viewOnGoogleMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String coordinates = latitude + "," + longitude;
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:" + coordinates + "?q=" + coordinates));
                startActivity(intent);
            }
        });

    }

    @Override
    public void onLocationChanged(Location currentLocation) {
        Location businessLocation = new Location(name);
        businessLocation.setLatitude(latitude);
        businessLocation.setLongitude(longitude);
        double distance = currentLocation.distanceTo(businessLocation);

        if(distance <= 50) {
            Toast.makeText(getApplicationContext(),
                    "You are within 50 meters of this business location",
                    Toast.LENGTH_LONG).show();
        }
    }
}