package com.mootly.wcm.beans;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:broughtfwdlossesdocument")
public class BroughtFwdLossesDocument extends BroughtFwdLossesVariables{

	static final public String NAMESPACE = "mootlywcm:broughtfwdlossesdocument";
	static final public String NODE_NAME = "broughtfwdlossesdocument";

	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		double defaultValue = 0.0d;

		if (formMap == null) return;

		if (formMap.getField("salariesincomesetoff").getValue().isEmpty()){
			setSalariesincomesetoff(defaultValue);
		}
		else{
			String salariesincomesetoff=formMap.getField("salariesincomesetoff").getValue();
			setSalariesincomesetoff(Double.parseDouble(salariesincomesetoff));
		}

		if (formMap.getField("salariescurrentsetoff").getValue().isEmpty()) {
			setSalariescurrentsetoff(defaultValue);
		}
		else{
			String salariescurrentsetoff=formMap.getField("salariescurrentsetoff").getValue();
			setSalariescurrentsetoff(Double.parseDouble(salariescurrentsetoff));
		}

		if (formMap.getField("hpincomesetoff").getValue().isEmpty()) {
			setHpincomesetoff(defaultValue);
		}
		else{
			String hpincomesetoff=formMap.getField("hpincomesetoff").getValue();
			setHpincomesetoff(Double.parseDouble(hpincomesetoff));
		}

		if (formMap.getField("hpbflasetoff").getValue().isEmpty()) {
			setHpbflasetoff(defaultValue);
		}
		else{
			String hpbflasetoff=formMap.getField("hpbflasetoff").getValue();
			setHpbflasetoff(Double.parseDouble(hpbflasetoff));
		}

		if (formMap.getField("hpbfdsetoff").getValue().isEmpty()) {
			setHpbfdsetoff(defaultValue);
		}
		else{
			String hpbfdsetoff=formMap.getField("hpbfdsetoff").getValue();
			setHpbfdsetoff(Double.parseDouble(hpbfdsetoff));
		}

		if (formMap.getField("hpbflus35setoff").getValue().isEmpty()) {
			setHpbflus35setoff(defaultValue);
		}
		else{
			String hpbflus35setoff=formMap.getField("hpbflus35setoff").getValue();
			setHpbflus35setoff(Double.parseDouble(hpbflus35setoff));
		}

		if (formMap.getField("hpcurrentsetoff").getValue().isEmpty()) {
			setHpcurrentsetoff(defaultValue);
		}
		else{
			String hpcurrentsetoff=formMap.getField("hpcurrentsetoff").getValue();
			setHpcurrentsetoff(Double.parseDouble(hpcurrentsetoff));
		}

		if (formMap.getField("businessincomesetoff").getValue().isEmpty()) {
			setBusinessincomesetoff(defaultValue);
		}
		else{
			String businessincomesetoff=formMap.getField("businessincomesetoff").getValue();
			setBusinessincomesetoff(Double.parseDouble(businessincomesetoff));
		}

		if (formMap.getField("businessbflasetoff").getValue().isEmpty()) {
			setBusinessbflasetoff(defaultValue);
		}
		else{
			String businessbflasetoff=formMap.getField("businessbflasetoff").getValue();
			setBusinessbflasetoff(Double.parseDouble(businessbflasetoff));
		}

		if (formMap.getField("businessbfdsetoff").getValue().isEmpty()) {
			setBusinessbfdsetoff(defaultValue);
		}
		else{
			String businessbfdsetoff=formMap.getField("businessbfdsetoff").getValue();
			setBusinessbfdsetoff(Double.parseDouble(businessbfdsetoff));
		}

		if (formMap.getField("businessbflus35setoff").getValue().isEmpty()) {
			setBusinessbflus35setoff(defaultValue);
		}
		else{
			String businessbflus35setoff=formMap.getField("businessbflus35setoff").getValue();
			setBusinessbflus35setoff(Double.parseDouble(businessbflus35setoff));
		}

