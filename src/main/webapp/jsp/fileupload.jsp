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
<title>学生作业管理系统-主页</title>
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

.isnavfa {
	position: relative
}

.isNav {
	position: absolute;
	left: 0;
	bottom: -600px;
	width: 124px;
	height: 600px;
	border: 1px solid #dcdcdc;
	display: -moz-box;
	display: -ms-flexbox;
	display: -webkit-flex;
	display: -webkit-box;
	display: flex;
	-webkit-box-orient: vertical;
	-webkit-box-direction: normal;
	-moz-box-orient: vertical;
	-moz-box-direction: normal;
	-webkit-flex-direction: column;
	flex-direction: column;
	background-color: #dcdcdc;
}

.isNav span {
	display: block;
	width: 100%;
	height: 55px;
	color: #000;
	text-align: center;
	font-size: 15px;
	line-height: 55px;
	color: #ffffff;
}

.isNav .item:hover {
	background: darkcyan;
}

.nav {
	background-color: #928C8B;
}

.container1 {
	width: 1000px;
	margin: 0 auto;
	padding: 35px;
}
</style>
</head>
<body>

	<!--头部-->
	<header class="isnavfa">
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
						<c:if test="${not empty notHandList}">
							<p>
								你的
								<c:forEach items="${notHandList }" var="item">
									${item}、
								</c:forEach>
								科目作业还没有全部提交。
							</p>
						</c:if>
					</div>
					<div class="collapse navbar-collapse navbar-right" id="bs-collapse">
						<span><a href="${basePath }logout" class="btn btn-danger">退出登录</a></span>
						<span><a href="${basePath }cpasswd" class="btn btn-primary">修改密码</a></span>
					</div>
				</div>
			</div>
		</nav>
		<div id="isNav" class="isNav">
			<span><strong>导航栏</strong></span> <span class="item" id="chooseFile"><strong>选择文件</strong></span>
			<span class="item" id="history"><strong>历史文件</strong></span> <span
				class="item"> <a href="${basePath }cpasswd"><font
					color="white"><strong>修改密码</strong></font></a>
			</span> <span class="item"> <a href="${basePath }logout"><font
					color="white"><strong>退出登录</strong></font></a></span>

		</div>

	</header>
	<!--/头部-->
	<!--内容-->

	<section>

		<div class="container1" id="ischooseFile">
			<form action="" method="post" enctype="multipart/form-data">
				<div>
					<h1>请选择文件归类</h1>
					<label for="subject_ID"> <select name="subject"
						id="subject_ID" class="form-control">
							<option value="none">请选择科目...</option>
							<c:forEach items="${orderInfoList }" var="orderInfo">
								<option value="${orderInfo }">${orderInfo }</option>
							</c:forEach>
					</select>
					</label> <label for="oid_id"> <select name="oid" id="oid_id"
						class="form-control">
							<option value="none">请选择次序...</option>
					</select>
					</label>
					<p id="des"></p>
				</div>
				<div>
					<hr>
					<div class="alert alert-danger alert-dismissible fade in hidden"
						role="alert" id="alert_id">
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<strong>与服务器交互数据失败！</strong> 请检查网络连接并重新选择文件归类！
					</div>
					<button type="button" id="upfilebutton_id" disabled="disabled"
						class="btn btn-primary" data-toggle="modal"
						data-remote="${basePath }jsp/upfileui.jsp"
						data-target=".bs-modal-lg">开始上传文件</button>
					<div class="modal fade bs-modal-lg" tabindex="-1" role="dialog"
						aria-labelledby="myLargeModalLabel">
						<div class="modal-dialog modal-lg">
							<div class="modal-content"></div>
						</div>
					</div>
				</div>
			</form>
			<p></p>


		</div>
	</section>
	<!--/内容-->

	<!--历史-->
	<section style="display: none" id="ishistory">
		<div class="container1">
			<hr>
			<div class="history">
				<p>上传文件历史记录</p>
				<div class="alert alert-dismissible fade in hidden" role="alert"
					id="alert_success">
					<button type="button" class="close" id="closealert_successdel"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<strong id="del_message"></strong>
				</div>

				<div class="alert alert-danger alert-dismissible fade in hidden"
					role="alert" id="delalert_id">
					<h4 class="glyphicon glyphicon-warning-sign">确定删除吗？</h4>
					<p>注意：该操作不可逆！</p>
					<p>
						<button type="button" class="btn btn-danger" id="delalert_true">确定删除</button>
						<button type="button" class="btn btn-default" id="delalert_cancel">取消</button>
					</p>
				</div>

				<div class="table-responsive">
					<table class="table table-hover">
						<tr>
							<td>科目</td>
							<td>次序</td>
							<td>文件类型</td>
							<td>分数</td>
							<td>上传时间</td>
							<td>文件大小</td>
							<td>操作</td>
						</tr>
						<c:forEach items="${userHistoryList}" var="userHistory">
							<tr id="${userHistory.hid }">
								<td><p>${userHistory.osubject}</p></td>
								<td><p>${userHistory.oname}</p></td>
								<td><p>${userHistory.filepath}</p></td>
								<td><p>${userHistory.fraction}</p></td>
								<td><p>
										<fmt:formatDate value="${userHistory.uptime }"
											pattern="yyyy年MM月dd日 HH:mm:ss" />
									</p></td>
								<td><p>
										<fmt:formatNumber value="${(userHistory.filesize)/1024 }"
											maxFractionDigits="2" />
									</p></td>
								<td>
									<button type="button" class="btn btn-danger"
										onclick="del_button('${userHistory.hid }')">删除</button>
									<button type="button" class="btn btn-primary"
										onclick="down_button('${userHistory.hid }')">下载</button>
									<button type="button" class="btn btn-success"
										onclick="view_button('${userHistory.hid }')">问答</button>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</section>
	<!--/历史-->

	<!--脚注-->
	<footer>
		<div class="container">
			<hr>
		</div>
	</footer>
	<!--/脚注-->

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="${basePath }weblib/jquery/jquery-3.2.1.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="${basePath }weblib/bootstrap/js/bootstrap.min.js"></script>
	<script src="${basePath }js/base.js"></script>
	<script>
		$("#chooseFile").click(function() {

			$('#ischooseFile').show();
			$('#ishistory').hide();

		});

		$("#history").click(function() {

			$('#ischooseFile').hide();
			$('#ishistory').show();
		});

		var hid = "";
		var a = '';
		function del_button(hids) {
			$("#delalert_id").removeClass("hidden");
			hid = hids;
		}

		function down_button(hid) {
			window.open("${basePath }downFile?hid=" + hid, "_blank");
		}

		function view_button(hid) {
			window.open("${basePath }questAndReply?hid=" + hid, "_blank");
		}
		$(function() {
			var file_subject = "";
			var file_oid = "";
			$("#subject_ID").change(
					function() {
						file_subject = $(this).val();
						$.get("${basePath }getOnameBysubject?subject="
								+ file_subject, function(data) {
							//	$("#oid_id").empty();
							$("#upfilebutton_id").removeAttr("disabled");
							$.each(data, function(key, value) {
								if (key === 0) {
									file_oid = value.oid;
								}
								$("#oid_id").append(
										"<option value=" + value.oid + ">"
												+ value.oname + "</option>");
							});
						});
					});
			$("#oid_id").change(function() {
				file_oid = $(this).val();
			});

			$("#oid_id").change(
					function() {
						file_oid = $(this).val();
						$.get("${basePath }getDescByOid?oid=" + file_oid,
								function(data) {
									$("#des").html(data.describtion);
									console.log(data)
								});
					});

			$("#upfilebutton_id").click(
					function() {
						$.get("${basePath }userselect?userselect_oid="
								+ file_oid, function(data) {
							if (!data) {
								$("#upfilebutton_id").attr("disabled",
										"disabled");
								$("#subject_ID").attr("disabled", "disabled");
								$("#oid_id").attr("disabled", "disabled");
								$("#alert_id").removeClass("hidden");
								$(".bs-modal-lg").modal('hide');
							}
						});
					});
			$("#alert_id").on('closed.bs.alert', function() {
				window.location.reload();
			});
			$("#delalert_true").click(
					function() {
						$("#delalert_id").addClass("hidden");
						$.get("${basePath }delEntityByHID?delHid=" + hid,
								function(data) {
									if (data) {
										$("#alert_success").removeClass(
												"alert-danger");
										$("#alert_success").addClass(
												"alert-success");
										$("#alert_success").removeClass(
												"hidden");
										$("#" + hid).remove();
										$("#del_message").text("文件已经成功删除！");
									} else {
										$("#alert_success").removeClass(
												"alert-success");
										$("#alert_success").addClass(
												"alert-danger");
										$("#alert_success").removeClass(
												"hidden");
										$("#del_message").text(
												"文件删除失败！请检查网络连接！");
									}
								});
					});
			$("#delalert_cancel").click(function() {
				$("#delalert_id").addClass("hidden");
			});
			$("#closealert_successdel").click(function() {
				$("#alert_success").addClass("hidden");
			});
		});
	</script>
</body>
</html>