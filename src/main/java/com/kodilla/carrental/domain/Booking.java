package com.kodilla.carrental.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "books")
public class Booking {

    @Id
    @NotNull
    @GeneratedValue
    private Long id;
    @Column(name = "bookSince")
    private LocalDate bookSince;
    @Column(name = "bookTo")
    private LocalDate bookTo;

    @OneToMany(
            targetEntity = Equipment.class,
            mappedBy = "booking",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Equipment> equipment = new ArrayList<>();
}
