import javax.tools.SimpleJavaFileObject;
import java.util.ArrayList;
import java.util.Collections;

static void calcularEstadisticas(ArrayList<Double> data, int numClases) {
    // Calcular el rango
    double min = Collections.min(data);
    double max = Collections.max(data);
    double rango = max - min;

    // Calcular la amplitud del intervalo
    double amplitud = rango / numClases;

    // Construir los intervalos y contar la frecuencia absoluta
    ArrayList<Double> puntosMedios = new ArrayList<>();
    ArrayList<Integer> frecuencias = new ArrayList<>();
    int inicioIntervalo = (int) Math.floor(min);
    for (int i = 0; i < numClases; i++) {
        double intervaloInicio = inicioIntervalo + i * amplitud;
        double intervaloFin = intervaloInicio + amplitud;
        int frecuencia = 0;
        for (double dato : data) {
            if (dato >= intervaloInicio && dato < intervaloFin) {
                frecuencia++;
            }
        }
        frecuencias.add(frecuencia);
        puntosMedios.add((intervaloInicio + intervaloFin) / 2);
    }

    // Calcular frecuencia acumulada y frecuencia relativa
    int frecuenciaAcumulada = 0;
    ArrayList<Double> frecuenciasRelativas = new ArrayList<>();
    for (int frecuencia : frecuencias) {
        frecuenciaAcumulada += frecuencia;
        frecuenciasRelativas.add((double) frecuencia / data.size());
    }

    // Calcular frecuencia relativa acumulada y porcentaje
    double frecuenciaRelativaAcumulada = 0;
    ArrayList<Double> porcentajes = new ArrayList<>();
    for (double frecuenciaRelativa : frecuenciasRelativas) {
        frecuenciaRelativaAcumulada += frecuenciaRelativa;
        porcentajes.add(frecuenciaRelativa * 100);
    }

    // Mostrar la tabla descriptiva
    System.out.println("Tabla Descriptiva:");
    System.out.println("Intervalo\tFrecuencia\tPunto Medio\tFrecuencia Acumulada\tFrecuencia Relativa\tFrecuencia Relativa Acumulada\tPorcentaje");
    for (int i = 0; i < numClases; i++) {
        System.out.printf("%.2f - %.2f\t%d\t\t%.2f\t\t%d\t\t\t%.4f\t\t\t%.4f\t\t\t\t%.2f%%\n",
                inicioIntervalo + i * amplitud,
                inicioIntervalo + (i + 1) * amplitud,
                frecuencias.get(i),
                puntosMedios.get(i),
                frecuenciaAcumulada,
                frecuenciasRelativas.get(i),
                frecuenciaRelativaAcumulada,
                porcentajes.get(i));
    }
}
}