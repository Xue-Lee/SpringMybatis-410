package com.icss.entity;

import java.sql.Timestamp;
import java.util.List;

public class BookOrders {
	private Integer orderId;
	private Integer orderClient;
	private Timestamp orderDate;
	private String address;
	private Float money;
	private String tel;
	private String other;
	private Integer state;
	private String admin;
	private Timestamp acceptDate;
	private Timestamp sendDate;
	private List<BookOrderDetail> details;
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getOrderClient() {
		return orderClient;
	}
	public void setOrderClient(Integer orderClient) {
		this.orderClient = orderClient;
	}
	public Timestamp getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Float getMoney() {
		return money;
	}
	public void setMoney(Float money) {
		this.money = money;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public Timestamp getAcceptDate() {
		return acceptDate;
	}
	public void setAcceptDate(Timestamp acceptDate) {
		this.acceptDate = acceptDate;
	}
	public Timestamp getSendDate() {
		return sendDate;
	}
	public void setSendDate(Timestamp sendDate) {
		this.sendDate = sendDate;
	}
	public List<BookOrderDetail> getDetails() {
		return details;
	}
	public void setDetails(List<BookOrderDetail> details) {
		this.details = details;
	}

}
