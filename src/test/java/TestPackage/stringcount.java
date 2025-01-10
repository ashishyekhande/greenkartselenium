package TestPackage;

import org.testng.annotations.Test;

public class stringcount {

	@Test
	public void Stringcount() {

		String str = "Deepak";
		int count = 0;

		for (int i = 0; i < str.length(); i++) {

			char a= str.charAt(i);
			for(int j=0;j<str.length();j++)
			{
				if(a==str.charAt(j))
				{
					count++;
				}
				else {
					//System.out.println(a +"->"+count);
				}
				
			}
					System.out.println(a +"->"+count);
					count =0;
		}

	}
}
