
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Class06IncrementoSalarial {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionString = 
            "jdbc:mysql://localhost:3306/hospital";
            Connection cn = 
            DriverManager.getConnection
            (connectionString, "root", "mysql2025");
            System.out.println("Oficio:");
            String oficio = teclado.nextLine();
            System.out.println("Incremento salarial: ");
            String incremento = teclado.nextLine();
            oficio = oficio.toUpperCase();
//update EMP set SALARIO = SALARIO + 1 where OFICIO='ANALISTA'
            String sql = "update EMP set SALARIO = SALARIO + "
            + incremento + " where OFICIO='" + oficio + "'";
            Statement st = cn.createStatement();
            int modificados = st.executeUpdate(sql);
            //------MOSTRAMOS LOS EMPLEADOS-----
//select * from EMP where OFICIO='ANALISTA'
            String sqlSelect = 
            "select * from EMP where OFICIO='" + oficio + "'";
            ResultSet rs = st.executeQuery(sqlSelect);
            while (rs.next()){
                String ape = rs.getString("APELLIDO");
                String ofi = rs.getString("OFICIO");
                String sal = rs.getString("SALARIO");
                System.out.println(ape + " - " + ofi + " - " + sal);
            }
            rs.close();
            cn.close();
        } catch (Exception e) {
            System.out.println("Excepción: " + e);
        }
    } 
}
