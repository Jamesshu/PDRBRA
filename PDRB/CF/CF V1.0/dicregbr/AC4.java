package com.alk.dicregbr;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class tela4 extends AppCompatActivity {

    private EditText editIncluir;
    private Spinner spinnerEstados;
    private EditText editSignificado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t4);
        //Integração Java e XML
        editIncluir = (EditText) findViewById(R.id.T4_Incluir);
        spinnerEstados = (Spinner) findViewById(R.id.T4_SpinEstados);
        editSignificado = (EditText) findViewById(R.id.T4_AddSignificado);
    }//fim do onCreate
    public void enviar (View v){
        String palavraDig = editIncluir.getText().toString();
        String estadoDig = spinnerEstados.getSelectedItem().toString();
        String significadoDig= editSignificado.getText().toString();
        String uriText =
                "mailto:18devak@gmail.com" +
                        "?subject=" + Uri.encode("SUGESTÃO DE NOVA PALAVRA - "+palavraDig) +
                        "&body=" + Uri.encode("Olá, acho que está palavra ainda não foi adicionada ao Dicionário Regional " +
                        "Brasileiro, ou acredito que ela possua um outro significado diferente do existente no app!\n"
                        +"\nPalavra ou expressão: "+palavraDig
                        +"\nEstado: "+estadoDig
                        +"\nSignificado da palavra ou expressão: "+significadoDig);
        Uri uri = Uri.parse(uriText);
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(uri);
        startActivity(Intent.createChooser(emailIntent,"Selecione seu app de e-mail preferido"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.m1,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemClicado = item.getItemId();
        if (itemClicado == (R.id.M1_ItemSair)){
            this.finish(); // só fecha a activity atual
        }else if (itemClicado == (R.id.M1_Home)){
            Intent i = new Intent(this,tela1.class);
            startActivity(i);
        /*}else if (itemClicado == (R.id.M2_Home)){
            Intent i = new Intent(this,tela1.class);*/
        }
        return super.onOptionsItemSelected(item);
    }
}//fim da classe
