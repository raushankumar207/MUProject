package mu.demo.project;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import java.awt.event.*;
public class DCname implements MouseListener{
	JFrame frm;
	JLabel lblcid,lblcname;
	JTextField txtcid,txtcname;
	JButton btnsave,btnsearch,btnupdate;
	JPanel j;
	Font f=new Font("Consolas",Font.BOLD,14);
	public DCname()
	{
		frm=new JFrame("Add Company Name");
		frm.setLayout(null);
		frm.setSize(350,200);
		frm.setLocation(500, 250);
		frm.setResizable(false);
		frm.setFont(f);
		
		lblcid=new JLabel("Company Id");
		lblcid.setBounds(10, 10, 100, 30);
		lblcid.setFont(f);
		frm.add(lblcid);
		
		txtcid=new JTextField();
		txtcid.setBounds(130,10,200,30);
		txtcid.setFont(f);
		frm.add(txtcid);
		
		lblcname=new JLabel("Company Name");
		lblcname.setBounds(10,60,100,30);
		lblcname.setFont(f);
		frm.add(lblcname);
		
		txtcname=new JTextField();
		txtcname.setBounds(130, 60, 200, 30);
		txtcname.setFont(f);
		frm.add(txtcname);
		
		j=new JPanel();
		j.setBounds(10, 110, 330, 50);
		j.setLayout(null);
		j.setBackground(Color.DARK_GRAY);
		frm.add(j);
		
		btnsave=new JButton("New");
		btnsave.setBounds(05, 05, 100, 40);
		btnsave.setFont(f);
		j.add(btnsave);
		btnsave.addMouseListener(this);
		
		btnsearch=new JButton("Search");
		btnsearch.setBounds(115, 05, 100, 40);
		btnsearch.setFont(f);
		j.add(btnsearch);
		
		btnupdate=new JButton("Edit");
		btnupdate.setBounds(225, 05, 100, 40);
		btnupdate.setFont(f);
		j.add(btnupdate);
	
		frm.setVisible(true);
	}
	public static void main(String args[])
	{
		new DCname();
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		btnsave.setBackground(Color.ORANGE);
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		btnsave.setBackground(UIManager.getColor(btnsearch.getBackground()));
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
