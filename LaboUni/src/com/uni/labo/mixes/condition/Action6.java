package com.uni.labo.mixes.condition;

import java.awt.Component;

import javax.swing.JDialog;

import org.apache.log4j.Logger;

import com.gui.builder.components.Dialog;
import com.gui.builder.main.IAction;
import com.uni.labo.mixes.type.MixTypeWindow;

public class Action6 implements IAction {

	Logger logger = Logger.getLogger(Action6.class);

	@Override
	public void execute(Component panel) {
		logger.info("Odpalanie okna z typem mieszanki");
		JDialog dialog = new MixTypeWindow();
		((Dialog)dialog).showDialog();
	}
}
