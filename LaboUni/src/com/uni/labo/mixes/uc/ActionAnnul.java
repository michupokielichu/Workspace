package com.uni.labo.mixes.uc;

import java.awt.Component;

import javax.swing.JInternalFrame;

import com.gui.builder.components.TextField;
import com.gui.builder.main.Context;
import com.gui.builder.main.IAction;

public class ActionAnnul implements IAction, IMixCondition {

	@Override
	public void execute(Component panel) {
		TextField description = (TextField) Context.getComponent(panel, DESCRIPTION);
		if (description.getText().equals("aaa")) {
			((JInternalFrame) panel).dispose();
		}
	}

}
