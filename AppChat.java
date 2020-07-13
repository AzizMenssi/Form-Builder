import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class AppChat extends JFrame implements ActionListener {
		JTextArea A;
		JTextField F;
		Client c;
		affichThread T;
	public AppChat(Client C) {
		T=new affichThread();
		c=C;
		this.setTitle("Chat");
		this.setLayout(null);
		this.setSize(new Dimension(600,700));
		A=new JTextArea();
		F=new JTextField();
		A.setEditable(false);
		A.setBounds(20,20,500,500);
		F.setBounds(40, 540, 450,30);
		this.add(A);
		this.add(F);
		F.addActionListener(this);
		T.start();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==F){
			c.sendMessage(F.getText());
		}
		
	}
	public class affichThread extends Thread{
		public affichThread() {
		}
		@Override
			public void run() {
				while(true){
					try {
						A.setText(c.M.getAllMsg());
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
	}
}
