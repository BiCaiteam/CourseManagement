package com.example.hee;
import java.util.ArrayList;   
import java.util.HashMap;   
 
import android.app.Activity;   
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;   
import android.view.Window;
import android.widget.AdapterView;   
import android.widget.AdapterView.OnItemClickListener;   
import android.widget.GridView;   
import android.widget.SimpleAdapter;
import android.widget.TextView;
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
    	  String id ;String shangjixueshi;String xueshi;String renshu; String qizhizhouxu;String renkejiaoshi;String beizhu; String zhuanye; String xuanxiuleixing;String kechengmingcheng; String shiyanxueshi; String xuefen;String[] items=new String[12];
 SQLiteDatabase mSQLiteDatabase = this.openOrCreateDatabase("test",MODE_PRIVATE,null);
    	// SQLdm s = new SQLdm();
        // SQLiteDatabase mSQLiteDatabase =s.openDatabase(getApplicationContext()); 
    	 
    	    String CREATE_TABLE =  "create table first(id       varchar(50)     null,                 zhuanye                  varchar(50)          null, renshu                 varchar(50)                  null, kechengmingcheng                 varchar(50)          null,xuanxiuleixing              varchar(50)          null,  xuefen             varchar(50)               null,xueshi                   varchar(50)                  null,shiyanxueshi                varchar(50)                  null,shangjixueshi                varchar(50)                  null, qizhizhouxu                 varchar(50)          null,renkejiaoshi                varchar(50)          null,beizhu                varchar(50)          null)";
    	   mSQLiteDatabase.execSQL(CREATE_TABLE);
 
    	 
          String INSERT_DATA = "insert into first(id,zhuanye,renshu,kechengmingcheng ,xuanxiuleixing  , xuefen , xueshi ,shiyanxueshi ,shangjixueshi  , qizhizhouxu , renkejiaoshi , beizhu) values ('2012','计算机科学与技术','87','Internet技术与协议分析实验','实践选修','1','24',null,null,null,null,null)";
          mSQLiteDatabase.execSQL(INSERT_DATA);
         String INSERT_DATA1 = "insert into first(id,zhuanye,renshu,kechengmingcheng ,xuanxiuleixing  , xuefen , xueshi ,shiyanxueshi ,shangjixueshi  , qizhizhouxu , renkejiaoshi , beizhu) values ('2012','计算机科学与技术','87','IT企业项目实训','实践选修','2','48',null,null,null,null,null)";
          mSQLiteDatabase.execSQL(INSERT_DATA1);
          String INSERT_DATA2 = "insert into first(id,zhuanye,renshu,kechengmingcheng ,xuanxiuleixing  , xuefen , xueshi ,shiyanxueshi ,shangjixueshi  , qizhizhouxu , renkejiaoshi , beizhu) values ('2012','计算机科学与技术','87','多媒体通讯技术','专业选修','2','32',null,null,null,null,null)";
          mSQLiteDatabase.execSQL(INSERT_DATA2);
          String INSERT_DATA3 = "insert into first(id,zhuanye,renshu,kechengmingcheng ,xuanxiuleixing  , xuefen , xueshi ,shiyanxueshi ,shangjixueshi  , qizhizhouxu , renkejiaoshi , beizhu) values ('2012','计算机科学与技术','87','分布式操作系统','专业选修','2','32',null,null,null,null,null)";
          mSQLiteDatabase.execSQL(INSERT_DATA3);
          String INSERT_DATA4 = "insert into first(id,zhuanye,renshu,kechengmingcheng ,xuanxiuleixing  , xuefen , xueshi ,shiyanxueshi ,shangjixueshi  , qizhizhouxu , renkejiaoshi , beizhu) values ('2012','计算机科学与技术','87','分布式系统','专业选修','2','32',null,null,null,null,null)";
          mSQLiteDatabase.execSQL(INSERT_DATA4);
          String INSERT_DATA5 = "insert into first(id,zhuanye,renshu,kechengmingcheng ,xuanxiuleixing  , xuefen , xueshi ,shiyanxueshi ,shangjixueshi  , qizhizhouxu , renkejiaoshi , beizhu) values ('2012','计算机科学与技术','87','广域网技术实验','实践选修','1','24',null,null,null,null,null)";
          mSQLiteDatabase.execSQL(INSERT_DATA5);
          String INSERT_DATA6 = "insert into first(id,zhuanye,renshu,kechengmingcheng ,xuanxiuleixing  , xuefen , xueshi ,shiyanxueshi ,shangjixueshi  , qizhizhouxu , renkejiaoshi , beizhu) values ('2012','计算机科学与技术','87','计算机仿真技术','专业选修','2','32','12',null,null,null,null)";
          mSQLiteDatabase.execSQL(INSERT_DATA6);
          String INSERT_DATA7 = "insert into first(id,zhuanye,renshu,kechengmingcheng ,xuanxiuleixing  , xuefen , xueshi ,shiyanxueshi ,shangjixueshi  , qizhizhouxu , renkejiaoshi , beizhu) values ('2012','计算机科学与技术','87','计算机外部设备','专业选修','2','32',null,null,null,null,null)";
          mSQLiteDatabase.execSQL(INSERT_DATA7);
          String INSERT_DATA8 = "insert into first(id,zhuanye,renshu,kechengmingcheng ,xuanxiuleixing  , xuefen , xueshi ,shiyanxueshi ,shangjixueshi  , qizhizhouxu , renkejiaoshi , beizhu) values ('2012','计算机科学与技术','87','软件可靠性与可信软件','专业选修','2','32',null,null,null,null,null)";
          mSQLiteDatabase.execSQL(INSERT_DATA8);
          String INSERT_DATA9 = "insert into first(id,zhuanye,renshu,kechengmingcheng ,xuanxiuleixing  , xuefen , xueshi ,shiyanxueshi ,shangjixueshi  , qizhizhouxu , renkejiaoshi , beizhu) values ('2012','计算机科学与技术','87',' 网络工程应用开发技术','专业选修','2','32',null,null,null,null,null)";
          mSQLiteDatabase.execSQL(INSERT_DATA9);
          String INSERT_DATA10 = "insert into first(id,zhuanye,renshu,kechengmingcheng ,xuanxiuleixing  , xuefen , xueshi ,shiyanxueshi ,shangjixueshi  , qizhizhouxu , renkejiaoshi , beizhu) values ('2012','计算机科学与技术','87','云计算','专业选修','2','32',null,null,null,null,null)";
          mSQLiteDatabase.execSQL(INSERT_DATA10);
          String INSERT_DATA11 = "insert into first(id,zhuanye,renshu,kechengmingcheng ,xuanxiuleixing  , xuefen , xueshi ,shiyanxueshi ,shangjixueshi  , qizhizhouxu , renkejiaoshi , beizhu) values ('2013','计算机科学与技术','1',' EDA技术','专业方向（限选）1','2','32',null,16,null,null,null)";
          mSQLiteDatabase.execSQL(INSERT_DATA11);
          String INSERT_DATA12 = "insert into first(id,zhuanye,renshu,kechengmingcheng ,xuanxiuleixing  , xuefen , xueshi ,shiyanxueshi ,shangjixueshi  , qizhizhouxu , renkejiaoshi , beizhu) values ('2013','计算机科学与技术','1',' Java语言程序设计','实践选修','1.5','36',null,18,null,null,null)";
          mSQLiteDatabase.execSQL(INSERT_DATA12);
          String INSERT_DATA13 = "insert into first(id,zhuanye,renshu,kechengmingcheng ,xuanxiuleixing  , xuefen , xueshi ,shiyanxueshi ,shangjixueshi  , qizhizhouxu , renkejiaoshi , beizhu) values ('2013','计算机科学与技术','1',' Linux操作系统设计实践','实践选修','1.5','32',null,null,null,null,null)";
          mSQLiteDatabase.execSQL(INSERT_DATA13);
          String INSERT_DATA14 = "insert into first(id,zhuanye,renshu,kechengmingcheng ,xuanxiuleixing  , xuefen , xueshi ,shiyanxueshi ,shangjixueshi  , qizhizhouxu , renkejiaoshi , beizhu) values ('2013','计算机科学与技术','1','Web程序设计','专业方向（限选）2','2','32',null,8,null,null,null)";
          mSQLiteDatabase.execSQL(INSERT_DATA14);
    	  Cursor c = mSQLiteDatabase.rawQuery("SELECT * FROM  first", null);  
          while (c.moveToNext()) {  
        	  id=c.getString(c.getColumnIndex("id"));
		       shangjixueshi=c.getString(c.getColumnIndex("shangjixueshi"));
		     xueshi=c.getString(c.getColumnIndex("xueshi"));
		     renshu=c.getString(c.getColumnIndex("renshu"));
		        qizhizhouxu = c.getString(c.getColumnIndex("qizhizhouxu"));
		       renkejiaoshi= c.getString(c.getColumnIndex("renkejiaoshi"));
		      beizhu= c.getString(c.getColumnIndex("beizhu"));
		     zhuanye = c.getString(c.getColumnIndex("zhuanye"));
		        xuanxiuleixing = c.getString(c.getColumnIndex("xuanxiuleixing"));
		        kechengmingcheng = c.getString(c.getColumnIndex("kechengmingcheng"));
		     shiyanxueshi = c.getString(c.getColumnIndex("shiyanxueshi"));
		      xuefen=c.getString(c.getColumnIndex("xuefen"));
		       
		    items[0]=id; items[1]=zhuanye;items[2]=renshu; items[3]=kechengmingcheng; items[4]=xuanxiuleixing; items[5]=xuefen; items[6]=xueshi; items[7]=shiyanxueshi;items[8]=shangjixueshi;items[9]=qizhizhouxu;items[10]=renkejiaoshi;items[11]=beizhu;
		       for (String strText:items) {
                    HashMap<String, String> map = new HashMap<String, String>();
                    map.put("ItemText",strText);
                    srcTable.add(map);
               }    

            saTable.notifyDataSetChanged();
		   
          }  
          c.close(); 
            
          //删除数据  
          //mSQLiteDatabase.delete("first", "id > ?", new String[]{"35"});  
          mSQLiteDatabase.execSQL("drop table first");
          //关闭当前数据库  
          mSQLiteDatabase.close();  
            
          //删除test.db数据库  
        
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
