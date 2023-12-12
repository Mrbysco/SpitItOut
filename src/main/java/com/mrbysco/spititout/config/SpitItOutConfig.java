package com.mrbysco.spititout.config;

import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class SpitItOutConfig {
	public static class Client {
		public final ModConfigSpec.BooleanValue onlyLogCause;

		Client(ModConfigSpec.Builder builder) {
			builder.comment("Client settings")
					.push("Client");

			onlyLogCause = builder
					.comment("Setting this to false will log the full stacktrace (Default: true)")
					.define("onlyLogCause", true);

			builder.pop();
		}
	}

	public static final ModConfigSpec clientSpec;
	public static final Client CLIENT;

	static {
		final Pair<Client, ModConfigSpec> specPair = new ModConfigSpec.Builder().configure(Client::new);
		clientSpec = specPair.getRight();
		CLIENT = specPair.getLeft();
	}
}