		if (formMap.getField("businesscurrentsetoff").getValue().isEmpty()) {
			setBusinesscurrentsetoff(defaultValue);
		}
		else{
			String businesscurrentsetoff=formMap.getField("businesscurrentsetoff").getValue();
			setBusinesscurrentsetoff(Double.parseDouble(businesscurrentsetoff));
		}

		if (formMap.getField("speculativeincomesetoff").getValue().isEmpty()) {
			setSpeculativeincomesetoff(defaultValue);
		}
		else{
			String speculativeincomesetoff=formMap.getField("speculativeincomesetoff").getValue();
			setSpeculativeincomesetoff(Double.parseDouble(speculativeincomesetoff));
		}

		if (formMap.getField("speculativebflasetoff").getValue().isEmpty()) {
			setSpeculativebflasetoff(defaultValue);
		}
		else{
			String speculativebflasetoff=formMap.getField("speculativebflasetoff").getValue();
			setSpeculativebflasetoff(Double.parseDouble(speculativebflasetoff));
		}

		if (formMap.getField("speculativebfdsetoff").getValue().isEmpty()) {
			setSpeculativebfdsetoff(defaultValue);
		}
		else{
			String speculativebfdsetoff=formMap.getField("speculativebfdsetoff").getValue();
			setSpeculativebfdsetoff(Double.parseDouble(speculativebfdsetoff));
		}

		if (formMap.getField("speculativebflus35setoff").getValue().isEmpty()) {
			setSpeculativebflus35setoff(defaultValue);
		}
		else{
			String speculativebflus35setoff=formMap.getField("speculativebflus35setoff").getValue();
			setSpeculativebflus35setoff(Double.parseDouble(speculativebflus35setoff));
		}

		if (formMap.getField("speculativecurrentsetoff").getValue().isEmpty()) {
			setSpeculativecurrentsetoff(defaultValue);
		}
		else{
			String speculativecurrentsetoff=formMap.getField("speculativecurrentsetoff").getValue();
			setSpeculativecurrentsetoff(Double.parseDouble(speculativecurrentsetoff));
		}

		if (formMap.getField("specifiedincomesetoff").getValue().isEmpty()) {
			setSpecifiedincomesetoff(defaultValue);
		}
		else{
			String specifiedincomesetoff=formMap.getField("specifiedincomesetoff").getValue();
			setSpecifiedincomesetoff(Double.parseDouble(specifiedincomesetoff));
		}

		if (formMap.getField("specifiedbflasetoff").getValue().isEmpty()) {
			setSpecifiedbflasetoff(defaultValue);
		}
		else{
			String specifiedbflasetoff=formMap.getField("specifiedbflasetoff").getValue();
			setSpecifiedbflasetoff(Double.parseDouble(specifiedbflasetoff));
		}

		if (formMap.getField("specifiedbfdsetoff").getValue().isEmpty()) {
			setSpecifiedbfdsetoff(defaultValue);
		}
		else{
			String specifiedbfdsetoff=formMap.getField("specifiedbfdsetoff").getValue();
			setSpecifiedbfdsetoff(Double.parseDouble(specifiedbfdsetoff));
		}

		if (formMap.getField("specifiedbflus35setoff").getValue().isEmpty()) {
			setSpecifiedbflus35setoff(defaultValue);
		}
		else{
			String specifiedbflus35setoff=formMap.getField("specifiedbflus35setoff").getValue();
			setSpecifiedbflus35setoff(Double.parseDouble(specifiedbflus35setoff));
		}

		if (formMap.getField("specifiedcurrentsetoff").getValue().isEmpty()) {
			setSpecifiedcurrentsetoff(defaultValue);
		}
		else{
			String specifiedcurrentsetoff=formMap.getField("specifiedcurrentsetoff").getValue();
			setSpecifiedcurrentsetoff(Double.parseDouble(specifiedcurrentsetoff));
		}

