package org.crce.interns.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.crce.interns.beans.UserBean;
import org.crce.interns.model.User;

public class AddTPCValidator implements Validator {

	@Override
	public boolean supports(Class<?> paramClass) {
		// TODO Auto-generated method stub
		return User.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		UserBean userBean = (UserBean) obj;
		System.out.println(userBean.getUsername() + " : User Name in Validator");
		System.out.println(userBean.getRole_id() + " : User Role ID in Validator");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "username.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "role_id", "role_id.required");
	}

}
