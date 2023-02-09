package com.douzone.jblog.vo;

public class CategoryVo {
	private Long no;
	private String categoryname;
	private String id;
	private Long count;
	
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
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", categoryname=" + categoryname + ", id=" + id + ", count=" + count + "]";
	}
	
	
}
