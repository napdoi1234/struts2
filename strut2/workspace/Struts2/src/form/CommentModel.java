package form;

import java.sql.Date;

public class CommentModel {
private String commentid;
private Date commentdate;
private String content;
private String userid;
private String articleid;
private String status;

public String getCommentid() {
	return commentid;
}
public void setCommentid(String commentid) {
	this.commentid = commentid;
}
public Date getCommentdate() {
	return commentdate;
}
public void setCommentdate(Date commentdate) {
	this.commentdate = commentdate;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public String getArticleid() {
	return articleid;
}
public void setArticleid(String articleid) {
	this.articleid = articleid;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}

}
