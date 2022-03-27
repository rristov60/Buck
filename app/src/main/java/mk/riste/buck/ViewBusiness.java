package mk.riste.buck;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewBusiness extends AppCompatActivity {
    String name;
    String address;
    String description;
    double latitude;
    double longitude;
    String eMail;
    String telephone;
    String webSite;
    int image;

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
}