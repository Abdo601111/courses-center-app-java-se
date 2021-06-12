package com.ga.tc.common;

public class Constants {
    
    public static final Integer SEARCH_BY_ID = 0;
    public static final Integer SEARCH_BY_FULL_NAME = 1;
    public static final Integer SEARCH_BY_EMAIL = 2;
    public static final Integer STATUS_INACTIVE = 0;
    public static final Integer STATUS_ACTIVE = 1;
    public static final Integer STATUS_LIST_ALL = 2;
    public static final Integer LOCAL_AR = 1;
    public static final Integer LOCAL_EN = 2;
    public static final String DEFAULT_PASSWORD = "1234";
    public static final String  FORGOT_PASSWORD_MAIL_BODY="<html>\r\n" + 
			"	<body>" + 
			"		<h3 style=\"color:red;\">ERP <sub>Key</sub> Account Created for you</h3>\r\n" + 
			"		<b>Dear:#full_name#</b><br/>\r\n" + 
			"		<p style=\"font-size:15px;color:blue\">\r\n" + 
			"		Your password is: \r\n" +
			"		</p>\r\n" + 
			"		#password#<br/>\r\n" + 
			"		<b>Password:</b> #pass#<br/>\r\n" + 
			"		<br/><br/>\r\n" + 
			"		<p style=\"font-size:13px;color:gray\">\r\n" + 
			"		Enjoy our System.<br/>\r\n" + 
			"		TC Admin\r\n" + 
			"		\r\n" + 
			"		</p>\r\n" + 
			"	</body>\r\n" + 
			"</html>";
    public static final String [] SCREENS_CODES = {"USR_CR", "USR_AL", 
                        "CRS_A", "CRS_REG", "CRTFCT", "RPRT", "ROL_MG" ,"ROL_AX",
                        "PROFILE_EDT", "CHG_PASS","SCRS"};
}
