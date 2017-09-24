package de.marcusjanke.casestudies.medicalprocedurescheduler.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.marcusjanke.casestudies.medicalprocedurescheduler.domain.Study;
import de.marcusjanke.casestudies.medicalprocedurescheduler.repositories.PatientRepository;
import de.marcusjanke.casestudies.medicalprocedurescheduler.repositories.StudyRepository;

/**
 * StudyController
 * 
 * @author marcus
 *
 */
@Controller
public class StudyController {
	
	private final Logger logger = LoggerFactory.getLogger(PatientController.class);

	@Autowired
	private StudyRepository studyRepository;
	@Autowired
	private PatientRepository patientRepository;

	/**
	 * create StudyController
	 */
	public StudyController() {
		logger.info("Created StudyController");
	}

	/**
	 * get studies view
	 * 
	 * @param model
	 * @return studies view
	 */
	@RequestMapping(value="/studies", method=RequestMethod.GET)
	public String getStudies(Model model) {
		Iterable<Study> studies = studyRepository.findAll();
		model.addAttribute("study", Study.EXAMPLE);
		model.addAttribute("studies", studies);
		model.addAttribute("patients", patientRepository.findAll());
		return "studies";
	}

	/**
	 * add study and get studies view
	 * 
	 * @param model
	 * @return studies view
	 */
	@RequestMapping(value="/studies", method=RequestMethod.POST)
	public String addStudy(@ModelAttribute Study study, Model model) {
		studyRepository.save(study);
        return getStudies(model);
    }

}