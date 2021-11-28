package com.example.calculadorabinariapuertaslogicas;

import android.content.pm.ActivityInfo;
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
    private Button botonSuma, botonResta, botonMultiplicar, botonDividir, botonAND, botonOR, botonXOR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//Obtenemos una referencia a los controles de la interfaz gráfica
        numA = (EditText)findViewById(R.id.numA);
        numB = (EditText) findViewById(R.id.numB);
        salida = (TextView) findViewById(R.id.salida);
        botonSuma = (Button) findViewById(R.id.botonSuma);
        botonResta = (Button) findViewById(R.id.botonResta);
        botonMultiplicar = (Button) findViewById(R.id.botonMultiplicar);
        botonDividir = (Button) findViewById(R.id.botonDividir);
        botonAND = (Button) findViewById(R.id.botonAND);
        botonOR = (Button) findViewById(R.id.botonOR);
        botonXOR = (Button) findViewById(R.id.botonXOR);
//Implementamos el evento click del botón
        botonSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//Realizamos la suma
                try {
                    String valor1 = numA.getText().toString();
                    String valor2 = numB.getText().toString();
                    int numero1 = Integer.parseInt(valor1, 2);
                    int numero2 = Integer.parseInt(valor2, 2);
                    int suma = numero1 + numero2;
                    String resultado = Integer.toBinaryString(suma); //Paso a binario

                    if (resultado.length() > 8)  //Binario
                        throw new NumberFormatException();

                    while (resultado.length() < 8) {
                        resultado = "0" + resultado;
                    }                           //Fin binario

                    salida.setText(resultado);
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(),"Overflow o Datos no introducidos",Toast.LENGTH_LONG).show();  //Corrección overflow
                }
            }
        });

        //Implementamos el evento click del botón
        botonResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//Realizamos la resta
                try {
                    String valor1 = numA.getText().toString();
                    String valor2 = numB.getText().toString();
                    int numero1 = Integer.parseInt(valor1, 2);
                    int numero2 = Integer.parseInt(valor2, 2);

                    if(numero2>numero1) {
                        Toast.makeText(getApplicationContext(),"Numero negativo no representable",Toast.LENGTH_LONG).show();
                    }else{
                        int resta = numero1 - numero2;
                        String resultado = Integer.toBinaryString(resta);

                        if (resultado.length() > 8)
                            throw new NumberFormatException();

                        while (resultado.length() < 8) {
                            resultado = "0" + resultado;
                        }

                        salida.setText(resultado);
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(),"Overflow o Datos no introducidos",Toast.LENGTH_LONG).show();
                }
            }
        });

        //Implementamos el evento click del botón
        botonMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//Realizamos la multiplicación
                try {
                    String valor1 = numA.getText().toString();
                    String valor2 = numB.getText().toString();
                    int numero1 = Integer.parseInt(valor1, 2);
                    int numero2 = Integer.parseInt(valor2, 2);
                    int multiplicacion = numero1 * numero2;
                    String resultado = Integer.toBinaryString(multiplicacion);

                    if (resultado.length() > 8)
                        throw new NumberFormatException();

                    while (resultado.length() < 8) {
                        resultado = "0" + resultado;
                    }

                    salida.setText(resultado);
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(),"Overflow o Datos no introducidos",Toast.LENGTH_LONG).show();
                }
            }
        });

        //Implementamos el evento click del botón
        botonDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//Realizamos la division
                try {
                    String valor1 = numA.getText().toString();
                    String valor2 = numB.getText().toString();
                    int numero1 = Integer.parseInt(valor1, 2);
                    int numero2 = Integer.parseInt(valor2, 2);
                    if(numero2==0){
                        Toast.makeText(getApplicationContext(),"No divisible por 0",Toast.LENGTH_LONG).show();
                    }else{
                        int dividir = numero1 / numero2;
                        String resultado = Integer.toBinaryString(dividir);

                        if (resultado.length() > 8)
                            throw new NumberFormatException();

                        while (resultado.length() < 8) {
                            resultado = "0" + resultado;
                        }

                        salida.setText(resultado);
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(),"Overflow o Datos no introducidos",Toast.LENGTH_LONG).show();
                }
            }
        });

        botonAND.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String valor1 = numA.getText().toString();
                    String valor2 = numB.getText().toString();
                    int numero1 = Integer.parseInt(valor1, 2);
                    int numero2 = Integer.parseInt(valor2, 2);
                    int suma = numero1 & numero2;
                    String resultado = Integer.toBinaryString(suma);

                    if (resultado.length() > 8)
                        throw new NumberFormatException();

                    while (resultado.length() < 8) {
                        resultado = "0" + resultado;
                    }

                    salida.setText(resultado);
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(),"Overflow o Datos no introducidos",Toast.LENGTH_LONG).show();
                }
            }
        });

        botonOR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String valor1 = numA.getText().toString();
                    String valor2 = numB.getText().toString();
                    int numero1 = Integer.parseInt(valor1, 2);
                    int numero2 = Integer.parseInt(valor2, 2);
                    int suma = numero1 | numero2;
                    String resultado = Integer.toBinaryString(suma);

                    if (resultado.length() > 8)
                        throw new NumberFormatException();

                    while (resultado.length() < 8) {
                        resultado = "0" + resultado;
                    }
                    salida.setText(resultado);
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(),"Overflow o Datos no introducidos",Toast.LENGTH_LONG).show();
                }
            }
        });

        botonXOR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String valor1 = numA.getText().toString();
                    String valor2 = numB.getText().toString();
                    int numero1 = Integer.parseInt(valor1, 2);
                    int numero2 = Integer.parseInt(valor2, 2);
                    int suma = numero1 ^ numero2;
                    String resultado = Integer.toBinaryString(suma);

                    if (resultado.length() > 8)
                        throw new NumberFormatException();

                    while (resultado.length() < 8) {
                        resultado = "0" + resultado;
                    }

                    salida.setText(resultado);
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(),"Overflow o Datos no introducidos",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
