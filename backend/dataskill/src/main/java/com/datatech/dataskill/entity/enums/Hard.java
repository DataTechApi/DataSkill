package com.datatech.dataskill.entity.enums;

public enum Hard {
    JAVA("Java"),
    SPRING("Spring"),
    PYTHON("Python"),
    CSHARP("C#"),
    HTML("Html"),
    CSS("Css"),
    MYSQL("Mysql"),
    JAVASCRIPT("Javascript"),
    ANGULAR("Angular"),
    POWERBI("Power BI"),
    ANALISE_DADOS("Analise de Dados");

    private String descricao;

    Hard(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao(){
        return this.descricao;
    }
}
