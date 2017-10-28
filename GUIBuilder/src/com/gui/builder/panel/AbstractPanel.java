package com.gui.builder.panel;

import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gui.builder.components.Panel;
import com.gui.builder.components.ScrollPane;
import com.gui.builder.frame.IContextComponents;
import com.gui.builder.main.Builder;
import com.gui.builder.main.GUIHelper;
import com.gui.builder.variables.IComponent;

/**
 * 
 * @author michu
 *
 */
public abstract class AbstractPanel extends Panel implements IContextComponents {

	private static final long serialVersionUID = -3640857195259525786L;

	private List<Component> mComponents = null;

	public AbstractPanel() {
		mComponents = new ArrayList<Component>();
		Builder b2 = new Builder();
		try {
			String path = getClass().getName().replace(".", "/") + ".properties";
			b2.loadProperties(path);
			mComponents.addAll(b2.getComponents());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		b2.buidPanel(this);
		initialise();
	}
	
	public void initialise() {};

	public List<Component> getGUIComponents() {
		return mComponents;
	}
	@Override
	public Map<String, IComponent> getContextMap() {
		Map<String, IComponent> map = new HashMap<String, IComponent>();
		for (Component c : GUIHelper.loadAllComponents(mComponents)) {
			if (c instanceof Panel) {
				map.putAll(((AbstractPanel)c).getContextMap());
			} else if(c instanceof ScrollPane){
				map.put(((ScrollPane)c).getComponent().getId(), ((ScrollPane)c).getComponent());
			}else {
				IComponent icom = (IComponent) c;
				map.put(icom.getId(), icom);
			}
		}

		return map;
	}
	


}
