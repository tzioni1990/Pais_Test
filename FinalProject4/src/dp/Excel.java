package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Excel {
	
	public static Object[][] getDataFromExcel(String filePath, String sheetName) throws IOException{
		Object[][] tableArray=null;
		DataFormatter formatter=new DataFormatter();
		FileInputStream excelFile=new FileInputStream(filePath);
		XSSFWorkbook excelWBook=new XSSFWorkbook(excelFile);
		XSSFSheet excelWSheet = excelWBook.getSheet(sheetName);
		int row=2, col=10;
		String value;
		XSSFCell cell;
		try {
			tableArray=new Object[row][col];
			for(int i=0; i<row; i++)
				for(int j=0; j<col; j++) {
					cell=excelWSheet.getRow(i+1).getCell(j+1);
					value=formatter.formatCellValue(cell);
					tableArray[i][j]=value;
				}
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return tableArray;
	}

}
