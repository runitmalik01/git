package com.mootly.wcm.beans;

import javax.jcr.RepositoryException;

import org.hippoecm.hst.component.support.forms.FormMap;
import org.hippoecm.hst.content.beans.ContentNodeBinder;
import org.hippoecm.hst.content.beans.ContentNodeBindingException;
import org.hippoecm.hst.content.beans.Node;
import org.hippoecm.hst.content.beans.standard.HippoBean;

import com.mootly.wcm.beans.standard.FlexibleDocument;
import com.mootly.wcm.model.FilingSection;
import com.mootly.wcm.model.FinancialYear;

/**
 * 
 * @author BEN-10
 * 
 * */

@SuppressWarnings("unused")
@Node(jcrType = "mootlywcm:balancesheetdocument")
public class BalanceSheetDocument extends FlexibleDocument implements ContentNodeBinder,FormMapFiller {
	static final public String NAMESPACE = "mootlywcm:balancesheetdocument";
	static final public String NODE_NAME = "balancesheetdocument";

	private Double propCapital;
	private Double reavReserve;
	private Double capReserve;
	private Double statReserve;
	private Double otherReserve;
	private Double grossProprietFund;
	private Double grossLoanFund;
	
	private Double forgnCurrLoan;
	private Double rupLoanBank;
	private Double rupLoanOther;
	private Double unsecLoanBank;
	private Double unsecLoanOther;
	private Double defTaxLiability;
	private Double sourcOfFund;
	
	private Double grossBlock;
	private Double depreciation;
	private Double capWorkProgrss;
	private Double grossFixedAsset;
	
	private Double ltInvestQuot;
	private Double ltInvestUnquot;
	private Double stInvestEquity;
	private Double stInvestPrefShare;
	private Double stInvestDebent;
	private Double grossInvest;
	
	private Double storesConsum;
	private Double rawMaterial;
	private Double stockProcess;
	private Double finishGoods;
	private Double sundryDebtor;
	private Double cashInHand;
	private Double balanceBank;
	private Double otherCurrAsset;
	private Double grossCurrAssets;
	
	private Double advancRecover;
	private Double advancRecover1;
	private Double loanAdvanCorpOthr;
	private Double balWthRevenAuth;
	private Double grossCurrAssLoanAdvan;

	private Double sundryCreditor ;
	private Double laibLeaseAsset ;
	private Double unpaidDividnd ;
	private Double unpaidMatdebntur;
	private Double unpaidCallMoney;
	private Double interestAcuurOnabove;
	private Double interestAcuurNtLoan;
	private Double grossCurrLiability;

	private Double incometaxProvis;
	private Double wealthTaxProvis;
	private Double leaveProvis;
	private Double otherProvis;
	private Double grossProvision;
	
	private Double grossCurrLaibilProvison;
	private Double netCurrAssets;
	private Double miscellanExpend;
	private Double deftaxAssets;
	private Double profLoassAccn;
	private Double grossAppliFund;
	
	private Double totalSundryDebtor;
	private Double totalSundryCreditor;
	private Double totalStockTrade;
	private Double cashBalance;
	

	public Double getPropCapital() {
		if(propCapital == null) propCapital = getProperty("mootlywcm:propCapital"); 
		return propCapital;
	}

	public void setPropCapital(Double propCapital) {
		this.propCapital = propCapital;
	}

	public Double getReavReserve() {
		if(reavReserve == null) reavReserve = getProperty("mootlywcm:reavReserve");
		return reavReserve;
	}

	public void setReavReserve(Double reavReserve) {
		this.reavReserve = reavReserve;
	}

	public Double getCapReserve() {
		if(capReserve == null) capReserve = getProperty("mootlywcm:capReserve");
		return capReserve;
	}

	public void setCapReserve(Double capReserve) {
		this.capReserve = capReserve;
	}

	public Double getStatReserve() {
		if(statReserve == null) statReserve = getProperty("mootlywcm:statReserve");
		return statReserve;
	}

	public void setStatReserve(Double statReserve) {
		this.statReserve = statReserve;
	}

	public Double getOtherReserve() {
		if(otherReserve == null) otherReserve = getProperty("mootlywcm:otherReserve");
		return otherReserve;
	}

	public void setOtherReserve(Double otherReserve) {
		this.otherReserve = otherReserve;
	}

	public Double getForgnCurrLoan() {
		if(forgnCurrLoan == null) forgnCurrLoan = getProperty("mootlywcm:forgnCurrLoan");
		return forgnCurrLoan;
	}

	public void setForgnCurrLoan(Double forgnCurrLoan) {		
		this.forgnCurrLoan = forgnCurrLoan;
	}

