package com.assignment.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class UserController {
	@Autowired
	private org.springframework.jdbc.core.JdbcTemplate jdbcTemplate;

	@RequestMapping("verifyregister")
	public String register(HttpServletRequest req, Model m) {

		String name = req.getParameter("name");
		Boolean i = jdbcTemplate.queryForObject(" select exists( select * from pet_user where user_name=?)",
				Boolean.class, name);
		if (i) {
			String msg = "User name already Exists";
			m.addAttribute("message", msg);
			return "usererrorpage";

		} else {
			String password = req.getParameter("password");
			String cpassword = req.getParameter("cpassword");
			if (password.equals(cpassword)) {
				String query = "insert into pet_user(user_name,user_passwd) values('" + name + "','" + password + "')";
				int j = jdbcTemplate.update(query);
				return "successregister";

			} else {
				String msg = "sorry both passwords must match";
				m.addAttribute("Message", msg);
				return "registererrorpage";
			}
		}

	}

	@RequestMapping("/verifylogin")
	public String login(HttpServletRequest req, Model m, final HttpSession see) {
		final String name = req.getParameter("name");
		final String password = req.getParameter("password");

		/*
		 * Boolean i = jdbcTemplate.queryForObject(
		 * "select exists(select id from pet_user where user_name=? and user_passwd=?)",
		 * Boolean.class, name, password);
		 */
		String sql = "select * from pet_user where user_name=? and user_passwd=?";
		boolean i = jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {

			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, name);
				ps.setString(2, password);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					see.setAttribute("id", rs.getInt("id"));
					return true;
				} else {
					return false;
				}

			}
		});
		if (i) {
			see.setAttribute("name", name);
			return "loginsuccess";

		} else {
			String msg = "username and password does not match";
			m.addAttribute("message", msg);
			return "passworderrorpage";

		}

	}

	@RequestMapping("/log")
	public String log() {
		return "login";
	}

	@RequestMapping("/register")
	public String register() {
		return "register";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "logout";
	}

}
