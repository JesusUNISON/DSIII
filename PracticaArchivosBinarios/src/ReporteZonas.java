import java.util.Enumeration;
import java.util.Hashtable;

public class ReporteZonas {

    public static void main(String[] args) {

        final String dataPath = "D:/Escuela/UNI/DS III/IntelJ/PracticaArchivosBinarios/vendors-data.dat";

        RandomVendorFile randomFile = new RandomVendorFile(dataPath);
        Vendor vendor;

        Hashtable <String, Integer> tablaZonas= new Hashtable<>();

        System.out.println("Vendedores por zonas:");

        for (int i = 1; i <= 100; i++) {
            int pos  = (i * Vendor.RECORD_LEN) - Vendor.RECORD_LEN;
            vendor= randomFile.read(pos);

            if (tablaZonas.containsKey(vendor.getZona())) {
                int contador = tablaZonas.get(vendor.getZona());
                contador++;
                tablaZonas.put(vendor.getZona(), contador);
            } else {
                tablaZonas.put(vendor.getZona(), 1);
            }
        }

        Enumeration<String> zonas= tablaZonas.keys();

        while (zonas.hasMoreElements()) {
            String zona = zonas.nextElement();
            System.out.printf("%5s %8d\n", zona,tablaZonas.get(zona));
            /*
            for (int i = 1; i <= 100; i++) {
                int pos  = (i * Vendor.RECORD_LEN) - Vendor.RECORD_LEN;
                vendor= randomFile.read(pos);
                if (vendor.getZona().equals(zona)) {
                    System.out.println(vendor);
                }
            }
             */
        }

    }

}
