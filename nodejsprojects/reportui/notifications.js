
exports.sendInactiveReminder = function (emailAddress,resellerId,memberHandlePathUUID) {
		//first send email to the user and then update the record in the collections w4india_notifications
		//either create a record or just update the existing 
		//the property will be inactiveReminderCount
		//find the reminderCount here
		
		var reminderCount = 1;
		
		var message = {
	    "html": "<p>Example HTML content</p>",
	    "text": "Example text content",
	    "subject": "example subject",
	    "from_email": "no-reply@wealth4india.com",
	    "from_name": "Wealth4India",
	    "to": [{
	            "email": emailAddress,
	            "name":  emailAddress,
	            "type": "to"
	        }],
	    "headers": {
	        "Reply-To": "no-reply@wealth4india.com"
	    },
	    "important": false,
	    "track_opens": null,
	    "track_clicks": null,
	    "auto_text": null,
	    "auto_html": null,
	    "inline_css": null,
	    "url_strip_qs": null,
	    "preserve_recipients": null,
	    "view_content_link": null,
	    "bcc_address": "amit@mootly.com",
	    "tracking_domain": null,
	    "signing_domain": null,
	    "return_path_domain": null,
	    "merge": true,
	    "global_merge_vars": [{
	            "name": "merge1",
	            "content": "merge1 content"
	        }],
	    "merge_vars": [{
	            "rcpt": "recipient.email@example.com",
	            "vars": [{
	                    "name": "reminderCount",
	                    "content": reminderCount
	                }]
	        }],
	    "tags": [
	        "inactivation-reminders"
	    ],
	    "metadata": {
	        "website": "www.wealth4india.com"
	    },
	    "recipient_metadata": [{
	            "rcpt": emailAddress,
	            "values": {
	                "memberHandlePathUUID": memberHandlePathUUID
	            }
	        }]
	};
	var async = false;
	var ip_pool = "Main Pool";
	//var send_at = "example send_at";
	mandrill_client.messages.send({"message": message, "async": async, "ip_pool": ip_pool}, function(result) {
	    console.log(result);
	    /*
	    [{
	            "email": "recipient.email@example.com",
	            "status": "sent",
	            "reject_reason": "hard-bounce",
	            "_id": "abc123abc123abc123abc123abc123"
	        }]
	    */
	}, function(e) {
	    // Mandrill returns the error as an object with name and message keys
	    console.log('A mandrill error occurred: ' + e.name + ' - ' + e.message);
	    // A mandrill error occurred: Unknown_Subaccount - No subaccount exists with the id 'customer-123'
	});
	

}