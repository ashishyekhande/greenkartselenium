package TestPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pages.Basket;
import Pages.dashboard;

@Listeners(Listen.class)
public class greenkartTest extends Baseclass {

	dashboard d;
	@Test//(dataProvider = "veg")
	public void checkouttest() throws Exception
	{		
		String a[] =datamethod().split(",");
		for(String item :a)
		{
			w=d.addtokart(item);
		}
		Basket b = new Basket(w,datamethod());
		b.Chekout();
				
	}
	
	@BeforeTest
	public void siteopen()
	{
		d=openURl("https://rahulshettyacademy.com/seleniumPractise/#/");
	}
	
	
	public String datamethod() throws Exception
	{
		FileInputStream file = new FileInputStream("./Data/veg.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sh = wb.getSheetAt(0);
		int row = sh.getLastRowNum();
		int col = sh.getRow(0).getLastCellNum();
		String a="";
		Object o [][]= new Object[row][col];
		for(int i =0;i<row;i++)
		{
			XSSFRow rownum = sh.getRow(i+1);
			for(int j=0;j<col;j++)
			{
				o[i][j] =rownum.getCell(j).getStringCellValue();
				a = o[i][j].toString()+","+a;
			}
			
			
		}
		System.out.println(a);
		return a;
		
	}
	
}
