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
    <script src="${path}/scripts/cms/customer_update.js"></script>
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
                        <li class="active">迎宾机器人</li>
                        <li><a href="${path}/cms/list">商户信息管理</a></li>
                        <c:if test="${editable == 1 }"><li class="active">商户编辑</li></c:if>
                        <c:if test="${editable == 0 }"><li class="active">商户详情</li></c:if>
                    </ul><!-- .breadcrumb -->
                </div>
            
                <div class="page-content" style="height: 550px;">
                    <div style="height: 40px;"></div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<table style="width: 99%;">
								<tr>
									<td style="width: 4%;text-align: left;">
									   <a class="btn btn-primary" type="button" href="${path}/cms/list">返回</a></td>
									<td class="panel-title" style="width: 96%;text-align: center;font-weight:bold">
										<c:if test="${editable == 1 }">商户编辑</c:if>
										<c:if test="${editable == 0 }">商户详情</c:if>
									</td>
								</tr>
							</table>
						</div>
						<div class="panel-body">
							<div class="row">
								<form id="customer_form" class="form">
									<div class="row">
										<div class="col-md-12">
											<div class="col-md-6">
												<div class="form-group">
													<div class="input-group">
														<div class="input-group-addon">商户名</div>
														<input class="form-control" type="text" id="customer" name="customer" maxlength="10" value="${customer.customer}" placeholder="请输入商户名" <c:if test="${editable == 0 }">readonly</c:if>/>
														<input type="text" id="id" name="id" value="${customer.customer}" hidden="hidden">
														<input type="text" id="code" name="code" value="${customer.code}" hidden="hidden">
														<input type="text" id="code_group" name="code_group" value="${customer.code_group}" hidden="hidden">
													</div>
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<div class="input-group">
														<div class="input-group-addon">值</div>
                                              		    <input  class="form-control" type="text" id="value" name="value"  maxlength="50" value="${customer.value}" placeholder="请输入值" <c:if test="${editable == 0 }">readonly</c:if>/> 
													</div>
												</div>
											</div>
									<div class="row">
										<div class="col-md-12">
											<div class="col-md-12">
												<div class="form-group">
													<div class="input-group">
														<div class="input-group-addon">备注</div>
														<textArea class="form-control" id="remark" name="remark" maxlength="50" value="${customer.remark}" style="resize:none" rows="4"placeholder="请输入标记" <c:if test="${editable == 0 }">readonly</c:if>>${customer.remark}</textArea>
													</div>
												</div>
											</div>
										</div>
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