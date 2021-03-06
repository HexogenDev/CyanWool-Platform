package net.cyanwool.platform.material.blocks;

import net.cyanwool.platform.block.Block;
import net.cyanwool.platform.entity.alive.player.Player;
import net.cyanwool.platform.inventory.item.ItemStack;
import net.cyanwool.platform.material.Material;
import net.cyanwool.platform.material.items.ItemMaterial;
import net.cyanwool.platform.world.Position;
import net.cyanwool.platform.world.World;
import net.cyanwool.platform.world.sounds.Sound;

public class BlockMaterial extends ItemMaterial {

	private int lightValue;
	private Sound stepSound;
	private Sound placeSound;
	private Sound breakSound;

	public BlockMaterial(Material material) {
		super(material.getStringId(), material.getId());
	}

	public BlockMaterial(String stringId, int Id) {
		super(stringId, Id, 0);
	}

	public BlockMaterial(String StringId, int Id, int metadata) {
		super(StringId, Id, metadata);
	}

	public BlockMaterial(String StringId, int Id, int metadata, int customData) {
		super(StringId, Id, metadata, customData);
	}

	public boolean onBlockPlaced(Player player, Position pos) {
		return true;
	}

	public boolean onBlockDestroy(Player player, Block block) {
		return true;
	}

	public boolean onBlockInteract(Player player, Block block, ItemStack item) {
		return true;
	}

	public boolean onBlockDig(Player player, Block block, ItemStack item) {
		return true;
	}

	public void onEntityWalk(Player baseEntity, Block block) {
	}

	public int getLightValue() {
		return lightValue;
	}

	public BlockMaterial setLightValue(int value) {
		this.lightValue = value;
		return this;
	}

	public Sound getStepSound() {
		return stepSound;
	}

	public BlockMaterial setStepSound(Sound stepSound) {
		this.stepSound = stepSound;
		return this;
	}

	public Sound getPlaceSound() {
		return placeSound;
	}

	public BlockMaterial setPlaceSound(Sound placeSound) {
		this.placeSound = placeSound;
		return this;
	}

	public Sound getBreakSound() {
		return breakSound;
	}

	public BlockMaterial setBreakSound(Sound breakSound) {
		this.breakSound = breakSound;
		return this;
	}

	public boolean canPlaceBlockAt(World worldIn, Position pos) {
		return true;
	}
}
