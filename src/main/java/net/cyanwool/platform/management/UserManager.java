package net.cyanwool.platform.management;

import java.util.List;
import java.util.UUID;

import net.cyanwool.platform.Server;

public interface UserManager {

	public boolean checkPlayer(UUID uuid);

	public void addPlayer(UUID uuid);

	public void removePlayer(UUID uuid);

	public Server getServer();

	public List<UUID> getUUID();

}
