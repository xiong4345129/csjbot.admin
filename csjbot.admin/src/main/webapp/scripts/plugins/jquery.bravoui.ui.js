/**
 * 
 * @author xiaoming
 */

bravoui.ui = bravoui.ui || {};

/**
 * define
 */
(function($, BUI) {

	BUI.ui.msg = BUI.ui.msg || {};

	BUI.ui.msg.alert = function(options) {

		var msg = '<div class="modal"><div class="modal-dialog"><div class="modal-content">' + '<div class="modal-header"><button type="button" class="close" id="closeModal" data-dismiss="modal"><span>&times;</span></button><h4 class="modal-title"></h4></div>' + '<div class="modal-body"></div>' + '<div class="modal-footer"><button type="button" class="btn btn-default" id="closeModal" data-dismiss="modal" >Ok</button></div>'
				+ '</div></div></div>';

		msg = $(msg).modal({
			backdrop : 'static'
		});
		// --------------------------------------------------------------------------------------------------------------------------------------------------------------
		var _msg = "", _title = "";
		if (typeof options == 'string' || typeof options == 'int') {
			_title = "Info.";
			_msg = options;
		} else {
			_title = options.title;
			_msg = options.msg;
		}
		$(msg).find(".modal-title").append(_title);
		$(msg).find(".modal-body").append(_msg);
		// --------------------------------------------------------------------------------------------------------------------------------------------------------------
		$(msg).find("button").click(function() {
			$(msg).remove();
		});
	};

}(jQuery, bravoui));

(function($, BUI) {

	BUI.ui.comment = BUI.ui.comment || {};

	BUI.ui.comment.show = function(options) {

		var defaults = {
			title : "Comment",
			tipMsg : "",
			requiredMsg : "This field is required.",
			style : "",
			readonly : false,
			value : null,
			height : null,
			width : null,
			maxLength : 400,
			contentEl : "<textarea class=\"comment\" style=\"height: 160px; width: 100%\"></textarea><span class=\"error-tip\"></span>",
			buttons : [ {
				text : "Ok",
				style : "btn-default",
				click : function(btn, target, comment) {
					$(target).remove();
				}
			} ]
		};

		options = $.extend(defaults, options) || defaults;

		var win = '<div class="modal comment-window"><div class="modal-dialog"><div class="modal-content">' + '<div class="modal-header"><button type="button" id="closeModal" class="close" data-dismiss="modal"><span>&times;</span></button><h4 class="modal-title"></h4></div>' + '<div class="modal-body"></div>' + '<div class="modal-footer"></div>' + '</div></div></div>';

		win = $(win).modal({
			backdrop : 'static'
		});
		// --------------------------------------------------------------------------------------------------------------------------------------------------------------
		$(win).find(".modal-title").append((options && options.title) || "Comment");
		$(win).find(".modal-body").append((options && options.tipMsg) || "");
		$(win).find(".modal-body").append((options && options.contentEl));
		// --------------------------------------------------------------------------------------------------------------------------------------------------------------
		if ((options && options.height)) {
			$(win).find(".comment").css({
				height : options.height
			});
		}
		if ((options && options.width)) {
			$(win).find(".comment").css({
				width : options.width
			});
		}
		if ((options && options.maxLength)) {
			$(win).find(".comment").attr('maxlength', options.maxLength);
		}
		if (options.readonly) {
			$(win).find(".comment").attr('readonly', "true");
		}
		if (options.value) {
			$(win).find(".comment").val(options.value);
		}
		// --------------------------------------------------------------------------------------------------------------------------------------------------------------
		$(win).find(".comment").unbind("keyup").keyup(function(){
			if(!bravoui.isEmpty(this.value)) $(win).find(".error-tip").empty();
			else $(win).find(".error-tip").empty().append(options.requiredMsg);
		});
		// --------------------------------------------------------------------------------------------------------------------------------------------------------------
		win.validate = function(){
			var comment = $(win).find(".comment").val();
			if(bravoui.isEmpty(comment)) {
				$(win).find(".error-tip").empty().append(options.requiredMsg);
				// --------------------------------------------------------------------------------------------------------------------------------------------------------------
				return false;
			}
			// --------------------------------------------------------------------------------------------------------------------------------------------------------------
			return true;
		};
		// --------------------------------------------------------------------------------------------------------------------------------------------------------------
		$.each(options.buttons, function(i, button) {
			var btn = $("<button type=\"button\" class=\"btn\" >" + button.text + "</button>");
			if (button.style)
				$(btn).addClass(button.style);
			if (button.click)
				$(btn).unbind('click').click(function() {
					button.click(this, win);
				});
			$(win).find(".modal-footer").append(btn);
		});
		// --------------------------------------------------------------------------------------------------------------------------------------------------------------
		$(win).find(".modal-header").find(".close").click(function() {
			$(win).remove();
		});
	};

}(jQuery, bravoui));