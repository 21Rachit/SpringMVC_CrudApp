package purpledocs.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import purpledocs.model.Patient;

public class PatientMapper implements RowMapper<Patient> {

	@Override
	public Patient mapRow(ResultSet rs, int rowNum) throws SQLException {
		Patient patient = new Patient();
		patient.setPatient_id(rs.getInt(1));
		patient.setPatient_name(rs.getString(2));
		patient.setPatient_age(rs.getInt(3));
		patient.setDescription(rs.getString(4));
		patient.setCreation_ts(rs.getDate(5));
		patient.setUpdation_ts(rs.getDate(6));
		
		return patient;
	}

}
