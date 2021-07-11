package com.teluf.login;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ForgotPassword extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private static final String SPACE = " ";
	
	JPanel panel;
	JLabel username, message;
	JTextField username_text;
	JButton check;
	
	File credentials = new File(PathHandler.getPath());
	
	Validate v = new Validate();
	
	protected void run(int x, int y) {
		if(panel == null) {
			username = new JLabel();
			username.setText(SPACE + "username:");
			username_text = new JTextField();
			
			message = new JLabel();
			
			check = new JButton("check");
			check.addActionListener(this);
			
			panel = new JPanel(new GridLayout(2, 1));
			panel.add(username);
			panel.add(username_text);
			panel.add(message);
			panel.add(check);
			
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			setResizable(false);
			setLayout(new BorderLayout());
			add(panel, BorderLayout.CENTER);
			setTitle("forgot password?");
			setSize(x, y);
			setLocationRelativeTo(null);
		}
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("check")) {
			v.checkIfUsernamesExistsAndGivePassword(username_text.getText(), credentials, message);
			username_text.setText("");
		}
	}
}