	public Double getRupLoanBank() {
		if(rupLoanBank == null) rupLoanBank = getProperty("mootlywcm:rupLoanBank");
		return rupLoanBank;
	}

	public void setRupLoanBank(Double rupLoanBank) {
		this.rupLoanBank = rupLoanBank;
	}

	public Double getRupLoanOther() {
		if(rupLoanOther == null) rupLoanOther = getProperty("mootlywcm:rupLoanOther");
		return rupLoanOther;
	}

	public void setRupLoanOther(Double rupLoanOther) {
		this.rupLoanOther = rupLoanOther;
	}

	@Override
	public boolean bind(Object content, javax.jcr.Node node)
			throws ContentNodeBindingException {
		// TODO Auto-generated method stub
		super.bindToNode(node);
		try {
			BalanceSheetDocument bsd = (BalanceSheetDocument) content;
			
			node.setProperty("mootlywcm:advancRecover", bsd.getAdvancRecover());
			node.setProperty("mootlywcm:balanceBank", bsd.getBalanceBank());
			node.setProperty("mootlywcm:balWthRevenAuth", bsd.getBalWthRevenAuth());
			node.setProperty("mootlywcm:capReserve", bsd.getCapReserve());
			node.setProperty("mootlywcm:capWorkProgrss", bsd.getCapWorkProgrss());
			node.setProperty("mootlywcm:cashInHand", bsd.getCashInHand());
			node.setProperty("mootlywcm:deftaxAssets", bsd.getDeftaxAssets());
			node.setProperty("mootlywcm:defTaxLiability", bsd.getDefTaxLiability());
			node.setProperty("mootlywcm:depreciation", bsd.getDepreciation());
			
			node.setProperty("mootlywcm:finishGoods", bsd.getFinishGoods());
			node.setProperty("mootlywcm:forgnCurrLoan", bsd.getForgnCurrLoan());
			node.setProperty("mootlywcm:grossAppliFund", bsd.getGrossAppliFund());
			node.setProperty("mootlywcm:grossBlock", bsd.getGrossBlock());
			
			node.setProperty("mootlywcm:grossCurrAssets", bsd.getGrossCurrAssets());
			node.setProperty("mootlywcm:grossCurrAssLoanAdvan", bsd.getGrossCurrAssLoanAdvan());
			node.setProperty("mootlywcm:grossCurrLaibilProvison", bsd.getGrossCurrLaibilProvison());
			node.setProperty("mootlywcm:grossCurrLiability", bsd.getGrossCurrLiability());
			node.setProperty("mootlywcm:grossFixedAsset", bsd.getGrossFixedAsset());
			
			node.setProperty("mootlywcm:grossInvest", bsd.getGrossInvest());
			node.setProperty("mootlywcm:grossProvision", bsd.getGrossProvision());
			node.setProperty("mootlywcm:incometaxProvis", bsd.getIncometaxProvis());
			node.setProperty("mootlywcm:interestAcuurNtLoan", bsd.getInterestAcuurNtLoan());
			node.setProperty("mootlywcm:interestAcuurOnabove", bsd.getInterestAcuurOnabove());
			node.setProperty("mootlywcm:laibLeaseAsset", bsd.getLaibLeaseAsset());
			node.setProperty("mootlywcm:leaveProvis", bsd.getLeaveProvis());
			node.setProperty("mootlywcm:loanAdvanCorpOthr", bsd.getLoanAdvanCorpOthr());
			node.setProperty("mootlywcm:ltInvestQuot", bsd.getLtInvestQuot());
			node.setProperty("mootlywcm:ltInvestUnquot", bsd.getLtInvestUnquot());
			node.setProperty("mootlywcm:miscellanExpend", bsd.getMiscellanExpend());
			node.setProperty("mootlywcm:netCurrAssets", bsd.getNetCurrAssets());
			node.setProperty("mootlywcm:otherCurrAsset", bsd.getOtherCurrAsset());
			
			node.setProperty("mootlywcm:otherReserve", bsd.getOtherReserve());
			node.setProperty("mootlywcm:profLoassAccn", bsd.getProfLoassAccn());
			node.setProperty("mootlywcm:propCapital", bsd.getPropCapital());
			node.setProperty("mootlywcm:rawMaterial", bsd.getRawMaterial());
			node.setProperty("mootlywcm:reavReserve", bsd.getReavReserve());
			
			node.setProperty("mootlywcm:rupLoanBank", bsd.getRupLoanBank());
			node.setProperty("mootlywcm:rupLoanOther", bsd.getRupLoanOther());
			node.setProperty("mootlywcm:sourcOfFund", bsd.getSourcOfFund());
			node.setProperty("mootlywcm:statReserve", bsd.getStatReserve());
			node.setProperty("mootlywcm:stInvestDebent", bsd.getStInvestDebent());
			
			node.setProperty("mootlywcm:stInvestEquity", bsd.getStInvestEquity());
			node.setProperty("mootlywcm:stInvestPrefShare", bsd.getStInvestPrefShare());
			node.setProperty("mootlywcm:stockProcess", bsd.getStockProcess());
			node.setProperty("mootlywcm:storesConsum", bsd.getStoresConsum());
			node.setProperty("mootlywcm:sundryCreditor", bsd.getSundryCreditor());
			node.setProperty("mootlywcm:sundryDebtor", bsd.getSundryDebtor());
			node.setProperty("mootlywcm:unpaidCallMoney", bsd.getUnpaidCallMoney());
			
			node.setProperty("mootlywcm:unpaidDividnd", bsd.getUnpaidDividnd());
			node.setProperty("mootlywcm:unpaidMatdebntur", bsd.getUnpaidMatdebntur());
			node.setProperty("mootlywcm:unsecLoanBank", bsd.getUnsecLoanBank());
			node.setProperty("mootlywcm:unsecLoanOther", bsd.getUnsecLoanOther());
			node.setProperty("mootlywcm:wealthTaxProvis", bsd.getWealthTaxProvis());
			node.setProperty("mootlywcm:grossProprietFund", bsd.getGrossProprietFund());
			node.setProperty("mootlywcm:grossLoanFund", bsd.getGrossLoanFund());
			
			node.setProperty("mootlywcm:totalStockTrade", bsd.getTotalStockTrade());
			node.setProperty("mootlywcm:totalSundryCreditor", bsd.getTotalSundryCreditor());
			node.setProperty("mootlywcm:totalSundryDebtor", bsd.getTotalSundryDebtor());
			node.setProperty("mootlywcm:cashBalance", bsd.getCashBalance());
		}catch (RepositoryException re) {
			log.error("Binding Node Error",re);

		}
		return true;
	}

