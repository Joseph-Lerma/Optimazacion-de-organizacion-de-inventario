public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaInventario inventario = new SistemaInventario();
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nMenú:");
            System.out.println("1. Ver inventario");
            System.out.println("2. Ver cantidad de producto");
            System.out.println("3. Agregar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Actualizar cantidad de producto");
            System.out.println("6. Guardar inventario en archivo");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    inventario.verInventario();
                    break;
                case 2:
                    System.out.print("Ingrese el código del producto: ");
                    String codigo = scanner.nextLine();
                    Producto producto = inventario.buscarProducto(codigo);
                    if (producto != null) {
                        System.out.println("Cantidad del producto " + codigo + ": " + producto.getCantidad());
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el código del producto: ");
                    codigo = scanner.nextLine();
                    System.out.print("Ingrese la cantidad: ");
                    int cantidad = scanner.nextInt();
                    scanner.nextLine();  // Consumir la nueva línea
                    inventario.agregarProducto(codigo, cantidad);
                    System.out.println("Producto agregado.");
                    break;
                case 4:
                    System.out.print("Ingrese el código del producto a eliminar: ");
                    codigo = scanner.nextLine();
                    inventario.eliminarProducto(codigo);
                    System.out.println("Producto eliminado.");
                    break;
                case 5:
                    System.out.print("Ingrese el código del producto: ");
                    codigo = scanner.nextLine();
                    System.out.print("Ingrese la nueva cantidad: ");
                    cantidad = scanner.nextInt();
                    scanner.nextLine();  // Consumir la nueva línea
                    inventario.actualizarCantidad(codigo, cantidad);
                    System.out.println("Cantidad actualizada.");
                    break;
                case 6:
                    System.out.print("Ingrese el nombre del archivo para guardar el inventario: ");
                    String archivo = scanner.nextLine();
                    inventario.guardarInventario(archivo);
                    break;
                case 7:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }

        scanner.close();
    }
}