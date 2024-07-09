package dao;



import model.Usuario;
import jdbc.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ConexaoDao {
    private final Connection conexao;
    
    public ConexaoDao() {
            this.conexao = new Conexao().getConnection();
    }
    
    public void adicionaUsuario(Usuario usuario) {
        String sql = "INSERT INTO Usuario " +
                    "(idusuario, nome, email, celular, senha, endereço) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, usuario.getCPF());
            ps.setString(2, usuario.getNomeCompleto());
            ps.setString(3, usuario.getCelular());
            ps.setString(4, usuario.getEmail());
            ps.setString(5, usuario.getPassword());
            ps.setString(6, usuario.getEndereco());
            ps.execute();
            ps.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
      public boolean login(String CPF, String senha) {
        String sql = "SELECT * FROM Usuario WHERE idusuario = ? AND senha = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, CPF);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
            else {
                return false;
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Usuario> getLista() throws SQLException {
        
            List<Usuario> usuarios = new ArrayList<>();
            try{
            String sql = "SELECT * FROM Usuario";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setCPF(rs.getString("CPF"));
                usuario.setNomeCompleto(rs.getString("Nome Completo"));
                usuario.setCelular(rs.getString("celular"));
                usuario.setEmail(rs.getString("email"));
                usuario.setCadastro(rs.getString("login"));
                usuario.setEndereco(rs.getString("endereço"));
                
                adicionaUsuario(usuario);
            }
            rs.close();
            ps.close();
            return usuarios;
         }
         catch (SQLException e) {
            throw new RuntimeException(e);
         }
    }
    
    public Usuario getUsuario(Integer idusuario) {
        Usuario usuario = new Usuario();
        try {
            String sql = "SELECT * FROM Usuario WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, idusuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usuario.set(rs.getInt("idusuario"));
                usuario.setCPF(rs.getString("CPF"));
                usuario.setNomeCompleto(rs.getString("Nome Completo"));
                usuario.setCelular(rs.getString("celular"));
                usuario.setEmail(rs.getString("email"));
                usuario.setPassword(rs.getString("senha"));
            }
            rs.close();
            ps.close();
            return usuario;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

