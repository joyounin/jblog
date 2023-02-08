package com.douzone.jblog.vo;

public class CategoryVo {
	private Long no;
	private String categoryname;
	private String id;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", categoryname=" + categoryname + ", id=" + id + "]";
	}
	
	
}
