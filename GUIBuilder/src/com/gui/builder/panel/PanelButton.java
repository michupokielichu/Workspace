package com.gui.builder.panel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.apache.log4j.Logger;

import com.gui.builder.components.Button;
import com.gui.builder.components.Panel;
import com.gui.builder.main.Builder;
import com.gui.builder.main.IAction;

public class PanelButton extends Panel {
	Logger logger = Logger.getLogger(PanelButton.class);

	private static final long serialVersionUID = 6041526088344545057L;
	private JButton btnOk = new Button("OK");
	private JButton btnAnnul = new Button("Anuluj");
	private boolean mPanelActivated;
	private Component mComponent = null;

	public PanelButton(Component component) {
		mComponent = component;
		JPanel btnPanel = new JPanel();

		btnPanel.setLayout(new BorderLayout());
		btnPanel.add(btnOk, BorderLayout.LINE_START);
		btnPanel.add(btnAnnul, BorderLayout.LINE_END);
		add(btnPanel, BorderLayout.PAGE_END);
	}

	public void prepareActions(String mOkAction, String mAnnulAction) {
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				ClassLoader classLoader = Builder.class.getClassLoader();
				IAction action = null;
				try {
					action = (IAction) classLoader.loadClass(mOkAction).newInstance();
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				action.execute(mComponent);
			}
		});

		btnAnnul.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				ClassLoader classLoader = Builder.class.getClassLoader();
				IAction action = null;
				try {
					action = (IAction) classLoader.loadClass(mAnnulAction).newInstance();
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
					logger.error("Takiej klasy to nie znalaz³em!");
					e1.printStackTrace();
				}
				action.execute(mComponent);
			}
		});
	}

	public void setPanelActivated() {
		mPanelActivated = true;
	}
	
	public boolean getPanelActivated(){
		return mPanelActivated;
	}
}
