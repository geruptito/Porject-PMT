package com.visiplus.pmt.services;

import com.visiplus.pmt.entities.Project;
import com.visiplus.pmt.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    // Récupérer tous les projets
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    // Récupérer un projet par ID
    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }

    // Créer un nouveau projet
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    // Mettre à jour un projet existant
    public Project updateProject(Long id, Project projectDetails) {
        Optional<Project> projectOptional = projectRepository.findById(id);
        if (projectOptional.isPresent()) {
            Project project = projectOptional.get();
            project.setName(projectDetails.getName());
            project.setDescription(projectDetails.getDescription());
            project.setStartDate(projectDetails.getStartDate());
            project.setAdmin(projectDetails.getAdmin());
            return projectRepository.save(project);
        } else {
            throw new RuntimeException("Projet non trouvé avec l'ID : " + id);
        }
    }

    // Supprimer un projet par ID
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}
