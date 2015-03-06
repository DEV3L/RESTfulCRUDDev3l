package com.dev3l.ws.agent;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.dev3l.ws.bean.UserBean;
import com.dev3l.ws.datastore.UserDataStore;

@Singleton
public class UserAgent {
	private static final Logger logger = LogManager.getLogger();

	public List<UserBean> get() {
		final List<UserBean> userBeans = new ArrayList<UserBean>();

		for (final Long id : UserDataStore.getUserBeanMap().keySet()) {
			userBeans.add(UserDataStore.getUserBeanMap().get(id));
		}

		return userBeans;
	}

	public UserBean get(final long id) {
		return UserDataStore.getUserBeanMap().get(id);
	}

	public UserBean add(final UserBean userBean) {
		if (userBean == null) {
			logger.warn("Cannot add a null user");
			return null;
		}

		if (userBean.getId() != null) {
			logger.warn("Cannot add user that already exists... user should not have an id value.");
			return null;
		}

		long maxId = 0;

		for (final Long id : UserDataStore.getUserBeanMap().keySet()) {
			if (id > maxId) {
				maxId = id;
			}
		}

		userBean.setId(++maxId);
		UserDataStore.getUserBeanMap().put(userBean.getId(), userBean);

		return userBean;
	}

	public boolean update(final UserBean userBean) {
		if (userBean == null) {
			logger.warn("Cannot update a null user");
			return false;
		}

		UserDataStore.getUserBeanMap().put(userBean.getId(), userBean);
		return true;
	}

	public boolean delete(final long userBeanId) {
		if (UserDataStore.getUserBeanMap().get(userBeanId) != null) {
			UserDataStore.getUserBeanMap().remove(userBeanId);
			return true;
		}

		logger.warn("Could not delete user: " + userBeanId);
		return false;
	}
}
