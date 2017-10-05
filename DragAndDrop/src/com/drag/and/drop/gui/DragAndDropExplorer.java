package com.drag.and.drop.gui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class DragAndDropExplorer implements Runnable {

	private List<String> queue;

	public DragAndDropExplorer(List<String> q) {
		queue = q;
	}

	@Override
	public void run() {
		Process process;
		try {
			process = new ProcessBuilder("C:\\Users\\blwm\\Desktop\\Desktop\\Windows-API-Code-Pack-1.1-master\\source\\Samples\\Shell\\KnownFoldersBrowser\\CS\\KnownFoldersBrowser\\bin\\Debug\\KnownFoldersBrowser.exe").start();
			InputStream is = process.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line;

			while ((line = br.readLine()) != null) {
				System.out.println(line);
				queue.add(line);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		System.out.println("Koniec");
	}

}
