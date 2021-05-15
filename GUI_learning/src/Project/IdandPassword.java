package Project;

import java.util.HashMap;

public class IdandPassword {
	private static IdandPassword instance = null;
	private static HashMap<String, String> customerLoginInfo = new HashMap<String, String>();
	private static HashMap<String, String> authorityLoginInfo = new HashMap<String, String>();
	private static HashMap<String, String> administratorLoginInfo = new HashMap<String, String>();
	
	IdandPassword(){
		customerLoginInfo.put("abc", "12345678");
		customerLoginInfo.put("xyz", "87654321");
		customerLoginInfo.put("yoo", "12345678");
		
		authorityLoginInfo.put("tom", "tom12345");
		authorityLoginInfo.put("jerry", "jerry12345");
		authorityLoginInfo.put("mark", "mark12345");
		
		administratorLoginInfo.put("Prit", "Prit2000");
	}
	
	public static IdandPassword getInstance() {
		if(instance == null) {
			instance = new IdandPassword();
		}
		customerLoginInfo = getCustomerLoginInfo();
		authorityLoginInfo = getAuthorityLoginInfo();
		administratorLoginInfo = getAdministratorLoginInfo();
		return instance;
	}
	
	protected static HashMap<String, String> getCustomerLoginInfo(){
		return customerLoginInfo;
	}
	
	protected static HashMap<String, String> getAuthorityLoginInfo(){
		return authorityLoginInfo;
	}

	protected static HashMap<String, String> getAdministratorLoginInfo(){
		return administratorLoginInfo;
	}
	public void addCustomer(String user, String password){
		if(!customerLoginInfo.containsKey(user)) {
			//customerLoginInfo.put(user, password);
			System.out.println(customerLoginInfo);
		}
		else {
			customerLoginInfo.put(user, password);
			System.out.println(customerLoginInfo);
		}
	}
	
	public void addAuthority(String user, String password){
		if(!authorityLoginInfo.containsKey(user)) {
			authorityLoginInfo.put(user, password);
		}
	}
	
	public void addAdministrator(String user, String password){
		if(administratorLoginInfo.containsKey(user)) {
			administratorLoginInfo.put(user, password);
		}
	}

}
