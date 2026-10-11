package com.example.formappq1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

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
        int code = intent.getIntExtra("CODE", 0);

        ThankYouActivity activity = this;

        TextView thankYouText = findViewById(R.id.thankyouText);
        if(name != null && !name.isEmpty()){
            thankYouText.setText("Thank You, " + name + "! We've received your request.");
        }
        else{
            thankYouText.setText("Thank you for submitting!");
        }

        Button button = (Button) findViewById(R.id.submitCode);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText codeField = (EditText) findViewById(R.id.codeField);

                if(Integer.parseInt(codeField.getText().toString()) == code){
                    Toast.makeText(activity, "The Code Is Correct", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(activity, "The Code Is Incorrect", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
