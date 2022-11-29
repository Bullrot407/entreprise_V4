package be.ieps.poo.arnaud.logging;

import be.ieps.poo.arnaud.App;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoggingManager {
    public static final Logger LOGGER = Logger.getLogger(App.class.getPackage().getName());

    // Configuration directement dans la classe
//	static {
//		try {
//			FileHandler fileHandler = new FileHandler("logsDemo.txt");
//			fileHandler.setFormatter(new SimpleFormatter());
//			LOGGER.addHandler(fileHandler);
//		} catch (Exception exception) {
//			LOGGER.log(Level.SEVERE, "Cannot read configuration file", exception);
//		}
//	}

    // Configuration par un fichier de propriétés
    private static final LogManager logManager = LogManager.getLogManager();

    static {
        try {
            logManager.readConfiguration(new FileInputStream("jul.properties"));
        } catch (IOException exception) {
            LOGGER.log(Level.SEVERE, "Cannot read configuration file", exception);
        }
    }

}
