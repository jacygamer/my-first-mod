package net.jlccraft.testmod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.jlccraft.testmod.blocks.ModBlocks;
import net.jlccraft.testmod.events.ModEvents;
import net.jlccraft.testmod.handler.ModHandlers;
import net.jlccraft.testmod.lib.Reference;
import net.jlccraft.testmod.tileentity.ModTileEntitys;
import net.jlccraft.testmod.creativetab.ModTabs;
import net.jlccraft.testmod.items.ModItems;
import net.jlccraft.testmod.proxy.CommonProxy;

/**
 * Created by jerrod on 6/3/2014.
 */
@Mod(modid = Reference.MODID, name = Reference.MODNAME, version = Reference.VERSION)
public class TestMod {

    @Mod.Instance(Reference.MODID)
    public static TestMod instance;

    @SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.COMMON, modId = Reference.MODID)
    public static CommonProxy proxy;




    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {


        // Initialize mod blocks
        ModBlocks.Init();

        // Initialize mod items
        ModItems.Init();

        // Initialize mod Armor
        //ModArmor.Init();

        // Initialize Creative Tabs
        ModTabs.Init();

        // Initialize World Gen
        //ModWorldGen.Init();

        // Initialize porxy
        proxy.registerProxies();

    }


    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

        // Initialize Tile Entity's
          ModTileEntitys.Init();

        // Initialize mod Gui's
        ModHandlers.Init();

        // Initialize mod Recipes
        //ModRecipes.Init();

        // Initialize events
        ModEvents.Init();

        // Initialize achievements
        //ModAchievement.Init();

    }


    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

}