package net.plugsoft.pssysvendas.LibClass;

public enum RomaneioStatus {
    TODOS("Todos os status..."),
    ABERTO("Aberto"),
    ENTREGUE("Entregue"),
    PARCIAL("Parcial"),
    RECUSADO("Recusado");

    private String descricao;

    private RomaneioStatus(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
