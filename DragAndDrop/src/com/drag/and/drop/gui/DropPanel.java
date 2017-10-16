package com.drag.and.drop.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TooManyListenersException;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.drag.and.drop.layout.WrapLayout;

public class DropPanel extends JPanel implements KeyListener {

	private JPanel imagesPane;
	private DropTarget dropTarget;
	private DropTargetHandler dropTargetHandler;
	private JPanel statusBar;
	private Color panelColor = Color.WHITE;
	private Image image = null;
	private int iWidth2;
	private int iHeight2;
	
	private List<File> fileList;
	private List<ImagePane> imagePaneList;

	public DropPanel() throws IOException {
		fileList = new ArrayList<>();
		imagePaneList = new ArrayList<>();
		setLayout(new BorderLayout());
		imagesPane = new JPanel(new WrapLayout()) {
			@Override
			public void paintComponent(Graphics g)
			{
			    super.paintComponent(g);
			    if (image != null)
			    {
//			    	float scaleWidth = ((float)this.getParent().getWidth()) / image.getWidth(this);
//					image = image.getScaledInstance((int)(image.getWidth(this)*scaleWidth),(int)( image.getHeight(this)*scaleWidth), Image.SCALE_SMOOTH);
//					
			        int x = 0;
			        int y = this.getParent().getHeight()/2 - iHeight2;
			        g.drawImage(image,x,y,this);

			    }
			}
		};
		imagesPane.setBackground(Color.WHITE);
		statusBar = new StatusBar();
		
		File imgeFile = new File("C:\\Users\\blwm\\Desktop\\arrow.png");
		image = ImageIO.read(imgeFile);
		this.iWidth2 = image.getWidth(this) / 2;
		this.iHeight2 = image.getHeight(this) / 2;

		add(imagesPane);
		add(statusBar, BorderLayout.SOUTH);
	}


	
	public List<File> getFiles() {
		return fileList.stream().map(File.class::cast).collect(Collectors.toList());
	}

	protected DropTarget getMyDropTarget() {
		if (dropTarget == null) {
			dropTarget = new DropTarget(this, DnDConstants.ACTION_COPY_OR_MOVE, null);
		}
		return dropTarget;
	}

	protected DropTargetHandler getDropTargetHandler() {
		if (dropTargetHandler == null) {
			dropTargetHandler = new DropTargetHandler();
		}
		return dropTargetHandler;
	}

	@Override
	public void addNotify() {
		super.addNotify();
		try {
			getMyDropTarget().addDropTargetListener(getDropTargetHandler());
		} catch (TooManyListenersException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void removeNotify() {
		super.removeNotify();
		getMyDropTarget().removeDropTargetListener(getDropTargetHandler());
	}

	private void importFiles(List<File> files) {
		Runnable run = new Runnable() {
			@Override
			public void run() {
				updateFileList(files);
			}
		};
		SwingUtilities.invokeLater(run); 
	}

	private void updateFileList(List<File> files) {
		if (files != null && !files.isEmpty()) {
			fileList.addAll(files);
		}
		imagesPane.removeAll();
		imagePaneList.clear();
		for (File file : fileList) {
			try {
				ImagePane pane = new ImagePane(file);
				imagesPane.add(pane);
				imagePaneList.add(pane);
			} catch (Exception exp) {
				exp.printStackTrace();
			}
		}
		imagesPane.revalidate();
		imagesPane.repaint();

	}

	protected class DropTargetHandler implements DropTargetListener {

		@Override
		public void dragEnter(DropTargetDragEvent dtde) {
		}

		@Override
		public void dragOver(DropTargetDragEvent dtde) {
		}

		@Override
		public void dropActionChanged(DropTargetDragEvent dtde) {
		}

		@Override
		public void dragExit(DropTargetEvent dte) {
		}

		@Override
		public void drop(DropTargetDropEvent dtde) {
			Transferable transferable = dtde.getTransferable();
			// if (dtde.isDataFlavorSupported(DataFlavor.imageFlavor)) {
			dtde.acceptDrop(dtde.getDropAction());
			try {
				List<File> transferData = (List<File>) transferable.getTransferData(DataFlavor.javaFileListFlavor);
				transferData.stream().forEach(d -> System.out.println(d.getAbsolutePath()));
				if (transferData != null && transferData.size() > 0) {
					importFiles(transferData);
					dtde.dropComplete(true);
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyChar());
		if (e.getKeyCode() == KeyEvent.VK_DELETE) {
			List<File> fileToRemove = new ArrayList<>();
			for (int i = 0; i < imagePaneList.size(); i++) {
				if (imagePaneList.get(i).getRemoveFlag()) {
					fileToRemove.add(fileList.get(i));
				}
			}
			fileList.removeAll(fileToRemove);
			updateFileList(null);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}