package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class sausedemo extends utility {

	public WebDriver w;

	public sausedemo(WebDriver w) 
	{
		super(w);
		this.w=w;
		PageFactory.initElements(w, this);
	}
	
		// TODO Auto-generated constructor stub
		public void loginTest(String user, String pass)
		{
			w.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys(user);
			w.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys(pass);
			w.findElement(By.cssSelector("#login-button")).click();
		}
	

}
