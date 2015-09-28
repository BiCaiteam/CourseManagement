package com.example.hee;
import com.example.hee.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity implements OnClickListener{

	private Button button1_openActivity;
	private Button button2_openDate;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button1_openActivity=(Button) findViewById(R.id.button1_openActiviy);
		button2_openDate=(Button) findViewById(R.id.button2_openDate);
		button1_openActivity.setOnClickListener(this);
		button2_openDate.setOnClickListener(this);
	}
		@Override
		public void onClick(View v) {
			
			switch(v.getId()){
			case R.id.button1_openActiviy:
			Intent intent=new Intent();
			intent.setClass(MainActivity.this, GridViewTestActivity.class);
			startActivity(intent);
			break;
			case R.id.button2_openDate:
				Intent intent2=new Intent();
				intent2.setClass(MainActivity.this, ExcelDate.class);
				startActivity(intent2);
				break;
			}
			
		}
}

