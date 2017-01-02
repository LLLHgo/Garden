package presentation.sitemanager.controller;

import java.util.ArrayList;

import Enum.ResultMessage;
import businesslogic.clientbl.ClientManage;
import businesslogic.hoteinfobl.Hotelinfo;
import businesslogic.hotelstaffbl.HotelstaffManage;
import businesslogic.logbl.LogManage;
import businesslogic.marketingbl.MarketingManage;
import businesslogic.sitemanagerbl.SitemanagerManage;
import businesslogicservice.clientblservice.ClientBLService;
import businesslogicservice.hotelinfoblservice.HotelinfoBLService;
import businesslogicservice.hotelstaffblservice.HotelstaffBLService;
import businesslogicservice.logblservice.LogBLService;
import businesslogicservice.marketinblservice.MarketingBLService;
import businesslogicservice.sitemanagerblservice.SitemanagerBLService;
import presentation.sitemanager.view.ProcessClientAccountManageView;
import presentation.sitemanager.view.ProcessHotelAccountManageView;
import presentation.sitemanager.view.ProcessMarketingAccountManageView;
import presentation.sitemanager.view.ProcessShowLogView;
import presentation.sitemanager.view.ProcessSitemanagerAccountManageView;
import presentation.sitemanager.view.ProcessSitemanagerView;
import presentation.sitemanager.view.ProcessSitemanagerViewControllerService;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.SitemanagerAddVO;
import vo.hotelstaffVO.HotelstaffVO;
import vo.logVO.LogVO;
import vo.marketingVO.MarketingVO;
import vo.sitemanagerVO.SitemanagerVO;
/**
 * sitemanager模块的controller
 * @author yilu
 *
 */
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

	SitemanagerBLService sitemanagerblservice; 
	MarketingBLService marketingblservice; 
	ClientBLService clientblservice; 
	HotelstaffBLService hotelstaffblservice;
	HotelinfoBLService hotelblservice; 
	LogBLService logblservice; 

	public ProcessSitemanagerViewController(String sitemanagerId){
		this.sitemanagerId=sitemanagerId;

		sitemanagerblservice=new SitemanagerManage();
		marketingblservice=new MarketingManage();

		marketingblservice=new MarketingManage();
		clientblservice=new ClientManage();
		hotelblservice=new Hotelinfo();
		hotelstaffblservice=new HotelstaffManage();
		logblservice=new LogManage();
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
    // 初始化sitemanager界面类
	public SitemanagerVO init() {
		sitemanagerVO= sitemanagerblservice.sitemanagerAcountShow();
		return sitemanagerVO;
	}
	// 更新客户账户
	@Override
	public ResultMessage clientAccountUpdate(ClientVO clientVO) {
		return clientblservice.updateInfo(clientVO);
	}
	// 删除客户账户
	@Override
	public ResultMessage clientAccountDelete(String userId) {
		return clientblservice.saveSitemanagerDelete(userId);
	}
	// 删除网站营销人员账户
	@Override
	public ResultMessage marketingAccountDelete(MarketingVO vo){
		return marketingblservice.MarketingAccountDelete(vo);
	}
	// 查找客户账户
	@Override
	public ClientVO clientAccountFind(String id) {
		return clientblservice.getclient(id);
	}
	// 添加网站营销人员账户
	@Override
	public ResultMessage MarketingAccountAdd(MarketingVO marketingVO) {
		return marketingblservice.MarketingAccountAdd(marketingVO);
	}
	// 更新网站营销人员账户
	@Override
	public ResultMessage MarketingAccountUpdate(MarketingVO marketingVO) {
		return marketingblservice.MarketingAccountUpdate(marketingVO);
	}
	// 查找网站营销人员账户
	@Override
	public MarketingVO MarketingAccountFind(String findInfo) {
		return marketingblservice.MarketingAccountFind(findInfo);
	}
    // 添加酒店账户
	@Override
	public ResultMessage HotelAccountAdd(SitemanagerAddVO sitemanagerAddVO, HotelstaffVO hotelstaffVO) {
		return hotelblservice.saveSitemanagerAdd(sitemanagerAddVO,hotelstaffVO);
	}
	// 查找酒店工作人员账户
	@Override
	public HotelstaffVO HotelStaffAccountFind(String id) {
		return hotelstaffblservice.returnSitemanagerAccount(id);
	}
	// 查找酒店账户
	@Override
	public HotelinfoVO HotelinfoAccountFind(String hotelId){
		return hotelblservice.getBasicinfo(hotelId);
	}
	// 更新酒店工作人员账户
	@Override
	public ResultMessage HotelStaffAccountUpdate(HotelstaffVO hotelstaffVO) {
		return hotelstaffblservice.saveSitemanagerUpdate(hotelstaffVO);
	}
    // 显示网站管理人员账户
	@Override
	public SitemanagerVO sitemanagerAcountShow() {
		return sitemanagerblservice.sitemanagerAcountShow();
	}
	// 更新网站管理人员账户
	@Override
	public ResultMessage sitemanagerAccountUpdate(SitemanagerVO accountVO) {
		return sitemanagerblservice.sitemanagerAccountUpdatePO(accountVO);
	}

	// 查找具体日期的日志
	@Override
	public ArrayList<LogVO> findLog(String year,String month,String day) {
		return logblservice.getLog(year,month,day);
	}
	// 添加日志
	@Override
	public ResultMessage addLog(String logInfo) {
		return logblservice.addLog(logInfo);
	}
	// 进入网站管理人员账户管理
	@Override
	public void jbSitemanagerManageButtonClicked(){
		processSitemanagerView.hideWelcome();
		marketingAccountManageView.setVisible(false);
		clientAccountManageView.setVisible(false);
		hotelAccountManageView.setVisible(false);
		showLogView.setVisible(false);
		sitemanagerAccountManageView.setVisible(true);
	}

	// 进入网站营销人员账户管理
	@Override
	public void jbMarketingManageButtonClicked() {
		processSitemanagerView.hideWelcome();
		sitemanagerAccountManageView.setVisible(false);
		clientAccountManageView.setVisible(false);
		hotelAccountManageView.setVisible(false);
		showLogView.setVisible(false);
		marketingAccountManageView.setVisible(true);

	}
	// 进入客户账户管理
	public void jbClientManageButtonClicked(){
		processSitemanagerView.hideWelcome();
		sitemanagerAccountManageView.setVisible(false);
		marketingAccountManageView.setVisible(false);
		hotelAccountManageView.setVisible(false);
		showLogView.setVisible(false);
		clientAccountManageView.setVisible(true);
	}

	// 退出当前账户
	@Override
	public void jbExitButtonClicked() {
		System.exit(0);
	}

	// 进入酒店账户管理
	@Override
	public void jbHotelManageButtonClicked() {
		processSitemanagerView.hideWelcome();
		sitemanagerAccountManageView.setVisible(false);
		marketingAccountManageView.setVisible(false);
		clientAccountManageView.setVisible(false);
		showLogView.setVisible(false);
		hotelAccountManageView.setVisible(true);

	}

	// 进入查看日志界面
	@Override
	public void jbShowLogButtonClicked() {
		processSitemanagerView.hideWelcome();
		sitemanagerAccountManageView.setVisible(false);
		marketingAccountManageView.setVisible(false);
		clientAccountManageView.setVisible(false);
		hotelAccountManageView.setVisible(false);
		showLogView.setVisible(true);

	}


	@Override
	public String getMarketingID() {	
		return marketingblservice.getMarketingID();
		//return null;
	}


	@Override
	public String getHotelID() {
		// TODO Auto-generated method stub
		return hotelstaffblservice.getNewAddHotelID();
	}

}
