package web.vo;

public class ProductVO {
	
	private String name,description;
	private int price;
	
		
	public ProductVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductVO(String name) {
		super();
		setName(name);
	}
	public ProductVO(String name, String description, int price) {
		super();
		setName(name);
		setDescription(description);
		setPrice(price);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
	  if (name.length() <= 0) {
		System.out.println("상품명을 입력해 주세요");
	  } else {
	    this.name = name;
	  }
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
	  if (price < 0) {
	    System.out.println("상품 가격은 최소한 0원 이상이어야 합니다");
	  } else {
	    this.price = price;
	  }
		
	}
	@Override
	public String toString() {
		return "ProductVO [name=" + name + ", description=" + description + ", price=" + price + "]";
	}
	
	

}
