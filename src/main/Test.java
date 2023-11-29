package main;


import form.Main;
import form.QLSinhVien;
import form.QLNhanVien;
import form.QLSach;
import form.ThongKe;
import java.awt.Component;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import menu.EventMenu;
import net.miginfocom.swing.MigLayout;
import utils.MsgBox;

public class Test extends javax.swing.JFrame {

    public Test() {
        initComponents();
        layer.setLayout(new MigLayout("fill, inset 0", "[fill]", "[fill]"));
        layer.setLayer(menu, JLayeredPane.POPUP_LAYER);
        layer.add(menu, "pos 0 0.5al 60 n", 0);
        menu.addEvent(new EventMenu() {
            @Override
            public void menuSelected(int index) {
                if (index == 0) {
                    showForm(new Main());
                   
                } else if (index == 1) {
                    showForm(new QLNhanVien());
                }  else if (index == 2) {
                    showForm(new QLSach());
                }else if (index == 3) {
                    showForm(new QLSinhVien());
                }else if (index == 5) {
                    showForm(new ThongKe());
                }else if (index == 8) {
                    if (MsgBox.confirm(main, "Bạn có muốn thoát không ?")) {
                        System.exit(0);
                    }
                }
            }
        });
    }

    private void showForm(Component com) {
        main.removeAll();
        main.add(com);
        main.repaint();
        main.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new menu.Menu();
        layer = new javax.swing.JLayeredPane();
        main = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        main.setBackground(new java.awt.Color(30, 30, 30));
        main.setLayout(new java.awt.BorderLayout());

        layer.setLayer(main, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layerLayout = new javax.swing.GroupLayout(layer);
        layer.setLayout(layerLayout);
        layerLayout.setHorizontalGroup(
            layerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, 1081, Short.MAX_VALUE)
        );
        layerLayout.setVerticalGroup(
            layerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layer)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layer)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Test().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane layer;
    private javax.swing.JPanel main;
    private menu.Menu menu;
    // End of variables declaration//GEN-END:variables
}
