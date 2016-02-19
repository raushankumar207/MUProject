package mu.demo.project;

import java.awt.Font;

import javax.swing.*;

public class DrugsMaster {
	JFrame frm;
	JLabel lblmid,lblmname,lbldname,lbltype,lblmor,lblnoon,lbleve,lbldosage,lbldosremark,lblduration,lbldcname;
	JTextField txtmid,txtmname,txtdosremark,txtduration,txtdcname;
	JComboBox cmbtype,cmbmor,cmbnoon,cmbeve,cmbdname;
	JButton btndadd,btnsave;
	String drugstype[]={"Tablets","Capsule","Syrup","Powder","Injection"};
	String dosg[]={"0","1","1.2","2"};
	public DrugsMaster()
	{
		frm=new JFrame("Durgs Master");
		frm.setLayout(null);
		frm.setSize(500,500);
		frm.setLocation(500,150);
		frm.setResizable(false);
		
		Font f=new Font("Consolas",Font.BOLD,14);
		
		lblmid=new JLabel("Medicine Id");
		lblmid.setBounds(10, 20, 120, 30);
		lblmid.setFont(f);
		frm.add(lblmid);
		
		txtmid=new JTextField();
		txtmid.setBounds(160,20, 100, 30);
		txtmid.setFont(f);
		txtmid.setToolTipText("<html><p bgcolor=\"red\"><font color=\"#EFF7FB\" " + "size=\"05\" face=\"Monotype Corsiva\"> Enter Medicine Id" + "</font></p></html>");
		frm.add(txtmid);
		
		lblmname=new JLabel("Medicine Name");
		lblmname.setBounds(10,60,120,30);
		lblmname.setFont(f);
		frm.add(lblmname);
		
		txtmname=new JTextField();
		txtmname.setBounds(160,60,200,30);
		txtmname.setFont(f);
		txtmname.setToolTipText("<html><p bgcolor=\"red\"><font color=\"#EFF7FB\" " + "size=\"05\" face=\"Monotype Corsiva\"> Enter Medicine Name" + "</font></p></html>");
		frm.add(txtmname);
		
		lbldname=new JLabel("Drugs");
		lbldname.setBounds(10,100,120,30);
		lbldname.setFont(f);
		frm.add(lbldname);
		
		cmbdname=new JComboBox();
		cmbdname.setBounds(160,100,200,30);
		cmbdname.setFont(f);
		cmbdname.setEditable(true);
		cmbdname.setToolTipText("<html><p bgcolor=\"red\"><font color=\"#EFF7FB\" " + "size=\"05\" face=\"Monotype Corsiva\"> Enter Drugs" + "</font></p></html>");
		frm.add(cmbdname);
		
		btndadd=new JButton("Add Drugs");
		btndadd.setBounds(370, 100, 110,30);
		btndadd.setFont(f);
		btndadd.setToolTipText("<html><p bgcolor=\"red\"><font color=\"#EFF7FB\" " + "size=\"05\" face=\"Monotype Corsiva\"> Add Drug Name" + "</font></p></html>");
		frm.add(btndadd);
		lbltype=new JLabel("Type");
		lbltype.setBounds(10, 140, 130, 30);
		lbltype.setFont(f);
		frm.add(lbltype);
		
		cmbtype=new JComboBox(drugstype);
		cmbtype.setBounds(160, 140, 150, 30);
		cmbtype.setFont(f);
		cmbtype.setToolTipText("<html><p bgcolor=\"red\"><font color=\"#EFF7FB\" " + "size=\"05\" face=\"Monotype Corsiva\"> Select Medicine Type" + "</font></p></html>");
		frm.add(cmbtype);
		
		lblmor=new JLabel("Morning");
		lblmor.setBounds(160, 180, 60, 30);
		lblmor.setFont(f);
		frm.add(lblmor);
		
		lblnoon=new JLabel("Noon");
		lblnoon.setBounds(240, 180, 40, 30);
		lblnoon.setFont(f);
		frm.add(lblnoon);
		
		lbleve=new JLabel("Evening");
		lbleve.setBounds(320, 180, 60, 30);
		lbleve.setFont(f);
		frm.add(lbleve);
		
		lbldosage=new JLabel("Dosage");
		lbldosage.setBounds(10,210,120,30);
		lbldosage.setFont(f);
		frm.add(lbldosage);
		
		cmbmor=new JComboBox(dosg);
		cmbmor.setBounds(160,210,60,30);
		cmbmor.setFont(f);
		cmbmor.setToolTipText("<html><p bgcolor=\"red\"><font color=\"#EFF7FB\" " + "size=\"05\" face=\"Monotype Corsiva\"> Select Morning Dosage" + "</font></p></html>");
		frm.add(cmbmor);
		
		cmbnoon=new JComboBox(dosg);
		cmbnoon.setBounds(240,210,60,30);
		cmbnoon.setFont(f);
		cmbnoon.setToolTipText("<html><p bgcolor=\"red\"><font color=\"#EFF7FB\" " + "size=\"05\" face=\"Monotype Corsiva\"> Select Noon Dosage" + "</font></p></html>");
		frm.add(cmbnoon);
		
		cmbeve=new JComboBox(dosg);
		cmbeve.setBounds(320,210,60,30);
		cmbeve.setFont(f);
		cmbeve.setToolTipText("<html><p bgcolor=\"red\"><font color=\"#EFF7FB\" " + "size=\"05\" face=\"Monotype Corsiva\"> Select Evening Dosage" + "</font></p></html>");
		frm.add(cmbeve);
		
		lbldosremark=new JLabel("Dosage Remark");
		lbldosremark.setBounds(10, 250, 120,30);
		lbldosremark.setFont(f);
		frm.add(lbldosremark);
		
		txtdosremark=new JTextField();
		txtdosremark.setBounds(160, 250, 270, 30);
		txtdosremark.setFont(f);
		frm.add(txtdosremark);
		
		lblduration=new JLabel("Duration (Days)");
		lblduration.setBounds(10, 290, 120, 30);
		lblduration.setFont(f);
		frm.add(lblduration);
		
		txtduration=new JTextField("");
		txtduration.setBounds(160,290,100,30);
		txtduration.setFont(f);
		txtduration.setToolTipText("<html><p bgcolor=\"red\"><font color=\"#EFF7FB\" " + "size=\"05\" face=\"Monotype Corsiva\"> Enter Medicine Days" + "</font></p></html>");
		frm.add(txtduration);
		
		lbldcname=new JLabel("Company Name");
		lbldcname.setBounds(10,330,120,30);
		lbldcname.setFont(f);
		frm.add(lbldcname);
		
		txtdcname=new JTextField();
		txtdcname.setBounds(160,330, 200, 30);
		txtdcname.setFont(f);
		txtdcname.setToolTipText("<html><p bgcolor=\"red\"><font color=\"#EFF7FB\" " + "size=\"05\" face=\"Monotype Corsiva\"> Enter Company Name" + "</font></p></html>");
		frm.add(txtdcname);
		
		btnsave=new JButton("Save");
		btnsave.setBounds(160, 370, 100,40);
		btnsave.setFont(f);
		frm.add(btnsave);
		
		frm.setVisible(true);
	}
	public static void main(String args[])
	{
		new DrugsMaster();
	}
}
