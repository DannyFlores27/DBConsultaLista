import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class Main {
  public static void main(String[] args) {
    // Configurar conexión a base de datos
    String url = "jdbc:mysql://localhost:3306/ListaPrueba";
    String usuario = "Alex";
    String contraseña = "123321.0";

    try {
        // Establecer conexión
        Connection conexion = DriverManager.getConnection(url, usuario, contraseña);

        String consultaSQL = "SELECT * FROM ListaPrueba";
        Statement sentencia = conexion.createStatement();

        ResultSet resultadoConsulta = sentencia.executeQuery(consultaSQL);

        // Lista para almacenar los resultados
        ArrayList<String> resultados = new ArrayList<>();

        // Recorrer los resultados y agregarlos a la lista
        while (resultadoConsulta.next()) {
            String respuesta = resultadoConsulta.getString("Nombre");
            resultados.add(respuesta);
        }

        // Cerrar conexión y recursos
        resultadoConsulta.close();
        sentencia.close();
        conexion.close();

        // Imprimir lista
        for (String resultado : resultados) {
            System.out.println(resultado);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
  }
}