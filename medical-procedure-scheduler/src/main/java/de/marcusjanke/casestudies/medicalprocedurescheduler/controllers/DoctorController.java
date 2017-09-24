package de.marcusjanke.casestudies.medicalprocedurescheduler.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.marcusjanke.casestudies.medicalprocedurescheduler.domain.Doctor;
import de.marcusjanke.casestudies.medicalprocedurescheduler.repositories.DoctorRepository;

/**
 * DoctorController
 * 
 * @author marcus
 *
 */
@Controller
public class DoctorController {

	private final Logger logger = LoggerFactory.getLogger(DoctorController.class);

	@Autowired
	private DoctorRepository doctorRepository;

	/**
	 * create DoctorController
	 */
	public DoctorController() {
		logger.info("Created DoctorController");
	}

	/**
	 * get doctors view
	 * 
	 * @param model
	 * @return doctors view
	 */
	@RequestMapping(value = "/doctors", method = RequestMethod.GET)
	public String getDoctors(Model model) {
		Iterable<Doctor> doctors = doctorRepository.findAll();
		model.addAttribute("doctor", Doctor.EXAMPLE);
		model.addAttribute("doctors", doctors);
		return "doctors";
	}

	/**
	 * add doctor and get doctors view
	 * 
	 * @param model
	 * @return doctors view
	 */
	@RequestMapping(value = "/doctors", method = RequestMethod.POST)
	public String addDoctor(@ModelAttribute Doctor doctor, Model model) {
		doctorRepository.save(doctor);
		return getDoctors(model);
	}

}