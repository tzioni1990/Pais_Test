package dp;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Data {
	
	@DataProvider(name="dataFromExcel")
	public static Object[][] dataFromExcel() throws IOException{
		Object[][] myDataObject=Excel.getDataFromExcel("C:\\Users\\tzion\\OneDrive\\שולחן העבודה\\NewWorkspace\\P4.xlsx", "גיליון1");
		return myDataObject;
	}

}
