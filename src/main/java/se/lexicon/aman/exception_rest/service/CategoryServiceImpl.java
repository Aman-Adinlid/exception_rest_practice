package se.lexicon.aman.exception_rest.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import se.lexicon.aman.exception_rest.dto.CategoryDto;
import se.lexicon.aman.exception_rest.entity.Category;
import se.lexicon.aman.exception_rest.exception.ArgumentException;
import se.lexicon.aman.exception_rest.exception.RecordDuplicateException;
import se.lexicon.aman.exception_rest.exception.RecordNotFoundException;
import se.lexicon.aman.exception_rest.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CategoryServiceImpl implements CategoryService {

    CategoryRepository categoryRepository;
    ModelMapper modelMapper;

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoryDto save(CategoryDto dto) throws RecordDuplicateException {
        if (dto == null) throw new ArgumentException("CategoryDto is null");
        if (dto.getId() <= 0) throw new ArgumentException("Category id is null");
        Category category = modelMapper.map(dto, Category.class);
        categoryRepository.findByNameIgnoreCase(dto.getName()).orElseThrow(() ->
                new RecordDuplicateException("Category name should not be duplicate"));
        Category savedCategory = categoryRepository.save(category);
        CategoryDto convertedToDto = modelMapper.map(savedCategory, CategoryDto.class);
        return convertedToDto;
    }

    @Override
    public CategoryDto update(CategoryDto dto) throws RecordNotFoundException {
        if (dto == null) throw new ArgumentException("CategoryDto is null");
        if (dto.getId() != 0) throw new ArgumentException("CategoryDto id is null");
        Category category = modelMapper.map(dto, Category.class);
        categoryRepository.findById(category.getId()).orElseThrow(() -> new RecordNotFoundException("Category id is not valid"));
        Category updatedCategory = categoryRepository.save(category);
        CategoryDto convertedToDto = modelMapper.map(updatedCategory, CategoryDto.class);
        return convertedToDto;
    }

    @Override
    public List<CategoryDto> getAll() {
        List<Category> categoryList = new ArrayList<>();
        categoryRepository.findAll().iterator().forEachRemaining(categoryList::add);
        List<CategoryDto> categoryDtoList = categoryList.stream().map(category -> modelMapper.map(category, CategoryDto.class)).
                collect(Collectors.toList());
        return categoryDtoList;
    }

    @Override
    public CategoryDto findById(int id) {
        if (id <= 0) throw new ArgumentException("Id is not valid");
        Optional<Category> category = categoryRepository.findById(id);
        if (!category.isPresent())
            return modelMapper.map(category, CategoryDto.class);
        return null;
    }

    @Override
    public void deleteById(int id) throws RecordNotFoundException {
        if (id <= 0) throw new ArgumentException("Is is not valid");
        categoryRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Category Id is not valid"));
        categoryRepository.deleteById(id);
    }
}
