import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainScene extends JPanel {
    private float widthCalculation;
    private float heightCalculation;
    private float lengthCalculation;

    public MainScene(int x, int y, int width, int height){
        this.setLayout(null);
        this.setBounds(x, y , width, height);
        JLabel labelWidth = new JLabel("Width");
        labelWidth.setBounds(50, 60, 100 , 30);
        this.add(labelWidth);

        TextField widthText = new TextField("");
        widthText.setBounds(200, 60, 100, 30);
        this.add(widthText);
        widthText.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                try {
                    float value = Float.parseFloat(widthText.getText());
                    if(value<=0){
                        System.out.println("0 is not a valid number");
                        widthText.setText("");
                        value = Float.parseFloat(widthText.getText());
                    }
                    widthCalculation = value;
                    System.out.println("Width is "+widthCalculation);
                } catch (NumberFormatException exception) {
                    System.out.println("Please enter a valid number");
                    widthText.setText("");
                }
            }
        });


        JLabel heightLabel = new JLabel("Height");
        heightLabel.setBounds(50, 160, 100 , 30);
        this.add(heightLabel);

        TextField heightText = new TextField("");
        heightText.setBounds(200, 160, 100, 30);
        this.add(heightText);
        heightText.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                try {
                    float value = Float.parseFloat(heightText.getText());
                    if(value<=0){
                        System.out.println("0 is not a valid number");
                        heightText.setText("");
                        value = Float.parseFloat(heightText.getText());
                    }
                    heightCalculation = value;
                    System.out.println("Height is "+heightCalculation);
                } catch (NumberFormatException exception) {
                    System.out.println("Please enter a valid number");
                    heightText.setText("");
                }
            }
        });

        JLabel labelLength = new JLabel("Length");
        labelLength.setBounds(50, 260, 100 , 30);
        this.add(labelLength);
        TextField lengthText = new TextField("");
        lengthText.setBounds(200, 260, 100, 30);
        this.add(lengthText);
        lengthText.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                try {
                    float value = Float.parseFloat(lengthText.getText());
                    if(value<=0){
                        System.out.println("0 is not a valid number");
                        lengthText.setText("");
                        value = Float.parseFloat(lengthText.getText());
                    }
                    lengthCalculation = value;
                    System.out.println("Length is "+lengthCalculation);
                } catch (NumberFormatException exception) {
                    System.out.println("Please enter a valid number");
                    lengthText.setText("");
                }
            }
        });

        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(50,340,100,30);
        this.add(calculateButton);
        calculateButton.setEnabled(true);
        new Thread(()->{
            while(true){
                if(isEmpty(lengthText.getText())||isEmpty(heightText.getText())||isEmpty(widthText.getText())){
                    calculateButton.setEnabled(false);
                }else{
                    calculateButton.setEnabled(true);
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
        calculateButton.addActionListener(e ->{
            float volume = (lengthCalculation*widthCalculation*heightCalculation);
            float area = ((2*widthCalculation*heightCalculation)+(2*widthCalculation*lengthCalculation)+
                    (2*lengthCalculation*heightCalculation));
            JOptionPane.showMessageDialog(null, "Volume is "+volume+"." +
                    " Area is "+area);
        });


    }
    public boolean isEmpty(String text){
        if(text.equals("")){
            return true;
        }else{
            return false;
        }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }

}
