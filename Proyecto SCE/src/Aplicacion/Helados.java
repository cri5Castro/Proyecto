package Aplicacion;

public class Helados extends Producto {
    private int     indexHelado;
    private String  tipoHelado;
    private double  precio;
    private boolean disponibilidad;

    public Helados() {
        this(0);
    }

    public Helados(int idx) {
        super(4);
        indexHelado = idx;
        tipoHelado = setTipoDeHelado(indexHelado);
        precio = setPrecio(tipoHelado);
        disponibilidad = setDisponibilidad();
    }

    public String setTipoDeHelado(int id) {

        switch (id) {
        case 1:
            tipoHelado = "Helado de Yogurt";
            break;
        case 2:
            tipoHelado = "Helado fresa";
            break;
        case 3:
            tipoHelado = "Helado de Chocolate";
            break;
        case 4:
            tipoHelado = "Paleta magnum Almendras";
            break;
        case 5:
            tipoHelado = "Helado Vainilla";
            break;
        case 6:
            tipoHelado = "Helado de yogurt Taro";

        default:
            indexHelado = 0;
            tipoHelado = "Helado no especificado";
            break;
        }
        return tipoHelado;
    }

    public double getPrecio() {
        return precio;
    }

    private boolean setDisponibilidad() {
        return (indexHelado != 0);
    }

    public void setHelado(int idx) {
        indexHelado = idx;
        tipoHelado = setTipoDeHelado(indexHelado);
        precio = setPrecio(tipoHelado);
        disponibilidad = setDisponibilidad();
    }

    public double setPrecio(String tipo) {
        switch (tipo) {
        case "Helado de Yogurt":
            precio = 17.50;
            break;
        case "Helado fresa":
            precio = 15.50;
            break;
        case "Helado de Chocolate":
            precio = 12.50;
            break;
        case "Paleta magnum Almendras":
            precio = 20.50;
            break;
        case "Helado Vainilla":
            precio = 10.50;
            break;
        case "Helado de yogurt Taro":
            precio = 18.50;
            break;
        default:
            precio = 0;
            break;
        }
        return precio;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (disponibilidad) {
            builder.append(super.toString() + "\nTipo:\n" + tipoHelado + "\nPrecio: $" + precio + "\nDisponible");
        } else {
            builder.append("Helado No Disponible");
        }
        return builder.toString();

    }
}
