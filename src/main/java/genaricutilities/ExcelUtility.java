package genaricutilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String getCellData(String sheet, int rowNum, int cellNum) throws Throwable {

		FileInputStream fis = new FileInputStream(IPathUtility.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		Row row = sh.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		DataFormatter data = new DataFormatter();
		return data.formatCellValue(cell);

	}
}
