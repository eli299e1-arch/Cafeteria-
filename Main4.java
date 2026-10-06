import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main4 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Cafeteria cafe = new Cafeteria();
        int opcion;
        double facturaTotal = 0;

        do {
            System.out.println("\n===== MENU CAFETERIA =====");
            System.out.println("1. P (Popcorn)");
            System.out.println("2. Hotdog");
            System.out.println("3. Refresco");
            System.out.println("4. Agua");
            System.out.println("5. Chocolate");
            System.out.println("6. Combos");
            System.out.println("7. Finalizar factura");
            System.out.println("8. Reportes del día");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(br.readLine());
            } catch (Exception e) {
                opcion = 0;
            }

            switch (opcion) {
                case 1:
                    System.out.println("1. Chico 1.25");
                    System.out.println("2. Mediano 2.00");
                    System.out.println("3. Grande 3.00");
                    System.out.print("Seleccione tamaño: ");
                    int tipoP = Integer.parseInt(br.readLine());
                    System.out.print("Cantidad: ");
                    int cantP = Integer.parseInt(br.readLine());
                    facturaTotal += cafe.venderP(tipoP, cantP);
                    break;

                case 2:
                    System.out.print("Cantidad Hotdog: ");
                    int cantHd = Integer.parseInt(br.readLine());
                    facturaTotal += cafe.venderHotdog(cantHd);
                    break;

                case 3:
                    System.out.println("1. Pequeño 1.30");
                    System.out.println("2. Mediano 2.00");
                    System.out.println("3. Grande 2.75");
                    System.out.print("Seleccione tamaño: ");
                    int tipoRef = Integer.parseInt(br.readLine());
                    System.out.print("Cantidad: ");
                    int cantRef = Integer.parseInt(br.readLine());
                    facturaTotal += cafe.venderRefresco(tipoRef, cantRef);
                    break;

                case 4:
                    System.out.print("Cantidad de agua: ");
                    int cantAgua = Integer.parseInt(br.readLine());
                    facturaTotal += cafe.venderAgua(cantAgua);
                    break;

                case 5:
                    System.out.print("Cantidad de chocolates: ");
                    int cantChoc = Integer.parseInt(br.readLine());
                    facturaTotal += cafe.venderChocolate(cantChoc);
                    break;

                case 6:
                    System.out.println("1. Combo 1");
                    System.out.println("2. Combo 2");
                    System.out.println("3. Combo 3");
                    System.out.print("Seleccione combo: ");
                    int tipoCombo = Integer.parseInt(br.readLine());
                    System.out.print("Cantidad: ");
                    int cantCombo = Integer.parseInt(br.readLine());
                    System.out.print("Desea agrandarlo? (1=Si / 2=No): ");
                    int agr = Integer.parseInt(br.readLine());
                    boolean aumentar = (agr == 1);
                    facturaTotal += cafe.venderCombo(tipoCombo, cantCombo, aumentar);
                    break;

                case 7:
                    System.out.print("¿Es jubilado? (1=Si / 2=No): ");
                    int jub = Integer.parseInt(br.readLine());

                    if (jub == 1) {
                        facturaTotal = cafe.aplicarDescuentoJubilado(facturaTotal);
                    }

                    System.out.println("\n===== FACTURA =====");
                    System.out.println("Total a pagar: $" + facturaTotal);
                    facturaTotal = 0;
                    break;

                case 8:
                    System.out.println("\n=== REPORTES DEL DÍA ===");
                    double totalDia = cafe.totalRecaudado;

                    System.out.println("P: $" + cafe.totalP);
                    System.out.println("Hotdog: $" + cafe.totalHotdog);
                    System.out.println("Refrescos: $" + cafe.totalRefresco);
                    System.out.println("Agua: $" + cafe.totalAgua);
                    System.out.println("Chocolate: $" + cafe.totalChocolate);

                    System.out.println("\nTotal recaudado: $" + totalDia);
                    System.out.println("Total descuento a jubilados: $" + cafe.totalDescuentosJubilados);

                    if (totalDia > 0) {
                        System.out.println("P: " + (cafe.totalP * 100 / totalDia) + "%");
                        System.out.println("Hotdog: " + (cafe.totalHotdog * 100 / totalDia) + "%");
                        System.out.println("Refrescos: " + (cafe.totalRefresco * 100 / totalDia) + "%");
                        System.out.println("Agua: " + (cafe.totalAgua * 100 / totalDia) + "%");
                        System.out.println("Chocolate: " + (cafe.totalChocolate * 100 / totalDia) + "%");
                    }
                    break;

                case 9:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 9);
    }
}