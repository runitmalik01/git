package com.mootly.wcm.model.schedules.y2013_2014;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import in.gov.incometaxindiaefiling.y2012_2013.ITR;
import in.gov.incometaxindiaefiling.y2012_2013.PARTAQD;
import in.gov.incometaxindiaefiling.y2012_2013.PARTAQD.ManfactrConcern;
import in.gov.incometaxindiaefiling.y2012_2013.PARTAQD.ManfactrConcern.FinishrByProd;
import in.gov.incometaxindiaefiling.y2012_2013.PARTAQD.ManfactrConcern.RawMaterial;
import in.gov.incometaxindiaefiling.y2012_2013.PARTAQD.TradingConcern;
import in.gov.incometaxindiaefiling.y2012_2013.QuantitDet;

import com.mootly.wcm.beans.ManufactureFinishedProductsDocument;
import com.mootly.wcm.beans.ManufactureRawMatDocument;
import com.mootly.wcm.beans.QuantitativeUnitDocument;
import com.mootly.wcm.beans.compound.ManufactureFinishedGoodsDetail;
import com.mootly.wcm.beans.compound.ManufactureRawMatDetail;
import com.mootly.wcm.beans.compound.QuantitativeUnitDetail;
import com.mootly.wcm.services.IndianCurrencyHelper;

public class PartA_QD {

	QuantitativeUnitDocument quantitativeUnitDocument = null;
	ManufactureRawMatDocument manufactureRawMatDocument = null;
	ManufactureFinishedProductsDocument manufactureFinishedProductsDocument= null;

	public PartA_QD(QuantitativeUnitDocument quantitativeUnitDocument, ManufactureRawMatDocument manufactureRawMatDocument,
			ManufactureFinishedProductsDocument manufactureFinishedProductsDocument){
		this.quantitativeUnitDocument = quantitativeUnitDocument;
		this.manufactureRawMatDocument = manufactureRawMatDocument;
		this.manufactureFinishedProductsDocument = manufactureFinishedProductsDocument;
	}

