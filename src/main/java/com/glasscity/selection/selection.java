package com.glasscity.selection;

import net.minecraft.util.math.BlockPos;

import java.util.Objects;

/**
 * プレイヤーが選択した範囲を保持するクラス。
 *
 * <p>WorldEditのSelectionに近い役割を持つ。</p>
 */
public class Selection {

    private BlockPos pos1;
    private BlockPos pos2;

    /**
     * Position1を取得
     */
    public BlockPos getPos1() {
        return pos1;
    }

    /**
     * Position1を設定
     */
    public void setPos1(BlockPos pos1) {
        this.pos1 = Objects.requireNonNull(pos1);
    }

    /**
     * Position2を取得
     */
    public BlockPos getPos2() {
        return pos2;
    }

    /**
     * Position2を設定
     */
    public void setPos2(BlockPos pos2) {
        this.pos2 = Objects.requireNonNull(pos2);
    }

    /**
     * Position1・2の両方が設定済みか
     */
    public boolean isComplete() {
        return pos1 != null && pos2 != null;
    }

    /**
     * 選択解除
     */
    public void clear() {
        pos1 = null;
        pos2 = null;
    }

    /**
     * 最小座標
     */
    public BlockPos getMin() {

        if (!isComplete()) {
            return null;
        }

        return new BlockPos(
                Math.min(pos1.getX(), pos2.getX()),
                Math.min(pos1.getY(), pos2.getY()),
                Math.min(pos1.getZ(), pos2.getZ())
        );
    }

    /**
     * 最大座標
     */
    public BlockPos getMax() {

        if (!isComplete()) {
            return null;
        }

        return new BlockPos(
                Math.max(pos1.getX(), pos2.getX()),
                Math.max(pos1.getY(), pos2.getY()),
                Math.max(pos1.getZ(), pos2.getZ())
        );
    }

    /**
     * X方向サイズ
     */
    public int getSizeX() {

        if (!isComplete()) {
            return 0;
        }

        return getMax().getX() - getMin().getX() + 1;
    }

    /**
     * Y方向サイズ
     */
    public int getSizeY() {

        if (!isComplete()) {
            return 0;
        }

        return getMax().getY() - getMin().getY() + 1;
    }

    /**
     * Z方向サイズ
     */
    public int getSizeZ() {

        if (!isComplete()) {
            return 0;
        }

        return getMax().getZ() - getMin().getZ() + 1;
    }

    /**
     * 範囲内のブロック数
     */
    public long getVolume() {

        if (!isComplete()) {
            return 0L;
        }

        return (long) getSizeX()
                * getSizeY()
                * getSizeZ();
    }

    /**
     * 指定座標が選択範囲内か
     */
    public boolean contains(BlockPos pos) {

        if (!isComplete()) {
            return false;
        }

        BlockPos min = getMin();
        BlockPos max = getMax();

        return pos.getX() >= min.getX()
                && pos.getX() <= max.getX()
                && pos.getY() >= min.getY()
                && pos.getY() <= max.getY()
                && pos.getZ() >= min.getZ()
                && pos.getZ() <= max.getZ();
    }

    @Override
    public String toString() {

        if (!isComplete()) {
            return "Selection{Incomplete}";
        }

        return String.format(
                "Selection{(%d,%d,%d)->(%d,%d,%d)}",
                getMin().getX(),
                getMin().getY(),
                getMin().getZ(),
                getMax().getX(),
                getMax().getY(),
                getMax().getZ()
        );
    }

}
