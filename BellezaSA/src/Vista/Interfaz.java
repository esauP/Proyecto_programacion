/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author Usuario
 */
public class Interfaz extends javax.swing.JFrame {

    /**
     * Creates new form Vista_prueba1
     */
    public Interfaz() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DiaConfBd = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TxtDiaIP = new javax.swing.JTextField();
        TxtDiaUsu = new javax.swing.JTextField();
        TxtDiaPass = new javax.swing.JTextField();
        BtnDiaConGuar = new javax.swing.JButton();
        BtnDiaConCan = new javax.swing.JButton();
        tabPrincipal = new javax.swing.JTabbedPane();
        paneTpv = new javax.swing.JPanel();
        paneClientes = new javax.swing.JPanel();
        paneProductos = new javax.swing.JPanel();
        paneEmpleados = new javax.swing.JPanel();
        paneProveedores = new javax.swing.JPanel();
        Menu = new javax.swing.JMenuBar();
        menuListados = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        menuArchivo = new javax.swing.JMenu();
        menuPrecio = new javax.swing.JMenuItem();
        menuFacturas = new javax.swing.JMenuItem();
        menuEmpleado = new javax.swing.JMenuItem();
        menuClientes = new javax.swing.JMenuItem();
        Menuconf = new javax.swing.JMenu();
        menuConexion = new javax.swing.JMenuItem();

        jLabel1.setText("IP:");

        jLabel2.setText("Usuario:");

        jLabel3.setText("Contraseña:");

        BtnDiaConGuar.setText("Guardar");

        BtnDiaConCan.setText("Salir sin guardar");

        javax.swing.GroupLayout DiaConfBdLayout = new javax.swing.GroupLayout(DiaConfBd.getContentPane());
        DiaConfBd.getContentPane().setLayout(DiaConfBdLayout);
        DiaConfBdLayout.setHorizontalGroup(
            DiaConfBdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DiaConfBdLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(DiaConfBdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(DiaConfBdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TxtDiaPass, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                    .addComponent(TxtDiaUsu)
                    .addComponent(TxtDiaIP))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(DiaConfBdLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(BtnDiaConGuar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(BtnDiaConCan)
                .addGap(38, 38, 38))
        );
        DiaConfBdLayout.setVerticalGroup(
            DiaConfBdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DiaConfBdLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(DiaConfBdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TxtDiaIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DiaConfBdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TxtDiaUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DiaConfBdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TxtDiaPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DiaConfBdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnDiaConGuar)
                    .addComponent(BtnDiaConCan))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabPrincipal.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        javax.swing.GroupLayout paneTpvLayout = new javax.swing.GroupLayout(paneTpv);
        paneTpv.setLayout(paneTpvLayout);
        paneTpvLayout.setHorizontalGroup(
            paneTpvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1078, Short.MAX_VALUE)
        );
        paneTpvLayout.setVerticalGroup(
            paneTpvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 563, Short.MAX_VALUE)
        );

        tabPrincipal.addTab("TPV", paneTpv);

        javax.swing.GroupLayout paneClientesLayout = new javax.swing.GroupLayout(paneClientes);
        paneClientes.setLayout(paneClientesLayout);
        paneClientesLayout.setHorizontalGroup(
            paneClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1078, Short.MAX_VALUE)
        );
        paneClientesLayout.setVerticalGroup(
            paneClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 563, Short.MAX_VALUE)
        );

        tabPrincipal.addTab("Clientes", paneClientes);

        javax.swing.GroupLayout paneProductosLayout = new javax.swing.GroupLayout(paneProductos);
        paneProductos.setLayout(paneProductosLayout);
        paneProductosLayout.setHorizontalGroup(
            paneProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1078, Short.MAX_VALUE)
        );
        paneProductosLayout.setVerticalGroup(
            paneProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 563, Short.MAX_VALUE)
        );

        tabPrincipal.addTab("Productos", paneProductos);

        javax.swing.GroupLayout paneEmpleadosLayout = new javax.swing.GroupLayout(paneEmpleados);
        paneEmpleados.setLayout(paneEmpleadosLayout);
        paneEmpleadosLayout.setHorizontalGroup(
            paneEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1078, Short.MAX_VALUE)
        );
        paneEmpleadosLayout.setVerticalGroup(
            paneEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 563, Short.MAX_VALUE)
        );

        tabPrincipal.addTab("Empleados", paneEmpleados);

        javax.swing.GroupLayout paneProveedoresLayout = new javax.swing.GroupLayout(paneProveedores);
        paneProveedores.setLayout(paneProveedoresLayout);
        paneProveedoresLayout.setHorizontalGroup(
            paneProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1078, Short.MAX_VALUE)
        );
        paneProveedoresLayout.setVerticalGroup(
            paneProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 563, Short.MAX_VALUE)
        );

        tabPrincipal.addTab("Proveedores", paneProveedores);

        menuListados.setText("Archivo");

        jMenuItem1.setText("Datos de la empresa");
        menuListados.add(jMenuItem1);

        jMenuItem2.setText("Incremento de precio");
        menuListados.add(jMenuItem2);

        jMenuItem3.setText("Administracion Usuarios");
        menuListados.add(jMenuItem3);

        jMenuItem4.setText("Salir");
        menuListados.add(jMenuItem4);

        Menu.add(menuListados);

        menuArchivo.setText("Listados");

        menuPrecio.setText("Lista de Precios");
        menuArchivo.add(menuPrecio);

        menuFacturas.setText("Listado de facturas");
        menuArchivo.add(menuFacturas);

        menuEmpleado.setText("Facturacion por empleado");
        menuArchivo.add(menuEmpleado);

        menuClientes.setText("Facturacion por clientes");
        menuArchivo.add(menuClientes);

        Menu.add(menuArchivo);

        Menuconf.setText("Configuración");

        menuConexion.setText("Conexión Base de Datos");
        Menuconf.add(menuConexion);

        Menu.add(Menuconf);

        setJMenuBar(Menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(tabPrincipal)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPrincipal)
        );

        tabPrincipal.getAccessibleContext().setAccessibleName("TPV");

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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BtnDiaConCan;
    public javax.swing.JButton BtnDiaConGuar;
    public javax.swing.JDialog DiaConfBd;
    public javax.swing.JMenuBar Menu;
    public javax.swing.JMenu Menuconf;
    public javax.swing.JTextField TxtDiaIP;
    public javax.swing.JTextField TxtDiaPass;
    public javax.swing.JTextField TxtDiaUsu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenu menuArchivo;
    public javax.swing.JMenuItem menuClientes;
    public javax.swing.JMenuItem menuConexion;
    public javax.swing.JMenuItem menuEmpleado;
    public javax.swing.JMenuItem menuFacturas;
    private javax.swing.JMenu menuListados;
    public javax.swing.JMenuItem menuPrecio;
    public javax.swing.JPanel paneClientes;
    public javax.swing.JPanel paneEmpleados;
    public javax.swing.JPanel paneProductos;
    public javax.swing.JPanel paneProveedores;
    public javax.swing.JPanel paneTpv;
    public javax.swing.JTabbedPane tabPrincipal;
    // End of variables declaration//GEN-END:variables
}
