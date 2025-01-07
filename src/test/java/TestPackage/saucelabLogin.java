package TestPackage;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pages.dashboard;
import Pages.sausedemo;
@Listeners(Listen.class)
public class saucelabLogin extends Baseclass {
	public dashboard d;
	public sausedemo s ;

	@Test(dataProvider = "login")
	public void sauseloginTest(HashMap<String , String> a)throws Exception 
	{
		
		openURL("https://www.saucedemo.com/");
		s=sauseobj();
		s.loginTest(a.get("user"),a.get("pass")) ;
		
	}
	
	
	@DataProvider(name ="login")
	public Object[][] hashmapobj()
	{
		
		HashMap<String, String> obj = new HashMap<String, String>();
		obj.put("user", "standard_user");
		obj.put("pass", "secret_sauce");
		return new Object[][]
				{ {obj}  };	
	}

}