	@Override
	public void fill(FormMap formMap) {
		// TODO Auto-generated method stub
		super.fill(formMap);
		if (log.isInfoEnabled()) {
			log.info("Into the fill method");
		}
		if (formMap == null) return;
		if(formMap.getField("advancRecover")!=null) setAdvancRecover(Double.parseDouble(formMap.getField("advancRecover").getValue()));
		if(formMap.getField("balanceBank")!=null) setBalanceBank(Double.parseDouble(formMap.getField("balanceBank").getValue()));
		if(formMap.getField("balWthRevenAuth")!=null) setBalWthRevenAuth(Double.parseDouble(formMap.getField("balWthRevenAuth").getValue()));
		if(formMap.getField("capReserve")!=null) setCapReserve(Double.parseDouble(formMap.getField("capReserve").getValue()));
		if(formMap.getField("capWorkProgrss")!=null) setCapWorkProgrss(Double.parseDouble(formMap.getField("capWorkProgrss").getValue()));
		if(formMap.getField("cashBalance")!=null) setCashBalance(Double.parseDouble(formMap.getField("cashBalance").getValue()));
		if(formMap.getField("cashInHand")!=null) setCashInHand(Double.parseDouble(formMap.getField("cashInHand").getValue()));
		if(formMap.getField("deftaxAssets")!=null) setDeftaxAssets(Double.parseDouble(formMap.getField("deftaxAssets").getValue()));
		if(formMap.getField("defTaxLiability")!=null) setDefTaxLiability(Double.parseDouble(formMap.getField("defTaxLiability").getValue()));
		if(formMap.getField("depreciation")!=null) setDepreciation(Double.parseDouble(formMap.getField("depreciation").getValue()));
		if(formMap.getField("finishGoods")!=null) setFinishGoods(Double.parseDouble(formMap.getField("finishGoods").getValue()));
		if(formMap.getField("forgnCurrLoan")!=null) setForgnCurrLoan(Double.parseDouble(formMap.getField("forgnCurrLoan").getValue()));
		if(formMap.getField("grossAppliFund")!=null) setGrossAppliFund(Double.parseDouble(formMap.getField("grossAppliFund").getValue()));
		if(formMap.getField("grossBlock")!=null) setGrossBlock(Double.parseDouble(formMap.getField("grossBlock").getValue()));
		if(formMap.getField("grossCurrAssets")!=null) setGrossCurrAssets(Double.parseDouble(formMap.getField("grossCurrAssets").getValue()));
		if(formMap.getField("grossCurrAssLoanAdvan")!=null) setGrossCurrAssLoanAdvan(Double.parseDouble(formMap.getField("grossCurrAssLoanAdvan").getValue()));
		if(formMap.getField("grossCurrLaibilProvison")!=null) setGrossCurrLaibilProvison(Double.parseDouble(formMap.getField("grossCurrLaibilProvison").getValue()));
		if(formMap.getField("grossCurrLiability")!=null) setGrossCurrLiability(Double.parseDouble(formMap.getField("grossCurrLiability").getValue()));
		if(formMap.getField("grossFixedAsset")!=null) setGrossFixedAsset(Double.parseDouble(formMap.getField("grossFixedAsset").getValue()));
		if(formMap.getField("grossInvest")!=null) setGrossInvest(Double.parseDouble(formMap.getField("grossInvest").getValue()));
		if(formMap.getField("grossLoanFund")!=null) setGrossLoanFund(Double.parseDouble(formMap.getField("grossLoanFund").getValue()));
		
		if(formMap.getField("grossProprietFund")!=null) setGrossProprietFund(Double.parseDouble(formMap.getField("grossProprietFund").getValue()));
		if(formMap.getField("grossProvision")!=null) setGrossProvision(Double.parseDouble(formMap.getField("grossProvision").getValue()));
		if(formMap.getField("incometaxProvis")!=null) setIncometaxProvis(Double.parseDouble(formMap.getField("incometaxProvis").getValue()));
		if(formMap.getField("interestAcuurNtLoan")!=null) setInterestAcuurNtLoan(Double.parseDouble(formMap.getField("interestAcuurNtLoan").getValue()));
		if(formMap.getField("interestAcuurOnabove")!=null) setInterestAcuurOnabove(Double.parseDouble(formMap.getField("interestAcuurOnabove").getValue()));
		if(formMap.getField("laibLeaseAsset")!=null) setLaibLeaseAsset(Double.parseDouble(formMap.getField("laibLeaseAsset").getValue()));
		if(formMap.getField("leaveProvis")!=null) setLeaveProvis(Double.parseDouble(formMap.getField("leaveProvis").getValue()));
		if(formMap.getField("loanAdvanCorpOthr")!=null) setLoanAdvanCorpOthr(Double.parseDouble(formMap.getField("loanAdvanCorpOthr").getValue()));
		if(formMap.getField("ltInvestQuot")!=null) setLtInvestQuot(Double.parseDouble(formMap.getField("ltInvestQuot").getValue()));
		if(formMap.getField("ltInvestUnquot")!=null) setLtInvestUnquot(Double.parseDouble(formMap.getField("ltInvestUnquot").getValue()));
		
		if(formMap.getField("miscellanExpend")!=null) setMiscellanExpend(Double.parseDouble(formMap.getField("miscellanExpend").getValue()));
		if(formMap.getField("netCurrAssets")!=null) setNetCurrAssets(Double.parseDouble(formMap.getField("netCurrAssets").getValue()));
		if(formMap.getField("otherCurrAsset")!=null) setOtherCurrAsset(Double.parseDouble(formMap.getField("otherCurrAsset").getValue()));
		if(formMap.getField("otherProvis")!=null) setOtherProvis(Double.parseDouble(formMap.getField("otherProvis").getValue()));
		
		if(formMap.getField("otherReserve")!=null) setOtherReserve(Double.parseDouble(formMap.getField("otherReserve").getValue()));
		if(formMap.getField("profLoassAccn")!=null) setProfLoassAccn(Double.parseDouble(formMap.getField("profLoassAccn").getValue()));
		if(formMap.getField("propCapital")!=null) setPropCapital(Double.parseDouble(formMap.getField("propCapital").getValue()));
		if(formMap.getField("rawMaterial")!=null) setRawMaterial(Double.parseDouble(formMap.getField("rawMaterial").getValue()));
		if(formMap.getField("reavReserve")!=null) setReavReserve(Double.parseDouble(formMap.getField("reavReserve").getValue()));
		
		if(formMap.getField("rupLoanBank")!=null) setRupLoanBank(Double.parseDouble(formMap.getField("rupLoanBank").getValue()));
		if(formMap.getField("rupLoanOther")!=null) setRupLoanOther(Double.parseDouble(formMap.getField("rupLoanOther").getValue()));
		if(formMap.getField("sourcOfFund")!=null) setSourcOfFund(Double.parseDouble(formMap.getField("sourcOfFund").getValue()));
		if(formMap.getField("statReserve")!=null) setStatReserve(Double.parseDouble(formMap.getField("statReserve").getValue()));
		if(formMap.getField("stInvestDebent")!=null) setStInvestDebent(Double.parseDouble(formMap.getField("stInvestDebent").getValue()));
		if(formMap.getField("stInvestEquity")!=null) setStInvestEquity(Double.parseDouble(formMap.getField("stInvestEquity").getValue()));
		if(formMap.getField("stInvestPrefShare")!=null) setStInvestPrefShare(Double.parseDouble(formMap.getField("stInvestPrefShare").getValue()));
		if(formMap.getField("stockProcess")!=null) setStockProcess(Double.parseDouble(formMap.getField("stockProcess").getValue()));
		
		if(formMap.getField("storesConsum")!=null) setStoresConsum(Double.parseDouble(formMap.getField("storesConsum").getValue()));
		if(formMap.getField("sundryCreditor")!=null) setSundryCreditor(Double.parseDouble(formMap.getField("sundryCreditor").getValue()));
		if(formMap.getField("sundryDebtor")!=null) setSundryDebtor(Double.parseDouble(formMap.getField("sundryDebtor").getValue()));
		if(formMap.getField("totalStockTrade")!=null) setTotalStockTrade(Double.parseDouble(formMap.getField("totalStockTrade").getValue()));
		
		if(formMap.getField("totalSundryCreditor")!=null) setTotalSundryCreditor(Double.parseDouble(formMap.getField("totalSundryCreditor").getValue()));
		if(formMap.getField("totalSundryDebtor")!=null) setTotalSundryDebtor(Double.parseDouble(formMap.getField("totalSundryDebtor").getValue()));
		if(formMap.getField("unpaidCallMoney")!=null) setUnpaidCallMoney(Double.parseDouble(formMap.getField("unpaidCallMoney").getValue()));
			
		if(formMap.getField("unpaidDividnd")!=null) setUnpaidDividnd(Double.parseDouble(formMap.getField("unpaidDividnd").getValue()));
		if(formMap.getField("unpaidMatdebntur")!=null) setUnpaidMatdebntur(Double.parseDouble(formMap.getField("unpaidMatdebntur").getValue()));
		if(formMap.getField("unsecLoanBank")!=null) setUnsecLoanBank(Double.parseDouble(formMap.getField("unsecLoanBank").getValue()));
		if(formMap.getField("unsecLoanOther")!=null) setUnsecLoanOther(Double.parseDouble(formMap.getField("unsecLoanOther").getValue()));
		if(formMap.getField("wealthTaxProvis")!=null) setWealthTaxProvis(Double.parseDouble(formMap.getField("wealthTaxProvis").getValue()));
	}
	@Override
	public <T extends HippoBean> void cloneBean(T sourceBean) {
		// TODO Auto-generated method stub

	}

