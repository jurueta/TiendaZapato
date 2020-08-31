package com.example.tallerzapatos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

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
        String[] ArraytipoZapato, ArraymarcaZapato;

        seleccionGenero = findViewById(R.id.grdnbtnGenero);
        resultado = findViewById(R.id.txtResultado);
        genMasculino = findViewById(R.id.rdbtnSexoMasculino);
        genFemenino = findViewById(R.id.rdbtnSexoFemenino);
        tipoZapato = findViewById(R.id.sltTipoZapato);
        marcaZapato = findViewById(R.id.sltMarcaZapato);
        cantidadZapatos = findViewById(R.id.txtCantidadZapatos);
        ArraytipoZapato = getResources().getStringArray(R.array.tipo_zapato);
        ArraymarcaZapato = getResources().getStringArray(R.array.marcas_zapatos);
        ArrayAdapter<String> adapterTipoZapato = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, ArraytipoZapato);
        ArrayAdapter<String> adapterMarcaZapato = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, ArraymarcaZapato);
        tipoZapato.setAdapter(adapterTipoZapato);
        marcaZapato.setAdapter(adapterMarcaZapato);
    }

    public void Muestratotal(View v){
        int opcionTipo, opcionMarca, cantidadIngresada;
        double precioZapato = 0, total;
        if (validad()) {
            NumberFormat nf = NumberFormat.getInstance(new Locale("es", "CO"));
            opcionTipo = tipoZapato.getSelectedItemPosition();
            opcionMarca = marcaZapato.getSelectedItemPosition();
            cantidadIngresada = Integer.parseInt("" + cantidadZapatos.getText());
            if (seleccionGenero.getCheckedRadioButtonId() == genMasculino.getId()) {
                switch (opcionTipo) {
                    case 1:
                        switch (opcionMarca) {
                            case 1:
                                precioZapato = 120000;
                                break;
                            case 2:
                                precioZapato = 140000;
                                break;
                            case 3:
                                precioZapato = 130000;
                                break;
                        }
                        break;
                    case 2:
                        switch (opcionMarca) {
                            case 1:
                                precioZapato = 50000;
                                break;
                            case 2:
                                precioZapato = 80000;
                                break;
                            case 3:
                                precioZapato = 100000;
                                break;
                        }
                        break;
                }
            } else {
                switch (opcionTipo) {
                    case 1:
                        switch (opcionMarca) {
                            case 1:
                                precioZapato = 100000;
                                break;
                            case 2:
                                precioZapato = 130000;
                                break;
                            case 3:
                                precioZapato = 110000;
                                break;
                        }
                        break;
                    case 2:
                        switch (opcionMarca) {
                            case 1:
                                precioZapato = 60000;
                                break;
                            case 2:
                                precioZapato = 70000;
                                break;
                            case 3:
                                precioZapato = 120000;
                                break;
                        }
                        break;
                }
            }
            total = precioZapato * cantidadIngresada;
            resultado.setText("" + getString(R.string.txt_total_p) + " " + nf.format(total));
        }
    }

    public void limpiar(View v){
        cantidadZapatos.setText("");
        genMasculino.setChecked(false);
        genFemenino.setChecked(false);
        tipoZapato.setSelection(0);
        marcaZapato.setSelection(0);
        resultado.setText("");
    }

    public boolean validad(){

        if (!genMasculino.isChecked() && !genFemenino.isChecked()){
            genMasculino.setError(getString(R.string.txt_error_genero));
            genFemenino.setError(getString(R.string.txt_error_genero));
            return false;
        }

        if (tipoZapato.getSelectedItemPosition() == 0){
            return false;
        }

        if (marcaZapato.getSelectedItemPosition() == 0){
            return false;
        }

        if (cantidadZapatos.getText().toString().isEmpty()){
            cantidadZapatos.setError(getString(R.string.txt_entrada_cantidad));
            return false;
        }

        return true;
    }
}