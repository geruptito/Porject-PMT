package com.visiplus.pmt.repositories;

import com.visiplus.pmt.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

// Cette interface permet d'accéder aux données de l'entité Task en étendant JpaRepository.
public interface TaskRepository extends JpaRepository<Task, Long> {
}
