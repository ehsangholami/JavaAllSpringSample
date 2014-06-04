<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="req" value="${pageContext.request}"/>
<c:set var="baseURL" value="${req.scheme}://${req.serverName}:${req.serverPort}${req.contextPath}"/>

<!DOCTYPE html>

<!-- Mirrored from themepixels.com/main/themes/demo/webpage/katniss/login.jsp by HTTrack Website Copier/3.x [XR&CO'2010], Sat, 08 Jun 2013 08:12:22 GMT -->

<!-- Mirrored from barforosh.ir/login/ by HTTrack Website Copier/3.x [XR&CO'2010], Sun, 09 Jun 2013 11:19:06 GMT -->
<!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=UTF-8"><!-- /Added by HTTrack -->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>سامانه پیام کوتاه فرهنگ و توسعه کندو</title>
    <link rel="stylesheet" href="${baseURL}/assets/login/css/style.default.css" type="text/css"/>
    <script type="text/javascript" src="${baseURL}/assets/login/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="${baseURL}/assets/login/js/jquery-migrate-1.1.1.min.js"></script>
</head>

<body class="loginbody">

<div class="loginwrapper">
    <div class="loginwrap zindex100 animate2 bounceInDown">
        <div class="logo"></div>
        <h1 class="logintitle"><span class="iconfa-lock"></span> سامانه پیام کوتاه کندو <span class="subtitle">فرهنگ و توسعه کندو</span>
        </h1>

        <div class="loginwrapperinner">
            <form id="loginform" action="/login" method="post">
                <p class="animate4 bounceIn"><input type="text" id="username" name="username" placeholder="نام کاربری"/>
                </p>

                <p class="animate5 bounceIn"><input type="password" id="password" name="password"
                                                    placeholder="کلمه عبور"/></p>

                <p class="animate6 bounceIn">
                    <button class="btn btn-default btn-block">ورود به سامانه</button>
                </p>
                <p class="animate7 fadeIn"><a href="#"><span class="icon-question-sign icon-white"></span> بازیابی کلمه
                    عبور</a></p>
            </form>
        </div>
        <!--loginwrapperinner-->
    </div>
    <div class="loginshadow animate3 fadeInUp"></div>
</div>
<!--loginwrapper-->

<script type="text/javascript">
    jQuery.noConflict();

    jQuery(document).ready(function () {

        var anievent = (jQuery.browser.webkit) ? 'webkitAnimationEnd' : 'animationend';
        jQuery('.loginwrap').bind(anievent, function () {
            jQuery(this).removeClass('animate2 bounceInDown');
        });

        jQuery('#username,#password').focus(function () {
            if (jQuery(this).hasClass('error')) jQuery(this).removeClass('error');
        });

        jQuery('#loginform button').click(function () {
            if (!jQuery.browser.msie) {
                if (jQuery('#username').val() == '' || jQuery('#password').val() == '') {
                    if (jQuery('#username').val() == '') jQuery('#username').addClass('error'); else jQuery('#username').removeClass('error');
                    if (jQuery('#password').val() == '') jQuery('#password').addClass('error'); else jQuery('#password').removeClass('error');
                    jQuery('.loginwrap').addClass('animate0 wobble').bind(anievent, function () {
                        jQuery(this).removeClass('animate0 wobble');
                    });
                } else {
                    jQuery('.loginwrapper').addClass('animate0 fadeOutUp').bind(anievent, function () {
                        jQuery('#loginform').submit();
                    });
                }
                return false;
            }
        });
    });
</script>
</body>

<!-- Mirrored from themepixels.com/main/themes/demo/webpage/katniss/login.jsp by HTTrack Website Copier/3.x [XR&CO'2010], Sat, 08 Jun 2013 08:12:25 GMT -->

<!-- Mirrored from barforosh.ir/login/ by HTTrack Website Copier/3.x [XR&CO'2010], Sun, 09 Jun 2013 11:19:08 GMT -->
<!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=UTF-8"><!-- /Added by HTTrack -->
</html>
