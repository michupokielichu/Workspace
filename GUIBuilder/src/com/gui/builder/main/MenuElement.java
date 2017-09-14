package com.gui.builder.main;

public class MenuElement {
	private String mMenu;
	private String mItem;
	private String mAction;

	public MenuElement(String menu, String item, String action) {
		mMenu = menu;
		mItem = item;
		mAction = action;
	}

	public String getMenu() {
		return mMenu;
	}

	public String getItem() {
		return mItem;
	}

	public String getAction() {
		return mAction;
	}
}
