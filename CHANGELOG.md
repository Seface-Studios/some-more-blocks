## Changelog
![Latest Release](https://img.shields.io/github/v/release/seface-studios/some-more-blocks?logo=github&logoColor=959da5&labelColor=353c43&color=0091c2&Current&label=Latest%20Release)

## [Unreleased] - June ?
#### [Commit History](https://github.com/SefaceStudios/some-more-blocks/compare/v1.0.0...v1.0.0)

Special mention for the **NeoForge port** which will be constantly maintained along with the Fabric and Forge versions. All the features/changes below are implemented on this port too!

### Added
- **Pale Rose Bush:** A new plant that can be found on pale garden biome. Different from the Eyeblosoom, this plant will not close with daylight.
- **Pale Mushroom Family**⁽⁺⁴⁾
  - Pale Mushroom
  - Pale Mushroom Colony
  - Pale Mushroom Colony Wall
  - Tall Pale Mushroom Colony
- **Redstone Shroomlight:** A new lamp-like block craftable with Shroomlight block and Redstone.
- **Redstone Sea Lantern:** A new lamp-like block craftable with Sea Lantern block and Redstone.
- **Carved Mushroom Stem:** Use a Axe on Mushroom Stem to transform into the Carved variation. This variation has a mushroom carved into it.
- **New polished basalt block family**⁽⁺¹⁶⁾
  - Polished Basalt Bricks and variants
  - Polished Basalt Tiles and variants
  - Corrupted Polished Basalt Bricks and variants
  - Chiseled Polished Basalt Bricks
  - Polished Basalt Pillar
- **Big Lily Pad generation:** The Big Lily Pad can now be found at mangrove and jungle biomes. Big Lily Pads is a 2x2 block that can be placed above water and ice blocks. This block can be rotated in 4 different directions.
- **Mushroom/Fungus Colonies generation:** The Brown and Red Mushroom Colonies can now be found on old growth biomes. The Crimson and Warped Fungus can be found in their respective biomes. There are 3 types of Mushroom/Fungus colonies, Short, Tall and Wall.
- **New plants**⁽⁺⁴⁾
  - **Reeds:** A new water plant that can grow with Cattails.
  - **Clover:** Can be found in most of forests and plains. 4 Clovers can ocupate the same block space.
  - **Nether Clover:** Can be found in all nether biomes with exception of basalt Deltas.
  - **Tall Cactus:** This block can be found in deserts and badlands alongside the Tiny Cactus.
- **Shingles Stairs:** 17 new colored stairs.
- **doSnowAccumulateOnPlants Gamerule:** If false, the gamerule will prevent some plants to be turned into snowy variant (short grass, ferns etc) and snowy plants to be turned into normal.
  - `Devs Note` - We are aware of incompatibility with some season mods like [Fabric Seasons](https://www.curseforge.com/minecraft/mc-mods/fabric-seasons) and [Serene Seasons](https://www.curseforge.com/minecraft/mc-mods/serene-seasons). While we try to decide the better way to implement this compatibility, this game rule will fix the issue. Have any suggestion about this? Send an email to `contact@sefacestudios.net` with the subject `Snowy Plants Season Mods Compatibility`.
- **New advancements**⁽⁺⁴⁾
  - **With Our Power(ed) Combined!** - Have all Redstone Froglights in your inventory.
  - **A Grate Time Waste...** - Have all Some More Blocks Grates blocks in your inventory.
  - **Very Serious Dedication** - Use Netherite Bricks to craft an unreversible block and immediately regret it.
  - **Next, We Are Going To Steal... The Moon!** - Use an Axe to carve a Stripped Pale Log (or Wood) in each lunar phase.
- **New languages**⁽⁺⁵⁾
  - **Italian:** Thanks to *Alessia04* and *biancoaleepapy*.
  - **Japanese:** Thanks to *chatintoro* and *HayaKoh*.
  - **Russian:** Thanks to *bonnie22556* and *mannoob_the_uhh*.
  - **Spanish (Spain):** Thanks to *Rubenicos*.
  - **Turkish:** Thanks to *emrzeyy*.

### Changed
- **New textures**
  - Cattails now looks more natural.
  - Carved Mangrove Log/Wood figure is now represented by a Lily Pad.
  - Corrupted Bricks are now animated.
- **World generation and distribution**
  - Short Snow Grass and Snow Fern can now be found naturally in snowy taiga and snowy plains.
  - Large Snow Fern can now be found naturally in snowy taiga.
  - Tiny Cactus will not generate in forests anymore.
    - Tiny Cactus can now only be found in deserts and badlands.
  - Cattails can now be placed and generated above gravel and sand if on water.
- **Beacon base blocks:** Iron, Gold, Diamond, Emerald and Netherite Bricks, Cut and Pillar can now be used as Beacon base block. (This is not applied for Cracked variations.)
- **Conduit activation:** Polished, Chiseled, Pillar, Tiles, Mossy Bricks and Smooth Prismarine variations can now be used as Conduit activator. (This is not applied for Cracked variations.)
- **Technical adjustments**
  - `tiny_cactus_placeable.json` was renamed to `cactus_plants_placeable.json`.
  - All the Biome Tags with `generates_*.json` format was moved to `generates/*.json` folder. This will affect how the id of this biome tags are; Check all the available Biome Tags [here](https://github.com/Seface-Studios/some-more-blocks/tree/1.21.4/common/src/main/generated/data/somemoreblocks/tags/worldgen/biome).
    - `generates_tiny_cactus.json` was renamed to `generates/cactus_plants.json`.
  - We are now fully using the Fabric Data Generation.
  - Custom Platform Service for better development.
  - Bumped the minimun Fabric version from `0.110.5+1.21.4` to `0.117.0+1.21.4`.

### Removed
- All the Parent Block Tags for all leaf litters type. The parent leaves are now set on Configured Feature file of the leaf litter.

### Fixed
- The swapped textures between Blue Contrete Bricks and Blue Concrete Tiles. [#11](https://github.com/Seface-Studios/some-more-blocks/issues/11)

---
<div>
  <img align="right" height="64" width="64" src="https://raw.githubusercontent.com/Seface-Blocks/some-more-blocks/main/.github/assets/animated_icon.gif" title="Some More Blocks Icon" />
  <h3>Seface Studios</h3>
  <p><a href="mailto:contact@sefacestudios.net">contact@sefacestudios.net</a> · <a title="X (FKA Twitter)" href="https://x.com/SefaceStudios">@SefaceStudios</a></p>
</div>