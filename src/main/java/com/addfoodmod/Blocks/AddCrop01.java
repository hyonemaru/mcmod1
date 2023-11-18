package com.addfoodmod.Blocks;

import com.addfoodmod.AddFoodMod;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;

public class AddCrop01 extends BlockCrops {

    public AddCrop01() {

    }

    @Override
    protected Item getSeed() {
        return AddFoodMod.ADD_SEED_01;
    }

    @Override
    protected Item getCrop() {
        return AddFoodMod.ITEM_ADD_CROP_01;
    }
}
