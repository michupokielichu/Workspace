package com.gui.builder.main;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

import org.apache.log4j.Logger;

import com.gui.builder.components.DesktopPane;
import com.gui.builder.components.Image;
import com.gui.builder.components.InternalFrame;
import com.gui.builder.components.Label;
import com.gui.builder.components.Menu;
import com.gui.builder.components.MenuBar;
import com.gui.builder.components.Panel;
import com.gui.builder.components.ScrollPane;
import com.gui.builder.components.TextField;
import com.gui.builder.components.ToolBar;
import com.gui.builder.components.ToolBarButton;
import com.gui.builder.panel.PanelButton;
import com.gui.builder.variables.IComponent;
import com.gui.builder.variables.IFonts;
import com.gui.builder.variables.IPropertyfileElement;
import com.gui.builder.variables.ISettings;

public class Builder implements IPropertyfileElement{
	Logger logger = Logger.getLogger(Builder.class);
	
	private JFrame mFrame;
	private Properties mProperties;

	private List<Component> components;
	private List<Component> labels;
	private Map<String, List<MenuElement>> menuItems;
	private static JDesktopPane mDesktopPane;
	private static JToolBar mToolBar;

	private IAction mBeforeAction;
	private Integer mColumns;
	private Integer mRows;
	private String mTitle;
	private String mIcon;
	private String mWidth;
	private String mHeight;
	private String mScrollMode;

	private String mBtnOk;
	private String mBtnAnnul;

	public Builder() {
		mProperties = new Properties();
		components = new ArrayList<Component>();
		labels = new ArrayList<Component>();
		menuItems = new HashMap<String, List<MenuElement>>();
	}

	public void addComponent(Component component) {
		components.add(component);
	}
	
	public static void addInternalFrame(JInternalFrame frame){
		mDesktopPane.add(frame);
		((ToolBar)mToolBar).add(new ToolBarButton(frame));
	}
	
	public static void disposeInternalFrame(JInternalFrame frame){
		((ToolBar)mToolBar).deleteElement(((InternalFrame)frame).getId());
		frame.dispose();

	}

