package com.hakan.core.hologram;

import com.hakan.core.HCore;
import org.bukkit.Location;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public final class HHologramHandler {

    private static final Map<String, HHologram> HOLOGRAMS = new HashMap<>();

    /**
     * Initializes holograms.
     */
    public static void initialize() {
        HCore.syncScheduler().every(1)
                .run(() -> HHologramHandler.getValues().forEach(hologram -> hologram.getRenderer().render()));
    }

    /**
     * Gets content as safe.
     *
     * @return holograms map.
     */
    @Nonnull
    public static Map<String, HHologram> getContentSafe() {
        return new HashMap<>(HHologramHandler.HOLOGRAMS);
    }

    /**
     * Gets content.
     *
     * @return holograms map.
     */
    @Nonnull
    public static Map<String, HHologram> getContent() {
        return HHologramHandler.HOLOGRAMS;
    }

    /**
     * Gets holograms as safe.
     *
     * @return holograms.
     */
    @Nonnull
    public static Collection<HHologram> getValuesSafe() {
        return new ArrayList<>(HHologramHandler.HOLOGRAMS.values());
    }

    /**
     * Gets holograms.
     *
     * @return holograms.
     */
    @Nonnull
    public static Collection<HHologram> getValues() {
        return HHologramHandler.HOLOGRAMS.values();
    }

    /**
     * Finds a created hologram
     *
     * @param id hologram id that you want
     * @return hologram from id
     */
    @Nonnull
    public static Optional<HHologram> findByID(@Nonnull String id) {
        return Optional.ofNullable(HHologramHandler.HOLOGRAMS.get(Objects.requireNonNull(id, "id cannot be null!")));
    }

    /**
     * Gets a created hologram
     *
     * @param id hologram id that you want
     * @return hologram from id
     */
    @Nonnull
    public static HHologram getByID(@Nonnull String id) {
        return HHologramHandler.findByID(id).orElseThrow(() -> new NullPointerException("hologram(" + id + ") cannot be null!"));
    }

    /**
     * Creates a new hologram
     *
     * @param id       hologram id
     * @param location location
     * @param players  player list
     * @return new hologram
     */
    @Nonnull
    public static HHologram create(@Nonnull String id, @Nonnull Location location, @Nullable Set<UUID> players) {
        Objects.requireNonNull(id, "id cannot be null");
        Objects.requireNonNull(location, "location cannot be null");

        HHologramHandler.delete(id);

        HHologram hHologram = (players != null) ? new HHologram(id, location, players) : new HHologram(id, location);
        HHologramHandler.HOLOGRAMS.put(id, hHologram);
        return hHologram;
    }

    /**
     * Creates a new hologram
     *
     * @param id       hologram id
     * @param location location
     * @return new hologram
     */
    @Nonnull
    public static HHologram create(@Nonnull String id, @Nonnull Location location) {
        return HHologramHandler.create(id, location, null);
    }

    /**
     * Deletes hologram by id
     *
     * @param id id of hologram
     * @return hologram to be deleted
     */
    @Nullable
    public static HHologram delete(@Nonnull String id) {
        Objects.requireNonNull(id, "id cannot be null");

        HHologram oldHologram = HHologramHandler.HOLOGRAMS.get(id);
        if (oldHologram != null)
            oldHologram.delete();

        return oldHologram;
    }
}