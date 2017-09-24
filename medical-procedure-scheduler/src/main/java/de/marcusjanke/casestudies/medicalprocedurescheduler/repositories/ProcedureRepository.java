package de.marcusjanke.casestudies.medicalprocedurescheduler.repositories;

import org.springframework.data.repository.CrudRepository;

import de.marcusjanke.casestudies.medicalprocedurescheduler.domain.Procedure;

public interface ProcedureRepository extends CrudRepository<Procedure, Long> {

}
