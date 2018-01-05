package com.gui.properties.generator.starter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
	private static Map<String, String> locationMap = null;

	private static String ID = "id";
	private static String LOCATION = "location";
	private static String TYPE = "type";

	private static int COLLUMN_OBJECT = -1;
	private static int COLLUMN_TYPE = -1;
	private static int COLLUMN_PATH = -1;

	public static void readXLSXFile(String file) throws IOException {
		typeMap = new HashMap<>();
		locationMap = new HashMap<>();

		InputStream ExcelFileToRead = new FileInputStream(file);
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
					if (ID.equals(cell.getStringCellValue())) {
						COLLUMN_OBJECT = cell.getColumnIndex();
						logger.info("COLLUMN_OBJECT: " + COLLUMN_OBJECT);
					} else if (TYPE.equals(cell.getStringCellValue())) {
						COLLUMN_TYPE = cell.getColumnIndex();
						logger.info("COLLUMN_TYPE: "+COLLUMN_TYPE);
					} else if (LOCATION.equals(cell.getStringCellValue())) {
						COLLUMN_PATH = cell.getColumnIndex();
						logger.info("COLLUMN_PATH: "+COLLUMN_PATH);
					}
				}
			} else if(row!=null && row.getCell(COLLUMN_OBJECT)!=null){
				String object = row.getCell(COLLUMN_OBJECT).getStringCellValue();
				String type = row.getCell(COLLUMN_TYPE).getStringCellValue();
				String path = row.getCell(COLLUMN_PATH).getStringCellValue();
				if (row.getRowNum() > 1) {
					if (!(type == null || type.isEmpty())) {
						typeMap.put(object, type);
						locationMap.put(object, path);
					}
				}
			}
		}
		wb.close();
	}

	public static void generate(boolean overridePackages, boolean overrideJava) {
		System.out.println(locationMap.size() + " paths to generate");
		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		for (String obj : locationMap.keySet()) {
			String concatenatedPath = s + "/src/main/java/" + locationMap.get(obj).replace(".", "/");
			File packag = new File(concatenatedPath);
			if (!packag.exists() || overridePackages) {
				if (packag.mkdirs()) {
					System.out.println("Multiple directories are created!");
				} else {
					System.out.println("Failed to create multiple directories!");
				}
			}
			String pathToFile = concatenatedPath + "/" + obj + ".java";
			System.err.println(pathToFile);
			File file = new File(pathToFile);
			if (!file.exists() || overrideJava) {
				ClassGenerator gen = new ClassGenerator(obj, pathToFile, locationMap.get(obj), typeMap.get(obj));
			}
		}
	}
	
//	private static void createDirectory(List<String> path) {
//		if (!path.isEmpty()) {
//			File dir = new File(path.get(0));
//			if(!dir.exists()) {
//				dir.mkdirs();
//			}
//			dir.
//			path.remove(0);
//			createDirectory(path);
//		}
//	}
}
