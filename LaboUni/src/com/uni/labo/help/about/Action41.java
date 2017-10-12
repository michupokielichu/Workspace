package com.uni.labo.help.about;

import java.awt.Component;

import javax.swing.JDialog;

import com.gui.builder.components.Dialog;
import com.gui.builder.main.IAction;

public class Action41 implements IAction {

	@Override
	public void execute(Component parent) {
		JDialog loginWindow = new AboutWindow();
		((Dialog)loginWindow).showDialog();
	}

}