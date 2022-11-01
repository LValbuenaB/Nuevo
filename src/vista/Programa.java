/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import modelo.Usuarios;

/**
 *
 * @author laura
 */
public class Programa extends javax.swing.JFrame {

    Usuarios usuario;
    
    public Programa() {
        initComponents();
    }

    public Programa(Usuarios usuario){
        System.out.println("Entro a programa");
        //Como este es el contraturctor que se va abrir tmabien se debe inciiar los componentes
        initComponents();
        setLocationRelativeTo(null);
        this.usuario = usuario;
        
        etiquetaNombre.setText(usuario.getNombre());
        etiquetaROl.setText(usuario.getNombreRol());
        
        System.out.println("Se asignan etiquetas");
        System.out.println(usuario.getIdTipo_usuario());
        if (usuario.getIdTipo_usuario() == 1) {
            System.out.println("Usuario tipo 1"); 
        }
        else if(usuario.getIdTipo_usuario() == 2){
            //Restringir algunos campos del sistema
            menuProveedores.setVisible(false);
            subMenuAgregarProducto.setVisible(false);
            System.out.println("Usuario tipo 2");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        etiquetaNombre = new javax.swing.JLabel();
        etiquetaROl = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuProductos = new javax.swing.JMenu();
        subMenuAgregarProducto = new javax.swing.JMenuItem();
        subMenuModificar = new javax.swing.JMenuItem();
        subMenuCatalogo = new javax.swing.JMenuItem();
        menuProveedores = new javax.swing.JMenu();
        subMenuAgregarProveedores = new javax.swing.JMenuItem();
        subMenuCatalogoProveedores = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("Bienvenido al programa");

        etiquetaNombre.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        etiquetaROl.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        menuProductos.setText("Productos");

        subMenuAgregarProducto.setText("Agregar Producto");
        menuProductos.add(subMenuAgregarProducto);

        subMenuModificar.setText("Modificar Producto");
        menuProductos.add(subMenuModificar);

        subMenuCatalogo.setText("Catálogo de Productos");
        menuProductos.add(subMenuCatalogo);

        jMenuBar1.add(menuProductos);

        menuProveedores.setText("Proveedores");

        subMenuAgregarProveedores.setText("Agregar Proveedor");
        menuProveedores.add(subMenuAgregarProveedores);

        subMenuCatalogoProveedores.setText("Catálogo de Proveedores");
        menuProveedores.add(subMenuCatalogoProveedores);

        jMenuBar1.add(menuProveedores);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(112, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(100, 100, 100))
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(etiquetaNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                    .addComponent(etiquetaROl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(etiquetaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(etiquetaROl, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(132, Short.MAX_VALUE))
        );

        pack();
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
            java.util.logging.Logger.getLogger(Programa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Programa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Programa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Programa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Programa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel etiquetaNombre;
    private javax.swing.JLabel etiquetaROl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuProductos;
    private javax.swing.JMenu menuProveedores;
    private javax.swing.JMenuItem subMenuAgregarProducto;
    private javax.swing.JMenuItem subMenuAgregarProveedores;
    private javax.swing.JMenuItem subMenuCatalogo;
    private javax.swing.JMenuItem subMenuCatalogoProveedores;
    private javax.swing.JMenuItem subMenuModificar;
    // End of variables declaration//GEN-END:variables
}
