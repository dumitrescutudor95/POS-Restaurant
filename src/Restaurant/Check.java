package Restaurant;

//Imports
import java.awt.print.PrinterException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

//Class
public class Check extends javax.swing.JFrame {

    //Pos object
    Pos p;

    //String buffer containing all the Check's data
    StringBuffer sb = new StringBuffer();

    //Pos setter
    public void setPos(Pos p) {
        this.p = p;
    }

    //Constructor
    public Check() {
        initComponents();
    }

    //Method: filling the check
    public void fillCheck() {
        //Refreshing the StringBuffer
        sb.delete(0, sb.length());
        //Adding the local date time to the check
        LocalDateTime ldt = LocalDateTime.now();
        sb.append(ldt.format(DateTimeFormatter.ofPattern("   EEEE dd MMMM YYYY  -  h:mm a", Locale.US)) + "\n");

        sb.append("======================================\n");

        //Adding the waiter's name
        sb.append("   Waiter:" + p.currentWaiter.toString() + "\n");

        sb.append("--------------------------------------------------------------------\n");

        //Adding the products:Products served + Quantity + Prices
        if (p.countSchnitzel > 0) {
            sb.append("   Schnitzel \n   x" + p.countSchnitzel + "\t - " + p.countSchnitzel * p.m.priceSchnitzel + "$\n");
        }
        if (p.countChickenBreasts > 0) {
            sb.append("   Chicken breast \n   x" + p.countChickenBreasts + "\t - " + p.countChickenBreasts * p.m.priceChickenBreast + "$\n");
        }
        if (p.countMashedPotatoes > 0) {
            sb.append("   Mashed potatoes \n   x" + p.countMashedPotatoes + "\t - " + p.countMashedPotatoes * p.m.priceMashedPotatoes + "$\n");
        }
        if (p.countFrenchFries > 0) {
            sb.append("   French fries \n   x" + p.countFrenchFries + "\t - " + p.countFrenchFries * p.m.priceFrenchFries + "$\n");
        }
        if (p.countSummerSalad > 0) {
            sb.append("   Summer salad \n   x" + p.countSummerSalad + "\t - " + p.countSummerSalad * p.m.priceSummerSalad + "$\n");
        }
        if (p.countPickleSalad > 0) {
            sb.append("   Pickle salad \n   x" + p.countPickleSalad + "\t - " + p.countPickleSalad * p.m.pricePickleSalad + "$\n");
        }
        if (p.countBread > 0) {
            sb.append("   Bread \n   x" + p.countBread + "\t - " + p.countBread * p.m.priceBread + "$\n");
        }
        if (p.countSparklingWater > 0) {
            sb.append("   Sparkling water \n   x" + p.countSparklingWater + "\t - " + p.countSparklingWater * p.m.priceWater + "$\n");
        }
        if (p.countStillWater > 0) {
            sb.append("   Still water \n   x" + p.countStillWater + "\t - " + p.countStillWater * p.m.priceWater + "$\n");
        }
        if (p.countCocaCola > 0) {
            sb.append("   Coca Cola \n   x" + p.countCocaCola + "\t - " + p.countCocaCola * p.m.priceJuice + "$\n");
        }
        if (p.countFanta > 0) {
            sb.append("   Fanta \n   x" + p.countFanta + "\t - " + p.countFanta * p.m.priceJuice + "$\n");
        }
        if (p.countSprite > 0) {
            sb.append("   Sprite \n   x" + p.countSprite + "\t - " + p.countSprite * p.m.priceJuice + "$\n");
        }
        sb.append("\n--------------------------------------------------------------------\n");

        //Adding total price
        sb.append("   Total: " + p.orderPrice+"$");

        labelNota.setText(sb.toString());
        labelNota.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        labelNota = new javax.swing.JTextArea();
        buttonPrint = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelNota.setColumns(20);
        labelNota.setRows(5);
        jScrollPane1.setViewportView(labelNota);

        buttonPrint.setText("Print");
        buttonPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonPrint)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Method : Ending + printing the check
    private void buttonPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPrintActionPerformed
        try {
            labelNota.print();
        } catch (PrinterException ex) {
            Logger.getLogger(Check.class.getName()).log(Level.SEVERE, null, ex);
        }
        //After the check is paid,hide the note
        this.setVisible(false);
    }//GEN-LAST:event_buttonPrintActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonPrint;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea labelNota;
    // End of variables declaration//GEN-END:variables
}
