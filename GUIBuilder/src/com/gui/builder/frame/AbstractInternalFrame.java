package com.gui.builder.frame;

import java.awt.BorderLayout;
import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.apache.log4j.Logger;

import com.gui.builder.components.InternalFrame;
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
public abstract class AbstractInternalFrame extends InternalFrame implements IContextComponents {
	Logger logger = Logger.getLogger(AbstractInternalFrame.class);

	private static final long serialVersionUID = -3640857195259525786L;

	private static int INTERNAL_FRAME_NUM;
	private static boolean INTERNAL_FRAME_MAXMIZED;

	private List<Component> mComponents = null;
	private JPanel mMainPanel = null;

	public AbstractInternalFrame() {
		mComponents = new ArrayList<Component>();
		mMainPanel = new Panel();
		mId = "INTERNAL_FRAME_" + INTERNAL_FRAME_NUM++;
		Builder builder = new Builder();
		try {
			String path = getClass().getName().replace(".", "/") + ".properties";
			builder.loadProperties(path);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		mComponents.addAll(builder.getComponents());

		BorderLayout borderLayout = new BorderLayout(10, 10);

		JPanel btnPanel = new PanelButton(this);
		builder.buildBtnPanel(btnPanel);

		logger.debug("Title:" + builder.getTitle());
		setTitle(builder.getTitle() + " #" + INTERNAL_FRAME_NUM);

		mMainPanel.setLayout(borderLayout);
		mMainPanel.add(mComponents.get(0), BorderLayout.NORTH);
		if (((PanelButton) btnPanel).getPanelActivated()) {
			mMainPanel.add(btnPanel, BorderLayout.EAST);
		}

		if (builder.getScrollMode()) {
			JScrollPane scrollPane = new ScrollPane("scroll_frame", (Component) mMainPanel,
					JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			add(scrollPane);
		} else {
			add(mMainPanel);
		}

		GUIHelper.setLookAndFeel(this);
		setVisible(true);
		// try {
		//// if (!isMaximum && INTERNAL_FRAME_MAXMIZED) {
		// setMaximum(INTERNAL_FRAME_MAXMIZED);
		//// }
		// } catch (PropertyVetoException e) {
		// e.printStackTrace();
		// }
		PropertyChangeListener propertyChangeListener = new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				System.out.println("Internal frame maximized: " + INTERNAL_FRAME_MAXMIZED);
				INTERNAL_FRAME_MAXMIZED = !INTERNAL_FRAME_MAXMIZED;
			};
		};
		addPropertyChangeListener(propertyChangeListener);
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
