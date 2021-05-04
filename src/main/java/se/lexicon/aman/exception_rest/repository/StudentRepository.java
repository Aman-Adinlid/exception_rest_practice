package se.lexicon.aman.exception_rest.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.aman.exception_rest.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student, Integer> {

    Optional<Student> findByFirstNameIgnoreCase(String firstName);

    Optional<Student> findByLastNameIgnoreCase(String lastName);

    List<Student> findByStudentDetails_DescriptionIgnoreCase(String description);
}
