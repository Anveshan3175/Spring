package com.cts.formatter;

import java.beans.PropertyEditorSupport;

import org.springframework.stereotype.Component;

import com.cts.form.SkillForm;

@Component
public class SkillFormEditor extends PropertyEditorSupport{

	 @Override
	 public void setAsText(String id) {
	 
	System.out.println("IDTONE CONVERTER--------"+id);
		/*SkillForm group = this.DAOGroupImpl
	 .getNetworkElementGroupByID(Integer.parseInt(id));*/
	 //System.out.println("GROUP RETURNED:"+group);
	 this.setValue(new SkillForm(Integer.parseInt(id),"",""));
	 return;
	
	}

}
