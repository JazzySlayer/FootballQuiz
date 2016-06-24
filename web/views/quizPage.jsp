<%--
  Created by IntelliJ IDEA.
  User: sugurung
  Date: 6/21/2016
  Time: 2:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/quizpage.css">
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />

</head>
<body>
<div class="container">
    <div class="page-header">
        <h1>Football Quiz</h1>
    </div>
    <div class="jumbotron">
        <div class="container">
            <div class="row">
                <div class="alert alert-success" role="alert">
                    ${question}
                </div>
                <div class="col-md-5">
                    <button type="button" class="btn btn-default test">${answer1}</button>
                </div>
                <div class="col-md-2"></div>
                <div class="col-md-5">
                    <button type="button" class="btn btn-default test">${answer2}</button>
                </div>
                <div class="col-md-5">
                    <button type="button" class="btn btn-default test">${answer3}</button>
                </div>
                <div class="col-md-2"></div>
                <div class="col-md-5">
                    <button type="button" class="btn btn-default test">${answer4}</button>
                </div>
                <input type="hidden" name="randNum" value="${randNum}">
                <input type="hidden" name="correct" value="${correct}">
            </div>
        </div>

    </div>
</div>
</div>
</body>
</html>

