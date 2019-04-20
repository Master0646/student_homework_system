<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<%@ page isELIgnored="false"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	application.setAttribute("basePath", basePath);
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>作业管理系统-问答界面</title>
<link rel="shortcut icon" href="${basePath }img/favicon.ico" />
<link rel="bookmark" href="${basePath }img/favicon.ico" />
<link href="${basePath }weblib/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="${basePath }css/base.css">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<style>
.userinfo {
	line-height: 48px;
}

.userinfo img {
	margin-right: 10px;
}

#bs-collapse {
	line-height: 48px;
}

tr>td>p {
	margin-top: 8px;
	margin-bottom: 8px;
}
</style>
</head>
<body>
	<!--头部-->
	<header>
		<nav class="navbar navbar-default">
			<div class="container">
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse" data-target="#bs-collapse"
							aria-expanded="false">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<div class="userinfo">
							<img src="${basePath }img/headdefault.jpg" alt="headImg"
								class="img-circle" style="width: 30px"> <span>登录用户：${user.name }</span>
						</div>
					</div>
					<div class="collapse navbar-collapse navbar-right" id="bs-collapse">
						<span><a href="${basePath }logout" class="btn btn-danger">退出登录</a></span>
						<span><a href="${basePath }cpasswd" class="btn btn-primary">修改密码</a></span>
					</div>
				</div>
			</div>
		</nav>
	</header>
	<div class="container">
		<div class="history">
			<h3>问答记录</h3>
			<hr>
			<c:forEach items="${OrderQuestionsReplyList}" var="item">
				<strong>学生提问：</strong>
				<p>${item.statusQuestions}</p>
				<c:if test="${not empty item.teacherReply}">
					<strong>老师回答：</strong>
					<p>${item.teacherReply}</p>
				</c:if>

				<c:if
					test="${item.teacherReply eq null && not empty item.statusQuestions }">
					<textarea rows="8" cols="100" id="requestText">
					</textarea>
					<input type="hidden" id="replyId" value="${item.id}"></input>
					<br>
					<button type="button" id="teacher_reply" class="btn btn-primary"
						data-toggle="modal">提交答案</button>
				</c:if>

				<hr>
			</c:forEach>
		</div>
	</div>
	<!--历史-->
	<section>
		<!-- <div class="container">
			<div class="history">
				<h3>老师解答:</h3>
				<hr />
				<textarea rows="8" cols="100" id="requestText">
				</textarea>
				<br>
				<button type="button" id="raise_questions" class="btn btn-primary"
					data-toggle="modal">提交答案</button>
			</div>
		</div> -->
	</section>


	<script src="${basePath }weblib/jquery/jquery-3.2.1.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="${basePath }weblib/bootstrap/js/bootstrap.min.js"></script>
	<script src="${basePath }js/base.js"></script>
	<script>
		var text = document.getElementById("requestText").value;
		var replyId = document.getElementById("replyId").value;
		var hid = $
		{
			hid
		};
		$(function() {
			$("#teacher_reply").click(
					function() {
						$.get("${basePath}addTeacherReply?text="
								+ $("#requestText").val() + "&id=" + replyId,
								function(data) {
									console.log(data);
									if (data == 'true') {
										alert("增加成功");
									} else {
										alert("系统错误");
									}
								});
					});
		});
	</script>
</body>
</html>