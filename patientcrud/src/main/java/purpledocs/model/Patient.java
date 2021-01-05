package purpledocs.model;

import java.util.Date;

public class Patient {
	
	private int patient_id;
	private String patient_name;
	private int patient_age;
	private String description;
	private Date creation_ts;
	private Date updation_ts;

	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	public String getPatient_name() {
		return patient_name;
	}

	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}

	public int getPatient_age() {
		return patient_age;
	}

	public void setPatient_age(int patient_age) {
		this.patient_age = patient_age;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreation_ts() {
		return creation_ts;
	}

	public void setCreation_ts(Date creation_ts) {
		this.creation_ts = creation_ts;
	}

	public Date getUpdation_ts() {
		return updation_ts;
	}

	public void setUpdation_ts(Date updation_ts) {
		this.updation_ts = updation_ts;
	}

}
