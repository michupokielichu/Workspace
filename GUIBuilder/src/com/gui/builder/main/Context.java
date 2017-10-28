package com.gui.builder.main;

import java.util.HashMap;
import java.util.Map;

import com.gui.builder.variables.IComponent;

public class Context {

	private static Map<String, IComponent> map = new HashMap<>();

	private static String SEPARATOR = "_";

	public static IComponent getComponent(String panelId, String componentId) {
		return map.get(panelId + SEPARATOR + componentId);
	}

	public static void addComponent(String panelId, String componentId, IComponent component) {
		map.put(panelId + SEPARATOR + componentId, component);
	}
	
//	public static IComponent getComponent(Component panel, String name) {
//		return ((IContextComponents) panel).getContextMap().get(name);
//	}
}
