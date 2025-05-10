package net.seface.somemoreblocks.platform;

import lombok.Getter;

import java.util.UUID;

/**
 * @deprecated This doesn't have any effects for the Platform System (yet).
 *             Marked as deprecated until there.
 */
@Deprecated()
@Getter
public enum PlatformEnvironment {
  UNKNOWN(0, "Unknown", "e7f3cf0d-8000-4fda-af29-0d085f4207dd"),
  PRODUCTION(1, "Production", "ae99973b-4b65-458a-942f-ae489bcc2dc8"),
  DEVELOPMENT(2, "Development", "ce62297d-f549-497a-ac5d-9d6e45991725");

  private final int index;
  private final String name;
  private final UUID uuid;

  PlatformEnvironment(int index, String name, String uuid) {
    this.index = index;
    this.name = name;
    this.uuid = UUID.fromString(uuid);
  }
}
