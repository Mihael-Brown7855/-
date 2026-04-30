package com.example.dragonmod.client;

import com.example.dragonmod.DragonMod;
import com.example.dragonmod.client.render.FireDragonModel;
import com.example.dragonmod.client.render.FireDragonRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class DragonModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(FireDragonModel.LAYER, FireDragonModel::getTexturedModelData);
        EntityRendererRegistry.register(DragonMod.FIRE_DRAGON, FireDragonRenderer::new);
    }
}
