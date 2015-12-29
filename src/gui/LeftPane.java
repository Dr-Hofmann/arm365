package gui;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class LeftPane extends JPanel{

	JButton btn;
	JTree tree;

	public LeftPane() {
	setBorder(BorderFactory.createLineBorder(Color.black));
	this.setPreferredSize(new Dimension(200, 900));
	tree = new JTree(createTree());
	setLayout(new BorderLayout());
	add(BorderLayout.CENTER, tree);
	
		
	}

	private DefaultMutableTreeNode createTree(){
		
		
		DefaultMutableTreeNode top = new DefaultMutableTreeNode("META_BANK");
		
		DefaultMutableTreeNode subTop = new DefaultMutableTreeNode("Входящие");
		
		DefaultMutableTreeNode subTop2 = new DefaultMutableTreeNode("Исходящие");
		
		DefaultMutableTreeNode subTop3 = new DefaultMutableTreeNode("Рабочие");
		
		DefaultMutableTreeNode subTop4 = new DefaultMutableTreeNode("На отправку");
		
		DefaultMutableTreeNode subTop5 = new DefaultMutableTreeNode("Удаленные");
		
		DefaultMutableTreeNode subTop6 = new DefaultMutableTreeNode("Архив");
		
		top.add(subTop);
		top.add(subTop2);
		top.add(subTop3);
		top.add(subTop4);
		top.add(subTop5);
		top.add(subTop6);
		
	
		return top;
	}
	
	
	public JTree getJTree(){
		
		return tree;
	}

}
