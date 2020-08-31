package com.eomcs.pms.domain;

import java.sql.Date;

// 게시물 데이터
// - 패키지 멤버 클래스는 static 이 될 수 없다.
// - 다른 패키지에 있는 클래스가 사용해야 하기 때문에 public 으로 공개한다.
public class Board {
  // 다른 패키지의 클래스가 인스턴스 필드를 직접 사용할 수 있도록 public으로 공개한다.
  private int no;
  private String title;
  private String content;
  private String writer;
  private Date registeredDate;
  private int viewCount;
public int getNo() {
	return no;
}
public void setNo(int no) {
	this.no = no;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getWriter() {
	return writer;
}
public void setWriter(String writer) {
	this.writer = writer;
}
public Date getRegisteredDate() {
	return registeredDate;
}
public void setRegisteredDate(Date registeredDate) {
	this.registeredDate = registeredDate;
}
public int getViewCount() {
	return viewCount;
}
public void setViewCount(int viewCount) {
	this.viewCount = viewCount;
}
}