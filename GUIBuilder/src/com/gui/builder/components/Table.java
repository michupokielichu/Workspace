package com.gui.builder.components;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.log4j.Logger;

import com.gui.builder.variables.IComponent;
import com.gui.builder.variables.IFonts;

public class Table extends JTable implements IComponent{
	
	Logger logger = Logger.getLogger(Table.class);
	
	private String mId;
	private boolean mObligatory;
	private static final long serialVersionUID = -4564467101561292786L;
	static Object rowData[][] = { 
			{ "Michal", "Bledowski", "Wroclaw" }, { "Karol", "Krawczyk", "Warszawa" },
			{ "Michal", "Bledowski", "Wroclaw" }, { "Karol", "Krawczyk", "Warszawa" },
			{ "Michal", "Bledowski", "Wroclaw" }, { "Karol", "Krawczyk", "Warszawa" },
			{ "Michal", "Bledowski", "Wroclaw" }, { "Karol", "Krawczyk", "Warszawa" },
			{ "Michal", "Bledowski", "Wroclaw" }, { "Karol", "Krawczyk", "Warszawa" },
			{ "Michal", "Bledowski", "Wroclaw" }, { "Karol", "Krawczyk", "Warszawa" },
			{ "Michal", "Bledowski", "Wroclaw" }, { "Karol", "Krawczyk", "Warszawa" },
			{ "Michal", "Bledowski", "Wroclaw" }, { "Karol", "Krawczyk", "Warszawa" },
			{ "Michal", "Bledowski", "Wroclaw" }, { "Karol", "Krawczyk", "Warszawa" },
			{ "Michal", "Bledowski", "Wroclaw" }, { "Karol", "Krawczyk", "Warszawa" },
			{ "Michal", "Bledowski", "Wroclaw" }, { "Karol", "Krawczyk", "Warszawa" },
			{ "Michal", "Bledowski", "Wroclaw" }, { "Karol", "Krawczyk", "Warszawa" },
			{ "Michal", "Bledowski", "Wroclaw" }, { "Karol", "Krawczyk", "Warszawa" },
			{ "Michal", "Bledowski", "Wroclaw" }, { "Karol", "Krawczyk", "Warszawa" },
			{ "Michal", "Bledowski", "Wroclaw" }, { "Karol", "Krawczyk", "Warszawa" },
			{ "Michal", "Bledowski", "Wroclaw" }, { "Karol", "Krawczyk", "Warszawa" },
			{ "Michal", "Bledowski", "Wroclaw" }, { "Karol", "Krawczyk", "Warszawa" },
			{ "Michal", "Bledowski", "Wroclaw" }, { "Karol", "Krawczyk", "Warszawa" },
			{ "Michal", "Bledowski", "Wroclaw" }, { "Karol", "Krawczyk", "Warszawa" },
			{ "Michal", "Bledowski", "Wroclaw" }, { "Karol", "Krawczyk", "Warszawa" }};
	static Object columnNames[] = { "Imie", "Nazwisko", "Miasto" };

	private List<String> mHeader = new ArrayList<>();
	
	public Table(){
		super();
//		getmo
		setFont(IFonts.TEXT_FONT);
		setDefaultEditor(Object.class, null);
		
//		setPreferredSize(new Dimension(10,400));
		addKeyListener(new KeyListener() {
		    public void keyPressed(KeyEvent e) {
				if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_UP) {
					logger.info("Enter pressed!" + e.getKeyCode() + "  " + e.getKeyText(e.getKeyCode()));
					((Table)e.getComponent()).setSize(((Table)e.getComponent()).getWidth(), ((Table)e.getComponent()).getHeight()+10);
				}
				if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_DOWN) {
					logger.info("Enter pressed!" + e.getKeyCode() + "  " + e.getKeyText(e.getKeyCode()));
					((Table)e.getComponent()).setSize(((Table)e.getComponent()).getWidth(), ((Table)e.getComponent()).getHeight()-10);
				}
		    }

		    public void keyReleased(KeyEvent e) { /* ... */ }

		    public void keyTyped(KeyEvent e) { /* ... */ }
		});

	}
	
	DefaultTableModel tableModel = new DefaultTableModel() {

	    @Override
	    public boolean isCellEditable(int row, int column) {
	       //all cells false
	       return false;
	    }
	};
	
	
	@Override
	public void initialise(String id, String text) {
		mId=id;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
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
	public void setDisabled(boolean disabled) {
		setEnabled(!disabled);
	}

	@Override
	public void addParameter(String strArg) {
		mHeader.add(strArg);
		TableModel model = new DefaultTableModel(mHeader.toArray(), 13);
		setModel(model);
	}

}
