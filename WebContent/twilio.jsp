<!--  
 * Jyoti Salitra
 * UTA ID: ***********
 * Cloud Computing (CSE - 6331) - David Levine
 * Programming Assignment # 6
 * Date: 12/10/2014
 -->

<!-- 
References:
1. https://www.twilio.com/docs/quickstart/java/client/outgoing-calls
 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Twilio6331 App</title>
    <script type="text/javascript"
      src="//static.twilio.com/libs/twiliojs/1.2/twilio.min.js"></script>
    <script type="text/javascript"
      src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js">
    </script>
    <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=true"></script>
    <link href="http://static0.twilio.com/packages/quickstart/client.css"
      type="text/css" rel="stylesheet" />
      <style type="text/css">
      body {
      	background: url(https://static0.twilio.com/packages/quickstart/whitey.png) center top repeat;
      }
      .col {
      	width: 48%;
      	float: left;
      	padding: 1%;
      }
      textarea {
      	display: block;
		margin: 25px auto 0 auto;
		outline: none;
		border: 1px solid #999;
		line-height: 1.4em;
		font-size: 24px;
		padding: 10px;
		width: 466px;
	}
	button {
		margin-top: 20px !important;
		font-size: 24px !important;
	}
      </style>
    <script type="text/javascript">
 
    Twilio.Device.setup("${token}", {debug: true});
 
      Twilio.Device.ready(function (device) {
        $("#log").text("Ready");
      });
 
      Twilio.Device.error(function (error) {
        $("#log").text("Error: " + error.message);
      });
 
      Twilio.Device.connect(function (conn) {
        $("#log").text("Successfully established call");
      });
 
      Twilio.Device.disconnect(function (conn) {
        $("#log").text("Call ended");
      });
 
      Twilio.Device.incoming(function (conn) {
        $("#log").text("Incoming connection from " + conn.parameters.From);
        // accept the incoming connection and start two-way audio
        conn.accept();
      });
 
      function call() {
        // get the phone number to connect the call to
        params = {"PhoneNumber": $("#number").val()};
        Twilio.Device.connect(params);
      }
 
      function hangup() {
        Twilio.Device.disconnectAll();
      }
      
      function sendSMS() {
    	  
    	  $.ajax({
    		  method: 'POST',
    		  url: 'smsSender',
    		  data: {number: $("#number").val(), body: $("#smsText").val()},
    		  error: function(error){
    			  $("#log").text("Error: " + error);
    		  },
    		  success: function(data){
    			  $("#log").text("SMS Sent to " + $("#number").val());
    		  }
    	  });
          
      }
      
      function showMap(position) {
    	  var mapcanvas = document.createElement('div');
    	  mapcanvas.id = 'mapcontainer';
    	  mapcanvas.style.height = '400px';
    	  mapcanvas.style.width = '500px';

    	  document.querySelector('article').appendChild(mapcanvas);

    	  var coords = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
    	  
    	  var options = {
    	    zoom: 15,
    	    center: coords,
    	    mapTypeId: google.maps.MapTypeId.ROADMAP
    	  };
    	  var map = new google.maps.Map(document.getElementById("mapcontainer"), options);

    	  var marker = new google.maps.Marker({
    	      position: coords,
    	      map: map,
    	      title:"Your Current Location"
    	  });
    	}
      
      function error() {
    	  alert('You have not allowed this app to track your geolocation.');
      }

      	//HTML5 Geolocation API
    	if (navigator.geolocation) {
    	  navigator.geolocation.getCurrentPosition(showMap, error);
    	} else {
    	  console.log('HTML5 Geo Location API is not supported');
    	}
    </script>
  </head>
  <body>
  <img src="https://static0.twilio.com/packages/quickstart/logo.png">
  <div>
  <div class="col">
	  <article></article>
  </div>
  <div class="col">
	  <p>Incoming Number: ***********</p>
    
    <button class="call" onclick="call();">
      Call
    </button>
    
    <button class="call" onclick="sendSMS();">
      Send SMS
    </button>
 
    <!-- use an onclick action to hang up the call when the user presses
    the button -->
    <button class="hangup" onclick="hangup();">
      Hangup
    </button>
 
    <input type="text" id="number" name="number"
      placeholder="Enter a phone number to call"/>
      <textarea rows="3" id="smsText" placeholder="Write your message here"></textarea>
 
    <div id="log">Loading pigeons...</div>
  </div>
    </div>
  </body>
</html>