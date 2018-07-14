package test.seleniumSupport;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ConnectWithExcel {
	XSSFWorkbook xBook;
	public void getConnection(String FilePath) {
		
		try {
			File xFile = new File(FilePath);
			FileInputStream input = new FileInputStream(xFile);
			XSSFWorkbook xBook = new XSSFWorkbook(input);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void getData(int SheetNumber) {
		XSSFSheet xSheet = xBook.getSheetAt(SheetNumber);
		
		
	}
}
