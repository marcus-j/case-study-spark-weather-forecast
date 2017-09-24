package de.marcusjanke.casestudies.medicalprocedurescheduler.repositories;

import org.springframework.data.repository.CrudRepository;

import de.marcusjanke.casestudies.medicalprocedurescheduler.domain.Study;

public interface StudyRepository  extends CrudRepository<Study, Long> {

}
