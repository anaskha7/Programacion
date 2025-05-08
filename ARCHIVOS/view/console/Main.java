package view.console;

import java.util.Scanner;
import model.Funciones;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Crear carpeta");
            System.out.println("2. Crear archivo con contenido");
            System.out.println("3. Listar archivos de una carpeta");
            System.out.println("4. Mostrar contenido de un archivo");
            System.out.println("5. Sobrescribir archivo");
            System.out.println("6. Borrar archivo");
            System.out.println("7. Contar caracteres");
            System.out.println("8. Contar palabras");
            System.out.println("9. Reemplazar palabras");
            System.out.println("10. Guardar contenido en Anas_Kharbouch.txt");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            opcion = Integer.parseInt(sc.nextLine());

            try {
                switch (opcion) {
                    case 1:
                        System.out.print("Nombre de la carpeta: ");
                        String carpeta = sc.nextLine();
                        Funciones.createFolder(carpeta);
                        break;

                    case 2:
                        System.out.print("Ruta de la carpeta: ");
                        String rutaArchivo = sc.nextLine();
                        System.out.print("Nombre del archivo (ej: texto.txt): ");
                        String archivo = sc.nextLine();
                        System.out.print("Texto a guardar: ");
                        String texto = sc.nextLine();
                        Funciones.createFile(rutaArchivo, archivo, texto);
                        break;

                    case 3:
                        System.out.print("Ruta de la carpeta: ");
                        String rutaLista = sc.nextLine();
                        String[] archivos = Funciones.showListFiles(rutaLista);
                        for (String nombre : archivos) {
                            System.out.println(nombre);
                        }
                        break;

                    case 4:
                        System.out.print("Ruta de la carpeta: ");
                        String rutaMostrar = sc.nextLine();
                        System.out.print("Nombre del archivo: ");
                        String archivoMostrar = sc.nextLine();
                        System.out.println(Funciones.showFile(rutaMostrar, archivoMostrar));
                        break;

                    case 5:
                        System.out.print("Ruta de la carpeta: ");
                        String rutaSobre = sc.nextLine();
                        System.out.print("Nombre del archivo: ");
                        String archivoSobre = sc.nextLine();
                        System.out.print("Nuevo contenido: ");
                        String nuevoTexto = sc.nextLine();
                        boolean resultado = Funciones.overWriteFile(rutaSobre, archivoSobre, nuevoTexto);
                        if (resultado) {
                            System.out.println("Archivo sobrescrito correctamente.");
                        } else {
                            System.out.println("El archivo no existe.");
                        }
                        break;

                    case 6:
                        System.out.print("Ruta de la carpeta: ");
                        String rutaBorrar = sc.nextLine();
                        System.out.print("Nombre del archivo: ");
                        String archivoBorrar = sc.nextLine();
                        Funciones.deleteFile(rutaBorrar, archivoBorrar);
                        break;

                    case 7:
                        System.out.print("Ruta de la carpeta: ");
                        String rutaChars = sc.nextLine();
                        System.out.print("Nombre del archivo: ");
                        String archivoChars = sc.nextLine();
                        int totalChars = Funciones.countChars(rutaChars, archivoChars);
                        System.out.println("Número de caracteres: " + totalChars);
                        break;

                    case 8:
                        System.out.print("Ruta de la carpeta: ");
                        String rutaWords = sc.nextLine();
                        System.out.print("Nombre del archivo: ");
                        String archivoWords = sc.nextLine();
                        int totalPalabras = Funciones.countWords(rutaWords, archivoWords);
                        System.out.println("Número de palabras: " + totalPalabras);
                        break;

                    case 9:
                        System.out.print("Ruta de la carpeta: ");
                        String rutaReem = sc.nextLine();
                        System.out.print("Nombre del archivo: ");
                        String archivoReem = sc.nextLine();
                        System.out.print("Palabra a reemplazar: ");
                        String antigua = sc.nextLine();
                        System.out.print("Nueva palabra: ");
                        String nueva = sc.nextLine();
                        String nuevoContenido = Funciones.swapWords(rutaReem, archivoReem, antigua, nueva);
                        System.out.println("Nuevo contenido:\n" + nuevoContenido);
                        break;

                    case 10:
                        System.out.print("Ruta de la carpeta: ");
                        String rutaGuardar = sc.nextLine();
                        System.out.print("Nombre del archivo: ");
                        String archivoGuardar = sc.nextLine();
                        Funciones.printToTextFile(rutaGuardar, archivoGuardar);
                        System.out.println("Contenido guardado en Anas_Kharbouch.txt");
                        break;

                    case 0:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (opcion != 0);

        sc.close();
    }
}
