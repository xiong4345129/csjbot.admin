$(function(){  
    
	validator = $('#desk_form').validate({
	    	errorElement : 'span',  
	        errorClass : 'help-block',  
	        focusInvalid : false,  
	        rules : {  
	        	number : {  
	                required : true,
	                rangelength:[0, 100]
	            },
	            alias : {  
	                required : true,
	                rangelength:[0, 100]
	            },
	            desk_type : {  
	                required : true,
	                isFloatNum3:true,
	                rangelength:[0, 2]
	            },
	            deskx : {  
	                required : true,
	                isFloatNum3: true
	            },
	            desky : {  
	                required : true,
	                isFloatNum3:true
	            },
	            deskz : {  
	                required : true,
	                isFloatNum3:true
	            },
	            deskw : {  
	                required : true,
	                isFloatNum3:true
	            },
	            deskv : {  
	                required : true,
	                isFloatNum3:true
	            },
	            deskq : {  
	                required : true,
	                isFloatNum3:true
	            },
	        },  
	        messages : {    
	        	number : {  
	                required : "必须填写桌号."
	            },
	            alias : {  
	                required : "必须填写桌号别名."
	            },
	            desk_type : {  
	                required : "必须填写桌号类型."
	            },
	            deskx : {  
	                required : "必须填写坐标X."
	            },
	            desky : {  
	                required : "必须填写坐标Y."
	            },
	            deskz : {  
	                required : "必须填写坐标Z."
	            },
	            deskw : {  
	                required : "必须填写坐标W."
	            },
	            deskv : {  
	                required : "必须填写坐标V."
	            },
	            deskq : {  
	                required : "必须填写坐标Q."
	            }
	        },
	        highlight : function(element) {  
	            $(element).closest('.form-group').addClass('has-error');  
	        },
	        success : function(label) {  
	            label.closest('.form-group').removeClass('has-error');  
	            label.remove();  
	        }, 
	        errorPlacement : function(error, element) {  
	            element.parent('div').parent('div').append(error);  
	        }
	        
	    });
	
    $("#submit").click(function(){
    	if (validator.form()) {
    		csjbotui.ui.msg.waiting({
    			title : "正在新增桌号",
    			msg : "请稍等..."
    		});
    		$("#desk_form").ajaxSubmit({
                type: "POST",
                url: _path + "/scs/add",
                dataType: "json",
                success: function(data){
                	csjbotui.ui.msg.waiting.remove();
                	if (data.msg == "S") {
                		csjbotui.ui.msg.alert({
                			msg : "新增桌号成功!",
                			ok : function(){
                				window.location = _path + "/scs/list";
                			}
                		});
                	} else {
                		csjbotui.ui.msg.alert("新增桌号失败!");
                	}
                },  
                error : function(xhr, msg, error) {  
                	csjbotui.ui.msg.waiting.remove();
                	if ("timeout" == msg || "parsererror" == msg) {
                        csjbotui.ui.msg.alert({
                			msg : "对不起，session过期，请重新登录!",
                			ok : function(){
                				window.location.reload();
                			}
                		});
                    } else {
                        csjbotui.ui.msg.alert("Internal Server Error!");
                    }
                }  
            });
    	}
		
	});
    
});/**
 * 
 */