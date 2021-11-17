package com.kodilla.carrental.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "book")
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id")
    private Car car;
}
