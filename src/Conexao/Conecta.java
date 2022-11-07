package Conexao;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conecta {

    static final String URL = "jdbc:postgresql://localhost:5432/projetodb2";
    static final String USER = "postgres";
    static final String PASS = "1582";

    public static Connection criarConexao() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        Connection conecta = DriverManager.getConnection(URL, USER, PASS);

        if (conecta != null) {
            System.out.println("Conexão efetuada com sucesso..." +
                    "\n-------------------------------");
            return conecta;
        }
        return null;
    }

    public static void closeConnection(Connection con) {

        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conecta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public static void closeConnection(Connection con, PreparedStatement stmt) {

        closeConnection(con);
        try {

            if (stmt != null) {
                stmt.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conecta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {

        closeConnection(con, stmt);


        try {

            if (rs != null) {
                rs.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conecta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
