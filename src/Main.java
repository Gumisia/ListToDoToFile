import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class Main extends JFrame {
    public Main(){
        initcomponents();
    }

    private void initcomponents(){

        this.setTitle("Test");
        this.setBounds(700, 300, 300, 210);

        jList.setVisibleRowCount(9);
        jList.setFixedCellWidth(280);

        jPanel.setLayout(new BorderLayout());

        jPanel.add(jTextField, BorderLayout.PAGE_START);
        jPanel.add(jScrollPane);
        jPanel.add(jButton, BorderLayout.PAGE_END);

        this.getContentPane().add(jPanel, BorderLayout.CENTER);

        this.setContentPane(jPanel);

        jTextField.addActionListener(e -> {
            myModelTest.addElementList(jTextField.getText());
            myModelTest.sortList();
            jTextField.setText("");
        });



        jButton.addActionListener( e->{

            try {
                myModelTest.saveToFile();
            }
            catch (IOException ex){
                ex.getMessage();
            }

            this.setTitle("out.txt");

            for(int i=0; i<myModelTest.getSize(); i++){
                myModelTest.deleteList();
            }

        });

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    private JPanel jPanel = new JPanel();
    private JTextField jTextField = new JTextField();
    private MyModelTest myModelTest = new MyModelTest();
    private JList<String> jList = new JList<>(myModelTest);
    private JScrollPane jScrollPane = new JScrollPane(jList);

    private JButton jButton = new JButton("Save");


    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}
