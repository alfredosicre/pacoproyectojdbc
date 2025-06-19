
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Class03BuscadorPlantillaFuncion {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca función");
        String funcion = teclado.nextLine();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionString =
                "jdbc:mysql://localhost:3306/hospital";
            Connection cn = DriverManager.getConnection(connectionString
            , "root", "mysql2025");
 //select APELLIDO, FUNCION, SALARIO from PLANTILLA
//where FUNCION='ENFERMERA'           
            String sql = "select APELLIDO, FUNCION, SALARIO from PLANTILLA "
            + " where FUNCION='" + funcion + "'";
            System.out.println(sql);
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                String ape = rs.getString("APELLIDO");
                String fun = rs.getString("FUNCION");
                String sal = rs.getString("SALARIO");
                System.out.println(ape + " - " + fun + " - " + sal);
            }
            rs.close();
            cn.close();
        } catch (Exception e) {
            System.out.println("Excepción: " + e);
        }
    }
}
