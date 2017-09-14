package com.gui.builder.frame;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.gui.builder.components.Frame;
import com.gui.builder.components.Panel;
import com.gui.builder.components.ScrollPane;
import com.gui.builder.main.Builder;
import com.gui.builder.main.GUIHelper;
import com.gui.builder.panel.AbstractPanel;
import com.gui.builder.panel.PanelButton;
import com.gui.builder.variables.IComponent;

/**
 * 
 * @author michu
 *
 */
public abstract class AbstractFrame extends Frame implements IContextComponents {

	private static final long serialVersionUID = -3640857195259525786L;

	private List<Component> mComponents = null;
	private JPanel mMainPanel = null;

	public AbstractFrame() {
		mMainPanel = new Panel();
		mComponents = new ArrayList<Component>();
		Builder builder = new Builder();
		try {
			String path = getClass().getName().replace(".", "/") + ".properties";
			builder.loadProperties(path);
			mComponents.addAll(builder.getComponents());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}

		builder.buildFrame(this);

		BorderLayout borderLayout = new BorderLayout(10, 10);

		JPanel btnPanel = new PanelButton(this);
		builder.buildBtnPanel(btnPanel);

		mMainPanel.setLayout(borderLayout);
		mMainPanel.add(mComponents.get(0), BorderLayout.NORTH);
		if (((PanelButton) btnPanel).getPanelActivated()) {
			mMainPanel.add(btnPanel, BorderLayout.EAST);
		}

		if (builder.getScrollMode()) {
			JScrollPane scrollPane = new ScrollPane("scroll_frame", (Component) mMainPanel,
					JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			add(scrollPane);
		} else {
			add(mMainPanel);
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GUIHelper.setLookAndFeel(this);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	public List<Component> getGUIComponents() {
		return mComponents;
	}

	@Override
	public Map<String, IComponent> getContextMap() {
		Map<String, IComponent> map = new HashMap<String, IComponent>();
		for (Component c : GUIHelper.loadAllComponents(mComponents)) {
			if (c instanceof Panel) {
				map.putAll(((AbstractPanel) c).getContextMap());
			} else {
				IComponent icom = (IComponent) c;
				map.put(icom.getId(), icom);
			}
		}

		return map;
	}

}
