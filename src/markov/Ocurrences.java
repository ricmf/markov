/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package markov;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author rick
 */
public class Ocurrences {

    double total;
    //HashMap<String, Integer> ocurrences;
    HashMap<String, String> ocurred = new HashMap();
    List<String> consolidated = new ArrayList();

    public Ocurrences() {
        //  ocurrences = new HashMap();
    }

    public void occur(String w) {
        //total++;
        ocurred.putIfAbsent(w, w);
        consolidated.add(ocurred.get(w));
        /*Integer i = ocurrences.get(w);
        if (i == null) {
            ocurrences.put(w, 0);
        } else {
            ocurrences.put(w, i + 1);
        }*/
    }

    public String generate() {
        return consolidated.get((int) (Math.random() * ocurred.size()));
    }

}
