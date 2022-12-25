import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
import java.beans.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class EmployeEnterance extends javax.swing.JFrame {


    public EmployeEnterance() {
        initComponents();
    }
   public ResultSet resultSet() throws SQLException {
     Connection connection = null;
       DBHelper dBHelper = new DBHelper();
       java.sql.Statement statement = null;
       ResultSet resultSet = null;
       Employe employe =new Employe();
       employe.setPassword(tbxPassword.getText());
       employe.setE_mail(tbxEmail.getText());
       try {
           String query = "SELECT * FROM Employe WHERE E_mail = '" + employe.getE_mail() + "' AND password = '" + employe.getPassword(tbxPassword.getText()) + "'";

           connection = dBHelper.getConnection();
           statement = connection.createStatement();
           resultSet = statement.executeQuery(query);

       } catch (SQLException exception) {
           System.out.println("Error : " + dBHelper.showErrorMessage(exception));
           System.out.println("error kodu :"+exception.getErrorCode());
       }
       finally{
           statement.close();
           connection.close();
       }

       return resultSet;
   }
   
    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        lblEmail = new javax.swing.JLabel();
        tbxEmail = new javax.swing.JTextField();
        lblTitle = new javax.swing.JLabel();
        tbxPassword = new javax.swing.JPasswordField();
        lblPassword = new javax.swing.JLabel();
        btnEnter = new javax.swing.JButton();
        ckbPassword = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblEmail.setText("E-posta :");

        tbxEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbxEmailActionPerformed(evt);
            }
        });

        lblTitle.setBackground(new java.awt.Color(51, 51, 255));
        lblTitle.setText(" GİRİŞ EKRANI");
        lblTitle.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 153, 255)));

        tbxPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbxPasswordActionPerformed(evt);
            }
        });

        lblPassword.setText("Şifre");

        btnEnter.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        btnEnter.setText("Giriş");
        btnEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnEnterActionPerformed(evt);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        ckbPassword.setText("Şifreyi göster");
        ckbPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(tbxPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(ckbPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(tbxEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(139, 139, 139)
                                                .addComponent(btnEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(145, 145, 145)
                                                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tbxEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(tbxPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(ckbPassword))
                                        .addComponent(lblPassword))
                                .addGap(28, 28, 28)
                                .addComponent(btnEnter)
                                .addContainerGap(121, Short.MAX_VALUE))
        );

        pack();
    }

    private void tbxPasswordActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void ckbPasswordActionPerformed(java.awt.event.ActionEvent evt) {
        if(ckbPassword.isSelected())
            tbxPassword.setEchoChar((char)0);
        else
            tbxPassword.setEchoChar('*');
    }

    private void btnEnterActionPerformed(ActionEvent evt) throws SQLException {
        System.out.println(resultSet().next());
         if (resultSet().next()) {
             EventQueue.invokeLater(() -> {
          new UI().setVisible(true);
      });
         }else
  JOptionPane.showMessageDialog(null, " E mail veya şifre hatalı");
        }



    private void tbxEmailActionPerformed(java.awt.event.ActionEvent evt) {
      
    }

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeEnterance().setVisible(true);
            }
        });
    }

    
    private javax.swing.JButton btnEnter;
    private javax.swing.JCheckBox ckbPassword;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField tbxEmail;
    private javax.swing.JPasswordField tbxPassword;
   

}
