package com.yulag;

import Event.User;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import utils.JDBCUtils;

import java.util.List;

/*
 *类名:Leader.class
 *版本:1.0
 *日期:2020年12月29日
 */
public class Leader {
		static Login login;
		public static void setDisappear(Login logina) {
			login=logina;
	}
		public static void disappear() {
			login.dispose();
	}

	public static void main(String[] args) {
		Login login =new Login();//加载登录类
		setDisappear(login);
	}
}
