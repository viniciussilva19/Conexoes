

package TelaLogin;

import TelaInicio.TelaPrincipal;
import TesteTela.Tela;
import dao.ConexaoDao;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Mavenproject1 {
    public static void main(String[] args) {
        // Criar a tela de login
        JFrame frame = new JFrame("Login");
        frame.setSize(1920, 1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Carregar a imagem
        ImageIcon backgroundIcon = new ImageIcon("C:/Users/vini-/OneDrive/Documentos/Imagens A3/login_4x.PNG");
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setSize(1920, 1080);

        // Definir layout da imagem como fundo
        frame.setContentPane(backgroundLabel);
        frame.setLayout(null);

        JPanel panel = new JPanel();
        panel.setOpaque(false); // Tornar o painel transparente
        panel.setLayout(null);
        panel.setBounds(200, 150, 300, 200); // Ajustar a posição e o tamanho do painel

        placeComponents(panel);

        frame.add(panel);
        frame.setVisible(true);
    }
    

    private static void placeComponents(JPanel panel) {
        JLabel userLabel = new JLabel("");
        userLabel.setBounds(10, 20, 80, 25);
        userLabel.setForeground(Color.black); // Definir cor do texto para se destacar no fundo
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(10, 90, 750, 80);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("");
        passwordLabel.setBounds(10, 25, 5, 25);
        passwordLabel.setForeground(Color.black); // Definir cor do texto para se destacar no fundo
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(100, 80, 80, 25);
        loginButton.addActionListener(new ActionListener()
        
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());

                ConexaoDao dao = new ConexaoDao();
        if (dao.login(username, password)) {
            JOptionPane.showMessageDialog(null, "Usuário logado ");
            
            new TelaPrincipal();
        }
        
        
        
        else {
            JOptionPane.showMessageDialog(null, "Usuário e/ou senha inválido!");
            }}
        });
        
        panel.add(loginButton);
        
        JButton cadastrarButton = new JButton("Cadastre-se");
        cadastrarButton.setBounds(100, 180, 120, 20);
        cadastrarButton.addActionListener(new ActionListener() 
        {
            
        
            public void actionPerformed(ActionEvent e) {
               
                new Tela();
           
                
        
        }
        
            });
        panel.add(cadastrarButton);
}
}
  
        
        
        
                
             


