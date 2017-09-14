package com.gui.builder.components;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import com.gui.builder.variables.IComponent;
import com.gui.builder.variables.IFonts;
import com.gui.builder.variables.ISettings;

public class ToolBar extends JToolBar implements IComponent {
	private String mId;
	private boolean mObligatory;
	private JPanel mLeftSide = null;

	public ToolBar(String id) {
		super(JToolBar.HORIZONTAL);
		setFont(IFonts.TEXT_FONT);
		mId = id;
		setPreferredSize(new Dimension(100, 35));
		setVisible(true);
		mLeftSide = new JPanel(new FlowLayout(FlowLayout.LEFT));
		add(mLeftSide);
		mLeftSide.setBackground(ISettings.TOOL_BAR_BACKGROUND_COLOR);
		setBackground(ISettings.TOOL_BAR_BACKGROUND_COLOR);
		setFloatable(false);
	}

	public Component add(ToolBarButton button) {
		mLeftSide.add(button);
		return this;
	}

	@Override
	public String getId() {
		return mId;
	}

	@Override
	public void setObligatory(boolean obligatory) {
		mObligatory = obligatory;
	}

	@Override
	public void setValue(String type) {
		// TODO Auto-generated method stub

	}

	@Override
	public void check() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initialise(String id, String text) {
		if (ISettings.TOOL_BAR_IMAGE) {
			add(Box.createHorizontalGlue());
			Image image = new Image(text);
			image.scaleImage(-1, 30);
			add(image);
		}
	}

	@Override
	public void setDisabled(boolean disabled) {
		setEnabled(!disabled);
	}

	public void deleteElement(String id) {
		for (Component component : ((JPanel) getComponent(0)).getComponents()) {
			if (component instanceof ToolBarButton && ((ToolBarButton) component).getId().equals(id)) {
				((JPanel) getComponent(0)).remove(component);
			}
		}
	}
}
