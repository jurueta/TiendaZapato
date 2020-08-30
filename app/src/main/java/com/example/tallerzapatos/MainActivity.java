package com.example.tallerzapatos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RadioGroup seleccionGenero;
    private RadioButton genMasculino, genFemenino;
    private Spinner tipoZapato, marcaZapato;
    private EditText cantidadZapatos;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seleccionGenero = findViewById(R.id.grdnbtnGenero);
        resultado = findViewById(R.id.txtResultado);
        genMasculino = findViewById(R.id.rdbtnSexoMasculino);
        genFemenino = findViewById(R.id.rdbtnSexoFemenino);
        tipoZapato = findViewById(R.id.sltTipoZapato);
        marcaZapato = findViewById(R.id.sltMarcaZapato);
        cantidadZapatos = findViewById(R.id.txtCantidadZapatos);

    }

    public void Muestratotal(View v){
        int opcionTipo, opcionMarca;
        if (seleccionGenero.getCheckedRadioButtonId() == genMasculino.getId()){
            opcionTipo = tipoZapato.getSelectedItemPosition();
            opcionMarca = marcaZapato.getSelectedItemPosition();
            switch (opcionTipo){
                case 1:
                    break;
                case 2:
                    break;
            }
        }
    }
}