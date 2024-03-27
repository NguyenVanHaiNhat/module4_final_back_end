package org.example.thi2.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cityDetail")
@Data
@NoArgsConstructor
public class CityDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
    private String name_city;
    private double area;
    private int population;
    private int GDP;
    private String description;
}
