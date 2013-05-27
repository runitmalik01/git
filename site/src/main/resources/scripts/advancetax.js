var AdvanceTaxDetail=new com.mootly.wcm.compound.AdvanceTaxDetail;
var sumAdvacTax=0;
var sum1=0;
var sum2=0;
var sum3=0;
var sum4=0;
var sum5=0;
var sum6=0;
if(advancetax!=null){
	if(advancetax.getAdvanceTaxDetailList() != null &&  advancetax.getAdvanceTaxDetailList().size() > 0 ){ 
		for(var i=0;i<advancetax.getAdvanceTaxDetailList().size();i++) {
			sumAdvacTax=sumAdvacTax+advancetax.getAdvanceTaxDetailList().get(i).getP_Amount();		    
			var fetchDate=process(advancetax.getAdvanceTaxDetailList().get(i).getDateStr());
			var date1=process("01/04/2013");  
			var date2=process("15/06/2013");  
			var date3=process("15/09/2013");  
			var date4=process("15/12/2013");  
			var date5=process("15/03/2014");  
			var date6=process("31/03/2014");  		    		 
			if(fetchDate>=date1  && fetchDate<=date2){
				sum1=sum1+advancetax.getAdvanceTaxDetailList().get(i).getP_Amount();			 
			}else{
				if(fetchDate>date2  && fetchDate<=date3){
					sum2=sum2+advancetax.getAdvanceTaxDetailList().get(i).getP_Amount();
				}else {
					if(fetchDate>date3  && fetchDate<=date4){
						sum3=sum3+advancetax.getAdvanceTaxDetailList().get(i).getP_Amount();		   
					} else{
						if(fetchDate>date4 && fetchDate<=date5){	   
							sum4=sum4+advancetax.getAdvanceTaxDetailList().get(i).getP_Amount();
						} else{
							if(fetchDate>date5 && fetchDate<=date6){
								sum5=sum5+advancetax.getAdvanceTaxDetailList().get(i).getP_Amount();
							}
						}
					}
				}
			}
		}
	}
}
out_total_advancetax=sumAdvacTax;
out_total_sum1=sum1;
out_total_sum2=sum2;
out_total_sum3=sum3;
out_total_sum4=sum4;
out_total_sum5=sum5;
out_total_sum6=sum6;
//function to convert in Date Object
function process(date){
	var parts = date.split("/");
	var date = new Date(parts[1] + "/" + parts[0] + "/" + parts[2]);
	return date.getTime();
};