/**
 * Jyoti Salitra
 * UTA ID: ***********
 * Cloud Computing (CSE - 6331) - David Levine
 * Programming Assignment # 6
 * Date: 12/10/2014
 */

package edu.uta.cse;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;
 
import com.twilio.sdk.client.TwilioCapability;
import com.twilio.sdk.client.TwilioCapability.DomainException;
 
public class TwilioServlet extends HttpServlet {
 
    /**
     * TwilioServlet.java will make phone call from browser to Twilio Client.
	 * References: 
	 * 1. https://www.twilio.com/docs/quickstart/java/client/hello-monkey
	 */
	
	// Created account on www.twilio.com and got the serialVersionUID, ACCOUNT_SID and AUTH_TOKEN.
	private static final long serialVersionUID = 357657823169663726L;
	public static final String ACCOUNT_SID = "***********";
    public static final String AUTH_TOKEN = "***********";
 
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
 
        // This is a special Quickstart application sid that is configured at twilio.com/user/account/apps
        String applicationSid = "***********";
 
        TwilioCapability capability = new TwilioCapability(ACCOUNT_SID, AUTH_TOKEN);
        capability.allowClientOutgoing(applicationSid);
        //The function allowClientIncoming grants the browser permission to register itself with Twilio under the name 'jyoti'. 
        capability.allowClientIncoming("***********");
 
        String token = null;
        try {
        	//generate token
            token = capability.generateToken();
        } catch (DomainException e) {
            e.printStackTrace();
        }
        // Forward the token information to a twilio.jsp view
        response.setContentType("text/html");
        request.setAttribute("token", token);
        RequestDispatcher view = request.getRequestDispatcher("twilio.jsp");
        view.forward(request, response);
    }
}