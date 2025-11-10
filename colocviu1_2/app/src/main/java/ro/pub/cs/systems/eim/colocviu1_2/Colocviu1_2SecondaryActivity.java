package ro.pub.cs.systems.eim.colocviu1_2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Colocviu1_2SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_colocviu12_secondary);
        TextView textView = findViewById(R.id.teComputed22);

        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("EXTRA_COMPUTED")) {
                textView.setText(savedInstanceState.getString("EXTRA_COMPUTED"));
            }
        }

        EdgeToEdge.enable(this);

        String numbers = getIntent().getExtras().get("EXTRA_SUMS").toString();
        var numbers2 = numbers.split("[+]");
        Integer sum = 0;
        for (String el : numbers2) {
            sum += Integer.parseInt(el);
        }
        Log.d("MY_TAG", sum + " ");
        textView.setText(sum.toString());
        setResult(sum,null);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        TextView textView = findViewById(R.id.teComputed22);
        outState.putString("EXTRA_COMPUTED", textView.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        TextView textView = findViewById(R.id.teComputed22);
        if (savedInstanceState.containsKey("EXTRA_COMPUTED")) {
            textView.setText(savedInstanceState.getString("EXTRA_COMPUTED"));
        }
    }

    @Override
    protected void onPause() {
        TextView textView = findViewById(R.id.teComputed22);
        setResult(Integer.parseInt(textView.getText().toString()),null);
        finish();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        TextView textView = findViewById(R.id.teComputed22);
        setResult(Integer.parseInt(textView.getText().toString()),null);
        super.onDestroy();
    }
}




