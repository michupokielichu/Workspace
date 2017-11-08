package com.gui.properties.generator.starter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Generator {
	private static Logger logger = Logger.getLogger(Generator.class);

	private static Map<String, String> typeMap = null;
	private static Map<String, String> pathMap = null;
	private static Map<String, String> btnOkMap = null;
	private static Map<String, String> btnAnnulMap = null;

	private static String OBJECT = "object";
	private static String TYPE = "type";
	private static String PATH = "path";
	private static String BTN_OK = "btnOk";
	private static String BTN_ANNUL = "btnAnnul";

	private static int COLLUMN_OBJECT = -1;
	private static int COLLUMN_TYPE = -1;
	private static int COLLUMN_PATH = -1;
	private static int COLLUMN_BTN_OK = -1;
	private static int COLLUMN_BTN_ANNUL = -1;

	public static void readXLSXFile() throws IOException {
		typeMap = new HashMap<>();
		pathMap = new HashMap<>();
		btnOkMap = new HashMap<>();
		btnAnnulMap = new HashMap<>();

		InputStream ExcelFileToRead = new FileInputStream("properties.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);

		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row;

		Iterator<Row> rows = sheet.rowIterator();
		while (rows.hasNext()) {
			row = (XSSFRow) rows.next();
			if (row.getRowNum() == 0) {
				Iterator<Cell> cellIter = row.cellIterator();
				while (cellIter.hasNext()) {
					Cell cell = cellIter.next();
					if (OBJECT.equals(cell.getStringCellValue())) {
						COLLUMN_OBJECT = cell.getColumnIndex();
					} else if (TYPE.equals(cell.getStringCellValue())) {
						COLLUMN_TYPE = cell.getColumnIndex();
					} else if (PATH.equals(cell.getStringCellValue())) {
						COLLUMN_PATH = cell.getColumnIndex();
					} else if (BTN_OK.equals(cell.getStringCellValue())) {
						COLLUMN_BTN_OK = cell.getColumnIndex();
					} else if (BTN_ANNUL.equals(cell.getStringCellValue())) {
						COLLUMN_BTN_ANNUL = cell.getColumnIndex();
					}
				}
			} else {
				String object = row.getCell(COLLUMN_OBJECT).getStringCellValue();
				String type = row.getCell(COLLUMN_TYPE).getStringCellValue();
				String path = row.getCell(COLLUMN_PATH).getStringCellValue();
				String btnOk = row.getCell(COLLUMN_BTN_OK).getStringCellValue();
				String btnAnnul = row.getCell(COLLUMN_BTN_ANNUL).getStringCellValue();
				if (row.getRowNum() > 1) {
					if (!(type == null || type.isEmpty())) {
						typeMap.put(object, type);
						pathMap.put(object, path);
					}
					if(!(btnOk == null || btnOk.isEmpty())) {
						btnOkMap.put(object, btnOk);
						btnAnnulMap.put(object, btnAnnul);
					}
				}
			}
		}
		wb.close();
	}

	public static void generate(boolean overridePackages, boolean overrideJava) {
		System.out.println(pathMap.size() + " paths to generate");
		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		for (String obj : pathMap.keySet()) {
			String concatenatedPath = s + "\\src\\" + pathMap.get(obj);
			File packag = new File(concatenatedPath);
			if (!packag.exists() || overridePackages) {
				if (packag.mkdirs()) {
					System.out.println("Multiple directories are created!");
				} else {
					System.out.println("Failed to create multiple directories!");
				}
			}
			String pathToFile = concatenatedPath + "\\" + obj + ".java";
			System.err.println(pathToFile);
			File file = new File(pathToFile);
			if (!file.exists() || overrideJava) {
				ClassGenerator gen = new ClassGenerator(obj, pathToFile, pathMap.get(obj), typeMap.get(obj));
			}
//			File btnOkFile = new File(pathname)
		}
	}
}
