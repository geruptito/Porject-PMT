package com.visiplus.pmt.repositories;

import com.visiplus.pmt.entities.TaskHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Cette interface permet d'accéder aux données de l'entité TaskHistory en étendant JpaRepository.
public interface TaskHistoryRepository extends JpaRepository<TaskHistory, Long> {
    List<TaskHistory> findByTaskId(Long taskId);  // Méthode personnalisée pour récupérer l'historique d'une tâche spécifique.
}
