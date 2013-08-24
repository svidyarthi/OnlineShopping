package pojo;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {
	
	private int productId;
	private String productName;
    private String productDesc;
    private String productCategory;
    private BigDecimal weight_lb;
	private BigDecimal price;
    
    public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public BigDecimal getPrice() {
			return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getWeight_lb() {
		return weight_lb;
	}

	public void setWeight_lb(BigDecimal weight) {
		this.weight_lb = weight;
	}
   
}
