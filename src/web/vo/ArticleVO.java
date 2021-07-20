package web.vo;

import java.util.Date;

public class ArticleVO {
  private int level;
  private int articleNO;
  private int parentNO;
  private String title;
  private String content;
  private String imageFileName;
  private String id;
  private Date writeDate;


  public ArticleVO() {
    super();
    // TODO Auto-generated constructor stub
  }

  public ArticleVO(int level, int articleNO, int parentNO, String title, String content,
      String imageFileName, String id, Date writeDate) {
    super();
    setLevel(level);
    setArticleNO(articleNO);
    setParentNO(parentNO);
    setTitle(title);
    setContent(content);
    setImageFileName(imageFileName);
    setId(id);
    setWriteDate(writeDate);
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public int getArticleNO() {
    return articleNO;
  }

  public void setArticleNO(int articleNO) {
    if (articleNO < 0) {
      System.out.println("error");
    } else {
      this.articleNO = articleNO;
    }

  }

  public int getParentNO() {
    return parentNO;
  }

  public void setParentNO(int parentNO) {
    if (parentNO < 0) {
      System.out.println("error");
    } else {
      this.parentNO = parentNO;
    }

  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    if (title.length() <= 0) {
      System.out.println("제목은 최소한 1글자 이상이어야 합니다");
    } else {
      this.title = title;
    }
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getImageFileName() {
    return imageFileName;
  }

  public void setImageFileName(String imageFileName) {
    this.imageFileName = imageFileName;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    if (id.length() < 0) {
      System.out.println("error");
    } else {
      this.id = id;
    }
  }

  public Date getWriteDate() {
    return writeDate;
  }

  public void setWriteDate(Date writeDate) {
    this.writeDate = writeDate;
  }

  @Override
  public String toString() {
    return "ArticleVO [level=" + level + ", articleNO=" + articleNO + ", parentNO=" + parentNO
        + ", title=" + title + ", content=" + content + ", imageFileName=" + imageFileName + ", id="
        + id + ", writeDate=" + writeDate + "]";
  }



}