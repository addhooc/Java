package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC_SQLite {

	public static void main(String[] args) throws Exception{
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:C:/Users/Tincho/Desktop/biblioteca.db");
        Statement stat = conn.createStatement();
        stat.executeUpdate("drop table if exists BIBLIOTECA;");
        stat.executeUpdate("create table BIBLIOTECA (libro, autor, anio);");
        PreparedStatement prep = conn.prepareStatement(
            "insert into BIBLIOTECA values (?, ?, ?);");

        prep.setString(1, "V.");
        prep.setString(2, "Pynchon, Thomas");
        prep.setInt(3, 1963);
        prep.addBatch();
        
        prep.setString(1, "Los sorias");
        prep.setString(2, "Laiseca, Alberto");
        prep.setInt(3, 1982);
        prep.addBatch();
        
        prep.setString(1, "Tractatus logico-philosophicus");
        prep.setString(2, "Wittgenstein");
        prep.setInt(3, 1921);
        prep.addBatch();

        conn.setAutoCommit(false);
        prep.executeBatch();
        conn.setAutoCommit(true);

        ResultSet rs = stat.executeQuery("select * from BIBLIOTECA;");
        while (rs.next()) {
            System.out.println("Obra : " + rs.getString("libro"));
            System.out.println("Autor : " + rs.getString("autor"));
            System.out.println("Publicado : " + rs.getInt("anio"));
        }
        rs.close();
        conn.close();

	}

}
