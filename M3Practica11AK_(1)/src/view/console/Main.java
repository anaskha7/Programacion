/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.console;

import java.util.Scanner;
import model.validations.UserDataValidations;
import model.validations.exeptions.FormatoInvalidoException;
import model.validations.exeptions.IdentificadorInvalidoException;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static UserDataValidations userDataValidations = new UserDataValidations();

    public static void main(String[] args) {
        sc.useDelimiter("\n");
        String opcion;

        while (true) {
            mostrarMenu();
            opcion = sc.next().toLowerCase();

            if (opcion.equals("z")) {
                System.out.println("SALIENDO...");
                break;
            }

            ejecutarOpcion(opcion);
        }
    }

    private static void mostrarMenu() {
        System.out.println("\nTESTER FUNCIONES UserDataValidations");
        System.out.println("1.- testCheckId");
        System.out.println("2.- checkFormatDate");
        System.out.println("3.- calculateAge");
        System.out.println("4.- checkPostalCode");
        System.out.println("5.- isNumeric (NO MODIFICADO)");
        System.out.println("6.- isAlphabetic (NO MODIFICADO)");
        System.out.println("7.- checkEmail");
        System.out.println("8.- checkName");
        System.out.println("Z.- SALIR");
        System.out.print("Opcion: ");
    }

    private static void ejecutarOpcion(String opcion) {
        switch (opcion) {
            case "1" -> testCheckId();
            case "2" -> testCheckFormatDate();
            case "3" -> testCalculateAge();
            case "4" -> testCheckPostalCode();
            case "5" -> testIsNumeric();
            case "6" -> testIsAlphabetic();
            case "7" -> testCheckEmail();
            case "8" -> testCheckName();
            default -> System.out.println("Opcion incorrecta");
        }
    }

    private static void testCheckId() {
        String id = pedirInput("Introduce tu Id: ");
        try {
            userDataValidations.checkId(1, id);
            System.out.println("El Id es correcto");
        } catch (IdentificadorInvalidoException e) {
            System.out.println("Id incorrecto: " + e.getMessage());
        }
    }

    private static void testCheckFormatDate() {
        String fecha = pedirInput("Introduce la fecha (dd/mm/yyyy): ");
        try {
            userDataValidations.checkFormatDate(fecha);
            System.out.println("El formato de la fecha es correcto");
        } catch (FormatoInvalidoException e) {
            System.out.println("Formato de fecha incorrecto: " + e.getMessage());
        }
    }

    private static void testCalculateAge() {
        String fechaNacimiento = pedirInput("Introduce la fecha de nacimiento (dd/mm/yyyy): ");
        try {
            int edad = userDataValidations.calculateAge(fechaNacimiento);
            System.out.println("Tu edad es: " + edad);
        } catch (FormatoInvalidoException e) {
            System.out.println("Fecha de nacimiento inválida: " + e.getMessage());
        }
    }

    private static void testCheckPostalCode() {
        String codigoPostal = pedirInput("Introduce el codigo postal: ");
        try {
            userDataValidations.checkPostalCode(codigoPostal);
            System.out.println("El codigo postal es correcto");
        } catch (FormatoInvalidoException e) {
            System.out.println("Codigo postal incorrecto: " + e.getMessage());
        }
    }

    private static void testIsNumeric() {
        String valor = pedirInput("Introduce un valor: ");
        System.out.println(userDataValidations.isNumeric(valor) ? "El valor es numerico" : "El valor no es numerico");
    }

    private static void testIsAlphabetic() {
        String valor = pedirInput("Introduce un valor: ");
        System.out.println(userDataValidations.isAlphabetic(valor) ? "El valor es alfabetico" : "El valor no es alfabetico");
    }

    private static void testCheckEmail() {
        String email = pedirInput("Introduce el correo electronico: ");
        try {
            userDataValidations.checkEmail(email);
            System.out.println("El correo electronico es valido");
        } catch (FormatoInvalidoException e) {
            System.out.println("Formato de correo electronico incorrecto: " + e.getMessage());
        }
    }

    private static void testCheckName() {
        String nombre = pedirInput("Introduce el nombre: ");
        try {
            userDataValidations.checkName(nombre);
            System.out.println("El nombre es valido");
        } catch (FormatoInvalidoException e) {
            System.out.println("Nombre invalido: " + e.getMessage());
        }
    }

    private static String pedirInput(String mensaje) {
        System.out.print(mensaje);
        return sc.next();
    }
}


