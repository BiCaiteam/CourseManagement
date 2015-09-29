package com.example.hee;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * ��������ʵ�ִ�assetsĿ¼��ȡ���ݿ��ļ�Ȼ��д��SDcard��,�����SDcard�д��ڣ��ʹ����ݿ⣬�����ھʹ�assetsĿ¼�¸��ƹ�ȥ
 * @author Big_Adamapple
 *
 */
public class SQLdm {  
    
  //���ݿ�洢·��  
  String filePath = "data/data/com.example.com/test1.db";  
  //���ݿ��ŵ��ļ��� data/data/com.main.jh ����  
  String pathStr = "data/data/com.example.com";  
    
  SQLiteDatabase database;   
  public  SQLiteDatabase openDatabase(Context context){  
    System.out.println("filePath:"+filePath);  
    File jhPath=new File(filePath);  
      //�鿴���ݿ��ļ��Ƿ����  
      if(jhPath.exists()){  
        Log.i("test1", "�������ݿ�");
        //������ֱ�ӷ��ش򿪵����ݿ�  
        return SQLiteDatabase.openOrCreateDatabase(jhPath, null);  
      }else{  
        //�������ȴ����ļ���  
        File path=new File(pathStr);  
        Log.i("test1", "pathStr="+path);
        if (path.mkdir()){  
          Log.i("test1", "�����ɹ�"); 
        }else{  
          Log.i("test1", "����ʧ��");
        };  
        try {  
          //�õ���Դ  
          AssetManager am= context.getAssets();  
          //�õ����ݿ��������  
          InputStream is=am.open("test1.db");  
          Log.i("test1", is+"");
          //�������д��SDcard����	
          FileOutputStream fos=new FileOutputStream(jhPath);  
          Log.i("test1", "fos="+fos);
          Log.i("test1", "jhPath="+jhPath);
          //����byte����  ����1KBдһ��  
          byte[] buffer=new byte[1024];  
          int count = 0;  
          while((count = is.read(buffer))>0){  
            Log.i("test1", "�õ�");
            fos.write(buffer,0,count);  
          }  
          //���رվͿ�����  
          fos.flush();  
          fos.close();  
          is.close();  
        } catch (IOException e) {  
          // TODO Auto-generated catch block  
          e.printStackTrace();  
          return null;
        }  
        //���û��������ݿ�  �����Ѿ�����д��SD�����ˣ�Ȼ����ִ��һ��������� �Ϳ��Է������ݿ���  
        return openDatabase(context);  
      }  
  }  
}