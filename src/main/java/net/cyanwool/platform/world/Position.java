package net.cyanwool.platform.world;

import net.cyanwool.platform.block.Block;
import net.cyanwool.platform.utils.NumberConversions;
import net.cyanwool.platform.world.chunk.Chunk;

public class Position {

	private double x;
	private double y;
	private double z;
	private World world;

	public Position(World world, double x, double y, double z) {
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public World getWorld() {
		return world;
	}

	public int getBlockX() {
		return NumberConversions.floor(x); // TODO
	}

	public int getBlockY() {
		return NumberConversions.floor(y); // TODO
	}

	public int getBlockZ() {
		return NumberConversions.floor(z); // TODO
	}

	public Block getBlock() {
		return world.getBlock(this);// TODO
	}

	public Chunk getChunk() {
		return getWorld().getChunkManager().getChunkFromBlockCoords(getBlockX(), getBlockZ());
	}

	public double distanceTo(Position pos) {
		double var2 = pos.getX() - this.getX();
		double var4 = pos.getY() - this.getY();
		double var6 = pos.getZ() - this.getZ();
		return Math.sqrt(var2 * var2 + var4 * var4 + var6 * var6);
	}

	public double squareDistanceTo(Position pos) {
		double var2 = pos.getX() - this.getX();
		double var4 = pos.getY() - this.getY();
		double var6 = pos.getZ() - this.getZ();
		return var2 * var2 + var4 * var4 + var6 * var6;
	}

	public void add(double x, double y, double z) {
		this.x += x;
		this.y += y;
		this.z += z;
	}

	public void substract(double x, double y, double z) {
		this.x -= x;
		this.y -= y;
		this.z -= z;
	}

	public void add(Position pos) {
		this.x += pos.getX();
		this.y += pos.getY();
		this.z += pos.getZ();
	}

	public void substract(Position pos) {
		this.x -= pos.getX();
		this.y -= pos.getY();
		this.z -= pos.getZ();
	}
}
