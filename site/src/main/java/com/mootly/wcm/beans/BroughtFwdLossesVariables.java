package com.mootly.wcm.beans;

import javax.jcr.RepositoryException;

import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;

public abstract class BroughtFwdLossesVariables extends BaseDocument implements ContentNodeBinder, FormMapFiller {

	private Double salariesincomesetoff;
	private Double salariescurrentsetoff;
	private Double hpincomesetoff;
	private Double hpbflasetoff;
	private Double hpbfdsetoff;
	private Double hpbflus35setoff;
	private Double hpcurrentsetoff;
	private Double businessincomesetoff;
	private Double businessbflasetoff;
	private Double businessbfdsetoff;
	private Double businessbflus35setoff;
	private Double businesscurrentsetoff;
	private Double speculativeincomesetoff;
	private Double speculativebflasetoff;
	private Double speculativebfdsetoff;
	private Double speculativebflus35setoff;
	private Double speculativecurrentsetoff;
	private Double specifiedincomesetoff;
	private Double specifiedbflasetoff;
	private Double specifiedbfdsetoff;
	private Double specifiedbflus35setoff;
	private Double specifiedcurrentsetoff;
	private Double stgcincomesetoff;
	private Double stgcbflasetoff;
	private Double stgcbfdsetoff;
	private Double stgcbflus35setoff;
	private Double stgccurrentsetoff;
	private Double ltgcincomesetoff;
	private Double ltgcbflasetoff;
	private Double ltgcbfdsetoff;
	private Double ltgcbflus35setoff;
	private Double ltgccurrentsetoff;
	private Double otherincomesetoff;
	private Double otherbflasetoff;
	private Double otherbfdsetoff;
	private Double otherbflus35setoff;
	private Double othercurrentsetoff;
	private Double horseincomesetoff;
	private Double horsebflasetoff;
	private Double horsebfdsetoff;
	private Double horsebflus35setoff;
	private Double horsecurrentsetoff;
	private Double totalbflasetoff;
	private Double totalbfdsetoff;
	private Double totalbflus35setoff;
	private Double currentsetoff;

	//getter and setter methods

	public  Double getSalariesincomesetoff() {
		if (salariesincomesetoff == null) salariesincomesetoff = getProperty("mootlywcm:salariesincomesetoff");
		return salariesincomesetoff;
	}

	public final void  setSalariesincomesetoff(Double salariesincomesetoff) {
		this.salariesincomesetoff = salariesincomesetoff;
	}

	public  Double getSalariescurrentsetoff() {
		if (salariescurrentsetoff == null) salariescurrentsetoff = getProperty("mootlywcm:salariescurrentsetoff");
		return salariescurrentsetoff;
	}

	public final void  setSalariescurrentsetoff(Double salariescurrentsetoff) {
		this.salariescurrentsetoff = salariescurrentsetoff;
	}
	public  Double getHpincomesetoff() {
		if (hpincomesetoff == null) hpincomesetoff = getProperty("mootlywcm:hpincomesetoff");
		return hpincomesetoff;
	}

	public final void  setHpincomesetoff(Double hpincomesetoff) {
		this.hpincomesetoff = hpincomesetoff;
	}
	public  Double getHpbflasetoff() {
		if (hpbflasetoff == null) hpbflasetoff = getProperty("mootlywcm:hpbflasetoff");
		return hpbflasetoff;
	}

	public final void  setHpbflasetoff(Double hpbflasetoff) {
		this.hpbflasetoff = hpbflasetoff;
	}
	public  Double getHpbfdsetoff() {
		if (hpbfdsetoff == null) hpbfdsetoff = getProperty("mootlywcm:hpbfdsetoff");
		return hpbfdsetoff;
	}
	public final void  setHpbfdsetoff(Double hpbfdsetoff) {
		this.hpbfdsetoff = hpbfdsetoff;
	}
	public  Double getHpbflus35setoff() {
		if (hpbflus35setoff == null) hpbflus35setoff = getProperty("mootlywcm:hpbflus35setoff");
		return hpbflus35setoff;
	}

