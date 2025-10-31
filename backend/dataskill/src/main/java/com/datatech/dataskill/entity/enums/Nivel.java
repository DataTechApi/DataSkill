package com.datatech.dataskill.entity.enums;

public enum Nivel {
    BASICO("Basico"),
    INTERMEDIARIO("Intermediario"),
    AVANCADO("Avancado");

    private String descricao;
    Nivel(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return this.descricao;
    }

}
