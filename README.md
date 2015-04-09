# twilio-app
Develop a web app capable of voice call and SMS send features using Twilio API

###Steps for Creating Twilio Account User:
1. Go to www.twilio.com and Signup as a free tier client.
2. Get the `ACCOUNT_SID` and `AUTH_TOKEN`.
3. Get the auto generated phone number and save verified user phone number as Caller IDs for Twilio services.
4. Create TwiML App (twilioapp) and get the `applicationSID` and Set the Request URLS in Voice and Messaging section.

### Steps for Developing TwilioABS Project:
1. Create new web application project with TwilioABS name.
2. Deploy TwilioABS Project on local tomcat server and test.
3. Project will deploy on web browser and provide services for make call, receive call, send message , and receive message. 
4. The app also provides a Google Map screen showing a marker on the user’s geolocation.

###Steps for Deploying TwilioABS Project on AWS Beanstalk:
1. Sign In on AWS and click on Elastic Beanstalk in Products category.
2. Create new Application, name as Twilio6331 and complete application form with default configuration.
3. Upload TwilioABS.war file on beanstalk and deploy. The app is available at `http://twilio6331-env.elasticbeanstalk.com/`

###Technology: 
Java, JavaScript, HTML, Tomcat 7, CSS

###API: 
Twilio API, Google Maps API

###Library: 
twilio-java-sdk-3.3.16-jar-with-dependencies.jar
