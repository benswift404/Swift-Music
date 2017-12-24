import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

public class SwiftMusic {

    public static void main(String[] args) {
        createUI();
    }

    static void createUI() {
        JPanel panel = new JPanel();
        JLabel titleLabel = new JLabel("Welcome to Swift Music!");
        JButton button = new JButton("Open");
        String artists[] = {
            "KYLE",
            "Chance the Rapper",
            "Migos",
            "DRAM",
            "Lil Yachty"
        };
        JComboBox comboBox = new JComboBox<>(artists);
        JFrame frame = new JFrame("Swift Music");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setResizable(true);

        button.addActionListener(new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Desktop desktop = Desktop.getDesktop();
                    String comboValue = comboBox.getSelectedItem().toString();
                    switch(comboValue) {
                        case "KYLE":
                            desktop.browse(new URI("http://www.apple.com/"));
                            break;
                        default:
                            JOptionPane.showMessageDialog(frame, "Something went wrong");
                    }
                } catch (Exception e) {
                    System.out.println("There was an error");
                }
            }
        });

        panel.add(titleLabel);
        panel.add(comboBox);
        panel.add(button);
        frame.add(panel);

        frame.setVisible(true);
    }

}