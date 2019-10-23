package stringkata;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class Calculator {
	
	public static int Add(String numbers) {
		int sum =0;
		List<Integer> negatives = new ArrayList<Integer>();
		if (numbers.isEmpty()) {
			return 0;
		}else {
			
			String[] strNumbers  =splitString(numbers);
			
				for(String number: strNumbers) {
					int n = Integer.parseInt(number);
					if (n < 0) {
						negatives.add(n);
					}
					
				}
				if (negatives.size() > 0) {
					throw new RuntimeException("Negative Numbers Not Allowed: "+ StringUtils.join(negatives,','));
				}
				
			for( String n: strNumbers) {
				sum +=Integer.parseInt(n);
				
			}
			
			return sum;
		}
		
//		return 1;
	}
	
	
	
	public static String[] splitString(String text) {
		if (text.startsWith("//")) {
			Matcher m= Pattern.compile("//(.)\n(.*)").matcher(text);
			m.matches();
			String customSpliter = m.group(1);
			String numbers = m.group(2);
			return numbers.split(customSpliter);
		}else {
			String[] strNumbers  = text.split(",|\n");
			
			return strNumbers;
			
		}
		
	
	}

}
