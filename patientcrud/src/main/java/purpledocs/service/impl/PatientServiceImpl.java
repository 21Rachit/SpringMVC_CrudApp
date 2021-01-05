package purpledocs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import purpledocs.dao.PatientDAO;
import purpledocs.model.Patient;
import purpledocs.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientDAO patientDao;

	@Override
	public Patient getPatientById(int id) {
		return patientDao.getPatientById(id);
	}

	@Override
	public void saveOrUpdatePatient(Patient p) {
	   patientDao.saveOrUpdatePatient(p);
	}

	@Override
	public int deletePatient(int id) {
		return patientDao.deletePatient(id);
	}

	@Override
	public List<Patient> findAll() {
		return patientDao.findAll();
	}
	
	
}
