package com.example.hee;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DateBase extends SQLiteOpenHelper{

public DateBase(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}
String tbname="edb";

        public void onCreate(SQLiteDatabase db) {
                String sql =  "create table edb (id      int    null, nianji      char varying(8)      null,  zhuanye                  varchar(20)          null, renshu                 int                  null, kechengmingcheng                 varchar(50)          null,xuanxiuleixing              varchar(20)          null,  xuefen              float                null,xueshi                   int                  null,shiyanxueshi                int                  null,shangjixueshi                 int                  null, qizhizhouxu                 varchar(30)          null,renkejiaoshi                varchar(12)          null,beizhu                varchar(50)          null)";
                
                db.execSQL(sql);//需要异常捕获
        }
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
 
				String sql = "drop table "+tbname;
                db.execSQL(sql);
                onCreate(db);
        }
       /* zhuanye  
        renshu                
        kechengmingcheng   
        ,xuanxiuleixing        
        xuefen             
        xueshi                  
        shiyanxueshi               
        shangjixueshi                
         qizhizhouxu               
         renkejiaoshi              
         beizhu              */
        /**
         * 添加数据
         */
        public void insert(int id,String zhuanye,int renshu,String kechengmingcheng ,String xuanxiuleixing  , float xuefen ,int xueshi ,int shiyanxueshi ,int shangjixueshi  ,String qizhizhouxu ,String renkejiaoshi ,String beizhu){
                SQLiteDatabase db= getWritableDatabase();//获取可写SQLiteDatabase对象
                //ContentValues类似map，存入的是键值对
                String sql = "insert into user(zhuanye,renshu,kechengmingcheng ,xuanxiuleixing  , xuefen , xueshi ,shiyanxueshi ,shangjixueshi  , qizhizhouxu , renkejiaoshi , beizhu) values ('" + id + "','" + zhuanye + ",'" + renshu + "','" + kechengmingcheng + "','" + xuanxiuleixing + "','" + xuefen + "','" + xueshi + "'','" + shiyanxueshi + "'','" + shangjixueshi + "'','" + qizhizhouxu  + "'','" +  renkejiaoshi + "'', '" +   beizhu + "'' beizhu)";//插入操作的SQL语句
                		db.execSQL(sql);//执行SQL语句
                }
        /**
         * 删除记录
         * @param _id
         */
        public void delete(String _id){
                SQLiteDatabase db= getWritableDatabase();
                db.delete(tbname, 
                        "_id=?", 
                        new String[]{_id});
        }
        /**
         * 更新记录的，跟插入的很像
         */
        public void update(String _id,String tname, int tage, String ttel){
                SQLiteDatabase db= getWritableDatabase();
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("tname", tname);
                        contentValues.put("tage", tage);
                       contentValues.put("ttel", ttel);
                     db.update(tbname, contentValues, 
                        "_id=?", 
                        new String[]{_id});
        }
        /**
         * 查询所有数据 
         * @return Cursor
         */
        public Cursor select(){
                SQLiteDatabase db = getReadableDatabase();
                        return db.query(
                                tbname, 
                                new String[]{"_id","tname","tage","ttel","taddr"}, 
                                null, 
                                null, null, null, "_id desc");
        }
}