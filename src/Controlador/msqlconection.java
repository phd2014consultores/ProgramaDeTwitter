/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
 import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author David Botello
 */
public class msqlconection 
{
    private static final String USER_NAME = "root";
    private static final String USER_PASSWORD = "root";
    private static final String CONN_STRING = "jdbc:mysql://localhost:3306/prueba?zeroDateTimeBehavior=convertToNull";
    
    public Connection coneccion()
    {
         Connection conn = null;
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(USER_NAME, USER_NAME, USER_PASSWORD);
            System.out.println("Conexion Exitosa.....");
        } catch (SQLException ex) {
            Logger.getLogger(msqlconection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(msqlconection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return conn;
    }
}
