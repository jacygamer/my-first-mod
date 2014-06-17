package net.jlccraft.testmod.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

/**
 * Created by jerrod on 6/3/2014.
 */
public class TabMyTab extends CreativeTabs {


    public TabMyTab(int id, String name) {
        super(id, name);
    }

    @Override
    public Item getTabIconItem() {
        return Items.bed;
    }
}
