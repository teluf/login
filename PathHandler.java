package com.teluf.login;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

public class PathHandler {
	private static final String path = "C:" + File.separator + "Internal" + File.separator + "u21213_p";
	private static final String path2 = path + File.separator + "uu12.txt";
	
	protected static void createFile() {
		File f = new File(path);
		File f1 = new File(path2);
		f.mkdirs();
		try {
			f1.createNewFile();
			JOptionPane.showMessageDialog(null, "credentials file now created", "Success", JOptionPane.INFORMATION_MESSAGE);
		} 
		catch (IOException e) {
		}
	}
	
	protected static String getPath() {
		return path2;
	}
}