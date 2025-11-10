package ro.pub.cs.systems.eim.colocviu1_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Colocviu1_2MainActivity extends AppCompatActivity {
    Integer sum = 0;
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
                sum+= Integer.parseInt(editText.getText().toString());
            }
        });

        Button btnCompute = findViewById(R.id.btnCompute);
        btnCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = findViewById(R.id.all_terms);
                textView.setText(sum.toString());


            }
        });

    }
}