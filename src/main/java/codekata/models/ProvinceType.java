package codekata.models;

public class ProvinceType {
	String code ="";
	String name ="";
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		return "ProvinceType [code=" + code + ", name=" + name + "]";
	}
	
	
	

}
