package com.uni.labo.starter;

import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JFrame;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.gui.builder.components.Dialog;
import com.gui.builder.translate.Translator;
import com.uni.labo.hibernate.HibernateUtil;
import com.uni.labo.login.LoginWindow;
import com.uni.labo.main.MainFrame;

public class Main {
	private static Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		logger.info("LaboUNI has just been started on "+ System.getProperty("os.name"));
		Session session = HibernateUtil.getSessionFactory().openSession();

		 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					Splash sp = new Splash();
					try {
						Translator.readXLSXFile();
					} catch (IOException e) {
						e.printStackTrace();
					}
					JFrame main = new MainFrame();
					JDialog loginWindow = new LoginWindow();
					main.setVisible(true);
					((Dialog)loginWindow).showDialog().equals("correctly_logged");
						
						
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
