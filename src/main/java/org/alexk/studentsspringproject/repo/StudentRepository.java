package org.alexk.studentsspringproject.repo;

import org.alexk.studentsspringproject.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findById(Integer id);
    boolean existsById(Integer id);
    void deleteById(Integer id);
}

