package Entidades;

public class Setor {

    private int codigo;

    private String nomeSet;

    public Setor() {
    }

    public Setor(int codigo, String nomeSet) {
        this.codigo = codigo;
        this.nomeSet = nomeSet;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeSet() {
        return nomeSet;
    }

    public void setNomeSet(String nomeSet) {
        this.nomeSet = nomeSet;
    }
}
