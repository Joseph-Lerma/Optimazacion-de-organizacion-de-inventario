import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SistemaInventario {
    private Map<String, Producto> inventario;

    public SistemaInventario() {
        this.inventario = new HashMap<>();
    }

    public void agregarProducto(String codigo, int cantidad) {
        inventario.put(codigo, new Producto(codigo, cantidad));
    }

    public void eliminarProducto(String codigo) {
        inventario.remove(codigo);
    }

    public Producto buscarProducto(String codigo) {
        return inventario.get(codigo);
    }

    public void actualizarCantidad(String codigo, int cantidad) {
        Producto producto = inventario.get(codigo);
        if (producto != null) {
            producto.setCantidad(cantidad);
        }
    }

    public void verInventario() {
        if (inventario.isEmpty()) {
            System.out.println("El inventario está vacío.");
        } else {
            for (Producto producto : inventario.values()) {
                System.out.println(producto);
            }
        }
    }

    public void guardarInventario(String archivo) {
        try (FileWriter writer = new FileWriter(archivo)) {
            for (Producto producto : inventario.values()) {
                writer.write(producto.getCodigo() + "," + producto.getCantidad() + "\n");
            }
            System.out.println("Inventario guardado en " + archivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


