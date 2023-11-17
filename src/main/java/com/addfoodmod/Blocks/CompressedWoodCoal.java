package com.addfoodmod.Blocks;


import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CompressedWoodCoal extends Block {

    public CompressedWoodCoal(){
        super(Material.ROCK);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        this.setHardness(6.0f);
        this.setResistance(5.0f);
        this.setSoundType(SoundType.STONE);
        this.setUnlocalizedName("compressed_wood_coal");
        GameRegistry.registerFuelHandler(new IFuelHandler() {
            @Override
            public int getBurnTime(ItemStack fuel){
                if(fuel.getItem() == Item.getItemFromBlock(CompressedWoodCoal.this)){
                return 160000;
            }
                return 0;
            }
        });
    }

}
