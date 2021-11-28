package com.example.calculadoradecimal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText numA;
    private EditText numB;
    private TextView salida;
    private Button botonSuma, botonResta, botonMultiplicar, botonDividir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//Obtenemos una referencia a los controles de la interfaz gráfica
        numA = (EditText)findViewById(R.id.numA);
        numB = (EditText) findViewById(R.id.numB);
        salida =(TextView)findViewById(R.id.salida);
        botonSuma = (Button) findViewById(R.id.botonSuma);
        botonResta = (Button) findViewById(R.id.botonResta);
        botonMultiplicar = (Button) findViewById(R.id.botonMultiplicar);
        botonDividir = (Button) findViewById(R.id.botonDividir);
//Implementamos el evento click del botón
        botonSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//Realizamos la suma
                String valor1=numA.getText().toString();
                String valor2=numB.getText().toString();
                int numero1=Integer.parseInt(valor1);
                int numero2=Integer.parseInt(valor2);

                int suma=numero1+numero2;
                String resultado=String.valueOf(suma);
                salida.setText(resultado);
            }
        });

        //Implementamos el evento click del botón
        botonResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//Realizamos la resta
                String valor1=numA.getText().toString();
                String valor2=numB.getText().toString();
                int numero1=Integer.parseInt(valor1);
                int numero2=Integer.parseInt(valor2);
                int resta=numero1-numero2;
                String resultado=String.valueOf(resta);
                salida.setText(resultado);
            }
        });

        //Implementamos el evento click del botón
        botonMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//Realizamos la multiplicación
                String valor1=numA.getText().toString();
                String valor2=numB.getText().toString();
                int numero1=Integer.parseInt(valor1);
                int numero2=Integer.parseInt(valor2);
                int multiplicacion=numero1*numero2;
                String resultado=String.valueOf(multiplicacion);
                salida.setText(resultado);
            }
        });

        //Implementamos el evento click del botón
        botonDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//Realizamos la suma
                String valor1=numA.getText().toString();
                String valor2=numB.getText().toString();
                int numero1=Integer.parseInt(valor1);
                int numero2=Integer.parseInt(valor2);
                if(numero2==0){
                    Toast.makeText(getApplicationContext(),"Error, no divisible entre 0",Toast.LENGTH_LONG).show();
                }else{
                    int dividir=numero1/numero2;
                    String resultado=String.valueOf(dividir);
                    salida.setText(resultado);
                }
            }
        });
    }
}