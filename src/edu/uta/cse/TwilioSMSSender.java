/**
 * Jyoti Salitra
 * UTA ID: ***********
 * Cloud Computing (CSE - 6331) - David Levine
 * Programming Assignment # 6
 * Date: 12/10/2014
 */

package edu.uta.cse;

/**
 * References:
 * 1. https://www.twilio.com/docs/quickstart/java/sms/hello-monkey
 */

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.SmsFactory;
import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.resource.instance.Sms;
 
public class TwilioSMSSender extends HttpServlet {
 
	private static final long serialVersionUID = -3514850007993541498L;
	public static final String ACCOUNT_SID = "***********";
    public static final String AUTH_TOKEN = "***********";

	// service() responds to both GET and POST requests.
    // You can also use doGet() or doPost()
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
    	//create a instance of Account
        Account account = client.getAccount();
        //create a instance of SmsFactory using its factory method
        SmsFactory messageFactory = account.getSmsFactory();
        //Create a map of all attributes and values for a record
        Map<String, String> params = new HashMap<String, String>();
        params.put("To", request.getParameter("number"));
        params.put("From", "***********");
        params.put("Body", request.getParameter("body"));
        try {
			Sms sms = messageFactory.create(params);
		} catch (TwilioRestException e) {
			e.printStackTrace();
		}
    }
}