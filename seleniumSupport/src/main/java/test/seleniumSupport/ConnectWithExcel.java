package test.seleniumSupport;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ConnectWithExcel {
	XSSFWorkbook xBook;
	XSSFSheet xSheet;
	public void getConnection(String FilePath) {
		
		try {
			File xFile = new File(FilePath);
			FileInputStream input = new FileInputStream(xFile);
			 xBook = new XSSFWorkbook(input);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	public String[][] getData(int SheetNumber) {
		 xSheet = xBook.getSheetAt(SheetNumber);
		 int Row_Num = xSheet.getLastRowNum();
		 int Cal_Num = xSheet.getRow(0).getLastCellNum();
		 String[][] xData = new String[Row_Num][Cal_Num];
		 for(int i=0;i<Row_Num;i++) {
			 XSSFRow xRow = xSheet.getRow(i+1);
			 
			 for(int j=0;j<Cal_Num;j++) {
				 XSSFCell xCell = xRow.getCell(j);
				 String xValue = changeValue(xCell);
				 xData[i][j]=xValue;
			 }
		 }
		 
		
		return xData;
	}

	private String changeValue(XSSFCell xCell) {
		String result = null;
		Object value;
		if(xCell == null) {
			result = "";
		}
		else
		{
			if(xCell.getCellTypeEnum()==CellType.STRING) {
				result = xCell.getStringCellValue();
			}
			else if(xCell.getCellTypeEnum() == CellType.NUMERIC) {
				value = (int)xCell.getNumericCellValue();
				result = value.toString();
				
			}
		}
		return result;
	}
	
	public String ExcelPath(String fileName) {
		
		String path = System.getProperty("user.dir")+"\\ExcelFile\\"+fileName+".xlsx";
		return path;
	}
	
	
	public String[][] excelConnection(String fileName,int SheetNumber) {
		getConnection(ExcelPath(fileName));
		String[][] xData = getData(SheetNumber);
		return xData;
	}
	
	
	

	
}