	public Double getUnsecLoanBank() {
		if(unsecLoanBank == null) unsecLoanBank = getProperty("mootlywcm:unsecLoanBank");
		return unsecLoanBank;
	}

	public void setUnsecLoanBank(Double unsecLoanBank) {
		this.unsecLoanBank = unsecLoanBank;
	}

	public Double getUnsecLoanOther() {
		if(unsecLoanOther == null) unsecLoanOther = getProperty("mootlywcm:unsecLoanOther");
		return unsecLoanOther;
	}

	public void setUnsecLoanOther(Double unsecLoanOther) {
		this.unsecLoanOther = unsecLoanOther;
	}

	public Double getDefTaxLiability() {
		if(defTaxLiability == null) defTaxLiability = getProperty("mootlywcm:defTaxLiability");
		return defTaxLiability;
	}

	public void setDefTaxLiability(Double defTaxLiability) {
		this.defTaxLiability = defTaxLiability;
	}

	public Double getSourcOfFund() {
		if(sourcOfFund == null) sourcOfFund = getProperty("mootlywcm:sourcOfFund");
		return sourcOfFund;
	}

	public void setSourcOfFund(Double sourcOfFund) {
		this.sourcOfFund = sourcOfFund;
	}

	public Double getGrossBlock() {
		if(grossBlock == null) grossBlock = getProperty("mootlywcm:grossBlock");
		return grossBlock;
	}

