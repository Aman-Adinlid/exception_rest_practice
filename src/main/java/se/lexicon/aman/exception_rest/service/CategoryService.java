package se.lexicon.aman.exception_rest.service;

import se.lexicon.aman.exception_rest.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto save(CategoryDto dto);

    CategoryDto update(CategoryDto dto);

    List<CategoryDto> getAll();

    CategoryDto findById(int id);

    void deleteById(int id);
}
