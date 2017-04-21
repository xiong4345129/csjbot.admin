<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML>
<html>
<head>
    <jsp:include page="../common/meta.jsp" />
    <jsp:include page="../common/resources.jsp" />
    <script src="${path}/scripts/scs/dishType_update.js"></script>
    <script src="${path}/scripts/common/preview.js"></script>
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
                        <li class="active">送餐机器人</li>
                        <li><a href="${path}/dte/list">菜品类型管理</a></li>
                        <c:if test="${editable == 1 }"><li class="active">菜品类型编辑</li></c:if>
                        <c:if test="${editable == 0 }"><li class="active">菜品类型详情</li></c:if>
                    </ul><!-- .breadcrumb -->
                </div>
            
                <div class="page-content" style="height: 550px;">
                    <div style="height: 40px;"></div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<table style="width: 99%;">
								<tr>
									<td style="width: 4%;text-align: left;">
									   <a class="btn btn-primary" type="button" href="${path}/dte/list">返回</a></td>
									<td class="panel-title" style="width: 96%;text-align: center;font-weight:bold">
										<c:if test="${editable == 1 }">菜品类型编辑</c:if>
										<c:if test="${editable == 0 }">菜品类型详情</c:if>
									</td>
								</tr>
							</table>
						</div>
						<div class="panel-body">
							<div class="row">
								<form id="dishType_form" class="form">
									<div class="row">
										<div class="col-md-12">
											<div class="col-md-6">
												<div class="form-group">
													<div class="input-group">
														<div class="input-group-addon">菜品类型名称</div>
														<input class="form-control" type="text" id="type_name" name="type_name" maxlength="25" value="${dish_type.type_name}" placeholder="请输入菜品类型名称" <c:if test="${editable == 0 }">readonly</c:if>/>
														<input type="text" id="id" name="id" value="${dish_type.id}" hidden="hidden">
													</div>
												</div>
											</div>
											<div class="col-md-6">
												
											</div>
										</div>
									</div>
									
									<c:if test="${editable == 1 }">
										<div class="text-center">
	                                        <button type="button" class="btn btn-primary" id="submit">提交</button>
	                                    </div>
                                    </c:if>
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
