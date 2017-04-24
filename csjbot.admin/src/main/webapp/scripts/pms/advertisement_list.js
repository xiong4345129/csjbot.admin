var table = "";
var initable = "";
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
		    		url:_path + "/adv/search",
		    		method: "POST",
		    		data: queryData,
		    		error: function(xhr, msg){
		    			alert("数据加载失败！");
		    		}
		    	},
				columns : [{
					title : "广告名称",
					data : "name",
					width : "15%"
				},  {
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
		               targets: [ 2 ],
		               render: function ( data, type, row ) {
		            	   var datetime = new Date(Number(row.date_create)).Format( "yyyy-MM-dd HH:mm");
		                   return datetime;
		               }
				},
	           {
	               targets: [ 3 ],
	               render: operation,
	               orderable: false
	           }],
		        order: [[ 2, 'desc' ]],
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

function operation( data, type, row ) {
    var editor = "<a class='opt' id='detail_"+row.id+"' href=\"javascript:void(0);\" ><span>详情</span></a>&nbsp;&nbsp;"
                 + "<a class='opt' id='edit_"+row.id+"' href=\"javascript:void(0);\" ><span>编辑</span></a>&nbsp;&nbsp;"
                 + "<a class='opt' id='delete_"+row.id+"' href=\"javascript:void(0);\" ><span>删除</span></a>&nbsp;&nbsp;"
             
        $(document).off("click", "#detail_" + row.id).on("click", "#detail_" + row.id, function(){
        	window.location = _path + "/adv/" + row.id + "/toAdvertisementDetail";
         });
	    $(document).off("click", "#edit_" + row.id).on("click", "#edit_" + row.id, function(){
	    	window.location = _path + "/adv/" + row.id + "/toAdvertisementUpdate";
	     });    
	    $(document).off("click", "#delete_" + row.id).on("click", "#delete_" + row.id, function(){
	       	 csjbotui.ui.msg.confirm({
	 		        title : "确认删除",
					msg : "您确定要删除该广告【"+row.name+"】?",
					ok:function(){
						 $.ajax({
			        		type : "POST",
			  	            url : _path + "/adv/" + row.id + "/advertisementDelete",
			  	            dataType : "json",
			  	            success : function(data){ 
			  	            	if (data.msg == "S") {
	  	            				window.location.href = _path + "/adv/list";
			  	            	} else {
			  	            		csjbotui.ui.msg.alert( data.msg );
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


	
	
	
