package org.candoo.postchi.controller;

import org.quartz.impl.StdScheduler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: ehsan
 * Date: 6/21/13
 * Time: 11:35 AM
 * To change this template use File | Settings | File Templates.
 */
public class MainServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    //public static ApplicationContext context;
    //public static StdScheduler stdScheduler;

    @Override
    public void init(ServletConfig config) throws ServletException {

        //context = new ClassPathXmlApplicationContext("org/candoo/postchi/model/applicationContext.xml");
        //stdScheduler = (StdScheduler) context.getBean("queueSchedulerFactoryBean");
        super.init(config);
    }

    @Override
    public void destroy() {
        System.out.println("Shutdown System ---> Scheduler Turnoff");
        //stdScheduler.shutdown(false);
        super.destroy();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }
}
