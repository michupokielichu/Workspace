package com.drag.and.drop.starter;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.drag.and.drop.gui.DragAndDropDialog;
import com.drag.and.drop.gui.DragAndDropExplorer;

public class Main {

	public static void main(String[] args) throws IOException {

		List<String> q = Collections.synchronizedList(new LinkedList<String>());

		Thread p1 = new Thread(new DragAndDropExplorer(q));
		DragAndDropDialog c1 = new DragAndDropDialog(q);

		p1.start();
		c1.run();
		System.out.println("Koniec_");

	}
}