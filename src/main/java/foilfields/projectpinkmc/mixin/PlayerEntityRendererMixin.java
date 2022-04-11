package foilfields.projectpinkmc.mixin;

import foilfields.projectpinkmc.PlayerPigManager;
import foilfields.projectpinkmc.statuseffect.StatusEffects;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

// https://github.com/Draylar/identity/blob/1.17/src/main/java/draylar/identity/mixin/PlayerEntityRendererMixin.java
@Mixin(PlayerEntityRenderer.class)
public abstract class PlayerEntityRendererMixin extends LivingEntityRenderer<AbstractClientPlayerEntity, PlayerEntityModel<AbstractClientPlayerEntity>> {
    public PlayerEntityRendererMixin(EntityRendererFactory.Context ctx, PlayerEntityModel<AbstractClientPlayerEntity> model, float shadowRadius) {
        super(ctx, model, shadowRadius);
    }

    @Redirect(
            method = "render",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/entity/LivingEntityRenderer;render(Lnet/minecraft/entity/LivingEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"))
    private void render(LivingEntityRenderer renderer, LivingEntity player, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if (player.hasStatusEffect(StatusEffects.PIG)) {
            LivingEntity playerPig = PlayerPigManager.getPig(player);

            playerPig.lastLimbDistance = player.lastLimbDistance;
            playerPig.limbDistance = player.limbDistance;
            playerPig.limbAngle = player.limbAngle;
            playerPig.handSwinging = player.handSwinging;
            playerPig.handSwingTicks = player.handSwingTicks;
            playerPig.lastHandSwingProgress = player.lastHandSwingProgress;
            playerPig.handSwingProgress = player.handSwingProgress;
            playerPig.bodyYaw = player.bodyYaw;
            playerPig.prevBodyYaw = player.prevBodyYaw;
            playerPig.headYaw = player.headYaw;
            playerPig.prevHeadYaw = player.prevHeadYaw;
            playerPig.setOnGround(player.isOnGround());
            playerPig.setVelocity(player.getVelocity());

            playerPig.setPitch(player.getPitch());
            playerPig.prevPitch = player.prevPitch;

            playerPig.setPose(player.getPose());

            EntityRenderer pigRenderer = MinecraftClient.getInstance().getEntityRenderDispatcher().getRenderer(playerPig);
            pigRenderer.render(playerPig, f, g, matrixStack, vertexConsumerProvider, i);

        } else {
            super.render((AbstractClientPlayerEntity) player, f, g, matrixStack, vertexConsumerProvider, i);
        }
    }
}
