package org.example;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("=== Program started ===");

        // Read generated build passport (if present in resources)
        printBuildPassportIfExists();

        log.info("Hello! Please enter a string and press Enter:");

        try (Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8)) {
            if (!sc.hasNextLine()) {
                log.warn("No input provided (stdin is closed). Using default string.");
                processString("default");
            } else {
                String input = sc.nextLine();
                processString(input);
            }
        } catch (Exception e) {
            log.error("Error while reading input", e);
        }

        log.info("=== Program finished ===");
    }

    private static void processString(String input) {
        String reversed = StringUtils.reverse(input);
        String capitalized = StringUtils.capitalize(input);

        log.info("Input: {}", input);
        log.info("Reversed: {}", reversed);
        log.info("Capitalized: {}", capitalized);
    }

    private static void printBuildPassportIfExists() {
        String resourceName = "build-passport.properties";

        try (InputStream is = Main.class.getClassLoader().getResourceAsStream(resourceName)) {
            if (is == null) {
                log.info("No {} found (run generateBuildInfo / build first).", resourceName);
                return;
            }

            Properties props = new Properties();
            props.load(is);

            log.info("Build passport loaded:");
            props.forEach((k, v) -> log.info("  {} = {}", k, v));

        } catch (Exception e) {
            log.warn("Could not read build passport", e);
        }
    }
}