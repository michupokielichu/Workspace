package com.uni.labo.main;

import java.awt.Component;

import javax.swing.JInternalFrame;

import com.gui.builder.main.Builder;
import com.gui.builder.main.IAction;
import com.uni.labo.mixes.condition.MixConditionInternalFrame;

public class Action1 implements IAction {

	@Override
	public void execute(Component parent) {
		JInternalFrame internalFrame = new MixConditionInternalFrame();
		Builder.addInternalFrame(internalFrame);
	}

}
