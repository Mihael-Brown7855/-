package com.example.dragonmod;

import com.example.dragonmod.entity.FireDragonEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class DragonMod implements ModInitializer {
    public static final String MOD_ID = "dragonmod";

    public static final EntityType<FireDragonEntity> FIRE_DRAGON = Registry.register(
            Registries.ENTITY_TYPE,
            id("fire_dragon"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, FireDragonEntity::new)
                    .dimensions(EntityDimensions.fixed(2.6F, 1.8F))
                    .trackRangeBlocks(10)
                    .trackedUpdateRate(2)
                    .specificSpawnBlocks(net.minecraft.block.Blocks.NETHERRACK, net.minecraft.block.Blocks.BASALT, net.minecraft.block.Blocks.BLACKSTONE)
                    .build()
    );

    public static final Item DRAGON_SCALE = registerItem("dragon_scale", new Item(new Item.Settings()));
    public static final Item FIRE_DRAGON_SPAWN_EGG = registerItem(
            "fire_dragon_spawn_egg",
            new SpawnEggItem(FIRE_DRAGON, 0x7d1f13, 0xffb347, new Item.Settings())
    );

    public static final RegistryKey<ItemGroup> DRAGON_GROUP_KEY = RegistryKey.of(RegistryKeys.ITEM_GROUP, id("dragons"));
    public static final ItemGroup DRAGON_GROUP = Registry.register(
            Registries.ITEM_GROUP,
            DRAGON_GROUP_KEY,
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(FIRE_DRAGON_SPAWN_EGG))
                    .displayName(Text.translatable("itemGroup.dragonmod.dragons"))
                    .build()
    );

    @Override
    public void onInitialize() {
        FabricDefaultAttributeRegistry.register(FIRE_DRAGON, FireDragonEntity.createFireDragonAttributes());

        ItemGroupEvents.modifyEntriesEvent(DRAGON_GROUP_KEY).register(entries -> {
            entries.add(FIRE_DRAGON_SPAWN_EGG);
            entries.add(DRAGON_SCALE);
        });
    }

    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }

    private static Item registerItem(String path, Item item) {
        return Registry.register(Registries.ITEM, id(path), item);
    }
}
