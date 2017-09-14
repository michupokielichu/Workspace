package com.uni.labo.mixes.condition;

import java.awt.Component;

import javax.swing.JInternalFrame;

import org.apache.log4j.Logger;

import com.gui.builder.main.Builder;
import com.gui.builder.main.IAction;

public class ActionAnnul implements IAction {
	static Logger log = Logger.getLogger(ActionAnnul.class.getName());

	@Override
	public void execute(Component panel) {
		Builder.disposeInternalFrame((JInternalFrame) panel);
	}
}