	public void setGrossBlock(Double grossBlock) {
		this.grossBlock = grossBlock;
	}

	public Double getDepreciation() {
		if(depreciation == null) depreciation = getProperty("mootlywcm:depreciation");
		return depreciation;
	}

	public void setDepreciation(Double depreciation) {
		this.depreciation = depreciation;
	}

	public Double getCapWorkProgrss() {
		if(capWorkProgrss == null) capWorkProgrss = getProperty("mootlywcm:capWorkProgrss");
		return capWorkProgrss;
	}

	public void setCapWorkProgrss(Double capWorkProgrss) {
		this.capWorkProgrss = capWorkProgrss;
	}

	public Double getGrossFixedAsset() {
		if(grossFixedAsset == null) grossFixedAsset = getProperty("mootlywcm:grossFixedAsset");
		return grossFixedAsset;
	}

	public void setGrossFixedAsset(Double grossFixedAsset) {
		this.grossFixedAsset = grossFixedAsset;
	}

	public Double getLtInvestQuot() {
		if(ltInvestQuot == null) ltInvestQuot = getProperty("mootlywcm:ltInvestQuot");
		return ltInvestQuot;
	}

	public void setLtInvestQuot(Double ltInvestQuot) {
		this.ltInvestQuot = ltInvestQuot;
	}

