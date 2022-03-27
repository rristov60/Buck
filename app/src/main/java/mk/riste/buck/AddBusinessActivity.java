package mk.riste.buck;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import androidx.appcompat.app.AppCompatActivity;

public class AddBusinessActivity extends AppCompatActivity {
    View saveButtonView;
    AutoCompleteTextView categoryDropDown;
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
        saveButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                SaveButton saveButton = new SaveButton(AddBusinessActivity.this, view);

                saveButton.buttonActivated();
                Handler handler = new Handler();
                // Add to MongoDB
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        saveButton.buttonFinished();
                        startActivity(new Intent(AddBusinessActivity.this, MainActivity.class));
                    }
                }, 3000);
            }
        });
    }

}