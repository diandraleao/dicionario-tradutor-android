package com.example.tradutor;

import java.util.ArrayList;
import java.util.List;


import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class LerActivity extends ListActivity {
	String regTexto;
	List<Texto> listTextos;
	ArrayList<String> arrTexto;
	ManipulaBD db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		arrTexto = new ArrayList<String>();
		db = new ManipulaBD(this);
		listTextos = db.buscar();
		for (Texto lv : listTextos) {
			regTexto = lv.getId()+" "+lv.getNome()+" "+lv.getTraducao();
			arrTexto.add(regTexto);
		}
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arrTexto);
		this.setListAdapter(dataAdapter);
	}
	
	@Override
	protected void onListItemClick(ListView l,View v, int position, long id){	
		//Toast.makeText(this, "Registro selecionado: "+(position+1), Toast.LENGTH_SHORT).show(); - USADO PARA DEBUG
		Intent it = new Intent(this,EditarActivity.class);
		String ing = listTextos.get(position).getNome();
		String trad = listTextos.get(position).getTraducao();
		String idtexto = ""+ listTextos.get(position).getId();
		Toast.makeText(this, ""+idtexto+"-"+ing, Toast.LENGTH_SHORT).show();
		it.putExtra("id",idtexto);
		it.putExtra("nome",ing);
		it.putExtra("traducao", trad);
		startActivity(it);
		finish();		
				
	}

}
