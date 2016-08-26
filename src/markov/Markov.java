/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package markov;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/**
 *
 * @author rick
 */
public class Markov {

    /**
     * @param args the command line arguments
     */
    static String readFile(String path, Charset encoding) {
        try {
            byte[] encoded = Files.readAllBytes(Paths.get(path));
            return new String(encoded, encoding);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void lala(int n, String s, HashMap<WordList, Ocurrences> l) {
        String[] words = s.split(" ");
        for (int i = 0; i < words.length - n; ++i) {
            String[] s2 = new String[n];
            for (int j = 0; j < n; ++j) {
                s2[j] = words[i + j];
            }
            l.putIfAbsent(new WordList(s2), new Ocurrences());
            l.get(new WordList(s2)).occur(words[i + n]);
        }
    }

    public static void main(String[] args) {
        long lt = System.currentTimeMillis();
        int n = 2;
        HashMap<WordList, Ocurrences> l = new HashMap();
        int nb = 1;
        for (int i = 0; i <= nb; ++i) {
            try {
                lala(n, readFile(Markov.class.getResource("book" + i).getPath(), StandardCharsets.UTF_8), l);
            } catch (Exception e) {
            }
        }
        System.out.println(System.currentTimeMillis() - lt);
        lt = System.currentTimeMillis();
        List<String> result = new ArrayList();
        int n2 = (int) (Math.random() * 100) + 50;
        int a = 0;
        Ocurrences current = null;
        for (Entry<WordList, Ocurrences> c : l.entrySet()) {
            a++;
            if (a == n2) {
                current = c.getValue();
                result.addAll(Arrays.asList(c.getKey().words));
                break;
            }
        }
        for (int i = n; i < n2 - n; ++i) {
            result.add(current.generate());
            current = l.get(new WordList(result.subList(i - n + 1, i + 1).toArray(new String[n])));
        }
        System.out.println(System.currentTimeMillis() - lt);
        lt = System.currentTimeMillis();
        for (String st : result) {
            System.out.print(st + " ");
        }

    }

}
