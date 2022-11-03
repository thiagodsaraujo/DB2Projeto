package Entidades;

public class Funcionario {

    private int matricula;

    private String nome;

    private double salario;

    private int codSetor;

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    private String createdOn;



    public Funcionario() {
    }

    public Funcionario(int matricula, String nome, double salario, int codSetor) {
        this.matricula = matricula;
        this.nome = nome;
        this.salario = salario;
        this.codSetor = codSetor;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getCodSetor() {
        return codSetor;
    }

    public void setCodSetor(int codSetor) {
        this.codSetor = codSetor;
    }

}
