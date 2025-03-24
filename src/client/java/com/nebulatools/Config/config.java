package com.nebulatools.Config;

import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.nebulatools.NebulaTools;

public class config {
    public static String modName;
    public static String modVersion;

    public static void loadConfig() {
        Gson gson = new Gson();

        try (FileReader reader = new FileReader("config/NebulaTools/config.json")) {
            // JSONファイルをJavaオブジェクトに変換
            Config config = gson.fromJson(reader, Config.class);

            // Initialize modName after loading the config
            modName = config.mod_name;
            modVersion = config.mod_version;

            // 値を出力
            NebulaTools.LOGGER.info("Mod Name: " + config.mod_name);
            NebulaTools.LOGGER.info("Mod Version: " + config.mod_version);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class Config {
        public String mod_name;
        public String mod_version;
    }
}

