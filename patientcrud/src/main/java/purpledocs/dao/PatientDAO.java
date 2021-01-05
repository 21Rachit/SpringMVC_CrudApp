package purpledocs.dao;

import java.util.List;

import purpledocs.model.Patient;

public interface PatientDAO {
	public Patient getPatientById(int id);

	public void saveOrUpdatePatient(Patient patient);

	public int deletePatient(int id);

	public List<Patient> findAll();

}
