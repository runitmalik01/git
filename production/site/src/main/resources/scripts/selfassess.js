var sumSelfAssess=0;

if(selfassess!=null){
	if (selfassess.getSelfAssesmentDetailList() != null &&  selfassess.getSelfAssesmentDetailList().size() > 0){ 	
		for(var i=0;i<selfassess.getSelfAssesmentDetailList().size();i++) 
			sumSelfAssess=(sumSelfAssess-0)+(selfassess.getSelfAssesmentDetailList().get(i).getP_Amount()-0);		
	}
}

out_total_selfassess=sumSelfAssess;