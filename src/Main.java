import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        DataSet dataSet = new DataSet();
        // Agregar datos al DataSet
        dataSet.agregarDato(10.5);
        dataSet.agregarDato(15.3);
        dataSet.agregarDato(20.1);
        dataSet.agregarDato(25.8);
        dataSet.agregarDato(30.6);

        ArrayList<Double> data = dataSet.obtenerDatos();

        System.out.println("Media: " + Operaciones.calcularMedia(data));
        System.out.println("Mediana: " + Operaciones.calcularMediana(data));
        System.out.println("Moda: " + Operaciones.calcularModa(data));
        System.out.println("Varianza: " + Operaciones.calcularVarianza(data));
        System.out.println("Desviación estándar: " + Operaciones.calcularDesviacionEstandar(data));
    }
}