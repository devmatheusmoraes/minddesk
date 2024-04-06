package br.com.infnet.minddesk.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Fila {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fila_sequence")
    @SequenceGenerator(name = "fila_sequence", sequenceName = "fila_sequence", allocationSize = 1)
    private Long id;

    @OneToOne
    private Ticket ticket;

}