	public Double getLtInvestUnquot() {
		if(ltInvestUnquot == null) ltInvestUnquot = getProperty("mootlywcm:ltInvestUnquot");
		return ltInvestUnquot;
	}

	public void setLtInvestUnquot(Double ltInvestUnquot) {
		this.ltInvestUnquot = ltInvestUnquot;
	}

	public Double getStInvestEquity() {
		if(stInvestEquity == null) stInvestEquity = getProperty("mootlywcm:stInvestEquity");
		return stInvestEquity;
	}

	public void setStInvestEquity(Double stInvestEquity) {
		this.stInvestEquity = stInvestEquity;
	}

	public Double getStInvestPrefShare() {
		if(stInvestPrefShare == null) stInvestPrefShare = getProperty("mootlywcm:stInvestPrefShare");
		return stInvestPrefShare;
	}

	public void setStInvestPrefShare(Double stInvestPrefShare) {
		this.stInvestPrefShare = stInvestPrefShare;
	}

	public Double getStInvestDebent() {
		if(stInvestDebent == null) stInvestDebent = getProperty("mootlywcm:stInvestDebent");
		return stInvestDebent;
	}

	public void setStInvestDebent(Double stInvestDebent) {
		this.stInvestDebent = stInvestDebent;
	}

	public Double getGrossInvest() {
		if(grossInvest == null) grossInvest = getProperty("mootlywcm:grossInvest");
		return grossInvest;
	}

	public void setGrossInvest(Double grossInvest) {
		this.grossInvest = grossInvest;
	}

	public Double getStoresConsum() {
		if(storesConsum == null) storesConsum = getProperty("mootlywcm:storesConsum");
		return storesConsum;
	}

	public void setStoresConsum(Double storesConsum) {
		this.storesConsum = storesConsum;
	}

	public Double getRawMaterial() {
		if(rawMaterial == null) rawMaterial = getProperty("mootlywcm:rawMaterial");
		return rawMaterial;
	}

	public void setRawMaterial(Double rawMaterial) {		
		this.rawMaterial = rawMaterial;
	}

	public Double getStockProcess() {
		if(stockProcess == null) stockProcess = getProperty("mootlywcm:stockProcess");
		return stockProcess;
	}

	public void setStockProcess(Double stockProcess) {
		this.stockProcess = stockProcess;
	}

	public Double getFinishGoods() {
		if(finishGoods == null) finishGoods = getProperty("mootlywcm:finishGoods");
		return finishGoods;
	}

	public void setFinishGoods(Double finishGoods) {
		this.finishGoods = finishGoods;
	}

	public Double getSundryDebtor() {
		if(sundryDebtor == null) sundryDebtor = getProperty("mootlywcm:sundryDebtor");
		return sundryDebtor;
	}

	public void setSundryDebtor(Double sundryDebtor) {
		this.sundryDebtor = sundryDebtor;
	}

	public Double getCashInHand() {
		if(cashInHand == null) cashInHand = getProperty("mootlywcm:cashInHand");
		return cashInHand;
	}

	public void setCashInHand(Double cashInHand) {
		this.cashInHand = cashInHand;
	}

	public Double getBalanceBank() {
		if(balanceBank == null) balanceBank = getProperty("mootlywcm:balanceBank");
		return balanceBank;
	}

	public void setBalanceBank(Double balanceBank) {
		this.balanceBank = balanceBank;
	}

	public Double getOtherCurrAsset() {
		if(otherCurrAsset == null) otherCurrAsset = getProperty("mootlywcm:otherCurrAsset");
		return otherCurrAsset;
	}

	public void setOtherCurrAsset(Double otherCurrAsset) {
		this.otherCurrAsset = otherCurrAsset;
	}

	public Double getGrossCurrAssets() {
		if(grossCurrAssets == null) grossCurrAssets = getProperty("mootlywcm:grossCurrAssets");
		return grossCurrAssets;
	}

	public void setGrossCurrAssets(Double grossCurrAssets) {
		this.grossCurrAssets = grossCurrAssets;
	}

	public Double getAdvancRecover() {
		if(advancRecover == null) advancRecover = getProperty("mootlywcm:advancRecover");
		return advancRecover;
	}

