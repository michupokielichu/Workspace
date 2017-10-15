package com.gui.builder.components;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.apache.log4j.Logger;

import com.gui.builder.variables.IComponent;

public class Image extends JLabel implements IComponent{

	final static Logger logger = Logger.getLogger(Image.class);

	private static final long serialVersionUID = 3145621494948012115L;

	BufferedImage image = null;

	private boolean mObligatory;
	
	private String mId;

	public Image() {
	}

	public Image(String pathToImage) {
		try {
			image = ImageIO.read(new File(pathToImage));
		} catch (IOException e) {
			logger.error("Obraz nie zosta³ znaleziony. Podana œcie¿ka: " + pathToImage);
			logger.error(e.getMessage());
		}
	}
	

	@Override
	public void initialise(String id, String path) {
		mId = id;
		setValue(path);
		setIcon(new ImageIcon(image));
	}
	
	public void scaleImage(int width, int height) {
		double ratio = 1;
		if (height > -1) {
			ratio =  (double)height / (double)image.getHeight();
		}
		if (width > -1) {
			ratio = (double)width/ (double)image.getWidth() ;
		}
		ImageIcon imageIcon = new ImageIcon(image);
		java.awt.Image img = imageIcon.getImage().getScaledInstance((int) (image.getWidth() * ratio),
				(int) (image.getHeight() * ratio), java.awt.Image.SCALE_SMOOTH); 
		setIcon(new ImageIcon(img));
		
	}

	@Override
	public String getId() {
		return null;
	}

	@Override
	public void setObligatory(boolean obligatory) {
		mObligatory = obligatory;
	}

	@Override
	public void setValue(String path) {
		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e) {
			logger.error("Obraz nie zosta³ znaleziony. Podana œcie¿ka: " + path);
			logger.error(e.getMessage());
		}
	}

	@Override
	public void check() {
		
	}
	
	@Override
	public void setDisabled(boolean disabled) {
		setEnabled(!disabled);
	}

	@Override
	public void addParameter(String strArg) {
		// TODO Auto-generated method stub
		
	}

}
