package com.teluf.login;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ResetUsername extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	JPanel panel;
	JLabel username, password, confirm_u, message;
	JTextField username_text, confirm_u_text;
	JPasswordField password_text;
	JButton confirm;
	
	Validate v = new Validate();
	
	protected void run(int x, int y) {
		if(panel == null) {
			username = new JLabel();
			username.setText(" username:");
			username_text = new JTextField();
			
			password = new JLabel();
			password.setText(" password:");
			password_text = new JPasswordField();
			
			confirm_u = new JLabel();
			confirm_u.setText(" new username:");
			confirm_u_text = new JTextField();
			
			message = new JLabel();
			
			confirm = new JButton("confirm");
			confirm.addActionListener(this);
			
			panel = new JPanel(new GridLayout(4, 1));
			panel.add(username);
			panel.add(username_text);
			panel.add(password);
			panel.add(password_text);
			panel.add(confirm_u);
			panel.add(confirm_u_text);
			panel.add(message);
			panel.add(confirm);
			
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			setResizable(false);
			setLayout(new BorderLayout());
			add(panel, BorderLayout.CENTER);
			setTitle("reset username");
			setSize(x, y);
			setLocationRelativeTo(null);
		}
		setVisible(true);
	}
	
	private void replaceUsername(String u, String p, String cu, File e, JLabel t) throws IOException {
		try {
			Scanner in = new Scanner(e);
			if(in.hasNextLine()) {
				while(in.hasNextLine()) {
					String s = in.nextLine();
					String[] sArray = s.split(", ");
					
					if(u.trim().equals(sArray[0]) && p.trim().equals(sArray[1])) {
						if(v.usernameExists(cu, e) == Status.USERNAME_EXISTS) {
							JOptionPane.showMessageDialog(null, "that username already exists\nErr code: Status.USERNAME_EXISTS", "Error", JOptionPane.ERROR_MESSAGE);
						}
						else {
							String oldContent = "";
					        BufferedReader reader = null;
					        FileWriter writer = null;
					         
					        try {
					            reader = new BufferedReader(new FileReader(e));
					            String line = reader.readLine();
					            String needsToBeReplaced = u.trim() + ", " + p.trim();
					            while (line != null) {
					            	if(line.equals(needsToBeReplaced)) {
					            		line = "";
					            	}
					                oldContent += (line + System.lineSeparator());
					                line = reader.readLine();
					            }
					            writer = new FileWriter(e);
					            writer.write(oldContent);
					            writer.write(cu + ", " + sArray[1]);
					            reader.close();
					            writer.close();
					        }
					        catch (IOException e1) {
					        	JOptionPane.showMessageDialog(null, "something failed\nErr code: Status.FAILURE", "Error", JOptionPane.ERROR_MESSAGE);
					        }
							
							in.close();
							JOptionPane.showMessageDialog(null, "Success", "Success", JOptionPane.INFORMATION_MESSAGE);
							setVisible(false);
							break;
						}  
					}
					else {
						t.setText(" invalid credentials");
					}
				}
				in.close();
			}
			else {
				JOptionPane.showMessageDialog(null, "Credentials file is empty, please sign up once\nErr code: Status.FAILURE", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		catch(FileNotFoundException exception) {
			JOptionPane.showMessageDialog(null, "credentials file not found", "Error", JOptionPane.ERROR_MESSAGE);
			PathHandler.createFile();
		}
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("confirm")) {
			String u = username_text.getText();
			String p = password_text.getText();
			String cu = confirm_u_text.getText();
			File credentials = new File(PathHandler.getPath());
			
			if(u.isEmpty() && p.isEmpty() && cu.isEmpty()) 
				JOptionPane.showMessageDialog(null, "Username, Password, New Username fields are blank\nErr code: Status.EMPTY_FIELD", "Error", JOptionPane.ERROR_MESSAGE);
			else if(u.isEmpty()) 
				JOptionPane.showMessageDialog(null, "Username field is blank\nErr code: Status.EMPTY_FIELD", "Error", JOptionPane.ERROR_MESSAGE);
			else if(p.isEmpty()) 
				JOptionPane.showMessageDialog(null, "Password field is blank\nErr code: Status.EMPTY_FIELD", "Error", JOptionPane.ERROR_MESSAGE);
			else if(cu.isEmpty())
				JOptionPane.showMessageDialog(null, "New Username field is blank\nErr code: Status.EMPTY_FIELD", "Error", JOptionPane.ERROR_MESSAGE);
			else if(cu.contains(" "))
				JOptionPane.showMessageDialog(null, "Spaces aren't allowed\nErr code: Status.FAILURE", "Error", JOptionPane.ERROR_MESSAGE);
			else if(p.equals(cu))
				JOptionPane.showMessageDialog(null, "The values entered for new username and old are the same\nErr code: Status.FAILURE", "Error", JOptionPane.ERROR_MESSAGE);
			else {
				try {
					replaceUsername(u.trim(), p.trim(), cu.trim(), credentials, message);
					username_text.setText("");
					password_text.setText("");
					confirm_u_text.setText("");
				} 
				catch (IOException exception) {}
			}
		}
	}
}