/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.validations;

import java.time.LocalDate;
import model.validations.exeptions.FormatoInvalidoException;
import model.validations.exeptions.IdentificadorInvalidoException;

public class UserDataValidations {

    /**
     * Debe validar si el NIF (tipo de documento 1) recibido es correcto o no.
     * @param typeDoc indica el tipo de documento identificativo (NIF-1, ..)
     * @param id contiene el documento identificativo a validar.
     * @throws IdentificadorInvalidoException si el formato del documento es incorrecto.
     */
    public static void checkId(int typeDoc, String id) throws IdentificadorInvalidoException {
        if (typeDoc != 1 || id.length() != 9) {
            throw new IdentificadorInvalidoException("Formato de ID incorrecto");
        }
        for (int i = 0; i < 8; i++) {
            if (id.charAt(i) < '0' || id.charAt(i) > '9') {
                throw new IdentificadorInvalidoException("El ID debe tener 8 números y una letra al final");
            }
        }
        char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        int num = 0;
        for (int i = 0; i < 8; i++) {
            num = num * 10 + (id.charAt(i) - '0');
        }
        if (id.charAt(8) != letras[num % 23]) {
            throw new IdentificadorInvalidoException("La letra del ID no coincide con el número");
        }
    }

    /**
     * Debe validar que el formato de la fecha recibida es correcto.
     * El formato esperado es "dd/mm/yyyy".
     * @param date contiene la fecha a validar.
     * @throws FormatoInvalidoException si la fecha tiene un formato incorrecto.
     */
    public static void checkFormatDate(String date) throws FormatoInvalidoException {
        if (date.length() != 10 || date.charAt(2) != '/' || date.charAt(5) != '/') {
            throw new FormatoInvalidoException("Formato de fecha incorrecto (debe ser dd/MM/yyyy)");
        }
        int dia = (date.charAt(0) - '0') * 10 + (date.charAt(1) - '0');
        int mes = (date.charAt(3) - '0') * 10 + (date.charAt(4) - '0');
        if (mes < 1 || mes > 12 || dia < 1 || dia > 31) {
            throw new FormatoInvalidoException("Fecha inválida");
        }
    }

    /**
     * Debe calcular la edad a partir de la fecha de nacimiento recibida.
     * La fecha debe ser validada previamente.
     * @param birthDate contiene la fecha de nacimiento en formato "dd/mm/yyyy".
     * @return la edad calculada.
     * @throws FormatoInvalidoException si la fecha es incorrecta.
     */
    public static int calculateAge(String birthDate) throws FormatoInvalidoException {
        checkFormatDate(birthDate);
        int anio = (birthDate.charAt(6) - '0') * 1000 + (birthDate.charAt(7) - '0') * 100 +
                   (birthDate.charAt(8) - '0') * 10 + (birthDate.charAt(9) - '0');
        return LocalDate.now().getYear() - anio;
    }

    /**
     * Debe validar que el código postal recibido tiene un formato correcto.
     * El formato esperado es de 5 dígitos numéricos.
     * @param zip contiene el código postal a validar.
     * @throws FormatoInvalidoException si el código postal es inválido.
     */
    public static void checkPostalCode(String zip) throws FormatoInvalidoException {
        if (zip.length() != 5) {
            throw new FormatoInvalidoException("El código postal debe tener 5 dígitos");
        }
        for (int i = 0; i < 5; i++) {
            if (zip.charAt(i) < '0' || zip.charAt(i) > '9') {
                throw new FormatoInvalidoException("El código postal solo puede contener números");
            }
        }
    }

    /**
     * Debe validar que el formato del correo electrónico es correcto.
     * El correo debe contener una "@" y terminar en un dominio válido (.com, .es, .net, .org).
     * @param email contiene el correo electrónico a validar.
     * @throws FormatoInvalidoException si el formato del correo es inválido.
     */
    public static void checkEmail(String email) throws FormatoInvalidoException {
        int at = -1, dot = -1;
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') at = i;
            if (email.charAt(i) == '.') dot = i;
        }
        if (at <= 0 || dot <= at) {
            throw new FormatoInvalidoException("Correo electrónico no válido");
        }
    }

    /**
     * Debe validar que el nombre recibido tiene una longitud válida
     * y que no contiene números ni caracteres especiales no permitidos.
     * @param name contiene el nombre a validar.
     * @throws FormatoInvalidoException si el nombre es inválido.
     */
    public static void checkName(String name) throws FormatoInvalidoException {
        if (name.length() < 2 || name.length() > 50) {
            throw new FormatoInvalidoException("El nombre debe tener entre 2 y 50 caracteres");
        }
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == 'ñ' || c == 'Ñ' || c == ' ')) {
                throw new FormatoInvalidoException("El nombre solo puede contener letras y espacios");
            }
        }
    }
    
    /**
 * Debe validar si el contenido de la cadena recibida es numérico.
 * @param str contiene la cadena a validar.
 * @return true si la cadena es numérica, false en caso contrario.
 */
public static boolean isNumeric(String str) {
    if (str.length() == 0) return false;
    for (int i = 0; i < str.length(); i++) {
        if (str.charAt(i) < '0' || str.charAt(i) > '9') return false;
    }
    return true;
}

/**
 * Debe validar si el contenido de la cadena recibida contiene solo letras.
 * @param str contiene la cadena a validar.
 * @return true si la cadena contiene solo letras, false en caso contrario.
 */
public static boolean isAlphabetic(String str) {
    if (str.length() == 0) return false;
    for (int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);
        if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == 'ñ' || c == 'Ñ')) return false;
    }
    return true;
}

}
