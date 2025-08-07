package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//DataProvider 1
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException{
		String path =".\\OpenCart\\TestData\\Opencart_LoginData.xlsx"; //Taking xl file from the testdata
		excelUtility xlutil = new excelUtility(path);
		
		int totalrow=xlutil.getRowCount("sheet1");
		int totalcolum=xlutil.getCellCount("sheet1",1);
		
		String logindata[][]=new String[totalrow][totalcolum];
		
		for(int i=1; i<=totalrow; i++) {
			for(int j=0; j<totalcolum; j++) {
				logindata[i-1][j]=xlutil.getCellData("sheet", i, j);
			}
		}
		
		return logindata;
	}
	
	//DataProvider 2
	
	//DataProvider 3
	
	//DataProvider 4

}
