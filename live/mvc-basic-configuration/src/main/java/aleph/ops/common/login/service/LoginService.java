package aleph.ops.common.login.service;

public class LoginService {
	
	public Boolean verifyUser(String username, String password) {
		return username.equals("Tabish") && password.equals("password");
	}

}
