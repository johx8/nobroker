package com.parameters;

public class DataProvider {
	@org.testng.annotations.DataProvider(name="userid")
	public static Object[][] getValidData(){
		ExcelReader excelReader = new ExcelReader("src\\test\\resource\\ExcelData\\data.xlsx","Sheet1");
		return excelReader.getSheetData();
		
	}
	
//	@DataProvider(name="addProfileInvalidData")
//	public static Object[][] getInvalidData(){
//		ExcelReader excelReader = new ExcelReader("src\\test\\resource\\ExcelData\\ProfileData.xlsx", "Sheet2");
//		return excelReader.getSheetData();
}


