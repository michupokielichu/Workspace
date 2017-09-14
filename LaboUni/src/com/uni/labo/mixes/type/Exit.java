package com.uni.labo.mixes.type;

import java.awt.Component;

import org.apache.log4j.Logger;

import com.gui.builder.main.IAction;

public class Exit implements IAction{
	static Logger log = Logger.getLogger(Exit.class.getName());

	public Exit(){
	
	}


	@Override
	public void execute(Component parent) {
		log.info("Koniec programu! Spadam!");
		System.exit(0);				
	}
}
