package seleniumSupport;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.checkerframework.checker.formatter.FormatUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class getExcel {
	WebDriver Driver;
	XSSFWorkbook xBook;
	private void excelpath(String FilePath) {
		File xfile = new File(FilePath);
		try {
			FileInputStream FIS = new FileInputStream(xfile);
			 xBook = new XSSFWorkbook(FIS);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	private String[][] excelData(int sheetNum) {
		XSSFSheet xSheet = xBook.getSheetAt(sheetNum);
		
		int Row_Num = xSheet.getLastRowNum();
		int Cal_Num = xSheet.getRow(0).getLastCellNum();
		String[][] xData = new String[Row_Num][Cal_Num];
		for(int i=1;i<Row_Num;i++) {
			XSSFRow xRow = xSheet.getRow(i);
			for(int j=0; j<Cal_Num;j++) {
				XSSFCell xCell = xRow.getCell(j);
				String finalValue = changeValue(xCell);
				xData[i][j]= finalValue; 
			}
			
		}
		return xData;
	}


	private String changeValue(XSSFCell xCell) {
	String	result = null;
	Object value;
		if(xCell == null) {
			result = "";
		}
		else {
			if(xCell.getCellTypeEnum()==CellType.STRING) {
				result =xCell.getStringCellValue();
			}
			else if(xCell.getCellTypeEnum() == CellType.NUMERIC) {
			 value =(int) xCell.getNumericCellValue();	
				result =value.toString();
			}
		}
		return result;
	}
	
	public void takePic(File destDir) {
		
		File Screen = ((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyDirectory(Screen, destDir);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
