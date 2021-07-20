package web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import web.util.ShopException;
import web.vo.ArticleVO;

public class BoardDAO {
  DataSource ds;

  public BoardDAO() {
    try {

      Context initCtx = new InitialContext();
      Context envCtx = (Context) initCtx.lookup("java:comp/env");
      ds = (DataSource) envCtx.lookup("jdbc/MyDB");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public ArrayList<ArticleVO> selectAllArticles() throws ShopException {
    Connection con = null;
    PreparedStatement st = null;
    ResultSet rs = null;

    try {
      con = ds.getConnection();

      String query = "select level, articleNO,parentNO,title,content,id,writeDate" + " from t_board"
          + " start with parentNO=0" + " connect by prior articleNO=parentNO"
          + " order siblings by articleNO desc";
      st = con.prepareStatement(query);

      rs = st.executeQuery();

      ArrayList<ArticleVO> list = new ArrayList();
      while (rs.next()) {
        int level = rs.getInt("level");
        int articleNO = rs.getInt("articleNO");
        int parentNO = rs.getInt("parentNO");
        String title = rs.getString("title");
        String content = rs.getString("content");
        String id = rs.getString("id");
        Date writeDate = rs.getDate("writeDate");

        ArticleVO vo =
            new ArticleVO(level, articleNO, parentNO, title, content, null, id, writeDate);
        list.add(vo);
      }

      return list;
    } catch (Exception e) {
      e.printStackTrace();
      throw new ShopException("Board Loading Fail");
    } finally {
      try {
        rs.close();
        st.close();
        con.close();
      } catch (Exception e) {

      }
    }
  }

  public synchronized void insertNewArticle(ArticleVO vo) throws ShopException {
    Connection con = null;
    PreparedStatement st = null, st2 = null;
    ResultSet rs = null;
    try {

      con = ds.getConnection();

      st = con.prepareStatement(
          "INSERT INTO t_board " + "(articleNO,parentNO,title,content, imageFileName,id,writeDate) "
              + "VALUES (?,?,?,?,?,?,sysdate) ");

      st2 = con.prepareStatement("select max(articleNO) from t_board");
      rs = st2.executeQuery();

      int articleNO = 0;
      if (rs.next()) {
        articleNO = rs.getInt(1) + 1;
      }

      st.setInt(1, articleNO);
      st.setInt(2, vo.getParentNO());
      st.setString(3, vo.getTitle());
      st.setString(4, vo.getContent());
      st.setString(5, vo.getImageFileName());
      st.setString(6, vo.getId());

      int i = st.executeUpdate();

      System.out.println(i + "행이 insert되었습니다");


    } catch (Exception e) {
      e.printStackTrace();
      throw new ShopException("글쓰기 실패");
    } finally {
      try {
        rs.close();
        st2.close();
        st.close();
        con.close();
      } catch (Exception e) {

      }
    }

  }

  public ArticleVO selectArticle(int articleNO) throws ShopException {
    Connection con = null;
    PreparedStatement st = null;
    ResultSet rs = null;

    try {
      con = ds.getConnection();

      String query = "select parentNO,title,content,imageFileName,id,writeDate" + " from t_board"
          + " where articleNO=?";

      st = con.prepareStatement(query);

      st.setInt(1, articleNO);
      rs = st.executeQuery();

      if (rs.next()) {

        int parentNO = rs.getInt("parentNO");
        String title = rs.getString("title");
        String content = rs.getString("content");
        String imageFileName = rs.getString("imageFileName");
        String id = rs.getString("id");
        Date writeDate = rs.getDate("writeDate");

        ArticleVO vo =
            new ArticleVO(0, articleNO, parentNO, title, content, imageFileName, id, writeDate);
        return vo;
      }

      return null;
    } catch (Exception e) {
      e.printStackTrace();
      throw new ShopException("Article Loading Fail");
    } finally {
      try {
        rs.close();
        st.close();
        con.close();
      } catch (Exception e) {

      }
    }
  }

}
