/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gss.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class TestDateFormatter {
    public static void main(String [] a){
        DateFormat f = new SimpleDateFormat("dd-MM-yyyy");
        try {
            System.out.print(f.parse("11-12-2017"));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }
}
