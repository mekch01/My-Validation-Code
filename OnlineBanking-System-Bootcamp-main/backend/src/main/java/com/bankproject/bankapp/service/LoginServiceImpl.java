package com.bankproject.bankapp.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankproject.bankapp.entity.Login;
import com.bankproject.bankapp.repository.LoginRepository;

@Service
public class LoginServiceImpl {
    @Autowired
    LoginRepository loginRepository;

    public void getLoginObject(long uId, String pswd) {
        /* -> To Refactor the code for LoginModel*/
        Login login = new Login();
        login.setUserId(uId);
        login.setPswd(pswd);
        loginRepository.save(login);
    }

	public String validateCustomer(Login l) {
		String result = "Invalid Credentials or Not Registered Customer";

		Login response = loginRepository.findByUserId(l.getUserId());
		if(response == null) {
			return result;
		}
		if(response.getPswd().equals(l.getPswd())) {
			result = "Credentials matched! Login Success";
		}

		return result;
	}
	
    
}