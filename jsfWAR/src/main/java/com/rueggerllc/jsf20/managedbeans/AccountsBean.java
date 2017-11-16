package com.rueggerllc.jsf20.managedbeans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;

import org.apache.log4j.Logger;

import com.rueggerllc.jsf20.beans.Account;
import com.rueggerllc.jsf20.utils.Constants;
import com.rueggerllc.jsf20.utils.ErrorUtils;


@ManagedBean(name="accountsBean")
@SessionScoped
@SuppressWarnings("serial")
public class AccountsBean extends BaseBean {

	private static Logger logger = Logger.getLogger(AccountsBean.class);
	public List<Account> accounts;
	
	public static final String NULL_ACCOUNT_SELECT_LABEL = "Make a Selection";
	public static final String NULL_ACCOUNT_SELECT_VAL = null;
	private Map<String,Account> accountMap;
	private Map<String,String> accountSelectMap;
	private String chosenAccountID = null;
	private Account chosenAccount;
	private boolean continueDisabled = true;
	private BigDecimal fundingAmount;
	
	@PostConstruct
	private void init() {
	}
	
	public String getInitialView() throws Exception {
		logger.info("AccountsBean Initial View Begin");
		if (fundingAmount == null) {
			// fundingAmount = new BigDecimal(53.22);
			fundingAmount = BigDecimal.valueOf(53.22);
			fundingAmount = fundingAmount.setScale(2, BigDecimal.ROUND_UP);
			logger.info("Funding Amount=" + fundingAmount);
		} 
		
		
		chosenAccount = null;
		
		accounts = new ArrayList<Account>();
		for (int i = 0; i < 3; i++) {
			Account account = new Account();
			account.setName("Account"+ i);
			account.setAddress(i + " Main Street");
			account.setStatus(100+i);
			accounts.add(account);
		}
		
		if (accountSelectMap == null) {
			accountSelectMap = new LinkedHashMap<String,String>();
			accountSelectMap.put(NULL_ACCOUNT_SELECT_LABEL, NULL_ACCOUNT_SELECT_VAL);
			for (Account account : accounts) {
				accountSelectMap.put(account.getName(), account.getName());
			}
		}
		
		// Done
		return null;
	}
	
	public List<Account> getAccounts() {
		return accounts;
	}
	
	public boolean getRenderAccountSelection() {
		return true;
	}
	
	public void badMethod(int y) {
		try {
			int x = 33;
			System.out.println(y>10?"yes":"no");
		} catch (Exception e) {
			
		}
	}
	
	
	public void accountSelectedAJAXEvent(AjaxBehaviorEvent event) throws Exception {
		logger.info("Account Selected BEGIN");
		try {
			if (chosenAccountID == NULL_ACCOUNT_SELECT_VAL) {
				logger.info("Select Account was chosen");
				return;
			}
			logger.info("Chosen AccountID=" + chosenAccountID);
			continueDisabled = false;
			return;
			
		} catch (Exception e) {
			logger.error("ERROR in AJAX Event Handler: accountSelectAjaxEvent");
			ErrorUtils.raiseErrorState(getRequest(), getResponse(), Constants.ERROR_SYSTEM_DOWN);
		}
	}
	
	
	public boolean getContinueDisabled() {
		return continueDisabled;
	}
	
	public Account getChosenAccount() {
		return chosenAccount;
	}
	
	public void setChosenAccount(Account account) {
		this.chosenAccount = account;
	}
	
	public String doContinue() {
		logger.info("---- SUBMIT BEGIN---");
		return "page1";
	}

	public BigDecimal getFundingAmount() {
		return fundingAmount;
	}

	public void setFundingAmount(BigDecimal fundingAmount) {
		this.fundingAmount = fundingAmount;
	}

	public Map<String, String> getAccountSelectMap() {
		return accountSelectMap;
	}

	public String getChosenAccountID() {
		return chosenAccountID;
	}

	public void setChosenAccountID(String chosenAccountID) {
		this.chosenAccountID = chosenAccountID;
	}
	
	

}
