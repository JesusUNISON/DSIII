import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

// Este codigo no considera los simbolos como caracteres
public class Contador {
    public static void main(String[] args) {
        FileReader in=null;
        FileWriter out=null;
        BufferedReader br=null;
        BufferedWriter bw=null;
        String ruta="D:/Escuela/UNI/DS III/IntelJ/LeerCaracteres/";
        Scanner s=null;

        try {
            File conecta= new File(ruta);
            if (!conecta.exists()) {
                conecta.mkdirs();
            }
            in= new FileReader("divina_comedia.txt");
            br= new BufferedReader(in);
            out=new FileWriter(ruta+"salida.txt");
            bw=new BufferedWriter(out);
            s=new Scanner(br);

            int c=0;

            while (s.hasNext()) {
                StringTokenizer N=new StringTokenizer(s.next(),"+-@#$%^&*~`=|°,.:;!¡¿?-_'/()[]{}1234567890\"");
                while (N.hasMoreElements()) {
                    N.nextToken();
                    c++;
                }
            }

            int[] Palabras=new int[c];

            in= new FileReader("divina_comedia.txt");
            br= new BufferedReader(in);
            s=new Scanner(br);
            c=0;
            //String word;
            while (s.hasNext()) {
                StringTokenizer N=new StringTokenizer(s.next(),"+-@#$%^&*~`=|°,.:;!¡¿?-_'/()[]{}1234567890\"");
                while (N.hasMoreElements()) {
                    Palabras[c]=N.nextToken().length();
                    c++;
                }
            }

            Arrays.sort(Palabras);
            int temp=Palabras[0];
            c=1;
            for (int i = 1; i < Palabras.length; i++) {
                if (temp==Palabras[i]){
                    c++;
                } else {
                    System.out.println("Palabras de "+temp+" caracteres: "+c);
                    bw.write("Palabras de "+temp+" caracteres: "+c);
                    bw.newLine();
                    temp=Palabras[i];
                    c=1;
                }
            }
            System.out.println("Palabras de "+temp+" caracteres: "+c); //siempre falta el ultimo
            bw.write("Palabras de "+temp+" caracteres: "+c);
            bw.newLine();
            bw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (s != null) {
                s.close();
            }
        }

    }
}
