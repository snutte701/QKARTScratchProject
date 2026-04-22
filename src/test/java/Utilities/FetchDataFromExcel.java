package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import ConstantsData.Constant;


public class FetchDataFromExcel {	
	@Test
	public static String getData(int row,int col) throws IOException,FileNotFoundException{
		FileInputStream fs=new FileInputStream(Constant.excelpath);
		XSSFWorkbook workbook=new XSSFWorkbook(fs);
		XSSFSheet sheet=workbook.getSheet("RegisterData");
		String value=sheet.getRow(row).getCell(col).toString();
		return value;
		
		
		
	}

}
