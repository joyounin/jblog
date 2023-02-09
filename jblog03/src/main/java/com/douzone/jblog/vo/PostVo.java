package com.douzone.jblog.vo;

public class PostVo {
	private Long no;
	private String title;
	private String contents;
	private String reg_date;
	private Long categoryno;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public Long getCategoryno() {
		return categoryno;
	}
	public void setCategoryno(Long categoryno) {
		this.categoryno = categoryno;
	}
	@Override
	public String toString() {
		return "PostVo [no=" + no + ", title=" + title + ", contents=" + contents + ", reg_date=" + reg_date
				+ ", categoryno=" + categoryno + "]";
	}
	
	
}
