
package Restaurant;

//Imports
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

//Class
public class RestaurantStatus extends javax.swing.JFrame {

    //Manager
    Manager m;

    //List:finished days
    DefaultListModel model = new DefaultListModel();
    //List:Staff
    DefaultTableModel model2;

    //Constructor
    public RestaurantStatus(Manager m) {
        initComponents();
        this.m = m;
        //Initializing the finished days's list
        listaZile.setModel(model);
        //And populating it
        fillDaysList();
        //Initializing the staff's list
        model2 = (DefaultTableModel) tableStaff.getModel();
        //And populating it
        fillStaffTable();
    }

    //Method: fill the worked days's list
    public void fillDaysList() {
        for (DayStatus sZ : m.listFinishedDays) {
            model.addElement(sZ.toString());
            System.out.println("Worked day added in table");
        }
        labelBugetRestaurant.setText(String.valueOf(m.getRestaurantBuget()));
    }
    
//Method:fill the staff's table
    public void fillStaffTable() {

        //Adding manager
        model2.getDataVector().removeAllElements();
        model2.addRow(new Object[]{"Manager",m.toString(), m.getSeniority(), m.getSalary()});
        //Adding cooks
        for (Cook b : m.listCooks) {
            model2.addRow(new Object[]{"Cook",b.toString(), b.getSeniority(), b.getSalary()});
        }
        //Adding waiters
        for (Waiter o : m.listWaiters) {
            model2.addRow(new Object[]{"Waiter",o.toString(), o.getSeniority(), o.getSalary()});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelDays = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaZile = new javax.swing.JList<>();
        labelRestaurantBudget = new javax.swing.JLabel();
        labelBugetRestaurant = new javax.swing.JLabel();
        labelStaff = new javax.swing.JLabel();
        butonPaySalaries = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableStaff = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        buttonBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelDays.setText("Days");

        jScrollPane1.setViewportView(listaZile);

        labelRestaurantBudget.setText("Restaurant Budget");

        labelStaff.setText("Staff");

        butonPaySalaries.setText("Pay Salaries");
        butonPaySalaries.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonPaySalariesActionPerformed(evt);
            }
        });

        tableStaff.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Position", "Name", "Seniority", "Salary"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tableStaff);

        jLabel3.setText("( PxD = Period of x dDays)");

        buttonBack.setText("Back");
        buttonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDays, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelStaff)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelRestaurantBudget)
                                .addGap(18, 18, 18)
                                .addComponent(labelBugetRestaurant, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(butonPaySalaries)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonBack, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(labelDays, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelRestaurantBudget)
                    .addComponent(labelBugetRestaurant, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(labelStaff)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butonPaySalaries)
                    .addComponent(buttonBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //Method:Paying salaries
    
    private void butonPaySalariesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonPaySalariesActionPerformed
        m.paySalaries();
        labelBugetRestaurant.setText(String.valueOf(m.getRestaurantBuget()));
        
        JOptionPane.showMessageDialog(null,"The salaries werre paid","Done", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_butonPaySalariesActionPerformed

    //Method: close(When pressing the Back button)
    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackActionPerformed
this.setVisible(false); 
    }//GEN-LAST:event_buttonBackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butonPaySalaries;
    private javax.swing.JButton buttonBack;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelBugetRestaurant;
    private javax.swing.JLabel labelDays;
    private javax.swing.JLabel labelRestaurantBudget;
    private javax.swing.JLabel labelStaff;
    private javax.swing.JList<String> listaZile;
    private javax.swing.JTable tableStaff;
    // End of variables declaration//GEN-END:variables
}
