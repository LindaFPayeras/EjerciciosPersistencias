package EjercicioPersonas;
import java.io.*;

class Persona implements Serializable {
    private String nombre;
    private int añoNacimiento;
    
    public Persona(String nombre, int añoNacimiento) {
        this.nombre = nombre;
        this.añoNacimiento = añoNacimiento;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public int getAñoNacimiento() {
        return añoNacimiento;
    }
}

public class ArchivoPersona {
    public static void main(String[] args) {
        // Ruta del archivo de texto
        String archivo = "personas.txt";
        
        // Crear algunas personas
        Persona persona1 = new Persona("Juan", 1990);
        Persona persona2 = new Persona("María", 1985);
        
        // Escribir las personas en el archivo
        escribirPersonaEnArchivo(persona1, archivo);
        escribirPersonaEnArchivo(persona2, archivo);
        
        // Leer las personas del archivo y mostrarlas en la consola
        leerPersonasDelArchivo(archivo);
    }
    
    public static void escribirPersonaEnArchivo(Persona persona, String archivo) {
        try (FileWriter fw = new FileWriter(archivo, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw)) {
            
            pw.println(persona.getNombre() + ", " + persona.getAñoNacimiento());
            
            System.out.println("Persona escrita en el archivo: " + persona.getNombre());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void leerPersonasDelArchivo(String archivo) {
        try (FileReader fr = new FileReader(archivo);
             BufferedReader br = new BufferedReader(fr)) {
            
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(", ");
                String nombre = partes[0];
                int añoNacimiento = Integer.parseInt(partes[1]);
                
                Persona persona = new Persona(nombre, añoNacimiento);
                System.out.println("Persona leída del archivo: " + persona.getNombre());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
