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

public class ResetPassword extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	JPanel panel;
	JLabel username, password, confirm_p, message;
	JTextField username_text;
	JPasswordField password_text, confirm_p_text;
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
			
			confirm_p = new JLabel();
			confirm_p.setText(" new password:");
			confirm_p_text = new JPasswordField();
			
			message = new JLabel();
			
			confirm = new JButton("confirm");
			confirm.addActionListener(this);
			
			panel = new JPanel(new GridLayout(4, 1));
			panel.add(username);
			panel.add(username_text);
			panel.add(password);
			panel.add(password_text);
			panel.add(confirm_p);
			panel.add(confirm_p_text);
			panel.add(message);
			panel.add(confirm);
			
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			setResizable(false);
			setLayout(new BorderLayout());
			add(panel, BorderLayout.CENTER);
			setTitle("reset password");
			setSize(x, y);
			setLocationRelativeTo(null);
		}
		setVisible(true);
	}
	
	private void replacePassword(String u, String p, String cp, File e, JLabel t) throws IOException {
		try {
			Scanner in = new Scanner(e);
			if(in.hasNextLine()) {
				while(in.hasNextLine()) {
					String s = in.nextLine();
					String[] sArray = s.split(", ");
					
					if(u.trim().equals(sArray[0]) && p.trim().equals(sArray[1])) {
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
				                oldContent = oldContent + line + System.lineSeparator();
				                line = reader.readLine();
				            }
				            writer = new FileWriter(e);
				            writer.write(oldContent);
				            writer.write(sArray[0] + ", " + cp);
				            reader.close();
				            writer.close();
				        }
				        catch (IOException e1) {}
						
						in.close();
						JOptionPane.showMessageDialog(null, "Success", "Success", JOptionPane.INFORMATION_MESSAGE);
						setVisible(false);
						break;
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
			JOptionPane.showMessageDialog(null, "credentials file not found\nErr code: Status.FILE_NOT_FOUND", "Error", JOptionPane.ERROR_MESSAGE);
			PathHandler.createFile();
		}
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("confirm")) {
			String u = username_text.getText();
			String p = password_text.getText();
			String cp = confirm_p_text.getText();
			File credentials = new File(PathHandler.getPath());
			
			if(u.isEmpty() && p.isEmpty() && cp.isEmpty()) 
				JOptionPane.showMessageDialog(null, "Username, Password, New Password fields are blank\nErr code: Status.EMPTY_FIELD", "Error", JOptionPane.ERROR_MESSAGE);
			else if(u.isEmpty()) 
				JOptionPane.showMessageDialog(null, "Username field is blank\nErr code: Status.EMPTY_FIELD", "Error", JOptionPane.ERROR_MESSAGE);
			else if(p.isEmpty()) 
				JOptionPane.showMessageDialog(null, "Password field is blank\nErr code: Status.EMPTY_FIELD", "Error", JOptionPane.ERROR_MESSAGE);
			else if(cp.isEmpty())
				JOptionPane.showMessageDialog(null, "New Password field is blank\nErr code: Status.EMPTY_FIELD", "Error", JOptionPane.ERROR_MESSAGE);
			else if(cp.contains(" "))
				JOptionPane.showMessageDialog(null, "Spaces aren't allowed\nErr code: Status.FAILURE", "Error", JOptionPane.ERROR_MESSAGE);
			else if(p.equals(cp))
				JOptionPane.showMessageDialog(null, "The values entered for new password and old are the same\nErr code: Status.FAILURE", "Error", JOptionPane.ERROR_MESSAGE);
			else {
				try {
					replacePassword(u.trim(), p.trim(), cp.trim(), credentials, message);
					username_text.setText("");
					password_text.setText("");
					confirm_p_text.setText("");
				} 
				catch (IOException exception) {}
			}
		}
	}
}