	public final void  setHpbflus35setoff(Double hpbflus35setoff) {
		this.hpbflus35setoff = hpbflus35setoff;
	}
	public  Double getHpcurrentsetoff() {
		if (hpcurrentsetoff == null) hpcurrentsetoff = getProperty("mootlywcm:hpcurrentsetoff");
		return hpcurrentsetoff;
	}

	public final void  setHpcurrentsetoff(Double hpcurrentsetoff) {
		this.hpcurrentsetoff = hpcurrentsetoff;
	}
	public  Double getBusinessincomesetoff() {
		if (businessincomesetoff == null) businessincomesetoff = getProperty("mootlywcm:businessincomesetoff");
		return businessincomesetoff;
	}

	public final void  setBusinessincomesetoff(Double businessincomesetoff) {
		this.businessincomesetoff = businessincomesetoff;
	}
	public  Double getBusinessbflasetoff() {
		if (businessbflasetoff == null) businessbflasetoff = getProperty("mootlywcm:businessbflasetoff");
		return businessbflasetoff;
	}

	public final void  setBusinessbflasetoff(Double businessbflasetoff) {
		this.businessbflasetoff = businessbflasetoff;
	}
	public  Double getBusinessbfdsetoff() {
		if (businessbfdsetoff == null) businessbfdsetoff = getProperty("mootlywcm:businessbfdsetoff");
		return businessbfdsetoff;
	}

	public final void  setBusinessbfdsetoff(Double businessbfdsetoff) {
		this.businessbfdsetoff = businessbfdsetoff;
	}
	public  Double getBusinessbflus35setoff() {
		if (businessbflus35setoff == null) businessbflus35setoff = getProperty("mootlywcm:businessbflus35setoff");
		return businessbflus35setoff;
	}

	public final void  setBusinessbflus35setoff(Double businessbflus35setoff) {
		this.businessbflus35setoff = businessbflus35setoff;
	}
	public  Double getBusinesscurrentsetoff() {
		if (businesscurrentsetoff == null) businesscurrentsetoff = getProperty("mootlywcm:businesscurrentsetoff");
		return businesscurrentsetoff;
	}

	public final void  setBusinesscurrentsetoff(Double businesscurrentsetoff) {
		this.businesscurrentsetoff = businesscurrentsetoff;
	}
	public  Double getSpeculativeincomesetoff() {
		if (speculativeincomesetoff == null) speculativeincomesetoff = getProperty("mootlywcm:speculativeincomesetoff");
		return speculativeincomesetoff;
	}

	public final void  setSpeculativeincomesetoff(Double speculativeincomesetoff) {
		this.speculativeincomesetoff = speculativeincomesetoff;
	}
	public  Double getSpeculativebflasetoff() {
		if (speculativebflasetoff == null) speculativebflasetoff = getProperty("mootlywcm:speculativebflasetoff");
		return speculativebflasetoff;
	}

	public final void  setSpeculativebflasetoff(Double speculativebflasetoff) {
		this.speculativebflasetoff = speculativebflasetoff;
	}
	public  Double getSpeculativebfdsetoff() {
		if (speculativebfdsetoff == null) speculativebfdsetoff = getProperty("mootlywcm:speculativebfdsetoff");
		return speculativebfdsetoff;
	}

	public final void  setSpeculativebfdsetoff(Double speculativebfdsetoff) {
		this.speculativebfdsetoff = speculativebfdsetoff;
	}
	public  Double getSpeculativebflus35setoff() {
		if (speculativebflus35setoff == null) speculativebflus35setoff = getProperty("mootlywcm:speculativebflus35setoff");
		return speculativebflus35setoff;
	}

	public final void  setSpeculativebflus35setoff(Double speculativebflus35setoff) {
		this.speculativebflus35setoff = speculativebflus35setoff;
	}

	public  Double getSpeculativecurrentsetoff() {
		if (speculativecurrentsetoff == null) speculativecurrentsetoff = getProperty("mootlywcm:speculativecurrentsetoff");
		return speculativecurrentsetoff;
	}
	public final void  setSpeculativecurrentsetoff(Double speculativecurrentsetoff) {
		this.speculativecurrentsetoff = speculativecurrentsetoff;
	}

