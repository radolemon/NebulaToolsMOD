package com.nebulatools;

import net.minecraft.client.MinecraftClient;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileMaker {
    public static void CheckConfigFile() {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (minecraftClient == null) {
            System.err.println("MinecraftClient instance is null. Ensure the game is running in a valid environment.");
            return;
        }

        Path runDirectory = minecraftClient.runDirectory.toPath();
        Path configDir = runDirectory.resolve("config");
        Path NebulaTools = configDir.resolve("NebulaTools");
        Path configFile = NebulaTools.resolve("config.json");

        if (!Files.exists(NebulaTools)) {
            try {
                Files.createDirectories(NebulaTools);
                NebulaToolsClient.LOGGER.info("Created 'NebulaTools' directory...");
            } catch (IOException e) {
                NebulaToolsClient.LOGGER.error(String.format("Directory to Create 'NebulaTools' folder: %s", e.getMessage()));
                return;
            }
        } else {
            NebulaToolsClient.LOGGER.info("'NebulaTools' directory found.");
        }

        // config.jsonファイルが存在しない場合は作成
        if (!Files.exists(configFile)) {
            try (InputStream inputStream = FileMaker.class.getResourceAsStream("/config.json")) {
                if (inputStream == null) {
                    NebulaToolsClient.LOGGER.error("Default config file not found in resources.");
                    return;
                }
                Files.copy(inputStream, configFile, StandardCopyOption.REPLACE_EXISTING);
                NebulaToolsClient.LOGGER.info("Copied 'config.json' file...");
            } catch (IOException e) {
                NebulaToolsClient.LOGGER.error(String.format("Failed to copy 'config.json' file: %s", e.getMessage()));
            }
        } else {
            NebulaToolsClient.LOGGER.info("'config.json' File found.");
        }
    }
}
