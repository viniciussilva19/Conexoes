
package teste;

import java.sql.Connection;
import java.sql.SQLException;
import jdbc.Conexao;

public class TestaConexaoBd {
    public static void main(String[] args) throws SQLException {
        Connection conexao = new Conexao().getConnection();
        System.out.println("Conexão estabelecida");
        conexao.close();
        
    }
}
    

