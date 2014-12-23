/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.report.mavenreport;

import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Usuario
 */
public class Reporte {
    public static void main(String[] args) {
        Connection b = null;
        try {
            JasperReport a = (JasperReport)JRLoader.loadObjectFromFile("C:/Users/Usuario/Documents/NetBeansProjects/mavenreport/src/report1.jasper");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            b = DriverManager.getConnection("jdbc:oracle:thin:@10.158.82.182:1521:xe", "aplicacion", "aplicacion1234");
            JasperPrint c =  JasperFillManager.fillReport(a, null, b);
            JasperViewer d = new JasperViewer(c);
            d.setVisible(true);
            b.close();
        }
        catch(Exception e) {
            e.printStackTrace();
            try {
                b.close();
            } catch (SQLException ex) {
                Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
