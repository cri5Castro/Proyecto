package guideUserInterface;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import clasesApp.Administrador;
import clasesApp.Cliente;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PrincipalLog {
    private ArrayList<Cliente> listaDeClientes = new ArrayList<Cliente>();;
    private ArrayList<Cliente> dbClientes      = listaDeClientes;
    public JFrame              frame;
    private JDesktopPane       desktopPane;
    private ImageIcon          icono;
    private ImageIcon          iconoaux;
    private JLabel             lblNewLabel;
    private JInternalFrame     internalLogin;
    private JTextField         reposNombre;
    private JLabel             lblUsuario;
    private JPasswordField     passwordField;
    private JLabel             lblContrasena;
    private JButton            btnSingUp;
    private JLabel             Mensaje;
    private JButton            btnSingIn;
    private VentanaDeCompras   shop;
    private ObjectContainer    baseDeDatos     = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),
            "clientes.db4o");
    private JTextField         txtRepostargeta;
    private JRadioButton       rdbtnAadirTargeta;
    private JLabel             lblExit;
    private ImageIcon          iconExit;
    private Administrador      admin;

    /**
     * Create the application.
     */
    public PrincipalLog() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        try {
            frame.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar cargar L&F");
        }
        try {
            dbClientes = consultarBaseDeDatos(baseDeDatos, dbClientes);
            admin = new Administrador("contrasena");
            System.out.println("Base de datos sincronizada");
        } catch (Exception e) {
            System.out.println("error al leer base de datos");

        }
        frame = new JFrame();
        frame.setSize(900, 700);
        frame.setResizable(false);
        desktopPane = new JDesktopPane();
        desktopPane.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        ;
        frame.setContentPane(desktopPane);

        lblNewLabel = new JLabel("Login");
        lblNewLabel.setBounds(new Rectangle(0, 0, 900, 660));
        icono = new ImageIcon(PrincipalLog.class.getResource("/Imagenes/desktop.png"));
        iconoaux = new ImageIcon(icono.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(),
                Image.SCALE_DEFAULT));

        lblExit = new JLabel("");
        lblExit.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                cerrarConexion(baseDeDatos);
                frame.dispose();
            }
        });
        lblExit.setBounds(742, 50, 105, 108);
        iconExit = new ImageIcon(new ImageIcon(PrincipalLog.class.getResource("/Imagenes/salir.png")).getImage()
                .getScaledInstance(lblExit.getWidth(), lblExit.getHeight(), Image.SCALE_DEFAULT));
        lblExit.setIcon(iconExit);
        desktopPane.add(lblExit);
        lblNewLabel.setIcon(iconoaux);
        desktopPane.add(lblNewLabel);

        internalLogin = new JInternalFrame("Login");
        internalLogin.getContentPane().setBackground(Color.DARK_GRAY);
        internalLogin.setBackground(Color.DARK_GRAY);
        internalLogin.setBounds(184, 145, 489, 422);
        desktopPane.add(internalLogin);
        internalLogin.getContentPane().setLayout(null);

        reposNombre = new JTextField();
        reposNombre.setBounds(185, 97, 183, 26);
        internalLogin.getContentPane().add(reposNombre);
        reposNombre.setColumns(10);

        lblUsuario = new JLabel("Usuario");
        lblUsuario.setBackground(Color.WHITE);
        lblUsuario.setForeground(Color.WHITE);
        lblUsuario.setBounds(70, 97, 85, 23);
        internalLogin.getContentPane().add(lblUsuario);

        passwordField = new JPasswordField();
        passwordField.setBounds(185, 156, 183, 26);
        internalLogin.getContentPane().add(passwordField);

        lblContrasena = new JLabel("Password");
        lblContrasena.setBackground(Color.WHITE);
        lblContrasena.setForeground(Color.WHITE);
        lblContrasena.setBounds(70, 159, 85, 23);
        internalLogin.getContentPane().add(lblContrasena);

        btnSingUp = new JButton("Sing Up");
        btnSingUp.setBackground(new Color(65, 105, 225));
        btnSingUp.setBounds(253, 246, 115, 29);
        internalLogin.getContentPane().add(btnSingUp);

        Mensaje = new JLabel("Ya tienes una cuenta?");
        Mensaje.setBackground(Color.WHITE);
        Mensaje.setForeground(Color.WHITE);
        Mensaje.setBounds(70, 294, 162, 23);
        internalLogin.getContentPane().add(Mensaje);

        btnSingIn = new JButton("Sing in");
        btnSingIn.setBackground(new Color(65, 105, 225));
        btnSingIn.setBounds(253, 291, 115, 29);
        internalLogin.getContentPane().add(btnSingIn);

        rdbtnAadirTargeta = new JRadioButton("Usar targeta");
        rdbtnAadirTargeta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (rdbtnAadirTargeta.isSelected()) {
                    txtRepostargeta.setVisible(true);
                    txtRepostargeta.setEnabled(true);
                } else {
                    txtRepostargeta.setVisible(false);
                    txtRepostargeta.setEnabled(false);
                }
            }
        });
        rdbtnAadirTargeta.setForeground(Color.WHITE);
        rdbtnAadirTargeta.setBackground(Color.DARK_GRAY);
        rdbtnAadirTargeta.setBounds(42, 194, 140, 26);
        internalLogin.getContentPane().add(rdbtnAadirTargeta);
        txtRepostargeta = new JTextField();
        txtRepostargeta.setVisible(false);
        txtRepostargeta.setEnabled(false);
        txtRepostargeta.setBorder(null);
        txtRepostargeta.setBounds(185, 198, 183, 26);
        txtRepostargeta.setBackground(Color.WHITE);
        internalLogin.getContentPane().add(txtRepostargeta);
        txtRepostargeta.setColumns(10);
        internalLogin.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btnSingIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String pass = new String(passwordField.getPassword());
                if (reposNombre.getText().equals("Admin")) {
                    if (admin.getContrasena().equals(pass)) {
                        try {
                            VentanaAdmin va = new VentanaAdmin(admin, baseDeDatos, dbClientes, PrincipalLog.this);
                            desktopPane.add(va);
                            va.setVisible(true);
                            internalLogin.setClosed(true);
                        } catch (PropertyVetoException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                        desktopPane.repaint();
                    } else {
                        JOptionPane.showMessageDialog(null, "Contraseña Incorrecta");
                    }
                } else {
                    if (buscarCliente(reposNombre.getText(), pass) != null) {
                        try {
                            VentanaUsuario vu = new VentanaUsuario(buscarCliente(reposNombre.getText(), pass),
                                    baseDeDatos, dbClientes, PrincipalLog.this);
                            desktopPane.add(vu);
                            vu.setVisible(true);
                            internalLogin.setClosed(true);
                            desktopPane.repaint();
                        } catch (PropertyVetoException e1) {
                            System.out.println("se produjo un error al acceder");
                            e1.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario no registrado verifique datos");
                    }
                }
            }
        });
        btnSingUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String passt = new String(passwordField.getPassword());
                addCliente(reposNombre.getText(), passt);
            }
        });

    }

    public Cliente buscarCliente(String nom, String pass) {
        Cliente buscado = null;
        for (Cliente cliente : dbClientes) {
            if (cliente.getNombre().equals(nom) && cliente.getPassword().equals(pass)) {
                buscado = cliente;
            }
        }
        return buscado;
    }

    public void addCliente(String nom, String pass) {
        if (nom.equals("Admin")) {
            JOptionPane.showMessageDialog(null, "usuario reservado escoja otro nombre");
        } else {
            if (buscarCliente(nom, pass) == null) {
                if (rdbtnAadirTargeta.isSelected()) {
                    try {
                        dbClientes.add(new Cliente(nom, pass, Long.valueOf(txtRepostargeta.getText()), 800));
                        almacenarEnBaseD(baseDeDatos, dbClientes);
                        JOptionPane.showMessageDialog(null, "Registro exitoso");
                    } catch (Exception e) {
                        System.out.println("error al almacenar Cliente");
                    }
                } else {
                    try {
                        dbClientes.add(new Cliente(nom, pass));
                        almacenarEnBaseD(baseDeDatos, dbClientes);
                        JOptionPane.showMessageDialog(null, "Registro exitoso");
                    } catch (Exception e) {
                        System.out.println("error al almacenar Cliente");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuario registrado escoja otro usuario");
            }
        }
    }

    public void cerrarConexion(ObjectContainer baseDatos) {
        try {
            baseDatos.close();
        } catch (Exception e) {
            System.out.println("error al cerrar la conexion");
        }
    }

    public ObjectContainer getBaseDeDatos() {
        return baseDeDatos;
    }

    public void almacenarEnBaseD(ObjectContainer baseDatos, ArrayList<Cliente> listaCliente) {
        try {
            baseDatos.store(listaCliente);
            baseDatos.commit();
            System.out.println("Se ha almacenado correctamente en la base de datos");
        } catch (Exception e) {
            System.out.println("Se ha porducido un error en la insercion");
        }
    }

    public ArrayList<Cliente> consultarBaseDeDatos(ObjectContainer baseDatos, ArrayList<Cliente> listaCliente) {
        ObjectSet resultado = baseDatos.queryByExample(listaCliente);
        return (ArrayList<Cliente>) resultado.get(0);
    }

    public ArrayList<Cliente> getListaDeClientes() {
        return dbClientes;
    }

    public JDesktopPane getDesktopPane() {
        return desktopPane;
    }
}