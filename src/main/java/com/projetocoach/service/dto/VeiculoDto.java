package com.projetocoach.service.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VeiculoDTO {
    private Long id;
    private String marca;
    private String modelo;
    private String cor;
    private String ano;
    private String preco;
    private String descricao;
    private String tipo;
}
