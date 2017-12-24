package UserInterface;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Socket.ClientController;

public class MainView extends JFrame {
	
	/**
	 * M10456012
	 * Kevin Yen
	 * kelly10056040@gmail.com
	 */
	private static final long serialVersionUID = 1L;

	//*****宣告介面*****//
	Container cp = this.getContentPane();
	
	//*****宣告元件*****//
	JLabel ipAddressLabel = new JLabel("IP Address:");
	JLabel portNumberLabel = new JLabel("Port Number:");
	JLabel statusLabel = new JLabel("Status: ");
	JLabel contentLabel = new JLabel("Send content: ");
	
	JTextField ipAddressTextField = new JTextField("140.127.22.141");
	JTextField portNumberTextField = new JTextField("8000");
	JTextField contentTextField = new JTextField("Test");
	
	JButton contactServerButton = new JButton("Contact Server");
	
	MainView()
	{
		//*****設定介面*****//
		this.setSize(300, 300);
		this.setLayout(null);
		this.setTitle("Client Socket");
		
		//*****設定元件位置*****//
		ipAddressLabel.setBounds(30, 30, 100, 30);
		ipAddressTextField.setBounds(120, 30, 120, 30);
		portNumberLabel.setBounds(30, 70, 100, 30);
		portNumberTextField.setBounds(120, 70, 120, 30);
		contentLabel.setBounds(30, 110, 100, 30);
		contentTextField.setBounds(30, 150, 210, 30);
		
		contactServerButton.setBounds(30, 190, 210, 30);
		statusLabel.setBounds(30, 230, 210, 30);
		
		cp.add(ipAddressLabel);
		cp.add(ipAddressTextField);
		cp.add(portNumberLabel);
		cp.add(portNumberTextField);
		cp.add(contentLabel);
		cp.add(contentTextField);
		cp.add(contactServerButton);
		cp.add(statusLabel);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		contactServerButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ClientController client = new ClientController();
				if (client.sentMessage(ipAddressTextField.getText(), 
						Integer.parseInt(portNumberTextField.getText()), 
						contentTextField.getText())) {
					statusLabel.setText("Status: Message sending success");
				} else {
					statusLabel.setText("Status: Message sending fail");
				}
			}});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainView();
	}
}
