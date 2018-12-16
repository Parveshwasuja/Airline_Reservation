public class validation{
	public static boolean checkname(String str){
		int flag=0;
		if(str==null || str.equals("null") || str.equals(""))
		{
			
			return false;
		}
		else{
		int length = str.length();
		for(int i=0;i<length;i++){
             char ch=str.charAt(i);
             if(Character.isLetter(ch) || Character.isWhitespace(ch))
             {
             	continue;
             }
             else
             {
             	flag=1;
             	break;
             }
             
		}
		if(flag==1)
		{
			return false;

		}
		else
		{
			
        return true;
		}
		
	  }
	}
	public static boolean checkinteger(String num){

		if(num!=null){
		int length = num.length();
		if(length>=2){
			int b = (int)num.charAt(0);
			int c = (int)num.charAt(1);
			if((b>=48 && b<=57) && (c>=48 && c<=57)){


		    
			for(int i=0;i<length;i++){
				int a = (int)num.charAt(i);
				if( (a>=48 && a<=57) || a==46 ){
            		
            	}
            	else{
            		return false;
            	}
			}
			return true;
	    	}
		}else{
			return false;
		}
		
		
	  }
	  return false;

	}

	public static boolean checkintegerwithoutdecimal(String num){

		if(num!=null){
		int length = num.length();
		if(length>=2){
			

		    
			for(int i=0;i<length;i++){
				int a = (int)num.charAt(i);
				if( (a>=48 && a<=57) ){
            		
            	}
            	else{
            		return false;
            	}
			}
			return true;
	    	
		}else{
			return false;
		}
		
		
	  }
	  return false;

	}
	  
	  
	
	public static boolean checkadhaar(String num){
		if(num!=null){
		int length = num.length();
		if(length==12){
            for(int i=0;i<num.length();i++){
            	int a=(int)num.charAt(i);
            	if(a>=48 && a<=57){
            		
            	}
            	else{
            		return false;
            	}
            }
            return true;
		}
		else{
			return false;
		}
	  }
	  return false;
	}
	public static boolean checkcontact(String num){
		if(num!=null){
		int length = num.length();
		if(length==10){
			for(int i=0;i<length;i++){
				int a = (int)num.charAt(i);
				if(a>=48 && a<=57){
            		
            	}
            	else{
            		return false;
            	}
			}
			return true;
		}
		else{
			return false;
		}
	  }
	  return false;
	}
	public static boolean checkage(String str){
		try{
			int age = Integer.parseInt(str);
			if(age>=3 && age<=100){
				return true;
			}
			else{
				return false;
			}
		}
		catch(Exception e){
			return false;//JOptionPane.showMessageDialog(this,"Enter valid age");
		}

	}
	public static boolean password(String str){
		int length = str.length();
		int temp=0,flag=0;
		if(length>=5 && length<=20){
			for(int i=0;i<length;i++){
				int a = (int)str.charAt(i);
				if(a>=48 && a<=57){
					temp=1;
				}
				if( (a>=65 && a<=90) || (a>=97 && a<=122) ){
					flag=1;
				}
			}
			if(flag==1 && temp==1){
				return true;

			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}
	public static boolean validaddress(String address){
		return address.matches( 
         "\\d+\\s+([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)" );
	}
	public static boolean checkemail(String str){
		
	  if( str!=null && str.length()>5 && str.indexOf('@')>1 && str.indexOf('.')>1)
	  {
	  	return true;
	  }
	  else{
	  	return false;
	  }
		
	
	
  }
  public static void main(String[] args) {
  	System.out.println(checkname("Ashish Kumar"));
  	System.out.println(checkemail("rohit@gmail.com"));
  }

}