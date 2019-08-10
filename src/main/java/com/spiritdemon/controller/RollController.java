package com.spiritdemon.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spiritdemon.pojo.Roll;
import com.spiritdemon.service.RollService;

@Controller
public class RollController {
	@Resource
	private RollService rollServiceImpl;
	@SuppressWarnings("unchecked")
	@RequestMapping("roll")
	public String roll(String username, HttpServletRequest req, HttpServletResponse resp) {
		//重定向直接访问控制器的请求
		if(username == null) {
			return "redirect:/index.jsp";
		}
		//去除username中的空格
		username = username.replaceAll(" ", "");
		//名称为空
		if(username.equals("")) {
			req.setAttribute("flag", 1);
			return "forward:/result.jsp";
		}
		//如有Cookie，检查其中名称与输入名称是否一致
		Logger logger = Logger.getLogger(RollController.class);
		Cookie[] cks = req.getCookies();
		try {
			for (Cookie ck : cks) {
				if(ck.getName().equals("username") && !URLDecoder.decode(ck.getValue(), "UTF-8").equals(username)) {
					req.setAttribute("flag", 2);
					return "forward:/result.jsp";
				}
			}
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage());
		}
		//根据名称查询数据库中是否有该用户roll点记录
		Roll r = rollServiceImpl.showRoll(username);
		//标记是否为新用户
		boolean newRoll = false;
		ServletContext application = req.getServletContext();
		if(r == null) {
			newRoll = true;
			logger.info(username+"还未roll，进行roll点");
			//roll点
			int rollValue = (int) (Math.random() * 10000);
			int index = rollServiceImpl.insRoll(username, rollValue);
			if(index == 1) {
				//如数据库信息添加成功，则重新用名称查询后取得该User对象
				r = rollServiceImpl.showRoll(username);
				logger.info(r.getId()+"号"+username+"，roll到"+rollValue+"点");
			}else {
				logger.error("roll点出错");
			}
			//添加Cookie信息，以防用多个名称roll点
			Cookie ck = null;
			try {
				ck = new Cookie("username", URLEncoder.encode(username, "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				logger.error(e.getMessage());
			}
			ck.setMaxAge(3*24*3600);
			resp.addCookie(ck);
		}
		if(r != null) {
			if(newRoll == false) {
				//如果不是新用户，则打印查询记录日志
				logger.info(r.getId()+"号"+username+"，查询自己roll到的"+r.getRollValue()+"点");
			}
			List<Roll> list = null;
			if(application.getAttribute("list") == null) {
				//如果application作用域中无list信息，则执行一次全表查询
				list = rollServiceImpl.showAll();
			}else {
				//如果application作用域中已有list信息，则直接从作用域中获取以减少数据库查询次数
				list = (List<Roll>) application.getAttribute("list");
				if(newRoll == true) {
					//向list中添加新用户信息
					list.add(r);
				}
			}
			//将当前用户信息存储到request作用域中
			req.setAttribute("r", r);
			//将全部用户信息存储到application作用域中
			application.setAttribute("list", list);
			req.setAttribute("flag", 0);
			return "forward:/result.jsp";
		}else {
			req.setAttribute("flag", 3);
			return "forward:/result.jsp";
		}
	}
}
