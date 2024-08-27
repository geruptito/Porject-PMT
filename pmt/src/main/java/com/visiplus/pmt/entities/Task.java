package com.visiplus.pmt.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity  // Indique que cette classe est une entité JPA mappée à une table de la base de données.
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // La clé primaire sera générée automatiquement.
    private Long id;

    private String name;  // Nom de la tâche
    private String description;  // Description de la tâche
    private String dueDate;  // Date d'échéance de la tâche
    private String priority;  // Priorité de la tâche (ex. : haute, moyenne, basse)
    private String status;  // Statut de la tâche (ex. : en cours, terminée)

    @ManyToOne  // Relation Many-to-One avec l'entité Project (chaque tâche appartient à un projet).
    private Project project;

    @ManyToOne  // Relation Many-to-One avec l'entité User (chaque tâche peut être assignée à un utilisateur).
    private User assignedTo;

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

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }
}
