/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitaplon;

import java.util.ArrayList;

/**
 *
 * @author lochoi
 */
public class Dictionary {

    public int numWord;
    private ArrayList<Word> word = new ArrayList<Word>();
    
    public ArrayList<Word> getWord(){
        return word;
    }
}
