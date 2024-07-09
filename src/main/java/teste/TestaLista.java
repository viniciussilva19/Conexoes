
package teste;

import dao.ConexaoDao;
import java.sql.SQLException;
import java.util.List;
import model.Usuario;


public class TestaLista {
    public static void main(String[] args) throws SQLException{
		
        ConexaoDao dao = new ConexaoDao();

        List<Usuario> usuarios = dao.getLista();

        System.out.println("Dados:\n");

        for (Usuario usuario : usuarios) {
            System.out.println("Nome: " + usuario.getCPF());
            System.out.println("Celular: " + usuario.getCelular());
            System.out.println("Email: " + usuario.getEmail());
        }
    }
}
    