	public void setAdvancRecover(Double advancRecover) {
		this.advancRecover = advancRecover;
	}

	public Double getLoanAdvanCorpOthr() {
		if(loanAdvanCorpOthr == null) loanAdvanCorpOthr = getProperty("mootlywcm:loanAdvanCorpOthr");
		return loanAdvanCorpOthr;
	}

	public void setLoanAdvanCorpOthr(Double loanAdvanCorpOthr) {
		this.loanAdvanCorpOthr = loanAdvanCorpOthr;
	}

	public Double getBalWthRevenAuth() {
		if(balWthRevenAuth == null) balWthRevenAuth = getProperty("mootlywcm:balWthRevenAuth");
		return balWthRevenAuth;
	}

	public void setBalWthRevenAuth(Double balWthRevenAuth) {
		this.balWthRevenAuth = balWthRevenAuth;
	}

	public Double getGrossCurrAssLoanAdvan() {
		if(grossCurrAssLoanAdvan == null) grossCurrAssLoanAdvan = getProperty("mootlywcm:grossCurrAssLoanAdvan");
		return grossCurrAssLoanAdvan;
	}

	public void setGrossCurrAssLoanAdvan(Double grossCurrAssLoanAdvan) {
		this.grossCurrAssLoanAdvan = grossCurrAssLoanAdvan;
	}

	public Double getSundryCreditor() {
		if(sundryCreditor == null) sundryCreditor = getProperty("mootlywcm:sundryCreditor");
		return sundryCreditor;
	}

	public void setSundryCreditor(Double sundryCreditor) {
		this.sundryCreditor = sundryCreditor;
	}

	public Double getLaibLeaseAsset() {
		if(laibLeaseAsset == null) laibLeaseAsset = getProperty("mootlywcm:laibLeaseAsset");
		return laibLeaseAsset;
	}

	public void setLaibLeaseAsset(Double laibLeaseAsset) {
		this.laibLeaseAsset = laibLeaseAsset;
	}

	public Double getUnpaidDividnd() {
		if(unpaidDividnd == null) unpaidDividnd = getProperty("mootlywcm:unpaidDividnd");
		return unpaidDividnd;
	}

	public void setUnpaidDividnd(Double unpaidDividnd) {
		this.unpaidDividnd = unpaidDividnd;
	}

	public Double getUnpaidMatdebntur() {
		if(unpaidMatdebntur == null) unpaidMatdebntur = getProperty("mootlywcm:unpaidMatdebntur");
		return unpaidMatdebntur;
	}

	public void setUnpaidMatdebntur(Double unpaidMatdebntur) {
		this.unpaidMatdebntur = unpaidMatdebntur;
	}

	public Double getUnpaidCallMoney() {
		if(unpaidCallMoney == null) unpaidCallMoney = getProperty("mootlywcm:unpaidCallMoney");
		return unpaidCallMoney;
	}

	public void setUnpaidCallMoney(Double unpaidCallMoney) {
		this.unpaidCallMoney = unpaidCallMoney;
	}

	public Double getInterestAcuurOnabove() {
		if(interestAcuurOnabove == null) interestAcuurOnabove = getProperty("mootlywcm:interestAcuurOnabove");
		return interestAcuurOnabove;
	}

	public void setInterestAcuurOnabove(Double interestAcuurOnabove) {
		this.interestAcuurOnabove = interestAcuurOnabove;
	}

	public Double getInterestAcuurNtLoan() {
		if(interestAcuurNtLoan == null) interestAcuurNtLoan = getProperty("mootlywcm:interestAcuurNtLoan");
		return interestAcuurNtLoan;
	}

	public void setInterestAcuurNtLoan(Double interestAcuurNtLoan) {
		this.interestAcuurNtLoan = interestAcuurNtLoan;
	}

	public Double getGrossCurrLiability() {
		if(grossCurrLiability == null) grossCurrLiability = getProperty("mootlywcm:grossCurrLiability");
		return grossCurrLiability;
	}

	public void setGrossCurrLiability(Double grossCurrLiability) {
		this.grossCurrLiability = grossCurrLiability;
	}

	public Double getIncometaxProvis() {
		if(incometaxProvis == null) incometaxProvis = getProperty("mootlywcm:incometaxProvis");
		return incometaxProvis;
	}

	public void setIncometaxProvis(Double incometaxProvis) {
		this.incometaxProvis = incometaxProvis;
	}

	public Double getWealthTaxProvis() {
		if(wealthTaxProvis == null) wealthTaxProvis = getProperty("mootlywcm:wealthTaxProvis");
		return wealthTaxProvis;
	}

