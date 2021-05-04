package se.lexicon.aman.exception_rest.dto;

import lombok.Data;

@Data
public class StudentDto {

    private int id;
    private String firstName;
    private String lastName;
    private boolean active;
    private CategoryDto category;
    private StudentDetailsDto studentDetails;
}
