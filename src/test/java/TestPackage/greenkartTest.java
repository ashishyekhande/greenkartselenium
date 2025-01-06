package TestPackage;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Pages.Basket;
import Pages.dashboard;
import Pages.*;

//@Listeners(Listen.class)
public class greenkartTest extends Baseclass {

	public dashboard d;
	public sausedemo s ;
	
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
