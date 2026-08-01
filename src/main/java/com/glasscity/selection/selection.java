package com.glasscity.selection;

import net.minecraft.core.BlockPos;

/**
 * プレイヤーが選択した範囲を保持するクラス
 */
public class Selection {

    private BlockPos pos1;
    private BlockPos pos2;

    public Selection() {
    }

    public BlockPos getPos1() {
        return pos1;
    }

    public void setPos1(BlockPos pos1) {
        this.pos1 = pos1;
    }

    public BlockPos getPos2() {
        return pos2;
    }

    public void setPos2(BlockPos pos2) {
        this.pos2 = pos2;
    }

    /**
     * Pos1・Pos2の両方が設定済みか
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
    public int getWidth() {

        if (!isComplete()) {
            return 0;
        }

        return getMax().getX() - getMin().getX() + 1;
    }

    /**
     * Y方向サイズ
     */
    public int getHeight() {

        if (!isComplete()) {
            return 0;
        }

        return getMax().getY() - getMin().getY() + 1;
    }

    /**
     * Z方向サイズ
     */
    public int getLength() {

        if (!isComplete()) {
            return 0;
        }

        return getMax().getZ() - getMin().getZ() + 1;
    }

    /**
     * ブロック総数
     */
    public long getVolume() {

        if (!isComplete()) {
            return 0;
        }

        return (long) getWidth()
                * getHeight()
                * getLength();
    }

    /**
     * 範囲内か判定
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
            return "Selection[Incomplete]";
        }

        return String.format(
                "Selection[(%d,%d,%d)->(%d,%d,%d)]",
                getMin().getX(),
                getMin().getY(),
                getMin().getZ(),
                getMax().getX(),
                getMax().getY(),
                getMax().getZ()
        );
    }
}
