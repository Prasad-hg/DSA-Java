import java.util.*;
public class basicOp{
    public static void main(String args[]){
        HashSet<String>hs = new HashSet<>();
        hs.add("hassan");
        hs.add("Chikmagaluru");
        hs.add("Coorg");
        hs.add("Sak");

        Iterator it = hs.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
    }
}
}