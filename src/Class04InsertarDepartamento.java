
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Class04InsertarDepartamento {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionString = 
                "jdbc:mysql://localhost:3306/hospital";
            Connection cn = 
                DriverManager.getConnection(connectionString
                , "root", "mysql2025");
            //Si queremos administrar nosotros los commits
            cn.setAutoCommit(false);
            System.out.println("Id departamento");
            String id = teclado.nextLine();
            System.out.println("Nombre departamento");
            String nombre = teclado.nextLine();
            System.out.println("Localidad");
            String loc = teclado.nextLine();
//insert into DEPT values (50, 'TEST', 'LOC TEST')
            String sql = "insert into DEPT values (" + id + ", '"
            + nombre + "', '" + loc + "')";
            Statement st = cn.createStatement();
            int registros = st.executeUpdate(sql);
            System.out.println("Registros insertados: " + registros);
            //Al ser una base de datos Transaccional (MySql, Oracle)
            //debemos indicar que los cambios son permanentes
            //1.- Permanente: commit
            //2.- Deshacer cambios: rollback
            cn.commit();
            //Cerramos la conexión
            cn.close();
        } catch (Exception e) {
            System.out.println("Excepción " + e);
        }
    }
}
