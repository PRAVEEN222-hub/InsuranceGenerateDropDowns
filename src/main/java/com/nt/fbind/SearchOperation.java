package com.nt.fbind;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class SearchOperation {
	
	private String userName;
	private String planName;
	private String planStatus;
	private String gender;
	private String startDate;
	private String endDate;
	

}
