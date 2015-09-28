package com.example.hee;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.example.hee.DateBase;;
public class ExcelDate extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_excel_date);
		DateBase db1=new DateBase(this, "edb", null, 0);
		db1.onCreate(null);
	}
}
