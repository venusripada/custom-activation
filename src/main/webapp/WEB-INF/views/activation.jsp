<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html lang="en" >
    <head>
        <meta charset="UTF-8">
        <title>Activate User</title>
        <c:set var="context" value="${pageContext.request.contextPath}" />

        <link rel="stylesheet" href="${context}/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
        <link rel="stylesheet" href="${context}/style.css">
        <script> let appPayload = ${response} </script>
    </head>
    <body>

        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3">
                    <form class="form-horizontal mar-top-bot-50" id="validateForm" method="post" action="${context}/createUser">
                        <h1>Choose Password</h1>
                        <fieldset>
                            <!-- Password input-->
                            <div class="form-group">
                                <label class="col-md-12 control-label" for="passwordinput">Password <span id="popover-password-top" class="hide pull-right block-help"><i class="fa fa-info-circle text-danger" aria-hidden="true"></i> Enter a strong password</span></label>
                                <div class="col-md-12">
                                    <input id="password" name="password" type="password" placeholder="" class="form-control input-md" data-placement="bottom" data-toggle="popover" data-container="body" type="button" data-html="true">
                                    <div id="popover-password">
                                        <p>Password Strength: <span id="result"> </span></p>
                                        <div class="progress">
                                            <div id="password-strength" class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width:0%">
                                            </div>
                                        </div>
                                        <ul class="list-unstyled">
                                            <li class=""><span class="low-upper-case"><i class="fa fa-times" aria-hidden="true"></i></span>&nbsp; 1 lowercase &amp; 1 uppercase</li>
                                            <li class=""><span class="one-number"><i class="fa fa-times" aria-hidden="true"></i></span> &nbsp;1 number (0-9)</li>
                                            <li class=""><span class="one-special-char"><i class="fa fa-times" aria-hidden="true"></i></span> &nbsp;1 Special Character (!@#$%^&*).</li>
                                            <li class=""><span class="eight-character"><i class="fa fa-times" aria-hidden="true"></i></span>&nbsp; Atleast 8 Character</li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <!-- Repeat Password -->
                            <div class="form-group">
                                <label class="col-md-12 control-label" for="passwordinput">Password Confirmation <span id="popover-cpassword" class="hide pull-right block-help"><i class="fa fa-info-circle text-danger" aria-hidden="true"></i> Password don't match</span></label>
                                <div class="col-md-12">
                                    <input id="confirm-password" name="confirm-password" type="password" placeholder="" class="form-control input-md">
                                </div>
                            </div>
                        </fieldset>
                        <h1>Choose recovery Question and Answer</h1>
                        <fieldset>
                            <!-- Password input-->
                            <div class="form-group">
                                <label class="col-md-12 control-label" for="securityQuestion">Recovery Question </label>
                                <div class="col-md-12">
                                    <input id="security-question" name="securityQuestion" placeholder="" class="form-control input-md" >
                                   
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <label class="col-md-12 control-label" for="securityQuestionAnswer">Recovery Answer </label>
                                <div class="col-md-12">
                                    <input id="security-answer" name="securityQuestionAnswer"  placeholder="" class="form-control input-md">
                                </div>
                            </div>
                             <input id="stateToken" type="hidden" name="stateToken" value="${token}"  placeholder="" class="form-control input-md">
                             <button type="submit" id="submit" class="btn btn-primary">Create Account</button>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>


        <script src="${context}/webjars/jquery/1.11.1/jquery.min.js"></script>
        <script src="${context}/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>

    </script><script  src="${context}/application.js"></script>

</body>
</html>