package com.qst.project02.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qst.project02.test.Log4jLog;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.qst.project02.pojo.User;
import com.qst.project02.service.LoginService;
import org.springframework.web.servlet.ModelAndView;


import java.io.IOException;

@Controller
@RequestMapping("/")
public class LoginController {

/*	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
	@RequestMapping("/testlog")
	public String helloworld() {
		log.info("log开始生成");
		return "Hello world!";
	}*/


    /**
     * 登录接口
     */
    @Autowired
    LoginService loginService;


    // 跳转首页（登录页）
    @RequestMapping("/tologin")
    public String login() {
        return "LoginRegist/assets/login";
    }

    // 跳转首页（登录页）
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/toregist")
    public String regist() {
        return "LoginRegist/assets/regist";
    }

    @RequestMapping("/toStore")
    public String store() {
        return "main/store";
    }

    @RequestMapping("/toOrder")
    public String order() {
        return "main/checkout";
    }

    /**
     * 登陆接口
     *
     * @param user
     * @param request
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/loginUser", method = {RequestMethod.POST, RequestMethod.GET})
    // HttpServletRequest对象代表客户端的请求
    public ModelAndView login(User user, HttpServletRequest request, HttpSession session) {
        Logger logger = LogManager.getLogger(Log4jLog.class);
        ModelAndView mav = new ModelAndView();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        user.setUsername(username);
        user.setPassword(password);
        user = this.loginService.dologin(user);
        if (user != null) {
            session.setAttribute("user", user.getUsername());
            mav.setViewName("index");
            logger.info("登陆|" + username);
            return mav;
        } else {
            session.setAttribute("errormsg", "账号或密码错误!请重新输入");
        }
        mav.setViewName("LoginRegist/assets/login");
        return mav;
    }

    // 注册操作

    /**
     * 注册接口
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/regist", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public int regist(@RequestBody User user) {

        Logger logger = LogManager.getLogger(Log4jLog.class);
        int result = 1;

        loginService.regist(user);
        logger.info("注册|" + user.getUsername() + "|" + user.getAge() + "|" + user.getJob());
        return result;
    }

    /**
     * 跳转到订单页面的接口
     * 接收前端传回的商品信息，从session中获取登陆用户名
     *
     * @param request
     * @param session
     * @return
     */
    @RequestMapping(value = "/order", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView order(HttpServletRequest request, HttpSession session, @RequestParam("pname") String pname, @RequestParam("price") String price) {
        Logger logger = LogManager.getLogger(Log4jLog.class);
        ModelAndView mav = new ModelAndView();
        // String itemname = request.getParameter("pname");
        // String itemprice = request.getParameter("price");
        String username = (String) session.getAttribute("user");
        mav.setViewName("main/store");
        logger.info("点击商品|" + username + "|" + pname + "|" + price);
        return mav;
    }

    @RequestMapping(value = "/cfmorder", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView cfmOrder(HttpServletRequest request, HttpSession session, @RequestParam("name") String name, @RequestParam("price") String price, @RequestParam("realname") String realname, @RequestParam("province") String province, @RequestParam("tel") String tel) {
        Logger logger = LogManager.getLogger(Log4jLog.class);
        ModelAndView mav = new ModelAndView();
        String username = (String) session.getAttribute("user");
        mav.setViewName("main/store");
        logger.info("购买成功|" + username + "|" + name + "|" + price + "|" + realname + "|" + province + "|" + tel);
        return mav;
    }

}
