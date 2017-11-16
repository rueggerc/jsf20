package com.rueggerllc.jsf20.utils;

import com.rueggerllc.jsf20.beans.Account;

public class Utils {

	public static boolean isBlank(String field) {
		return (field == null || field.trim().equals(""));
	}
	
	public static String getAccountLabel(Account account) {
		return account.getName();
	}
	
//	public static <T> T findBean(FacesContext context, String beanName) {
//		return (T) context.getApplication().evaluateExpressionGet(context, "#{" + beanName + "}", Object.class);
//	}
//	
//	@SuppressWarnings("unchecked")
//	public static <T> T findBean(String beanName) {
//		FacesContext context = FacesContext.getCurrentInstance();
//		return (T) context.getApplication().evaluateExpressionGet(context, "#{" + beanName + "}", Object.class);
//	}

}
