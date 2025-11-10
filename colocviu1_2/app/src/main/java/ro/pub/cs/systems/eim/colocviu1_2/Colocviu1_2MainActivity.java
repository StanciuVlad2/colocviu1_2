package ro.pub.cs.systems.eim.colocviu1_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Colocviu1_2MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_practical_test01_2_main);

        Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = findViewById(R.id.all_terms);
                EditText editText = findViewById(R.id.next_term);

                if(textView.getText().toString().isEmpty()) {
                    textView.setText(editText.getText().toString());

                } else {
                    textView.setText(textView.getText() + "+" + editText.getText().toString());
                }
            }
        });

        Button btnCompute = findViewById(R.id.btnCompute);
        btnCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = findViewById(R.id.all_terms);
                Intent intent = new Intent(Colocviu1_2MainActivity.this,Colocviu1_2SecondaryActivity.class);
                intent.putExtra("EXTRA_SUMS", textView.getText().toString());
                startActivityForResult(intent,0);



            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 0) {
            Toast.makeText(this, "This is suma : " + resultCode, Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode,resultCode,null);
    }
}