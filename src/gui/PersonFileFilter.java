package gui;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class PersonFileFilter extends FileFilter{

	@Override
	public boolean accept(File f) {
		
		
		String name = f.getName();
		
		String ext = Utils.getFileExtention(name);
		
		if(ext == null){
			return false;
			
		}
		
		if(ext.equals("per")){
			
			return true;
		}
		
		return false;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Person database file (*.per)";
	}
	
	

}
