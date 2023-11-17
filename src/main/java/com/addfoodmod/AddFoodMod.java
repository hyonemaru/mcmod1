package com.addfoodmod;

import com.addfoodmod.Blocks.CompressedWoodCoal;
import com.addfoodmod.Blocks.JumpBlock;
import com.addfoodmod.Blocks.SpecialCookingTable;
import com.addfoodmod.Blocks.WoodCoalBlock;
import com.addfoodmod.Items.*;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;


@Mod(modid = "addfoodmod",
        name = "AddFoodMod",
        version ="1.1.0",
        acceptedMinecraftVersions = "[1.12]")
@Mod.EventBusSubscriber(modid = "addfoodmod")
public class AddFoodMod {
    public static final String MOD_ID = "addfoodmod";

    public static final Item BAKED_APPLE = new BakedApple(6,0.5f,false);
    public static final Block CWC = new CompressedWoodCoal();
    public static final Block WOOD_COAL_BLOCK = new WoodCoalBlock();
    public static final Item CHEESE = new Cheese(3,2,false);
    public static final Item COOKIE = new Cookie(6,0.5f,false);
    public static final Item OREO_COOKIE = new Oreo_Cookie(7,0.4f,false);
    public static final Item CARROT_CAKE=new CarrotCake(10,0.8f,false);
    public static final Block SCT = new SpecialCookingTable();
    public static final Block JB = new JumpBlock();
    @SubscribeEvent
    public static void onRegisterItems(RegistryEvent.Register<Item> event){
        event.getRegistry().register(BAKED_APPLE.setRegistryName(MOD_ID,"baked_apple"));
        event.getRegistry().register(CHEESE.setRegistryName(MOD_ID,"cheese"));
        event.getRegistry().register(COOKIE.setRegistryName(MOD_ID,"plain_cookie"));
        event.getRegistry().register(OREO_COOKIE.setRegistryName(MOD_ID,"oreo_cookie"));
        event.getRegistry().register(CARROT_CAKE.setRegistryName(MOD_ID,"carrot_cake"));
        event.getRegistry().register(new ItemBlock(CWC).setRegistryName(MOD_ID,"compressed_wood_coal"));
        event.getRegistry().register(new ItemBlock(WOOD_COAL_BLOCK).setRegistryName(MOD_ID,"wood_coal_block"));
        event.getRegistry().register(new ItemBlock(SCT).setRegistryName(MOD_ID,"special_cooking_table"));
        event.getRegistry().register(new ItemBlock(JB).setRegistryName(MOD_ID,"jump_block"));
    }
    @SubscribeEvent
    public static void onRegisterBlocks(RegistryEvent.Register<Block> event){
        event.getRegistry().register(CWC.setRegistryName(MOD_ID,"compressed_wood_coal"));
        event.getRegistry().register(WOOD_COAL_BLOCK.setRegistryName(MOD_ID,"wood_coal_block"));
        event.getRegistry().register(SCT.setRegistryName(MOD_ID,"special_cooking_table"));
        event.getRegistry().register(JB.setRegistryName(MOD_ID,"jump_block"));
    }
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event){
        ModelLoader.setCustomModelResourceLocation(BAKED_APPLE,0,
        new ModelResourceLocation(BAKED_APPLE.getRegistryName(),"invntory"));
        ModelLoader.setCustomModelResourceLocation(CHEESE,0,
        new ModelResourceLocation(CHEESE.getRegistryName(),"invntory"));
        ModelLoader.setCustomModelResourceLocation(COOKIE,0,
        new ModelResourceLocation(COOKIE.getRegistryName(),"invntory"));
        ModelLoader.setCustomModelResourceLocation(OREO_COOKIE,0,
        new ModelResourceLocation(OREO_COOKIE.getRegistryName(),"invntory"));
        ModelLoader.setCustomModelResourceLocation(CARROT_CAKE,0,
        new ModelResourceLocation(CARROT_CAKE.getRegistryName(),"invntory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(CWC),0,
        new ModelResourceLocation(CWC.getRegistryName(),"inventry"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(WOOD_COAL_BLOCK),0,
        new ModelResourceLocation(WOOD_COAL_BLOCK.getRegistryName(),"inventry"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(SCT),0,
        new ModelResourceLocation(SCT.getRegistryName(),"inventry"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(JB),0,
        new ModelResourceLocation(JB.getRegistryName(),"inventry"));
    }


}
