package com.tasks.capitel9;

import java.io.FileNotFoundException;
import java.net.UnknownHostException;

/**
 * When you rethrow an exception that you caught in a multi-catch clause, how
 * do you declare its type in the throws declaration of the ambient method? For
 * example, consider
 * public void process() throws ... {
 * try {
 * ...
 * catch (FileNotFoundException | UnknownHostException ex) {
 * logger.log(Level.SEVERE, "...", ex);
 * throw ex;
 * }
 * }
 */
public class C9E3 {

    public void process() throws FileNotFoundException, UnknownHostException {
        try {
            if (System.currentTimeMillis() % 2 == 0) throw new FileNotFoundException();
            else throw new UnknownHostException();
        } catch (FileNotFoundException | UnknownHostException ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

}
