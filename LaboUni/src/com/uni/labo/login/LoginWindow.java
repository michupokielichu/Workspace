package com.uni.labo.login;

import org.apache.log4j.Logger;

import com.gui.builder.frame.AbstractDialog;

public class LoginWindow extends AbstractDialog {

	static Logger log = Logger.getLogger(LoginWindow.class.getName());

	@Override
	public void doOnClose() {
		log.info("Koniec programu! Spadam!");
		System.exit(0);
	}
}
