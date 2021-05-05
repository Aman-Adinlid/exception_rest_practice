package se.lexicon.aman.exception_rest.service;


import se.lexicon.aman.exception_rest.dto.CategoryDto;
import se.lexicon.aman.exception_rest.exception.RecordDuplicateException;
import se.lexicon.aman.exception_rest.exception.RecordNotFoundException;

import java.util.List;

public interface CategoryService {

    CategoryDto save(CategoryDto dto) throws RecordDuplicateException;

    CategoryDto update(CategoryDto dto) throws RecordNotFoundException;

    List<CategoryDto> getAll();

    CategoryDto findById(int id) throws RecordNotFoundException;

    void deleteById(int id) throws RecordNotFoundException;
}
