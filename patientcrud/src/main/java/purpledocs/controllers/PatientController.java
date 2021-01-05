package purpledocs.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import purpledocs.model.Patient;
import purpledocs.service.PatientService;

@RestController
@ComponentScan
public class PatientController {
	@Autowired
	PatientService patientService;
	
	@RequestMapping(value="/")
	public ModelAndView listPatient(ModelAndView model) throws IOException{
	    List<Patient> listPat = patientService.findAll();
	    model.addObject("listPatient", listPat);
	    model.setViewName("home");
	 
	    return model;
	}
	
	@RequestMapping(value="/addPatient", method = RequestMethod.GET)
	public ModelAndView addPatient(ModelAndView model) {
	    Patient newPatient = new Patient();
	    model.addObject("patient", newPatient);
	    model.setViewName("PatientForm");
	    return model;
	}
	
	@RequestMapping(value = "/savePatient", method = RequestMethod.POST)
	public ModelAndView savePatient(@ModelAttribute Patient patient) {
	    patientService.saveOrUpdatePatient(patient);
	    return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/deletePatient", method = RequestMethod.GET)
	public ModelAndView deletePatient(HttpServletRequest request) {
	    int id = Integer.parseInt(request.getParameter("id"));
	    patientService.deletePatient(id);
	    return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/updatePatient", method = RequestMethod.GET)
	public ModelAndView updatePatient(@ModelAttribute Patient patient, HttpServletRequest request) {
	    int id = Integer.parseInt(request.getParameter("id"));
	    Patient pat = patientService.getPatientById(id);
	    ModelAndView model = new ModelAndView("PatientForm");
	    model.addObject("patient", pat);
	 
	    return model;
	}
}
