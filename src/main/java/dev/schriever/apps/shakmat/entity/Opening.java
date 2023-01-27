package dev.schriever.apps.shakmat.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity()
@Table(name = "openings")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Opening {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String moves;

    @OneToMany(mappedBy = "opening")
    @Singular
    private List<Variant> variants;

    public Opening(String name, String moves) {
        this.name = name;
        this.moves = moves;
    }
}
