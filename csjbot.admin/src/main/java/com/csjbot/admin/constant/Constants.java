package com.csjbot.admin.constant;

public class Constants {
	
	/** 当前用户 */
	public final static String CURRENT_USER = "currentUser";
	/** 当前验证码 */
	public final static String CURRENT_USER_VALIDATE_CODE_KEY = "CURRENT_USER_VALIDATE_CODE_KEY";
	
	public final static String ADMIN_ACCOUNT = "admin";
	
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
		/**支付方法**/
		public final static String ZFFF = "ZFFF"; 
		/**服务规模**/
		public final static String FWGM = "FWGM";  
		/**过滤模块**/
		public final static String GLMK = "GLMK";  
		/**产品分类**/
		public final static String CPFL = "CPFL"; 
		/**报表时间**/
		public final static String BBSJ = "BBSJ"; 
		/**Pad使用时长分段,单位秒**/
		public final static String SYSC = "SYSC"; 
		/**Pad使用频次，单位次**/
		public final static String SYPC = "SYPC"; 
		/**接口频道**/
		public final static String JKPD = "JKPD"; 
		/** 产品利率分段  **/
		public final static String LLFD = "LLFD";
		/** Pad访问页数 **/
        public final static String FWYS = "FWYS";
        /** Pad使用间隔  **/
        public final static String SYJG = "SYJG";
	}
	
	public class Status{
		public final static int RUN = 1;
		public final static int DOWN = 0;
	}
}
