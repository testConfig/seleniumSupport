package test.seleniumSupport;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetExcelConnection {
	XSSFWorkbook xBook;
	private void getExcelFile(String Filepath) {
		File xfile = new File(Filepath);
		try {
			FileInputStream FIS = new FileInputStream(xfile);
			xBook = new XSSFWorkbook(FIS);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	private String[][] getData(int SheetNum) {
		XSSFSheet xSheet = xBook.getSheetAt(SheetNum);
		int Row_Num = xSheet.getLastRowNum();
		int Cal_Num = xSheet.getRow(0).getLastCellNum();
		String[][] xData =new String[Row_Num][Cal_Num];
		for(int i=1;i<Row_Num;i++) {
			XSSFRow xRow = xSheet.getRow(i);
			for(int j=0;j<Cal_Num;j++) {
				XSSFCell xCell =xRow.getCell(j);
				String xValue = changeTheValue(xCell);
				xData[i][j]=xValue;
			}
		}
		return xData;
	}
	private String changeTheValue(XSSFCell xCell) {
		String xValue = null;
		Object re;
		if(xCell.getCellTypeEnum() == CellType.BLANK) {

			xValue ="";
		}
	else
	{
		if(xCell.getCellTypeEnum() == CellType.STRING) {
			xValue = xCell.getStringCellValue();
		}
		else if(xCell.getCellTypeEnum() == CellType.NUMERIC){
			re =(int) xCell.getNumericCellValue();
			xValue = re.toString();
			
		}
		}
		return xValue;
	}

}
