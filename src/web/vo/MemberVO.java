package web.vo;

public class MemberVO {
  private String id, pw, name, address;
  private int age;


  public MemberVO() {
    super();
    // TODO Auto-generated constructor stub
  }

  public MemberVO(String id, String pw) {
    setId(id);
    setPw(pw);
  }

  public MemberVO(String id, String pw, String name) {
    setId(id);
    setPw(pw);
    setName(name);
    setAddress("privacy");
    setAge(-1);
  }

  public MemberVO(String id, String pw, String name, String address, int age) {
    setId(id);
    setPw(pw);
    setName(name);
    setAddress(address);
    setAge(age);
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    if (id.length() < 1) {
      System.out.println("id를 입력해주세요");
    } else {
      this.id = id;
    }
  }

  public String getPw() {
    return pw;
  }

  public void setPw(String pw) {
    if (pw.length() < 1) {
      System.out.println("비밀번호를 입력해주세요");
    } else {
      this.pw = pw;
    }
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    if (isInteger(name)) {
      System.out.println("올바른 이름을 입력하세요");
    } else {
      this.name = name;
    }
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
      this.address = address;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public static boolean isInteger(String s) {
    System.out.println(String.format("Parsing string value: \"%s\"", s));

    if (s == null || s.equals("")) {
      return false;
    }

    try {
      int iVal = Integer.parseInt(s);
      return true;
    } catch (NumberFormatException e) {
      System.out.println("Cannot parse the string to integer");
    }
    return false;
  }

  @Override
  public String toString() {
    return "MemberVO [id=" + id + ", pw=" + pw + ", name=" + name + ", address=" + address
        + ", age=" + age + "]";
  }


}
