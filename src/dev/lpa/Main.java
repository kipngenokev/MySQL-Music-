package dev.lpa;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;

public class Main {
    private final static String CONN_STRING= "jdbc:mysql://localhost:3306/music";
    public static void main(String[] args){
      String username= JOptionPane.showInputDialog(null,"Enter DB username:");
      JPasswordField pf= new JPasswordField();
      int okclx= JOptionPane.showConfirmDialog(null,pf,"Enter DB Password",JOptionPane.OK_CANCEL_OPTION);

      final char[] password=(okclx==JOptionPane.OK_OPTION)?pf.getPassword():null;

      try(Connection connection= DriverManager.getConnection(CONN_STRING,username,String.valueOf(password))){
          System.out.println(" Success !!Connection made to the music database");
          Arrays.fill(password,' ');
      }catch (SQLException e){
          throw new RuntimeException (e);
      }
    }
}
