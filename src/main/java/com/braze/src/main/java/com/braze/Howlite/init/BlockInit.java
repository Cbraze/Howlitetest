package com.braze.Howlite.init;


import com.braze.Howlite.Howlite;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Howlite.MOD_ID)
@Mod.EventBusSubscriber(modid = Howlite.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockInit {

    public static final Block howlite_ore = null;

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new Block(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(5, 6)
        .sound(SoundType.METAL)
        .harvestTool(ToolType.PICKAXE)
        .harvestLevel(2)).setRegistryName("howlite_ore"));
    }

    @SubscribeEvent
    public static void registerBlockItems(final RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new BlockItem(howlite_ore, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("howlite_ore"));
    }
}
