package com.uni.labo.login;

import java.awt.Component;

import org.apache.log4j.Logger;

import com.gui.builder.main.IAction;

public class ActionAnnul implements IAction{
	static Logger log = Logger.getLogger(ActionAnnul.class.getName());

	@Override
	public void execute(Component parent) {
		log.info("Koniec programu! Spadam!");
		System.exit(0);				
	}
}
