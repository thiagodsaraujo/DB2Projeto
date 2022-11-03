package jdbc;

public class DAOTeste {

    // aqui mostra um pouco como usamos o DAO

    public static void main(String[] args) {
        DAO dao = new DAO();

        String sql = "INSERT INTO pessoas (nome) VALUES (?)"; // aqui poderia ser (nome, pessoa) VALUES (?,?) pq estamos aceitando vários paramentros
        System.out.println(dao.incluir(sql,"João da Silva"));
        System.out.println(dao.incluir(sql,"Ana Júlia"));
        System.out.println(dao.incluir(sql,"Fulano de Tal"));        ;
        System.out.println(dao.incluir(sql,"Sicrano Teste"));

        dao.close();
    }
}
