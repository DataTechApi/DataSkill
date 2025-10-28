package com.datatech.dataskill.entity.enums;

public enum Soft {
    COMUNICACAO("Comunicação"),
    RESILIENCIA("Resiliência"),
    TRABALHO_EM_EQUIPE("Trabalho em Equipe"),
    LIDERANCA("Liderança"),
    ADAPTABILIDADE("Adaptabilidade"),
    PENSAMENTO_CRITICO("Pensamento Crítico");


    private String descricao;

    Soft(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }
}
