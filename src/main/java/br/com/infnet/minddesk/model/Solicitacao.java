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

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Solicitacao(UUID id, Agente agente, Categoria categoria, Cliente cliente, String email,
                       String descricao, String urgencia){
        super(id, agente, categoria, cliente, email);
        this.descricao = descricao;
        this.urgencia= urgencia;
        this.cliente = cliente;
    }

    public static Ticket criarTicket(TipoTicket tipo, UUID idTicket, Agente agente, Categoria categoria, Cliente cliente, String email,
                                             String descricao, String urgencia) {
        switch (tipo) {
            case SOLICITACAO:
                return new Solicitacao(idTicket, agente, categoria, cliente, email, descricao, urgencia);
            default:
                throw new IllegalArgumentException("Tipo de ticket desconhecido: " + tipo);
        }
    }

}
