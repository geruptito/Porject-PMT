package com.visiplus.pmt.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity  // Cette annotation indique que la classe Project est une entité JPA mappée à une table dans la base de données.
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Génération automatique de l'ID par la base de données.
    private Long id;

    private String name;  // Nom du projet
    private String description;  // Description du projet
    private String startDate;  // Date de début du projet

    @ManyToOne  // Indique qu'il y a une relation Many-to-One avec l'entité User (l'administrateur du projet).
    private User admin;

    @OneToMany(mappedBy = "project")  // Relation One-to-Many avec les tâches du projet (Un projet peut avoir plusieurs tâches).
    private List<Task> tasks;

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
