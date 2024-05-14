package com.example.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private String lvl = "Beginner";
    RadioGroup rBtn;

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

        rBtn =  findViewById(R.id.rad);
        rBtn.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.rb1){
                    lvl = "Beginner";
                }
                else if(checkedId == R.id.rb2){
                    lvl = "Intermediate";
                }
                else if(checkedId == R.id.rb3){
                    lvl = "Expert";
                }
            }
        });

        ProgressBar bar = findViewById(R.id.progress);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i <= 10; i++) {
                    bar.incrementProgressBy(i*10);
                    SystemClock.sleep(2500);
                }
            }
        });

        thread.start();
    }


    @SuppressLint("SetTextI18n")
    public  void btnHandler(View view){
        TextView txt = findViewById(R.id.txt1);
        EditText edt = findViewById(R.id.input1);
        CheckBox chk = findViewById(R.id.chk1);
        TextView txt2 = findViewById(R.id.txt2);

        String text = edt.getText().toString();

        if(text.isEmpty()||!chk.isChecked()){
            Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "User verified, level is: "+lvl, Toast.LENGTH_LONG).show();
            txt.setText("Welcome "+text);
            txt2.setText("Level: "+lvl);
        }

    }
}