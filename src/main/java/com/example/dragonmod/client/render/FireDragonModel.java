package com.example.dragonmod.client.render;

import com.example.dragonmod.DragonMod;
import com.example.dragonmod.entity.FireDragonEntity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class FireDragonModel extends SinglePartEntityModel<FireDragonEntity> {
    public static final EntityModelLayer LAYER = new EntityModelLayer(new Identifier(DragonMod.MOD_ID, "fire_dragon"), "main");

    private final ModelPart root;
    private final ModelPart head;
    private final ModelPart leftWing;
    private final ModelPart rightWing;
    private final ModelPart tail;

    public FireDragonModel(ModelPart root) {
        this.root = root;
        this.head = root.getChild(EntityModelPartNames.HEAD);
        this.leftWing = root.getChild("left_wing");
        this.rightWing = root.getChild("right_wing");
        this.tail = root.getChild(EntityModelPartNames.TAIL);
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData root = modelData.getRoot();

        root.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create()
                .uv(0, 0).cuboid(-8.0F, -8.0F, -12.0F, 16.0F, 16.0F, 28.0F),
                ModelTransform.pivot(0.0F, 10.0F, 0.0F));
        root.addChild(EntityModelPartNames.HEAD, ModelPartBuilder.create()
                .uv(0, 44).cuboid(-5.0F, -5.0F, -10.0F, 10.0F, 10.0F, 12.0F)
                .uv(44, 44).cuboid(-2.0F, -2.0F, -16.0F, 4.0F, 4.0F, 6.0F)
                .uv(0, 66).cuboid(-4.0F, -9.0F, -5.0F, 2.0F, 4.0F, 2.0F)
                .uv(8, 66).cuboid(2.0F, -9.0F, -5.0F, 2.0F, 4.0F, 2.0F),
                ModelTransform.pivot(0.0F, 6.0F, -14.0F));
        root.addChild(EntityModelPartNames.TAIL, ModelPartBuilder.create()
                .uv(64, 0).cuboid(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 24.0F),
                ModelTransform.pivot(0.0F, 10.0F, 14.0F));
        root.addChild("left_wing", ModelPartBuilder.create()
                .uv(0, 76).cuboid(0.0F, 0.0F, -4.0F, 26.0F, 1.0F, 18.0F, new Dilation(0.0F)),
                ModelTransform.pivot(7.0F, 3.0F, -2.0F));
        root.addChild("right_wing", ModelPartBuilder.create()
                .uv(0, 95).cuboid(-26.0F, 0.0F, -4.0F, 26.0F, 1.0F, 18.0F, new Dilation(0.0F)),
                ModelTransform.pivot(-7.0F, 3.0F, -2.0F));
        root.addChild("left_front_leg", ModelPartBuilder.create()
                .uv(88, 44).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F),
                ModelTransform.pivot(5.0F, 12.0F, -8.0F));
        root.addChild("right_front_leg", ModelPartBuilder.create()
                .uv(88, 44).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F),
                ModelTransform.pivot(-5.0F, 12.0F, -8.0F));
        root.addChild("left_back_leg", ModelPartBuilder.create()
                .uv(104, 44).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F),
                ModelTransform.pivot(5.0F, 12.0F, 10.0F));
        root.addChild("right_back_leg", ModelPartBuilder.create()
                .uv(104, 44).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F),
                ModelTransform.pivot(-5.0F, 12.0F, 10.0F));

        return TexturedModelData.of(modelData, 128, 128);
    }

    @Override
    public ModelPart getPart() {
        return root;
    }

    @Override
    public void setAngles(FireDragonEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        head.yaw = headYaw * ((float) Math.PI / 180.0F);
        head.pitch = headPitch * ((float) Math.PI / 180.0F);

        float flap = MathHelper.sin(animationProgress * 0.35F) * 0.35F;
        leftWing.roll = 0.35F + flap;
        rightWing.roll = -0.35F - flap;
        tail.yaw = MathHelper.sin(animationProgress * 0.12F) * 0.18F;
    }
}
