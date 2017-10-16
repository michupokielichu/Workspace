package com.gui.builder.translate;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.gui.builder.variables.ISettings;

public class Translator {
	private static Logger logger = Logger.getLogger(Translator.class);

	private static List<List<String>> itemList = null;

	public static void readXLSXFile() throws IOException {
		InputStream ExcelFileToRead = new FileInputStream("rsrc/translate.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);

		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row;
		String cell;

		Iterator<Row> rows = sheet.rowIterator();
		int rowNum = 0;
		List<String> languageList = new ArrayList<>();
		itemList = new ArrayList<>();
		while (rows.hasNext()) {
			row = (XSSFRow) rows.next();
			Iterator<Cell> cells = row.cellIterator();
			String outputRow = "";
			List<String> rowList = new ArrayList<>();
			while (cells.hasNext()) {
				cell = ((XSSFCell) cells.next()).getStringCellValue();
				if (rowNum == 0 && !cell.isEmpty()) {
					languageList.add(cell);
				} else {
					rowList.add(cell);
				}
				outputRow += cell + " ";
			}
			itemList.add(rowList);
			rowNum++;
		}
		for (List<String> rowList : itemList) {
			for (int iter = 2; iter < rowList.size(); iter++) {
				generateMap(languageList.get(iter - 2), rowList.get(0), rowList.get(1), rowList.get(iter));
			}
		}
		wb.close();
	}
	private static Map<String, Map<String, Map<String, String>>> translateMap = new HashMap<>();
	
	private static void generateMap(String language, String panelId, String labelId, String label) {
		if (!translateMap.containsKey(language)) {
			translateMap.put(language, new HashMap<>());
		}
		Map<String, Map<String, String>> panelMap = translateMap.get(language);
		if (!panelMap.containsKey(panelId)) {
			panelMap.put(panelId, new HashMap<>());
		}
		Map<String, String> itemMap = panelMap.get(panelId);
		if (!itemMap.containsKey(labelId)) {
			itemMap.put(labelId, label);
		} 
	}

	public static String getLabel(String panelId, String labelId) {
		if (panelId == null || labelId == null) {
			return "";
		}
		Map<String, String> map = translateMap.get(ISettings.LANGUAGE).get(panelId);
		return map != null ? map.get(labelId) : "";
	}

}
