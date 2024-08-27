package com.visiplus.pmt.services;

import com.visiplus.pmt.entities.Task;
import com.visiplus.pmt.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    // Récupérer toutes les tâches
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Récupérer une tâche par ID
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    // Créer une nouvelle tâche
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    // Mettre à jour une tâche existante
    public Task updateTask(Long id, Task taskDetails) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            task.setName(taskDetails.getName());
            task.setDescription(taskDetails.getDescription());
            task.setDueDate(taskDetails.getDueDate());
            task.setPriority(taskDetails.getPriority());
            task.setStatus(taskDetails.getStatus());
            task.setProject(taskDetails.getProject());
            task.setAssignedTo(taskDetails.getAssignedTo());
            return taskRepository.save(task);
        } else {
            throw new RuntimeException("Tâche non trouvée avec l'ID : " + id);
        }
    }

    // Supprimer une tâche par ID
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
