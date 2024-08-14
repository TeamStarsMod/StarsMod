package cn.neko.starsmod.entity.rocket_t1;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class rocket_t1_model extends EntityModel<rocket_t1_entity> {
	private final ModelPart bb_main;
	public rocket_t1_model(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bb_main = modelPartData.addChild("bb_main", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -7.0F, -1.0F, 3.0F, 5.0F, 3.0F, new Dilation(0.0F))
		.uv(12, 0).cuboid(0.0F, -4.0F, -2.0F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F))
		.uv(8, 8).cuboid(-2.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F))
		.uv(4, 8).cuboid(0.0F, -4.0F, 2.0F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 8).cuboid(2.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F))
		.uv(11, 7).cuboid(0.0F, -8.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		return TexturedModelData.of(modelData, 16, 16);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		bb_main.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public void setAngles(rocket_t1_entity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
	}
}