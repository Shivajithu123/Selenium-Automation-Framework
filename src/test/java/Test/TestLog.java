/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

/**
 *
 * @author HP
 */
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestLog {

    private static final Logger logger =
            LogManager.getLogger(TestLog.class);

    public static void main(String[] args) {

        logger.info("LOG4J WORKING SUCCESSFULLY");

    }
}
