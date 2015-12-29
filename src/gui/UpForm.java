package gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Created by JFormDesigner on Sat Dec 19 21:12:15 MSK 2015
 */
import javax.swing.*;

import gui.UpForm_old.AgeCategory;



/**
 * @author Anton Sotnikov
 */
public class UpForm extends JPanel {
	public UpForm() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Anton Sotnikov
		titleLabel = new JLabel();
		separator1 = new JSeparator();
		NameLabel = new JLabel();
		OccupationLabel = new JLabel();
		nameField = new JTextField();
		occupationField = new JTextField();
		okbtn = new JButton();
		scrollPane1 = new JScrollPane();
		ageList = new JList();
		emp = new JComboBox();
		ageLabel = new JLabel();
		taxLabel = new JLabel();
		taxField = new JTextField();
		emploeeLabel = new JLabel();
		male = new JRadioButton();
		female = new JRadioButton();
		gender = new JLabel();
		citizenCheck = new JCheckBox();

		//=============CitizenCheckActionListner
		citizenCheck.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean isTicked = citizenCheck.isSelected();
				taxField.setEnabled(isTicked);
				taxLabel.setEnabled(isTicked);

			}

		});

		
		//====================ComboBox Model=====================
		DefaultComboBoxModel empModel = new DefaultComboBoxModel();
		
		empModel.addElement("Employed");
		empModel.addElement("Self-employed");
		empModel.addElement("unemployed");
		
		emp.setModel(empModel);
		
		
		//====================JList Model=====================
		DefaultListModel ageModel = new DefaultListModel();
		

		ageModel.addElement(new AgeCategory(0, "under 18"));
		ageModel.addElement(new AgeCategory(1,"18 to 65"));
		ageModel.addElement(new AgeCategory(2, "65 or over"));
		
		ageList.setModel(ageModel); 
		

		//====================Radio Button Group=====================
		genderGroup = new ButtonGroup();

		genderGroup.add(male);
		genderGroup.add(female);
		
		male.setActionCommand("male");
		female.setActionCommand("female");
		
		male.setSelected(true);
		
		//======== this ========
		setPreferredSize(new Dimension(700, 350));
		setMinimumSize(new Dimension(1200, 350));
		setFont(this.getFont().deriveFont(this.getFont().getStyle() | Font.ITALIC));

		// JFormDesigner evaluation mark
		setBorder(new javax.swing.border.CompoundBorder(
			new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
				"Meta-studio design", javax.swing.border.TitledBorder.CENTER,
				javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
				java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

				//
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
						
						
						
System.out.println(this.toString()+" "+name+" "+occupation+" "+" "+ageCat.toString()+" "+ageCat.getId()+" "+empVal+" "+taxId+" "+" "+usCitizen+" "+genderValue);
						
						FormEvent ev = new FormEvent(this, name, occupation, ageCat.toString(), ageCat.getId(), empVal,  taxId, usCitizen, genderValue);
						
						if(formListener!= null){
							formListener.formEventOccured(ev);
							
						}
						
					}

				});
		//---- titleLabel ----
		titleLabel.setText("PERSON DATA FORM");
		titleLabel.setFont(titleLabel.getFont().deriveFont(Font.PLAIN, titleLabel.getFont().getSize() + 7f));

		//---- NameLabel ----
		NameLabel.setText("Name");
		NameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

		//---- OccupationLabel ----
		OccupationLabel.setText("Occupation");
		OccupationLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

		//---- okbtn ----
		okbtn.setText("OK");

		//======== scrollPane1 ========
		{
			scrollPane1.setViewportView(ageList);
			
			
			
		}

		//---- ageLabel ----
		ageLabel.setText("Age List");
		ageLabel.setFont(ageLabel.getFont().deriveFont(ageLabel.getFont().getStyle() | Font.BOLD));

		//---- taxLabel ----
		taxLabel.setText("TaxID");
		taxLabel.setFont(new Font("Tahoma", Font.BOLD, 12));

		//---- emploeeLabel ----
		emploeeLabel.setText("Emploee Category");
		emploeeLabel.setFont(emploeeLabel.getFont().deriveFont(emploeeLabel.getFont().getStyle() | Font.BOLD));

		//---- male ----
		male.setText("male");

		//---- female ----
		female.setText("female");

		//---- gender ----
		gender.setText("GENDER");
		gender.setFont(gender.getFont().deriveFont(Font.BOLD));

		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup()
					.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup()
							.addGroup(layout.createSequentialGroup()
								.addGap(91, 91, 91)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
									.addComponent(okbtn, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
									.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup()
											.addGroup(layout.createSequentialGroup()
												.addGroup(layout.createParallelGroup()
													.addComponent(NameLabel, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
													.addComponent(OccupationLabel))
												.addGap(30, 30, 30)
												.addGroup(layout.createParallelGroup()
													.addComponent(occupationField, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
													.addComponent(nameField, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
													.addComponent(taxField, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
													.addGroup(layout.createSequentialGroup()
														.addComponent(gender)
														.addGap(101, 101, 101)
														.addComponent(citizenCheck))))
											.addGroup(layout.createSequentialGroup()
												.addGap(104, 104, 104)
												.addComponent(male)
												.addGap(6, 6, 6)
												.addComponent(female)))
										.addGap(47, 47, 47)
										.addGroup(layout.createParallelGroup()
											.addComponent(emploeeLabel)
											.addComponent(ageLabel)
											.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
											.addComponent(emp, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)))))
							.addGroup(layout.createSequentialGroup()
								.addGap(122, 122, 122)
								.addComponent(taxLabel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
							.addGroup(layout.createSequentialGroup()
								.addGap(55, 55, 55)
								.addComponent(separator1, GroupLayout.PREFERRED_SIZE, 650, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(65, Short.MAX_VALUE))
					.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addGap(0, 276, Short.MAX_VALUE)
						.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
						.addGap(164, 164, 164))
			);
			layout.setVerticalGroup(
				layout.createParallelGroup()
					.addGroup(layout.createSequentialGroup()
						.addGap(20, 20, 20)
						.addComponent(titleLabel)
						.addGap(26, 26, 26)
						.addComponent(separator1, GroupLayout.PREFERRED_SIZE, 5, GroupLayout.PREFERRED_SIZE)
						.addGap(29, 29, 29)
						.addComponent(ageLabel)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup()
							.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
									.addComponent(NameLabel)
									.addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
									.addComponent(OccupationLabel)
									.addComponent(occupationField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
									.addComponent(taxLabel)
									.addComponent(taxField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup()
							.addGroup(layout.createSequentialGroup()
								.addComponent(gender)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
									.addComponent(female)
									.addComponent(emploeeLabel)
									.addComponent(male)))
							.addComponent(citizenCheck))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(emp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(okbtn)
						.addContainerGap(50, Short.MAX_VALUE))
			);
		/*
		layout.setHorizontalGroup(
			layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup()
						.addGroup(layout.createSequentialGroup()
							.addGap(91, 91, 91)
							.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addComponent(okbtn, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
								.addGroup(layout.createSequentialGroup()
									.addGroup(layout.createParallelGroup()
										.addGroup(layout.createSequentialGroup()
											.addGroup(layout.createParallelGroup()
												.addComponent(NameLabel, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
												.addComponent(OccupationLabel))
											.addGap(30, 30, 30)
											.addGroup(layout.createParallelGroup()
												.addComponent(occupationField, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
												.addComponent(nameField, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
												.addComponent(taxField, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
												.addComponent(gender)))
										.addGroup(layout.createSequentialGroup()
											.addGap(104, 104, 104)
											.addComponent(male)
											.addGap(6, 6, 6)
											.addComponent(female)))
									.addGap(60, 60, 60)
									.addGroup(layout.createParallelGroup()
										.addComponent(emploeeLabel)
										.addComponent(ageLabel)
										.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
										.addComponent(emp, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(layout.createSequentialGroup()
							.addGap(122, 122, 122)
							.addComponent(taxLabel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup()
							.addGap(55, 55, 55)
							.addComponent(separator1, GroupLayout.PREFERRED_SIZE, 1200, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(65, Short.MAX_VALUE))
				.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
					.addGap(0, 276, Short.MAX_VALUE)
					.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
					.addGap(164, 164, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup()
					.addGap(20, 20, 20)
					.addComponent(titleLabel)
					.addGap(26, 26, 26)
					.addComponent(separator1, GroupLayout.PREFERRED_SIZE, 5, GroupLayout.PREFERRED_SIZE)
					.addGap(29, 29, 29)
					.addComponent(ageLabel)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup()
						.addGroup(layout.createSequentialGroup()
							.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(NameLabel)
								.addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(OccupationLabel)
								.addComponent(occupationField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
							.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(taxLabel)
								.addComponent(taxField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addComponent(gender)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(female)
						.addComponent(emploeeLabel)
						.addComponent(male))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(emp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(okbtn)
					.addContainerGap(50, Short.MAX_VALUE))
		);
		
		*/
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Anton Sotnikov
	private JLabel titleLabel;
	private JSeparator separator1;
	private JLabel NameLabel;
	private JLabel OccupationLabel;
	private JTextField nameField;
	private JTextField occupationField;
	private JButton okbtn;
	private JScrollPane scrollPane1;
	private JList ageList;
	private JComboBox emp;
	private JLabel ageLabel;
	private JLabel taxLabel;
	private JTextField taxField;
	private JLabel emploeeLabel;
	private JRadioButton male;
	private JRadioButton female;
	private JLabel gender;
	private ButtonGroup genderGroup;
	private JCheckBox citizenCheck;
	private FormListener formListener;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
	
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
