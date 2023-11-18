package com.addfoodmod;

import com.addfoodmod.Blocks.*;
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

import javax.jws.WebParam;
import java.awt.print.Book;


@Mod(modid = "addfoodmod",
        name = "AddFoodMod",
        version ="1.2.3",
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
    public static final Item TBOOK = new TBook();
    public static final Item CBOOK = new MyCustomBook();
    public static final Block ADD_CROP_01 = new AddCrop01();
    public static final Item ADD_SEED_01 = new AddSeed01();
    public static final Item ITEM_ADD_CROP_01 = new ItemAddCrop01();
    public static final Item IOL = new IumpOfLife();
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
        event.getRegistry().register(TBOOK.setRegistryName(MOD_ID,"t_book"));
        event.getRegistry().register(CBOOK.setRegistryName(MOD_ID,"c_book"));
        event.getRegistry().register(ADD_SEED_01.setRegistryName(MOD_ID,"add_seed_01"));
        event.getRegistry().register(ITEM_ADD_CROP_01.setRegistryName(MOD_ID,"item_add_crop_01"));
        event.getRegistry().register(new ItemBlock(ADD_CROP_01).setRegistryName(MOD_ID,"add_crop_block_01"));
        event.getRegistry().register(IOL.setRegistryName(MOD_ID,"iump_of_life"));

    }
    @SubscribeEvent
    public static void onRegisterBlocks(RegistryEvent.Register<Block> event){
        event.getRegistry().register(CWC.setRegistryName(MOD_ID,"compressed_wood_coal"));
        event.getRegistry().register(WOOD_COAL_BLOCK.setRegistryName(MOD_ID,"wood_coal_block"));
        event.getRegistry().register(SCT.setRegistryName(MOD_ID,"special_cooking_table"));
        event.getRegistry().register(JB.setRegistryName(MOD_ID,"jump_block"));
        event.getRegistry().register(ADD_CROP_01.setRegistryName(MOD_ID,"add_crop_block_01"));
    }
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event){
        ModelLoader.setCustomModelResourceLocation(BAKED_APPLE,0,
        new ModelResourceLocation(BAKED_APPLE.getRegistryName(),"inventory"));
        ModelLoader.setCustomModelResourceLocation(CHEESE,0,
        new ModelResourceLocation(CHEESE.getRegistryName(),"inventory"));
        ModelLoader.setCustomModelResourceLocation(COOKIE,0,
        new ModelResourceLocation(COOKIE.getRegistryName(),"inventory"));
        ModelLoader.setCustomModelResourceLocation(OREO_COOKIE,0,
        new ModelResourceLocation(OREO_COOKIE.getRegistryName(),"inventory"));
        ModelLoader.setCustomModelResourceLocation(CARROT_CAKE,0,
        new ModelResourceLocation(CARROT_CAKE.getRegistryName(),"inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(CWC),0,
        new ModelResourceLocation(CWC.getRegistryName(),"inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(WOOD_COAL_BLOCK),0,
        new ModelResourceLocation(WOOD_COAL_BLOCK.getRegistryName(),"inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(SCT),0,
        new ModelResourceLocation(SCT.getRegistryName(),"inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(JB),0,
        new ModelResourceLocation(JB.getRegistryName(),"inventory"));
        ModelLoader.setCustomModelResourceLocation(TBOOK,0,
        new ModelResourceLocation(TBOOK.getRegistryName(),"inventory"));
        ModelLoader.setCustomModelResourceLocation(CBOOK,0,
        new ModelResourceLocation(TBOOK.getRegistryName(),"inventory"));
        ModelLoader.setCustomModelResourceLocation(ADD_SEED_01,0,
        new ModelResourceLocation(ADD_SEED_01.getRegistryName(),"inventory"));
        ModelLoader.setCustomModelResourceLocation(ITEM_ADD_CROP_01,0,
        new ModelResourceLocation(ITEM_ADD_CROP_01.getRegistryName(),"inventory"));

        for (int f = 0; f < 8; f++) {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ADD_CROP_01),f,
            new ModelResourceLocation(ADD_CROP_01.getRegistryName(),"age="+f));
        }
        ModelLoader.setCustomModelResourceLocation(IOL,0,
        new ModelResourceLocation(IOL.getRegistryName(),"inventory"));
    }
}
