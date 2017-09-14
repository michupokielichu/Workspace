package com.uni.labo.mixes.condition;

import java.awt.Component;

import javax.swing.JInternalFrame;

import com.gui.builder.components.TextField;
import com.gui.builder.main.Builder;
import com.gui.builder.main.Context;
import com.gui.builder.main.IAction;
import com.uni.labo.mixes.uc.MixInternalFrame;

public class ActionOk implements IAction, IMixCondition {

	@Override
	public void execute(Component panel) {
		TextField description = (TextField) Context.getComponent(panel, DESCRIPTION);
//		if (description.getText().equals("aaa")) {
			JInternalFrame mix = new MixInternalFrame();
			Builder.addInternalFrame(mix);
			((JInternalFrame) panel).dispose();
//		}
	}

}
