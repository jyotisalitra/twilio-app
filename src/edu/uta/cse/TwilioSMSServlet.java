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
 * 1.https://www.twilio.com/docs/quickstart/java/sms/hello-monkey
 */

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException; 
import com.twilio.sdk.verbs.TwiMLResponse;
import com.twilio.sdk.verbs.TwiMLException;
import com.twilio.sdk.verbs.Sms;
 
public class TwilioSMSServlet extends HttpServlet {
 
	private static final long serialVersionUID = -3514850007993541498L;

	// service() responds to both GET and POST requests.
    // You can also use doGet() or doPost()
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	// Create response instance of TwiMLResponse.
        TwiMLResponse twiml = new TwiMLResponse();
      ////create a instance of Sms and type String reply send by browser. 
        Sms message = new Sms("Hello, this is an automated reply from Twilio6331 App.");
        try {
        	//Append messsage
            twiml.append(message);
        } catch (TwiMLException e) {
            e.printStackTrace();
        }
        
        //Set content type to get response.
        response.setContentType("application/xml");
        response.getWriter().print(twiml.toXML());
    }
}