package net.cyanwool.platform.world;

import java.util.List;

import net.cyanwool.platform.Server;

public interface WorldManager {

	public Server getServer();

	public List<World> getWorlds();

	public boolean addWorld(String name);

	public World getWorld(String name);

	public void removeWorld(World world);

	public void saveWorld(World world);

	public void saveAllWorlds();
}
