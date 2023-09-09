package br.com.mvc.mudi.dto;

import br.com.mvc.mudi.model.Pedido;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RequisicaoNovoPedido {
    

    @NotBlank
    @NotNull
	private String nomeProduto;
	
    @NotBlank
	private String urlProduto;
	
    @NotBlank
	private String urlImagem;
	
	private String descricao;


    public Pedido toPedido(){

        Pedido pedido = new Pedido();
        pedido.setNomeProduto(nomeProduto);
        pedido.setUrlImagem(urlImagem);
        pedido.setUrlProduto(urlProduto);
        pedido.setDescricao(descricao);
        return pedido;
    }

}
