	$.datepicker.setDefaults({
		  /*showOn: "both",*/
		  /*buttonImageOnly: true,
          buttonImage: "<hst:link path="/img/calendar.gif"/>",*/
		  /*buttonText: "Calendar",*/
	      dateFormat: "dd/mm/yy"
		});
		$.datepicker.setDefaults( $.datepicker.regional[ "fr" ] );
		$.validator.addMethod("pan", function(value, element) {
		   	 return this.optional(element) || /^[a-zA-Z]{3}[p|P|c|C|h|H|f|F|a|A|t|T|b|B|l|L|j|J|g|G][a-zA-Z]\d{4}[a-zA-Z]{1}?$/i.test(value);
		}, "PAN is invalid.");
		$.validator.addMethod("amount", function(value, element) {
		   	 return this.optional(element) || /^[0-9]+\.?[0-9]{0,2}?$/i.test(value);
		}, "AMOUNT is invalid.");
		$.validator.addMethod("percentage", function(value, element) {
		   	 return this.optional(element) || /^(100(\.00?)?|[1-9]?\d(\.\d\d?)?)?$/i.test(value);
		}, "Percentage is invalid.");
		$.validator.addMethod("max", function(value, element) {
		   	 return this.optional(element) || /^([0-9]+\.?[0-9]{0,2}){0,14}?$/i.test(value);
		}, "Max length allowed is 14.");
		$.validator.addMethod("pin", function(value, element) {
		   	 return this.optional(element) || /^[0-9]{6}?$/i.test(value);
		}, "PIN Code is invalid");
		$.validator.addMethod("std", function(value, element) {
		   	 return this.optional(element) || /^[0-9]{1,5}?$/i.test(value);
		}, "STD Code is invalid");
		$.validator.addMethod("mobile", function(value, element) {
		   	 return this.optional(element) || /^[1-9]{1}[0-9]{9}?$/i.test(value);
		}, "Mobile No is invalid");
		$.validator.addMethod("email", function(value, element) {
		   	 return this.optional(element) || /^([\.a-zA-Z0-9_\-])+@([a-zA-Z0-9_\-])+(([a-zA-Z0-9_\-])*\.([a-zA-Z0-9_\-])+)+?$/i.test(value);
		}, "Email-ID is invalid");
		$.validator.addMethod("accountno", function(value, element) {
		   	 return this.optional(element) || /^[0-9A-Za-z]{10,}$/i.test(value);
		}, "Account No is invalid");
		$.validator.addMethod("micr", function(value, element) {
		   	 return this.optional(element) || /^[0-9]{9}?$/i.test(value);
		}, "MICR Code is invalid");
		$.validator.addMethod("ifsc", function(value, element) {
		   	 return this.optional(element) || /^[a-zA-Z0-9]{4}[0]{1}[a-zA-Z0-9]{6}?$/i.test(value);
		}, "IFSC Code is invalid");
		$.validator.addMethod("tan", function(value, element) {
		   	 return this.optional(element) || /^[a-zA-Z]{4}[0-9]{5}[a-zA-Z]{1}?$/i.test(value);
		}, "TAN is invalid");
		$.validator.addMethod("bsr", function(value, element) {
		   	 return this.optional(element) || /^[0-9]{7}?$/i.test(value);
		}, "BSR Code is invalid");
		$.validator.addMethod("serial", function(value, element) {
		   	 return this.optional(element) || /^[0-9]{0,5}?$/i.test(value);
		}, "Challan Serial No is invalid");
		$.validator.addMethod("tdscertificate", function(value, element) {
		   	 return this.optional(element) || /^[0-9]{0,8}?$/i.test(value);
		}, "TDS Certificate No is invalid");
		$.validator.addMethod("ackno", function(value, element) {
		   	 return this.optional(element) || /^[0-9]{15}?$/i.test(value);
		}, "Ack No is invalid");
		$.validator.addMethod("indiandate", function(value, element) {
		   	 return this.optional(element) || /^[0-9]{2}\/[0-9]{2}\/[0-9]{4}?$/i.test(value);
		}, "Date Format is invalid");
		$.validator.addMethod("indiandateAdvance", function(value, element) {
		   	 return this.optional(element) || /^[0-9]{2}\/[0-9]{2}\/[0-9]{4}?$/i.test(value);
		}, "Date Format is invalid");
		$.validator.addMethod("indiandateSelfAssesment", function(value, element) {
		   	 return this.optional(element) || /^[0-9]{2}\/[0-9]{2}\/[0-9]{4}?$/i.test(value);
		}, "Date Format is invalid");
		$.validator.addMethod("indiandateLosses", function(value, element) {
		   	 return this.optional(element) || /^[0-9]{2}\/[0-9]{2}\/[0-9]{4}?$/i.test(value);
		}, "Date Format is invalid");
		$.validator.addMethod("auditdateCal", function(value, element) {
		   	 return this.optional(element) || /^[0-9]{2}\/[0-9]{2}\/[0-9]{4}?$/i.test(value);
		}, "Date Format is invalid");
		$.validator.addMethod("dateAuditReport", function(value, element) {
			return this.optional(element) || /^[0-9]{2}\/[0-9]{2}\/[0-9]{4}?$/i.test(value);
		}, "Date Format is invalid");
		$.validator.addMethod("currentDateCal", function(value, element) {
		   	 return this.optional(element) || /^[0-9]{2}\/[0-9]{2}\/[0-9]{4}?$/i.test(value);
		}, "Date Format is invalid");
		$.validator.addMethod("chequeNo", function(value, element) {
		   	 return this.optional(element) || /^[0-9]{6}?$/i.test(value);
		}, "Cheque Number is invalid");
		$.validator.addMethod("TrabsitionNo", function(value, element) {
		   	 return this.optional(element) || /^[a-zA-Z0-9]{0,20}?$/i.test(value);
		}, "Transition/UTR Number is invalid");
		$.validator.addMethod("TaxIdNo", function(value, element) {
		   	 return this.optional(element) || /^[a-zA-Z0-9]{0,16}?$/i.test(value);
		}, "Tax Identification Number is invalid");
		$.validator.addMethod("MembershipNo", function(value, element) {
			return this.optional(element) || /^[0-9]{0,6}?$/i.test(value);
		}, "Membership No. of Auditor is not valid");
		$.validator.addMethod("amountNeg", function(value, element) {
		   	 return this.optional(element) || /^-?[0-9]+\.?[0-9]{0,2}?$/i.test(value);
		}, "AMOUNT is invalid.");
		$.validator.addMethod("cvvNumber", function(value, element) {
		   	 return this.optional(element) || /^[0-9]{3}?$/i.test(value);
		}, "CVV is invalid.");
		$.validator.addMethod("cardNumber", function(value, element) {
		   	 return this.optional(element) || /^[0-9]{16}?$/i.test(value);
		}, "Card Number is invalid.");
		$(".uprcase").each(function(){
	          this.style.textTransform = 'uppercase';
	       })
	       .change(function(){
	          this.value = this.value.toUpperCase();
	       });		
		
		