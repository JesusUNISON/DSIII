import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class ReporteEdad {

    public static void main(String[] args) {

        final String dataPath = "D:/Escuela/UNI/DS III/IntelJ/PracticaArchivosBinarios/vendors-data.dat";

        RandomVendorFile randomFile = new RandomVendorFile(dataPath);
        Vendor vendor;

        LocalDate fechaVendor;
        LocalDate actual = LocalDate.now();

        System.out.println("Registros mayores de 30 años:");

        for (int i = 1; i <= 100; i++) {
            int pos  = (i * Vendor.RECORD_LEN) - Vendor.RECORD_LEN;
            vendor= randomFile.read(pos);

            fechaVendor = LocalDate.parse(vendor.fechaString(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            int edad = Period.between(fechaVendor, actual).getYears();

            if (edad >= 30) {
                System.out.println(vendor + " " + edad + " años");
            }

        }

    }
}
