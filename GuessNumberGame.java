import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuessNumberGame extends JFrame {
    private int hiddennumber;
    private int attempts;

    private JLabel labels;
    private JTextField textfields;
    private JButton button;

    private int generateRandomNumber(int smallest, int largest) {
        return (int) (Math.random() * (largest - smallest + 1)) + smallest;
    }

    private void checkGuess() {
        try {
            int guess = Integer.parseInt(textfields.getText());
            attempts++;
            if (guess == hiddennumber) {
                JOptionPane.showMessageDialog(this, "Congratulations! You guessed the number in " + attempts + " attempts!");
                resetGame();
            }
            else if (guess < hiddennumber) {
                JOptionPane.showMessageDialog(this, "Try again. The secret number is higher.");
            }
            else {
                JOptionPane.showMessageDialog(this, "Try again. The secret number is lower.");
            }
            textfields.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid number.");
        }
    }


    public GuessNumberGame() {
        setTitle("Guess The Number Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 200);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(252, 228, 236));

        hiddennumber = generateRandomNumber(1, 100);
        attempts = 0;

        labels = new JLabel("Enter your guess:");
        textfields = new JTextField(10);
        button = new JButton("Submit");


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });

        setLayout(new FlowLayout());
        add(labels);
        add(textfields);
        add(button);

        setVisible(true);
    }



    private void resetGame() {
        hiddennumber = generateRandomNumber(1, 100);
        attempts = 0;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GuessNumberGame();}
        });
    }
}

