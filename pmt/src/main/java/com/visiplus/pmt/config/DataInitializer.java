package com.visiplus.pmt.config;

import com.visiplus.pmt.entities.User;
import com.visiplus.pmt.entities.Project;
import com.visiplus.pmt.entities.Task;
import com.visiplus.pmt.repositories.UserRepository;
import com.visiplus.pmt.repositories.ProjectRepository;
import com.visiplus.pmt.repositories.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration  // Indique que cette classe contient des configurations Spring.
public class DataInitializer {

    @Bean  // La méthode annotée avec @Bean sera exécutée lors du démarrage de l'application.
    CommandLineRunner initDatabase(UserRepository userRepository, ProjectRepository projectRepository, TaskRepository taskRepository) {
        return args -> {
            // Création de deux utilisateurs
            User john = new User();
            john.setUsername("john_doe");
            john.setEmail("john.doe@example.com");
            john.setPassword("password123");
            userRepository.save(john);  // Enregistrement de l'utilisateur dans la base de données

            User jane = new User();
            jane.setUsername("jane_doe");
            jane.setEmail("jane.doe@example.com");
            jane.setPassword("password456");
            userRepository.save(jane);

            // Création de deux projets
            Project projectAlpha = new Project();
            projectAlpha.setName("Projet Alpha");
            projectAlpha.setDescription("Projet de développement Alpha");
            projectAlpha.setStartDate(LocalDate.of(2024, 1, 1).toString());
            projectAlpha.setAdmin(john);  // John est l'administrateur du projet Alpha
            projectRepository.save(projectAlpha);

            Project projectBeta = new Project();
            projectBeta.setName("Projet Beta");
            projectBeta.setDescription("Projet de développement Beta");
            projectBeta.setStartDate(LocalDate.of(2024, 2, 1).toString());
            projectBeta.setAdmin(jane);  // Jane est l'administratrice du projet Beta
            projectRepository.save(projectBeta);

            // Création de trois tâches
            Task task1 = new Task();
            task1.setName("Tâche 1");
            task1.setDescription("Description de la tâche 1");
            task1.setDueDate("2024-01-15");
            task1.setPriority("Haute");
            task1.setStatus("En cours");
            task1.setProject(projectAlpha);  // La tâche 1 appartient au projet Alpha
            task1.setAssignedTo(john);  // La tâche 1 est assignée à John
            taskRepository.save(task1);

            Task task2 = new Task();
            task2.setName("Tâche 2");
            task2.setDescription("Description de la tâche 2");
            task2.setDueDate("2024-01-20");
            task2.setPriority("Moyenne");
            task2.setStatus("Non commencée");
            task2.setProject(projectAlpha);  // La tâche 2 appartient au projet Alpha
            task2.setAssignedTo(jane);  // La tâche 2 est assignée à Jane
            taskRepository.save(task2);

            Task task3 = new Task();
            task3.setName("Tâche 3");
            task3.setDescription("Description de la tâche 3");
            task3.setDueDate("2024-02-05");
            task3.setPriority("Basse");
            task3.setStatus("Terminée");
            task3.setProject(projectBeta);  // La tâche 3 appartient au projet Beta
            task3.setAssignedTo(john);  // La tâche 3 est assignée à John
            taskRepository.save(task3);
        };
    }
}
