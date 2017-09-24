package de.marcusjanke.casestudies.medicalprocedurescheduler.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import de.marcusjanke.casestudies.medicalprocedurescheduler.domain.Patient;
import de.marcusjanke.casestudies.medicalprocedurescheduler.domain.Sex;
import de.marcusjanke.casestudies.medicalprocedurescheduler.repositories.PatientRepository;

/**
 * PatientController
 * 
 * @author marcus
 *
 */
@Controller
public class PatientController {
	
	private final Logger logger = LoggerFactory.getLogger(PatientController.class);

	@Autowired
	private PatientRepository patientRepository;

	/**
	 * create PatientController
	 */
	public PatientController() {
		logger.info("Created PatientController");
	}

	/**
	 * get patients view
	 * 
	 * @param model
	 * @return patients view
	 */
	@RequestMapping(value="/patients", method=RequestMethod.GET)
	public String getPatients(Model model) {
		Iterable<Patient> patients = patientRepository.findAll();
		model.addAttribute("patient", Patient.EXAMPLE);
		model.addAttribute("patients", patients);
		model.addAttribute("sexes", Sex.values());
		return "patients";
	}

	/**
	 * add patient and get patients view
	 * 
	 * @param model
	 * @return patients view
	 */
	@RequestMapping(value="/patients", method=RequestMethod.POST)
	public String addPatient(@ModelAttribute Patient patient, Model model) {
		patientRepository.save(patient);		
        return getPatients(model);
    }

}