package com.emp.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="h_No")
	private String hNo;
	@Column(name="address_lane1")
	private String addresslane1;
	@Column(name="city")
	private String city;
	@Column(name="pin")
	private Long pin;
	@Column(name="state")
	private String state;
	
	
	
	public Address() {
		
	}
	
	public Address(String hNo, String addresslane1, String city, Long pin, String state) {
		super();
	
		this.hNo = hNo;
		this.addresslane1 = addresslane1;
		this.city = city;
		this.pin = pin;
		this.state = state;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String gethNo() {
		return hNo;
	}
	public void sethNo(String hNo) {
		this.hNo = hNo;
	}
	public String getAddresslane1() {
		return addresslane1;
	}
	public void setAddresslane1(String addresslane1) {
		this.addresslane1 = addresslane1;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Long getPin() {
		return pin;
	}
	public void setPin(Long pin) {
		this.pin = pin;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	 @JoinColumn( name = "emp_id", referencedColumnName = "id")
	
	private Employee employee;

}
