package br.com.infnet.minddesk.model;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class FilaSuporte extends Fila{

    private String descricao;

}
