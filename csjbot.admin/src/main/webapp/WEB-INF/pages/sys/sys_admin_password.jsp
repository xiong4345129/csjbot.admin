<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
import="java.text.SimpleDateFormat"
%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%  
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    Date date = new Date();    
%>
<!DOCTYPE HTML>
<html>
<head>
    <jsp:include page="../common/meta.jsp" />
    <jsp:include page="../common/resources.jsp" />
    <script src="${path }/scripts/sys/sys_admin_password.js" ></script>
    <script type="text/javascript">
        $(function(){
            $("#sys_admin").addClass("active");
            $("#sys").addClass("open");
            $("#sys").addClass("active");
        });
    </script>
</head>
  
<body class="navbar-fixed">
    <jsp:include page="../common/header.jsp" />
    <div class="main-container">
        <div class="main-container-inner">  
            <jsp:include page="../common/menu.jsp" />
            
            <div class="main-content" id="mainContent">
                <div class="breadcrumbs breadcrumbs-fixed" id="breadcrumbs">
            
                    <ul class="breadcrumb">
                        <li>
                            <i class="icon-home home-icon"></i>
                            <a href="${path}/">首页</a>
                        </li>
                        <li class="active">系统配置</li>
                        <li><a href="${path}/sys/admin/list">系统管理员</a></li>
                        <li class="active">系统管理员改密</li>
                    </ul><!-- .breadcrumb -->
                </div>
            
                <div class="page-content">
                    <div style="height: 40px;"></div>
                    <div class="panel panel-default">
			            <div class="panel-heading">
			                <table style="width: 99%;">
			                    <tr>
			                           <td style="width: 4%;text-align: left;" nowrap="nowrap" >
			                            <a  class="btn btn-primary" type="button" href="${path }/sys/admin/list" >返回</a></td>
			                            <td class="panel-title" style="width: 96%;text-align: center;font-weight:bold">系统管理员改密</td>
			                       </tr>
			               </table>
			            </div>
			            <div class="panel-body">
			            
			            <div class="row">
			            <input type="hidden" id="id" name="id"  value="${user.id}" readonly>
			            <form  id="password_edit_form" class="form" role ="form">
			            <div class="row">
			                <div class="col-md-12">
			                    <!-- 账号 -->
			                    <div class="col-md-6">
			                        <div class="form-group">
			                            <div class="input-group">
			                                <div class="input-group-addon">&nbsp;账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号&nbsp;</div>
			                                <input class="form-control" type="text" id="username" name="username"  value="${user.username}" disabled="disabled">                               
			                            </div>
			                        </div>
			                    </div>
			                    
			                </div>                  
			            </div>
			            <div class="row">
			                <div class="col-md-12">
			                    <!-- 姓名 -->
			                    <div class="col-md-6">
			                        <div class="form-group">
			                            <div class="input-group">
			                                <div class="input-group-addon">&nbsp;姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名&nbsp;</div>
			                                <input class="form-control" type="text" id="realname" name="realname"  value="${user.realname}" disabled="disabled" >                              
			                            </div>
			                        </div>
			                    </div>
			                </div>                  
			            </div>
			            <div class="row">
			                <div class="col-md-12">
			                    <!-- 登录密码 -->
			                    <div class="col-md-6">
			                        <div class="form-group">
			                            <div class="input-group">
			                                <div class="input-group-addon">&nbsp;新&nbsp;密&nbsp;码&nbsp;</div>
			                                <input class="form-control" type="password" id="password" name="password" placeholder="5-15位，支持字母、数字和符号，字母区分大小写">                              
			                            </div>
			                        </div>
			                    </div>
			                    
			                </div>                  
			            </div>
			            <div class="row">
			                <div class="col-md-12">
			                    <!-- 确认密码-->
			                    <div class="col-md-6">
			                        <div class="form-group">
			                            <div class="input-group">
			                                <div class="input-group-addon">确认密码</div>
			                                <input class="form-control" type="password" id="confirmPassword" name="confirmPassword"  placeholder="请再输一次刚输入的登录密码，确保两次输入一致">                             
			                            </div>
			                        </div>
			                    </div>
			                </div>                  
			            </div>
			             <div class="text-center">
			                <button type="button" class="btn btn-primary" id="changePassword">保存修改 </button>
			            </div>
			              </form>
			            </div>             
			         </div>    
			        </div>
                    
                </div><!-- /.page-content -->
            </div><!-- /.main-content -->
            
        </div>
        
    </div><!-- /.main-container-inner -->
    
    <jsp:include page="../common/footer.jsp" />
</body>
</html>