	public  Double getSpecifiedincomesetoff() {
		if (specifiedincomesetoff == null) specifiedincomesetoff = getProperty("mootlywcm:specifiedincomesetoff");
		return specifiedincomesetoff;
	}
	public final void  setSpecifiedincomesetoff(Double specifiedincomesetoff) {
		this.specifiedincomesetoff = specifiedincomesetoff;
	}

	public  Double getSpecifiedbflasetoff() {
		if (specifiedbflasetoff == null) specifiedbflasetoff = getProperty("mootlywcm:specifiedbflasetoff");
		return specifiedbflasetoff;
	}
	public final void  setSpecifiedbflasetoff(Double specifiedbflasetoff) {
		this.specifiedbflasetoff = specifiedbflasetoff;
	}

	public  Double getSpecifiedbfdsetoff() {
		if (specifiedbfdsetoff == null) specifiedbfdsetoff = getProperty("mootlywcm:specifiedbfdsetoff");
		return specifiedbfdsetoff;
	}
	public final void  setSpecifiedbfdsetoff(Double specifiedbfdsetoff) {
		this.specifiedbfdsetoff = specifiedbfdsetoff;
	}

	public  Double getSpecifiedbflus35setoff() {
		if (specifiedbflus35setoff == null) specifiedbflus35setoff = getProperty("mootlywcm:specifiedbflus35setoff");
		return specifiedbflus35setoff;
	}
	public final void  setSpecifiedbflus35setoff(Double specifiedbflus35setoff) {
		this.specifiedbflus35setoff = specifiedbflus35setoff;
	}

	public  Double getSpecifiedcurrentsetoff() {
		if (specifiedcurrentsetoff == null) specifiedcurrentsetoff = getProperty("mootlywcm:specifiedcurrentsetoff");
		return specifiedcurrentsetoff;
	}
	public final void  setSpecifiedcurrentsetoff(Double specifiedcurrentsetoff) {
		this.specifiedcurrentsetoff = specifiedcurrentsetoff;
	}

	public  Double getStgcincomesetoff() {
		if (stgcincomesetoff == null) stgcincomesetoff = getProperty("mootlywcm:stgcincomesetoff");
		return stgcincomesetoff;
	}
	public final void  setStgcincomesetoff(Double stgcincomesetoff) {
		this.stgcincomesetoff = stgcincomesetoff;
	}

	public  Double getStgcbflasetoff() {
		if (stgcbflasetoff == null) stgcbflasetoff = getProperty("mootlywcm:stgcbflasetoff");
		return stgcbflasetoff;
	}
	public final void  setStgcbflasetoff(Double stgcbflasetoff) {
		this.stgcbflasetoff = stgcbflasetoff;
	}

	public  Double getStgcbfdsetoff() {
		if (stgcbfdsetoff == null) stgcbfdsetoff = getProperty("mootlywcm:stgcbfdsetoff");
		return stgcbfdsetoff;
	}
	public final void  setStgcbfdsetoff(Double stgcbfdsetoff) {
		this.stgcbfdsetoff = stgcbfdsetoff;
	}

	public  Double getStgcbflus35setoff() {
		if (stgcbflus35setoff == null) stgcbflus35setoff = getProperty("mootlywcm:stgcbflus35setoff");
		return stgcbflus35setoff;
	}
	public final void  setStgcbflus35setoff(Double stgcbflus35setoff) {
		this.stgcbflus35setoff = stgcbflus35setoff;
	}

	public  Double getStgccurrentsetoff() {
		if (stgccurrentsetoff == null) stgccurrentsetoff = getProperty("mootlywcm:stgccurrentsetoff");
		return stgccurrentsetoff;
	}
	public final void  setStgccurrentsetoff(Double stgccurrentsetoff) {
		this.stgccurrentsetoff = stgccurrentsetoff;
	}

	public  Double getLtgcincomesetoff() {
		if (ltgcincomesetoff == null) ltgcincomesetoff = getProperty("mootlywcm:ltgcincomesetoff");
		return ltgcincomesetoff;
	}
	public final void  setLtgcincomesetoff(Double ltgcincomesetoff) {
		this.ltgcincomesetoff = ltgcincomesetoff;
	}

