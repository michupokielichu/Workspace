package com.uni.labo.mixes.condition;

import java.awt.Component;

import com.gui.builder.components.TextField;
import com.gui.builder.main.Context;
import com.gui.builder.main.IAction;

public class BeforeAction implements IAction {

	@Override
	public void execute(Component parent) {
		TextField field1 =  (TextField) Context.getComponent("MixParameters", "obiekt1");
		field1.setText("0");
		
		TextField field2 =  (TextField) Context.getComponent("MixParameters", "obiekt2");
		field2.setText("100");
	}
}
