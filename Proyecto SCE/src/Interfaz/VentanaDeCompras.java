package Interfaz;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

import com.db4o.ObjectContainer;

import Aplicacion.Cliente;
import Productos.Bebida;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class VentanaDeCompras extends JInternalFrame {
    /**
     * 
     */
    private static final long serialVersionUID = 8045284595207835913L;
    private JComboBox<String> cbPaqueteDelDia;
    private ImageIcon         iconoBebida;
    private JLabel            lblBebida;
    private JComboBox<String> cbBebida;
    private JButton           btnConfirmarBebida;
    private JLabel            lblGolosina;
    private JComboBox<String> cbGolosina;
    private JButton           btnConfirmarGolosina;
    private JLabel            lblHelado;
    private JComboBox<String> cbHelado;
    private JButton           btnConfirmarHelado;
    private JLabel            lblLacteo;
    private JComboBox<String> cbLacteo;
    private JButton           btnConfirmarLacteo;
    private JLabel            lblPaqueteDelDia;
    private JRadioButton      checkElegirBebida;
    private JComboBox<String> cbIngredienteEs;
    private ImageIcon         iconoHelado;
    private ImageIcon         iconoGolosina;
    private ImageIcon         iconoLacteo;
    private ImageIcon         iconoPaqueteDelDia;
    private ImageIcon         iconoPreparado;
    private JButton           btnConfirmarPaqueteDelDia;
    private JLabel            lblPreparado;
    private JRadioButton      rdbtnIngredienteExtra;
    private JComboBox<String> cbPreparado;
    private JButton           btnConfirmarPreparado;
    private JButton           btnConfirmarCompra;

    /**
     * Create the frame.
     */
    public VentanaDeCompras(Cliente uncliente, ObjectContainer oC, ArrayList<Cliente> dbC) {
        getContentPane().setBackground(Color.DARK_GRAY);
        getContentPane().setLayout(null);
        // variables bebida
        lblBebida = new JLabel("Bebida");
        lblBebida.setBounds(98, 21, 105, 105);
        getContentPane().add(lblBebida);
        iconoBebida = new ImageIcon(new ImageIcon(VentanaDeCompras.class.getResource("/Imagenes/bebidaicon.png"))
                .getImage().getScaledInstance(lblBebida.getWidth(), lblBebida.getHeight(), Image.SCALE_DEFAULT));
        lblBebida.setIcon(iconoBebida);
        getContentPane().add(lblBebida);
        cbBebida = new JComboBox<String>();
        cbBebida.setBackground(Color.WHITE);
        cbBebida.setBounds(88, 135, 115, 26);
        cbBebida.addItem("coca cola");
        cbBebida.addItem("Sprite");
        cbBebida.addItem("Nestea");
        cbBebida.addItem("Manzanita");
        cbBebida.addItem("Fanta");
        cbBebida.addItem("Boing Guayaba");
        cbBebida.addItem("Boing uva");
        cbBebida.addItem("Boing manzana");
        cbBebida.addItem("Agua embotellada");
        getContentPane().add(cbBebida);

        btnConfirmarBebida = new JButton("");
        btnConfirmarBebida.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                uncliente.comprar(uncliente.getProducto("Bebida", getIndexBebida((String) cbBebida.getSelectedItem())));
                System.out.println(uncliente);
            }
        });
        btnConfirmarBebida.setBackground(new Color(30, 144, 255));
        btnConfirmarBebida.setIcon(new ImageIcon(VentanaDeCompras.class.getResource("/Imagenes/shoicon.png")));
        btnConfirmarBebida.setBounds(218, 124, 42, 37);
        getContentPane().add(btnConfirmarBebida);
        // variables golosina
        lblGolosina = new JLabel("Golosina");
        lblGolosina.setBounds(351, 16, 115, 115);
        iconoGolosina = new ImageIcon(new ImageIcon(VentanaDeCompras.class.getResource("/Imagenes/candyicon.png"))
                .getImage().getScaledInstance(lblBebida.getWidth(), lblBebida.getHeight(), Image.SCALE_DEFAULT));
        lblGolosina.setIcon(iconoGolosina);
        getContentPane().add(lblGolosina);
        cbGolosina = new JComboBox<String>();
        cbGolosina.setBackground(Color.WHITE);
        cbGolosina.setBounds(351, 135, 115, 26);
        cbGolosina.addItem("Paleta");
        cbGolosina.addItem("Gomitas");
        cbGolosina.addItem("KitKat");
        cbGolosina.addItem("Pasitas");
        cbGolosina.addItem("gansito");
        cbGolosina.addItem("Carlos XV");
        cbGolosina.addItem("lunetas");
        getContentPane().add(cbGolosina);
        btnConfirmarGolosina = new JButton("");
        btnConfirmarGolosina.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                uncliente.comprar(
                        uncliente.getProducto("Golosina", getIndexGolosina((String) cbGolosina.getSelectedItem())));
                System.out.println(uncliente);
            }
        });
        btnConfirmarGolosina.setIcon(new ImageIcon(VentanaDeCompras.class.getResource("/Imagenes/shoicon.png")));
        btnConfirmarGolosina.setBackground(new Color(30, 144, 255));
        btnConfirmarGolosina.setBounds(481, 124, 42, 37);
        getContentPane().add(btnConfirmarGolosina);
        // variable helado
        lblHelado = new JLabel("Helado");
        lblHelado.setBounds(98, 172, 115, 115);
        iconoHelado = new ImageIcon(new ImageIcon(VentanaDeCompras.class.getResource("/Imagenes/icecreamicon.png"))
                .getImage().getScaledInstance(lblBebida.getWidth(), lblBebida.getHeight(), Image.SCALE_DEFAULT));
        lblHelado.setIcon(iconoHelado);
        getContentPane().add(lblHelado);
        cbHelado = new JComboBox<String>();
        cbHelado.setBackground(Color.WHITE);
        cbHelado.addItem("Helado de Yogurt");
        cbHelado.addItem("Helado fresa");
        cbHelado.addItem("Helado de Chocolate");
        cbHelado.addItem("Paleta magnum Almendras");
        cbHelado.addItem("Helado Vainilla");
        cbHelado.addItem("Helado de yogurt Taro");
        cbHelado.setBounds(88, 295, 115, 26);
        getContentPane().add(cbHelado);
        btnConfirmarHelado = new JButton("");
        btnConfirmarHelado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                uncliente.comprar(uncliente.getProducto("Helado", getIndexHelado((String) cbHelado.getSelectedItem())));
                System.out.println(uncliente);
            }
        });
        btnConfirmarHelado.setIcon(new ImageIcon(VentanaDeCompras.class.getResource("/Imagenes/shoicon.png")));
        btnConfirmarHelado.setBackground(new Color(30, 144, 255));
        btnConfirmarHelado.setBounds(218, 284, 42, 37);
        getContentPane().add(btnConfirmarHelado);
        // variables Lacteo

        lblLacteo = new JLabel("Lacteo");
        lblLacteo.setBounds(351, 172, 115, 115);
        iconoLacteo = new ImageIcon(new ImageIcon(VentanaDeCompras.class.getResource("/Imagenes/milkicon.png"))
                .getImage().getScaledInstance(lblBebida.getWidth(), lblBebida.getHeight(), Image.SCALE_DEFAULT));
        lblLacteo.setIcon(iconoLacteo);
        getContentPane().add(lblLacteo);
        cbLacteo = new JComboBox<String>();
        cbLacteo.setBackground(Color.WHITE);
        cbLacteo.setBounds(351, 295, 115, 26);
        cbLacteo.addItem("Griego Yoplait");
        cbLacteo.addItem("Yoplait de fresa");
        cbLacteo.addItem("Yoplait de Manzana");
        cbLacteo.addItem("Leche 400ml Santa clara");
        cbLacteo.addItem("Leche Deslactosada 400ml Santa clara");
        cbLacteo.addItem("Jugo Ades");
        getContentPane().add(cbLacteo);
        btnConfirmarLacteo = new JButton("");
        btnConfirmarLacteo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                uncliente.comprar(uncliente.getProducto("Lacteo", getIndexLacteo((String) cbLacteo.getSelectedItem())));
                System.out.println(uncliente);
            }
        });
        btnConfirmarLacteo.setIcon(new ImageIcon(VentanaDeCompras.class.getResource("/Imagenes/shoicon.png")));
        btnConfirmarLacteo.setBackground(new Color(30, 144, 255));
        btnConfirmarLacteo.setBounds(481, 284, 42, 37);
        getContentPane().add(btnConfirmarLacteo);
        setBounds(0, 0, 700, 600);
        // variables paquete del dia
        lblPaqueteDelDia = new JLabel("Paquete del Dia");
        lblPaqueteDelDia.setBounds(108, 326, 120, 134);
        iconoPaqueteDelDia = new ImageIcon(
                new ImageIcon(VentanaDeCompras.class.getResource("/Imagenes/paqueteDelDia.png")).getImage()
                        .getScaledInstance(lblBebida.getWidth(), lblBebida.getHeight(), Image.SCALE_DEFAULT));
        lblPaqueteDelDia.setIcon(iconoPaqueteDelDia);
        getContentPane().add(lblPaqueteDelDia);
        cbPaqueteDelDia = new JComboBox<String>();
        cbPaqueteDelDia.setBackground(new Color(0, 0, 0));
        cbPaqueteDelDia.setEnabled(false);
        cbPaqueteDelDia.addItem("coca cola");
        cbPaqueteDelDia.addItem("Sprite");
        cbPaqueteDelDia.addItem("Nestea");
        cbPaqueteDelDia.addItem("Manzanita");
        cbPaqueteDelDia.addItem("Fanta");
        cbPaqueteDelDia.addItem("Boing Guayaba");
        cbPaqueteDelDia.addItem("Boing uva");
        cbPaqueteDelDia.addItem("Boing manzana");
        cbPaqueteDelDia.addItem("Agua embotellada");
        cbPaqueteDelDia.setBounds(88, 500, 154, 26);
        getContentPane().add(cbPaqueteDelDia);
        checkElegirBebida = new JRadioButton("Elegir bebida");
        checkElegirBebida.setBackground(new Color(30, 144, 255));
        checkElegirBebida.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (checkElegirBebida.isSelected()) {
                    cbPaqueteDelDia.setBackground(new Color(30, 144, 255));
                    cbPaqueteDelDia.setEnabled(true);
                } else {
                    cbPaqueteDelDia.setBackground(Color.black);
                    cbPaqueteDelDia.setEnabled(false);
                }
            }
        });
        checkElegirBebida.setBounds(88, 459, 155, 29);
        getContentPane().add(checkElegirBebida);

        btnConfirmarPaqueteDelDia = new JButton("");
        btnConfirmarPaqueteDelDia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (checkElegirBebida.isSelected()) {
                    uncliente.comprar(uncliente.getProducto("Paquete del dia",
                            getIndexBebida((String) cbPaqueteDelDia.getSelectedItem())));
                    System.out.println(uncliente);
                } else {
                    uncliente.comprar(uncliente.getProducto("Paquete del dia", 0));
                    System.out.println(uncliente);
                }
            }
        });
        btnConfirmarPaqueteDelDia.setIcon(new ImageIcon(VentanaDeCompras.class.getResource("/Imagenes/shoicon.png")));
        btnConfirmarPaqueteDelDia.setBackground(new Color(30, 144, 255));
        btnConfirmarPaqueteDelDia.setBounds(257, 489, 42, 37);
        getContentPane().add(btnConfirmarPaqueteDelDia);
        // variables Preparado
        cbIngredienteEs = new JComboBox<String>();
        cbIngredienteEs.setBackground(new Color(0, 0, 0));
        cbIngredienteEs.setEnabled(false);
        cbIngredienteEs.setBounds(351, 500, 152, 26);
        cbIngredienteEs.addItem("jamon extra");
        cbIngredienteEs.addItem("Pechuga de pavo");
        cbIngredienteEs.addItem("queso extra");
        cbIngredienteEs.addItem("Aguacate");
        cbIngredienteEs.addItem("Aderezos");
        cbIngredienteEs.addItem("Guacamole");
        cbIngredienteEs.addItem("BBq");
        cbIngredienteEs.addItem("Wasabi");
        getContentPane().add(cbIngredienteEs);
        lblPreparado = new JLabel("Preparado");
        lblPreparado.setBounds(361, 336, 115, 115);
        iconoPreparado = new ImageIcon(new ImageIcon(VentanaDeCompras.class.getResource("/Imagenes/preparadoIcon.png"))
                .getImage().getScaledInstance(lblBebida.getWidth(), lblBebida.getHeight(), Image.SCALE_DEFAULT));
        lblPreparado.setIcon(iconoPreparado);
        getContentPane().add(lblPreparado);
        rdbtnIngredienteExtra = new JRadioButton("ingrediente extra");
        rdbtnIngredienteExtra.setBackground(new Color(30, 144, 255));
        rdbtnIngredienteExtra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rdbtnIngredienteExtra.isSelected()) {
                    cbIngredienteEs.setBackground(Color.white);
                    cbIngredienteEs.setEnabled(true);
                } else {
                    cbIngredienteEs.setBackground(Color.DARK_GRAY);
                    cbIngredienteEs.setEnabled(false);
                }
            }
        });
        rdbtnIngredienteExtra.setBounds(351, 459, 155, 29);
        getContentPane().add(rdbtnIngredienteExtra);
        cbPreparado = new JComboBox<String>();
        cbPreparado.addItem("Sandwich");
        cbPreparado.addItem("Sushi");
        cbPreparado.addItem("Molletes");
        cbPreparado.addItem("Tortas");
        cbPreparado.addItem("Ensalada de Atun");
        cbPreparado.addItem("Ensalada de pollo");
        cbPreparado.addItem("Pechuga Empanisada con ensalada");
        cbPreparado.addItem("Enchiladas");
        cbPreparado.addItem("Orden de tacos");
        cbPreparado.addItem("Guisado Del dia");
        cbPreparado.setBounds(517, 460, 152, 26);
        getContentPane().add(cbPreparado);
        btnConfirmarPreparado = new JButton("");
        btnConfirmarPreparado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rdbtnIngredienteExtra.isSelected()) {
                    uncliente.comprar(uncliente.getProducto("Preparado",
                            getIndexPreparado((String) cbPreparado.getSelectedItem()),
                            getIndexIngredienteE((String) cbIngredienteEs.getSelectedItem())));
                    System.out.println(uncliente);
                } else {
                    uncliente.comprar(uncliente.getProducto("Preparado",
                            getIndexPreparado((String) cbPreparado.getSelectedItem())));
                    System.out.println(uncliente);
                }
            }
        });
        btnConfirmarPreparado.setIcon(new ImageIcon(VentanaDeCompras.class.getResource("/Imagenes/shoicon.png")));
        btnConfirmarPreparado.setBackground(new Color(30, 144, 255));
        btnConfirmarPreparado.setBounds(517, 489, 42, 37);
        getContentPane().add(btnConfirmarPreparado);

        btnConfirmarCompra = new JButton("Confirmar Compra");
        btnConfirmarCompra.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
        btnConfirmarCompra.setBackground(new Color(255, 255, 0));
        btnConfirmarCompra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                almacenarEnBaseD(oC, dbC);
                getContentPane().removeAll();
                getContentPane().repaint();
                getContentPane().add(new TicketDeCompra(uncliente, oC, dbC));
            }
        });
        btnConfirmarCompra.setBounds(517, 62, 152, 37);
        getContentPane().add(btnConfirmarCompra);
    }

    private int getIndexBebida(String tipo) {
        int index = 0;
        switch (tipo) {
        case "coca cola":
            index = 1;
            break;
        case "Sprite":
            index = 2;
            break;
        case "Nestea":
            index = 3;
            break;
        case "Manzanita":
            index = 4;
            break;
        case "Fanta":
            index = 5;
            break;
        case "Boing Guayaba":
            index = 6;
            break;
        case "Boing uva":
            index = 7;
            break;
        case "Boing manzana":
            index = 8;
            break;
        case "Agua embotellada":
            index = 9;
            break;
        default:
            index = 0;
            break;
        }
        return index;
    }

    private int getIndexGolosina(String tipo) {
        int index = 0;
        switch (tipo) {
        case "Paleta":
            index = 1;
            break;
        case "Gomitas":
            index = 2;
            break;
        case "KitKat":
            index = 3;
            break;
        case "Pasitas":
            index = 4;
            break;
        case "gansito":
            index = 5;
            break;
        case "Carlos XV":
            index = 6;
            break;
        case "lunetas":
            index = 7;
            break;
        default:
            index = 0;
            break;
        }
        return index;
    }

    public int getIndexHelado(String tipo) {
        int index = 0;
        switch (tipo) {
        case "Helado de Yogurt":
            index = 1;
            break;
        case "Helado fresa":
            index = 2;
            break;
        case "Helado de Chocolate":
            index = 3;
            break;
        case "Paleta magnum Almendras":
            index = 4;
            break;
        case "Helado Vainilla":
            index = 5;
            break;
        case "Helado de yogurt Taro":
            index = 6;
            break;
        default:
            index = 0;
            break;
        }
        return index;
    }

    public int getIndexLacteo(String tipo) {
        int index = 0;
        switch (tipo) {
        case "Griego Yoplait":
            index = 1;
            break;
        case "Yoplait de fresa":
            index = 2;
            break;
        case "Yoplait de Manzana":
            index = 3;
            break;
        case "Leche 400ml Santa clara":
            index = 4;
            break;
        case "Leche Deslactosada 400ml Santa clara":
            index = 5;
            break;
        case "Jugo Ades":
            index = 6;
            break;
        default:
            index = 0;
            break;
        }
        return index;
    }

    private int getIndexIngredienteE(String cual) {
        int index = 0;
        switch (cual) {
        case "jamon extra":
            index = 1;
            break;
        case "Pechuga de pavo":
            index = 2;
            break;
        case "queso extra":
            index = 3;
            break;
        case "Aguacate":
            index = 4;
        case "Aderezos":
            index = 5;
            break;
        case "Guacamole":
            index = 6;
            break;
        case "BBq":
            index = 7;
            break;
        case "Wasabi":
            index = 8;
            break;
        default:
            break;
        }
        return index;
    }

    public int getIndexPreparado(String tipo) {
        int index = 0;
        switch (tipo) {
        case "Sandwich":
            index = 1;
            break;
        case "Molletes":
            index = 2;
            break;
        case "Tortas":
            index = 3;
            break;
        case "Ensalada de Atun":
            index = 4;
            break;
        case "Ensalada de pollo":
            index = 5;
            break;
        case "Pechuga Empanisada con ensalada":
            index = 6;
            break;
        case "Enchiladas":
            index = 7;
            break;
        case "Orden de tacos":
            index = 8;
            break;
        case "Guisado Del dia":
            index = 9;
            break;
        case "Sushi":
            index = 10;
            break;
        default:
            index = 0;
            break;
        }
        return index;

    }

    public static void almacenarEnBaseD(ObjectContainer baseDatos, ArrayList<Cliente> listaCliente) {
        try {
            baseDatos.delete(listaCliente);
            baseDatos.store(listaCliente);
            baseDatos.commit();
            System.out.println("Se ha almacenado correctamente en la base de datos");
        } catch (Exception e) {
            System.out.println("Se ha porducido un error en la insercion");
        }
    }

}
