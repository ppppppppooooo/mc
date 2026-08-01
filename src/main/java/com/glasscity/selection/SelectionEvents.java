package com.glasscity.selection;

import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;

public final class SelectionEvents {

    private final SelectionManager manager;

    public SelectionEvents(SelectionManager manager) {
        this.manager = manager;
    }

    public void register() {

        /*
         * 左クリック
         */
        AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {

            if (world.isClient()) {
                return ActionResult.PASS;
            }

            if (!(player instanceof ServerPlayerEntity serverPlayer)) {
                return ActionResult.PASS;
            }

            if (hand != Hand.MAIN_HAND) {
                return ActionResult.PASS;
            }

            if (!player.getMainHandStack().isOf(Items.DIAMOND_AXE)) {
                return ActionResult.PASS;
            }

            manager.setPos1(serverPlayer, pos);

            player.sendMessage(
                    Text.literal(
                            String.format(
                                    "§aPosition 1 set (§e%d§a, §e%d§a, §e%d§a)",
                                    pos.getX(),
                                    pos.getY(),
                                    pos.getZ()
                            )
                    ),
                    false
            );

            return ActionResult.FAIL;
        });

        /*
         * 右クリック
         */
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {

            if (world.isClient()) {
                return ActionResult.PASS;
            }

            if (!(player instanceof ServerPlayerEntity serverPlayer)) {
                return ActionResult.PASS;
            }

            if (hand != Hand.MAIN_HAND) {
                return ActionResult.PASS;
            }

            if (!player.getMainHandStack().isOf(Items.DIAMOND_AXE)) {
                return ActionResult.PASS;
            }

            BlockHitResult hit = hitResult;

            manager.setPos2(serverPlayer, hit.getBlockPos());

            player.sendMessage(
                    Text.literal(
                            String.format(
                                    "§aPosition 2 set (§e%d§a, §e%d§a, §e%d§a)",
                                    hit.getBlockPos().getX(),
                                    hit.getBlockPos().getY(),
                                    hit.getBlockPos().getZ()
                            )
                    ),
                    false
            );

            return ActionResult.SUCCESS;
        });

    }

}
