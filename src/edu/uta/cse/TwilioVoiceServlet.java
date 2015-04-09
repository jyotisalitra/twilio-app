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
import java.io.IOException; 
import com.twilio.sdk.verbs.TwiMLResponse;
import com.twilio.sdk.verbs.TwiMLException;
import com.twilio.sdk.verbs.Dial;
import com.twilio.sdk.verbs.Client;
import com.twilio.sdk.verbs.Number;


/**
 *  
 * References:
 * 1. https://www.twilio.com/docs/quickstart/java/client/outgoing-calls
 *
 */

public class TwilioVoiceServlet extends HttpServlet {
    
	//get the serialVersionUID 
	private static final long serialVersionUID = 1118647238513704256L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //get parameter
        String phoneNumber = request.getParameter("PhoneNumber");
 
        /* Use this as the caller ID when making calls from a browser. */
        String callerId = "***********";
        //Create instance of TwiMLResponse and Dial.
        TwiMLResponse twiml = new TwiMLResponse();
        Dial dial = new Dial();
        try {
            if (phoneNumber != null) {
            	//Append phone number in Dial.
                dial.append(new Number(phoneNumber));
                //Set it as a callerID.
                dial.setCallerId(callerId);
            } else {
            	//Else default client will make call.
                dial.append(new Client("jyoti"));
            }
            twiml.append(dial);
        } catch (TwiMLException e) {
            e.printStackTrace();
        }
        // Set content type to get response.
        response.setContentType("application/xml");
        response.getWriter().print(twiml.toXML());
    }
}