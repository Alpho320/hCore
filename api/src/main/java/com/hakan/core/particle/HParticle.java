package com.hakan.core.particle;

import org.bukkit.Color;
import org.bukkit.util.Vector;

import javax.annotation.Nonnull;
import java.util.Objects;

/**
 * HParticle class.
 */
public final class HParticle {

    private String particleName;
    private Vector offset;
    private Color color;
    private int amount;
    private double speed;

    /**
     * Creates new instance of this class.
     *
     * @param particleName Particle name.
     * @param amount       Amount.
     * @param speed        Speed.
     * @param offset       Offset.
     * @param color        Particle Color.
     */
    public HParticle(@Nonnull String particleName, int amount, double speed, @Nonnull Vector offset, @Nonnull Color color) {
        this.particleName = Objects.requireNonNull(particleName, "particle name cannot be null!");
        this.offset = Objects.requireNonNull(offset, "offset cannot be null!");
        this.color = Objects.requireNonNull(color, "color cannot be null!");
        this.amount = amount;
        this.speed = speed;
    }

    /**
     * Creates new instance of this class.
     *
     * @param particleName Particle name.
     * @param amount       Amount.
     * @param speed        Speed.
     * @param offset       Offset.
     */
    public HParticle(@Nonnull String particleName, int amount, double speed, @Nonnull Vector offset) {
        this(particleName, amount, speed, offset, Color.WHITE);
    }

    /**
     * Creates new instance of this class.
     *
     * @param particleName Particle name.
     * @param amount       Amount.
     * @param offset       Offset.
     */
    public HParticle(@Nonnull String particleName, int amount, @Nonnull Vector offset) {
        this(particleName, amount, 0.1, offset, Color.WHITE);
    }

    /**
     * Creates new instance of this class.
     *
     * @param particleName Particle name.
     * @param speed        Amount.
     * @param offset       Offset.
     */
    public HParticle(@Nonnull String particleName, double speed, @Nonnull Vector offset) {
        this(particleName, 10, speed, offset, Color.WHITE);
    }

    /**
     * Creates new instance of this class.
     *
     * @param particleName Particle name.
     * @param offset       Offset.
     */
    public HParticle(@Nonnull String particleName, @Nonnull Vector offset) {
        this(particleName, 10, 1, offset, Color.WHITE);
    }

    /**
     * Creates new instance of this class.
     *
     * @param particleName Particle name.
     */
    public HParticle(@Nonnull String particleName) {
        this(particleName, 10, 1, new Vector(0.1, 0.1, 0.1), Color.WHITE);
    }

    /**
     * Gets particle name.
     *
     * @return Particle name.
     */
    @Nonnull
    public String getParticleName() {
        return this.particleName;
    }

    /**
     * Sets particle name.
     *
     * @param particleName Particle name.
     */
    public void setParticleName(@Nonnull String particleName) {
        this.particleName = Objects.requireNonNull(particleName, "particle name cannot be null!");
    }

    /**
     * Gets offset.
     *
     * @return Offset.
     */
    @Nonnull
    public Vector getOffset() {
        return this.offset;
    }

    /**
     * Sets offset.
     *
     * @param offset Offset.
     */
    public void setOffset(@Nonnull Vector offset) {
        this.offset = Objects.requireNonNull(offset, "offset cannot be null!");
    }

    /**
     * Gets color.
     *
     * @return Color.
     */
    @Nonnull
    public Color getColor() {
        return this.color;
    }

    /**
     * Sets color.
     *
     * @param color Color.
     */
    public void setColor(@Nonnull Color color) {
        this.color = Objects.requireNonNull(color, "color cannot be null!");
    }

    /**
     * Gets amount.
     *
     * @return Amount.
     */
    public int getAmount() {
        return this.amount;
    }

    /**
     * Gets amount.
     *
     * @param amount Amount.
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * Gets speed.
     *
     * @return Speed.
     */
    public double getSpeed() {
        return this.speed;
    }

    /**
     * Sets speed.
     *
     * @param speed Speed.
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
