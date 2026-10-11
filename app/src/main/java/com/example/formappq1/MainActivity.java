package com.example.formappq1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        MainActivity activity = this;
        Button button = (Button) findViewById(R.id.submitForm);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText nameField = (EditText) findViewById(R.id.nameField);
                EditText emailField = (EditText) findViewById(R.id.emailField);

                int r = new Random().nextInt();

                if(r < 0){
                    r = r * -1;
                }

                int code = (r % 899999) + 100000;

                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(android.net.Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{emailField.getText().toString()});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Validation Code");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Your Code Is: " + code + ".");

                Intent intent = new Intent(activity, ThankYouActivity.class);

                intent.putExtra("NAME", nameField.getText().toString());
                intent.putExtra("CODE", code);

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }

                if(emailIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(emailIntent);
                }
            }
        });
    }
}