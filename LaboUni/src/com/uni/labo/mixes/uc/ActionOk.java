package com.uni.labo.mixes.uc;

import java.awt.Component;

import javax.swing.JInternalFrame;

import org.apache.log4j.Logger;

import com.gui.builder.main.Builder;
import com.gui.builder.main.IAction;

public class ActionOk implements IAction {
	static Logger log = Logger.getLogger(ActionOk.class.getName());

	@Override
	public void execute(Component panel) {
		Builder.disposeInternalFrame((JInternalFrame) panel);
	}
}
