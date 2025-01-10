package cucumberpackage;

import Pages.Basket;
import Pages.dashboard;
import TestPackage.Baseclass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepdefination extends Baseclass{
	public dashboard d;
	Basket b; 
	@Given("I have open greenkart site")
	public void I_have_open_greenkart_site()
	{
		openURL("https://rahulshettyacademy.com/seleniumPractise/#/");
	}
	
	@When("added items in basket")
	public void added_items_in_basket() throws Exception
	{
		d=dashobj();
		String a[] =datamethod().split(",");
		for(String item :a)
		{
			w=d.addtokart(item);
		}
	}
	
	@And("complete the checkout")
	public void complete_the_checkout() throws Exception
	{
		b = new Basket(w,datamethod());
		b.Chekout();
		w.quit();
	}
	
}
