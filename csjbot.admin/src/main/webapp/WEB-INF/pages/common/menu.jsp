<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<script src="${path }/scripts/main/menu.js" ></script>
<a class="menu-toggler" id="menu-toggler" href="#"> <span
	class="menu-text"></span>
</a>
<div class="sidebar sidebar-fixed" id="sidebar">
    <div class="sidebar-shortcuts" id="sidebar-shortcuts">
        <div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
            <button class="btn btn-success" title="敬请期待">
                <i class="icon-dashboard"></i>
            </button>
            <button class="btn btn-info" title="敬请期待">
                <i class="icon-flag"></i>
            </button>
            <button class="btn btn-warning" title="敬请期待">
                <i class="icon-book"></i>
            </button>
            <button class="btn btn-danger" title="敬请期待">
                <i class="icon-cog"></i>
            </button>
        </div>
        <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
			<span class="btn btn-success"></span>
			<span class="btn btn-info"></span>
			<span class="btn btn-warning"></span>
			<span class="btn btn-danger"></span>
		</div>
    </div>
    <!--  menu  -->
	<ul class="nav nav-list">
		<li id="tms">
		    <a href="#" class="dropdown-toggle"> 
		        <i class="icon-list"></i><span class="menu-text"> 机器人管理 </span> 
				<b class="arrow icon-angle-down"></b>
		    </a>

			<ul class="submenu">
				<li id="tms_view">
				    <a href="javascript:void(0);">
				    	<i class="icon-double-angle-right"></i> 版本上传
				    </a>
				</li>
				<li id="tms_list">
				    <a href="javascript:void(0);">
				    	<i class="icon-double-angle-right"></i> 机器人清单
				    </a>
				</li>
			</ul>
		</li>
		<li id="sys">
		    <a href="#" class="dropdown-toggle"> 
		        <i class="icon-cogs"></i><span class="menu-text"> 系统配置 </span> 
		        <b class="arrow icon-angle-down"></b>
		    </a>

			<ul class="submenu">
				<li id="sys_admin">
				    <a href="${path}/sys/admin/list"  > 
				        <i class="icon-double-angle-right"></i> 系统管理员
				    </a>
				</li>
				<li id="sys_permission">
				    <a href="${path}/role/list"  > 
				        <i class="icon-double-angle-right"></i> 角色权限管理
				    </a>
				</li>
				<li id="sys_dictionary">
				    <a href="${path}/dic/list"  > 
				        <i class="icon-double-angle-right"></i> 字典信息
				    </a>
				</li>
			</ul>
		</li>
	</ul>
	<!-- /.nav-list -->

	<div class="sidebar-collapse" id="sidebar-collapse">
		<i id="sidebararrow" class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
	</div>
	
</div>
