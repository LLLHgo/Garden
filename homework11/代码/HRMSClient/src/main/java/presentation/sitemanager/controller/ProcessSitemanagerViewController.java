package presentation.sitemanager.controller;

import java.util.ArrayList;

import Enum.ResultMessage;
import businesslogicservice.clientblservice.ClientBLService;
import businesslogicservice.clientblservice.ClientBLService_Stub;
import businesslogicservice.hotelinfoblservice.HotelinfoBLService;
import businesslogicservice.hotelinfoblservice.HotelinfoBLService_Stub;
import businesslogicservice.hotelstaffblservice.HotelstaffBLService;
import businesslogicservice.hotelstaffblservice.HotelstaffBLService_Stub;
import businesslogicservice.logblservice.LogBLService;
import businesslogicservice.logblservice.LogBLService_Stub;
import businesslogicservice.marketinblservice.MarketingBLService;
import businesslogicservice.marketinblservice.MarketingBLService_Stub;
import businesslogicservice.sitemanagerblservice.SitemanagerBLService;
import businesslogicservice.sitemanagerblservice.SitemanagerBLService_Stub;
import presentation.sitemanager.view.ProcessClientAccountManageView;
import presentation.sitemanager.view.ProcessHotelAccountManageView;
import presentation.sitemanager.view.ProcessMarketingAccountManageView;
import presentation.sitemanager.view.ProcessShowLogView;
import presentation.sitemanager.view.ProcessSitemanagerView;
import presentation.sitemanager.view.ProcessSitemanagerViewControllerService;
import presentation.sitemanager.view.ProcessSitemanagerAccountManageView;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.SitemanagerAddVO;
import vo.hotelstaffVO.HotelstaffVO;
import vo.logVO.LogVO;
import vo.marketingVO.MarketingVO;
import vo.sitemanager.SitemanagerVO;

public class ProcessSitemanagerViewController implements ProcessSitemanagerViewControllerService {
	
	String sitemanagerId;
	SitemanagerVO sitemanagerVO;
	ClientVO clientVO;
	private ProcessSitemanagerView processSitemanagerView;
	private ProcessSitemanagerAccountManageView sitemanagerAccountManageView;
	private ProcessMarketingAccountManageView marketingAccountManageView;
	private ProcessClientAccountManageView clientAccountManageView;
	private ProcessHotelAccountManageView hotelAccountManageView;
	private ProcessShowLogView showLogView;
	
	SitemanagerBLService sitemanagerblservice; // 以stub调用
	MarketingBLService marketingblservice; // 以stub调用
	ClientBLService clientblservice; // 以stub调用
	HotelstaffBLService hotelstaffblservice;// 以stub调用
	HotelinfoBLService hotelblservice; // 以stub调用
	LogBLService logblservice; // 以stub调用
	 
	public ProcessSitemanagerViewController(String sitemanagerId){
		this.sitemanagerId=sitemanagerId;
		sitemanagerblservice=new SitemanagerBLService_Stub();
		marketingblservice=new MarketingBLService_Stub();
		clientblservice=new ClientBLService_Stub();
		hotelblservice=new HotelinfoBLService_Stub();
		hotelstaffblservice=new HotelstaffBLService_Stub();
		logblservice=new LogBLService_Stub();
		sitemanagerVO=init();
	}
	
	
	public String getSitemanagerId(){
		return sitemanagerId;
	}
	public void setView(ProcessSitemanagerView view) {
		this.processSitemanagerView=view;
		
		sitemanagerAccountManageView=new ProcessSitemanagerAccountManageView(this,processSitemanagerView,sitemanagerVO);
		sitemanagerAccountManageView.setVisible(false);
		marketingAccountManageView=new ProcessMarketingAccountManageView(this,processSitemanagerView);
		marketingAccountManageView.setVisible(false);
		clientAccountManageView=new ProcessClientAccountManageView(this,processSitemanagerView);
		clientAccountManageView.setVisible(false);
		hotelAccountManageView=new ProcessHotelAccountManageView(this,processSitemanagerView);
		hotelAccountManageView.setVisible(false);
		showLogView=new ProcessShowLogView(this,processSitemanagerView);
		showLogView.setVisible(false);
	}
	
