package se.lexicon.aman.exception_rest.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.aman.exception_rest.entity.Category;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

    Optional<Category> findByNameIgnoreCase(String name);
}
