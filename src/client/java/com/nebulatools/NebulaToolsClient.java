package com.nebulatools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nebulatools.Config.*;

import net.fabricmc.api.ClientModInitializer;

public class NebulaToolsClient implements ClientModInitializer {
	public static final String MOD_ID = "NebulaTools";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		FileMaker.CheckConfigFile();
		config.loadConfig();
		CommandsRegister.register();
	}
}