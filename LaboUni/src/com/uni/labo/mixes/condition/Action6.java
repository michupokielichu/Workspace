package com.uni.labo.mixes.condition;

import java.awt.Component;

import org.apache.log4j.Logger;

import com.gui.builder.main.IAction;

public class Action6 implements IAction {

	Logger logger = Logger.getLogger(Action6.class);

	@Override
	public void execute(Component panel) {
		logger.info("Odpalanie okna z typem mieszanki");
//		JDialog dialog = new MixTypeWindow();
//		((Dialog)dialog).showDialog();
	}
}
