package com.gui.properties.generator.starter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class ClassGenerator {

	private static String COMMENT = "//GENERATED CLASS, DO NOT CHANGE!!";
	private static String PACKAGE = "package ";
	private static String IMPORT = "import ";
	private static String PUBLIC_CLASS = "public class ";
	private static String EXTENDS = " extends ";
	private static String LEFT_BRACKET = " { ";
	private static String RIGHT_BRACKET = "} ";
	private static String SEPARATOR = "; ";
	private static String LINE_SEPARATOR = System.lineSeparator();
	private static String DOUBLE_LINE_SEPARATOR = LINE_SEPARATOR + LINE_SEPARATOR;

	public ClassGenerator(String name, String pathToFile, String path, String type) {
		writing(name, pathToFile, path, type);
	}

	public void writing(String name, String obj, String path, String type) {
		try {
			File statText = new File(obj);
			FileOutputStream is = new FileOutputStream(statText);
			OutputStreamWriter osw = new OutputStreamWriter(is);
			Writer w = new BufferedWriter(osw);
			w.write(PACKAGE + path.replace("/", ".") + SEPARATOR);
			w.write(DOUBLE_LINE_SEPARATOR);
			w.write(IMPORT + type + SEPARATOR);
			w.write(DOUBLE_LINE_SEPARATOR);
			w.write(COMMENT);
			w.write(LINE_SEPARATOR);
			w.write(PUBLIC_CLASS + name + EXTENDS + type.split("\\.")[type.split("\\.").length - 1] + LEFT_BRACKET);
			w.write(LINE_SEPARATOR);
			w.write(RIGHT_BRACKET);
			w.close();
		} catch (IOException e) {
			System.err.println("Problem writing to the file statsTest.txt");
		}
	}
}