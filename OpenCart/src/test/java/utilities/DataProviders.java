package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	
	@DataProvider(name="loginData")
	public String[][] getData() throws IOException{
		
		String path=".\\testData\\Book1.xlsx";
		
		ExcelUtility xl=new ExcelUtility(path);
		
		int totalRows=xl.getRow("sheet1");
		int totalCol=xl.getCellCount("sheet1", 1);
		
		String[][] loginData=new String[totalRows][totalCol];
		for(int i=1;i<=totalRows;i++) {
			for(int j=0;j<totalCol;j++) {
				loginData[i-1][j]=xl.getCellData("sheet1", i, j);
				
			}
		}
		
		return loginData;
	}
}
