package meiqin520;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;




public class StuService {
    /**
     * 查询stu表中所有的数据
     * @return 
     */
    public static List<Stuenty> getAllByDb(){
        List<Stuenty> list=new ArrayList<Stuenty>();
        try {
        	Dbhelper db=new Dbhelper();
            String sql="select * from stu";
            ResultSet rs= db.Search(sql, null);
            while (rs.next()) {
            	String id=rs.getString("id");
            	String zhuanye=rs.getString("zhuanye");
            	 String kechengmingcheng=rs.getString("kechengmingcheng");
            	 int renshu=rs.getInt("zrenshu");
            	 String xuanxiuneixing=rs.getString("xuanxiuneixing");
            	 int xuefen=rs.getInt("xuefen");
            	 int xueshi=rs.getInt("xueshi");
            	 int shangjixueshi=rs.getInt("shangjixueshi");
            	 int shiyanxueshi=rs.getInt("shiyanxueshi");
            	 String qizhizhouqi=rs.getString("qizhizhuoqi");
            	 String renkejiaoshi=rs.getString("renkejiaoshi");
            	 String beizhu=rs.getString("beizhu");
                
                list.add(new Stuenty(id, zhuanye, renshu, kechengmingcheng, xuanxiuneixing, xuefen, xueshi,
                		shangjixueshi, shiyanxueshi, qizhizhouqi, renkejiaoshi, beizhu));
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
    
    /**
     * 查询指定目录中电子表格中所有的数据
     * @param file 文件完整路径
     * @return
     */
    public static List<Stuenty> getAllByExcel(String file){
        List<Stuenty> list=new ArrayList<Stuenty>();
        try {
            Workbook rwb=Workbook.getWorkbook(new File(file));
            Sheet rs=rwb.getSheet("Test Shee 1");//或者rwb.getSheet(0)
            int clos=rs.getColumns();//得到所有的列
            int rows=rs.getRows();//得到所有的行
            
            System.out.println(clos+" rows:"+rows);
            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < clos; j++) {
                    //第一个是列数，第二个是行数
                	String id=rs.getCell(j++, i).getContents();//默认最左边编号也算一列 所以这里得j++
                	String zhuanye=rs.getCell(j++, i).getContents();
                         String renshu=rs.getCell(j++, i).getContents();
                	 String kechengmingcheng=rs.getCell(j++, i).getContents();
                	 String xuanxiuneixing=rs.getCell(j++, i).getContents();
                	 String xuefen=rs.getCell(j++, i).getContents();
                	 String xueshi=rs.getCell(j++, i).getContents();
                	 String shangjixueshi=rs.getCell(j++, i).getContents();
                	 String shiyanxueshi=rs.getCell(j++, i).getContents();
                	 String qizhizhouqi=rs.getCell(j++, i).getContents();
                	 String renkejiaoshi=rs.getCell(j++, i).getContents();
                	 String beizhu=rs.getCell(j++, i).getContents();
                    //System.out.println("id:"+id+" name:"+name+" sex:"+sex+" num:"+num);
                    list.add(new Stuenty(id, zhuanye, renshu, kechengmingcheng, 
                    		xianxiuneixing, xuefen , xueshi, shangjixueshi , 
                    		shiyanxueshi , qishizhouqi, renkelaoshi, beizhu));
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        return list;
        
    }
    
    /**
     * 通过Id判断是否存在
     * @param id
     * @return
     */

    
    
    
}