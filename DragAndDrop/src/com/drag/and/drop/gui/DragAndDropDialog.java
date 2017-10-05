package com.drag.and.drop.gui;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

public class DragAndDropDialog extends JDialog{
	private List<String> queue;
	private JPanel dropPanel;
	
	public DragAndDropDialog(List<String> q) {
		queue = q;
	}
	
	public List<File> getFiles(){
		return ((DropPanel)dropPanel).getFiles();
	}

	public void run() throws IOException {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception weTried) {
		}
		dropPanel = new DropPanel();
		setLayout(new GridLayout());
		
		getContentPane().add(new JScrollPane(dropPanel), BorderLayout.CENTER);
		addKeyListener((KeyListener) dropPanel);
		setUndecorated (true);
		setSize(400, 600);
		
		setVisible(true);
		while (queue == null || queue.isEmpty()) {
		}
		String line = queue.remove(0);
		while (!line.startsWith("*") && !line.endsWith("*")) {

			int h1 = Integer.parseInt(line.split(";")[0]);
			int w1 = Integer.parseInt(line.split(";")[1]);
			int x1 = Integer.parseInt(line.split(";")[2]);
			int y1 = Integer.parseInt(line.split(";")[3]);

			int w2 = getWidth();
			int h2 = getHeight();
			int x2 = getX();
			int y2 = getY();
			setModal(false);
			setLocation(x1 + w1-7 , y1);
			setSize(w2, h1-7);
			setFocusable(true);
			setModal(true);
			while (queue.isEmpty()) { }
			line = queue.remove(0);
		}
		if (line.equals("*exit*") || line.equals("*delete_all*")) {
			dispose();
		} 
	}

}