	public  Double getLtgcbflasetoff() {
		if (ltgcbflasetoff == null) ltgcbflasetoff = getProperty("mootlywcm:ltgcbflasetoff");
		return ltgcbflasetoff;
	}
	public final void  setLtgcbflasetoff(Double ltgcbflasetoff) {
		this.ltgcbflasetoff = ltgcbflasetoff;
	}

	public  Double getLtgcbfdsetoff() {
		if (ltgcbfdsetoff == null) ltgcbfdsetoff = getProperty("mootlywcm:ltgcbfdsetoff");
		return ltgcbfdsetoff;
	}
	public final void  setLtgcbfdsetoff(Double ltgcbfdsetoff) {
		this.ltgcbfdsetoff = ltgcbfdsetoff;
	}

	public  Double getLtgcbflus35setoff() {
		if (ltgcbflus35setoff == null) ltgcbflus35setoff = getProperty("mootlywcm:ltgcbflus35setoff");
		return ltgcbflus35setoff;
	}
	public final void  setLtgcbflus35setoff(Double ltgcbflus35setoff) {
		this.ltgcbflus35setoff = ltgcbflus35setoff;
	}

	public  Double getLtgccurrentsetoff() {
		if (ltgccurrentsetoff == null) ltgccurrentsetoff = getProperty("mootlywcm:ltgccurrentsetoff");
		return ltgccurrentsetoff;
	}
	public final void  setLtgccurrentsetoff(Double ltgccurrentsetoff) {
		this.ltgccurrentsetoff = ltgccurrentsetoff;
	}

	public  Double getOtherincomesetoff() {
		if (otherincomesetoff == null) otherincomesetoff = getProperty("mootlywcm:otherincomesetoff");
		return otherincomesetoff;
	}
	public final void  setOtherincomesetoff(Double otherincomesetoff) {
		this.otherincomesetoff = otherincomesetoff;
	}

	public  Double getOtherbflasetoff() {
		if (otherbflasetoff == null) otherbflasetoff = getProperty("mootlywcm:otherbflasetoff");
		return otherbflasetoff;
	}
	public final void  setOtherbflasetoff(Double otherbflasetoff) {
		this.otherbflasetoff = otherbflasetoff;
	}

	public  Double getOtherbfdsetoff() {
		if (otherbfdsetoff == null) otherbfdsetoff = getProperty("mootlywcm:otherbfdsetoff");
		return otherbfdsetoff;
	}
	public final void  setOtherbfdsetoff(Double otherbfdsetoff) {
		this.otherbfdsetoff = otherbfdsetoff;
	}

	public  Double getOtherbflus35setoff() {
		if (otherbflus35setoff == null) otherbflus35setoff = getProperty("mootlywcm:otherbflus35setoff");
		return otherbflus35setoff;
	}
	public final void  setOtherbflus35setoff(Double otherbflus35setoff) {
		this.otherbflus35setoff = otherbflus35setoff;
	}

	public  Double getOthercurrentsetoff() {
		if (othercurrentsetoff == null) othercurrentsetoff = getProperty("mootlywcm:othercurrentsetoff");
		return othercurrentsetoff;
	}
	public final void  setOthercurrentsetoff(Double othercurrentsetoff) {
		this.othercurrentsetoff = othercurrentsetoff;
	}

	public  Double getHorseincomesetoff() {
		if (horseincomesetoff == null) horseincomesetoff = getProperty("mootlywcm:horseincomesetoff");
		return horseincomesetoff;
	}
	public final void  setHorseincomesetoff(Double horseincomesetoff) {
		this.horseincomesetoff = horseincomesetoff;
	}

	public  Double getHorsebflasetoff() {
		if (horsebflasetoff == null) horsebflasetoff = getProperty("mootlywcm:horsebflasetoff");
		return horsebflasetoff;
	}
	public final void  setHorsebflasetoff(Double horsebflasetoff) {
		this.horsebflasetoff = horsebflasetoff;
	}

	public  Double getHorsebfdsetoff() {
		if (horsebfdsetoff == null) horsebfdsetoff = getProperty("mootlywcm:horsebfdsetoff");
		return horsebfdsetoff;
	}
	public final void  setHorsebfdsetoff(Double horsebfdsetoff) {
		this.horsebfdsetoff = horsebfdsetoff;
	}

