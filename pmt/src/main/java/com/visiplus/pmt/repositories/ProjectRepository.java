package com.visiplus.pmt.repositories;

import com.visiplus.pmt.entities.Project;
import com.visiplus.pmt.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Cette interface permet d'accéder aux données de l'entité Project en étendant JpaRepository.
public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByAdmin(User admin);  // Méthode personnalisée pour trouver les projets par administrateur.
}
