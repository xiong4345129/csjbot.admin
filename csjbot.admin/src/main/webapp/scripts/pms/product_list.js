var table = "";
$(function() {
	
	// ----------------条件搜索-----------------------------------------------------------
	$("#searchButton").click(function() {
		table.state.clear(); 
		table.destroy();
		table = $("#tp").DataTable(initOptions());
	});
	$(document).keydown(function(e){
		if (e && e.keyCode == 13) {
			$("#searchButton").click();
			return false;
		}
	});

	// ----------------重置搜索条件--------------------------------------------------------
	$('#resetButton').click(function() {
		$('#name').val('');
	});
	
	function initOptions(){
		var queryData = {name:$("#name").val()};
		var options = {
				processing: true,
		        serverSide: true,
		    	ajax: {
		    		url:_path + "/pms/search",
		    		method: "POST",
		    		data: queryData,
		    		error: function(xhr, msg){
		    			alert("数据加载失败！");
		    		}
		    	},
				columns : [{
					title : "产品名称",
					data : "name",
					width : "15%"
				}, {
					title : "价格",
					data : "price",
					width : "15%"
				}, {
					title : "备注",
					data : "memo",
					width : "15%"
				}, {
					title : "创建时间",
					data : "date_create",
					dataType : 'datetime',
					width : "15%"
				}, {
					title : "操作",
					width : "15%",
					style : "operation-column"
				}],
				columnDefs: [{ 
		               targets: [ 3 ],
		               render: function ( data, type, row ) {
		            	   var datetime = new Date(Number(row.date_create)).Format( "yyyy-MM-dd HH:mm");
		                   return datetime;
		               }
				},
	           {
	               targets: [ 4 ],
	               render: operation,
	               orderable: false
	           }],
		        order: [[ 3, 'asc' ]],
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
	table = $("#tp").DataTable(initOptions());
});

function operation( data, type, row ) {
    var editor = "<a class='opt' id='detail_"+row.id+"' href=\"javascript:void(0);\" ><span>详情</span></a>&nbsp;&nbsp;"
                 + "<a class='opt' id='edit_"+row.id+"' href=\"javascript:void(0);\" ><span>编辑</span></a>&nbsp;&nbsp;"
             
        $(document).off("click", "#detail_" + row.id).on("click", "#detail_" + row.id, function(){
        	window.location = _path + "/con/" + row.id + "/toConfigDetail";
         });
	    $(document).off("click", "#edit_" + row.id).on("click", "#edit_" + row.id, function(){
	    	window.location = _path + "/con/" + row.id + "/toConfigEdit";
	     });    
	    
    return editor;
}


	
	
	
