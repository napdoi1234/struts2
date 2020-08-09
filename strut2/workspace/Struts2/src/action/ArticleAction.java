package action;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.ConnectDB;
import form.ArticleModel;

public class ArticleAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ArticleModel> articleList;
	private ArticleModel article;
	private Connection conn = null;
	
	public List<ArticleModel> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<ArticleModel> articleList) {
		this.articleList = articleList;
	}

	public ArticleModel getArticle() {
		return article;
	}

	public void setArticle(ArticleModel article) {
		this.article = article;
	}

	public String getAllArticle()  {
		
		try {
			conn = ConnectDB.Open();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String query = "Select * from article ";
		PreparedStatement pstmt = null;
		articleList = new ArrayList<ArticleModel>();

		try {
			pstmt = conn.prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ResultSet rs = null;
		try {
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArticleModel article = null;
		 java.sql.Date dbSqlDate;
		try {
			while (rs.next()) {
				article = new ArticleModel();
				article.setArticleID(rs.getString(1));
				article.setArticleName(rs.getString(2));
				dbSqlDate= rs.getDate(3);
				article.setArticleDate(dbSqlDate.toString());
				article.setArticleContent(rs.getString(4));
				article.setUserID(rs.getString(5));
				article.setArticleStatus(rs.getString(6));
				articleList.add(article);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConnectDB.Close(conn, pstmt);
		return "success";
	}

	public String insertArticle() throws  ClassNotFoundException {
		Connection conn = ConnectDB.Open();

		String query = "INSERT INTO article VALUES (?, ?, ?, ?, ?,?)";
		PreparedStatement pstmt = null;
		Date date=Date.valueOf(article.getArticleDate());
		try {
			pstmt = conn.prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pstmt = ConnectDB.setParamenter(pstmt, article.getArticleID(), article.getArticleName(), date, article.getArticleContent(),
				article.getUserID(), article.getArticleStatus());
		int rs=0;
		try {
			rs = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (rs > 0) {
			ConnectDB.Close(conn, pstmt);
			return "insertSuccess";
		}
		return "insertError";
	}

	public String editArticle() throws SQLException {
		try {
			conn = ConnectDB.Open();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date date=Date.valueOf(article.getArticleDate());
		String query = "UPDATE article SET article_name=?,article_date=?,article_content=?,user_id=?,article_status=? WHERE article_id=?";
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt = ConnectDB.setParamenter(pstmt, article.getArticleName(), date, article.getArticleContent(),
				article.getUserID(), article.getArticleStatus(), article.getArticleID());
		int rs = pstmt.executeUpdate();
		if (rs > 0) {
			ConnectDB.Close(conn, pstmt);
			return "editSuccess";
		}

		return "editError";
	}

	public String findArticle() throws SQLException {
		try {
			conn = ConnectDB.Open();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date dbSqlDate;
		String query = "select * from article where article_ID=?";
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt = ConnectDB.setParamenter(pstmt, article.getArticleID());
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			article = new ArticleModel();
			article.setArticleID(rs.getString(1));
			article.setArticleName(rs.getString(2));
			dbSqlDate= rs.getDate(3);
			article.setArticleDate(dbSqlDate.toString());
			article.setArticleContent(rs.getString(4));
			article.setUserID(rs.getString(5));
			article.setArticleStatus(rs.getString(6));
			ConnectDB.Close(conn, pstmt);
		}
		return "findSuccess";
	}

	public String deleteArticle() throws SQLException {
		try {
			conn = ConnectDB.Open();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query = "DELETE FROM article WHERE article_ID=?;";
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt = ConnectDB.setParamenter(pstmt, article.getArticleID());
		int rs = pstmt.executeUpdate();
		return "deleteSuccess";
	}
}

