package dev.schriever.apps.shakmat.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.apache.bcel.classfile.Module;

import java.util.List;

@Entity()
@Table(name = "variants")
@Data
@NoArgsConstructor
public class Variant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "opening_id", nullable = false)
    private Opening opening;

    @Column(nullable = false)
    private String moves;

    @OneToMany(mappedBy = "variant")
    private List<Variant> variants;

    @ManyToOne
    @JoinColumn(name = "variant_id")
    private Variant variant;

    public Variant(Opening opening, String moves) {
        this.opening = opening;
        this.moves = moves;
    }

    public Variant(Opening opening, Variant variant, String moves) {
        this.opening = opening;
        this.variant = variant;
        this.moves = moves;
    }
}
