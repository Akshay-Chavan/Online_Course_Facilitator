package com.oodp.ocf.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



public class SessionUtil {
	
	public boolean isSessionSet(HttpServletRequest request)
	{
		try
		{
		HttpSession session=request.getSession();
		
		String KID=(String)session.getAttribute("fName");
		
		if(KID==null)
		{
			return false;
		}
		else
		{
			return true;
		}
		}catch (Exception e) {
			return false;
		}
	}

}
