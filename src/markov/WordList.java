/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package markov;

import java.util.Arrays;

/**
 *
 * @author rick
 */
public class WordList {

    String[] words;

    public WordList(String[] words) {
        this.words = words;
    }

    @Override
    public boolean equals(Object obj) {
        return obj.hashCode() == hashCode();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Arrays.deepHashCode(this.words);
        return hash;
    }

    
}
