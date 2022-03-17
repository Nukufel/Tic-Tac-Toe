import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame {

    private JFrame win =new JFrame();
    private JLabel winLabel = new JLabel();


    private static final  JPanel mainPanel = new JPanel();

    JButton[] b = new JButton[9];

    public static int cntr = 0;
    private boolean check = false;

    public Gui(){

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setSize(200,200);

        mainPanel.setLayout(new GridLayout(3,3,1,1));


        for (int i = 0; i < 9; i++) {
            b[i]= new JButton();
            mainPanel.add(b[i]);
            b[i].addActionListener(actionListener);
        }

        add(mainPanel);

        setVisible(true);



        win.setLayout(new BorderLayout());
        win.add(winLabel, BorderLayout.CENTER);
        win.setSize(100,100);
        win.setLocationRelativeTo(null);




    }
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            for (int a = 0; a < 9; a++) {
                if (win.isVisible() == false) {
                    if (e.getSource() == b[a]) {
                        if (b[a].getText() == "") {
                            if (cntr % 2 == 0) {
                                b[a].setText("X");
                                cntr++;
                                System.out.println(cntr);
                                checking();
                                if (check == true) {
                                    winLabel.setText("X Won");
                                    win.setVisible(true);
                                }

                            } else {
                                b[a].setText("O");
                                cntr++;
                                System.out.println(cntr);
                                checking();
                                if (check == true) {
                                    winLabel.setText("O Won");
                                    win.setVisible(true);
                                }
                            }
                        }
                    }
                }
            }
            if (cntr == 9){
                winLabel.setText("Unentschieden");
                win.setVisible(true);
            }

        }
    };



    public void checking(){

        if((b[0].getText() == "X" && b[1].getText() == "X" && b[2].getText() == "X")||(b[0].getText() == "O" && b[1].getText() == "O" && b[2].getText() == "O")){
            check = true;
        }else if ((b[3].getText() == "X" && b[4].getText() == "X" && b[5].getText() == "X")||(b[3].getText() == "O" && b[4].getText() == "O" && b[5].getText() == "O")){
            check = true;
        }else if ((b[6].getText() == "X" && b[7].getText() == "X" && b[8].getText() == "X")||(b[6].getText() == "O" && b[7].getText() == "O" && b[8].getText() == "O")){
            check = true;
        }else if ((b[0].getText() == "X" && b[3].getText() == "X" && b[6].getText() == "X")||(b[0].getText() == "O" && b[3].getText() == "O" && b[6].getText() == "O")){
            check = true;
        }else if ((b[1].getText() == "X" && b[4].getText() == "X" && b[7].getText() == "X")||(b[1].getText() == "O" && b[4].getText() == "O" && b[7].getText() == "O")){
            check = true;
        }else if ((b[2].getText() == "X" && b[5].getText() == "X" && b[8].getText() == "X")||(b[2].getText() == "O" && b[5].getText() == "O" && b[8].getText() == "O")){
            check = true;
        }else if ((b[0].getText() == "X" && b[4].getText() == "X" && b[8].getText() == "X")||(b[0].getText() == "O" && b[4].getText() == "O" && b[8].getText() == "O")){
            check = true;
        }else if ((b[2].getText() == "X" && b[4].getText() == "X" && b[6].getText() == "X")||(b[2].getText() == "O" && b[4].getText() == "O" && b[6].getText() == "O")){
            check = true;
        }else{
            check = false;
        }
    }
}
