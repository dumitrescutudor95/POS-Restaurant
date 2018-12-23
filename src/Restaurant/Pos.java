package Restaurant;

//Imports
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

//Class
public class Pos extends javax.swing.JFrame implements Serializable {

    //Files containg data about the Staff:the manager,waiters and cooks
    File managerFile = new File("manager.txt");
    File waitersFile = new File("ospatari.txt");
    File cooksFile = new File("listaBucatari.txt");

    //Current waiter
    Waiter currentWaiter;

    //Daily profit + the restaurant's budget
    private double dailyProfit;
    private double restaurantBudget;

    //Manager
    Manager m;

    //Check
    Check n;

    //RestaurantStatus object:holding the daily profit,employers,budget,
    //and the salary pay method
    public RestaurantStatus statusRestaurant;

    //Table: ordered products+price
    DefaultTableModel model = new DefaultTableModel();

    //Timer: showing the date and time
    Timer t = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            LocalDateTime ldt = LocalDateTime.now();
            labelTime.setText(ldt.format(DateTimeFormatter.ofPattern("EEEE dd MMMM YYYY  -  h:mm a", new Locale("ro", "RO"))));
        }
    });

//Order price
    public double orderPrice;

    //Order items count
    int countSchnitzel;
    int countChickenBreasts;
    int countMashedPotatoes;
    int countFrenchFries;
    int countSummerSalad;
    int countPickleSalad;
    int countBread;
    int countSparklingWater;
    int countStillWater;
    int countCocaCola;
    int countFanta;
    int countSprite;

