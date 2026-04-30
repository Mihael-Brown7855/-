package com.example.dragonmod.client.render;

import com.example.dragonmod.DragonMod;
import com.example.dragonmod.entity.FireDragonEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class FireDragonRenderer extends MobEntityRenderer<FireDragonEntity, FireDragonModel> {
    private static final Identifier TEXTURE = DragonMod.id("textures/entity/fire_dragon.png");

    public FireDragonRenderer(EntityRendererFactory.Context context) {
        super(context, new FireDragonModel(context.getPart(FireDragonModel.LAYER)), 0.9F);
    }

    @Override
    public void render(
        FireDragonEntity dragon,
        float yaw,
        float tickDelta,
        MatrixStack matrices,
        VertexConsumerProvider vertexConsumers,
        int light
    ) {
        matrices.push();
        matrices.scale(1.5F, 1.5F, 1.5F);
        super.render(dragon, yaw, tickDelta, matrices, vertexConsumers, light);
        matrices.pop();
    }

    @Override
    public Identifier getTexture(FireDragonEntity entity) {
        return TEXTURE;
    }
}
