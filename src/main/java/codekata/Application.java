package codekata;

import codekata.models.Address;
import codekata.models.ValidationResult;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;

public class Application {
	
//Get the smallest number in the array
public static int getSmallestNumber(int[] x) {
	int smallest = x[0];
	for(int i = 1; i < x.length; ++i) {
		if(x[i] < smallest)
			smallest = x[i];
	}
	return smallest;
}


	//Find Highest CommonFactor Function
	public static int highestCommonFactor(int[] numbers) {
		
		
		int smallest = getSmallestNumber(numbers);
		
		for(int i = smallest; i >= 1; i--) {
		   int j;
		   for(j = 0; j < numbers.length; ++j) {
			   if(numbers[j] % i != 0)
				   break;
		   }
		   
		   
		   //Return the HCF if we're done
		   if(j == numbers.length)
			   return i;
		}
		// so the only possible is 1
		return 1;

		}
	
	
	public static ValidationResult validateAddress(Address address) {
		
	 Boolean isValid = false;
	 Boolean isPostalCodeNumeric = false;
	 Boolean hasCountry = false;
	 Boolean isAddressZAR = false;
	 Boolean addressLinePresent = false;
	 Boolean hasProvince = false;
	 Boolean hasPostalCode = false;
	 
	 List<String> issues =new ArrayList<String>();
	 
	 
	 if (address.getPostalCode() != null && !address.getPostalCode().isEmpty()) {
		 
		 hasPostalCode = true;
		
		 if (hasPostalCode) {
	
			if (StringUtils.isNumeric(address.getPostalCode())) {
				isPostalCodeNumeric=true;
			}else {
				 issues.add("Address has a non-numeric Postal Code");
			 }
		 }else {
			 issues.add("Address has no Postal Code");
		 }
		  
	 }
	 
	 if (!address.getCountry().getName().isEmpty() && address.getCountry().getName() != null) {
		 
		 hasCountry = true;
		 
		 if (hasCountry) {
			 isAddressZAR = address.getCountry().getCode().equals("ZA");
		 }
	 }else {
		issues.add("Address has no country");
	 }
	 
	 if (address.getAddressLineDetail() != null) {
		 if(!address.getAddressLineDetail().getLine1().isEmpty() || !address.getAddressLineDetail().getLine2().isEmpty() ) {
			 
			 addressLinePresent=true;
		 }else {
			 issues.add("Address has no address line");
		 }
		 
	 }else {
		 issues.add("Address has no address line");
	 }
	 
	 if (isAddressZAR) {
		 
		 if (address.getProvinceOrState() !=null) {
			 if (!address.getProvinceOrState().getName().isEmpty() && address.getProvinceOrState().getName() != null) {
			 		hasProvince=true;
			 	}else {
			 		 issues.add("Address has no province");
			 	}
		 }else {
			 issues.add("Address has no province");
		 }
		 	
	 }
	 
	 if (isAddressZAR) {
		 
		 if (hasProvince && addressLinePresent && isPostalCodeNumeric && hasCountry ) {
			 isValid =true;
		 }else {
			 isValid =false;
		 }
		 
	 }else {
		 
		 if (addressLinePresent && isPostalCodeNumeric && hasCountry ) {
			 isValid =true;
		 }else {
			 isValid =false;
		 }
	 }
	 
	 
	 ValidationResult result = new ValidationResult();
	 result.setIsValid(isValid);
	 result.setIssues(issues);
	 
	 return result;
	}
	//AddressType Menu Option Function
	public static int addressTypeOption() {
		Scanner sc = new Scanner(System.in);
		 System.out.println("Please Select an Address type Below (e.g. 1, 2 or 5 ):");
		 System.out.println("1. Physical Address");
		 System.out.println("2. Postal Address");
		 System.out.println("5. Business Address");
		 System.out.print("Selected option: ");
		 
		 
		 int addressType = sc.nextInt();
		 
		 return addressType;
	}

	//Pretty Print address function
	public static String prettyPrintAddress(Address address) {

		String prettyAddress ="";
		
		String addressType ="";
		String addressLine1="";
		String addressLine2="";
		String cityOrTown="";
		String province ="";
		String postalCode="";
		String country="";
		
		if (address.getType() != null ) {
			addressType = address.getType().getName();
		}
		
		if (address.getType() != null ) {
			addressType = address.getType().getName();
		}
		if (address.getAddressLineDetail() != null ) {
			addressLine1 = address.getAddressLineDetail().getLine1();
			addressLine2 = address.getAddressLineDetail().getLine2();
		}
		if (address.getCityOrTown() != null ) {
			cityOrTown = address.getCityOrTown();
		}
		
		
		if (address.getProvinceOrState() != null ) {
			province = address.getProvinceOrState().getName();
		}
		
		
		if (address.getPostalCode() != null ) {
			postalCode = address.getPostalCode();
		}
		
		if (address.getPostalCode() != null ) {
			country = address.getCountry().getName();
		}
		
		prettyAddress = String.format("%s:%s,%s-%s-%s-%s-%s", addressType,  addressLine1, addressLine2,cityOrTown,province,postalCode, country);
		
		return prettyAddress;

		}
		 

	public static Address[] loadAddressesFromFile() {
	Gson gson = new Gson();
	Address[] addressList = null;
		String filePath = "./src/main/java/codekata/addresses.json";
		 
		
		String content;
		try {
			content = new String ( Files.readAllBytes( Paths.get(filePath) ) );
			

			 addressList = gson.fromJson(content, Address[].class);
			return addressList;
		} catch (IOException e) {
			
			//Do nothing and return empty array
		}
		return addressList;
	}
	
	
	public static void printAllAddresses(Address[] a) {
		for(Address address: a) {
			System.out.println(prettyPrintAddress(address));
	}
	}
	
	
	public static int menu() {
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Please Select an option from the menu below (e.g. 1 or 2 ):");
		 System.out.println("1. Pretty Print All Addresses");
		 System.out.println("2. Pretty Print Specific Addresses");
		 System.out.println("3. Validate Addreses");
		 System.out.println("4. Highest Common Factor");
		 System.out.println("0. Exit");
		 System.out.print("Selected option: ");
		 
		 	int option = sc.nextInt();
		 	
		 	return option;
	}
	
	
	public static void prettyPrintSpecific(Address[] a, int id){
		for(Address address: a) {
			
			if (address.getType().getCode() == id)
					System.out.println(prettyPrintAddress(address));
	}
		
	}
	


	public static void main(String[] args)  {

		Address[] addressList= loadAddressesFromFile();
		
		int selected= menu();
		
		while(selected != 0) {
			
			if (selected == 1) {
				printAllAddresses(addressList);
			}
			
			if (selected == 2) {
				 
				 int addressType = addressTypeOption();
				 prettyPrintSpecific(addressList,addressType);
			
			}
			
			if (selected == 3) {
				
				for (Address a:addressList ) {
					
				
					System.out.print("\nValidation Results For: ");
					System.out.println(prettyPrintAddress(a));
					
					ValidationResult r = validateAddress(a);
					
					if (r.getIsValid()) {
						System.out.println("Address given is valid ");
					}else {
						System.out.println("Address is invalid given the following issues: ");
						
						for (String issue: r.getIssues()) {
							System.out.println(issue);
						}
					}
				}
			}
			
			if (selected == 4) {
				
				int[] numbers = {177,50};
				
				System.out.println("Highest Common Factor is: "+ highestCommonFactor(numbers));
			}
			
			if (selected == 0) {
				System.out.println("Bye Bye");
			}
			
			selected= menu();
		}
		

	}
	

    
 
    }
    
    