	public void buidWindowFrame(JFrame frame) {
		mFrame = frame;
		mFrame.setTitle(mTitle);
		logger.debug("Frame title: " + mTitle);
		if (mIcon != null) {
			logger.debug("Path to icon:" + mIcon);
			ImageIcon img = new ImageIcon(mIcon);
			mFrame.setIconImage(img.getImage());
		}
		JMenuBar menuBar = new MenuBar();
		mFrame.setJMenuBar(menuBar);
		mFrame.setLayout(null);
		mDesktopPane = new DesktopPane();
		mToolBar = new ToolBar("toolBar");
		((ToolBar)mToolBar).initialise("toolBar", "rsrc/toolBarLogo.png");
		JPanel tmpPanel = new Panel();
		tmpPanel.setVisible(true);
		tmpPanel.setSize(400, 400);
		tmpPanel.setLayout(new BorderLayout());
		tmpPanel.add(mDesktopPane, BorderLayout.CENTER);
		if (ISettings.TOOL_BAR_ENABLED) {
			tmpPanel.add(mToolBar, BorderLayout.AFTER_LAST_LINE);
		}
		mFrame.setContentPane(tmpPanel);

		for (String menu : menuItems.keySet()) {
			JMenu m = new Menu(menu);
			for (MenuElement me : menuItems.get(menu)) {
				JMenuItem mi = new JMenuItem(me.getItem());
				mi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						ClassLoader classLoader = Builder.class.getClassLoader();
						IAction action = null;
						try {
							action = (IAction) classLoader.loadClass(me.getAction()).newInstance();
						} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
							e.printStackTrace();
						}
						action.execute(mFrame);
					}
				});
				m.add(mi);
			}
			menuBar.add(m);
		}
		if (mWidth != null && mHeight != null) {
			frame.setSize(new Dimension(Integer.parseInt(mWidth), Integer.parseInt(mHeight)));
		}
		SwingUtilities.updateComponentTreeUI(frame);

	}

	public void buildFrame(JFrame frame) {
		frame.setTitle(mTitle);
		if (mWidth != null && mHeight != null) {
			frame.setSize(new Dimension(Integer.parseInt(mWidth), Integer.parseInt(mHeight)));
		}
	}
	
	public void buildDialog(JDialog dialog) {
		dialog.setTitle(mTitle);
		if (mWidth != null && mHeight != null) {
			dialog.setSize(new Dimension(Integer.parseInt(mWidth), Integer.parseInt(mHeight)));
		}
	}

	public void buildBtnPanel(JPanel btnPanel) {
		if (mBtnOk != null) {
			PanelButton b = ((PanelButton) btnPanel);
			b.prepareActions(mBtnOk, mBtnAnnul);
			b.setPanelActivated();
		} 
	}

	public void buidPanel(JPanel panel) {
		TitledBorder border = BorderFactory.createTitledBorder(mTitle);
		border.setTitleFont(IFonts.BORDER_FONT);
		panel.setBorder(border);
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;

		gbc.gridx = 0;
		gbc.weightx = 1;
		panel.setLayout(layout);

		int i = 0;
		if (!labels.isEmpty()) {
			for (int y = 0; y < mRows; y++) {
				for (int x = 0; x < mColumns * 2; x += 2) {
					if (i < components.size()) {
						gbc.insets = new Insets(0, 0, 2, 10);
						gbc.gridx = x;
						gbc.gridy = y;
						Component left = labels.get(i);
						gbc.weightx = 0;
						panel.add(left, gbc);
						Component right = components.get(i);
						gbc.gridx = x + 1;
						gbc.weightx = 1;
						panel.add(right, gbc);
						i++;
					}
				}
			}
		} else {
			for (Component component : components) {
				gbc.gridx = 0;
				gbc.gridy = i;
				gbc.weightx = 1;
				panel.add(component, gbc);
				i++;
			}
		}
		
		if (mBeforeAction != null) {
			mBeforeAction.execute(panel);
		}
		panel.setVisible(true);
	}

	public void loadProperties(String fullPath) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		InputStream input = null;
		try {

			String filename = fullPath;
			input = Builder.class.getClassLoader().getResourceAsStream(filename);
			if (input == null) {
				logger.error("Nie znaleziono " + filename);
				return;
			}

			mProperties.load(input);
			ClassLoader classLoader = Builder.class.getClassLoader();

			String title = mProperties.getProperty(TITLE);
			String id = mProperties.getProperty(ID);
			String beforAction = mProperties.getProperty(BEFORE_ACTION);
			String icon = mProperties.getProperty(ICON);
			mWidth = mProperties.getProperty(WIDTH);
			mHeight = mProperties.getProperty(HEIGHT);
			mScrollMode = mProperties.getProperty(SCROLL);
			mBtnOk = getPathToBtnAction(fullPath) + ISettings.ACTION_OK_NAME;
			mBtnAnnul = getPathToBtnAction(fullPath) + ISettings.ACTION_ANNUL_NAME;
			mTitle = title;
			mIcon = icon;
			Set<String> idSet = new HashSet<String>();
			if (beforAction != null) {
				try {
					mBeforeAction = (IAction) classLoader.loadClass(beforAction).newInstance();
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
			for (int i = 1; i <= 51; i++) {
				String strLabel = mProperties.getProperty(LABEL + i);
				String strId = mProperties.getProperty(ID + i);
				String strObligatory = mProperties.getProperty(OBLIGATORY + i);
				String strComponent = mProperties.getProperty(COMPONENT + i);
				String strDefault = mProperties.getProperty(DEFAULT + i);
				String strDisabled = mProperties.getProperty(DISABLED + i);
				String strScrollMode = mProperties.getProperty(SCROLL + i);
				String strHeight = mProperties.getProperty(HEIGHT + i);
				String strItem = mProperties.getProperty(ITEM + i);
				String strWidth = mProperties.getProperty(WIDTH + i);
				if (strLabel != null) {
					labels.add(new Label(strLabel));
				}
				if (strComponent != null) {
					if (!strComponent.equals("break")) {
						logger.debug("Generowanie komponentu: " + strLabel);
						logger.debug("Klasa: " + strComponent);
						Class<IComponent> componentClass = (Class<IComponent>) classLoader.loadClass(strComponent);
						IComponent component = (IComponent) componentClass.newInstance();
						component.initialise(strId, strDefault);
						component.setDisabled(Boolean.parseBoolean(strDisabled));
						if (strObligatory != null) {
							component.setObligatory(Boolean.parseBoolean(strObligatory));
						}
						if (strComponent.equals(Image.class.getName())) {
							if (strWidth == null) {
								strWidth = "-1";
							}
							if (strHeight == null) {
								strHeight = "-1";
							}
							((Image) component).scaleImage(Integer.parseInt(strWidth), Integer.parseInt(strHeight));
						}
						if (strScrollMode != null && strScrollMode.equals("true")) {
							JScrollPane scrollPane = new ScrollPane("scroll_" + strId, (Component) component,
									JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
							scrollPane.setPreferredSize(new Dimension(50, Integer.parseInt(strHeight)));
							components.add(scrollPane);
						} else {
							components.add((Component) component);
						}
						if (idSet.contains(strId)) {
							throw new AssertionError("Dwa takie same id: " + strId + " w panelu: " + fullPath);
						}
						idSet.add(strId);
					}else{
						TextField tmp = new TextField();
						tmp.initialise("break"+i, "");
						tmp.setVisible(false);
						components.add(tmp);
						labels.add(new Label(" "));
						idSet.add("break"+i);
					}
					mColumns = getIntValueFromPropertiesFile("columns");
					mRows = (int) Math.ceil((double) components.size() / (double) mColumns);
				} else if (strItem != null) {
					List<MenuElement> list = new ArrayList<MenuElement>();
					for (int j = 1; j < 31; j++) {
						String strInternItem = mProperties.getProperty("item" + i + "_" + j);
						String strClass = mProperties.getProperty("class" + i + "_" + j);
						if (strInternItem != null && strClass != null) {
							list.add(new MenuElement(strItem, strInternItem, strClass));
						}
					}
					menuItems.put(strItem, list);
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private String getPathToBtnAction(String fullPath) {
		String path = "";
		for (int i = 0; i < fullPath.split("/").length - 1; i++) {
			path = path + fullPath.split("/")[i] + ".";
		}
		return path;
	}

	private int getIntValueFromPropertiesFile(String string) {
		String value = mProperties.getProperty(string);
		return value != null ? Integer.parseInt(value) : null;
	}

	public List<Component> getComponents() {
		return components;
	}

	public void setComponent(String id, String value) {
		for (Component component : components) {
			if (component.getName().equals(TextField.class.getName()) && ((TextField) component).getId().equals(id)) {
				((TextField) component).setText(value);
			}
		}
	}

	public String getComponent(String id) {
		for (Component component : components) {
			if (component.getName().equals(TextField.class.getName()) && ((TextField) component).getId().equals(id)) {
				return ((TextField) component).getText();
			}
		}
		return null;
	}
	
	public IAction getBeforeAction(){
		return mBeforeAction;
	}

	public String getTitle() {
		return mTitle;
	}

	public boolean getScrollMode() {
		return mScrollMode!=null && mScrollMode.equals("true");
	}

}
