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

    /*static Logger loggerRoot = Logger.getLogger(MainController.class);
    static Logger loggerAdpBulk = Logger.getLogger("com.candoosms.adpbulk");
    static Logger loggerAdpService = Logger.getLogger("com.candoosms.adpservice");
    static Logger loggerMagfa = Logger.getLogger("com.candoosms.magfa");
    static Logger loggerReceiveService = Logger.getLogger("com.candoosms.receiveservice");
    static Logger loggerBirthDay = Logger.getLogger("com.candoosms.birthday");
    static Logger loggerMagfaStatus = Logger.getLogger("com.candoosms.magfastatus");
    static Logger loggerAdpStatus = Logger.getLogger("com.candoosms.adpstatus");*/


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

        /*modelAndView.addObject("AdpBulk", "Started");
        modelAndView.addObject("AdpService", "Started");
        modelAndView.addObject("Magfa", "Started");
        modelAndView.addObject("ReceiveService", "Started");
        modelAndView.addObject("BirthDay", "Started");
        modelAndView.addObject("MagfaStatus", "Started");
        modelAndView.addObject("AdpStatus", "Started");*/


        return modelAndView;
    }

    @RequestMapping(value = "/index1", method = RequestMethod.GET)
    @Secured("ROLE_USER")
    public ModelAndView Index1() {

        ModelAndView modelAndView = new ModelAndView("index1");
        return modelAndView;
    }

    /*@RequestMapping(value = "/pauseAllService", method = RequestMethod.GET)
    public String PauseAllService() {

        System.out.println("------------------------> PauseAllService");
        try {
            MainServlet.stdScheduler.pauseAll();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        loggerRoot.info("PauseAll ------> PauseAllService");
        return "index";
    }

    @RequestMapping(value = "/resumeAllService", method = RequestMethod.GET)
    public String ResumeAllService() {

        System.out.println("------------------------> ResumeAllService");
        try {
            MainServlet.stdScheduler.resumeAll();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        loggerRoot.info("ResumeAll ------> ResumeAllService");
        return "index";
    }


    //------------------- AdpBulk --------------------------------------

    @RequestMapping(value = "/resumeAdpBulk", method = RequestMethod.GET)
    public
    @ResponseBody
    String StartAdpBulk() {

        System.out.println("Resume AdpBulk");
        try {
            MainServlet.stdScheduler.resumeTrigger("runAdpBulkTrigger", "runServiceTriggerGroup");
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        loggerAdpBulk.info("Resume ----------> ResumeAdpBulk");
        return "AdpBulk,Resumed";
    }

    @RequestMapping(value = "/pauseAdpBulk", method = RequestMethod.GET)
    public
    @ResponseBody
    String PauseAdpBulk() {

        System.out.println("Pause AdpBulk");
        try {
            MainServlet.stdScheduler.pauseTrigger("runAdpBulkTrigger", "runServiceTriggerGroup");
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        loggerAdpBulk.info("Pause ----------> pauseAdpBulk");
        return "AdpBulk,Paused";
    }


    @RequestMapping(value = "/viewLogAdpBulk", method = RequestMethod.GET)
    public String ViewLogAdpBulk() {
        System.out.println("------------------------> ViewLogAdpBulk");
        loggerAdpBulk.info("ViewLog ------> ViewLogAdpBulk");
        return "viewlog_adpbulk";
    }

    //------------------- AdpService --------------------------------------

    @RequestMapping(value = "/resumeAdpService", method = RequestMethod.GET)
    public
    @ResponseBody
    String StartAdpService() {

        System.out.println("Resume AdpService");
        try {
            MainServlet.stdScheduler.resumeTrigger("runAdpServiceTrigger", "runServiceTriggerGroup");
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        loggerAdpService.info("Resume ----------> ResumeAdpService");

        return "AdpService,Resumed";
    }

    @RequestMapping(value = "/pauseAdpService", method = RequestMethod.GET)
    public
    @ResponseBody
    String PauseAdpService() {

        System.out.println("Pause AdpService");
        try {
            MainServlet.stdScheduler.pauseTrigger("runAdpServiceTrigger", "runServiceTriggerGroup");
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        loggerAdpService.info("Pause ----------> pauseAdpService");
        return "AdpService,Paused";
    }

    @RequestMapping(value = "/viewLogAdpService", method = RequestMethod.GET)
    public String ViewLogAdpService() {
        System.out.println("------------------------> ViewLogAdpService");
        loggerAdpBulk.info("ViewLog ------> ViewLogAdpService");
        return "viewlog_adpservice";
    }

    //------------------- Magfa --------------------------------------

    @RequestMapping(value = "/resumeMagfa", method = RequestMethod.GET)
    public
    @ResponseBody
    String StartMagfa() {

        System.out.println("Resume Magfa");
        try {
            MainServlet.stdScheduler.resumeTrigger("runMagfaTrigger", "runServiceTriggerGroup");
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        loggerMagfa.info("Resume ----------> ResumeMagfa");
        return "Magfa,Resumed";
    }

    @RequestMapping(value = "/pauseMagfa", method = RequestMethod.GET)
    public
    @ResponseBody
    String PauseMagfa() {

        System.out.println("Pause Magfa");
        try {
            MainServlet.stdScheduler.pauseTrigger("runMagfaTrigger", "runServiceTriggerGroup");
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        loggerMagfa.info("Pause ----------> pauseMagfa");
        return "Magfa,Paused";
    }

    @RequestMapping(value = "/viewLogMagfa", method = RequestMethod.GET)
    public String ViewLogMagfa() {
        System.out.println("------------------------> ViewLogMagfa");
        loggerAdpBulk.info("ViewLog ------> ViewLogMagfa");
        return "viewlog_magfa";
    }

    //------------------- ReceiveService --------------------------------------

    @RequestMapping(value = "/resumeReceiveService", method = RequestMethod.GET)
    public
    @ResponseBody
    String StartReceiveService() {

        System.out.println("Resume ReceiveService");
        try {
            MainServlet.stdScheduler.resumeTrigger("runReceiveServiceTrigger", "runServiceTriggerGroup");
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        loggerReceiveService.info("Resume ----------> ResumeReceiveService");
        return "ReceiveService,Resumed";
    }

    @RequestMapping(value = "/pauseReceiveService", method = RequestMethod.GET)
    public
    @ResponseBody
    String PauseReceiveService() {

        System.out.println("Pause ReceiveService");
        try {
            MainServlet.stdScheduler.pauseTrigger("runReceiveServiceTrigger", "runServiceTriggerGroup");
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        loggerReceiveService.info("Pause ----------> pauseReceiveService");
        return "ReceiveService,Paused";
    }

    @RequestMapping(value = "/viewLogReceiveService", method = RequestMethod.GET)
    public String ViewLogReceiveService() {
        System.out.println("------------------------> ViewLogReceiveService");
        loggerAdpBulk.info("ViewLog ------> ViewLogReceiveService");
        return "viewlog_receiveservice";
    }

    //------------------- BirthDay --------------------------------------

    @RequestMapping(value = "/resumeBirthDay", method = RequestMethod.GET)
    public
    @ResponseBody
    String StartBirthDay() {

        System.out.println("Resume BirthDay");
        try {
            MainServlet.stdScheduler.resumeTrigger("runBirthDayTrigger", "runServiceTriggerGroup");
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        loggerBirthDay.info("Resume ----------> ResumeBirthDay");
        return "BirthDay,Resumed";
    }

    @RequestMapping(value = "/pauseBirthDay", method = RequestMethod.GET)
    public
    @ResponseBody
    String PauseBirthDay() {

        System.out.println("Pause BirthDay");
        try {
            MainServlet.stdScheduler.pauseTrigger("runBirthDayTrigger", "runServiceTriggerGroup");
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        loggerBirthDay.info("Pause ----------> pauseBirthDay");
        return "BirthDay,Paused";
    }

    @RequestMapping(value = "/viewLogBirthDay", method = RequestMethod.GET)
    public String ViewLogBirthDay() {
        System.out.println("------------------------> ViewLogBirthDay");
        loggerAdpBulk.info("ViewLog ------> ViewLogBirthDay");
        return "viewlog_birthday";
    }

    //------------------- MagfaStatus --------------------------------------

    @RequestMapping(value = "/resumeMagfaStatus", method = RequestMethod.GET)
    public
    @ResponseBody
    String StartMagfaStatus() {

        System.out.println("Resume MagfaStatus");
        try {
            MainServlet.stdScheduler.resumeTrigger("runMagfaStatusTrigger", "runServiceTriggerGroup");
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        loggerMagfaStatus.info("Resume ----------> ResumeMagfaStatus");
        return "MagfaStatus,Resumed";
    }

    @RequestMapping(value = "/pauseMagfaStatus", method = RequestMethod.GET)
    public
    @ResponseBody
    String PauseMagfaStatus() {

        System.out.println("Pause MagfaStatus");
        try {
            MainServlet.stdScheduler.pauseTrigger("runMagfaStatusTrigger", "runServiceTriggerGroup");
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        loggerBirthDay.info("Pause ----------> pauseMagfaStatus");
        return "MagfaStatus,Paused";
    }

    @RequestMapping(value = "/viewLogMagfaStatus", method = RequestMethod.GET)
    public String ViewLogMagfaStatus() {
        System.out.println("------------------------> ViewLogMagfaStatus");
        loggerAdpBulk.info("ViewLog ------> ViewLogMagfaStatus");
        return "viewlog_magfastatus";
    }

    //------------------- AdpStatus --------------------------------------

    @RequestMapping(value = "/resumeAdpStatus", method = RequestMethod.GET)
    public
    @ResponseBody
    String StartAdpStatus() {

        System.out.println("Resume AdpStatus");
        try {
            MainServlet.stdScheduler.resumeTrigger("runAdpStatusTrigger", "runServiceTriggerGroup");
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        loggerAdpStatus.info("Resume ----------> ResumeAdpStatus");
        return "AdpStatus,Resumed";
    }

    @RequestMapping(value = "/pauseAdpStatus", method = RequestMethod.GET)
    public
    @ResponseBody
    String PauseAdpStatus() {

        System.out.println("Pause MagfaStatus");
        try {
            MainServlet.stdScheduler.pauseTrigger("runAdpStatusTrigger", "runServiceTriggerGroup");
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        loggerAdpStatus.info("Pause ----------> pauseAdpStatus");
        return "AdpStatus,Paused";
    }

    @RequestMapping(value = "/viewLogAdpStatus", method = RequestMethod.GET)
    public String ViewLogAdpStatus() {
        System.out.println("------------------------> ViewLogAdpStatus");
        loggerAdpBulk.info("ViewLog ------> ViewLogAdpStatus");
        return "viewlog_adpstatus";
    }*/



    /*@RequestMapping(value = "/pauseQueue", method = RequestMethod.GET)
    public void pause() {
        System.out.println("pauseQueue");
        *//*try {
            MainServlet.stdScheduler.pauseAll();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }*//*

    }


    @RequestMapping(value = "/resumeQueue", method = RequestMethod.GET)
    public void resume() {

        *//*try {
            MainServlet.stdScheduler.resumeAll();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }*//*

    }*/

}
