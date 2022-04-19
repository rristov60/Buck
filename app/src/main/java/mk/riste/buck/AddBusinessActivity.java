package mk.riste.buck;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class AddBusinessActivity extends AppCompatActivity {
    View saveButtonView;
    AutoCompleteTextView categoryDropDown;
    TextInputEditText businessName;
    TextInputEditText businessAddress;
    TextInputEditText businessLatitude;
    TextInputEditText businessLongitude;
    TextInputEditText businessEmail;
    TextInputEditText businessTelephone;
    TextInputEditText businessWebsite;
    TextInputEditText businessDescription;

    String[] categories = {
            "Services",
            "Fun",
            "Industry",
            "Education"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_business);
        categoryDropDown = findViewById(R.id.autoCompleteTextCategory);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, categories);
        categoryDropDown.setAdapter(adapter);
        saveButtonView = findViewById(R.id.saveButton);

        businessName = findViewById(R.id.textInputEditTextName);
        businessAddress = findViewById(R.id.textInputEditTextAddress);
        businessLatitude = findViewById(R.id.textInputEditTextLatitude);
        businessLongitude = findViewById(R.id.textInputEditTextLongitude);
        businessEmail = findViewById(R.id.textInputEditTextEMail);
        businessTelephone = findViewById(R.id.textInputEditTextTelephone);
        businessWebsite = findViewById(R.id.textInputEditTextWebsite);
        businessDescription = findViewById(R.id.textInputEditTextDescription);

        saveButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                if( TextUtils.isEmpty(businessName.getText().toString())
                        || TextUtils.isEmpty(businessAddress.getText().toString())
                        || TextUtils.isEmpty(businessAddress.getText().toString())
                        || TextUtils.isEmpty(businessLatitude.getText().toString())
                        || TextUtils.isEmpty(businessLongitude.getText().toString())
                        || TextUtils.isEmpty(businessEmail.getText().toString())
                        || TextUtils.isEmpty(businessTelephone.getText().toString())
                        || TextUtils.isEmpty(businessWebsite.getText().toString())
                        || TextUtils.isEmpty(businessDescription.getText().toString())
                )
                {
                    Toast.makeText(AddBusinessActivity.this,
                            "Please Fill in all of the fields !",
                            Toast.LENGTH_LONG).show();
                } else {
                    SaveButton saveButton = new SaveButton(AddBusinessActivity.this, view);

                    saveButton.buttonActivated();
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            // add to sql
                            SQLDB sqldb = new SQLDB();
                            sqldb.addBusiness(businessName.getText().toString(),
                                                businessAddress.getText().toString(),
                                                businessLatitude.getText().toString(),
                                                businessLongitude.getText().toString(),
                                    businessEmail.getText().toString(),
                                    businessTelephone.getText().toString(),
                                    businessWebsite.getText().toString(),
                                    categoryDropDown.getText().toString(),
                                    businessDescription.getText().toString() );
                            saveButton.buttonFinished();
                            startActivity(new Intent(AddBusinessActivity.this, MainActivity.class));
                        }
                    });
                    // Add to SQLDB
//                    handler.postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            saveButton.buttonFinished();
//                            startActivity(new Intent(AddBusinessActivity.this, MainActivity.class));
//                        }
//                    }, 3000);
                }
                }


        });
    }

}