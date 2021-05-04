package se.lexicon.aman.exception_rest.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    @Column(nullable = false, unique = true, length = 200)
    private String lastName;
    @Column(nullable = false, unique = true, length = 200)
    private boolean active;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    private Category category;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private StudentDetails studentDetails;
}
