package cn.neko.starsmod.entity.rocket_t1;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class rocket_t1_render extends MobEntityRenderer<rocket_t1_entity, rocket_t1_model> {

    public rocket_t1_render(EntityRendererFactory.Context context) {
        super(context, new rocket_t1_model(rocket_t1_model.getTexturedModelData().createModel()), 1.0f);
    }

    @Override
    public Identifier getTexture(rocket_t1_entity entity) {
        return new Identifier("starsmod", "textures/entity/rockets/rocket_t1.png");
    }
}
