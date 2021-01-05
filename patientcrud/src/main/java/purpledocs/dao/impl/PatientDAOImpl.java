package purpledocs.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import purpledocs.dao.PatientDAO;
import purpledocs.dao.mapper.PatientMapper;
import purpledocs.model.Patient;

//@Repository
@Component
public class PatientDAOImpl implements PatientDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
//	@Autowired
//	private Environment environment;

	@Override
	public void saveOrUpdatePatient(Patient patient) {

		String query;
		// String query = environment.getProperty("add_patient");
		if (patient.getPatient_id() > 0) {
			query = "UPDATE patient SET Patient_Name=?, Patient_Age=?, description=?, Creation_Ts=?, Updation_Ts=? WHERE Patient_id=?";
			jdbcTemplate.update(query, patient.getPatient_name(), patient.getPatient_age(), patient.getDescription(),
					patient.getCreation_ts(), patient.getUpdation_ts(), patient.getPatient_id());
		} else {
			query = "INSERT INTO patient (`Patient_id`, `Patient_Name`, `Patient_Age`, `description`, `Creation_Ts`, `Updation_Ts`) VALUES (?, ?, ?, ?, ?, ?)";

			jdbcTemplate.update(query, patient.getPatient_id(), patient.getPatient_name(), patient.getPatient_age(),
					patient.getDescription(), patient.getCreation_ts(), patient.getUpdation_ts());
		}
	}

	@Override
	public Patient getPatientById(int id) {
		// String query = environment.getProperty("get_patient_by_id");
		String query = "SELECT * FROM patient WHERE patient_id = " + id;
		Patient patient = jdbcTemplate.queryForObject(query, new PatientMapper());

//		try {
//			pat = jdbcTemplate.queryForObject(query, new PatientMapper());
//		} catch (EmptyResultDataAccessException emptyResult) {
//			emptyResult.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		return patient;
	}

//	@Override
//	public int updatePatient(Patient patient) {
//		int status = -1;
//		
//		//String query = environment.getProperty("update_patient");
//		String query = "UPDATE patient p SET p.Patient_Name = ?, p.Patient_Age = ?, p.description = ?, p.Creation_Ts = ?, p.Updation_Ts = ? where p.Patient_id = ?;";
//		try {
//			status = jdbcTemplate.update(query, patient.getPatient_name(), patient.getPatient_age(),
//					patient.getDescription(), patient.getCreation_ts(), patient.getUpdation_ts(),
//					patient.getPatient_id());
//		} catch (DataAccessException dae) {
//			dae.printStackTrace();
//		}
//		
//		return status;
//	}

	@Override
	public int deletePatient(int id) {
		// String query = environment.getProperty("delete_patient");
		String query = "DELETE FROM patient WHERE Patient_id = ?;";

		int status = -1;

		try {
			status = jdbcTemplate.update(query, id);
		} catch (DataAccessException dae) {
			dae.printStackTrace();
		}

		return status;
	}

	public List<Patient> findAll() {
		List<Patient> list = new ArrayList<Patient>();
		// String query = environment.getProperty("find_all");
		String query = "SELECT * FROM patient;";

		try {
			list = jdbcTemplate.query(query, new PatientMapper());
		} catch (EmptyResultDataAccessException emptyResult) {
			emptyResult.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
