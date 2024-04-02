package br.com.infnet.minddesk.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.UUID;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Solicitacao extends Ticket{

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String urgencia;

    @Column(nullable = false)
    private String texto;

    public Solicitacao(Long id, Agente agente, Categoria categoria, Cliente cliente, String email,
                       String descricao, String urgencia, String texto){
        super(id, agente, categoria, cliente, email);
        this.descricao = descricao;
        this.urgencia= urgencia;
        this.texto = texto;
    }

    public static Ticket criarTicket(TipoTicket tipo, Long idTicket, Agente agente, Categoria categoria, Cliente cliente, String email,
                                             String descricao, String urgencia, String texto) {
        switch (tipo) {
            case SOLICITACAO:
                return new Solicitacao(idTicket, agente, categoria, cliente, email, descricao, urgencia, texto);
            default:
                throw new IllegalArgumentException("Tipo de ticket desconhecido: " + tipo);
        }
    }

}
