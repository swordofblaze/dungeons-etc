package com.swordofblaze.dungeons_etc.common.capability.stress;

public interface IStressCapability {

    /**
     * @return - The current amount of stress from a player.
     */
    int getStress();

    /**
     * Set the amount of stress for the player.
     */
    void setStress(int stress);

    /**
     * @param amount The amount of stress to add.
     */
    void addStress(int amount);

    /**
     * @param amount The amount of stress to subtract.
     */
    void subtractStress(int amount);
}
