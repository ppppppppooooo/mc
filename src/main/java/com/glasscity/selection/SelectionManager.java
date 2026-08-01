package com.glasscity.selection;

import net.minecraft.server.network.ServerPlayerEntity;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * プレイヤー毎の範囲選択を管理するクラス
 */
public class SelectionManager {

    /**
     * UUID -> Selection
     */
    private final Map<UUID, Selection> selections = new ConcurrentHashMap<>();

    /**
     * Selection取得
     */
    public Selection getSelection(ServerPlayerEntity player) {

        return selections.computeIfAbsent(
                player.getUuid(),
                uuid -> new Selection()
        );
    }

    /**
     * Pos1設定
     */
    public void setPos1(ServerPlayerEntity player,
                        net.minecraft.util.math.BlockPos pos) {

        Selection selection = getSelection(player);
        selection.setPos1(pos);
    }

    /**
     * Pos2設定
     */
    public void setPos2(ServerPlayerEntity player,
                        net.minecraft.util.math.BlockPos pos) {

        Selection selection = getSelection(player);
        selection.setPos2(pos);
    }

    /**
     * Pos1取得
     */
    public net.minecraft.util.math.BlockPos getPos1(ServerPlayerEntity player) {

        return getSelection(player).getPos1();
    }

    /**
     * Pos2取得
     */
    public net.minecraft.util.math.BlockPos getPos2(ServerPlayerEntity player) {

        return getSelection(player).getPos2();
    }

    /**
     * 完了しているか
     */
    public boolean hasCompleteSelection(ServerPlayerEntity player) {

        return getSelection(player).isComplete();
    }

    /**
     * 選択解除
     */
    public void clear(ServerPlayerEntity player) {

        selections.remove(player.getUuid());
    }

    /**
     * 全プレイヤー削除
     */
    public void clearAll() {

        selections.clear();
    }

    /**
     * プレイヤー数
     */
    public int size() {

        return selections.size();
    }

    /**
     * 管理しているか
     */
    public boolean contains(ServerPlayerEntity player) {

        return selections.containsKey(player.getUuid());
    }

    /**
     * ログアウト時
     */
    public void remove(ServerPlayerEntity player) {

        selections.remove(player.getUuid());
    }

}
