package codekata.models;

import java.util.Date;

public class Address {
	int id;
	AddressLineDetail addressLineDetail;
	ProvinceType provinceOrState;
	String cityOrTown;
	CountryType country;
	AddressType type;
	String postalCode;
	Date lastUpdated;
	
	
	
	@Override
	public String toString() {
		return "Address [id=" + id + ", addressLineDetail=" + addressLineDetail + ", provinceOrState=" + provinceOrState
				+ ", cityOrTown=" + cityOrTown + ", country=" + country + ", type=" + type + ", postalCode="
				+ postalCode + ", lastUpdated=" + lastUpdated + "]";
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public AddressLineDetail getAddressLineDetail() {
		return addressLineDetail;
	}
	public void setAddressLineDetail(AddressLineDetail addressLineDetail) {
		this.addressLineDetail = addressLineDetail;
	}
	public ProvinceType getProvinceOrState() {
		return provinceOrState;
	}
	public void setProvinceOrState(ProvinceType provinceOrState) {
		this.provinceOrState = provinceOrState;
	}
	public String getCityOrTown() {
		return cityOrTown;
	}
	public void setCityOrTown(String cityOrTown) {
		this.cityOrTown = cityOrTown;
	}
	public CountryType getCountry() {
		return country;
	}
	public void setCountry(CountryType country) {
		this.country = country;
	}
	public AddressType getType() {
		return type;
	}
	public void setType(AddressType type) {
		this.type = type;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	
	
}

