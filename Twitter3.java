import java.util.Scanner;

public class Twitter3 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextLine()){
			String nextLine = scanner.nextLine();
			if(nextLine.contains("E")){
				String maskedEmail = maskEmail(nextLine.substring(2,nextLine.length() ));
				System.out.println("E:"+maskedEmail);
			}
			else if(nextLine.contains("P")){
				String maskedPhoneNumber = maskPhoneNumber(nextLine.substring(2,nextLine.length()));
				System.out.println("P:"+maskedPhoneNumber);
			}
		}
		scanner.close();
	}
	
	public static String maskEmail(String email){
		String[] emailSplit = email.split("@");
		char firstLetter = emailSplit[0].charAt(0);
		char lastLetter = emailSplit[0].charAt(emailSplit[0].length()-1);
		String maskedEmail = firstLetter+"*****"+lastLetter+"@"+emailSplit[1];
		return maskedEmail;
	}
	
	public static String maskPhoneNumber(String phoneNumber){
		String[] phoneNumberSplit = null;
		String maskedPhoneNumber="";
		int limiter= 0;
		if(phoneNumber.charAt(0) == '+'){
			maskedPhoneNumber+="+";
			int i = 0;
			while(phoneNumber.charAt(i+1)!='('){
				maskedPhoneNumber+="*";
				i++;
			}
			limiter = i;
			maskedPhoneNumber+="-";
			phoneNumber= phoneNumber.substring(limiter+1,phoneNumber.length());
		}
		
		if(phoneNumber.contains("-")){
			int count=0;
			phoneNumberSplit = phoneNumber.split("-");
			for(int i = 0 ; i < phoneNumberSplit[0].length(); i ++){
				String character = ""+phoneNumberSplit[0].charAt(i);
				if(count<3){
					if(character.matches("[0-9]+")){
						maskedPhoneNumber += "*";
						count++;
					}
					
				}
				else{
					count = 0 ;
					maskedPhoneNumber+="-";
				}
			}
			maskedPhoneNumber+="-"+phoneNumberSplit[1];
		}
		else{
			int count=0;
			phoneNumberSplit = phoneNumber.split(" ");
			int slot=1;
			for(String parts:phoneNumberSplit){
				if(slot==3){
					break;
				}
				for(int i = 0 ; i < parts.length(); i ++){
					String character = ""+parts.charAt(i);
					if(count<3){
						if(character.matches("[0-9]+")){
							maskedPhoneNumber+="*";
							count++;
						}
					}
					if(count==3){
						count = 0;
						maskedPhoneNumber+="-";
					}
				}
				slot++;
			}
			maskedPhoneNumber+=phoneNumberSplit[2];
		}
		return maskedPhoneNumber;
	}
}
