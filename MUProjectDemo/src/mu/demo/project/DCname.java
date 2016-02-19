package mu.demo.project;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;

import java.awt.event.*;
public class DCname implements MouseListener{
	JFrame frm;
	JLabel lblcid,lblcname;
	JTextField txtcid,txtcname;
	JButton btnsave,btnsearch,btnupdate;
	JPanel j;
	String html="<html><p bgcolor=\"red\"><font color=\"#7CFC00\" " + "size=\"05\" face=\"Kruti Dev 010\"> ;gk¡ dEifu dk uke vafdr djsaA" + "</font></p></html>";
	Font f=new Font("Consolas",Font.BOLD,14);
	public DCname()
	{
		frm=new JFrame("Add Company Name");
		frm.setLayout(null);
		frm.setSize(350,200);
		frm.setLocation(500, 250);
		frm.setResizable(false);
		frm.setFont(f);
		
		UIManager.put("Tooltip.font", new FontUIResource("Consolas", Font.ITALIC, 12));
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
		txtcname.addMouseListener(this);
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
		btnsearch.addMouseListener(this);
		
		btnupdate=new JButton("Edit");
		btnupdate.setBounds(225, 05, 100, 40);
		btnupdate.setFont(f);
		j.add(btnupdate);
		btnupdate.addMouseListener(this);
	
		frm.setVisible(true);
	}
	public static void main(String args[])
	{
		new DCname();
	}
	@Override
	public void mouseClicked(MouseEvent evt) {
		// TODO Auto-generated method stub
		if(evt.getSource().equals(btnsave))
		{
			if(btnsave.getText().equals("New"))
			{
				btnsave.setText("Save");
			}
		}
	}
	@Override
	public void mouseEntered(MouseEvent evt) {
		// TODO Auto-generated method stub
		
		if(evt.getSource().equals(btnsave))
		{
			btnsave.setBackground(Color.ORANGE);
		}
		if(evt.getSource().equals(btnsearch))
		{
			btnsearch.setBackground(Color.orange);
		}
		if(evt.getSource().equals(btnupdate))
		{
			btnupdate.setBackground(Color.orange);
		}
		if(evt.getSource().equals(txtcname))
		{
			txtcname.setToolTipText(html);
		}
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//btnsave.setBackground(UIManager.getColor(btnsearch.getBackground()));
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
