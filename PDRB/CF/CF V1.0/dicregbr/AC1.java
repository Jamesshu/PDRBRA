package com.alk.dicregbr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class tela1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t1);
    }//fim do onCreate


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.m3, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemClicado = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (itemClicado == R.id.M3_ItemSobre) {
            Intent i = new Intent(this, tela5.class);
            startActivity(i);
        }
        if (itemClicado == R.id.M3_ItemAddP){
            Intent i = new Intent(this, tela4.class);
            startActivity(i);
        }
        if (itemClicado == R.id.M3_ItemSair){
            this.finish(); // apenas miniminiza o app
        }
        return super.onOptionsItemSelected(item);
    }
}
