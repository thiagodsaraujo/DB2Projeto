package Entidades;

public class Estabelecimento {

    private int codigoEstab;
    private String nomeEstab;

    public Estabelecimento() {
    }

    public Estabelecimento(int codigoEstab, String nomeEstab) {
        this.codigoEstab = codigoEstab;
        this.nomeEstab = nomeEstab;
    }

    public int getCodigoEstab() {
        return codigoEstab;
    }

    public void setCodigoEstab(int codigoEstab) {
        this.codigoEstab = codigoEstab;
    }

    public String getNomeEstab() {
        return nomeEstab;
    }

    public void setNomeEstab(String nomeEstab) {
        this.nomeEstab = nomeEstab;
    }
}
