package com.example.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
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

        RadioGroup rBtn =  findViewById(R.id.rad);
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
    }

    public  void btnHandler(View view){
        TextView txt = findViewById(R.id.txt1);
        EditText edt = findViewById(R.id.input1);
        CheckBox chk = findViewById(R.id.chk1);

        String text = edt.getText().toString();

        if(text.isEmpty()||!chk.isChecked()){
            Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "User verified, level is: "+lvl, Toast.LENGTH_LONG).show();
            txt.setText("Welcome "+text);
        }

    }
}