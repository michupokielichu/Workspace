package com.drag.and.drop.gui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class ImagePane extends JPanel {

		private Image img = null;
		Image imgContainer = null;
		private boolean remove = false;
		int width = 0;
		int height = 0;
		File source;
		int IMAGE_SIZE = 100;
		
		
		public ImagePane(File source) throws IOException {
			
			setBackground(Color.RED);
			setBackground(Color.white);
			this.source=source;
			img = ImageIO.read(source);
			if (img.getWidth(this) > IMAGE_SIZE || img.getHeight(this) > IMAGE_SIZE) {
				width = img.getWidth(this);
				height = img.getWidth(this);
				float scaleWidth = ((float)IMAGE_SIZE) / width;
				float scaleHeight = ((float)IMAGE_SIZE) / height;
				if (scaleWidth > scaleHeight) {
					width = -1;
					height = (int) (height * scaleHeight);
				} else {
					width = (int) (width * scaleWidth);
					height = -1;
				}
				img = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);

				addMouseListener(new MouseAdapter() {

					@Override
					public void mousePressed(MouseEvent e) {
						remove =!remove;
						imgContainer = img;
						img = null;
						repaint();
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						img = imgContainer;
						repaint();
					}
				});
			}
		}

		@Override
		public Dimension getPreferredSize() {
			return new Dimension(IMAGE_SIZE, IMAGE_SIZE);
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g.create();
			if (img != null) {
				g2d.drawImage(img, 0, 0, this);
				if (remove) {
					setBorder(BorderFactory.createLineBorder(Color.RED, 5));
				} else {
					setBorder(null);
				}
			}
			g2d.dispose();
		}
		
		public boolean getRemoveFlag() {
			return remove;
		}
	}