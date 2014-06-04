package org.candoo.postchi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: ehsan
 * Date: 7/24/13
 * Time: 11:56 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class MainController {


    @Autowired
    ServletContext context;

    public MainController() {
    }

    /*@RequestMapping(value = "/login", method = RequestMethod.POST)
    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    public String Login(HttpServletRequest request) {
        String loginUsername = context.getInitParameter("loginUsername");
        String loginPassword = context.getInitParameter("loginPassword");
        /*//**
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username != null && password != null) {
            if (username.equals(loginUsername) && password.equals(loginPassword)) {
                request.getSession().setAttribute("logined", "true");
                return "redirect:/index";
            } else {
                return "account/login";
            }
        } else {
            return "account/login";
        }
    }*/

    /*@RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String Logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "account/login";
    }*/

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @Secured("ROLE_ADMIN")
    public ModelAndView Index() {

        ModelAndView modelAndView = new ModelAndView("index");


        return modelAndView;
    }

    @RequestMapping(value = "/index1", method = RequestMethod.GET)
    @Secured("ROLE_USER")
    public ModelAndView Index1() {

        ModelAndView modelAndView = new ModelAndView("index1");
        return modelAndView;
    }

    
}
