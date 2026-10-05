public class Cafeteria {

    double pchico = 1.25;
    double pmediano = 2.00;
    double pgrande = 3.00;

    double hotdog = 2.50;
    double refPeq = 1.30;
    double refMed = 2.00;
    double refGra = 2.75;

    double agua = 1.50;
    double chocolate = 1.75;

    double combo1 = 4.50;
    double combo2 = 5.00;
    double combo3 = 6.80;

    double totalP = 0;
    double totalHotdog = 0;
    double totalRefresco = 0;
    double totalAgua = 0;
    double totalChocolate = 0;

    double totalRecaudado = 0;
    double totalDescuentosJubilados = 0;

    public double venderP(int tipo, int cantidad) {
        double precio = 0;

        if (tipo == 1) precio = pchico;
        if (tipo == 2) precio = pmediano;
        if (tipo == 3) precio = pgrande;

        double total = precio * cantidad;
        totalP += total;
        totalRecaudado += total;
        return total;
    }

    public double venderHotdog(int cantidad) {
        double total = hotdog * cantidad;
        totalHotdog += total;
        totalRecaudado += total;
        return total;
    }

    public double venderRefresco(int tipo, int cantidad) {
        double precio = 0;

        if (tipo == 1) precio = refPeq;
        if (tipo == 2) precio = refMed;
        if (tipo == 3) precio = refGra;

        double total = precio * cantidad;
        totalRefresco += total;
        totalRecaudado += total;
        return total;
    }

    public double venderAgua(int cantidad) {
        double total = agua * cantidad;
        totalAgua += total;
        totalRecaudado += total;
        return total;
    }

    public double venderChocolate(int cantidad) {
        double total = chocolate * cantidad;
        totalChocolate += total;
        totalRecaudado += total;
        return total;
    }

    public double venderCombo(int tipoCombo, int cantidad, boolean agrandar) {

        double precio = 0;

        if (tipoCombo == 1) precio = combo1;
        if (tipoCombo == 2) precio = combo2;
        if (tipoCombo == 3) precio = combo3;

        if (agrandar) precio += 0.50;

        double total = precio * cantidad;

        if (tipoCombo == 1) {
            totalP += pmediano * cantidad;
            totalRefresco += refGra * cantidad;
        }
        if (tipoCombo == 2) {
            totalHotdog += hotdog * cantidad;
            totalRefresco += refGra * cantidad;
        }
        if (tipoCombo == 3) {
            totalP += pgrande * cantidad;
            totalRefresco += refMed * 2 * cantidad;
        }

        totalRecaudado += total;

        return total;
    }

    public double aplicarDescuentoJubilado(double monto) {
        double descuento = monto * 0.20;
        totalDescuentosJubilados += descuento;
        return monto - descuento;
    }
}