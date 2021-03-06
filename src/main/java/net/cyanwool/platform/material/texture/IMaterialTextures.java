package net.cyanwool.platform.material.texture;

public interface IMaterialTextures {

	public String getStringId();

	public int getIndex();

	public IMaterialTextures getTextureFromId(int id);

	public IMaterialTextures getTextureFromId(String id);
}