//Constructor
    public Pos() {
        initComponents();
        //Setting the table
        model = (DefaultTableModel) listaComanda.getModel();
        //Starting program
        startProgram();
        //Hiding buttons
        hideButtons();
        //Start timer
        t.start();

    }

    //Check setter
    public void setCheck(Check n) {
        this.n = n;
    }

    //Method:rewriting the files
    public void rewritingFile() {
        try {
            //First step:emptying the files
            Formatter f1 = new Formatter(waitersFile);
            f1.format("");
            Formatter f2 = new Formatter(managerFile);
            f2.format("");
            Formatter f3 = new Formatter(cooksFile);
            f3.format("");

            //Rewriting the waiters's file
            FileOutputStream fo = new FileOutputStream(waitersFile);
            ObjectOutputStream output = new ObjectOutputStream(fo);
            for (Waiter o : m.listWaiters) {
                output.writeObject(o);
            }
            fo.close();
            output.close();

            //Rewriting the manager's file
            FileOutputStream fo2 = new FileOutputStream(managerFile);
            ObjectOutputStream output2 = new ObjectOutputStream(fo2);
            output2.writeObject(m);
            fo2.close();
            output2.close();

            //Rewriting the cooks's file
            FileOutputStream fo3 = new FileOutputStream(cooksFile);
            ObjectOutputStream output3 = new ObjectOutputStream(fo3);
            for (Cook o : m.listCooks) {
                output3.writeObject(o);
            }
            fo3.close();
            output3.close();

        } catch (FileNotFoundException exception) {
        } catch (IOException exception2) {
        }

    }

    //Method:hiding the buttons
    public void hideButtons() {
        butonAddSparklingWater.setVisible(false);
        butonAddStillWater.setVisible(false);
        butonAddFrenchFries.setVisible(false);
        butonAddBread.setVisible(false);
        butonAddCocaCola.setVisible(false);
        butonAddFanta.setVisible(false);
        butonAddChickenBreast.setVisible(false);
        butonAddMashedPotatoes.setVisible(false);
        butonAddPickleSalad.setVisible(false);
        butonAddSummerSalad.setVisible(false);
        butonAddSchnitzel.setVisible(false);
        butonAddSprite.setVisible(false);
        incheieComanda.setVisible(false);
        jScrollPane4.setVisible(false);
        jScrollPane2.setVisible(false);
        labelOrder.setVisible(false);
        jTotal.setVisible(false);
        labelPretTotal.setVisible(false);
        labelNameWaiter.setVisible(false);
        labelCurrentWaiter.setVisible(false);
    }

    //Method:reset order
    public void resetOrder() {
        countSchnitzel = 0;
        countChickenBreasts = 0;
        countMashedPotatoes = 0;
        countFrenchFries = 0;
        countSummerSalad = 0;
        countPickleSalad = 0;
        countBread = 0;
        countSparklingWater = 0;
        countStillWater = 0;
        countCocaCola = 0;
        countFanta = 0;
        countSprite = 0;
        orderPrice = 0;
    }

    ;
    
    //Method:starting the program
    public void startProgram() {
        //Reading the manager's file
        try {
            FileInputStream fis3 = new FileInputStream(managerFile);
            ObjectInputStream ois3 = new ObjectInputStream(fis3);
            while (true) {
                m = (Manager) ois3.readObject();
                System.out.println("The manager was read from the file");
            }
        } catch (FileNotFoundException ex) {
            ex.toString();
        } catch (IOException ioe) {
            System.out.println(ioe.toString());
        } catch (ClassNotFoundException cnfe) {
            System.out.println(cnfe.toString());
        }

        //Adding the waiters to the comboBox
        if (managerFile.exists()) {
            for (Waiter o : m.listWaiters) {
                comboBoxWaiter.addItem(o.toString());
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        incheieComanda = new javax.swing.JButton();
        butonAddSchnitzel = new javax.swing.JButton();
        butonAddChickenBreast = new javax.swing.JButton();
        butonAddMashedPotatoes = new javax.swing.JButton();
        butonAddFrenchFries = new javax.swing.JButton();
        butonAddSummerSalad = new javax.swing.JButton();
        butonAddPickleSalad = new javax.swing.JButton();
        butonAddBread = new javax.swing.JButton();
        labelOrder = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaComanda = new javax.swing.JTable();
        jTotal = new javax.swing.JLabel();
        labelPretTotal = new javax.swing.JLabel();
        butonAddSparklingWater = new javax.swing.JButton();
        butonAddCocaCola = new javax.swing.JButton();
        butonAddFanta = new javax.swing.JButton();
        butonAddStillWater = new javax.swing.JButton();
        butonAddSprite = new javax.swing.JButton();
        jLabelSelectWaiter = new javax.swing.JLabel();
        labelCurrentWaiter = new javax.swing.JLabel();
        labelNameWaiter = new javax.swing.JLabel();
        comboBoxWaiter = new javax.swing.JComboBox<>();
        bLogin = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelOspatarCurent = new javax.swing.JTable();
        bLogout = new javax.swing.JButton();
        labelTime = new javax.swing.JLabel();
        bEndDay = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        bAddWaiter = new javax.swing.JMenuItem();
        bAddCook = new javax.swing.JMenuItem();
        bAddChangeManager = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        incheieComanda.setBackground(new java.awt.Color(0, 0, 0));
        incheieComanda.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        incheieComanda.setText("Check ");
        incheieComanda.setToolTipText("");
        incheieComanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incheieComandaActionPerformed(evt);
            }
        });

        butonAddSchnitzel.setBackground(new java.awt.Color(153, 0, 0));
        butonAddSchnitzel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        butonAddSchnitzel.setText("Schnitzel");
        butonAddSchnitzel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonAddSchnitzelActionPerformed(evt);
            }
        });

        butonAddChickenBreast.setBackground(new java.awt.Color(153, 0, 0));
        butonAddChickenBreast.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        butonAddChickenBreast.setText("Chicken Breast");
        butonAddChickenBreast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonAddChickenBreastActionPerformed(evt);
            }
        });

        butonAddMashedPotatoes.setBackground(new java.awt.Color(255, 153, 0));
        butonAddMashedPotatoes.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        butonAddMashedPotatoes.setText("Mashed Potatoes");
        butonAddMashedPotatoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonAddMashedPotatoesActionPerformed(evt);
            }
        });

        butonAddFrenchFries.setBackground(new java.awt.Color(255, 153, 0));
        butonAddFrenchFries.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        butonAddFrenchFries.setText("French Fries");
        butonAddFrenchFries.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonAddFrenchFriesActionPerformed(evt);
            }
        });

        butonAddSummerSalad.setBackground(new java.awt.Color(102, 255, 153));
        butonAddSummerSalad.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        butonAddSummerSalad.setText("Summer Salad");
        butonAddSummerSalad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonAddSummerSaladActionPerformed(evt);
            }
        });

        butonAddPickleSalad.setBackground(new java.awt.Color(102, 255, 153));
        butonAddPickleSalad.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        butonAddPickleSalad.setText("Pickle Salad");
        butonAddPickleSalad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonAddPickleSaladActionPerformed(evt);
            }
        });

        butonAddBread.setBackground(new java.awt.Color(153, 153, 0));
        butonAddBread.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        butonAddBread.setText("Bread");
        butonAddBread.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonAddBreadActionPerformed(evt);
            }
        });

        labelOrder.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelOrder.setText("Order");

        listaComanda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produs", "Pret"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(listaComanda);

        jTotal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTotal.setText("Total:");

        labelPretTotal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelPretTotal.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        butonAddSparklingWater.setBackground(new java.awt.Color(51, 153, 255));
        butonAddSparklingWater.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        butonAddSparklingWater.setText("Sparkling");
        butonAddSparklingWater.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonAddSparklingWaterActionPerformed(evt);
            }
        });

        butonAddCocaCola.setBackground(new java.awt.Color(255, 0, 51));
        butonAddCocaCola.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        butonAddCocaCola.setText("Coca Cola");
        butonAddCocaCola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonAddCocaColaActionPerformed(evt);
            }
        });

        butonAddFanta.setBackground(new java.awt.Color(255, 102, 51));
        butonAddFanta.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        butonAddFanta.setText("Fanta");
        butonAddFanta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonAddFantaActionPerformed(evt);
            }
        });

        butonAddStillWater.setBackground(new java.awt.Color(51, 153, 255));
        butonAddStillWater.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        butonAddStillWater.setText("Still Water");
        butonAddStillWater.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonAddStillWaterActionPerformed(evt);
            }
        });

        butonAddSprite.setBackground(new java.awt.Color(0, 153, 51));
        butonAddSprite.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        butonAddSprite.setText("Sprite");
        butonAddSprite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonAddSpriteActionPerformed(evt);
            }
        });

        jLabelSelectWaiter.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabelSelectWaiter.setText("Select Waiter");

        labelCurrentWaiter.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        labelCurrentWaiter.setText("Current Waiter");

        labelNameWaiter.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        comboBoxWaiter.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        bLogin.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        bLogin.setText("Log in");
        bLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoginActionPerformed(evt);
            }
        });

        tabelOspatarCurent.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        tabelOspatarCurent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product", "Quantity sold"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tabelOspatarCurent);

        bLogout.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        bLogout.setText("Log out");
        bLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLogoutActionPerformed(evt);
            }
        });

        labelTime.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        bEndDay.setText("End day");
        bEndDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEndDayActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        bAddWaiter.setText("Add waiter");
        bAddWaiter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddWaiterActionPerformed(evt);
            }
        });
        jMenu1.add(bAddWaiter);

        bAddCook.setText("Add cook");
        bAddCook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddCookActionPerformed(evt);
            }
        });
        jMenu1.add(bAddCook);

        bAddChangeManager.setText("Add/Change manager");
        bAddChangeManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddChangeManagerActionPerformed(evt);
            }
        });
        jMenu1.add(bAddChangeManager);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelTime, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabelSelectWaiter)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(comboBoxWaiter, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(bLogin)
                                    .addGap(18, 18, 18)
                                    .addComponent(bLogout)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelCurrentWaiter)
                                .addGap(18, 18, 18)
                                .addComponent(labelNameWaiter, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bEndDay)))
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(labelPretTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(89, 89, 89)
                                .addComponent(incheieComanda, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(labelOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(butonAddStillWater, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(butonAddSparklingWater)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(butonAddCocaCola, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(butonAddFanta, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(butonAddSprite, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(butonAddSchnitzel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(butonAddChickenBreast))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(butonAddMashedPotatoes))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(butonAddFrenchFries, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(butonAddSummerSalad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(butonAddPickleSalad, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(butonAddBread)))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelTime, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSelectWaiter)
                            .addComponent(comboBoxWaiter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bLogin)
                            .addComponent(bLogout))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCurrentWaiter)
                            .addComponent(labelNameWaiter, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(butonAddSchnitzel)
                            .addComponent(butonAddFrenchFries))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(butonAddMashedPotatoes)
                            .addComponent(butonAddChickenBreast)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(butonAddSummerSalad)
                            .addGap(18, 18, 18)
                            .addComponent(butonAddPickleSalad))
                        .addComponent(butonAddBread, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butonAddSparklingWater)
                    .addComponent(butonAddStillWater)
                    .addComponent(butonAddCocaCola)
                    .addComponent(butonAddFanta)
                    .addComponent(butonAddSprite))
                .addGap(18, 18, 18)
                .addComponent(labelOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(incheieComanda, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPretTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bEndDay)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Method:showing the order's Final price
    public void afisarePretTotal() {
        labelPretTotal.setText(String.valueOf(orderPrice));
    }

    //Adding Schnitzel to the order
    private void butonAddSchnitzelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonAddSchnitzelActionPerformed
        countSchnitzel++;
        model.addRow(new Object[]{"Schnitzel", m.priceSchnitzel});
        orderPrice += m.priceSchnitzel;
        afisarePretTotal();
    }//GEN-LAST:event_butonAddSchnitzelActionPerformed

    //Adding Mashed potatoes to the order
    private void butonAddMashedPotatoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonAddMashedPotatoesActionPerformed
        countMashedPotatoes++;
        model.addRow(new Object[]{"Mashed potatoes", m.priceMashedPotatoes});
        orderPrice += m.priceMashedPotatoes;
        afisarePretTotal();
    }//GEN-LAST:event_butonAddMashedPotatoesActionPerformed

    //Adding Pickle salad to the order 
    private void butonAddPickleSaladActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonAddPickleSaladActionPerformed
        countPickleSalad++;
        model.addRow(new Object[]{"Pickle salad", m.pricePickleSalad});
        orderPrice += m.pricePickleSalad;
        afisarePretTotal();
    }//GEN-LAST:event_butonAddPickleSaladActionPerformed

    //Adding chicken breast to the order
    private void butonAddChickenBreastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonAddChickenBreastActionPerformed
        countChickenBreasts++;
        model.addRow(new Object[]{"Chicken breast", m.priceChickenBreast});
        orderPrice += m.priceChickenBreast;
        afisarePretTotal();
    }//GEN-LAST:event_butonAddChickenBreastActionPerformed

    //Adding Summer salad to the order
    private void butonAddSummerSaladActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonAddSummerSaladActionPerformed
        countSummerSalad++;
        model.addRow(new Object[]{"Summer salad", m.priceSummerSalad});
        orderPrice += m.priceSummerSalad;
        afisarePretTotal();
    }//GEN-LAST:event_butonAddSummerSaladActionPerformed

    //Adding French Fries to the order
    private void butonAddFrenchFriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonAddFrenchFriesActionPerformed
        countFrenchFries++;
        model.addRow(new Object[]{"French fries", m.priceFrenchFries});
        orderPrice += m.priceFrenchFries;
        afisarePretTotal();
    }//GEN-LAST:event_butonAddFrenchFriesActionPerformed

    //Adding Bread to the order
    private void butonAddBreadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonAddBreadActionPerformed
        countBread++;
        model.addRow(new Object[]{"Bread", m.priceBread});
        orderPrice += m.priceBread;
        afisarePretTotal();
    }//GEN-LAST:event_butonAddBreadActionPerformed

    //Adding Still water to the order
    private void butonAddStillWaterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonAddStillWaterActionPerformed
        countStillWater++;
        model.addRow(new Object[]{"Still water", m.priceWater});
        orderPrice += m.priceWater;
        afisarePretTotal();
    }//GEN-LAST:event_butonAddStillWaterActionPerformed

    //Adding Sparkling water to the order
    private void butonAddSparklingWaterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonAddSparklingWaterActionPerformed
        countSparklingWater++;
        model.addRow(new Object[]{"Sparkling water", m.priceWater});
        orderPrice += m.priceWater;
        afisarePretTotal();
    }//GEN-LAST:event_butonAddSparklingWaterActionPerformed

    //Adding Coca cola to the order
    private void butonAddCocaColaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonAddCocaColaActionPerformed
        countCocaCola++;
        model.addRow(new Object[]{"Coca Cola", m.priceJuice});
        orderPrice += m.priceJuice;
        afisarePretTotal();
    }//GEN-LAST:event_butonAddCocaColaActionPerformed

    //Adding Fanta to the order
    private void butonAddFantaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonAddFantaActionPerformed
        countFanta++;
        model.addRow(new Object[]{"Fanta", m.priceJuice});
        orderPrice += m.priceJuice;
        afisarePretTotal();
    }//GEN-LAST:event_butonAddFantaActionPerformed

    //Adding Sprite to the order
    private void butonAddSpriteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonAddSpriteActionPerformed
        countSprite++;
        model.addRow(new Object[]{"Sprite", m.priceJuice});
        orderPrice += m.priceJuice;
        afisarePretTotal();
    }//GEN-LAST:event_butonAddSpriteActionPerformed

    //Method:Filling the waiters's Statistics table
    private void showSalesTable() {

        //Getting the waiter from the list
        int index = comboBoxWaiter.getSelectedIndex();
        Waiter o = m.listWaiters.get(index);

        //Reseting the table
        DefaultTableModel model = (DefaultTableModel) tabelOspatarCurent.getModel();
        model.getDataVector().removeAllElements();

        //Putting his activity in the table
        model.addRow(new Object[]{"Schnitzel", o.soldSchnitzel});
        model.addRow(new Object[]{"Chicken breast", o.soldChickenBreasts});
        model.addRow(new Object[]{"Mashed potatoes", o.soldMashedPotatoes});
        model.addRow(new Object[]{"French fries", o.soldFrenchFries});
        model.addRow(new Object[]{"Summer salad", o.soldSummerSalad});
        model.addRow(new Object[]{"Pickle salad", o.soldpickleSalad});
        model.addRow(new Object[]{"Bread", o.soldBread});
        model.addRow(new Object[]{"Sparkling water", o.soldSparklingWater});
        model.addRow(new Object[]{"Still water", o.soldStillWater});
        model.addRow(new Object[]{"Cola", o.soldCocaCola});
        model.addRow(new Object[]{"Fanta", o.soldFanta});
        model.addRow(new Object[]{"Sprite", o.soldSprite});
    }

    //Method:Ending the order
    private void incheieComandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_incheieComandaActionPerformed
        //Selecting the current waiter
        int index = comboBoxWaiter.getSelectedIndex();
        currentWaiter = m.listWaiters.get(index);
        Waiter o = m.listWaiters.get(index);

        //Preparing and showing the ckeck
        n.fillCheck();
        n.setVisible(true);

        //Removing the sold products from the company's property
        m.schnitzel -= countSchnitzel;
        m.chickenBreasts -= countChickenBreasts;
        m.mashedPotatoes -= countMashedPotatoes;
        m.frenchFries -= countFrenchFries;
        m.summerSalad -= countSummerSalad;
        m.pickleSald -= countPickleSalad;
        m.bread -= countBread;
        m.sparklingWater -= countSparklingWater;
        m.stillWater -= countStillWater;
        m.cola -= countCocaCola;
        m.fanta -= countFanta;
        m.sprite -= countSprite;

        //Adding the number of sold products to the waiter's data
        o.soldSchnitzel += countSchnitzel;
        o.soldChickenBreasts += countChickenBreasts;
        o.soldMashedPotatoes += countMashedPotatoes;
        o.soldFrenchFries += countFrenchFries;
        o.soldSummerSalad += countSummerSalad;
        o.soldpickleSalad += countPickleSalad;
        o.soldBread += countBread;
        o.soldCocaCola += countCocaCola;
        o.soldFanta += countFanta;
        o.soldSprite += countSprite;
        o.soldSparklingWater += countSparklingWater;
        o.soldStillWater += countStillWater;

        //Increasing the daily's profit
        m.increasingDailyProfit(orderPrice);
        //Increasing the restaurant's budget
        m.increasingRestaurantBudget(orderPrice);

        //Showing this data to the console:
        System.out.println("Daily profit: " + m.getDailyProfit());
        System.out.println("Restaurant's budget:" + m.getRestaurantBuget());

        //Reseting the order
        resetOrder();
        labelPretTotal.setText("");
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }

        //Refresh
        
        rewritingFile();

        showSalesTable();

        hideButtons();

    }//GEN-LAST:event_incheieComandaActionPerformed

    //Method:adding waiters from the Menu bar
    
    private void bAddWaiterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddWaiterActionPerformed
        String firstName= JOptionPane.showInputDialog(null, "Insert first name", "Please insert first name", JOptionPane.INFORMATION_MESSAGE);
        String lastName = JOptionPane.showInputDialog(null, "Insert last name", "Please insert last name", JOptionPane.INFORMATION_MESSAGE);
        String s = JOptionPane.showInputDialog(null, "Insert salary", "Please insert salary", JOptionPane.INFORMATION_MESSAGE);
        int salary = Integer.parseInt(s);

        Waiter o = new Waiter(m, firstName, lastName, salary);
        m.listWaiters.add(o);
        comboBoxWaiter.addItem(o.toString());

        rewritingFile();

    }//GEN-LAST:event_bAddWaiterActionPerformed

    //Waiter login method
    private void bLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLoginActionPerformed
        butonAddSparklingWater.setVisible(true);
        butonAddStillWater.setVisible(true);
        butonAddFrenchFries.setVisible(true);
        butonAddBread.setVisible(true);
        butonAddCocaCola.setVisible(true);
        butonAddFanta.setVisible(true);
        butonAddChickenBreast.setVisible(true);
        butonAddMashedPotatoes.setVisible(true);
        butonAddPickleSalad.setVisible(true);
        butonAddSummerSalad.setVisible(true);
        butonAddSchnitzel.setVisible(true);
        butonAddSprite.setVisible(true);
        incheieComanda.setVisible(true);
        jScrollPane4.setVisible(true);
        jScrollPane2.setVisible(true);
        labelOrder.setVisible(true);
        jTotal.setVisible(true);
        labelPretTotal.setVisible(true);
        labelNameWaiter.setVisible(true);
        labelCurrentWaiter.setVisible(true);

        int index = comboBoxWaiter.getSelectedIndex();
        currentWaiter = m.listWaiters.get(index);
        labelNameWaiter.setText(currentWaiter.toString());

        showSalesTable();
    }//GEN-LAST:event_bLoginActionPerformed

    //Waiter logout method
    private void bLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLogoutActionPerformed
        hideButtons();
        resetOrder();
    }//GEN-LAST:event_bLogoutActionPerformed

    //Method:Adding / Changing the manager
    private void bAddChangeManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddChangeManagerActionPerformed
        String firstName = JOptionPane.showInputDialog(null, "Insert first name", "Please insert first name", JOptionPane.INFORMATION_MESSAGE);
        String lastName = JOptionPane.showInputDialog(null, "Insert last name", "Please insert last name", JOptionPane.INFORMATION_MESSAGE);
        String s = JOptionPane.showInputDialog(null, "Insert salary", "Please insert salary", JOptionPane.INFORMATION_MESSAGE);
        int salary = Integer.parseInt(s);

        m = new Manager(firstName, lastName, salary);

        rewritingFile();
    }//GEN-LAST:event_bAddChangeManagerActionPerformed

    //Metehod:Adding cooks from the menu bar
    private void bAddCookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddCookActionPerformed
        String firstName = JOptionPane.showInputDialog(null, "Insert first name", "Please insert first name", JOptionPane.INFORMATION_MESSAGE);
        String lastName = JOptionPane.showInputDialog(null, "Insert last name", "Please insert last name", JOptionPane.INFORMATION_MESSAGE);
        String s = JOptionPane.showInputDialog(null, "Insert salary", "Please insert salary", JOptionPane.INFORMATION_MESSAGE);
        int salary = Integer.parseInt(s);

        Cook o = new Cook(m, firstName, lastName, salary);
        m.listCooks.add(o);

        rewritingFile();


    }//GEN-LAST:event_bAddCookActionPerformed

    //Method:End day
    private void bEndDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEndDayActionPerformed
        RestaurantStatus sR = new RestaurantStatus(m);
        sR.model.clear();
        statusRestaurant = sR;
        m.endDay();
        statusRestaurant.fillDaysList();
        statusRestaurant.setVisible(true);
        rewritingFile();

        sR.m = this.m;
    }//GEN-LAST:event_bEndDayActionPerformed

    public static void main(String args[]) {

        Pos pos = new Pos();
        Check n = new Check();
        n.setPos(pos);
        pos.setCheck(n);

        pos.setVisible(true);
        pos.setDefaultCloseOperation(EXIT_ON_CLOSE);
        n.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem bAddChangeManager;
    private javax.swing.JMenuItem bAddCook;
    private javax.swing.JMenuItem bAddWaiter;
    private javax.swing.JButton bEndDay;
    private javax.swing.JButton bLogin;
    private javax.swing.JButton bLogout;
    private javax.swing.JButton butonAddBread;
    private javax.swing.JButton butonAddChickenBreast;
    private javax.swing.JButton butonAddCocaCola;
    private javax.swing.JButton butonAddFanta;
    private javax.swing.JButton butonAddFrenchFries;
    private javax.swing.JButton butonAddMashedPotatoes;
    private javax.swing.JButton butonAddPickleSalad;
    private javax.swing.JButton butonAddSchnitzel;
    private javax.swing.JButton butonAddSparklingWater;
    private javax.swing.JButton butonAddSprite;
    private javax.swing.JButton butonAddStillWater;
    private javax.swing.JButton butonAddSummerSalad;
    private javax.swing.JComboBox<String> comboBoxWaiter;
    private javax.swing.JButton incheieComanda;
    private javax.swing.JLabel jLabelSelectWaiter;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel jTotal;
    private javax.swing.JLabel labelCurrentWaiter;
    private javax.swing.JLabel labelNameWaiter;
    private javax.swing.JLabel labelOrder;
    private javax.swing.JLabel labelPretTotal;
    private javax.swing.JLabel labelTime;
    private javax.swing.JTable listaComanda;
    private javax.swing.JTable tabelOspatarCurent;
    // End of variables declaration//GEN-END:variables
}
