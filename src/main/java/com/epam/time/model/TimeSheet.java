package com.epam.time.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class TimeSheet {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int projectId;
	private int empId;
	

}
