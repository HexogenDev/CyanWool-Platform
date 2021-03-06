package net.cyanwool.platform.entity.alive.player;

import java.util.List;

import net.cyanwool.platform.command.ICommandSender;
import net.cyanwool.platform.entity.Entity;
import net.cyanwool.platform.network.PlayerNetwork;
import net.cyanwool.platform.world.Particle;
import net.cyanwool.platform.world.Position;
import net.cyanwool.platform.world.chunk.Chunk;
import net.cyanwool.platform.world.chunk.ChunkCoords;
import net.cyanwool.platform.world.effect.Effect;
import net.cyanwool.platform.world.sounds.Sound;

public interface Player extends Human, ICommandSender {

	public void kickPlayer(String message);

	// public GameProfile getGameProfile();

	// public ClientSettings getClientSettings();

	public boolean isOp();

	public void setOp(boolean flag);

	public void executeCommand(String commandName);

	public void chat(String message);

	public boolean isBanned();

	public void setBanned(boolean banned);

	public boolean isWhitelisted();

	public void setWhitelisted(boolean whitelisted);

	// public void displayGUI(InventoryType type);

	public List<ChunkCoords> getChunks();

	public void playSound(Position pos, String sound, float volume, float pitch);

	public void playSound(Position pos, Sound sound, float volume, float pitch);

	public void playEffect(Position pos, Effect effect, int data);

	public void playEffect(Position pos, int effect, int data);

	public void playParticle(Position pos, Particle particle, int amount, int data);

	public void playParticle(Position pos, int particle, int amount, int data);

	public void setTime(long time); // maybe sendTimeUpdate ?

	public void sendChunk(Chunk chunk);

	public void respawn();

	public PlayerNetwork getPlayerNetwork();

	// public PlayerListEntry getPlayerListEntry();

	public boolean isOnline();

	@Override
	public boolean canSeeEntity(Entity entity);

	public boolean canSeeChunk(Chunk chunk);
}
