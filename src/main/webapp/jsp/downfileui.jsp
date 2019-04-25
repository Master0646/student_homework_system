<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	application.setAttribute("basePath", basePath);
%>
<button type="button" class="btn btn-success"
	style="margin-bottom: 10px" onclick="downall()">全部下载</button>
<span id="total"></span>
<div class="table-responsive">
	<table class="table table-hover">
		<tr>
			<td>学生学号</td>
			<td>学生姓名</td>
			<td>是否上传</td>
			<td>作业成绩</td>
			<td>上传时间</td>
			<td>文件大小</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${fileListByHoid }" var="filelist">
			<tr <c:if test="${filelist.uptime==null}">class='danger'</c:if>>
				<td><p>${filelist.osubject }</p></td>
				<td><p>${filelist.oname }</p></td>
				<td><p>${filelist.uptime==null?"未上传":"已上传" }</p></td>
				<td><p id='fraction'>学生分数：${filelist.fraction == null? 0 :filelist.fraction }</p>
					修改分数：<input name="test" type="text" /></td>
				</td>
				<td><p>
						<fmt:formatDate value="${filelist.uptime }"
							pattern="yyyy年MM月dd日 HH:mm:ss" />
					</p></td>
				<td>
					<p>
						<c:if test="${filelist.uptime!=null}">
							<fmt:formatNumber value="${(filelist.filesize)/1024 }"
								maxFractionDigits="2" />Kb
                        </c:if>
					</p>
				</td>
				<td>
					<button type="button" class="btn btn-info"
						onclick="down('${filelist.hid }')"
						<c:if test="${filelist.uptime==null}">disabled='disabled'</c:if>>下载
					</button>
					<button type="button" class="btn btn-primary"
						onclick="view('${filelist.hid }')"
						<c:if test="${filelist.uptime==null}">disabled='disabled'</c:if>>问答
					</button> <!-- onclick="changefro('${filelist.hid}')" -->
					<button type="button" class="btn btn-primary btnclick"
						data-hid="${filelist.hid}"
						<c:if test="${filelist.uptime==null}">disabled='disabled'</c:if>>修改分数
					</button>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
<script>
	
    function down(hid) {
        window.open("${basePath }downFile?hid=" + hid, "_blank");
    }

    function downall() {
        window.open("${basePath }downAllFile", "_blank");
    }
    
    function view(hid) {
		window.open("${basePath }questAndReplyTeacher?hid=" + hid, "_blank");
	}
    
    $('.btnclick').click(function(){
    	var that=$(this);
    	var hid=that.data('hid');
    	var inputValue = that.parent().parent().find("input").val();
    	
    	console.log(inputValue);
    	$.get("${basePath}addTeacherScoring?fraction="
				+ inputValue  + "&hid=" + hid,
				function(data) {
					console.log(data);
					if (data == 'true') {
						that.parent().parent().find("#fraction").html('学生分数：'+ inputValue);
						alert("修改分数成功");
					} else {
						alert("系统错误");
					}
				}
    	);
    });
    
    /* function changefro(hid) {
		var value = true;
		var inputValue = this.parent().parent().find("input").val();
		console.log(inputValue);
		$.get("${basePath}addTeacherScoring?fraction="
				+ $("input[name='username']").val() + "&hid=" + hid,
				function(data) {
					console.log(data);
					if (data == 'true') {
						alert("增加成功");
					} else {
						alert("系统错误");
					}
				});
	}
     */
    
    $(function () {
        var data = [];
        <c:forEach items="${fileListByHoid }" var="file">
        data.push(${file.filesize});
        </c:forEach>
        var reduce = data.reduce(function (previousValue, currentValue) {
            return previousValue + currentValue;
        });
        console.log(parseInt(reduce) / 1024 / 1024);
        document.getElementById('total').innerText = (parseInt(reduce) / 1024 / 1024).toFixed(2) + 'MB';
    });
</script>