package codekata.models;

import java.util.ArrayList;
import java.util.List;

public class ValidationResult {
	
	Boolean isValid;
	List<String> issues = new ArrayList<String>();
	
	
	public Boolean getIsValid() {
		return isValid;
	}
	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}
	public List<String> getIssues() {
		return issues;
	}
	public void setIssues(List<String> issues) {
		this.issues = issues;
	}
	
	

}
