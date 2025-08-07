package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelUtility {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	String path;
	
	public excelUtility(String path) {
		this.path=path;
	}
	
	
	//To get Row Count
	public int getRowCount(String sheetname) throws IOException
	{
		fi = new FileInputStream(path); 
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetname);
		int rowcount=sheet.getLastRowNum();
		fi.close();
		workbook.close();
		return rowcount;	
	}
	
	//To get Cell Count
	public  int getCellCount(String sheetname, int rownum) throws IOException
	{
		
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetname);
		row = sheet.getRow(rownum);
		int cellcount = row.getLastCellNum();
		fi.close();
		workbook.close();
		return cellcount;
	}
	
	//To get/read CellData
	public  String getCellData(String sheetname, int rownum, int colum ) throws IOException
	{
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetname);
		row = sheet.getRow(rownum);
		cell = row.getCell(colum);
				
		String data;	
		try {
			//data=cell.toString();
			DataFormatter formatter = new DataFormatter();
			data = formatter.formatCellValue(cell);//Return the formatted value of cell as a string 
			}
		catch(Exception e)
		{
			data = "";
		}
		
		fi.close();
		workbook.close();
		return data;
	}
	
	//To Write CellData
	public void setCellData(String sheetname, int rownum, int colum, String data ) throws IOException
	{
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetname);
		row = sheet.getRow(rownum);
		cell = row.createCell(colum);
		cell.setCellValue(data);
		fo = new FileOutputStream(sheetname);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
	
		
	}
	
	//To Fill Cell with Green Color
	public  void fillGreenColor(String sheetname, int rownum, int colum ) throws IOException
	{
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetname);
		row = sheet.getRow(rownum);
		cell = row.getCell(colum);
		
		style=workbook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		fo = new FileOutputStream(sheetname);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
	}

	
	public  void fillRedColor(String sheetname, int rownum, int colum ) throws IOException
	{
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetname);
		row = sheet.getRow(rownum);
		cell = row.getCell(colum);
		
		style=workbook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		fo = new FileOutputStream(sheetname);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
