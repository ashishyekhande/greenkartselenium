package TestPackage;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Pages.dashboard;
import Pages.sausedemo;
@Listeners(Listen.class)
public class Login_hashmap extends Baseclass{

	
	public dashboard d;
	public sausedemo s ;

	@Test(dataProvider = "login")
	public void sauseloginTest_hashmap(HashMap<String , String> a)throws Exception 
	{
		
		openURL("https://www.saucedemo.com/");
		s=sauseobj();
		s.loginTest(a.get("user"),a.get("pass")) ;
		
	}
	
	@DataProvider(name ="login")
	public Object[][] JsonHash() throws Exception
	{
		File jsonFile = new File("./jsondata.json");
	
		//this line will return list of hashmaps 
		ObjectMapper obj = new ObjectMapper();
		List<HashMap<String , String>> datalist = obj.readValue(jsonFile, new TypeReference<List<HashMap<String ,String>>> () {}   );
	
		//convert hashmap list to object 
		
		Object[][] data = new Object[datalist.size()][1];
		for (int i = 0; i < datalist.size(); i++) {
            data[i][0] = datalist.get(i);
        }		
		
		return data;
			
		
	}
	
	
}
