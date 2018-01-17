package com.javaex.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.javaex.vo.BookVo;

public class BookDao {
	
		Connection conn = null;

		PreparedStatement pstmt = null;
		
		public void insertAuthor(BookVo bvo) {
			// 0. import java.sql.*;

			try {

				// 1. JDBC 드라이버 (Oracle) 로딩
				Class.forName("oracle.jdbc.driver.OracleDriver");

				// 2. Connection 얻어오기
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				conn = DriverManager.getConnection(url, "webdb", "webdb");

				// 3. SQL문 준비 / 바인딩 / 실행
				String query = " insert into book values(seq_book_id.nextval, ?, ?, ?, ?)";

				pstmt = conn.prepareStatement(query);

				pstmt.setString(1,bvo.getTitle());
				pstmt.setString(2,bvo.getPubs());
				pstmt.setString(3,bvo.getPubDate());
				pstmt.setInt (4,bvo.getAuthorId());

				int count = pstmt.executeUpdate();

				// 4.결과처리
				System.out.println(count + "건 저장완료");

			} catch (ClassNotFoundException e) {

				System.out.println("error: 드라이버 로딩 실패 - " + e);

			} catch (SQLException e) {

				System.out.println("error:" + e);

			} finally {

				// 5. 자원정리

				try {

					if (pstmt != null) {

						pstmt.close();

					}

					if (conn != null) {

						conn.close();

					}

				} catch (SQLException e) {

					System.out.println("error:" + e);

				}

			}

		}
		List<BookVo> BookList = new ArrayList<BookVo>();
		
		public List<BookVo> selectBookList() {
			// 0. import java.sql.*;

			Connection conn = null;

			PreparedStatement pstmt = null;

			ResultSet rs = null;

			try {
				// 1. JDBC 드라이버 (Oracle) 로딩
				Class.forName("oracle.jdbc.driver.OracleDriver");
				// 2. Connection 얻어오기
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				conn = DriverManager.getConnection(url, "webdb", "webdb");
				// 3. SQL문 준비 / 바인딩 / 실행
				String query = "select bo.book_id," 
						       +     " bo.title, " 
						       +     " bo.pubs, "  
						       +     " to_char(bo.pub_date, 'yy-mm-dd') pubdate,"  
						       +     " au.author_id," 
						       +     " au.author_name, "  
						       +     " au.author_desc "  
						       +" from book bo, author au "  
						       +" where bo.author_id = au.author_id";

				pstmt = conn.prepareStatement(query);
				rs = pstmt.executeQuery();

				// 4.결과처리
				
				while (rs.next()) {
					BookVo bvo = new BookVo();
					int bookId = rs.getInt("book_id");
					String Title = rs.getString("title");
					String Pubs  = rs.getString("pubs");
					String pubDate = rs.getString("pubdate");
					int authorId =rs.getInt("author_id");
					String authorName = rs.getString("author_name");
					String authorDesc = rs.getString("author_desc");
					
					bvo.setBookId(bookId);
					bvo.setTitle(Title);
					bvo.setPubs(Pubs);
					bvo.setPubDate(pubDate);
					bvo.setAuthorId(authorId);
				    bvo.setAuthorName(authorName);
				    bvo.setAuthorDesc(authorDesc);
					BookList.add(bvo);

					//System.out.println("작가 넘버:" + authorId + "|" + "작가 이름:" + authorName + "|" + "주 소:" + authorDesc);
				}

			} catch (ClassNotFoundException e) {

				System.out.println("error: 드라이버 로딩 실패 - " + e);

			} catch (SQLException e) {

				System.out.println("error:" + e);

			} finally {

				// 5. 자원정리

				try {

					if (rs != null) {

						rs.close();

					}

					if (pstmt != null) {

						pstmt.close();

					}

					if (conn != null) {

						conn.close();

					}

				} catch (SQLException e) {

					System.out.println("error:" + e);

				}

			}
			return BookList;

		}

	}

