package com.gui.builder.main;

import java.awt.Component;

import com.gui.builder.frame.IContextComponents;
import com.gui.builder.variables.IComponent;

public class Context {

	public static IComponent getComponent(Component panel, String name) {
		return ((IContextComponents) panel).getContextMap().get(name);
	}
}
