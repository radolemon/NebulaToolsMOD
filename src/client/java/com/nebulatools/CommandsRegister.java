package com.nebulatools;

import com.nebulatools.Config.*;
import net.minecraft.client.MinecraftClient;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.text.Text;

public class CommandsRegister {
    public static MinecraftClient client = MinecraftClient.getInstance();
    private static String nt = "\nNeed assistance?\n> command: §3/help\n§r§d[ " + config.modName + " / " + config.modVersion + " ]";
    private static String help = "\n§6No Data";

    public static void register() {
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, commandRegistryAccess) -> {
            dispatcher.register(
                LiteralArgumentBuilder.<FabricClientCommandSource>literal("nebulatools")
                    .executes(context -> {
                        if (client.player != null) {
                            client.player.sendMessage(Text.of(nt), false);
                        }
                        return Command.SINGLE_SUCCESS;
                    })
                    .then(
                        LiteralArgumentBuilder.<FabricClientCommandSource>literal("help")
                            .executes(context -> {
                                if (client.player != null) {
                                    client.player.sendMessage(Text.of(help), false);
                                }
                                return Command.SINGLE_SUCCESS;
                            })
                    )
            );
            dispatcher.register(
                LiteralArgumentBuilder.<FabricClientCommandSource>literal("nt")
                    .executes(context -> {
                        if (client.player != null) {
                            client.player.sendMessage(Text.of(nt), false);
                        }
                        return Command.SINGLE_SUCCESS;
                    })
                    .then(
                        LiteralArgumentBuilder.<FabricClientCommandSource>literal("help")
                            .executes(context -> {
                                if (client.player != null) {
                                    client.player.sendMessage(Text.of(help), false);
                                }
                                return Command.SINGLE_SUCCESS;
                            })
                    )
            );
        });
    }
}
