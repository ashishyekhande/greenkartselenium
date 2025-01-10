package TestPackage;

import java.util.Scanner;

import org.testng.annotations.Test;

public class testqk {

	@Test
	public void test123()
	{
		String str ;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter string ");
		str= sc.nextLine();
		
		//ex  Ashish
		
		for(int i=0;i<str.length();i++)
		{
			char a= str.charAt(i);
			
			for(int j=i+1;j<str.length();j++)
			{
				if(a==str.charAt(j))
				{
					System.out.println("repeated => "+a);
					
				}
				
			}
			
		}
		
	}
	
}
