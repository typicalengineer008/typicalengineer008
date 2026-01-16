package utils;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.IOException;

public class ExcelReader {

	public static String readFromExcel(String file_path, String sheet_name, int row_No, int col_No) {
		FileInputStream file = null;
		String excelValue = null;
		Workbook workbook = null;
		try {
			file = new FileInputStream(file_path);
			workbook = new XSSFWorkbook(file);
			Sheet sheet = workbook.getSheet(sheet_name);
			DataFormatter dataFormatter = new DataFormatter();
			Row row = sheet.getRow(row_No);
			Cell cell = row.getCell(col_No);
			excelValue = dataFormatter.formatCellValue(cell);

		} catch (FileNotFoundException fileError) {
			fileError.printStackTrace();
		} catch (IOException InuptOuptputerror) {
			InuptOuptputerror.printStackTrace();
		} finally {
			if (workbook != null) {
				try {
					workbook.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (file != null) {
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return excelValue;
	}

}
