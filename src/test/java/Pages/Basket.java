package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Basket extends utility {

	public WebDriver w;
	public String  listofitem;
	public Basket(WebDriver w, String listofitem) {
		// TODO Auto-generated constructor stub
		super(w);
		this.w=w;
		this.listofitem=listofitem;
		PageFactory.initElements(w, this);
	}
	
	@FindBy(css = "img[alt='Cart']")WebElement ele_basket;
	@FindBy(css = "button[type ='button']")List<WebElement> ele_addtokart;
	@FindBy(css = ".promoCode")WebElement ele_promocode;
	@FindBy(css = ".promoBtn")WebElement ele_promobutton;
	@FindBy(css = ".promoInfo")WebElement ele_info;
	@FindBy(css = "button")List<WebElement> ele_button;
	@FindBy(css = ".chkAgree")WebElement ele_checkbox;
	

	public void Chekout() throws Exception {
		// TODO Auto-generated method stub
		ele_basket.click();
		WebElement ele =smartList(ele_addtokart, "PROCEED TO CHECKOUT");
		//WebElement ele = ele_addtokart.stream().filter(s->s.getText().equalsIgnoreCase("PROCEED TO CHECKOUT")).findAny().orElse(null);
		Thread.sleep(2000);
		ele.click();
		verify();
		
		ele_promocode.sendKeys("reg");
		ele_promobutton.click();
		waitforelement(ele_info);
		Assert.assertEquals(ele_info.getText(), "Invalid code ..!");
		scroll();
		smartList(ele_button, "Place Order").click();
		Select s = new Select(w.findElement(By.cssSelector("select")));
		Thread.sleep(3000);
		s.selectByVisibleText("India");
		ele_checkbox.click();
		smartList(ele_button, "Proceed").click();
		
	}


	private void verify() 
	{
		// TODO Auto-generated method stub
		String a[]=listofitem.split(",");
		boolean b[]= new boolean[a.length];
		List<WebElement> items = w.findElements(By.cssSelector(".product-name"));
		int i =0;
	
		try {
			for(String str :a)
			{
				WebElement ele =smartList(items, str);
				//WebElement ele = items.stream().filter(s->s.getText().equalsIgnoreCase(str)).findAny().orElse(null);
				
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("item mismatch");
		}
		
		
		
	}

}
