<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<%--<meta name="_csrf" content="${_csrf.token}"/>--%>
<%--<meta name="_csrf_header" content="${_csrf.headerName}"/>--%>

<body>
<div class="container">
    <%--<form class="form-signin" method="post" action="/login">--%>
        <%--<h2 class="form-signin-heading">sign in.</h2>--%>
        <%--<p>--%>
            <%--<label for="username" class="sr-only">Username</label>--%>
            <%--<input type="text" id="username" name="username" class="form-control" placeholder="Username" required="" autofocus="">--%>
        <%--</p>--%>
        <%--<p>--%>
            <%--<label for="password" class="sr-only">Password</label>--%>
            <%--<input type="password" id="password" name="password" class="form-control" placeholder="Password" required="">--%>
        <%--</p>--%>
        <%--<input name="_csrf" type="hidden" value="2357320e-04e9-4fef-b1ef-3e5aadb9a47a">--%>
        <%--<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>--%>
    <%--</form>--%>
    <form class="login-form" method="post" action="/login">
        <%--<input type ="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}"/>--%>
        <div class="row">
            <div class="input-field col s12">
                <input id="id" type="text" name="name" class="validate"/>
                <label for="id">ID</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s12">
                <input id="password" type="password" name="password" class="validate"/>
                <label for="password">Password</label>
            </div>
        </div>
        <input class="login-btn waves-effect waves-light btn" type="submit" value="login"/>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    </form>

</div>
</body>

</html>
