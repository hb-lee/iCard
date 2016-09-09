package com.easypay.icard.entity;

public class CardInfo {

	private int id;
	private int userId;
	private int businessId;
	private String balance;
	private int credit;
	private String number;
	private int type;
	/**
	 * @author lihbbruce
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @author lihbbruce
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @author lihbbruce
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @author lihbbruce
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @author lihbbruce
	 * @return the businessId
	 */
	public int getBusinessId() {
		return businessId;
	}
	/**
	 * @author lihbbruce
	 * @param businessId the businessId to set
	 */
	public void setBusinessId(int businessId) {
		this.businessId = businessId;
	}
	/**
	 * @author lihbbruce
	 * @return the balance
	 */
	public String getBalance() {
		return balance;
	}
	/**
	 * @author lihbbruce
	 * @param balance the balance to set
	 */
	public void setBalance(String balance) {
		this.balance = balance;
	}
	/**
	 * @author lihbbruce
	 * @return the credit
	 */
	public int getCredit() {
		return credit;
	}
	/**
	 * @author lihbbruce
	 * @param credit the credit to set
	 */
	public void setCredit(int credit) {
		this.credit = credit;
	}
	/**
	 * @author lihbbruce
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}
	/**
	 * @author lihbbruce
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	/**
	 * @author lihbbruce
	 * @return the type
	 */
	public int getType() {
		return type;
	}
	/**
	 * @author lihbbruce
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}
}
