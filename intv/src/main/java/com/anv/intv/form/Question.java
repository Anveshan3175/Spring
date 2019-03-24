package com.anv.intv.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Question{

	private String id;
	private String categoryId;
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
	
	private boolean selected;
	
	public Question() {}
	
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public Question createQuestion(String id, String categoryId, String category, @NotNull String desc, @NotNull String ans) {
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
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
		this.checkBoxId = "quest"+id+"Check";
		this.linkId = "quest"+id+"link";
		this.textAreaId = "quest"+id;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
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
		 return id != null ? ("quest"+id+"Check") : id;
	}

	public void setCheckBoxId(String checkBoxId) {
		this.checkBoxId = checkBoxId;
	}

	public String getLinkId() {
		return id != null ? ("quest"+id+"link") : id;
	}

	public void setLinkId(String linkId) {
		this.linkId = linkId;
	}

	public String getTextAreaId() {
		return id != null ? ("quest"+id) : id;
	}

	public void setTextAreaId(String textAreaId) {
		this.textAreaId = textAreaId;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", categoryId=" + categoryId + ", category=" + category + ", desc=" + desc
				+ ", ans=" + ans + ", checkBoxId=" + checkBoxId + ", linkId=" + linkId + ", textAreaId=" + textAreaId
				+ ", selected=" + selected + "]";
	}
	
	
}
