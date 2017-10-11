package com.gui.builder.translate;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Translator {
	private static Logger logger = Logger.getLogger(Translator.class);

	public static void readXLSXFile() throws IOException {
		InputStream ExcelFileToRead = new FileInputStream("rsrc/translate.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);


		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row;
		XSSFCell cell;

		Iterator<Row> rows = sheet.rowIterator();
		System.out.println();
		logger.debug("Translator:");
		while (rows.hasNext()) {
			row = (XSSFRow) rows.next();
			Iterator<Cell> cells = row.cellIterator();
			String outputRow="";
			while (cells.hasNext()) {
				cell = (XSSFCell) cells.next();
				outputRow += cell.getStringCellValue() + " ";
			}
			logger.debug(outputRow);
		}
		System.out.println();
		wb.close();
	}

}
