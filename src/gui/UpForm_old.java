package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class UpForm_old extends JPanel{


	private JLabel nameLabel;
	private JLabel occupationLabel;
	private JTextField nameField;
	private JTextField occupationField;
	
	private JButton okbtn;
	
	private FormListener formListener;
	private JList ageList;
	private JComboBox emp;
	
	private JCheckBox citizenCheck;
	private JTextField taxField;
	private JLabel taxLabel;
	
	private JRadioButton male;
	private JRadioButton female;
	private ButtonGroup genderGroup;
	
	public UpForm_old() {
		
		
		
	//Р§РµСЂРµР· РѕР±СЉРµРєС‚ dimension - Р·Р°РґР°РµС‚СЃСЏ СЂР°Р·РјРµСЂРЅРѕСЃС‚СЊ РєРѕРјРїРѕРЅРµРЅС‚Р° РјРµС‚РѕРґ setPreferedSize
	this.setPreferredSize(new Dimension(1200, 300));	
		
	setBorder(BorderFactory.createLineBorder(Color.black));
	
	nameLabel = new JLabel("Name: ");
	occupationLabel = new JLabel("Occupation: ");
	nameField = new JTextField(100);
	occupationField = new JTextField(100);
	okbtn = new JButton("ok");
	
	citizenCheck = new JCheckBox();
	
	taxField = new JTextField(11);
	
	taxLabel = new JLabel("Tax ID");
	
	//SetUp tax ID
	
	taxField.setEnabled(false);
	taxLabel.setEnabled(false);
	
	citizenCheck.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			boolean isTicked = citizenCheck.isSelected();
			
			taxField.setEnabled(isTicked);
			taxLabel.setEnabled(isTicked);
			
		}
		
		
		
	});
	
	male = new JRadioButton("male");
	female = new JRadioButton("female");
	
	genderGroup = new ButtonGroup();
	
	
	//Setup gender Radio;
	
	genderGroup.add(male);
	genderGroup.add(female);
	
	male.setActionCommand("male");
	female.setActionCommand("female");
	
	male.setSelected(true);
	
	
	
	///////////////////////////////////////////////////////////////////////////////
	//JList РєРѕРјРїРѕРЅРµРЅС‚ РёСЃРїРѕР»СЊР·СѓРµС‚ ListModel РґР»СЏ РІРѕР·РјРѕР¶РЅРѕСЃС‚Рё РґРѕР±Р°РІР»СЏС‚СЊ РґР°РЅРЅС‹Рµ РІ JList,
	///////////////////////////////////////////////////////////////////////////////
	ageList = new JList();
	
	DefaultListModel ageModel = new DefaultListModel();
	
	ageModel.addElement(new AgeCategory(0, "under 18"));
	ageModel.addElement(new AgeCategory(1,"18 to 65"));
	ageModel.addElement(new AgeCategory(2, "65 or over"));
	
	ageList.setModel(ageModel); 
	
	ageList.setPreferredSize(new Dimension(120, 60));
	ageList.setSelectedIndex(0);
	
	ageList.setBorder(BorderFactory.createEtchedBorder());
	
	//---------End of JList
	
	
	
	
	//РџРѕС…РѕР¶РёРј РїСЂРёРЅС†РёРїРѕРј Р·Р°РїРѕР»РЅСЏРµРј JComboBox
	
	
	emp = new JComboBox();

	DefaultComboBoxModel empModel = new DefaultComboBoxModel();
	
	empModel.addElement("Employed");
	empModel.addElement("Self-employed");
	empModel.addElement("unemployed");
	
	emp.setModel(empModel);
	//end of combo
	
	
	
	
	
	okbtn.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			String name = nameField.getText();
			String occupation = occupationField.getText();
			AgeCategory ageCat = (AgeCategory)ageList.getSelectedValue();
			String taxId = taxField.getText();
			boolean usCitizen = citizenCheck.isSelected();
			
			String empVal = (String)emp.getSelectedItem();  
			
			String genderValue = genderGroup.getSelection().getActionCommand();
			
			
			
		//	System.out.println(genderValue);
			
			FormEvent ev = new FormEvent(this, name, occupation, ageCat.toString(), ageCat.getId(), empVal,  taxId, usCitizen, genderValue);
			
			if(formListener!= null){
				formListener.formEventOccured(ev);
				
			}
			
		}

	});

	
	//Р”Р»СЏ РїРѕР·РёС†РёР°РЅРёСЂРѕРІР°РЅРёСЏ РєРѕРјРїРѕРЅРµРЅС‚РѕРІ swing  С‚Р°Рє РЅР°Р·С‹РІР°РµРјС‹Р№ РјР°РєРµС‚ - layout - РёС… РЅРµСЃРєРѕР»СЊРєРѕ С‚РёРїРѕРІ
	//РІ РѕСЃРЅРѕРІРЅРѕРј BorderLayout() Рё GridBagControl();
	setLayout(new GridBagLayout());
	
	//РЈРїСЂР°РІР»СЏРµРј С‡РµСЂРµР· constraint - РїРµСЂРµРјРµС‰Р°РµРј - СѓРїСЂР°РІР»СЏРµРј РєРѕРјРїРѕРЅРµРЅС‚Р°РјРё
	GridBagConstraints gc = new GridBagConstraints();
	
	
	//FIRST ROW
	
	gc.weightx = 1;
	gc.weighty = 0;
	
	//Р”Р°РЅРЅС‹Р№ РјРµС‚РѕРґ Р·Р°РґР°РµС‚ РїРѕР·РёС†РёСЋ РІ С‚Р°Р±Р»РёС†Рµ РІ СЃС‚СЂРѕРєРµ Рё СЃРѕР»Р±С†Рµ СЃРѕРѕС‚РІРµС‚СЃС‚РІРµРЅРЅРѕ
	gc.gridx = 0;
	gc.gridy = 0;
	
	//Р”РѕРїРѕР»РЅРёС‚РµР»СЊРЅР°СЏ РїСѓСЃС‚Р°СЏ РѕР±Р»Р°СЃС‚СЊ РјРµР¶РґСѓ РєРѕР»РѕРЅРЅР°РјРё Рё СЃС‚СЂРѕРєР°РјРё
	//gc.weightx = 1;
	//gc.weighty = 1;
	
	//РљРѕРіРґР° СЏС‡РµР№РєР° - РѕС‚РѕР±СЂР°Р¶Р°РµРјР°СЏ РѕР±Р»Р°СЃС‚СЊ РєРѕРјРїРѕРЅРµРЅС‚Р° Р±РѕР»СЊС€Рµ С‡РµРј СЃР°Рј РєРѕРјРїРѕРЅРµРЅС‚, РґР°РЅРЅС‹Р№ РјРµС‚РѕРґ РѕРїСЂРµРґРµР»СЏРµС‚ СЂР°Р·РјРµСЂ РѕС‚РѕР±СЂР°Р¶РµРЅРёРµ 
	//РєРѕРјРїРѕРЅРµРЅС‚Р° РЅРµ РјРµРЅСЏСЏ РµРіРѕ Р·Р°РґР°РЅРЅС‹Рµ Р·РЅР°С‡РµРЅРёСЏ , РѕР±С‹С‡РЅРѕ NONE С‡С‚РѕР± РЅРµ РїСѓС‚Р°С‚СЊСЃСЏ РІ РѕС‚РѕР±СЂР°Р¶РµРЅРёРё С‚Р°Рє Р¶Рµ РµСЃС‚СЊ СЂР°СЃС‚СЏРЅСѓС‚СЊ РїРѕ РІРµСЂС‚РёРєР°Р»Рё Рё РіРѕСЂРёР·РѕРЅС‚Р°Р»Рё
	gc.fill = GridBagConstraints.NONE;
	
	//Р�СЃРїРѕР»СЊР·СѓРµС‚СЃСЏ РІ С‚РѕРј СЃР»СѓС‡Р°Рµ РµСЃР»Рё РѕС‚РѕР±СЂР°Р¶Р°РµРјР°СЏ РѕР±Р»Р°СЃС‚СЊ Р±РѕР»СЊС€Рµ СЂР°Р·РјРµСЂР° РєРѕРјРїРѕРЅРµРЅС‚Р° - РѕРїСЂРµРґРµР»СЏРµС‚ РµРіРѕ РїРѕР·РёС†РёСЋ РІРЅСѓС‚СЂРё РѕР±Р»Р°СЃС‚Рё
	//LINE_START - РІ Р»РµРІРѕРј РІРµСЂС…РЅРµРј СѓРіР»Сѓ
	gc.anchor = GridBagConstraints.LINE_END;
	add(nameLabel, gc);

	
	gc.gridx = 1;
	gc.gridy = 0;
	gc.anchor = GridBagConstraints.LINE_START;
	add(nameField, gc);
	
	//Second ROW 	
	gc.weightx = 1;
	gc.weighty = 0;
	
	gc.gridx = 0;
	gc.gridy = 1;
	
	//Р”Р°РЅРЅС‹Р№ РёРЅСЃРµС‚ РѕРїСЂРµРґРµР»СЏРµС‚ РѕС‚СЃС‚СѓРїС‹ РїРѕ РІСЃРµРјСѓ РїРёСЂРёРјРµС‚СЂСѓ РєРѕРјРїРѕРЅРµРЅС‚Р°
	//РїР°РґРґРёРЅРі - РѕС‚СЃС‚СѓРїС‹ РјРµР¶РґСѓ СЃР°РјРёРј РєРѕРјРїРѕРЅРµРЅС‚РѕРј Рё РѕС‚РѕР±СЂР°Р¶Р°РµРјРѕР№ РѕР±Р»Р°СЃС‚СЊСЋ
	gc.insets = new Insets(0,0,0,5);
	gc.anchor = GridBagConstraints.LINE_END;
	add(occupationLabel, gc);
	
	
	
	gc.gridx = 1;
	gc.gridy = 1;
	gc.anchor = GridBagConstraints.LINE_START;
	add(occupationField, gc);

	//THIRD ROW
	
	gc.weightx = 1;
	//gc.weighty = 0.1;
	gc.gridx = 1;
	gc.gridy = 2;
	gc.insets = new Insets(0,0,0,0);
	//gc.anchor = GridBagConstraints.FIRST_LINE_START;
	gc.anchor = GridBagConstraints.LINE_START;
	add(ageList, gc);
	

	//Four ROW
	gc.weightx = 1;
	//gc.weighty = 0.1;
	gc.gridx = 1;
	gc.gridy = 3;
	gc.insets = new Insets(0,0,0,0);
	gc.anchor = GridBagConstraints.FIRST_LINE_START;
	add(emp, gc);
	
	
	//Next ROW
	
	gc.weightx = 1;
	gc.weighty = 0;
	
	gc.gridx = 0;
	gc.gridy = 4;
	
	//Р”Р°РЅРЅС‹Р№ РёРЅСЃРµС‚ РѕРїСЂРµРґРµР»СЏРµС‚ РѕС‚СЃС‚СѓРїС‹ РїРѕ РІСЃРµРјСѓ РїРёСЂРёРјРµС‚СЂСѓ РєРѕРјРїРѕРЅРµРЅС‚Р°
	//РїР°РґРґРёРЅРі - РѕС‚СЃС‚СѓРїС‹ РјРµР¶РґСѓ СЃР°РјРёРј РєРѕРјРїРѕРЅРµРЅС‚РѕРј Рё РѕС‚РѕР±СЂР°Р¶Р°РµРјРѕР№ РѕР±Р»Р°СЃС‚СЊСЋ
	gc.insets = new Insets(0,0,0,5);
	gc.anchor = GridBagConstraints.LINE_END;
	add(taxLabel, gc);
	
	
	
	gc.gridx = 1;
	gc.gridy = 4;
	gc.anchor = GridBagConstraints.LINE_START;
	add(taxField, gc);
	
	gc.gridx = 2;
	gc.gridy = 4;
	gc.anchor = GridBagConstraints.LINE_START;
	add(citizenCheck, gc);
	

	//NextROW
	gc.weightx = 1;
	//gc.weighty = 0.1;
	gc.gridx = 1;
	gc.gridy = 5;
	gc.insets = new Insets(0,0,0,0);
	gc.anchor = GridBagConstraints.FIRST_LINE_START;
	add(new JLabel("Gender : "), gc);
	
	gc.gridx = 0;
	gc.gridy = 6;
	gc.insets = new Insets(0,0,0,5);
	gc.anchor = GridBagConstraints.LINE_END;
	add(male, gc);
	
	gc.gridx = 1;
	gc.gridy = 6;
	gc.insets = new Insets(0,0,0,0);
	gc.anchor = GridBagConstraints.LINE_START;
	add(female, gc);
	
	
	//Next ROW
	
	gc.weightx = 1;
	//gc.weighty = 0.1;
	gc.gridx = 1;
	gc.gridy = 7;
	gc.anchor = GridBagConstraints.FIRST_LINE_START;
	add(okbtn, gc);
		
	}
	
	
	
	
	
	
	public void setFormListener(FormListener listener){
		this.formListener = listener;
		
		
	}
	
	class AgeCategory{
		private int id;
		String text;
		

		public AgeCategory(int id, String text) {
			this.id=id;
			this.text=text;
			
		}
		
		public String toString(){
			return text;
			
		}

		public int getId() {
			return id;
		}
		
		
		
	}
	
	
}
