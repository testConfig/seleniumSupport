import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import test.seleniumSupport.ConnectWithExcel;

public class ReadExcelData {
//
//	public static void main(String[] args) {
//		ConnectWithExcel xData = new ConnectWithExcel();
//		String[][] file =xData.excelConnection("InputFormSubmitte", 0);
//		for(int i=1; i<5;i++) {
//		String firstName =file[i][0];
//		String lastName = file[i][1];
//		System.out.println(firstName);
//		System.out.println(lastName);
//		}
//		
//
//	}
	
	
	
	
	@Test(dataProvider="data")
	public void printData(String FirstName,String LastName,String EmailAdd,String PhoneNum,	String HomeAdd, String City,String StateNam,String ZipCode,
		String WebAdd,String comment) {
		
		String printData = "FirstName is : "+ FirstName+ "Last Name is: "+LastName+ "Email add is :"+EmailAdd +"Phone Number : "+PhoneNum+"Home City : "+HomeAdd+ "city name :"+City
			+"StateNam :"+ StateNam + "ZipCode is: "+ZipCode +"Web Add is :" +WebAdd+ "comment is :"+ comment	;
		System.out.println(printData);

		
	}
	
	@DataProvider(name="data")
	String[][] getData() {
		ConnectWithExcel xData= new ConnectWithExcel();
		String[][] data =xData.excelConnection("InputFormSubmitte", 0);
		return data;
		
	}

}
