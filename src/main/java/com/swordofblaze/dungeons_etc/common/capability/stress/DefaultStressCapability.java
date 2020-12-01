package com.swordofblaze.dungeons_etc.common.capability.stress;

public class DefaultStressCapability implements IStressCapability {

    private int stress;

    public static int maxStress() {
        return 200;
    }

    @Override
    public int getStress() {
        return this.stress;
    }

    @Override
    public void setStress(int stress) {
        this.stress = stress;
    }

    @Override
    public void addStress(int amount) {
        int newStress = this.stress + amount;

        if (newStress > maxStress())
            newStress = maxStress();

        this.setStress(newStress);
    }

    @Override
    public void subtractStress(int amount) {
        int newStress = this.stress - amount;

        if (newStress < 0)
            newStress = 0;

        this.setStress(newStress);
    }
}
