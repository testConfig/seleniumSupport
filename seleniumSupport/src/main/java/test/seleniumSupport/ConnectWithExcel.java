package test.seleniumSupport;

import java.io.File;
import java.io.FileInputStream;
<<<<<<< HEAD
=======
import java.io.FileNotFoundException;

>>>>>>> branch 'master' of https://github.com/testConfig/seleniumSupport.git
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
<<<<<<< HEAD
		XSSFSheet xSheet = xBook.getSheetAt(SheetNumber);
		int Row_Num = xSheet.getLastRowNum();
		int Cal_Num = xSheet.getRow(0).getLastCellNum();
		String[][] xData = new String[Row_Num][Cal_Num];
		for(int i=0; i<Row_Num-1;i++) {
			XSSFRow row = xSheet.getRow(i);
			for(int j=0;j<Cal_Num;j++) {
				XSSFCell cell = row.getCell(j);
				String cellValue = changeCellValue(cell);
				cellValue =xData[i][j];
			}
			
		}
=======
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
		 
>>>>>>> branch 'master' of https://github.com/testConfig/seleniumSupport.git
		
		return xData;
<<<<<<< HEAD
	}

	private String changeCellValue(XSSFCell cell) {
		String result = null;
		Object value;
			if(cell == null) {
				result="";
				
			}
			else {
				
				if(cell.getCellTypeEnum()== CellType.STRING)
				{
					result =cell.getStringCellValue();
				}
				else if(cell.getCellTypeEnum() == CellType.NUMERIC) {
					value =(int) cell.getNumericCellValue();
					result = value.toString();
				}
				else {
					System.out.println("There have some proble with data Type config");
				}
				
			}
			
			return result;
=======
>>>>>>> branch 'master' of https://github.com/testConfig/seleniumSupport.git
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
