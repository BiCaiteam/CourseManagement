package meiqin520;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


			try {

				/**
				 * 后续考虑问题,比如Excel里面的图片以及其他数据类型的读取
				 **/
				InputStream is = new FileInputStream("C:\\Users\\yes\\Desktop\\计算机 1.xls");

				Workbook book = Workbook
						.getWorkbook(new File("C:\\Users\\yes\\Desktop\\计算机 1.xls"));
				book.getNumberOfSheets();
				// 获得第一个工作表对象
				Sheet sheet = book.getSheet(0);
				int Rows = sheet.getRows();
				int Cols = sheet.getColumns();
				System.out.println("当前工作表的名字:" + sheet.getName());
				System.out.println("总行数:" + Rows);
				System.out.println("总列数:" + Cols);
				for (int i = 0; i < Cols; ++i) {
					for (int j = 0; j < Rows; ++j) {
						// getCell(Col,Row)获得单元格的值
						System.out
								.print((sheet.getCell(i, j)).getContents() + "\t");
					}
					System.out.print("\n");
				}
				// 得到第一列第一行的单元格
				Cell cell1 = sheet.getCell(0, 0);
				String result = cell1.getContents();
				System.out.println(result);
				book.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}


