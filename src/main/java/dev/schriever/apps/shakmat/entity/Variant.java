package dev.schriever.apps.shakmat.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity()
@Table(name = "variants")
@Data
public class Variant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(nullable = false)
    private String moves;

    @ManyToOne
    @JoinColumn(name = "opening_id", nullable = false)
    private Opening opening;

    @OneToMany(mappedBy = "variant")
    private List<Variant> variants;

    @ManyToOne
    @JoinColumn(name = "variant_id")
    private Variant variant;
}
