/**
 * 
 */
var table = "";
var initable = "";
$(function() {

	// ----------------条件搜索-----------------------------------------------------------
	$("#searchButton").click(function() {
		table.state.clear();
		table.destroy();
		table = $("#tp").DataTable(initOptions());
	});
	$(document).keydown(function(e) {
		if (e && e.keyCode == 13) {
			$("#searchButton").click();
			return false;
		}
	});

	// ----------------重置搜索条件--------------------------------------------------------
	$('#resetButton').click(function() {
		$('#name').val('');
	});

	function initOptions() {
		var queryData = {
			name : $("#name").val()
		};
		var options = {
			processing : true,
			serverSide : true,
			ajax : {
				url : _path + "/dish/search",
				method : "POST",
				data : queryData,
				error : function(xhr, msg) {
					alert("数据加载失败！");
				}
			},
			columns : [ {
				title : "菜品id",
				data : "id",
				width : "20%"
			}, {
				title : "菜品类型",
				data : "dish_type",
				width : "10%"
			}, {
				title : "菜品名称",
				data : "name",
				width : "10%"
			}, {
				title : "价格",
				data : "price",
				width : "10%"
			}, {
				title : "备注",
				data : "memo",
				width : "20%"
			}, {
				title : "创建时间",
				data : "date_create",
				dataType : 'date_create',
				width : "15%"
			}, {
				title : "操作",
				width : "15%",
				style : "operation-column"
			} ],
			columnDefs : [ {
				targets : [ 5 ],
				render : function(data, type, row) {
					var datetime = new Date(Number(row.date_create)).Format("yyyy-MM-dd HH:mm");
					//  alert(new Date(Number(row.date_create)).Format( "yyyy-MM-dd HH:mm"));
					return datetime;
				}
			},
				{
					targets : [ 6 ],
					render : operation,
					orderable : false
				} ],
			order : [ [ 6, 'desc' ] ],
			remoteSort : true,
			pagination : true,
			paginationParam : {
				pageSize : 10,
				pagerLength : 5
			},
			emptyMsg : "查无结果"
		};
		return options;
	}
	initable = initOptions();
	table = $("#tp").DataTable(initOptions());

});

function operation(data, type, row) {
	var editor = "<a class='opt' id='detail_" + row.id + "' href=\"javascript:void(0);\" ><span>详情</span></a>&nbsp;&nbsp;"
	+ "<a class='opt' id='edit_"+row.id+"' href=\"javascript:void(0);\" ><span>编辑</span></a>&nbsp;&nbsp;"	
	+ "<a class='opt' id='delete_" + row.id + "' href=\"javascript:void(0);\" ><span>删除</span></a>&nbsp;&nbsp;"

	$(document).off("click", "#detail_" + row.id).on("click", "#detail_" + row.id, function() {
		window.location = _path + "/dish/" + row.id + "/toDishDetail";
	});
	$(document).off("click", "#edit_" + row.id).on("click", "#edit_" + row.id, function() {
		window.location = _path + "/dish/" + row.id + "/toDishUpdate";
	});
	$(document).off("click", "#delete_" + row.id).on("click", "#delete_" + row.id, function() {
		csjbotui.ui.msg.confirm({
			title : "确认删除",
			msg : "您确定要删除该菜品【" + row.name + "】?",
			ok : function() {
				$.ajax({
					type : "POST",
					url : _path + "/dish/" + row.id + "/dishDelete",
					dataType : "json",
					success : function(data) {
						if (data.msg == "S") {
							window.location.href = _path + "/dish/list";
						} else {
							csjbotui.ui.msg.alert(data.msg);
						}
					},
					error : function(xhr, msg, error) {
						csjbotui.ui.msg.alert("Internal Server Error!");
					}
				});
			}
		});
	});

	return editor;
}