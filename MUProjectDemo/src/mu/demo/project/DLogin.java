
package mu.demo.project;

import javax.swing.*;
import Login.*;
import java.awt.Font;
import java.awt.event.*;

public class DLogin extends JFrame implements ActionListener {

	/**
	 * @param args
	 */
	JFrame frm;
	JLabel lbluname,lblpassword;
	JTextField txtuname;
	JPasswordField txtpassword;
	JButton btnlogin,btnregister;
	Boolean flag;
	Font f;
	public DLogin()
	{
		frm=new JFrame();
		frm.setTitle("Login");
		frm.setSize(350,200);
		frm.setLocation(400, 250);
		frm.setLayout(null);
		frm.setResizable(false);
		
		f=new Font("Consolas", Font.BOLD,14);
		
		lbluname=new JLabel("User Name");
		lbluname.setBounds(20, 20, 100, 30);
		frm.add(lbluname);
		
		txtuname=new JTextField();
		txtuname.setBounds(150, 20, 170, 30);
		txtuname.setFont(f);
		frm.add(txtuname);
		
		lblpassword=new JLabel("Password");
		lblpassword.setBounds(20, 60, 100, 30);
		frm.add(lblpassword);
		
		txtpassword=new JPasswordField();
		txtpassword.setBounds(150, 60, 170, 30);
		txtpassword.setFont(f);
		frm.add(txtpassword);
		
		btnlogin=new JButton("Login");
		btnlogin.setBounds(150, 100, 75, 40);
		frm.add(btnlogin);
		btnlogin.addActionListener(this);
		
		btnregister=new JButton("Register");
		btnregister.setBounds(235, 100, 85, 40);
		frm.add(btnregister);
		btnregister.addActionListener(this);
		
		
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		changelookfeel();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DLogin();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnlogin))
		{
			UserLogin ul=new UserLogin(txtuname.getText(), txtpassword.getText());
			if(frmvalidate())
			{
				if(ul.validatelogin())
				{
					JOptionPane.showMessageDialog(null, "Login Successfull");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Login UnSuccessfull");
					txtuname.setText("");
					txtpassword.setText("");
					txtuname.grabFocus();
				}
			}
		}
		else if(e.getSource().equals(btnregister))
		{
			new DRegister();
			frm.hide();
		}
		
	}
	public boolean frmvalidate()
	{
		flag=true;
		if(txtuname.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "Enter User Name");
			txtuname.grabFocus();
			flag=false;
		}
		else if(txtpassword.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "Enter User Password");
			txtpassword.grabFocus();
			flag=false;
		}
		return flag;
	}
	public  void changelookfeel()
	{
		try {
			//UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI(this);
	}


}
