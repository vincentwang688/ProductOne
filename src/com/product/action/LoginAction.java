package com.product.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.model.UserInfo;
import com.product.service.UserInfoService;

public class LoginAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private UserInfoService service;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// String path = request.getContextPath();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String pswd = request.getParameter("pswd");

		UserInfo user = new UserInfo();
		user.setUserName(username);
		user.setPassword(pswd);

		boolean flag = service.login(user);
		String json = "";
		if (flag) {
			// response.sendRedirect(path + "/index.jsp");
			json = "{\"ok\":true,\"message\":\"登录成功\",\"object\":null}";
		} else {
			json = "{\"ok\":false,\"message\":\"登录失败\",\"object\":null}";
		}
		out.print(json);
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
		service = new UserInfoService();
	}
}
