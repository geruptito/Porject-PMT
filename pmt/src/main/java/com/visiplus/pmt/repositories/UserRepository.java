package com.visiplus.pmt.repositories;

import com.visiplus.pmt.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

// Cette interface permet d'accéder aux données de l'entité User en étendant JpaRepository.
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);  // Méthode personnalisée pour trouver un utilisateur par email.
}
