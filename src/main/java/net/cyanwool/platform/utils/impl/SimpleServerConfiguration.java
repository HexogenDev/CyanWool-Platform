package net.cyanwool.platform.utils.impl;

import java.io.File;
import java.io.IOException;

import net.cyanwool.platform.configuration.file.YamlConfiguration;
import net.cyanwool.platform.utils.ServerConfiguration;

public class SimpleServerConfiguration implements ServerConfiguration {

	private String address;
	private int port;
	private boolean online;
	private int maxPlayers;
	private String motd;
	private int viewDistance;
	private int threads;
	private boolean developerMode;

	private File file;
	private YamlConfiguration config;

	public SimpleServerConfiguration(String configFile) {
		this.file = new File(configFile);
	}

	@Override
	public void loadFromFile() {
		config = YamlConfiguration.loadConfiguration(file);
		String ip = config.getString("host");
		if (ip == null) {
			ip = "0.0.0.0";
		}

		int port = config.getInt("port");
		if (port == 0) {
			port = 25565;
		}

		boolean online = config.getBoolean("online-mode");
		int maxplayers = config.getInt("max-players");
		String motd = config.getString("motd");
		if (motd == null) {
			motd = "CyanWool Minecraft Server";
		}

		int viewDistance = config.getInt("view-distance");
		if (viewDistance == 0) {
			viewDistance = 8;
		}

		int threads = config.getInt("threads-count");
		if (threads == 0) {
			threads = Runtime.getRuntime().availableProcessors();
		}

		boolean developer = config.getBoolean("developer-mode");

		this.address = ip;
		this.port = port;
		this.online = online;
		this.maxPlayers = maxplayers;
		this.motd = motd;
		this.viewDistance = viewDistance;
		this.threads = threads;
		this.developerMode = developer;
	}

	public void createFile() {
		if (!file.exists()) {
			YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
			try {
				config.set("host", "0.0.0.0");
				config.set("port", 25565);
				config.set("online-mode", false); // for tests
				config.set("max-players", 20);
				config.set("motd", "A Custom Minecraft Server");
				config.set("view-distance", 8);
				config.set("threads-count", Runtime.getRuntime().availableProcessors());
				config.set("developer-mode", false);
				config.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String getIPAddress() {
		return address;
	}

	@Override
	public int getPort() {
		return port;
	}

	@Override
	public boolean isOnlineMode() {
		return online;
	}

	@Override
	public void setOnlineMode(boolean online_mode) {
		this.online = online_mode;
	}

	@Override
	public int getMaxPlayers() {
		return maxPlayers;
	}

	@Override
	public void setMaxPlayers(int maxplayers) {
		this.maxPlayers = maxplayers;
	}

	@Override
	public String getMotd() {
		return motd;
	}

	@Override
	public void setMotd(String motd) {
		this.motd = motd;
	}

	@Override
	public int getRadiusViewDistance() {
		return viewDistance;
	}

	@Override
	public void setRadiusViewDistance(int view) {
		this.viewDistance = view;
	}

	@Override
	public int getCountThreads() {
		return threads;
	}

	@Override
	public void setCountThreads(int count) {
		this.threads = count;
	}

	@Override
	public boolean isDeveloperMode() {
		return developerMode;
	}

	@Override
	public void setDeveloperMode(boolean flag) {
		this.developerMode = flag;
	}

	@Override
	public Object getValue(String key) {
		return config.get(key);
	}

	@Override
	public void setValue(String key, Object value) {
		this.config.set(key, value);
	}

}
