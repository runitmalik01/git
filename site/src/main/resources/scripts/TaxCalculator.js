//Define Helper Classes
var indianCurrencyHelper = new com.mootly.wcm.services.IndianCurrencyHelper();
/*
var assyear = document.getElementById("cbassyear").value;
var cbasstype = document.getElementById("cbasstype").value;
var cbresistatus = document.getElementById("cbresistatus").value;
var cbasscategory = document.getElementById("cbasscategory").value;
var txtNetIncome = document.getElementById("txtNetIncome").value;
var out_txtTax = document.getElementById("out_txtTax").value;
var out_txtsurcharge = document.getElementById("out_txtsurcharge").value;
*/
if (cbassyear == "2013-2014") {
    if (cbasscategory == "Male" || cbasscategory == "Female" && (cbasstype == "Individual" && cbresistatus == "Resident" || cbresistatus == "Non-Resident" || cbresistatus == "Not Ordinary Resident")) {
        if (txtNetIncome <= 200000 && txtNetIncome != 0) {
            var A = 0;
            var B = 0;
            var C = 0;
            var D = 0;
            var E = 0;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } //2013-2014..txtNetIncome is less then 200000.
        else if (txtNetIncome > 200001 && txtNetIncome <= 500000) {
            var A = (txtNetIncome - 200000) * 0.1;
            var B = A * 0.02;
            var C = A * 0.01;
            var D = indianCurrencyHelper.round((A + B + C) * 100) / 100;
            var E = 0;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } //2013-2014..txtNetIncome is more then 200001 and less then 500000.
        else if (txtNetIncome > 500001 && txtNetIncome <= 1000000) {
            var A = ((txtNetIncome - 500000) * 0.2) + 30000;
            var B = A * 0.02;
            var C = A * 0.01;
            var D = indianCurrencyHelper.round((A + B + C) * 100) / 100;
            var E = 0;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } //2013-2014..txtNetIncome is more then 500001 and less then 1000000.
        else if (txtNetIncome > 1000000) {
            var A = ((txtNetIncome - 1000000) * 0.3) + 130000;
            var B = A * 0.02;
            var C = A * 0.01;
            var D = indianCurrencyHelper.round((A + B + C) * 100) / 100;
            var E = 0;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } //2013-2014..txtNetIncome is more then 1000000.
    } //  Year 2013-2014..For Male and Female
    else if (cbasscategory == "Senior Citizen" && (cbasstype == "Individual" && cbresistatus == "Resident" || cbresistatus == "Non-Resident" || cbresistatus == "Not Ordinary Resident")) {
        if (txtNetIncome <= 250000 && txtNetIncome != 0) {
            var A = 0;
            var B = 0;
            var C = 0;
            var D = 0;
            var E = 0;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } //2013-2014..txtNetIncome is less then 250000.
        else if (txtNetIncome > 250001 && txtNetIncome <= 500000) {
            var A = ((txtNetIncome - 250000) * 0.1);
            var B = A * 0.02;
            var C = A * 0.01;
            var D = indianCurrencyHelper.round((A + B + C) * 100) / 100;
            var E = 0;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } //2013-2014..txtNetIncome is more then 2500001 and less then 500000.
        else if (txtNetIncome > 500001 && txtNetIncome <= 1000000) {
            var A = ((txtNetIncome - 500000) * 0.2) + 25000;
            var B = A * 0.02;
            var C = A * 0.01;
            var D = indianCurrencyHelper.round((A + B + C) * 100) / 100;
            var E = 0;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } //2013-2014..txtNetIncome is more then 500001 and less then 1000000.
        else if (txtNetIncome > 1000000) {
            var A = ((txtNetIncome - 1000000) * 0.3) + 125000;
            var B = A * 0.02;
            var C = A * 0.01;
            var D = indianCurrencyHelper.round((A + B + C) * 100) / 100;
            var E = 0;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } //2013-2014..txtNetIncome is more then 1000001.
    } // Year 2013-2014..Senior Citizen
    else if (cbasscategory == "Super Senior Citizen" && (cbasstype == "Individual" && cbresistatus == "Resident" || cbresistatus == "Non-Resident" || cbresistatus == "Not Ordinary Resident")) {
        if (txtNetIncome <= 500000 && txtNetIncome != 0) {
            var A = 0;
            var B = 0;
            var C = 0;
            var D = 0;
            var E = 0;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } //2013-2014..txtNetIncome is less then 500000.
        else if (txtNetIncome > 500001 && txtNetIncome <= 1000000) {
            var A = ((txtNetIncome - 500000) * 0.2);
            var B = A * 0.02;
            var C = A * 0.01;
            var D = indianCurrencyHelper.round((A + B + C) * 100) / 100;
            var E = 0;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } //2013-2014..txtNetIncome is  more then500001 and more then 1000001.
        else if (txtNetIncome > 1000000) {
            var A = ((txtNetIncome - 1000000) * 0.3) + 100000;
            var B = A * 0.02;
            var C = A * 0.01;
            var D = indianCurrencyHelper.round((A + B + C) * 100) / 100;
            var E = 0;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } //2013-2014..txtNetIncome is more then 1000001.
    } //Year 2013-2014..Super Senior Citizen
    else if (cbasstype == "Co-operative Society") {
        if (txtNetIncome <= 10000 && txtNetIncome != 0) {
            var A = txtNetIncome * 0.1;
            var B = A * 0.02;
            var C = A * 0.01;
            var D = A + B + C;
            var E = 0;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;

        }
    } //Year..2013-2014 Co-operative Society Calculation
    else if (cbasstype == "h") {
        if (txtNetIncome <= 200000 && txtNetIncome != 0) {
            var A = 0;
            var B = 0;
            var C = 0;
            var D = 0;
            var E = 0;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } //2013-2014..txtNetIncome is less then 200000.
        else if (txtNetIncome > 200001 && txtNetIncome <= 500000) {
            var A = (txtNetIncome - 200000) * 0.1;
            var B = A * 0.02;
            var C = A * 0.01;
            var D = indianCurrencyHelper.round((A + B + C) * 100) / 100;
            var E = 0;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } //2013-2014..txtNetIncome is more then 200001 and less then 500000.
        else if (txtNetIncome > 500001 && txtNetIncome <= 1000000) {
            var A = ((txtNetIncome - 500000) * 0.2) + 30000;
            var B = A * 0.02;
            var C = A * 0.01;
            var D = indianCurrencyHelper.round((A + B + C) * 100) / 100;
            var E = 0;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } //2013-2014..txtNetIncome is more then 500001 and less then 1000000.
        else if (txtNetIncome > 1000000) {
            var A = ((txtNetIncome - 1000000) * 0.3) + 130000;
            var B = A * 0.02;
            var C = A * 0.01;
            var D = indianCurrencyHelper.round((A + B + C) * 100) / 100;
            var E = 0;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } //2013-2014..txtNetIncome is more then 1000000.
    } //Year 2013-2014..HUF
    else if (cbasstype == "c") {
        if (txtNetIncome != 0 && txtNetIncome <= 10000000) {
            var A = txtNetIncome * 0.3;
            var B = A * 0.02;
            var C = A * 0.01;
            var E = 0;
            var D = A + B + C + E;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;

        } else if (txtNetIncome > 10000000) {
            var A = txtNetIncome * 0.3;
            var E = A * 0.05;
            var B = (A + E) * 0.02;
            var C = (A + E) * 0.01;
            var D = A + B + C + E;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;

        }
    } //Year 2013-2014..Domestic Company
    else if (cbasstype == "f" || cbasstype == "l") {
        if (txtNetIncome != 0) {
            var A = txtNetIncome * 0.3;
            var B = A * 0.02;
            var C = A * 0.01;
            var D = A + B + C;
            var E = 0;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        }
    } // 2013-2014 Firms and Local Authority Calculation
} // Assesssment Year 2013-2014 Calculation
 else if (cbassyear == "2012-13") {
    if (cbasscategory == "Male" && (cbasstype == "Individual" && cbresistatus == "Resident" || cbresistatus == "Non-Resident" || cbresistatus == "Not Ordinary Resident")) {
        if (txtNetIncome <= 180000 && txtNetIncome != 0) {
            var A = 0;
            var B = 0;
            var C = 0;
            var D = 0;
            var E = 0;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } //2012-2013..txtNetIncome is less then 180000.
        else if (txtNetIncome > 180001 && txtNetIncome <= 500000) {
            var A = ((txtNetIncome - 180000) * 0.1);
            var B = A * 0.02;
            var C = A * 0.01;
            var E = 0;
            var D = indianCurrencyHelper.round((A + B + C + E) * 100) / 100;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } //2012-2013..txtNetIncome is more then 180001 and less then 500000.
        else if (txtNetIncome > 500001 && txtNetIncome <= 800000) {
            var A = ((txtNetIncome - 500000) * 0.2) + 32000;
            var B = A * 0.02;
            var C = A * 0.01;
            var E = 0;
            var D = indianCurrencyHelper.round((A + B + C + E) * 100) / 100;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } //2012-2013..txtNetIncome is more then 500000 and less then 800000.
        else if (txtNetIncome > 800000) {
            var A = ((txtNetIncome - 800000) * 0.3) + 92000;
            var B = A * 0.02;
            var C = A * 0.01;
            var E = 0;
            var D = indianCurrencyHelper.round((A + B + C + E) * 100) / 100;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } //2012-2013..txtNetIncome is more then 800000.
    } // Year 2012-2013.. Male Calculation
    else if (cbasscategory == "Female" && (cbasstype == "Individual" && cbresistatus == "Resident" || cbresistatus == "Non-Resident" || cbresistatus == "Not Ordinary Resident")) {
        if (txtNetIncome <= 190000 && txtNetIncome != 0) {
            var A = 0;
            var B = 0;
            var C = 0;
            var D = 0;
            var E = 0;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } // 2012-2013 txtNetIncome is less then 190000.
        else if (txtNetIncome > 190001 && txtNetIncome <= 500000) {
            var A = ((txtNetIncome - 190000) * 0.1);
            var B = A * 0.02;
            var C = A * 0.01;
            var E = 0;
            var D = indianCurrencyHelper.round((A + B + C + E) * 100) / 100;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } //2012-2013 txtNetIncome is more then 190001 and less then 500000.
        else if (txtNetIncome > 500001 && txtNetIncome <= 800000) {
            var A = ((txtNetIncome - 500000) * 0.2) + 31000;
            var B = A * 0.02;
            var C = A * 0.01;
            var E = 0;
            var D = indianCurrencyHelper.round((A + B + C + E) * 100) / 100;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } // 2012-2013 txtNetIncome is more then 500001 and less then 800000.
        else if (txtNetIncome > 800000) {
            var A = ((txtNetIncome - 800000) * 0.3) + 91000;
            var B = A * 0.02;
            var C = A * 0.01;
            var E = 0;
            var D = indianCurrencyHelper.round((A + B + C + E) * 100) / 100;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } //2012-2013 txtNetIncome is more then 800000.
    } // Year 2012-2013.. Female Calculation
    else if (cbasscategory == "Senior Citizen" && (cbasstype == "Individual" && cbresistatus == "Resident" || cbresistatus == "Non-Resident" || cbresistatus == "Not Ordinary Resident")) {
        if (txtNetIncome <= 250000 && txtNetIncome != 0) {
            var A = 0;
            var B = 0;
            var C = 0;
            var D = 0;
            var E = 0;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } //2012-2013 txtNetIncome is less then 250000.
        else if (txtNetIncome > 250001 && txtNetIncome <= 500000) {
            var A = ((txtNetIncome - 250000) * 0.1);
            var B = A * 0.02;
            var C = A * 0.01;
            var E = 0;
            var D = indianCurrencyHelper.round((A + B + C + E) * 100) / 100;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } //2012-2013 txtNetIncome is more then 250001 and less then 500000.
        else if (txtNetIncome > 500001 && txtNetIncome <= 800000) {
            var A = ((txtNetIncome - 500000) * 0.2) + 25000;
            var B = A * 0.02;
            var C = A * 0.01;
            var E = 0;
            var D = indianCurrencyHelper.round((A + B + C + E) * 100) / 100;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } //2012-2013 txtNetIncome is more then 500001 and less then 800000.
        else if (txtNetIncome > 800000) {
            var A = ((txtNetIncome - 800000) * 0.3) + 85000;
            var B = A * 0.02;
            var C = A * 0.01;
            var E = 0;
            var D = indianCurrencyHelper.round((A + B + C) * 100) / 100;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } //2012-2013 txtNetIncome is more then 800000.
    } // Year 2012-2013.. Senior Citizen Calculation
    else if (cbasscategory == "Super Senior Citizen" && (cbasstype == "Individual" && cbresistatus == "Resident" || cbresistatus == "Non-Resident" || cbresistatus == "Not Ordinary Resident")) {
        if (txtNetIncome <= 500000 && txtNetIncome != 0) {
            var A = 0;
            var B = 0;
            var C = 0;
            var D = 0;
            var E = 0;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } //2012-2013 txtNetIncome is less then 500000.
        else if (txtNetIncome > 500001 && txtNetIncome <= 800000) {
            var A = ((txtNetIncome - 500000) * 0.2);
            var B = A * 0.02;
            var C = A * 0.01;
            var E = 0;
            var D = indianCurrencyHelper.round((A + B + C + E) * 100) / 100;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } //2012-2013 txtNetIncome is less then 500001 and less then 800000.
        else if (txtNetIncome > 800000) {
            var A = ((txtNetIncome - 800000) * 0.3) + 60000;
            var B = A * 0.02;
            var C = A * 0.01;
            var E = 0;
            var D = indianCurrencyHelper.round((A + B + C + E) * 100) / 100;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } //2012-2013 txtNetIncome is more then 800000.
    } // Year 2012-2013.. Super Senior Citizen Calculation 
    else if (cbasstype == "Co-operative Society") {
        if (txtNetIncome <= 10000 && txtNetIncome != 0) {
            var A = 0;
            var B = 0;
            var C = 0;
            var E = 0;
            var D = A + B + C + E;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } else if (txtNetIncome > 10000 && txtNetIncome <= 20000) {
            var A = (txtNetIncome * 0.2) + 1000;
            var B = A * 0.02;
            var C = A * 0.01;
            var E = 0;
            var D = A + B + C + E;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;

        } else if (txtNetIncome > 20000) {
            var A = (txtNetIncome * 0.3) + 3000;
            var B = A * 0.02;
            var C = A * 0.01;
            var E = 0;
            var D = A + B + C + E;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        }
    } //Year 2012-2013...Co-operative Society
    else if (cbasstype == "h") {
        if (txtNetIncome <= 180000 && txtNetIncome != 0) {
            var A = 0;
            var B = 0;
            var C = 0;
            var D = 0;
            var E = 0;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } //2012-2013..txtNetIncome is less then 180000.
        else if (txtNetIncome > 180001 && txtNetIncome <= 500000) {
            var A = ((txtNetIncome - 180000) * 0.1);
            var B = A * 0.02;
            var C = A * 0.01;
            var E = 0;
            var D = indianCurrencyHelper.round((A + B + C + E) * 100) / 100;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } //2012-2013..txtNetIncome is more then 180001 and less then 500000.
        else if (txtNetIncome > 500001 && txtNetIncome <= 800000) {
            var A = ((txtNetIncome - 500000) * 0.2) + 32000;
            var B = A * 0.02;
            var C = A * 0.01;
            var E = 0;
            var D = indianCurrencyHelper.round((A + B + C + E) * 100) / 100;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } //2012-2013..txtNetIncome is more then 500000 and less then 800000.
        else if (txtNetIncome > 800000) {
            var A = ((txtNetIncome - 800000) * 0.3) + 92000;
            var B = A * 0.02;
            var C = A * 0.01;
            var E = 0;
            var D = indianCurrencyHelper.round((A + B + C + E) * 100) / 100;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } //2012-2013..txtNetIncome is more then 1000000.
    } //Year 2012-2013..HUF Calculation
    else if (cbasstype == "c") {
        if (txtNetIncome != 0 && txtNetIncome <= 10000000) {
            var A = txtNetIncome * 0.3;
            var B = A * 0.02;
            var C = A * 0.01;
            var E = 0;
            var D = A + B + C + E;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;

        } else if (txtNetIncome > 10000000) {
            var A = txtNetIncome * 0.3;
            var E = A * 0.05;
            var B = (A + E) * 0.02;
            var C = (A + E) * 0.01;
            var D = A + B + C + E;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;

        }
    } //Year 2012-2013..Domestic Company
    else if (cbasstype == "f" || cbasstype == "l") {
        if (txtNetIncome != 0) {
            var A = txtNetIncome * 0.3;
            var B = A * 0.02;
            var C = A * 0.01;
            var E = 0;
            var D = A + B + C + E;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        }
    } // 2012-2013 Firms and Local Authority Calculation
} // Assesssment Year 2012-2013 Calculation  
 else if (cbassyear == "2011-12") {
    if (cbasscategory == "Male" && (cbasstype == "Individual" && cbresistatus == "Resident" || cbresistatus == "Non-Resident" || cbresistatus == "Not Ordinary Resident")) {
        if (txtNetIncome <= 160000 && txtNetIncome != 0) {
            var A = 0;
            var B = 0;
            var C = 0;
            var D = 0;
            var E = 0;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } //2011-2012 txtNetIncome is less then 160000.
        else if (txtNetIncome > 160001 && txtNetIncome <= 500000) {
            var A = ((txtNetIncome - 190000) * 0.1);
            var B = A * 0.02;
            var C = A * 0.01;
            var E = 0;
            var D = indianCurrencyHelper.round((A + B + C + E) * 100) / 100;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } // 2011-2012 txtNetIncome is more then 160001 and less then 500000.
        else if (txtNetIncome > 500001 && txtNetIncome <= 800000) {
            var A = ((txtNetIncome - 500000) * 0.2) + 34000;
            var B = A * 0.02;
            var C = A * 0.01;
            var E = 0;
            var D = indianCurrencyHelper.round((A + B + C + E) * 100) / 100;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } //2011-2012 txtNetIncome is more then 500001 and less then 800000.
        else if (txtNetIncome > 800000) {
            var A = ((txtNetIncome - 800000) * 0.3) + 94000;
            var B = A * 0.02;
            var C = A * 0.01;
            var E = 0;
            var D = indianCurrencyHelper.round((A + B + C + E) * 100) / 100;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } //2011-2012 txtNetIncome is more then 800001.
    } // Year 2011-2012.. Male Calculation
    else if (cbasscategory == "Female" && (cbasstype == "Individual" && cbresistatus == "Resident" || cbresistatus == "Non-Resident" || cbresistatus == "Not Ordinary Resident")) {
        if (txtNetIncome <= 190000 && txtNetIncome != 0) {
            var A = 0;
            var B = 0;
            var C = 0;
            var D = 0;
            var E = 0;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } //2011-2012 txtNetIncome is less then 190000.
        else if (txtNetIncome > 190001 && txtNetIncome <= 500000) {
            var A = ((txtNetIncome - 190000) * 0.1);
            var B = A * 0.02;
            var C = A * 0.01;
            var E = 0;
            var D = indianCurrencyHelper.round((A + B + C + E) * 100) / 100;

            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } //2011-2012 txtNetIncome is more then 190000 and less then 500000
        else if (txtNetIncome > 500001 && txtNetIncome <= 800000) {
            var A = ((txtNetIncome - 500000) * 0.2) + 26000;
            var B = A * 0.02;
            var C = A * 0.01;
            var E = 0;
            var D = indianCurrencyHelper.round((A + B + C + E) * 100) / 100;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } //2011-2012 txtNetIncome is more then 500001 and less then 800000
        else if (txtNetIncome > 800000) {
            var A = ((txtNetIncome - 800000) * 0.3) + 86000;
            var B = A * 0.02;
            var C = A * 0.01;
            var E = 0;
            var D = indianCurrencyHelper.round((A + B + C + E) * 100) / 100;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } //2011-2012 txtNetIncome is more then 800000
    } // Year 2011-2012.. Female Calculation
    else if ((cbasscategory == "Senior Citizen" || cbasscategory == "Super Senior Citizen") && (cbasstype == "Individual" && cbresistatus == "Resident" || cbresistatus == "Non-Resident" || cbresistatus == "Not Ordinary Resident")) {
        if (txtNetIncome <= 240000 && txtNetIncome != 0) {
            var A = 0;
            var B = 0;
            var C = 0;
            var D = 0;
            var E = 0;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } //2011-2012 txtNetIncome is less then 240000
        else if (txtNetIncome > 240001 && txtNetIncome <= 500000) {
            var A = ((txtNetIncome - 240000) * 0.1);
            var B = A * 0.02;
            var C = A * 0.01;
            var E = 0;
            var D = indianCurrencyHelper.round((A + B + C + E) * 100) / 100;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } //2011-2012 txtNetIncome is more then 240000 and less then 500000
        else if (txtNetIncome > 500001 && txtNetIncome <= 800000) {
            var A = ((txtNetIncome - 500000) * 0.2) + 26000;
            var B = A * 0.02;
            var C = A * 0.01;
            var E = 0;
            var D = indianCurrencyHelper.round((A + B + C + E) * 100) / 100;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } //2011-2012 txtNetIncome is more then 500000 and less then 800000
        else if (txtNetIncome > 800000) {
            var A = ((txtNetIncome - 800000) * 0.3) + 86000;
            var B = A * 0.02;
            var C = A * 0.01;
            var E = 0;
            var D = indianCurrencyHelper.round((A + B + C + E) * 100) / 100;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } //2011-2012 txtNetIncome is more then 800000
    } // Year 2011-2012... Senior Citizen 
    else if (cbasstype == "Co-operative Society") {
        if (txtNetIncome <= 10000 && txtNetIncome != 0) {
            var A = 0;
            var B = 0;
            var C = 0;
            var E = 0;
            var D = A + B + C + E;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;

        } else if (txtNetIncome > 10000 && txtNetIncome <= 20000) {
            var A = (txtNetIncome * 0.2) + 1000;
            var B = A * 0.02;
            var C = A * 0.01;
            var E = 0;
            var D = A + B + C + E;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;

        } else if (txtNetIncome > 20000) {
            var A = (txtNetIncome * 0.3) + 3000;
            var B = A * 0.02;
            var C = A * 0.01;
            var E = 0;
            var D = A + B + C + E;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        }
    } //Year 2011-2012 	Co-operative Society  
    else if (cbasstype == "h") {
        if (txtNetIncome <= 160000 && txtNetIncome != 0) {
            var A = 0;
            var B = 0;
            var C = 0;
            var D = 0;
            var E = 0;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } //2011-2012..HUF..txtNetIncome is less then 160000.
        else if (txtNetIncome > 160001 && txtNetIncome <= 500000) {
            var A = ((txtNetIncome - 190000) * 0.1);
            var B = A * 0.02;
            var C = A * 0.01;
            var E = 0;
            var D = indianCurrencyHelper.round((A + B + C + E) * 100) / 100;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } // 2011-2012..HUF.. txtNetIncome is more then 160001 and less then 500000.
        else if (txtNetIncome > 500001 && txtNetIncome <= 800000) {
            var A = ((txtNetIncome - 500000) * 0.2) + 34000;
            var B = A * 0.02;
            var C = A * 0.01;
            var E = 0;
            var D = indianCurrencyHelper.round((A + B + C + E) * 100) / 100;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } //2011-2012..HUF.. txtNetIncome is more then 500001 and less then 800000.
        else if (txtNetIncome > 800000) {
            var A = ((txtNetIncome - 800000) * 0.3) + 94000;
            var B = A * 0.02;
            var C = A * 0.01;
            var E = 0;
            var D = indianCurrencyHelper.round((A + B + C + E) * 100) / 100;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;
        } //2011-2012..HUF.. txtNetIncome is more then 800001.
    } // Year 2011-2012..HUF Calculation
    else if (cbasstype == "c") {
        if (txtNetIncome != 0 && txtNetIncome <= 10000000) {
            var A = txtNetIncome * 0.3;
            var B = A * 0.02;
            var C = A * 0.01;
            var E = 0;
            var D = A + B + C + E;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;

        } else if (txtNetIncome > 10000000) {
            var A = txtNetIncome * 0.3;
            var E = A * 0.075;
            var B = (A + E) * 0.02;
            var C = (A + E) * 0.01;
            var D = A + B + C + E;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;

        }
    } //Year 2011-2012..Domestic Company
    else if (cbasstype == "f") {
        if (txtNetIncome != 0) {
            var A = txtNetIncome * 0.3;
            var B = A * 0.02;
            var C = A * 0.01;
            var E = 0;
            var D = A + B + C + E;
            out_txtTax = A;
            out_txtEduCess = B;
            out_txtHEduCess = C;
            out_txttotaltax = D;
            out_txtsurcharge = E;

        }
    } //Year 2011-2012..Firms
} //Assessment Year 2011-2012 Calculations	

//print("hi - I have the sum of two objects " + d3);
