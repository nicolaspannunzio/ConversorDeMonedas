package model;

public class Historial {
    private String baseCode;
    private String targetCode;
    private double monto;
    private double resultado;

    public Historial(String baseCode, String targetCode, double monto, double resultado) {
        this.baseCode = baseCode;
        this.targetCode = targetCode;
        this.monto = monto;
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "Has convertido " + monto + " " + baseCode + " a " + resultado + " " + targetCode;
    }
}
