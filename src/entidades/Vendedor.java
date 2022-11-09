package entidades;

public class Vendedor {

    private int matricula;
    private int codEst;
    private String nome;
    private Double salario;


    public Vendedor() {
    }

    public Vendedor(int matricula, int codEst, String nome, Double salario) {
        this.matricula = matricula;
        this.codEst = codEst;
        this.nome = nome;
        this.salario = salario;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getCodEst() {
        return codEst;
    }

    public void setCodEst(int codEst) {
        this.codEst = codEst;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