	public  Double getHorsebflus35setoff() {
		if (horsebflus35setoff == null) horsebflus35setoff = getProperty("mootlywcm:horsebflus35setoff");
		return horsebflus35setoff;
	}
	public final void  setHorsebflus35setoff(Double horsebflus35setoff) {
		this.horsebflus35setoff = horsebflus35setoff;
	}

	public  Double getHorsecurrentsetoff() {
		if (horsecurrentsetoff == null) horsecurrentsetoff = getProperty("mootlywcm:horsecurrentsetoff");
		return horsecurrentsetoff;
	}
	public final void  setHorsecurrentsetoff(Double horsecurrentsetoff) {
		this.horsecurrentsetoff = horsecurrentsetoff;
	}

	public  Double getTotalbflasetoff() {
		if (totalbflasetoff == null) totalbflasetoff = getProperty("mootlywcm:totalbflasetoff");
		return totalbflasetoff;
	}
	public final void  setTotalbflasetoff(Double totalbflasetoff) {
		this.totalbflasetoff = totalbflasetoff;
	}

	public  Double getTotalbfdsetoff() {
		if (totalbfdsetoff == null) totalbfdsetoff = getProperty("mootlywcm:totalbfdsetoff");
		return totalbfdsetoff;
	}
	public final void  setTotalbfdsetoff(Double totalbfdsetoff) {
		this.totalbfdsetoff = totalbfdsetoff;
	}

	public  Double getTotalbflus35setoff() {
		if (totalbflus35setoff == null) totalbflus35setoff = getProperty("mootlywcm:totalbflus35setoff");
		return totalbflus35setoff;
	}
	public final void  setTotalbflus35setoff(Double totalbflus35setoff) {
		this.totalbflus35setoff = totalbflus35setoff;
	}

