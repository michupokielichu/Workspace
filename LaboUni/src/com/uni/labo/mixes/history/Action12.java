package com.uni.labo.mixes.history;

import java.awt.Component;

import javax.swing.JInternalFrame;

import com.gui.builder.main.Builder;
import com.gui.builder.main.IAction;

public class Action12 implements IAction {

	@Override
	public void execute(Component parent) {
		JInternalFrame internalFrame = new MixHistoryInternalFrame();
		Builder.addInternalFrame(internalFrame);
	}

}