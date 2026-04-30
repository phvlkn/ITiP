package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("App started");

        Person p = new Person("Meow", 19);
        log.debug("Created person: {}", p);

        try {
            String json = JsonUtil.toJson(p);
            log.info("Serialized JSON: {}", json);

            Person restored = JsonUtil.fromJson(json, Person.class);
            log.info("Deserialized person: {}", restored);
        } catch (Exception e) {
            log.error("Error during JSON processing", e);
        }

        log.info("App finished");
    }
}