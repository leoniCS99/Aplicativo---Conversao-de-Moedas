package com.LeoniDev.conversormoedas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private final viewHolder mViewHolder = new viewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.editValor = findViewById(R.id.edit_valor);
        this.mViewHolder.textDolar = findViewById(R.id.textDolar);
        this.mViewHolder.text_euro = findViewById(R.id.text_euro);
        this.mViewHolder.buttonCalcular = findViewById(R.id.buttonCalcular);


        this.mViewHolder.buttonCalcular.setOnClickListener(this);
        this.limparValor();

        this.getText();
        /*this.mViewHolder.buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        METODO DE CLICK NO BOTÃO
*/

    }

    private void limparValor() {

        this.mViewHolder.textDolar.setText("");
        this.mViewHolder.text_euro.setText("");
    }

    private void getText() {
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.buttonCalcular){
            String value = this.mViewHolder.editValor.getText().toString();
         if("".equals(value)){

            Toast.makeText(this, this.getString(R.string.informe_valor),Toast.LENGTH_LONG).show();
        }else{

            double real = Double.parseDouble(value);

            this.mViewHolder.textDolar.setText(String.format("%.2f", (real / 5.19)));
             this.mViewHolder.text_euro.setText(String.format("%.2f", (real / 6.12)));


            }

        }

    }


    private static class viewHolder{
        EditText editValor;
        TextView textDolar;
        TextView text_euro;
        Button buttonCalcular;

    }

}
