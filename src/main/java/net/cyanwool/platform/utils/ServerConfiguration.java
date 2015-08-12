package net.cyanwool.platform.utils;

public interface ServerConfiguration {

	public String getIPAdress();

	public int getPort();

	public boolean isOnlineMode();

	public void setOnlineMode(boolean online_mode);

	public int getMaxPlayers();

	public void setMaxPlayers(int maxplayers);

	public String getMotd();

	public void setMotd(String motd);

	public int getRadiusViewDistance();

	public void setRadiusViewDistance(int view);

	public int getMaxIterationsIO();

	public void setMaxIterationsIO(int iterations);

	public int getCountThreads();

	public void setCountThreads(int count);
	
	public boolean isDeveloperMode();
	
	public void setDeveloperMode(boolean flag);
}