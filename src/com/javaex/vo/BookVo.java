package com.javaex.vo;

public class BookVo {
	private int bookId;
	private String Title;
	private String Pubs;
	private String pubDate;
	private int AuthorId;
	private String authorName;
	private String authorDesc;
	
	
	public BookVo() {
		super();
	}


	public BookVo(String title, String pubs, String pubDate, int authorId) {
		super();
		Title = title;
		Pubs = pubs;
		this.pubDate = pubDate;
		AuthorId = authorId;
	}


	public BookVo(int bookId, String title, String pubs, String pubDate, int authorId) {
		super();
		this.bookId = bookId;
		Title = title;
		Pubs = pubs;
		this.pubDate = pubDate;
		AuthorId = authorId;
	}


	public int getBookId() {
		return bookId;
	}


	public void setBookId(int bookId) {
		this.bookId = bookId;
	}


	public String getTitle() {
		return Title;
	}


	public void setTitle(String title) {
		Title = title;
	}


	public String getPubs() {
		return Pubs;
	}


	public void setPubs(String pubs) {
		Pubs = pubs;
	}


	public String getPubDate() {
		return pubDate;
	}


	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}


	public int getAuthorId() {
		return AuthorId;
	}


	public void setAuthorId(int authorId) {
		AuthorId = authorId;
	}


	public String getAuthorName() {
		return authorName;
	}


	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}


	public String getAuthorDesc() {
		return authorDesc;
	}


	public void setAuthorDesc(String authorDesc) {
		this.authorDesc = authorDesc;
	}


	@Override
	public String toString() {
		return "BookVo [bookId=" + bookId + ", Title=" + Title + ", Pubs=" + Pubs + ", pubDate=" + pubDate
				+ ", AuthorId=" + AuthorId + ", authorName=" + authorName + ", authorDesc=" + authorDesc + "]";
	}
	
	
}