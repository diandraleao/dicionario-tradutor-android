package com.example.tradutor;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Texto texto = new Texto();
	private EditText edtIngles, edtTradutor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);   
        edtIngles = (EditText)findViewById(R.id.edtIngles);
        edtTradutor = (EditText)findViewById(R.id.edtTradutor);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void gravarClick(View v){
		texto.setNome(edtIngles.getText().toString());
		texto.setTraducao(edtTradutor.getText().toString());
		ManipulaBD bd = new ManipulaBD(this);
		bd.inserir(texto);
		Toast.makeText(this, "Tradução cadastrada com sucesso", Toast.LENGTH_SHORT).show();
		edtIngles.setText("");
		edtTradutor.setText("");
	}
    
	@Override	
	public boolean onMenuItemSelected(int panel, MenuItem item){
		Intent it;
		switch(item.getItemId()){
		case R.id.exibir:
			it = new Intent(this,LerActivity.class);
			startActivity(it);
			break;
		case R.id.sobre:
			it = new Intent(this,SobreActivity.class);
			startActivity(it);
			break;
		}
		return true;
	}
    
}
