package de.marcusjanke.casestudies.medicalprocedurescheduler.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.marcusjanke.casestudies.medicalprocedurescheduler.domain.Room;

public interface RoomRepository extends CrudRepository<Room, Long> {

	List<Room> findByName(String name);
}
