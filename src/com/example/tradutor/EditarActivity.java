package com.example.tradutor;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EditarActivity extends Activity {
	EditText edtIngles;
	EditText edtTradutor;
	EditText edtId;
	Intent it;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);
        edtIngles = (EditText)findViewById(R.id.edtIngles);
        edtTradutor = (EditText)findViewById(R.id.edtTradutor);
        edtId = (EditText)findViewById(R.id.edtId);
		it = getIntent();
		edtIngles.setText(it.getStringExtra("nome").toString());
		edtTradutor.setText(it.getStringExtra("traducao").toString());
		edtId.setText(it.getStringExtra("id".toString()));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.editar, menu);
        return true;
    }
    
    public void editarClick(View v){		
		ManipulaBD atualizar = new ManipulaBD(this); // controller
		Texto t = new Texto();
	    t.setId(Integer.parseInt( edtId.getText().toString()) );
	    t.setNome(edtIngles.getText().toString());
	    t.setTraducao(edtTradutor.getText().toString());
	    atualizar.atualizar(t); // manipula recebe um objeto
	    Toast.makeText(this, "A palavra "+edtIngles.getText()+
	    		"\n foi alterada com sucesso!", Toast.LENGTH_LONG).show();
	    finish();
	}
	
	public void excluirClick(View v){		
		ManipulaBD deletar = new ManipulaBD(this);
		Texto t = new Texto();
	    t.setId(Integer.parseInt( edtId.getText().toString()));
	    t.setNome(edtIngles.getText().toString());
	    t.setTraducao(edtTradutor.getText().toString());
	    deletar.deletar(t);
	    Toast.makeText(this, "A palavra "+edtIngles.getText()+
	    		"\n foi excluida com sucesso!", Toast.LENGTH_LONG).show();
	    finish();
	    
		
	}
}
