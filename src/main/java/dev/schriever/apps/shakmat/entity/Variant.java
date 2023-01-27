package dev.schriever.apps.shakmat.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity()
@Table(name = "variants")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

  @OneToMany(mappedBy = "parentVariant")
  @Singular
  private List<Variant> variants;

  @ManyToOne
  @JoinColumn(name = "parent_variant_id")
  private Variant parentVariant;

  public Variant(Opening opening, String moves) {
    this.opening = opening;
    this.moves = moves;
  }

  public Variant(Opening opening, Variant parentVariant, String moves) {
    this.opening = opening;
    this.parentVariant = parentVariant;
    this.moves = moves;
  }
}
