package com.gui.properties.generator.starter;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Generator.readXLSXFile("settings.xlsx");
		Generator.generate(true, true);
	}
}
