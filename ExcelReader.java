package com.parameters;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
public class ExcelReader {
    private Workbook workbook;
    private Sheet sheet;
    public ExcelReader(String filePath, String sheetName) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            workbook = WorkbookFactory.create(fis);
            sheet = workbook.getSheet(sheetName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String getCellData(int rowNum, int colNum) {
        return sheet.getRow(rowNum).getCell(colNum).toString();
    }
    public int getRowCount() {
        return sheet.getLastRowNum();
    }
    public int getColCount() {
        return sheet.getRow(0).getLastCellNum();
    }

    public Object[][] getSheetData() {
        int rows = getRowCount();
        int cols = getColCount();
        Object[][] data = new Object[rows][cols];
        for (int i = 1; i <= rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i - 1][j] = getCellData(i, j);
            }
        }
        return data;
    }
}
