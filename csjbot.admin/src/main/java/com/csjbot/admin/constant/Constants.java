package com.csjbot.admin.constant;

import com.csjbot.admin.util.PropertiesUtils;

public class Constants {
	
	/** 当前用户 */
	public final static String CURRENT_USER = "currentUser";
	/** 当前验证码 */
	public final static String CURRENT_USER_VALIDATE_CODE_KEY = "CURRENT_USER_VALIDATE_CODE_KEY";
	
	public final static String ADMIN_ACCOUNT = "admin";
	
	/** 文件上传路径*/
	public final static String UPLOAD_PATH = PropertiesUtils.getValue("upload.path");
	
	public final static Integer LAST_DAYS_30 = 30;
		
	public class Log{
		/**LOG级别INFO**/
		public final static int LOG_LEVEL_INFO = 1;
		/**LOG级别ERROR**/
		public final static int LOG_LEVEL_ERROR = 2;
		/**LOG级别WARM*/
		public final static int LOG_LEVEL_WARM = 3;
		/**LOG级别DEBUG**/
		public final static int LOG_LEVEL_DEBUG = 4;
		
		/**LOG类型操作日志**/
		public final static int LOG_TYPE_OPE = 1;
		/**LOG类型系统日志**/
		public final static int LOG_TYPE_SYS = 2;
		
	}
	
	
	public class DataDictionary{
		/**产品分类**/
		public final static String CPFL = "CPFL"; 
		/**支付方法**/
		public final static String ZFFF = "ZFFF"; 
	}
	
	public class Status{
		public final static int RUN = 1;
		public final static int DOWN = 0;
	}
	
	public class Attachment{
		
		public class Type{
			public final static String PRODUCT_BASIC_INFO = "PRODUCT_BASIC_INFO";   //产品基本信息
			public final static String ADVERTISMENT_PIC = "ADVERTISMENT_PIC";       //广告图片
			public final static String ADVERTISMENT_VEDIO = "ADVERTISMENT_VEDIO";   //广告视频
			public final static String ADVERTISMENT_AUDIO = "ADVERTISMENT_AUDIO";   //广告声频
		}
		public class Path {
			public final static String PRODUCT_PIC_PATH = "/pms/";
			public final static String ADVERTISMENT_FILE_PATH = "/ams/";
		}
	}
	
	
}
