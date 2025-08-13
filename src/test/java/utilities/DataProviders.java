package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//DataProvider 1
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException{
		String path =".\\TestData\\Opencart_LoginData.xlsx"; //Taking xl file from the testdata
		ExcelUtility xlutil = new ExcelUtility(path);
		
		int totalrow=xlutil.getRowCount("sheet1");
		int totalcolum=xlutil.getCellCount("sheet1",1);
		
		String logindata[][]=new String[totalrow][totalcolum];
		
		for(int i=1; i<=totalrow; i++) {  //1 read data from the XL sheet storing 
			
			for(int j=0; j<totalcolum; j++) { //0 i is row, j is column 
				
				logindata[i-1][j]=xlutil.getCellData("sheet1", i, j);
			}
		}
		
		return logindata; // returning 2D Array 
	}
	
	//DataProvider 2
	
	//DataProvider 3
	
	//DataProvider 4

}
