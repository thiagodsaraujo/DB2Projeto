package entidades;

public class Venda {

    public int codigoVenda;

    public int codigoProd;

    public int codVendedor;

    private int qntdVendida;

    public Venda() {
    }

    public Venda(int codigoVenda, int codigoProd, int codVendedor, int qntdVendida) {
        this.codigoVenda = codigoVenda;
        this.codigoProd = codigoProd;
        this.codVendedor = codVendedor;
        this.qntdVendida = qntdVendida;
    }

    public int getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(int codigoVenda) {
        this.codigoVenda = codigoVenda;
    }

    public int getCodigoProd() {
        return codigoProd;
    }

    public void setCodigoProd(int codigoProd) {
        this.codigoProd = codigoProd;
    }

    public int getCodVendedor() {
        return codVendedor;
    }

    public void setCodVendedor(int codVendedor) {
        this.codVendedor = codVendedor;
    }

    public int getQntdVendida() {
        return qntdVendida;
    }

    public void setQntdVendida(int qntdVendida) {
        this.qntdVendida = qntdVendida;
    }
}
