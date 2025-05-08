package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Funciones {

    // 1. Crear una carpeta si no existe
    public static void createFolder(String fileName) {
        File folder = new File(fileName);
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }

    // 2. Crear archivo con contenido. Si existe, añade texto.
    public static void createFile(String path, String fileName, String content) {
        File file = new File(path + File.separator + fileName);
        try {
            FileWriter fw = new FileWriter(file, true);
            fw.write(content);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 3. Listar archivos de una carpeta
    public static String[] showListFiles(String path) {
        File folder = new File(path);
        if (folder.exists() && folder.isDirectory()) {
            return folder.list();
        }
        return new String[0];
    }

    // 4. Mostrar el contenido de un archivo
    public static String showFile(String path, String fileName) {
        File file = new File(path + File.separator + fileName);
        StringBuilder content = new StringBuilder();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content.toString();
    }

    // 5. Sobrescribir un archivo con nuevo contenido
    public static boolean overWriteFile(String path, String fileName, String newContent) {
        File file = new File(path + File.separator + fileName);

        if (!file.exists()) {
            return false;
        }

        try {
            FileWriter writer = new FileWriter(file, false);
            writer.write(newContent);
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 6. Borrar un archivo
    public static void deleteFile(String path, String filename) {
        File file = new File(path + File.separator + filename);
        if (file.exists()) {
            file.delete();
        }
    }

    // 7. Contar caracteres en un archivo
    public static int countChars(String path, String fileName) {
        String content = showFile(path, fileName);
        return content.length();
    }

    // 8. Contar palabras en un archivo
    public static int countWords(String path, String fileName) {
        String content = showFile(path, fileName);
        String[] words = content.trim().split("\\s+");
        return content.trim().isEmpty() ? 0 : words.length;
    }

    // 9. Reemplazar una palabra por otra y retornar el nuevo contenido
    public static String swapWords(String path, String fileName, String oldWord, String newWord) {
        File file = new File(path + File.separator + fileName);
        String content = showFile(path, fileName);
        String newContent = content.replace(oldWord, newWord);
        overWriteFile(path, fileName, newContent);
        return newContent;
    }

    // 10. Guardar el contenido del archivo en un nuevo archivo llamado "Anas_Kharbouch.txt"
    public static void printToTextFile(String path, String fileName) {
        String content = showFile(path, fileName);
        File file = new File(path + File.separator + "Anas_Kharbouch.txt");

        try {
            FileWriter fw = new FileWriter(file, false);
            fw.write(content);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
