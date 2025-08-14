package net.seface.somemoreblocks.platform.registry;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import lombok.Getter;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class BidirectionalRegistryObject<K, V> {

  @Getter
  private final ResourceLocation id;

  private final BiMap<K, V> next;
  private final Map<V, K> previous;

  private BidirectionalRegistryObject(ResourceLocation identifier) {
    this.id = identifier;
    this.next = HashBiMap.create();
    this.previous = this.next.inverse();
  }

  /**
   * Registry a new object.
   * @param key The object key.
   * @param value The object value.
   */
  public void register(K key, V value) {
    if (value == null) {
      throw new IllegalArgumentException("The value cannot be null.");
    }

    if (this.next.containsKey(key)) {
      throw new IllegalArgumentException("The key " + key + " is already registered.");
    }

    this.next.put(key, value);
  }

  /**
   * Get the value of object by the key.
   * @param key The object key.
   * @return The object value.
   */
  public Optional<V> getNext(K key) {
    return Optional.ofNullable(this.next.get(key));
  }

  /**
   * Get the key of object by the value.
   * @param value The object value.
   * @return The object key.
   */
  public Optional<K> getPrevious(V value) {
    return Optional.ofNullable(this.previous.get(value));
  }

  /**
   * Get all the objects keys.
   */
  public Set<K> getKeySet() {
    return this.next.keySet();
  }

  /**
   * Get all the objects values.
   */
  public Set<V> getValueSet() {
    return this.next.values();
  }

  /**
   * Get the number os objects.
   */
  public int size() {
    return this.next.values().size();
  }

  public static <K, V> BidirectionalRegistryObject<K, V> create(ResourceLocation id) {
    return new BidirectionalRegistryObject<>(id);
  }
}
