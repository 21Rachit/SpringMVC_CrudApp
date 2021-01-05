package purpledocs.service;

import java.util.List;

import purpledocs.model.Patient;

public interface PatientService {

	public Patient getPatientById(int id);

	public void saveOrUpdatePatient(Patient p);

	public int deletePatient(int id);

	public List<Patient> findAll();
}
