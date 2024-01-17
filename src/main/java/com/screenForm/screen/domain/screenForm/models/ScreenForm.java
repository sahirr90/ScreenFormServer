package com.screenForm.screen.domain.screenForm.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity // JPA to save to the database
@NoArgsConstructor // Non argument constructor
@RequiredArgsConstructor // parameterized constructor
@Data
public class ScreenForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String email;

    @NonNull
    private int age;

    @NonNull
    private String gender;

    @NonNull
    private String phone;

    @NonNull
    private String injury;

    @NonNull
    private String injuryLocation;

    public String toString(){
        return String.format("%d %s %s %s %d %s %s %s %s", id, firstName,lastName,email, age, gender, injury, phone, injuryLocation);
    }

}
