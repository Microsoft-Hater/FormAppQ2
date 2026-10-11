package com.example.formappq1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ThankYouActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_thanks);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.thanks), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent = getIntent();
        String name = intent.getStringExtra("NAME");

        TextView thankYouText = findViewById(R.id.thankyouText);
        if(name != null && !name.isEmpty()){
            thankYouText.setText("Thank You, " + name + "! We've received your request.");
        }
        else{
            thankYouText.setText("Thank you for submitting!");
        }

    }
}
