package se.lexicon.aman.exception_rest.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Data
public class CategoryDto {
    private int id;
    @NotEmpty(message = "Category Name cannot be empty")
    @Size(min = 2, max = 30, message = "Category Name should be in 2-30 chars")
    private String name;
}
