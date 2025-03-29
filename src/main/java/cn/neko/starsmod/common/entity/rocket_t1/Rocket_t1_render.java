package cn.neko.starsmod.common.entity.rocket_t1;

import cn.neko.starsmod.common.StarsMod;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class Rocket_t1_render extends MobEntityRenderer<Rocket_t1_entity, Rocket_t1_model> {

    public Rocket_t1_render(EntityRendererFactory.Context context) {
        super(context, new Rocket_t1_model(Rocket_t1_model.getTexturedModelData().createModel()), 1.0f);
    }

    @Override
    public Identifier getTexture(Rocket_t1_entity entity) {
        return new Identifier(StarsMod.MOD_ID, "textures/entity/rockets/rocket_t1.png");
    }
}
