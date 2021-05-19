package Mensajes;

import Formularios.*;
import control.ControlCajaFuerte;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class correo extends javax.swing.JFrame {
    public static String Username = "cajafuerte614@gmail.com";
    public static String PassWord = "cajafuerte2018";
    String c = "";
    String email = "";
    //String Mensage = "Su codigo de verificacion es 154976";
    String Mensage = "La Contraseña de la caja fuerte es " + c;
    String To = "";
    String Subject = "Recuperacion de contraseña";
    
    public correo() {
        int i = 0;        
        Login login = new Login();        
        initComponents();
        this.setLocationRelativeTo(null);    
    }

    public void SendMail() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        
        c = ControlCajaFuerte.ObtenerContraseña();
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(Username, PassWord);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(Username));
            message.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse(To));
            message.setSubject(Subject);
            message.setText(Mensage);

            Transport.send(message);
            //JOptionPane.showMessageDialog(this, "Su mensaje ha sido enviado");
            MensajeRecuperar mrecuperar = new MensajeRecuperar();
            mrecuperar.setVisible(true);
            this.dispose();

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label2 = new java.awt.Label();
        rSMaterialButtonRectangle1 = new rojerusan.RSMaterialButtonRectangle();
        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        BotonCerrar = new javax.swing.JLabel();
        panelImage2 = new org.edisoncor.gui.panel.PanelImage();
        jLabel2 = new javax.swing.JLabel();
        Enviar = new rojerusan.RSButtonMetro();
        rSMetroTextPlaceHolder1 = new rojerusan.RSMetroTextPlaceHolder();

        label2.setText("label2");

        rSMaterialButtonRectangle1.setText("rSMaterialButtonRectangle1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Cargando"); // NOI18N
        setUndecorated(true);

        panelImage1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 255)));
        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/image.jpg"))); // NOI18N

        BotonCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/boto cerrar.png"))); // NOI18N
        BotonCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonCerrarMouseClicked(evt);
            }
        });

        panelImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/correo.png"))); // NOI18N

        javax.swing.GroupLayout panelImage2Layout = new javax.swing.GroupLayout(panelImage2);
        panelImage2.setLayout(panelImage2Layout);
        panelImage2Layout.setHorizontalGroup(
            panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 92, Short.MAX_VALUE)
        );
        panelImage2Layout.setVerticalGroup(
            panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("AR CENA", 1, 18)); // NOI18N
        jLabel2.setText("Ingrese el correo electronico");

        Enviar.setBackground(new java.awt.Color(0, 153, 255));
        Enviar.setText("Enviar");
        Enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnviarActionPerformed(evt);
            }
        });

        rSMetroTextPlaceHolder1.setForeground(new java.awt.Color(0, 0, 0));
        rSMetroTextPlaceHolder1.setBorderColor(new java.awt.Color(0, 153, 255));
        rSMetroTextPlaceHolder1.setBotonColor(new java.awt.Color(0, 153, 255));
        rSMetroTextPlaceHolder1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rSMetroTextPlaceHolder1.setPhColor(new java.awt.Color(102, 102, 102));
        rSMetroTextPlaceHolder1.setPlaceholder("Correo");
        rSMetroTextPlaceHolder1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMetroTextPlaceHolder1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panelImage1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelImage2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelImage1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelImage1Layout.createSequentialGroup()
                                .addComponent(rSMetroTextPlaceHolder1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panelImage1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                                .addComponent(BotonCerrar)))
                        .addContainerGap())
                    .addGroup(panelImage1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(Enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelImage1Layout.setVerticalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImage1Layout.createSequentialGroup()
                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage1Layout.createSequentialGroup()
                        .addComponent(BotonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addComponent(rSMetroTextPlaceHolder1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139))
            .addGroup(panelImage1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(panelImage2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonCerrarMouseClicked
        
        this.dispose();                
        Login login = new Login();
        login.setVisible(true);
    }//GEN-LAST:event_BotonCerrarMouseClicked

    private void EnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnviarActionPerformed
        To = rSMetroTextPlaceHolder1.getText(); 
        email = ControlCajaFuerte.ObtenerEmail();
        c = ControlCajaFuerte.ObtenerContraseña();
        Mensage = "La Contraseña de la caja fuerte es " + c;
        Subject = "Recuperacion de contraseña ";
        
        if(rSMetroTextPlaceHolder1.getText().equals(email)){
            SendMail();    
        }
        else{
           JOptionPane.showMessageDialog(null, "Correo no registrado");
        }
    }//GEN-LAST:event_EnviarActionPerformed

    private void rSMetroTextPlaceHolder1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMetroTextPlaceHolder1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMetroTextPlaceHolder1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new correo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BotonCerrar;
    private rojerusan.RSButtonMetro Enviar;
    private javax.swing.JLabel jLabel2;
    private java.awt.Label label2;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private org.edisoncor.gui.panel.PanelImage panelImage2;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle1;
    private rojerusan.RSMetroTextPlaceHolder rSMetroTextPlaceHolder1;
    // End of variables declaration//GEN-END:variables
}
