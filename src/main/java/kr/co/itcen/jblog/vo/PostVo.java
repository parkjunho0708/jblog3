package kr.co.itcen.jblog.vo;

public class PostVo {
	private int postNo;
	private String postTitle;
	private String postContents;
	private String postCreatedate;
	private int categoryNo;

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostContents() {
		return postContents;
	}

	public void setPostContents(String postContents) {
		this.postContents = postContents;
	}

	public String getPostCreatedate() {
		return postCreatedate;
	}

	public void setPostCreatedate(String postCreatedate) {
		this.postCreatedate = postCreatedate;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	@Override
	public String toString() {
		return "PostVo [postNo=" + postNo + ", postTitle=" + postTitle + ", postContents=" + postContents
				+ ", postCreatedate=" + postCreatedate + ", categoryNo=" + categoryNo + "]";
	}

}