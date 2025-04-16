package edu.upc.dsa.dsacalculadora;

import android.annotation.SuppressLint;
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

    private double memoria = 0;
    private TextView text_respuesta;
    private EditText edit_numero;
    private Button btn_suma, btn_resta, btn_multiplicar, btn_dividir, btn_reset;

    @SuppressLint("MissingInflatedId")
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
        edit_numero = findViewById(R.id.numero);
        btn_suma = findViewById(R.id.button_suma);
        btn_resta = findViewById(R.id.button_resta);
        btn_multiplicar = findViewById(R.id.button_multiplicar);
        btn_dividir = findViewById(R.id.button_dividir);
        btn_reset = findViewById(R.id.button_reset);

        btn_suma.setOnClickListener(v -> operar("+"));
        btn_resta.setOnClickListener(v -> operar("-"));
        btn_multiplicar.setOnClickListener(v -> operar("*"));
        btn_dividir.setOnClickListener(v -> operar("/"));
        btn_reset.setOnClickListener(v -> {
            memoria = 0;
            text_respuesta.setText("0");
        });

    }

    private void operar(String operacion) {
        String input = edit_numero.getText().toString();
        if (input.isEmpty()) return;

        double numero = Double.parseDouble(input);

        switch (operacion) {
            case "+": memoria += numero; break;
            case "-": memoria -= numero; break;
            case "*": memoria *= numero; break;
            case "/":
                if (numero != 0) memoria /= numero;
                else memoria = 0;
                break;
        }

        text_respuesta.setText(String.valueOf(memoria));
        edit_numero.setText(""); // limpia el campo
    }
}