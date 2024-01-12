package com.skycat.omnipotentnarrator;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.NarratorMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OmnipotentNarratorClient implements ClientModInitializer, ClientLifecycleEvents.ClientStarted {
    public static final Logger LOGGER = LoggerFactory.getLogger("omnipotent-narrator");

	@Override
	public void onClientStarted(MinecraftClient client) {
		client.options.getNarrator().setValue(NarratorMode.ALL);
	}

	@Override
	public void onInitializeClient() {
		ClientLifecycleEvents.CLIENT_STARTED.register(this);
	}
}