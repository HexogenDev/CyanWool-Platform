package net.cyanwool.platform.world.chunk;

import java.util.List;

import net.cyanwool.platform.world.World;

public interface ChunkManager {

	public World getWorld();

	public Chunk getChunk(int x, int z);

	public boolean isChunkLoaded(int x, int z);

	public boolean isChunkInUse(int x, int z);

	public boolean loadChunk(int x, int z);

	public void unloadChunk(Chunk chunk);

	public void generateChunk(Chunk chunk);

	public List<Chunk> getLoadedChunks();

	public Chunk getChunkFromChunkCoords(int x, int z);

	public Chunk getChunkFromBlockCoords(int x, int z);

	public void saveChunks();

	public void onTick();

}
