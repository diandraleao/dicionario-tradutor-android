package com.example.tradutor;

import java.util.ArrayList;
import java.util.List;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ManipulaBD {
private SQLiteDatabase bd;
	
	public ManipulaBD(Context context){
		CriaBD auxBd = new CriaBD(context);
		bd = auxBd.getWritableDatabase();
	}
	
	public void inserir(Texto texto){
		ContentValues valores = new ContentValues();
		valores.put("nome", texto.getNome());
		valores.put("traducao", texto.getTraducao());
		bd.insert("tbtexto", null, valores);
	}
	
	public void deletar(Texto texto){
		bd.delete("tbtexto", "_id = "+texto.getId(), null);
	}	
	
	public List<Texto> buscar(){ // listar
		List<Texto> list = new ArrayList<Texto>();
		String[] colunas = new String[]{"_id", "nome","traducao"};
		Cursor cursor = bd.query("tbtexto", colunas, null, null, null, null, "nome ASC");
		if(cursor.getCount() > 0){
			cursor.moveToFirst();
			do{
				Texto l = new Texto();
				l.setId(cursor.getLong(0));
				l.setNome(cursor.getString(1));
				l.setTraducao(cursor.getString(2));
				list.add(l);
			} while(cursor.moveToNext());
		}
		return(list);
	}
	
	public void atualizar(Texto texto){
		ContentValues valores = new ContentValues();
		valores.put("nome", texto.getNome());
		valores.put("traducao", texto.getTraducao());		
		bd.update("tbtexto", valores, "_id = ?", new String[]{""+texto.getId()});
	}
}
