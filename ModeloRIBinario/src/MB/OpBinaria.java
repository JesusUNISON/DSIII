/*
Autor: Jesus Angel Juarez Zazueta
       Hector Eduardo Arevalo Hernandez
       Andre Ahumada Avila
 */

package MB;

import java.util.Collection;
import java.util.HashSet;

public  class OpBinaria {
    public static Collection AND(Collection A, Collection B) {
        Collection temp = new HashSet();
        for (Object objeto : A) {
            if (B.contains(objeto)) {
                temp.add(objeto);
            }
        }
        return temp;
    }

    public static Collection OR(Collection A, Collection B) {
        Collection temp = A;
        for (Object objeto : B) {
            if (!A.contains(objeto)) {
                temp.add(objeto);
            }
        }
        return temp;
    }

    public static Collection NOT(Collection A, Collection B) {
        Collection temp = A;
        for (Object objeto : B) {
            if (A.contains(objeto)) {
                temp.remove(objeto);
            }
        }
        return temp;
    }
}
