import javax.swing.*;

public class Window extends JFrame {

    public Window(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(600, 500);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setTitle("Calculator");
        this.add(new MainScene(0, 0, 600, 500));
        this.setVisible(true);

    }
}
