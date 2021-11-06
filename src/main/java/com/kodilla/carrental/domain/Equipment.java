package com.kodilla.carrental.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "equipment")
public class Equipment {

    @Id
    @NotNull
    @GeneratedValue
    private Long id;
    @Column(name = "equipment")
    private String equipment;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "booking_id")
    private Booking booking;
}
