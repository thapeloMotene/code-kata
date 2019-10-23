package codekata.models;

public class AddressType {
	int code;
	String name ="";
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
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
		return "AddressType [code=" + code + ", name=" + name + "]";
	}
	
	
}
