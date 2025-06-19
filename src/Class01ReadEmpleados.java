
import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Class01ReadEmpleados {
    public static void main(String[] args) {
        //1) REGISTRAR LA CLASE DE NUESTRO DRIVER
        //JDBC DE MYSQL
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2) NECESITAMOS UNA CADENA DE CONEXION
            String connectionString = 
                "jdbc:mysql://localhost:3306/hospital";
            //3) CREAR UNA CONEXION MEDIANTE DRIVERMANAGER
            Connection cn = 
            DriverManager.getConnection(connectionString
            ,"root", "mysql2025");
            //4) CONSULTA SOBRE LA BBDD
            String sql = "select * from EMP";
            // 5) CREAMOS EL TIPO DE STATEMENT DEPENDIENDO 
            //DE LA CONSULTA.  CONSULTA SIMPLE
            Statement st = cn.createStatement();
            // 6) COMO ES CONSULTA SELECT, NECESITAMOS
            //UN ResultSet Y EL METODO executeQuery()
            ResultSet rs = st.executeQuery(sql);
            //7) RECORREMOS LOS REGISTROS MEDIANTE UN 
            //BUCLE WHILE
            while (rs.next()){
                String apellido = 
                    rs.getString("APELLIDO");
                System.out.println("Apellido: " + apellido);
            }
            //8) LIBERAMOS LOS RECURSOS
            rs.close();
            cn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Class" + e);
        } catch (SQLException ex){
            System.out.println("Sql: " + ex);
        }
    }
}
