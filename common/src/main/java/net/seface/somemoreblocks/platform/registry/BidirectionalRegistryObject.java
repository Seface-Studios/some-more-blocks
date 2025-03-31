package net.seface.somemoreblocks.platform.registry;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import lombok.Getter;
import net.minecraft.resources.ResourceLocation;

import java.util.Optional;

public class BidirectionalRegistryObject<K, V> {

  @Getter
  private final ResourceLocation id;

  private final BiMap<K, V> next;
  private final BiMap<V, K> previous;

  public BidirectionalRegistryObject(ResourceLocation identifier) {
    this.id = identifier;
    this.next = HashBiMap.create();
    this.previous = this.next.inverse();
  }

  public void register(K input, V output) {
    this.next.put(input, output);
  }

  public Optional<V> getNext(K value) {
    return Optional.ofNullable(this.next.get(value));
  }

  public Optional<K> getPrevious(V value) {
    return Optional.ofNullable(this.previous.get(value));
  }

  public static <K, V> BidirectionalRegistryObject<K, V> create(ResourceLocation id) {
    return new BidirectionalRegistryObject<>(id);
  }
}
