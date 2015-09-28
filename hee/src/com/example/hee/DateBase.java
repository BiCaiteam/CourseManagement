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
        
                String sql = "CREATE TABLE tb_test (_id INTEGER DEFAULT '1' NOT NULL PRIMARY KEY AUTOINCREMENT,class_jb TEXT  NOT NULL,class_ysbj TEXT  NOT NULL,title TEXT  NOT NULL,content_ysbj TEXT  NOT NULL)";
                
                db.execSQL(sql);//��Ҫ�쳣����
        }
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
 
				String sql = "drop table "+tbname;
                db.execSQL(sql);
                onCreate(db);
        }

        /**
         * �������
         */
        public long insert(String tname, int tage, String ttel){
                SQLiteDatabase db= getWritableDatabase();//��ȡ��дSQLiteDatabase����
                //ContentValues����map��������Ǽ�ֵ��
                       ContentValues contentValues = new ContentValues();
                       contentValues.put("tname", tname);
                contentValues.put("tage", tage);
                       contentValues.put("ttel", ttel);
                return db.insert(tbname, null, contentValues);
                }
        /**
         * ɾ����¼
         * @param _id
         */
        public void delete(String _id){
                SQLiteDatabase db= getWritableDatabase();
                db.delete(tbname, 
                        "_id=?", 
                        new String[]{_id});
        }
        /**
         * ���¼�¼�ģ�������ĺ���
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
         * ��ѯ�������� 
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