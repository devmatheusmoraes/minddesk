package br.com.infnet.minddesk.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Entity
public class Solicitacao extends Ticket{

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String urgencia;

    @Column(nullable = false)
    private String texto;

    public Solicitacao(Long id, Agente agente, Categoria categoria, Cliente cliente, Fila fila,
                       String descricao, String urgencia, String texto){
        super(id, agente, categoria, cliente, fila);
        this.descricao = descricao;
        this.urgencia= urgencia;
        this.texto = texto;
    }

}
