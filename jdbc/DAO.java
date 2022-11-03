package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {

    private Connection conexao;


    // quer retornar o id que foi gerado a partir dessa inclusao
    public int incluir(String sql, Object... atributos){
        // criou um DAO só para encapsular ao processo de inclusao, nao precisa se preocupar em criar conexao, statment, setar os dados e ta fazendo de forma encapsulada..
        // pois é um código de infraestrutura repetitivo e focar nas regras do negócio, DAO permite um nivel de
        //encapsulamento/abstração ainda maior
        // criou o prepared a partir da conexao, passou o sql, e pediu para retornar as chaves
        //agor vai setar cada atributo que recebi como param desse statement
        try {
            PreparedStatement stmt = getConexao().prepareStatement(
                    sql, PreparedStatement.RETURN_GENERATED_KEYS);
            adicionarAtributos(stmt,atributos);

            if (stmt.executeUpdate() > 0){
                ResultSet resultado = stmt.getGeneratedKeys();

                if (resultado.next()){
                    return resultado.getInt(1);
                }
            }
            return -1;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    // esse método vai adicionar os atributos que passou no array, se for string é set string e etc
    private void adicionarAtributos(PreparedStatement stmt, Object[] atributos) throws SQLException{
        int indice = 1;
        for (Object atributo: atributos){
            if (atributo instanceof String){
                stmt.setString(indice, (String) atributo);
            }else if (atributo instanceof Integer){
                stmt.setInt(indice, (Integer) atributo);
            }
            indice++;
        }
    }

    private Connection getConexao() throws SQLException {
        try {
            if (conexao != null && !conexao.isClosed()){
                return conexao;
            }

        } catch (SQLException e){
        }
        // se a conexao ou não existe ou esta fechada, cria uma nova conexao
        conexao = FabricaConexao.getConexao();
        return conexao;
    }

    public void close(){
        try {
            getConexao().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conexao = null; // aqui mata a conexao de toda forma
        }
    }

}
