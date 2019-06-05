package com.serenity.repository.util;

/**
 * Argument Validator is to validate the method arguments before using it,
 * also to minimize the duplicating of if statement inside each setter method or a method that has an argument.
 *
 * @Author Ahmed Samy (serenitydiver@hotmail.com)
 */
public class ArgumentValidator {

    public static void checkForNegativity(double number, String message) {
        if (number < 0) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void checkForNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void checkForNullOrEmptyString(String string, String message) {
        if (string == null || string.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }
}