	public SitemanagerVO init() {
		sitemanagerVO= sitemanagerblservice.sitemanagerAcountShow();
		return sitemanagerVO;
	}

	public ResultMessage clientAccountUpdate(ClientVO clientVO) {
		return clientblservice.updateInfo(clientVO);
	}

	public ResultMessage clientAccountDelete(String userId) {
		return clientblservice.saveSitemanagerDelete(userId);
	}
	public ResultMessage marketingAccountDelete(MarketingVO vo){
		return marketingblservice.MarketingAccountDelete(vo);
	}
	

	public ClientVO clientAccountFind(String id) {
		return clientblservice.getclient(id);
	}

	
	public ResultMessage MarketingAccountAdd(MarketingVO marketingVO) {
		return marketingblservice.MarketingAccountAdd(marketingVO);
	}


	public ResultMessage MarketingAccountUpdate(MarketingVO marketingVO) {
		return marketingblservice.MarketingAccountUpdate(marketingVO);
	}

	public MarketingVO MarketingAccountFind(String findInfo) {
		return marketingblservice.MarketingAccountFind(findInfo);
	}

	public ResultMessage MarketingAccountAdd(HotelinfoVO hotelinfo) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage HotelAccountAdd(SitemanagerAddVO sitemanagerAddVO, HotelstaffVO hotelstaffVO) {
		return hotelblservice.saveSitemanagerAdd(sitemanagerAddVO,hotelstaffVO);
	}

	@Override
	public HotelstaffVO HotelStaffAccountFind(String id) {
		return hotelstaffblservice.returnSitemanagerAccount(id);
	}

	@Override
	public ResultMessage HotelStaffAccountUpdate(HotelstaffVO hotelstaffVO) {
		return hotelstaffblservice.saveSitemanagerUpdate(hotelstaffVO);
	}

	@Override
	public SitemanagerVO sitemanagerAcountShow() {
		return sitemanagerblservice.sitemanagerAcountShow();
	}

	@Override
	public ResultMessage sitemanagerAccountUpdate(SitemanagerVO accountVO) {
		return sitemanagerblservice.sitemanagerAccountUpdatePO(accountVO);
	}

	@Override
	public ResultMessage checkAccount(SitemanagerVO accountVO) {
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<LogVO> findLog(String year,String month,String day) {
		return logblservice.getLog(year,month,day);
	}

	@Override
	public ResultMessage addLog(String logInfo) {
		return logblservice.addLog(logInfo);
	}
	
	@Override
	public void jbSitemanagerManageButtonClicked(){
		processSitemanagerView.hideWelcome();
		marketingAccountManageView.setVisible(false);
		clientAccountManageView.setVisible(false);
		hotelAccountManageView.setVisible(false);
		showLogView.setVisible(false);
		sitemanagerAccountManageView.setVisible(true);
	}


	@Override
	public void jbMarketingManageButtonClicked() {
		processSitemanagerView.hideWelcome();
		sitemanagerAccountManageView.setVisible(false);
		clientAccountManageView.setVisible(false);
		hotelAccountManageView.setVisible(false);
		showLogView.setVisible(false);
		marketingAccountManageView.setVisible(true);
		
	}
	
	public void jbClientManageButtonClicked(){
		processSitemanagerView.hideWelcome();
		sitemanagerAccountManageView.setVisible(false);
		marketingAccountManageView.setVisible(false);
		hotelAccountManageView.setVisible(false);
		showLogView.setVisible(false);
		clientAccountManageView.setVisible(true);
	}


	public void jbExitButtonClicked() {
		System.exit(0);
	}


	@Override
	public void jbHotelManageButtonClicked() {
		processSitemanagerView.hideWelcome();
		sitemanagerAccountManageView.setVisible(false);
		marketingAccountManageView.setVisible(false);
		clientAccountManageView.setVisible(false);
		showLogView.setVisible(false);
		hotelAccountManageView.setVisible(true);
		
	}


	@Override
	public void jbShowLogButtonClicked() {
		processSitemanagerView.hideWelcome();
		sitemanagerAccountManageView.setVisible(false);
		marketingAccountManageView.setVisible(false);
		clientAccountManageView.setVisible(false);
		hotelAccountManageView.setVisible(false);
		showLogView.setVisible(true);
		
	}
	
	

}
