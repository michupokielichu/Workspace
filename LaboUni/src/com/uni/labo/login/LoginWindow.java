package com.uni.labo.login;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.gui.builder.frame.AbstractDialog;
import com.gui.builder.translate.Translator;

public class LoginWindow extends AbstractDialog {

	static Logger log = Logger.getLogger(LoginWindow.class.getName());

	@Override
	public void doOnClose() {
		log.info("Koniec programu! Spadam!");
		try {
			Translator.readXLSXFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(0);
	}
}
