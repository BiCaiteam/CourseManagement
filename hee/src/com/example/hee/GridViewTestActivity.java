package com.example.hee;
import java.util.ArrayList;   
import java.util.HashMap;   
 
import android.app.Activity;   
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;   
import android.view.View;   
import android.view.Window;
import android.widget.AdapterView;   
import android.widget.AdapterView.OnItemClickListener;   
import android.widget.GridView;   
import android.widget.SimpleAdapter;   
import android.widget.Toast;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class GridViewTestActivity extends Activity {

	private GridView gridview;   
    protected ArrayList<HashMap<String, String>> srcTable;
    protected SimpleAdapter saTable;// ������
  
         
    public void onCreate(Bundle savedInstanceState) {  
        requestWindowFeature( Window.FEATURE_NO_TITLE ); //�ޱ���
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//ǿ��Ϊ����
        super.onCreate(savedInstanceState);   
         
     
        setContentView(R.layout.gridview);   
        gridview = (GridView) findViewById(R.id.gridview);   
  
        srcTable = new ArrayList<HashMap<String, String>>();
        saTable = new SimpleAdapter(this,
                srcTable,// ������Դ
                R.layout.griditem,//XMLʵ��
                new String[] { "ItemText" },  // ��̬������ImageItem��Ӧ������
                new int[] { R.id.ItemText });
         
     
        // ��Ӳ�����ʾ   
        gridview.setAdapter(saTable);   
        // �����Ϣ����   
        gridview.setOnItemClickListener(new ItemClickListener());   
  
        //��ӱ�ͷ
        addHeader();
  
        //������ݲ���
        addData();   
  
    } 
  
    @Override
    public void onConfigurationChanged(Configuration newConfig)
    { 
        super.onConfigurationChanged(newConfig); 
     if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
     {
//land
     }
     else if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
     {
//port
     }
    }
  
    public void addHeader(){
        String items[]={ "�꼶", "רҵ","רҵ����","�γ�����","ѡ������","ѧ��","ѧʱ","ʵ��ѧʱ","�ϻ�ѧʱ","��������","�ον�ʦ","��ע"};
        for (String strText:items) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("ItemText",strText);
            srcTable.add(map);
       }
        saTable.notifyDataSetChanged(); //��������
    }
  
    public void addData(){
         
        for(int i=0;i<3;i++){
            String items[]={ "����", "��ѧ","Ӣ��","����","�����","��ѧ","����", "��ѧ","Ӣ��","����","�����","��ѧ"};
            for (String strText:items) {
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("ItemText",strText);
                srcTable.add(map);
           }    
        }
        saTable.notifyDataSetChanged(); //��������
        
       /* DateBase db=new DateBase(this, "edb", null, 0);
     		db.onCreate(null);
     		Cursor c = db.select();//��ѯ������α�
     		if(c.moveToFirst()){//�ж��α��Ƿ�Ϊ��
     		    for(int i=0;i<c.getCount();i++){
     		        c.move(i);//�ƶ���ָ����¼
     		        String username = c.getString(c.getColumnIndex("username"));
     		        String password = c.getString(c.getColumnIndex("password"));
     		    }}*/
    }
  
    //����б�
    public void RemoveAll()
    {
        srcTable.clear();
        saTable.notifyDataSetChanged();
    }
  
    // ��񵥻�����
    class ItemClickListener implements OnItemClickListener {   
        public void onItemClick(AdapterView<?> arg0,View arg1,int arg2,long arg3){   
            // �ڱ�����arg2=arg3   
            @SuppressWarnings("unchecked")   
            HashMap<String, Object> item = (HashMap<String, Object>) arg0.getItemAtPosition(arg2);   
            // ��ʾ��ѡItem��ItemText   
            Toast.makeText(getApplicationContext(),(String)item.get("ItemText"),Toast.LENGTH_SHORT).show();
  
        }   
    }   
}
