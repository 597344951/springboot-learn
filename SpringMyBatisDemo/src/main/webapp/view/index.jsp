<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
    String path = request.getContextPath();
    String basePath =
            request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
<base href="<%=basePath%>">
    <!-- 引入样式 -->
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">

    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">

    <script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.js"></script>
    <!-- 先引入 Vue -->
    <script src="https://unpkg.com/vue/dist/vue.js"></script>
    <!-- 引入组件库 -->
    <script src="https://unpkg.com/element-ui/lib/index.js"></script>
    <%@include file="../include/head.jsp" %>
</head>
<body>
	<shiro:guest>
    欢迎游客访问，<a href="${pageContext.request.contextPath}/shiro_example/login/login.jsp">点击登录</a>
		<br />
	</shiro:guest>
	<shiro:user>
    欢迎[<shiro:principal />]登录，
<shiro:hasRole name="admin">  
    用户[<shiro:principal />]拥有角色admin<br />
		</shiro:hasRole>

		<a href="${pageContext.request.contextPath}/logout">点击退出</a>
		<br />
	</shiro:user>

	<table class="table table-bordered">
		<caption> 用户[<shiro:principal/>]角色权限状况</caption>
		<thead>
			<tr>
				<th>admin角色</th>
				<th>org:add</th>
				<th>org:update</th>
				<th>org:delete</th>
				<th>org:list</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>
					<shiro:hasRole name="admin">  
    					拥有角色admin<br />
					</shiro:hasRole>
				</td>
				<td>
					<shiro:hasPermission name="org:add">  
					   拥有权限org:add<br/>  
					</shiro:hasPermission> 
					<a href="permission/org_add" target="_blank">测试</a>  
					<a onclick="testAjax('org_add')">ajax</a>
				</td>
				<td>
					<shiro:hasPermission name="org:update">  
					   拥有权限org:update<br/>  
					</shiro:hasPermission>   
					<a href="permission/org_update" target="_blank">测试</a>
					<a onclick="testAjax('org_update')">ajax</a>
				</td>
				<td>
					<shiro:hasPermission name="org:delete">  
					   拥有权限org:delete<br/>  
					</shiro:hasPermission>   
					<a href="permission/org_delete" target="_blank">测试</a>
					<a onclick="testAjax('org_delete')">ajax</a>
				</td>
				<td>
					<shiro:hasPermission name="org:list">  
					   拥有权限org:list<br/>  
					</shiro:hasPermission>   
					<a href="permission/org_list" target="_blank">测试</a>
					<a onclick="testAjax('org_list')">ajax</a>
				</td>
			</tr>
		</tbody>

	</table>
</body>
<script type="text/javascript">

function testAjax(url){
	jQuery.ajax( {
		url : 'permission/'+url,
		method : 'get',
		data : '',
		dataType : 'json',
		async : true,
		success : function(res) {
			console.log(res);
		}
	});
}

</script>
</html>