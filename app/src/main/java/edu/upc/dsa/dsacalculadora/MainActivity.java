package edu.upc.dsa.dsacalculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView text_respuesta;
    private EditText edit_numero_uno;
    private EditText edit_numero_dos;
    private Button btn_suma;
    private Button btn_resta;
    private Button btn_multiplicar;
    private Button btn_dividir;




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
        text_respuesta = findViewById(R.id.respuesta);
        edit_numero_uno = findViewById(R.id.numero1);
        edit_numero_dos = findViewById(R.id.numero2);
        btn_suma = findViewById(R.id.button_suma);
        btn_suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               text_respuesta.setText(suma(Double.parseDouble(edit_numero_uno.getText().toString()), Double.parseDouble(edit_numero_dos.getText().toString()))+"");
            }
        });
        btn_resta = findViewById(R.id.button_resta);
        btn_resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_respuesta.setText(resta(Double.parseDouble(edit_numero_uno.getText().toString()), Double.parseDouble(edit_numero_dos.getText().toString()))+"");
            }
        });
        btn_multiplicar = findViewById(R.id.button_multiplicar);
        btn_multiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_respuesta.setText(multiplicar(Double.parseDouble(edit_numero_uno.getText().toString()), Double.parseDouble(edit_numero_dos.getText().toString()))+"");
            }
        });
        btn_dividir = findViewById(R.id.button_dividir);
        btn_dividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_respuesta.setText(dividir(Double.parseDouble(edit_numero_uno.getText().toString()), Double.parseDouble(edit_numero_dos.getText().toString()))+"");
            }
        });

    }

    public double suma (double a, double b){
        return a+b;
    }
    public double resta (double a, double b){
        return a-b;
    }
    public double multiplicar (double a, double b){
        return a*b;
    }
    public double dividir (double a, double b){
        double respuesta = 0;
        if (b!=0){
            return a/b;
        }
        return respuesta;
    }
}