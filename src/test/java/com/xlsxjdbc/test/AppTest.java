package com.xlsxjdbc.test;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    public void printSheetContents() {
        try {
            Class.forName("com.googlecode.sqlsheet.Driver");
            try (Connection conn = DriverManager.getConnection("jdbc:xls:file:dummy xlsx.xlsx")) {
                try (PreparedStatement stat = conn.prepareStatement("select * from Sheet1")) {
                    try (ResultSet rs = stat.executeQuery()) {
                        while (rs.next()) {
                            System.out.printf("%d %s%n",rs.getInt("A"),rs.getString("B"));
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        printSheetContents();
        assertTrue( true );
    }
}
