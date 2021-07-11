package com.teluf.login;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Validate {
	private static final String SPACE = " ";
	
	protected void validate(String u, String p, File e, JLabel f) throws NoSuchAlgorithmException, InvalidKeySpecException {
		try {
			p = EncryptionHandler.encrypt(p);
			
			Scanner in = new Scanner(e);
			if(in.hasNextLine()) {
				while(in.hasNextLine()) {
					String s = in.nextLine();
					String[] sArray = s.split("," + SPACE);

					if(u.trim().equals(sArray[0]) && p.trim().equals(sArray[1])) {
						f.setText(SPACE + "hello " + u);
						in.close();
						break;
					}
					else {
						f.setText(SPACE + "invalid credentials");
					}
				}
				in.close();
			}
			else {
				JOptionPane.showMessageDialog(null, "Credentials file is empty, please sign up once\nErr code: Status.FAILURE", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		catch(FileNotFoundException exception) {
			JOptionPane.showMessageDialog(null, "credentials file not found\nErr code: Status.FILE_NOT_FOUND", "Error", JOptionPane.ERROR_MESSAGE);
			PathHandler.createFile();
		}
	}
	
	protected Status usernameExists(String u, File e) throws IOException {
		try {
			Scanner in = new Scanner(e);
			if(in.hasNextLine()) {
				while(in.hasNextLine()) {
					String s = in.nextLine();
					String[] sArray = s.split("," + SPACE);
				
					if(u.trim().equals(sArray[0])) {
						in.close();
						return Status.USERNAME_EXISTS;
					}
				}
				in.close();
			}
			else {
				JOptionPane.showMessageDialog(null, "Credentials file is empty, please sign up once\nErr code: Status.FAILURE", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		catch(FileNotFoundException exception) {
			JOptionPane.showMessageDialog(null, "credentials file not found\nErr code: Status.FILE_NOT_FOUND", "Error", JOptionPane.ERROR_MESSAGE);
			PathHandler.createFile();
		}
		return Status.SUCCESS;
	}
	
	protected void checkIfUsernamesExistsAndGivePassword(String u, File e, JLabel l) {
		if(u.isEmpty()) {
			JOptionPane.showMessageDialog(null, "username field is empty\nErr code: Status.EMPTY_FIELD", "Error", JOptionPane.ERROR_MESSAGE);
		}
		try {
			Scanner in = new Scanner(e);
			if(in.hasNextLine()) {
				while(in.hasNextLine()) {
					String s = in.nextLine();
					String[] sArray = s.split("," + SPACE);
					
					if(u.trim().equals(sArray[0])) {
						JOptionPane.showMessageDialog(null, sArray[1], "Success", JOptionPane.INFORMATION_MESSAGE);
						break;
					}
					else {
						l.setText(SPACE + "username not found");
					}
				}
				in.close();
			}
			else {
				JOptionPane.showMessageDialog(null, "Credentials file is empty, please sign up once\nErr code: Status.FAILURE", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		catch(FileNotFoundException exception) {
			JOptionPane.showMessageDialog(null, "credentials file not found\\nErr code: Status.FILE_NOT_FOUND", "Error", JOptionPane.ERROR_MESSAGE);
			PathHandler.createFile();
		}
	}
}