		if (formMap.getField("stgcincomesetoff").getValue().isEmpty()) {
			setStgcincomesetoff(defaultValue);
		}
		else{
			String stgcincomesetoff=formMap.getField("stgcincomesetoff").getValue();
			setStgcincomesetoff(Double.parseDouble(stgcincomesetoff));
		}

		if (formMap.getField("stgcbflasetoff").getValue().isEmpty()) {
			setStgcbflasetoff(defaultValue);
		}
		else{
			String stgcbflasetoff=formMap.getField("stgcbflasetoff").getValue();
			setStgcbflasetoff(Double.parseDouble(stgcbflasetoff));
		}

		if (formMap.getField("stgcbfdsetoff").getValue().isEmpty()) {
			setStgcbfdsetoff(defaultValue);
		}
		else{
			String stgcbfdsetoff=formMap.getField("stgcbfdsetoff").getValue();
			setStgcbfdsetoff(Double.parseDouble(stgcbfdsetoff));
		}

		if (formMap.getField("stgcbflus35setoff").getValue().isEmpty()) {
			setStgcbflus35setoff(defaultValue);
		}
		else{
			String stgcbflus35setoff=formMap.getField("stgcbflus35setoff").getValue();
			setStgcbflus35setoff(Double.parseDouble(stgcbflus35setoff));
		}

		if (formMap.getField("stgccurrentsetoff").getValue().isEmpty()) {
			setStgccurrentsetoff(defaultValue);
		}
		else{
			String stgccurrentsetoff=formMap.getField("stgccurrentsetoff").getValue();
			setStgccurrentsetoff(Double.parseDouble(stgccurrentsetoff));
		}

		if (formMap.getField("ltgcincomesetoff").getValue().isEmpty()) {
			setLtgcincomesetoff(defaultValue);
		}
		else{
			String ltgcincomesetoff=formMap.getField("ltgcincomesetoff").getValue();
			setLtgcincomesetoff(Double.parseDouble(ltgcincomesetoff));
		}

		if (formMap.getField("ltgcbflasetoff").getValue().isEmpty()) {
			setLtgcbflasetoff(defaultValue);
		}
		else{
			String ltgcbflasetoff=formMap.getField("ltgcbflasetoff").getValue();
			setLtgcbflasetoff(Double.parseDouble(ltgcbflasetoff));
		}

		if (formMap.getField("ltgcbfdsetoff").getValue().isEmpty()) {
			setLtgcbfdsetoff(defaultValue);
		}
		else{
			String ltgcbfdsetoff=formMap.getField("ltgcbfdsetoff").getValue();
			setLtgcbfdsetoff(Double.parseDouble(ltgcbfdsetoff));
		}

		if (formMap.getField("ltgcbflus35setoff").getValue().isEmpty()) {
			setLtgcbflus35setoff(defaultValue);
		}
		else{
			String ltgcbflus35setoff=formMap.getField("ltgcbflus35setoff").getValue();
			setLtgcbflus35setoff(Double.parseDouble(ltgcbflus35setoff));
		}

		if (formMap.getField("ltgccurrentsetoff").getValue().isEmpty()) {
			setLtgccurrentsetoff(defaultValue);
		}
		else{
			String ltgccurrentsetoff=formMap.getField("ltgccurrentsetoff").getValue();
			setLtgccurrentsetoff(Double.parseDouble(ltgccurrentsetoff));
		}

		if (formMap.getField("otherincomesetoff").getValue().isEmpty()) {
			setOtherincomesetoff(defaultValue);
		}
		else{
			String otherincomesetoff=formMap.getField("otherincomesetoff").getValue();
			setOtherincomesetoff(Double.parseDouble(otherincomesetoff));
		}

		if (formMap.getField("otherbflasetoff").getValue().isEmpty()) {
			setOtherbflasetoff(defaultValue);
		}
		else{
			String otherbflasetoff=formMap.getField("otherbflasetoff").getValue();
			setOtherbflasetoff(Double.parseDouble(otherbflasetoff));
		}