	public void setWealthTaxProvis(Double wealthTaxProvis) {
		this.wealthTaxProvis = wealthTaxProvis;
	}

	public Double getLeaveProvis() {
		if(leaveProvis == null) leaveProvis = getProperty("mootlywcm:leaveProvis");
		return leaveProvis;
	}

	public void setLeaveProvis(Double leaveProvis) {
		this.leaveProvis = leaveProvis;
	}

	public Double getOtherProvis() {
		if(otherProvis == null) otherProvis = getProperty("mootlywcm:otherProvis");
		return otherProvis;
	}

	public void setOtherProvis(Double otherProvis) {
		this.otherProvis = otherProvis;
	}

	public Double getGrossProvision() {
		if(grossProvision == null) grossProvision = getProperty("mootlywcm:grossProvision");
		return grossProvision;
	}

	public void setGrossProvision(Double grossProvision) {
		this.grossProvision = grossProvision;
	}

	public Double getGrossCurrLaibilProvison() {
		if(grossCurrLaibilProvison == null) grossCurrLaibilProvison = getProperty("mootlywcm:grossCurrLaibilProvison");
		return grossCurrLaibilProvison;
	}

	public void setGrossCurrLaibilProvison(Double grossCurrLaibilProvison) {
		this.grossCurrLaibilProvison = grossCurrLaibilProvison;
	}

	public Double getNetCurrAssets() {
		if(netCurrAssets == null) netCurrAssets = getProperty("mootlywcm:netCurrAssets");
		return netCurrAssets;
	}

	public void setNetCurrAssets(Double netCurrAssets) {
		this.netCurrAssets = netCurrAssets;
	}

	public Double getMiscellanExpend() {
		if(miscellanExpend == null) miscellanExpend = getProperty("mootlywcm:miscellanExpend");
		return miscellanExpend;
	}

	public void setMiscellanExpend(Double miscellanExpend) {
		this.miscellanExpend = miscellanExpend;
	}

	public Double getDeftaxAssets() {
		if(deftaxAssets == null) deftaxAssets = getProperty("mootlywcm:deftaxAssets");
		return deftaxAssets;
	}

	public void setDeftaxAssets(Double deftaxAssets) {
		this.deftaxAssets = deftaxAssets;
	}

	public Double getProfLoassAccn() {
		if(profLoassAccn == null) profLoassAccn = getProperty("mootlywcm:profLoassAccn");
		return profLoassAccn;
	}

	public void setProfLoassAccn(Double profLoassAccn) {
		this.profLoassAccn = profLoassAccn;
	}

	public Double getGrossAppliFund() {
		if(grossAppliFund == null) grossAppliFund = getProperty("mootlywcm:grossAppliFund");
		return grossAppliFund;
	}

	public void setGrossAppliFund(Double grossAppliFund) {
		this.grossAppliFund = grossAppliFund;
	}

	public Double getGrossLoanFund() {
		if(grossLoanFund == null) grossLoanFund = getProperty("mootlywcm:grossLoanFund");
		return grossLoanFund;
	}

	public void setGrossLoanFund(Double grossLoanFund) {
		this.grossLoanFund = grossLoanFund;
	}

	public Double getGrossProprietFund() {
		if(grossProprietFund == null) grossProprietFund = getProperty("mootlywcm:grossProprietFund");
		return grossProprietFund;
	}

	public void setGrossProprietFund(Double grossProprietFund) {
		this.grossProprietFund = grossProprietFund;
	}

	public Double getTotalSundryDebtor() {
		if(totalSundryDebtor == null) totalSundryDebtor = getProperty("mootlywcm:totalSundryDebtor");
		return totalSundryDebtor;
	}

	public void setTotalSundryDebtor(Double totalSundryDebtor) {
		this.totalSundryDebtor = totalSundryDebtor;
	}

	public Double getTotalSundryCreditor() {
		if(totalSundryCreditor == null) totalSundryCreditor = getProperty("mootlywcm:totalSundryCreditor");
		return totalSundryCreditor;
	}

	public void setTotalSundryCreditor(Double totalSundryCreditor) {
		this.totalSundryCreditor = totalSundryCreditor;
	}

	public Double getTotalStockTrade() {
		if(totalStockTrade == null) totalStockTrade = getProperty("mootlywcm:totalStockTrade");
		return totalStockTrade;
	}

	public void setTotalStockTrade(Double totalStockTrade) {
		this.totalStockTrade = totalStockTrade;
	}

	public Double getCashBalance() {
		if(cashBalance == null) cashBalance = getProperty("mootlywcm:cashBalance");
		return cashBalance;
	}

	public void setCashBalance(Double cashBalance) {
		this.cashBalance = cashBalance;
	}
}