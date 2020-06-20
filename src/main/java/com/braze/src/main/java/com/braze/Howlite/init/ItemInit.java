package com.braze.Howlite.init;


import com.braze.Howlite.Howlite;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid= Howlite.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(Howlite.MOD_ID)
public class ItemInit {

    public static final Item example_item = null;
    public static final Item example_sword = null;
    public static final Item special_item = null;

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new Item(new Item.Properties().group(Howlite.HowliteItemGroup.instance)).setRegistryName("example_item"));
        //event.getRegistry().register(new SpecialItem(new Item.Properties().group(Howlite.HowliteItemGroup.instance)).setRegistryName("special_item"));

        event.getRegistry().register(new SwordItem(ModItemTier.EXAMPLE, 7, 4.0f, new Item.Properties().group(Howlite.HowliteItemGroup.instance)).setRegistryName("example_sword"));
        event.getRegistry().register(new PickaxeItem(ModItemTier.EXAMPLE, 4, 4.0f, new Item.Properties().group(Howlite.HowliteItemGroup.instance)).setRegistryName("example_pickaxe"));

    }


    public enum ModItemTier implements IItemTier {
        EXAMPLE(5, 3000, 15, 7.0f, 300, () -> {
           return Ingredient.fromItems(ItemInit.example_item);
        });
        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantability;
        private final LazyValue<Ingredient> repairMateriel;

        private ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
            this.harvestLevel = harvestLevel;
            this.maxUses = maxUses;
            this.efficiency = efficiency;
            this.attackDamage = attackDamage;
            this.enchantability = enchantability;
            this.repairMateriel = new LazyValue<> (repairMaterial);
        }

        @Override
        public int getMaxUses() {
            return this.maxUses;
        }

        @Override
        public float getEfficiency() {
            return this.efficiency;
        }

        @Override
        public float getAttackDamage() {
            return this.attackDamage;
        }

        @Override
        public int getHarvestLevel() {
            return this.harvestLevel;
        }

        @Override
        public int getEnchantability() {
            return this.enchantability;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return this.repairMateriel.getValue();
        }
    }
}
