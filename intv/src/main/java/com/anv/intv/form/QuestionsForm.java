package com.anv.intv.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class QuestionsForm {

	private int id;
	private int categoryId;
	private String category;
	@NotNull
	@Size(min=10,message = "Describe question with more than 10 chars")
	private String desc;
	
	@NotNull
	@Size(min=10,message = "Describe answer with more than 10 chars")
	private String ans;
	
	//UI Field Ids
	private String checkBoxId;
	private String linkId;
	private String textAreaId;
	
		
	public QuestionsForm createQuestion(int id, int categoryId, String category, @NotNull String desc, @NotNull String ans) {
		this.id = id;
		this.categoryId = categoryId;
		this.category = category;
		this.desc = desc;
		this.ans = ans;
		this.checkBoxId = "quest"+id+"Check";
		this.linkId = "quest"+id+"link";
		this.textAreaId = "quest"+id;
		
		return this;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
		this.checkBoxId = "quest"+id+"Check";
		this.linkId = "quest"+id+"link";
		this.textAreaId = "quest"+id;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getAns() {
		return (ans != null ? ans.trim() : ans);
	}
	public void setAns(String ans) {
		this.ans = ans;
	}

	public String getCheckBoxId() {
		 return "quest"+id+"Check";
	}

	public void setCheckBoxId(String checkBoxId) {
		this.checkBoxId = checkBoxId;
	}

	public String getLinkId() {
		return "quest"+id+"link";
	}

	public void setLinkId(String linkId) {
		this.linkId = linkId;
	}

	public String getTextAreaId() {
		return "quest"+id;
	}

	public void setTextAreaId(String textAreaId) {
		this.textAreaId = textAreaId;
	}
	
	
}
