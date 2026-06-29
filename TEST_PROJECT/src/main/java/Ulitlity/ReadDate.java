package Ulitlity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDate {

	//This method read the data from property file
	public static String readPropertyFile(String value) throws Exception
	{
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\TEST_PROJECT\\TestDate\\config.properties");
		prop.load(file);
		return prop.getProperty(value);
	}
	
	//Test method read the data from property file
	
	public static String readExcelFile(int rowNum, int colNum) throws Exception
	{
		
		FileInputStream file = new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\TEST_PROJECT\\TestDate\\TestDate.xlsx");
		Sheet excelSheet = WorkbookFactory.create(file).getSheet("Sheet1");
		String value = excelSheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		return value;
	}
}