		if (formMap.getField("otherbfdsetoff").getValue().isEmpty()) {
			setOtherbfdsetoff(defaultValue);
		}
		else{
			String otherbfdsetoff=formMap.getField("otherbfdsetoff").getValue();
			setOtherbfdsetoff(Double.parseDouble(otherbfdsetoff));
		}

		if (formMap.getField("otherbflus35setoff").getValue().isEmpty()) {
			setOtherbflus35setoff(defaultValue);
		}
		else{
			String otherbflus35setoff=formMap.getField("otherbflus35setoff").getValue();
			setOtherbflus35setoff(Double.parseDouble(otherbflus35setoff));
		}

		if (formMap.getField("othercurrentsetoff").getValue().isEmpty()) {
			setOthercurrentsetoff(defaultValue);
		}
		else{
			String othercurrentsetoff=formMap.getField("othercurrentsetoff").getValue();
			setOthercurrentsetoff(Double.parseDouble(othercurrentsetoff));
		}

		if (formMap.getField("horseincomesetoff").getValue().isEmpty()) {
			setHorseincomesetoff(defaultValue);
		}
		else{
			String horseincomesetoff=formMap.getField("horseincomesetoff").getValue();
			setHorseincomesetoff(Double.parseDouble(horseincomesetoff));
		}

		if (formMap.getField("horsebflasetoff").getValue().isEmpty()) {
			setHorsebflasetoff(defaultValue);
		}
		else{
			String horsebflasetoff=formMap.getField("horsebflasetoff").getValue();
			setHorsebflasetoff(Double.parseDouble(horsebflasetoff));
		}

		if (formMap.getField("horsebfdsetoff").getValue().isEmpty()) {
			setHorsebfdsetoff(defaultValue);
		}
		else{
			String horsebfdsetoff=formMap.getField("horsebfdsetoff").getValue();
			setHorsebfdsetoff(Double.parseDouble(horsebfdsetoff));
		}

		if (formMap.getField("horsebflus35setoff").getValue().isEmpty()) {
			setHorsebflus35setoff(defaultValue);
		}
		else{
			String horsebflus35setoff=formMap.getField("horsebflus35setoff").getValue();
			setHorsebflus35setoff(Double.parseDouble(horsebflus35setoff));
		}

		if (formMap.getField("horsecurrentsetoff").getValue().isEmpty()) {
			setHorsecurrentsetoff(defaultValue);
		}
		else{
			String horsecurrentsetoff=formMap.getField("horsecurrentsetoff").getValue();
			setHorsecurrentsetoff(Double.parseDouble(horsecurrentsetoff));
		}

		if (formMap.getField("totalbflasetoff").getValue().isEmpty()) {
			setTotalbflasetoff(defaultValue);
		}
		else{
			String totalbflasetoff=formMap.getField("totalbflasetoff").getValue();
			setTotalbflasetoff(Double.parseDouble(totalbflasetoff));
		}

		if (formMap.getField("totalbfdsetoff").getValue().isEmpty()) {
			setTotalbfdsetoff(defaultValue);
		}
		else{
			String totalbfdsetoff=formMap.getField("totalbfdsetoff").getValue();
			setTotalbfdsetoff(Double.parseDouble(totalbfdsetoff));
		}

		if (formMap.getField("totalbflus35setoff").getValue().isEmpty()) {
			setTotalbflus35setoff(defaultValue);
		}
		else{
			String totalbflus35setoff=formMap.getField("totalbflus35setoff").getValue();
			setTotalbflus35setoff(Double.parseDouble(totalbflus35setoff));
		}

		if (formMap.getField("currentsetoff").getValue().isEmpty()) {
			setCurrentsetoff(defaultValue);
		}
		else{
			String currentsetoff=formMap.getField("currentsetoff").getValue();
			setCurrentsetoff(Double.parseDouble(currentsetoff));
		}
	}

	@Override
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub

	}
}
