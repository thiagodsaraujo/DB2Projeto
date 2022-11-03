package jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class FabricaConexao {

    public static Connection getConexao() throws SQLException {
        try {
            Properties prop = getProperties();
//            final String url = "jdbc:mysql://localhost/curso_javaudemy?verifyServerCertificate=false&useSSL=true";
//            final String usuario = "root";
//            final String senha = "1234";

            final String url = prop.getProperty("banco.url");
            final String usuario = prop.getProperty("banco.usuario");
            final String senha = prop.getProperty("banco.senha");

            return DriverManager.getConnection(url,usuario, senha);
        } catch (SQLException | IOException e){
            //aqui esta chegando a exceção, vai lançar como RunTime e a causa original a sqlexcpetion, vai trocar a exceção checada por uma nao checada
            throw new RuntimeException(e);
        }
    }
    // a melhor forma é externalizar o arquivo properties em uma pasta padrao fora do projeto, para quando nao compactar ele ir junto...
    private static Properties getProperties() throws IOException {
        Properties prop = new Properties();
        String caminho = "conexao.properties";
        prop.load(FabricaConexao.class.getResourceAsStream(caminho));
        return prop;
    }

}
