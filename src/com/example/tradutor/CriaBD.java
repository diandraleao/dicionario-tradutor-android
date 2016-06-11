package com.example.tradutor;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBD extends SQLiteOpenHelper{
	private static final String NOME_BD = "Tradutor";
	private static final int VERSAO_BD = 1;
	
	public CriaBD(Context ctx){
		super(ctx, NOME_BD, null, VERSAO_BD);
	}

	@Override
	public void onCreate(SQLiteDatabase bd) {
		bd.execSQL("create table tbtexto(_id integer primary key autoincrement, nome text not null, traducao text not null);");
	}

	@Override
	public void onUpgrade(SQLiteDatabase bd, int arg1, int arg2) {
		bd.execSQL("drop table tbtexto;");
		onCreate(bd);
	}

}
