import java.util.ArrayList;

class DataSet {
    private ArrayList<Double> data;

    public DataSet() {
        this.data = new ArrayList<>();
    }

    public void agregarDato(double dato) {
        data.add(dato);
    }

    public ArrayList<Double> obtenerDatos() {
        return data;
    }
}