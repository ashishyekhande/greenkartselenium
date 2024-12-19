package Pages;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class dashboard extends utility{

	public WebDriver w;
	public dashboard(WebDriver w) {
		// TODO Auto-generated constructor stub
		super(w);
		this.w = w;
		PageFactory.initElements(w, this);
		
	}
	
	@FindBy(css = ".product h4")WebElement ele_prodname;
	@FindBy(css = "input[type ='search']")WebElement ele_search;
	@FindBy(css = "button[type ='button']")List<WebElement> ele_addtokart;
	@FindBy(css = "img[alt='Cart']")WebElement ele_basket;
	@FindBy(css = "p[class='product-name']")List<WebElement> ele_item_in_basket;
	
	
	public WebDriver addtokart(String item) throws Exception 
	{
		// TODO Auto-generated method stub
		ele_search.clear();
		ele_search.sendKeys(item);
		Thread.sleep(2000);
		WebElement ele =smartList(ele_addtokart, "ADD TO CART");
	//	WebElement ele = ele_addtokart.stream().filter(s->s.getText().equalsIgnoreCase("ADD TO CART")).findAny().orElse(null);
		Thread.sleep(2000);
		ele.click();
		
		
		ele_basket.click();
		WebElement ele_in_basket =smartList(ele_item_in_basket, item);
		//WebElement ele_in_basket = ele_item_in_basket.stream().filter(s->s.getText().equalsIgnoreCase(item)).findFirst().orElse(null);
		String item_in_basket = ele_in_basket.getText();
		
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(item, item_in_basket);
		softassert.assertAll();
		ele_basket.click();
		return w;
		
		
		
	}

	
	
}
