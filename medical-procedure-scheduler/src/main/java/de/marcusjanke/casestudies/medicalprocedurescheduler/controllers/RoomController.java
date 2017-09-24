package de.marcusjanke.casestudies.medicalprocedurescheduler.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.marcusjanke.casestudies.medicalprocedurescheduler.domain.Room;
import de.marcusjanke.casestudies.medicalprocedurescheduler.repositories.RoomRepository;

/**
 * RoomController
 * 
 * @author marcus
 *
 */
@Controller
public class RoomController {
	
	private final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	RoomRepository roomRepository;

	/**
	 * create RoomController
	 */
	public RoomController() {
		logger.info("Created RoomController");
	}

	/**
	 * get rooms view
	 * 
	 * @param model
	 * @return rooms view
	 */
	@RequestMapping(value="/rooms", method=RequestMethod.GET)
	public String getRooms(Model model) {
		Iterable<Room> rooms = roomRepository.findAll();
		model.addAttribute("room", Room.EXAMPLE);
		model.addAttribute("rooms", rooms);
		return "rooms";
	}

	/**
	 * add room and get rooms view
	 * 
	 * @param model
	 * @return rooms view
	 */
	@RequestMapping(value="/rooms", method=RequestMethod.POST)
	public String addRoom(@ModelAttribute Room room, Model model) {
		roomRepository.save(room);
        return getRooms(model);
    }

}
