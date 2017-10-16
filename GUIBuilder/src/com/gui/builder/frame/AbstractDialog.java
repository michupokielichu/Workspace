package com.gui.builder.frame;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.apache.log4j.Logger;

import com.gui.builder.components.Dialog;
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
public abstract class AbstractDialog extends Dialog implements IContextComponents {

	Logger logger = Logger.getLogger(AbstractDialog.class);
	
	private static final long serialVersionUID = -3640857195259525786L;

	private List<Component> mComponents = null;
	private JPanel mMainPanel = null;

	public AbstractDialog() {
		mMainPanel = new Panel();
		mComponents = new ArrayList<Component>();
		Builder builder = new Builder();
		try {
			String path = getClass().getName().replace(".", "/") + ".properties";
			logger.info(path);
			builder.loadProperties(path);
			mComponents.addAll(builder.getComponents());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException  e) {
			e.printStackTrace();
		}

		builder.buildDialog(this);

		BorderLayout borderLayout = new BorderLayout(10, 10);

		JPanel btnPanel = new PanelButton(this);
		boolean btnPanelFlag = builder.buildBtnPanel(btnPanel);

		mMainPanel.setLayout(borderLayout);
		mMainPanel.add(mComponents.get(0), BorderLayout.NORTH);
		if (btnPanelFlag && ((PanelButton) btnPanel).getPanelActivated()) {
			mMainPanel.add(btnPanel, BorderLayout.EAST);
		}

		if (builder.getScrollMode()) {
			JScrollPane scrollPane = new ScrollPane("scroll_frame", (Component) mMainPanel,
					JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			add(scrollPane);
		} else {
			add(mMainPanel);
		}

		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		GUIHelper.setLookAndFeel(this);
		setResizable(false);
		setLocationRelativeTo(null);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				doOnClose();
			}
		});
	}

	public void doOnClose() {
		dispose();
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
