

package TesteTela;


import TelaInicio.TelaPrincipal;
import dao.ConexaoDao;
import java.awt.Component;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import model.Usuario;

public class Tela {
    public Tela(){
        initComponents();
    }
    
     public static void main(String[] args) {
            initComponents();
     }
    private static void initComponents(){
        // Criar a tela de login
        JFrame frame = new JFrame("Tela de Cadastro");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel CPFLabel = new JLabel("CPF:");
        CPFLabel.setBounds(10, 20, 80, 25);
        panel.add(CPFLabel);

        final JTextField CPFText = new JTextField(20);
        CPFText.setBounds(130, 20, 185, 25);
        panel.add(CPFText);

        JLabel passwordLabel = new JLabel("Senha:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        final JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(130, 50, 185, 25);
        panel.add(passwordText);
        
        JLabel confpasswordLabel = new JLabel("Confirme a Senha:");
        confpasswordLabel.setBounds(10, 80, 140, 25);
        panel.add(confpasswordLabel);

        final JPasswordField confpasswordText = new JPasswordField(20);
        confpasswordText.setBounds(130, 80, 185, 25);
        panel.add(confpasswordText);
        
        JLabel emailLabel = new JLabel("E-mail:");
        emailLabel.setBounds(10, 110, 80, 25);
        panel.add(emailLabel);

        final JTextField emailText = new JTextField(20);
        emailText.setBounds(130, 110, 185, 25);
        panel.add(emailText);
        
        JLabel nomecompletoLabel = new JLabel("Nome completo");
        nomecompletoLabel.setBounds(10, 140, 140, 25);
        panel.add(nomecompletoLabel);

        final JTextField nomecompletoText = new JTextField(20);
        nomecompletoText.setBounds(130, 140, 185, 25);
        panel.add(nomecompletoText);
        
        JLabel enderecoLabel = new JLabel("Endereço");
        enderecoLabel.setBounds(10, 170, 140, 25);
        panel.add(enderecoLabel);

        final JTextField enderecoText = new JTextField(20);
        enderecoText.setBounds(130, 170, 185, 25);
        panel.add(enderecoText);
        
        JLabel celularLabel = new JLabel("Celular");
        celularLabel.setBounds(10, 200, 140, 25);
        panel.add(celularLabel);

        final JFormattedTextField celularText = new JFormattedTextField(createFormatter("(##) #####-####"));
        celularText.setBounds(130, 200, 185, 25);
        panel.add(celularText);

        JButton loginButton = new JButton("Cadastrar");
        loginButton.setBounds(130, 230, 100, 25);
        loginButton.addActionListener(new ActionListener() { 
            
            
            
            private Component rootPane;
            
            public void actionPerformed(ActionEvent e) {
                Usuario usuario = new Usuario();
                String CPF = CPFText.getText();
                String password = new String(passwordText.getPassword());
                String confPassword = new String(confpasswordText.getPassword());
                String email = emailText.getText();
                String nomeCompleto = nomecompletoText.getText();
                String endereco = enderecoText.getText();
                String celular = celularText.getText().replaceAll("[^\\d]", "");

                if (CPF.isEmpty() || password.isEmpty() || confPassword.isEmpty() || email.isEmpty() ||
                        nomeCompleto.isEmpty() || endereco.isEmpty() || celular.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos.");
                } else if (!password.equals(confPassword)) {
                    JOptionPane.showMessageDialog(null, "As senhas não coincidem.");
                } else {
                    
                    usuario.setCPF(CPFText.getText());
                    usuario.setPassword(password);
                    usuario.setEmail(emailText.getText());
                    usuario.setNomeCompleto(nomecompletoText.getText());
                    usuario.setEndereco(enderecoText.getText());
                    usuario.setCelular(celularText.getText());
                
                    ConexaoDao dao = new ConexaoDao();
                    
                
            
            
                dao.adicionaUsuario(usuario);
                 JOptionPane.showMessageDialog(rootPane, "Usuário adicionado com sucesso");
                 new TelaPrincipal();
                 
            }
            
                
                    
                
            }
        });
        panel.add(loginButton);
    }

    private static MaskFormatter createFormatter(String s) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(s);
            formatter.setPlaceholderCharacter('_');
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatter;
    }
}

    

