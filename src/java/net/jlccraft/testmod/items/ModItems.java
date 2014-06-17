package net.jlccraft.testmod.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

/**
 * Created by jerrod on 6/3/2014.
 */
public class ModItems {

    public static Item itemWindmill = new ItemWindmill();
    public static void Init() {

        GameRegistry.registerItem(itemWindmill, "Windmill");

    }

}
