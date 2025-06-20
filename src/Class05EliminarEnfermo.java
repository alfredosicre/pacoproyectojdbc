
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Class05EliminarEnfermo {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionString = 
            "jdbc:mysql://localhost:3306/hospital";
            Connection cn = DriverManager
            .getConnection(connectionString
            , "root", "mysql2025");            
            System.out.println("Inscripcion de Enfermo");
            String inscripcion = teclado.nextLine();
//delete from ENFERMO where INSCRIPCION=1234
            String sql = "delete from ENFERMO where INSCRIPCION="
            + inscripcion;
            Statement st = cn.createStatement();
            //POR SUPUESTO, PODEMOS REUTILIZAR EL Statement
            String sqlSelect = "select * from ENFERMO";
            ResultSet rs = st.executeQuery(sqlSelect);
            while (rs.next()){
                String ins = rs.getString("INSCRIPCION");
                String ape = rs.getString("APELLIDO");
                System.out.println(ins + " - " + ape);
            }
            rs.close();
            //Eliminar.......
            int deleted = st.executeUpdate(sql);
            System.out.println("Enfermos eliminados: " + deleted);
            //CERRAMOS LA CONEXION
            cn.close();
        } catch (Exception e) {
            System.out.println("Excepción: " + e);
        }
    }
}
