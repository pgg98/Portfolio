/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encriptar;

import com.mysql.jdbc.Connection;
import conexionSQL.conexionmysql;
import java.awt.RenderingHints.Key;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Pantalla extends javax.swing.JFrame {
    private String usuario;
    private String password;
    
    conexionmysql cc= new conexionmysql();
    Connection con= cc.conexion();
    /**
     * Creates new form Pantalla
     */
    public Pantalla(String usu, String pass) {
        usuario = usu;
        password= pass;
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("img/padlock_78356.png")).getImage());
        recargar();
        nombre();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        ruta = new java.awt.TextField();
        button1 = new java.awt.Button();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMis = new javax.swing.JTable();
        button2 = new java.awt.Button();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaTodos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        descargarMis = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        usu_comp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        arch_comp = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        nombre = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CRIPTODRIVE | PERFIL");
        setMaximumSize(new java.awt.Dimension(1030, 880));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Montserrat", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 204));
        jLabel1.setText("CRIPTODRIVE");
        jLabel1.setToolTipText("");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, -1, -1));

        ruta.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        ruta.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ruta.setText("Dirección del archivo");
        ruta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rutaActionPerformed(evt);
            }
        });
        getContentPane().add(ruta, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 302, -1));

        button1.setActionCommand("examinar");
        button1.setBackground(new java.awt.Color(0, 153, 204));
        button1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        button1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        button1.setLabel("Examinar");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        getContentPane().add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, 123, 30));

        jButton1.setBackground(new java.awt.Color(0, 153, 204));
        jButton1.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jButton1.setText("SUBIR");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 190, 135, 41));

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 204));
        jLabel2.setText("MIS ARCHIVOS");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, -1, -1));

        tablaMis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID ARCHIVO", "NOMBRE ARCHIVO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaMis.setToolTipText("");
        jScrollPane1.setViewportView(tablaMis);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 266, 144));

        button2.setBackground(new java.awt.Color(0, 153, 204));
        button2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        button2.setLabel("Recargar");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        getContentPane().add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 350, 92, 37));

        tablaTodos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRE ARCHIVO", "AUTOR ARCHIVO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaTodos);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 300, 257, 144));

        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 204));
        jLabel3.setText("TODOS LOS ARCHIVOS");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, 170, -1));

        descargarMis.setBackground(new java.awt.Color(0, 153, 204));
        descargarMis.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        descargarMis.setText("DESCARGAR");
        descargarMis.setBorder(null);
        descargarMis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descargarMisActionPerformed(evt);
            }
        });
        getContentPane().add(descargarMis, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 460, 174, 49));

        jButton2.setBackground(new java.awt.Color(0, 153, 204));
        jButton2.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jButton2.setText("COMPARTIR");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 590, 174, 48));

        usu_comp.setFont(new java.awt.Font("Montserrat", 0, 10)); // NOI18N
        usu_comp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usu_compActionPerformed(evt);
            }
        });
        getContentPane().add(usu_comp, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 580, 141, 30));

        jLabel4.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 204));
        jLabel4.setText("Usuario:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 580, 101, 30));

        jLabel5.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 204));
        jLabel5.setText("ID Archivo:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 620, 101, 33));

        arch_comp.setFont(new java.awt.Font("Montserrat", 0, 10)); // NOI18N
        getContentPane().add(arch_comp, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 620, 141, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/encriptar/img/padlock_78356.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, -1, -1));

        nombre.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        nombre.setForeground(new java.awt.Color(0, 153, 204));
        nombre.setText("| PERFIL |");
        nombre.setToolTipText("");
        getContentPane().add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, -1, -1));

        jLabel9.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 204));
        jLabel9.setText("SUBIR ARCHIVO");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, -1, -1));

        jSeparator2.setBackground(new java.awt.Color(0, 153, 204));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setToolTipText("");
        jSeparator2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 204)));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 530, 760, 140));

        jSeparator3.setBackground(new java.awt.Color(0, 153, 204));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator3.setToolTipText("");
        jSeparator3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 204)));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 760, 100));

        jSeparator4.setBackground(new java.awt.Color(0, 153, 204));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator4.setToolTipText("");
        jSeparator4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 204)));
        getContentPane().add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 760, 260));

        jLabel10.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 204));
        jLabel10.setText("COMPARTIR ARCHIVO");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 540, -1, -1));

        jButton3.setBackground(new java.awt.Color(0, 153, 204));
        jButton3.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        jButton3.setText("CERRAR SESIÓN");
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 50, 140, 50));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/encriptar/img/istockphoto-1143434145-170667a.jpg"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 720));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rutaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rutaActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        JFileChooser exam = new JFileChooser();
        exam.showOpenDialog(this);
        File archivo=exam.getSelectedFile();
        if(archivo != null){
            ruta.setText(archivo.getAbsolutePath());
        }
    }//GEN-LAST:event_button1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(!"".equals(ruta.getText())){
            KeyGenerator generarClave = null;
            SecretKey clave=null;
            try {
                generarClave = KeyGenerator.getInstance("AES");
                generarClave.init(128);
                clave = generarClave.generateKey();
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Pantalla.class.getName()).log(Level.SEVERE, null, ex);
            }                        
            byte[] contenido=null;
            
            String nom= ruta.getText();
            String[] nomarchi= ruta.getText().split("\\\\");
            String apa=nomarchi[nomarchi.length-1];
            
            
            File arch = new File(ruta.getText());
            InputStream lee = null;
            try {
                lee = new FileInputStream(arch);
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            }
            try {
                contenido = new byte[lee.available()];
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try{
                lee.read(contenido);
            }catch(IOException e){
                e.printStackTrace();
            }
            encriptar(clave, contenido, apa);//encripto contenido con clave aes
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        String sql="select * from archivo where nombre_usuario='"+usuario+"'";
        DefaultTableModel tm= (DefaultTableModel) tablaMis.getModel();
        tm.setRowCount(0);
        String sql2="select * from archivo";
        DefaultTableModel tm2= (DefaultTableModel) tablaTodos.getModel();
        tm2.setRowCount(0);
        
        try{
            java.sql.Statement st= con.createStatement();
            ResultSet rs= st.executeQuery(sql);
            
            while(rs.next()){
                String[] mete= new String[2];
                mete[0]=rs.getString("id_archivo");
                mete[1]=rs.getString("nombre_archivo");
                tm.addRow(mete);
            }
            
            java.sql.Statement st2= con.createStatement();
            ResultSet rs2= st2.executeQuery(sql2);      
            
            
            while(rs2.next()){
                String[] mete= new String[2];
                mete[0]=rs2.getString("nombre_archivo");
                mete[1]=rs2.getString("nombre_usuario");
                tm2.addRow(mete);
            }
        }
        catch(Exception e){
               e.printStackTrace();     
        }
        
    }//GEN-LAST:event_button2ActionPerformed

    private void descargarMisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descargarMisActionPerformed
        if(tablaMis.getSelectedRow()>-1){
          DefaultTableModel tm= (DefaultTableModel) tablaMis.getModel();
            int fila= tablaMis.getSelectedRow();
            String valor = (String) tm.getValueAt(fila, 0);

            formarArchivo(valor); 
        }
        
    }//GEN-LAST:event_descargarMisActionPerformed

    private void usu_compActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usu_compActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usu_compActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String usuario=usu_comp.getText();
        String archivo=arch_comp.getText();
        
        if(!usuario.equals("") && !archivo.equals("")){
            formarArchivo2(archivo,usuario);
        }
        else{
            JOptionPane.showMessageDialog(null, "Parametros vacios");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Acceso ac= new Acceso();
        ac.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    public void encriptar(SecretKey clave, byte[] contenido, String nom){
        Cipher cipher;
        byte[] archivo_en = null;
        String archivo_subir= null;
        String subir_clave= null;
        try{
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, clave);
            archivo_en= cipher.doFinal(contenido);
            archivo_subir= Base64.getEncoder().encodeToString(archivo_en);
            
            
            //obtengo la clave publica lista para usar
            PublicKey pub= cogerClave();
            
            //encripto clave aes con pública
            byte[] arc= enc(pub,clave.getEncoded());
            
            //paso de byte a string para guardar
            subir_clave=Base64.getEncoder().encodeToString(arc);
            
            String sql="INSERT INTO archivo (nombre_archivo, nombre_usuario, archivo_cifrado, aes_conrsa) VALUES ('"+nom+"','"+usuario +"','"+archivo_subir+"','"+subir_clave+"'); ";
                        
            java.sql.PreparedStatement pst= con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Archivo subido");
            recargar();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public PublicKey cogerClave() throws SQLException, InvalidKeySpecException, NoSuchAlgorithmException{
        String contra=null;
        String sql= "select * from usuario where nombre_usuario='"+usuario+"'";
        PublicKey po= null;
        
        java.sql.Statement st= con.createStatement();
        ResultSet rs= st.executeQuery(sql);
            
        if(rs.next()){
            contra= rs.getString("publica");
            byte[] publics= Base64.getDecoder().decode(contra);
            X509EncodedKeySpec keys= new X509EncodedKeySpec(publics);
            KeyFactory keyFactor= KeyFactory.getInstance("RSA");
            po= keyFactor.generatePublic(keys);
        }
        else{
            JOptionPane.showMessageDialog(null, "Usuario no encontrado");
        }
        return po;
    }
    
    public byte[] enc(PublicKey cla, byte[] cont) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
        Cipher cifraRSA= Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cifraRSA.init(Cipher.ENCRYPT_MODE, cla);
        byte[] claveAESencr= cifraRSA.doFinal(cont);
        return claveAESencr;
    }

    public void formarArchivo(String id){
        String sql="select * from archivo where id_archivo="+id;
        String sql2="select * from usuario where nombre_usuario='"+usuario+"'";
        
        try{
           java.sql.Statement st= con.createStatement();
           ResultSet rs= st.executeQuery(sql);
           String[] mete= new String[4];
           if(rs.next()){
               mete[0]=rs.getString("id_archivo");
               mete[1]=rs.getString("nombre_archivo");
               mete[2]=rs.getString("archivo_cifrado");
               mete[3]=rs.getString("aes_conrsa");
           }
           java.sql.Statement stu= con.createStatement();
           ResultSet rsu= stu.executeQuery(sql2);
           String clave=null;
           String pas=null;
           PrivateKey po=null;
           if(rsu.next()){
               clave=rsu.getString("privada_AES");//la tengo encriptada aes con su contraseña
               
               SecretKey passMon= new SecretKeySpec(password.getBytes("UTF-8"),"AES");
               byte[] ayuda= Base64.getDecoder().decode(clave.getBytes("UTF-8"));
               
               Cipher prim= Cipher.getInstance("AES");
               prim.init(Cipher.DECRYPT_MODE,passMon);
               byte[] rsadesen=prim.doFinal(ayuda);
               
               //MONTAMOS CLAVE PRIVADA RSA
               KeyFactory kf= KeyFactory.getInstance("RSA");
               po =kf.generatePrivate(new PKCS8EncodedKeySpec(rsadesen));
           }
           //DESENCRIPTAMOS AES CON LA PRIVADA
           byte[] aes=Base64.getDecoder().decode(mete[3].getBytes("UTF-8"));
           Cipher desc= Cipher.getInstance("RSA/ECB/PKCS1Padding");
           desc.init(Cipher.DECRYPT_MODE, po);
           byte[] aesDes=desc.doFinal(aes);
           String hola= Base64.getEncoder().encodeToString(aesDes);
           
           //MONTAMOS AES
           SecretKey claveAES = new SecretKeySpec(aesDes,"AES");
           
           //Desciframos archivo
           byte[] archivo= Base64.getDecoder().decode(mete[2].getBytes("UTF-8"));
           Cipher desi=Cipher.getInstance("AES/ECB/PKCS5Padding");
           desi.init(Cipher.DECRYPT_MODE, claveAES);
           byte[] archivoListo= desi.doFinal(archivo);
           String ar= Base64.getEncoder().encodeToString(archivoListo);
           
           //Montamos archivo
           try {
               JFileChooser jf= new JFileChooser();
               jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
               int sele=jf.showSaveDialog(this);
               if(sele==JFileChooser.APPROVE_OPTION){
                   File fichero= jf.getSelectedFile();
                   String fa=fichero.getAbsolutePath();
                   String[] separar=mete[1].split("\\.");
                   String nomFinal= fa+"\\"+separar[0]+"_E_."+separar[1];
                   FileOutputStream montar = new FileOutputStream(nomFinal);
                    montar.write(archivoListo);
                    montar.close();
                    JOptionPane.showMessageDialog(null, "Archivo descargado");
               }
                
            }catch(Exception e){
                e.printStackTrace();
            }
           
           
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void formarArchivo2(String nom, String usu){
        String sql="select * from archivo where id_archivo="+nom+" and nombre_usuario='"+usuario+"'";
        String sql2="select * from usuario where nombre_usuario='"+usuario+"'";
        
        try{
           java.sql.Statement st= con.createStatement();
           ResultSet rs= st.executeQuery(sql);
           String[] mete= new String[4];
           if(rs.next()){
               mete[0]=rs.getString("id_archivo");
               mete[1]=rs.getString("nombre_archivo");
               mete[2]=rs.getString("archivo_cifrado");
               mete[3]=rs.getString("aes_conrsa");
           }
           java.sql.Statement stu= con.createStatement();
           ResultSet rsu= stu.executeQuery(sql2);
           String clave=null;
           String pas=null;
           PrivateKey po=null;
           if(rsu.next()){
               clave=rsu.getString("privada_AES");//la tengo encriptada aes con su contraseña
               
               SecretKey passMon= new SecretKeySpec(password.getBytes("UTF-8"),"AES");
               byte[] ayuda= Base64.getDecoder().decode(clave.getBytes("UTF-8"));
               
               Cipher prim= Cipher.getInstance("AES");
               prim.init(Cipher.DECRYPT_MODE,passMon);
               byte[] rsadesen=prim.doFinal(ayuda);
               
               //MONTAMOS CLAVE PRIVADA RSA
               KeyFactory kf= KeyFactory.getInstance("RSA");
               po =kf.generatePrivate(new PKCS8EncodedKeySpec(rsadesen));
           }
           //DESENCRIPTAMOS AES CON LA PRIVADA
           byte[] aes=Base64.getDecoder().decode(mete[3].getBytes("UTF-8"));
           Cipher desc= Cipher.getInstance("RSA/ECB/PKCS1Padding");
           desc.init(Cipher.DECRYPT_MODE, po);
           byte[] aesDes=desc.doFinal(aes);
           String hola= Base64.getEncoder().encodeToString(aesDes);
           
           //MONTAMOS AES
           SecretKey claveAES = new SecretKeySpec(aesDes,"AES");
           
           //Desciframos archivo
           byte[] archivo= Base64.getDecoder().decode(mete[2].getBytes("UTF-8"));
           Cipher desi=Cipher.getInstance("AES/ECB/PKCS5Padding");
           desi.init(Cipher.DECRYPT_MODE, claveAES);
           byte[] archivoListo= desi.doFinal(archivo);
           
           //SUBIMOS ARCHIVO
           KeyGenerator generarClave = null;
           SecretKey clave2=null;
            try {
                generarClave = KeyGenerator.getInstance("AES");
                generarClave.init(128);
                clave2 = generarClave.generateKey();
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Pantalla.class.getName()).log(Level.SEVERE, null, ex);
            }
            Cipher cipher;
            byte[] archivo_en = null;
            String archivo_subir= null;
            String subir_clave= null;            
            
            try{
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, clave2);
            archivo_en= cipher.doFinal(archivoListo);
            archivo_subir= Base64.getEncoder().encodeToString(archivo_en);
            
            //obtengo la clave publica lista para usar
            String contra=null;
            String sql4= "select * from usuario where nombre_usuario='"+usu+"'";
            PublicKey pub= null;
        
            java.sql.Statement st3= con.createStatement();
            ResultSet rs3= st3.executeQuery(sql4);
            
            if(rs3.next()){
                contra= rs3.getString("publica");
                byte[] publics= Base64.getDecoder().decode(contra);
                X509EncodedKeySpec keys= new X509EncodedKeySpec(publics);
                KeyFactory keyFactor= KeyFactory.getInstance("RSA");
                pub= keyFactor.generatePublic(keys);
            }
            else{
                JOptionPane.showMessageDialog(null, "Usuario no encontrado");
            }            
            
            //encripto clave aes con pública
            byte[] arc= enc(pub,clave2.getEncoded());
            
            //paso de byte a string para guardar
            subir_clave=Base64.getEncoder().encodeToString(arc);
            
            String nombre="Comp_id_"+nom+"_nom_"+mete[1];
            
            String sql3="INSERT INTO archivo (nombre_archivo, nombre_usuario, archivo_cifrado, aes_conrsa) VALUES ('"+nombre+"','"+usu+"','"+archivo_subir+"','"+subir_clave+"'); ";
                        
            java.sql.PreparedStatement pst= con.prepareStatement(sql3);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Archivo subido");
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
           
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void recargar(){
        String sql="select * from archivo where nombre_usuario='"+usuario+"'";
        DefaultTableModel tm= (DefaultTableModel) tablaMis.getModel();
        tm.setRowCount(0);
        String sql2="select * from archivo";
        DefaultTableModel tm2= (DefaultTableModel) tablaTodos.getModel();
        tm2.setRowCount(0);
        
        try{
            java.sql.Statement st= con.createStatement();
            ResultSet rs= st.executeQuery(sql);
            
            while(rs.next()){
                String[] mete= new String[2];
                mete[0]=rs.getString("id_archivo");
                mete[1]=rs.getString("nombre_archivo");
                tm.addRow(mete);
            }
            
            java.sql.Statement st2= con.createStatement();
            ResultSet rs2= st2.executeQuery(sql2);      
            
            
            while(rs2.next()){
                String[] mete= new String[2];
                mete[0]=rs2.getString("nombre_archivo");
                mete[1]=rs2.getString("nombre_usuario");
                tm2.addRow(mete);
            }
        }
        catch(Exception e){
               e.printStackTrace();     
        }
        
    }
    
    public void nombre(){
        String ar= "| PERFIL "+usuario+" |";
        nombre.setText(ar);
    }
    
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
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField arch_comp;
    private java.awt.Button button1;
    private java.awt.Button button2;
    private javax.swing.JButton descargarMis;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel nombre;
    private java.awt.TextField ruta;
    private javax.swing.JTable tablaMis;
    private javax.swing.JTable tablaTodos;
    private javax.swing.JTextField usu_comp;
    // End of variables declaration//GEN-END:variables
}
