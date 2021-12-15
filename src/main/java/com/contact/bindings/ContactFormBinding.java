package com.contact.bindings;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ContactFormBinding {
	//In java we are following single responsibility principle.
	//This class capture the data from the form and transfer to backend.
	
	private Integer contactId;
	private String contactName;
	private String contactEmail;
	private long phoneNo;
	private String activeSw;
	private LocalDate createdDate;
	private LocalDate updatedDate;
	public Integer getContactId() {
		return contactId;
	}
	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getActiveSw() {
		return activeSw;
	}
	public void setActiveSw(String activeSw) {
		this.activeSw = activeSw;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDate getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}
	@Override
	public String toString() {
		return "ContactFormBinding [contactId=" + contactId + ", contactName=" + contactName + ", contactEmail="
				+ contactEmail + ", phoneNo=" + phoneNo + ", activeSw=" + activeSw + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + "]";
	}

	
	
	
}
