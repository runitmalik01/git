/*
 * SimpleModal Basic Modal Dialog
 * http://simplemodal.com
 *
 * Copyright (c) 2013 Eric Martin - http://ericmmartin.com
 *
 * Licensed under the MIT license:
 *   http://www.opensource.org/licenses/mit-license.php
 */

jQuery(function ($) {
	// Load dialog on page load
	//$('#basic-modal-content').modal();

	// Load dialog on click
	
	$('#basic-modal .bankint').click(function (e) {
		$('#basic-modal-contentbankint').modal();

		return false;
	});
	$('#basic-modal .otherint').click(function (e) {
		$('#basic-modal-contentotherint').modal();

		return false;
	});
	
	$('#basic-modal .basic80C').click(function (e) {
		$('#basic-modal-content80C').modal();

		return false;
	});
	$('#basic-modal .basic80IA').click(function (e) {
		$('#basic-modal-content80IA').modal();

		return false;
	});
	$('#basic-modal .basic80IB').click(function (e) {
		$('#basic-modal-content80IB').modal();

		return false;
	});
	$('#basic-modal .basic80IC').click(function (e) {
		$('#basic-modal-content80IC').modal();

		return false;
	});
	$('#basic-modal .basic80GG').click(function (e) {
		$('#basic-modal-content80GG').modal();

		return false;
	});
	$('#basic-modal .basic80G').click(function (e) {
		$('#basic-modal-content80G').modal();

		return false;
	});
});