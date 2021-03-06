<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<s:if test="%{#session.USERDETAILS == null}">

    <div class="login" id="login">
        <div class="slide-button" id="login-button">
            <i class="icon ion-ios-arrow-back"></i>
            Login
        </div>
        <div class="login-form">
            <form action="login" method="POST">
                <label>Email:</label><br>
                <input type="text" name="email" value="">
                <label>Password:</label><br>
                <input type="password" name="password" value="">
                <button type="submit" class="btn btn-primary">Login</button>
                <a href="register" class="btn btn-success">Register</a>
            </form>
            <a href="resetPassword.jsp" class="forget-password">Forget password</a>
        </div>
    </div>

    <script type="text/javascript">
        $('#login-button').click(function() {
            if($(this).css("margin-right") === "225px") {
                $('#login').animate({"margin-right": '-=225'}, 300);
                $('#login-button').animate({"margin-right": '-=225'}, 300);
                $('#login-button>i').addClass('ion-ios-arrow-back');
                $('#login-button>i').removeClass('ion-ios-arrow-forward');
            } else {
                $('#login').animate({"margin-right": '+=225'}, 300);
                $('#login-button').animate({"margin-right": '+=225'}, 300);
                $('#login-button>i').removeClass('ion-ios-arrow-back');
                $('#login-button>i').addClass('ion-ios-arrow-forward');
            }
        });
    </script>

</s:if>