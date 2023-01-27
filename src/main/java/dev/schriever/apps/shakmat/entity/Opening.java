package dev.schriever.apps.shakmat.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity()
@Table(name = "openings")
@Data
public class Opening {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String moves;

    @OneToMany(mappedBy = "opening")
    private List<Variant> variants;
}
