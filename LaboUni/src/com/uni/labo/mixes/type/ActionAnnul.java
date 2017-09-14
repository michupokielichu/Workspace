package com.uni.labo.mixes.type;

import java.awt.Component;

import javax.swing.JTable;

import org.apache.log4j.Logger;

import com.gui.builder.main.Context;
import com.gui.builder.main.IAction;

public class ActionAnnul implements IAction, IMixesType {
	Logger logger = Logger.getLogger(ActionAnnul.class);

	@Override
	public void execute(Component panel) {

		JTable table = (JTable) Context.getComponent(panel, TABLE);
		logger.debug(table.getSelectedRow());
		logger.debug(panel.getClass());
	}
}