	public PARTAQD getPARTAQD(ITR itr){

		PARTAQD pARTAQD = new PARTAQD();
		TradingConcern tradingConcern = new TradingConcern();
		ManfactrConcern manfactrConcern = new ManfactrConcern();
		RawMaterial rawMaterial = new RawMaterial();
		FinishrByProd finishrByProd = new FinishrByProd();
		IndianCurrencyHelper indianCurrencyHelper = new IndianCurrencyHelper();
		boolean hasAValidQD = false;

		if(quantitativeUnitDocument != null){
			List<QuantitativeUnitDetail> quantitativeUnitDetails = quantitativeUnitDocument.getQuantitativeUnitDetailList();
			if ( quantitativeUnitDetails != null && quantitativeUnitDetails.size() > 0 ){
				for (QuantitativeUnitDetail quantitativeUnitDetail:quantitativeUnitDetails)  {
					QuantitDet QuantitDet = new QuantitDet();
					QuantitDet.setItemName(quantitativeUnitDetail.getItem_Name());
					QuantitDet.setUnitOfMeasure(quantitativeUnitDetail.getItemUnit_Code());
					QuantitDet.setOpeningStock(indianCurrencyHelper.bigIntegerRoundStr(quantitativeUnitDetail.getOpening_Stock()));
					QuantitDet.setPurchaseQty(indianCurrencyHelper.bigIntegerRoundStr(quantitativeUnitDetail.getPurchage()));
					QuantitDet.setSaleQty(indianCurrencyHelper.bigIntegerRoundStr(quantitativeUnitDetail.getSales_Qty()));
					QuantitDet.setClgStock(indianCurrencyHelper.bigIntegerRoundStr(quantitativeUnitDetail.getClosing_Stock()));
					QuantitDet.setAnyShortExces(Long.parseLong(quantitativeUnitDetail.getShortage_IfAny()));
					tradingConcern.getQuantitDet().add(QuantitDet);
					pARTAQD.setTradingConcern(tradingConcern);
					if(!hasAValidQD) hasAValidQD = true;
				}
			}
		}
		if(manufactureRawMatDocument != null){
			List<ManufactureRawMatDetail> manufactureRawMatDetails = manufactureRawMatDocument.getManufacture_RawMatDetailList();
			if ( manufactureRawMatDetails != null && manufactureRawMatDetails.size() > 0 ){
				for (ManufactureRawMatDetail manufactureRawMatDetail:manufactureRawMatDetails)  {
					QuantitDet quantitDet = new QuantitDet();
					quantitDet.setItemName(manufactureRawMatDetail.getItem_Name());
					quantitDet.setUnitOfMeasure(manufactureRawMatDetail.getItemUnit_Code());
					quantitDet.setOpeningStock(indianCurrencyHelper.bigIntegerRoundStr(manufactureRawMatDetail.getOpening_Stock()));
					quantitDet.setPurchaseQty(indianCurrencyHelper.bigIntegerRoundStr(manufactureRawMatDetail.getPurchage()));
					if(!(manufactureRawMatDetail.getConsumption().isEmpty())){
						quantitDet.setPrevYrConsum(indianCurrencyHelper.bigIntegerRoundStr(manufactureRawMatDetail.getConsumption()));
					}else
						quantitDet.setPrevYrConsum(new BigInteger("0"));
					if(!(manufactureRawMatDetail.getSales().isEmpty())){
						quantitDet.setSaleQty(indianCurrencyHelper.bigIntegerRoundStr(manufactureRawMatDetail.getSales()));
					}else
						quantitDet.setSaleQty(new BigInteger("0"));
					quantitDet.setClgStock(indianCurrencyHelper.bigIntegerRoundStr(manufactureRawMatDetail.getClosing_Stock()));
					if(!(manufactureRawMatDetail.getYield_finishedProd().isEmpty())){
						quantitDet.setYldFinisProd(indianCurrencyHelper.bigIntegerRoundStr(manufactureRawMatDetail.getYield_finishedProd()));
					}else
						quantitDet.setYldFinisProd(new BigInteger("0"));
					if(!(manufactureRawMatDetail.getPercentage_Yield().isEmpty())){
						quantitDet.setPercentYld(new BigDecimal(manufactureRawMatDetail.getPercentage_Yield()));
					}else
						quantitDet.setPercentYld(new BigDecimal("0"));
					quantitDet.setAnyShortExces(Long.parseLong(manufactureRawMatDetail.getShortage_IfAny()));
					rawMaterial.getQuantitDet().add(quantitDet);
					manfactrConcern.setRawMaterial(rawMaterial);
					pARTAQD.setManfactrConcern(manfactrConcern);
					if(!hasAValidQD) hasAValidQD = true;
				}
			}
		}
		if(manufactureFinishedProductsDocument != null){
			List<ManufactureFinishedGoodsDetail> manufactureFinishedGoodsDetails = manufactureFinishedProductsDocument.getManufactureFinishedGoodsDetailList();
			if ( manufactureFinishedGoodsDetails != null && manufactureFinishedGoodsDetails.size() > 0 ){
				for (ManufactureFinishedGoodsDetail manufactureFinishedGoodsDetail:manufactureFinishedGoodsDetails){
					QuantitDet quantitDet = new QuantitDet();
					quantitDet.setItemName(manufactureFinishedGoodsDetail.getItem_Name());
					quantitDet.setUnitOfMeasure(manufactureFinishedGoodsDetail.getItemUnit_Code());
					quantitDet.setOpeningStock(indianCurrencyHelper.bigIntegerRoundStr(manufactureFinishedGoodsDetail.getOpening_Stock()));
					quantitDet.setPurchaseQty(indianCurrencyHelper.bigIntegerRoundStr(manufactureFinishedGoodsDetail.getPurchage()));
					if(!(manufactureFinishedGoodsDetail.getFinished_Goods().isEmpty())){
						quantitDet.setPrevyrManfact(indianCurrencyHelper.bigIntegerRoundStr(manufactureFinishedGoodsDetail.getFinished_Goods()));
					}else
						quantitDet.setPrevyrManfact(new BigInteger("0"));
					quantitDet.setSaleQty(indianCurrencyHelper.bigIntegerRoundStr(manufactureFinishedGoodsDetail.getSales_Qty()));
					quantitDet.setClgStock(indianCurrencyHelper.bigIntegerRoundStr(manufactureFinishedGoodsDetail.getClosing_Stock()));
					quantitDet.setAnyShortExces(Long.parseLong(manufactureFinishedGoodsDetail.getShortage_IfAny()));
					finishrByProd.getQuantitDet().add(quantitDet);
					manfactrConcern.setFinishrByProd(finishrByProd);
					pARTAQD.setManfactrConcern(manfactrConcern);
					if(!hasAValidQD) hasAValidQD = true;
				}
			}
		}

		if(hasAValidQD){
			return pARTAQD;
		}else
			return null;
	}
}
