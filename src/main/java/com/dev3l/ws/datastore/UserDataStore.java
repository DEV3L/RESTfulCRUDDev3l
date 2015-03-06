package com.dev3l.ws.datastore;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.inject.Named;

import com.dev3l.ws.bean.UserBean;

@Named
public class UserDataStore {
	private UserDataStore() {
	}

	private static Map<Long, UserBean> userBeanMap = new LinkedHashMap<Long, UserBean>();
	static {
		userBeanMap.put(1l, createUserBean(1, "admin", "admin@email.com", "AC", "admin"));
		userBeanMap.put(2l, createUserBean(2, "user_one", "user_one@email.com", "AC", "user_one"));
		userBeanMap.put(3l, createUserBean(3, "user_two", "user_two@email.com", "AC", "user_two"));
	}

	private static UserBean createUserBean(final long id, final String userName, final String email, final String status, final String password) {
		final UserBean userBean = new UserBean();

		userBean.setEmail(email);
		userBean.setId(id);
		userBean.setPassword(password);
		userBean.setStatus(status);
		userBean.setUserName(userName);

		return userBean;
	}

	public static Map<Long, UserBean> getUserBeanMap() {
		return userBeanMap;
	}
}
