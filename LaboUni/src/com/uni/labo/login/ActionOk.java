package com.uni.labo.login;

import java.awt.Component;

import org.apache.log4j.Logger;

import com.gui.builder.components.Dialog;
import com.gui.builder.components.TextField;
import com.gui.builder.main.Context;
import com.gui.builder.main.IAction;

public class ActionOk implements IAction, ILogin {

	Logger logger = Logger.getLogger(ActionOk.class);
	@Override
	public void execute(Component panel) {

		TextField user = (TextField) Context.getComponent(panel, USER);

		if (user.getText().equals("michu")) {
			logger.info(panel.getClass().getName() + " disposed");
			//			((JFrame) panel).dispose();
			((Dialog)panel).setValue("correctly_logged");
			((Dialog)panel).dispose();
		};
	}
}
