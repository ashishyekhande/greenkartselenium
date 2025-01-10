package TestPackage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pages.Basket;
import Pages.dashboard;
import Pages.*;

@Listeners(Listen.class)
public class greenkartTest extends Baseclass {

	public dashboard d;
	@Test  //itrating vegitable list from excel
	public void checkouttest() throws Exception
	{		
		openURL("https://rahulshettyacademy.com/seleniumPractise/#/");
		d=dashobj();
		String a[] =datamethod().split(",");
		for(String item :a)
		{
			w=d.addtokart(item);
		}
		Basket b = new Basket(w,datamethod());
		b.Chekout();
				
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
