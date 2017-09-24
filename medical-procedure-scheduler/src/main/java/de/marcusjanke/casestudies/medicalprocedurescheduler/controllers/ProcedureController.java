package de.marcusjanke.casestudies.medicalprocedurescheduler.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import de.marcusjanke.casestudies.medicalprocedurescheduler.domain.Procedure;
import de.marcusjanke.casestudies.medicalprocedurescheduler.domain.Status;
import de.marcusjanke.casestudies.medicalprocedurescheduler.repositories.DoctorRepository;
import de.marcusjanke.casestudies.medicalprocedurescheduler.repositories.ProcedureRepository;
import de.marcusjanke.casestudies.medicalprocedurescheduler.repositories.RoomRepository;
import de.marcusjanke.casestudies.medicalprocedurescheduler.repositories.StudyRepository;

/**
 * ProcedureController
 * 
 * @author marcus
 *
 */
@Controller
public class ProcedureController {

	private final Logger logger = LoggerFactory.getLogger(PatientController.class);

	@Autowired
	private StudyRepository studyRepository;
	@Autowired
	private ProcedureRepository procedureRepository;
	@Autowired
	private DoctorRepository doctorRepository;
	@Autowired
	private RoomRepository roomRepository;

	/**
	 * create ProcedureController
	 */
	public ProcedureController() {
		logger.info("Created ProcedureController");
	}

	/**
	 * get procedures view
	 * 
	 * @param model
	 * @return procedures view
	 */
	@RequestMapping(value = "/procedures", method = RequestMethod.GET)
	public String getProcedures(Model model) {
		Iterable<Procedure> procedures = procedureRepository.findAll();
		model.addAttribute("procedure", Procedure.EXAMPLE);
		model.addAttribute("procedures", procedures);
		model.addAttribute("studies", studyRepository.findAll());
		model.addAttribute("doctors", doctorRepository.findAll());
		model.addAttribute("rooms", roomRepository.findAll());
		return "procedures";
	}

	/**
	 * add procedure and get procedures view
	 * 
	 * @param model
	 * @return procedures view
	 */
	@RequestMapping(value = "/procedures", method = RequestMethod.POST)
	public String addProcedure(@ModelAttribute Procedure procedure, Model model) {
		procedureRepository.save(procedure);
		return getProcedures(model);
	}

	/**
	 * update procedure status
	 * 
	 * @param id
	 * @param model
	 * @param status
	 * @return procedures view
	 */
	@RequestMapping(value = "/procedures/{id}", method = RequestMethod.GET)
	public String getProcedures(@PathVariable("id") Long id, Model model, @RequestParam("status") Status status) {
		Procedure procedure = procedureRepository.findOne(id);
		procedure.setStatus(status);
		procedureRepository.save(procedure);
		return getProcedures(model);
	}

}