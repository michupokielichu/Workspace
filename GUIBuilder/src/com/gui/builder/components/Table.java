package com.gui.builder.components;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;

import com.gui.builder.variables.IComponent;
import com.gui.builder.variables.IFonts;

public class Table extends JTable implements IComponent{
	
	Logger logger = Logger.getLogger(Table.class);
	
	private String mId;
	private boolean mObligatory;
	private static final long serialVersionUID = -4564467101561292786L;
	static Object rowData[][] = { 
			{ "1Michal", "Bledowski", "Wroclaw" }, { "Karol", "Krawczyk", "Warszawa" },
			{ "2Michal", "Bledowski", "Wroclaw" }, { "Karol", "Krawczyk", "Warszawa" },
			{ "3Michal", "Bledowski", "Wroclaw" }, { "Karol", "Krawczyk", "Warszawa" },
			{ "4Michal", "Bledowski", "Wroclaw" }, { "Karol", "Krawczyk", "Warszawa" },
			{ "5Michal", "Bledowski", "Wroclaw" }, { "Karol", "Krawczyk", "Warszawa" },
//			{ "6Michal", "Bledowski", "Wroclaw" }, { "Karol", "Krawczyk", "Warszawa" },
//			{ "7Michal", "Bledowski", "Wroclaw" }, { "Karol", "Krawczyk", "Warszawa" },
//			{ "8Michal", "Bledowski", "Wroclaw" }, { "Karol", "Krawczyk", "Warszawa" },
//			{ "9Michal", "Bledowski", "Wroclaw" }, { "Karol", "Krawczyk", "Warszawa" },
//			{ "10Michal", "Bledowski", "Wroclaw" }, { "Karol", "Krawczyk", "Warszawa" },
//			{ "11Michal", "Bledowski", "Wroclaw" }, { "Karol", "Krawczyk", "Warszawa" },
//			{ "12Michal", "Bledowski", "Wroclaw" }, { "Karol", "Krawczyk", "Warszawa" },
//			{ "13Michal", "Bledowski", "Wroclaw" }, { "Karol", "Krawczyk", "Warszawa" },
//			{ "14Michal", "Bledowski", "Wroclaw" }, { "Karol", "Krawczyk", "Warszawa" },
//			{ "15Michal", "Bledowski", "Wroclaw" }, { "Karol", "Krawczyk", "Warszawa" },
//			{ "16Michal", "Bledowski", "Wroclaw" }, { "Karol", "Krawczyk", "Warszawa" },
//			{ "17Michal", "Bledowski", "Wroclaw" }, { "Karol", "Krawczyk", "Warszawa" },
//			{ "18Michal", "Bledowski", "Wroclaw" }, { "Karol", "Krawczyk", "Warszawa" },
//			{ "19Michal", "Bledowski", "Wroclaw" }, { "Karol", "Krawczyk", "Warszawa" },
			{ "20Michal", "Bledowski", "Wroclaw" }, { "Karol", "Krawczyk", "Warszawa" }};
	static Object columnNames[] = { "Imie", "Nazwisko", "Miasto" };

	
	public Table(){
		super(rowData, columnNames);
		setFont(IFonts.TEXT_FONT);
		setDefaultEditor(Object.class, null);
//		setPreferredSize(new Dimension(10,400));
//		addKeyListener(new KeyListener() {
//		    public void keyPressed(KeyEvent e) {
//				if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_UP) {
//					logger.info("Enter pressed!" + e.getKeyCode() + "  " + e.getKeyText(e.getKeyCode()));
//					((Table)e.getComponent()).setSize(((Table)e.getComponent()).getWidth(), ((Table)e.getComponent()).getHeight()+10);
//				}
//				if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_DOWN) {
//					logger.info("Enter pressed!" + e.getKeyCode() + "  " + e.getKeyText(e.getKeyCode()));
//					((Table)e.getComponent()).setSize(((Table)e.getComponent()).getWidth(), ((Table)e.getComponent()).getHeight()-10);
//				}
//		    }
//
//		    public void keyReleased(KeyEvent e) { /* ... */ }
//
//		    public void keyTyped(KeyEvent e) { /* ... */ }
//		});

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

}
