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
    protected SimpleAdapter saTable;// 适配器
  
         
    public void onCreate(Bundle savedInstanceState) {  
        requestWindowFeature( Window.FEATURE_NO_TITLE ); //无标题
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//强制为横屏
        super.onCreate(savedInstanceState);   
         
     
        setContentView(R.layout.gridview);   
        gridview = (GridView) findViewById(R.id.gridview);   
  
        srcTable = new ArrayList<HashMap<String, String>>();
        saTable = new SimpleAdapter(this,
                srcTable,// 数据来源
                R.layout.griditem,//XML实现
                new String[] { "ItemText" },  // 动态数组与ImageItem对应的子项
                new int[] { R.id.ItemText });
         
     
        // 添加并且显示   
        gridview.setAdapter(saTable);   
        // 添加消息处理   
        gridview.setOnItemClickListener(new ItemClickListener());   
  
        //添加表头
        addHeader();
  
        //添加数据测试
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
        String items[]={ "年级", "专业","专业人数","课程名称","选修类型","学分","学时","实验学时","上机学时","起讫周序","任课教师","备注"};
        for (String strText:items) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("ItemText",strText);
            srcTable.add(map);
       }
        saTable.notifyDataSetChanged(); //更新数据
    }
  
    public void addData(){
         
        for(int i=0;i<3;i++){
            String items[]={ "语文", "数学","英语","体育","计算机","化学","语文", "数学","英语","体育","计算机","化学"};
            for (String strText:items) {
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("ItemText",strText);
                srcTable.add(map);
           }    
        }
        saTable.notifyDataSetChanged(); //更新数据
        
       /* DateBase db=new DateBase(this, "edb", null, 0);
     		db.onCreate(null);
     		Cursor c = db.select();//查询并获得游标
     		if(c.moveToFirst()){//判断游标是否为空
     		    for(int i=0;i<c.getCount();i++){
     		        c.move(i);//移动到指定记录
     		        String username = c.getString(c.getColumnIndex("username"));
     		        String password = c.getString(c.getColumnIndex("password"));
     		    }}*/
    }
  
    //清空列表
    public void RemoveAll()
    {
        srcTable.clear();
        saTable.notifyDataSetChanged();
    }
  
    // 表格单击处理
    class ItemClickListener implements OnItemClickListener {   
        public void onItemClick(AdapterView<?> arg0,View arg1,int arg2,long arg3){   
            // 在本例中arg2=arg3   
            @SuppressWarnings("unchecked")   
            HashMap<String, Object> item = (HashMap<String, Object>) arg0.getItemAtPosition(arg2);   
            // 显示所选Item的ItemText   
            Toast.makeText(getApplicationContext(),(String)item.get("ItemText"),Toast.LENGTH_SHORT).show();
  
        }   
    }   
}