	public  Double getCurrentsetoff() {
		if (currentsetoff == null) currentsetoff = getProperty("mootlywcm:currentsetoff");
		return currentsetoff;
	}
	public final void  setCurrentsetoff(Double currentsetoff) {
		this.currentsetoff = currentsetoff;
	}

	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		try{

			BroughtFwdLossesDocument broughtFwdLossesDocument= (BroughtFwdLossesDocument) content;
			node.setProperty("mootlywcm:salariesincomesetoff",broughtFwdLossesDocument.getSalariesincomesetoff());
			node.setProperty("mootlywcm:salariescurrentsetoff",broughtFwdLossesDocument.getSalariescurrentsetoff());
			node.setProperty("mootlywcm:hpincomesetoff", broughtFwdLossesDocument.getHpincomesetoff());
			node.setProperty("mootlywcm:hpbflasetoff", broughtFwdLossesDocument.getHpbflasetoff());
			node.setProperty("mootlywcm:hpbfdsetoff", broughtFwdLossesDocument.getHpbfdsetoff());
			node.setProperty("mootlywcm:hpbflus35setoff", broughtFwdLossesDocument.getHpbflus35setoff());
			node.setProperty("mootlywcm:hpcurrentsetoff", broughtFwdLossesDocument.getHpcurrentsetoff());
			node.setProperty("mootlywcm:businessincomesetoff", broughtFwdLossesDocument.getBusinessincomesetoff());
			node.setProperty("mootlywcm:businessbflasetoff", broughtFwdLossesDocument.getBusinessbflasetoff());
			node.setProperty("mootlywcm:businessbfdsetoff", broughtFwdLossesDocument.getBusinessbfdsetoff());
			node.setProperty("mootlywcm:businessbflus35setoff", broughtFwdLossesDocument.getBusinessbflus35setoff());
			node.setProperty("mootlywcm:businesscurrentsetoff", broughtFwdLossesDocument.getBusinesscurrentsetoff());
			node.setProperty("mootlywcm:speculativeincomesetoff", broughtFwdLossesDocument.getSpeculativeincomesetoff());
			node.setProperty("mootlywcm:speculativebflasetoff", broughtFwdLossesDocument.getSpeculativebflasetoff());
			node.setProperty("mootlywcm:speculativebfdsetoff", broughtFwdLossesDocument.getSpeculativebfdsetoff());
			node.setProperty("mootlywcm:speculativebflus35setoff", broughtFwdLossesDocument.getSpeculativebflus35setoff());
			node.setProperty("mootlywcm:speculativecurrentsetoff", broughtFwdLossesDocument.getSpeculativecurrentsetoff());
			node.setProperty("mootlywcm:specifiedincomesetoff", broughtFwdLossesDocument.getSpecifiedincomesetoff());
			node.setProperty("mootlywcm:specifiedbflasetoff", broughtFwdLossesDocument.getSpecifiedbflasetoff());
			node.setProperty("mootlywcm:specifiedbfdsetoff", broughtFwdLossesDocument.getSpecifiedbfdsetoff());
			node.setProperty("mootlywcm:specifiedbflus35setoff", broughtFwdLossesDocument.getSpecifiedbflus35setoff());
			node.setProperty("mootlywcm:specifiedcurrentsetoff", broughtFwdLossesDocument.getSpecifiedcurrentsetoff());
			node.setProperty("mootlywcm:stgcincomesetoff", broughtFwdLossesDocument.getStgcincomesetoff());
			node.setProperty("mootlywcm:stgcbflasetoff", broughtFwdLossesDocument.getStgcbflasetoff());
			node.setProperty("mootlywcm:stgcbfdsetoff", broughtFwdLossesDocument.getStgcbfdsetoff());
			node.setProperty("mootlywcm:stgcbflus35setoff", broughtFwdLossesDocument.getStgcbflus35setoff());
			node.setProperty("mootlywcm:stgccurrentsetoff", broughtFwdLossesDocument.getStgccurrentsetoff());
			node.setProperty("mootlywcm:ltgcincomesetoff", broughtFwdLossesDocument.getLtgcincomesetoff());
			node.setProperty("mootlywcm:ltgcbflasetoff", broughtFwdLossesDocument.getLtgcbflasetoff());
			node.setProperty("mootlywcm:ltgcbfdsetoff",broughtFwdLossesDocument.getLtgcbfdsetoff());
			node.setProperty("mootlywcm:ltgcbflus35setoff", broughtFwdLossesDocument.getLtgcbflus35setoff());
			node.setProperty("mootlywcm:ltgccurrentsetoff", broughtFwdLossesDocument.getLtgccurrentsetoff());
			node.setProperty("mootlywcm:otherincomesetoff", broughtFwdLossesDocument.getOtherincomesetoff());
			node.setProperty("mootlywcm:otherbflasetoff", broughtFwdLossesDocument.getOtherbflasetoff());
			node.setProperty("mootlywcm:otherbfdsetoff", broughtFwdLossesDocument.getOtherbfdsetoff());
			node.setProperty("mootlywcm:otherbflus35setoff", broughtFwdLossesDocument.getOtherbflus35setoff());
			node.setProperty("mootlywcm:othercurrentsetoff", broughtFwdLossesDocument.getOthercurrentsetoff());
			node.setProperty("mootlywcm:horseincomesetoff", broughtFwdLossesDocument.getHorseincomesetoff());
			node.setProperty("mootlywcm:horsebflasetoff", broughtFwdLossesDocument.getHorsebflasetoff());
			node.setProperty("mootlywcm:horsebfdsetoff", broughtFwdLossesDocument.getHorsebfdsetoff());
			node.setProperty("mootlywcm:horsebflus35setoff", broughtFwdLossesDocument.getHorsebflus35setoff());
			node.setProperty("mootlywcm:horsecurrentsetoff", broughtFwdLossesDocument.getHorsecurrentsetoff());
			node.setProperty("mootlywcm:totalbflasetoff", broughtFwdLossesDocument.getTotalbflasetoff());
			node.setProperty("mootlywcm:totalbfdsetoff", broughtFwdLossesDocument.getTotalbfdsetoff());
			node.setProperty("mootlywcm:totalbflus35setoff", broughtFwdLossesDocument.getTotalbflus35setoff());
			node.setProperty("mootlywcm:currentsetoff", broughtFwdLossesDocument.getCurrentsetoff());

		} catch (RepositoryException rex) {
			log.error("Repository Exception while binding",rex);
		}
		return true;
	}
}
