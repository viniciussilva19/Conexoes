
package TelaInicio;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaPrincipal {
    
    public TelaPrincipal(){
        initComponents();
    }
    public static void main(String[] args) {
            initComponents();

    }
    private static void initComponents(){
        // Criar a tela de login
        JFrame frame = new JFrame("Tela Principal");
        frame.setSize(900, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Carregar a imagem
        ImageIcon backgroundIcon = new ImageIcon("C:/Users/vini-/Downloads/A3/projeto.JPG");
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setSize(900, 700);

        // Definir layout da imagem como fundo
        frame.setContentPane(backgroundLabel);
        frame.setLayout(null);

        JPanel panel = new JPanel();
        panel.setOpaque(false); // Tornar o painel transparente
        panel.setLayout(null);
        panel.setBounds(200, 150, 300, 200); // Ajustar a posição e o tamanho do painel


        frame.add(panel);
        frame.setVisible(true);
    }
    
 

       
}
