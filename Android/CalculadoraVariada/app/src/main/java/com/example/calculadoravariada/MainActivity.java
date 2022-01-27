package com.example.calculadoravariada;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText numA;
    private EditText numB;
    private TextView salida;
    private Button botonSuma, botonResta, botonMultiplicar, botonDividir;
    private RadioButton binN, SyM, C2;
    private int resul;
    private String noerror;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//Obtenemos una referencia a los controles de la interfaz gráfica
        numA = (EditText)findViewById(R.id.numA);
        numB = (EditText) findViewById(R.id.numB);
        salida =(TextView)findViewById(R.id.salida);
        botonSuma = (Button) findViewById(R.id.botonSuma);
        botonResta = (Button) findViewById(R.id.botonResta);
        botonMultiplicar = (Button) findViewById(R.id.botonMultiplicar);
        botonDividir = (Button) findViewById(R.id.botonDividir);
        binN = (RadioButton) findViewById(R.id.BN);
        SyM = (RadioButton) findViewById(R.id.SyM);
        C2 = (RadioButton) findViewById(R.id.C2);
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

                    if(binN.isChecked()) {
                        resul = numero1 + numero2;
                        String resultado = Integer.toBinaryString(resul); //Paso a binario

                        if (resultado.length() > 8)  //Binario
                            throw new NumberFormatException();

                        while (resultado.length() < 8) {
                            resultado = "0" + resultado;
                        }                           //Fin binario

                        salida.setText(resultado);
                    }else if(SyM.isChecked()){

                    }else if(C2.isChecked()){

                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();  //Corrección overflow
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

                    if (binN.isChecked()) {
                        resul = numero1 - numero2;
                        String resultado = Integer.toBinaryString(resul);

                        if (resultado.length() > 8)
                            throw new NumberFormatException();

                        while (resultado.length() < 8) {
                            resultado = "0" + resultado;
                        }

                        salida.setText(resultado);
                    }else if(SyM.isChecked()){

                    }else if(C2.isChecked()){

                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
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
                    if(binN.isChecked()) {
                        resul = numero1 * numero2;
                        String resultado = Integer.toBinaryString(resul);

                        if (resultado.length() > 8)
                            throw new NumberFormatException();

                        while (resultado.length() < 8) {
                            resultado = "0" + resultado;
                        }

                        salida.setText(resultado);
                    }else if(SyM.isChecked()){

                    }else if(C2.isChecked()){

                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
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
                    if(binN.isChecked()) {
                        if (numero2 == 0) {
                            Toast.makeText(getApplicationContext(), "No divisible entre 0", Toast.LENGTH_LONG).show();
                        } else {
                            resul = numero1 / numero2;
                            String resultado = Integer.toBinaryString(resul);

                            if (resultado.length() > 8)
                                throw new NumberFormatException();

                            while (resultado.length() < 8) {
                                resultado = "0" + resultado;
                            }

                            salida.setText(resultado);
                        }
                    }else if(SyM.isChecked()){

                    }else if(C2.isChecked()){

                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
                }
            }
        });

        binN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int num=resul;
                int bin=0;
                int dig=0;
                int exp=0;

                if(resul<=255 && resul>=0){
                    if(noerror.equals("*")==false){
                    while(num!=0){
                        dig=num%2;
                        bin=(int)(bin+dig*Math.pow(10, exp));
                        exp++;
                        num=num/2;
                    }
                    String resultado=String.valueOf(bin);
                    for(int i=resultado.length();i<8;i++){
                        resultado="0"+resultado;
                    }
                    salida.setText(resultado);
                }else{
                    salida.setText("Error");}
                }else{
                    salida.setText("Error");
                }
            }

        });

        SyM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num=resul;
                int bin=0;
                int dig=0;
                int exp=0;

                if(resul<=127&&resul>=-127&&!noerror.equals("*")){
                    if(resul>=0){
                        while(num!=0){
                            dig=num%2;
                            bin=(int)(bin+dig*Math.pow(10, exp));
                            exp++;
                            num=num/2;
                        }
                        String resultado=String.valueOf(bin);
                        for(int i=resultado.length();i<8;i++){
                            resultado="0"+resultado;
                        }
                        salida.setText(resultado);
                    }else{
                        int j;
                        j=0;
                        j=resul*(-1);
                        num=j;
                        while(num != 0){
                            dig=num%2;
                            bin=(int)(bin+dig*Math.pow(10, exp));
                            exp++;
                            num=num/2;
                        }
                        String resultado=String.valueOf(bin);

                        for(int i=resultado.length();i<8;i++){
                            if(i==7){
                                resultado="1"+resultado;
                            }else{
                                resultado="0"+resultado;
                            }
                        }
                        salida.setText(resultado);
                    }
                }
                else{
                    salida.setText("Error");
                }
            }
        });

        C2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num=resul;
                int bin=0;
                int dig=0;
                int exp=0;

                if(resul<=127&&resul>=-128&&!noerror.equals("*")){
                    if(resul>=0){
                        while(num!=0){
                            dig=num%2;
                            bin=(int)(bin+dig+Math.pow(10, exp));
                            exp++;
                            num=num/2;
                        }
                        String resultado=String.valueOf(bin);
                        for(int i=resultado.length();i<8;i++){
                            resultado="0"+resultado;
                        }
                        salida.setText(resultado);
                    }else{
                        int j;
                        j=0;
                        j=resul*(-1);
                        num=j;
                        while(num!=0){
                            dig=num%2;
                            bin=(int)(bin+dig*Math.pow(10, exp));
                            exp++;
                            num=num/2;
                        }
                        String resultado=String.valueOf(bin);
                        int aux;
                        aux=0;
                        boolean correcto;
                        correcto=false;
                        for(int i=resultado.length();i<8;i++){
                            resultado="0"+resultado;
                        }
                        char[] k=resultado.toCharArray();
                        for(int i=resultado.length()-1;(i>=0)&&correcto==false;i--){
                            if(k[i]=='1'){
                                correcto=true;
                                aux=i;
                            }
                        }
                        for(int i=0;i<aux;i++){
                            if(k[i]=='0'){
                                k[i]='1';
                            }else{
                                k[i]='0';
                            }
                        }
                        resultado=String.valueOf(k);
                        salida.setText(resultado);
                    }
                }
                else{
                    salida.setText("Error");
                }
            }
        });
    }
}