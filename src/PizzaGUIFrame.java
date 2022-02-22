
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class PizzaGUIFrame extends JFrame
{

    String pizzaSize[] = {"Small", "Medium", "Large", "Super"};

    JPanel main = new JPanel();
    JPanel controlPnl = new JPanel();
    JPanel finalPnl = new JPanel();
    JPanel crustPnl = new JPanel();
    JPanel sizePnl = new JPanel();
    JPanel toppingsPnl = new JPanel();
    JPanel optionsPnl = new JPanel();
    JLabel titleLbl = new JLabel("Pizza Time!",JLabel.CENTER);
    JLabel playerWins = new JLabel("Player Wins: 0");
    JLabel cpuWins = new JLabel("CPU Wins: 0");
    JLabel ties = new JLabel("Ties: 0");

    JRadioButton thinCrust = new JRadioButton("Thin");
    JRadioButton regCrust = new JRadioButton("Regular");
    JRadioButton deepCrust = new JRadioButton("Deep-Dish");
    JRadioButton reset = new JRadioButton();

    JCheckBox cheese = new JCheckBox("Cheese");
    JCheckBox pepperoni = new JCheckBox("Pepperoni");
    JCheckBox sausage = new JCheckBox("Sausage");
    JCheckBox peppers = new JCheckBox("Peppers");
    JCheckBox onions = new JCheckBox("Onions");
    JCheckBox goetta = new JCheckBox("goetta");

    Border toppingsBrd = BorderFactory.createTitledBorder("Toppings");
    Border crustBrd = BorderFactory.createTitledBorder("Crust");
    Border sizeBrd = BorderFactory.createTitledBorder("Size");


    JComboBox size = new JComboBox(pizzaSize);

    JButton quitBtn = new JButton("Quit");
    JButton orderBtn = new JButton("Order");
    JButton clearBtn = new JButton("Clear");

    JTextArea orderDisplayArea = new JTextArea(16, 40);
    JScrollPane scroller = new JScrollPane(orderDisplayArea);


    public class storedValue {
        public static int wins;
        public static int losses;
        public static int ties;
        public static int cpuChoice;
    }

    private void cpuRandom() {
        Random rnd = new Random();
        storedValue.cpuChoice = rnd.nextInt(3);
    }

    public PizzaGUIFrame()
    {
        titleLbl.setFont(new Font("Times New Roman", Font.ITALIC, 36));
        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);
        orderDisplayArea.setFont(new Font("Arial", Font.PLAIN, 16));
        quitBtn.setFont(new Font("Sans Serif", Font.BOLD, 24));
        orderBtn.setFont(new Font("Sans Serif", Font.BOLD, 24));
        clearBtn.setFont(new Font("Sans Serif", Font.BOLD, 24));
        playerWins.setFont(new Font("Arial", Font.PLAIN, 16));
        cpuWins.setFont(new Font("Arial", Font.PLAIN, 16));
        ties.setFont(new Font("Arial", Font.PLAIN, 16));
        optionsPnl.setBorder(new EmptyBorder(0,20,0,0));
        toppingsPnl.setBorder(toppingsBrd);
        sizePnl.setBorder(sizeBrd);
        crustPnl.setBorder(crustBrd);
        finalPnl.setBorder(new EmptyBorder(0,0,0,10));

        setTitle("Pizza Time!");
        setSize(900, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createGUI();
        enableButtons();

        setVisible(true);
    }

    private void createGUI()
    {
        main.setLayout(new BorderLayout());

        ButtonGroup crustBg = new ButtonGroup();
        crustBg.add(thinCrust);
        crustBg.add(regCrust);
        crustBg.add(deepCrust);
        crustBg.add(reset);

        controlPnl.setLayout(new GridLayout(1,3 ));
        controlPnl.add(orderBtn);
        controlPnl.add(clearBtn);
        controlPnl.add(quitBtn);
        titleLbl.setFont(new Font("Serif", Font.PLAIN, 24));

        sizePnl.add(size);

        crustPnl.setLayout(new BoxLayout(crustPnl, BoxLayout.Y_AXIS));
        crustPnl.add(thinCrust);
        crustPnl.add(regCrust);
        crustPnl.add(deepCrust);

        toppingsPnl.setLayout(new BoxLayout(toppingsPnl, BoxLayout.Y_AXIS));
        toppingsPnl.add(cheese);
        toppingsPnl.add(pepperoni);
        toppingsPnl.add(sausage);
        toppingsPnl.add(peppers);
        toppingsPnl.add(onions);
        toppingsPnl.add(goetta);

        optionsPnl.setLayout(new BoxLayout(optionsPnl, BoxLayout.Y_AXIS));
        optionsPnl.add(crustPnl);
        optionsPnl.add(toppingsPnl);

        finalPnl.add(scroller);


        main.add(BorderLayout.NORTH, titleLbl);
        main.add(BorderLayout.CENTER, optionsPnl);
        main.add(BorderLayout.WEST, sizePnl);
        main.add(BorderLayout.EAST, finalPnl);
        main.add(BorderLayout.SOUTH, controlPnl);

        add(main);
    }

    private void enableButtons()
    {


        orderBtn.addActionListener
                (
                        e -> {
                            Double subTotal = 0.00;
                            Double orderTotal;
                            Double tax;
                            String crst = "";
                            String sz;
                            String pzPrice;
                            ArrayList<String> ingredients = new ArrayList<String>();

                            if ((size.getSelectedItem()).equals("Small")) {
                                subTotal = subTotal + 8.00;
                                sz = "Small";
                                pzPrice = "8.00";
                            } else if ((size.getSelectedItem()).equals("Medium")) {
                                subTotal = subTotal + 12.00;
                                sz = "Medium";
                                pzPrice = "12.00";
                            } else if ((size.getSelectedItem()).equals("Large")) {
                                subTotal = subTotal + 16.00;
                                sz = "Large";
                                pzPrice = "16.00";
                            } else  {
                                subTotal = subTotal + 20.00;
                                sz = "Super";
                                pzPrice = "20.00";
                            }

                            Double count = 0.00;
                            if (cheese.isSelected()) {
                                subTotal = subTotal + 1.00;
                                ingredients.add("Cheese");
                                count++;
                            } if (pepperoni.isSelected()) {
                                subTotal = subTotal + 1.00;
                                ingredients.add("Pepperoni");
                                count++;
                            } if (sausage.isSelected()) {
                                subTotal = subTotal + 1.00;
                                ingredients.add("Sausage");
                                count++;
                            } if (peppers.isSelected()) {
                                subTotal = subTotal + 1.00;
                                ingredients.add("Peppers");
                                count++;
                            } if (onions.isSelected()) {
                                subTotal = subTotal + 1.00;
                                ingredients.add("Onions");
                                count++;
                            } if (goetta.isSelected()) {
                                subTotal = subTotal + 1.00;
                                count++;
                                ingredients.add("Goetta");
                            }

                            if (regCrust.isSelected()) {
                                crst = "Regular Crust";
                            } else if (thinCrust.isSelected()) {
                                crst = "Thin Crust";
                            } else if (deepCrust.isSelected()) {
                                crst = "Deep-Dish";
                            }

                            tax = subTotal * 0.07;
                            orderTotal = subTotal + tax;

                            orderDisplayArea.append("==============================" + "\n" +
                                    crst + ", " + sz + "\t" + pzPrice + "\n" +
                                    ingredients + "\n" + "\t\t" + String.format("%.2f",count) + "\n" +
                                    "Subtotal: " + "\t\t" + String.format("%.2f",subTotal) + "\n" +
                                    "Tax: " + "\t\t" + String.format("%.2f", tax) + "\n" +
                                    "----------------------------------------" + "\n" +
                                    "Total: " + "\t\t" + String.format("%.2f", orderTotal) + "\n" +
                                    "=============================="
                                    );

                        }
                );
        clearBtn.addActionListener
                (
                        e -> {
                            orderDisplayArea.setText("");

                            cheese.setSelected(false);
                            pepperoni.setSelected(false);
                            sausage.setSelected(false);
                            peppers.setSelected(false);
                            onions.setSelected(false);
                            goetta.setSelected(false);

                            reset.setSelected(true);
                        }
                );

        quitBtn.addActionListener
                (
                        (ActionEvent ae) -> System.exit(0)
                );
    }

}

//class CustomComboBox extends JLabel implements ListCellRenderer {
//
//    @Override
//    public Component getListCellRendererComponent(JList list, Object value,
//                                                  int index, boolean isSelected, boolean cellHasFocus) {
//
//        JLabel label = new JLabel() {
//            public Dimension getPreferredSize() {
//                return new Dimension(50, 25);
//            }
//        };
//        label.setText(String.valueOf(value));
//
//        return label;
//    }
//}
