## Changelog
![Latest Release](https://img.shields.io/github/v/release/seface-studios/some-more-blocks?logo=github&logoColor=959da5&labelColor=353c43&color=0091c2&Current&label=Latest%20Release)

## 1.3.0 - August 30th
#### [Commit History](https://github.com/Seface-Studios/some-more-blocks/compare/1.21.4...1.21.5)

> [!NOTE]
> Most of the features are applied to all the SMB mod versions!

Special mention for the **NeoForge port** which will be constantly maintained along with the Fabric and Forge versions. All the features/changes below are implemented on this port too!

### Added
- **`[1.21.4+]` Pale Rose Bush:** A new plant that can be found in pale garden biome. Different from the Eyeblosoom, this plant will not close with daylight.
- **`[1.21.4+]` Pale Mushroom block family**⁽⁺⁴⁾
  - Pale Mushroom, can be found on caves below pale garden biome.
  - Pale Mushroom Colony, can be found on pale garden biome.
  - Wall Pale Mushroom Colony, can be found on pale garden biome attached on trees.
  - Tall Pale Mushroom Colony, can be found on pale garden biome.
- **`[1.21.5 only]` Snow Bush:** A new snowy plant variant that can be found in frozen rivers biome or converted in snowstorm.
- **`[1.21.5 only]` Snow Firefly Bush:** A new snowy plant variant that can be converted in snowstorm. Different of normal Firefly Bush, this bush will not emit Fireflies particle at night.
- **Redstone Shroomlight:** A new lamp-like block craftable with Shroomlight block and Redstone.
- **Redstone Sea Lantern:** A new lamp-like block craftable with Sea Lantern block and Redstone.
- **Carved Mushroom Stem:** Use a Axe on Mushroom Stem to transform into the Carved variation. This variation has a mushroom carved into it.
- **New polished basalt block family**⁽⁺¹⁶⁾
  - Polished Basalt Bricks and variants
  - Polished Basalt Tiles and variants
  - Corrupted Polished Basalt Bricks and variants
  - Chiseled Polished Basalt Bricks
  - Polished Basalt Pillar
- **Big Lily Pad generation:** The Big Lily Pad can now be found in mangrove and jungle biomes. Big Lily Pads is a 2x2 block that can be placed above water and ice blocks. This block can be rotated in 4 different directions.
- **Mushroom/Fungus Colonies generation:** The Brown and Red Mushroom Colonies can now be found in old growth biomes. The Crimson and Warped Fungus can be found in their respective biomes. There are 3 types of Mushroom/Fungus colonies, Short, Tall and Wall.
- **New plants**⁽⁺⁴⁾
  - **Reeds:** A new water plant that can grow with Cattails.
  - **Clover:** Can be found in most of forests and plains. 4 Clovers can ocuppy the same block space.
  - **Nether Clover:** Can be found in all nether biomes with exception of basalt Deltas.
  - **Tall Cactus:** This block can be found in deserts and badlands alongside the Tiny Cactus.
- **Shingles Stairs:** 17 new colored stairs.
- **Checkered Tiles:** 16 new colored blocks.
- **Game Rules**
  - **doSnowAccumulateOnPlants** - If false, the gamerule will prevent some plants to be turned into snowy variant (short grass, ferns etc) and snowy plants to be turned into normal.
    - `Devs Note` - We are aware of incompatibility with some season mods like [Fabric Seasons](https://www.curseforge.com/minecraft/mc-mods/fabric-seasons) and [Serene Seasons](https://www.curseforge.com/minecraft/mc-mods/serene-seasons). While we try to decide the better way to implement this compatibility, this game rule will fix the issue. Have any suggestion about this? Send an email to `contact@sefacestudios.net` with the subject `Snowy Plants Season Mods Compatibility`.
  - **`[1.21.5 only]` doLeafLitterDry** - Will not dry the Some More Blocks Leaf Litters into Vanilla Leaf Litter.
- **New advancements**⁽⁺⁴⁾
  - **With Our Power(ed) Combined!** - Have all Redstone Froglights in your inventory.
  - **`[1.21+ only]` A Grate Time Waste...** - Have all Some More Blocks Grates blocks in your inventory.
  - **Very Serious Dedication** - Use Netherite Bricks to craft an unreversible block and immediately regret it.
  - **`[1.21.4 only]` Next, We Are Going To Steal... The Moon!** - Use an Axe to carve a Stripped Pale Log (or Wood) in each lunar phase.
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
  - Luminous Flower is now more flower-like.
  - Red and Brown Mushroom Colonies reimagined.
  - Crimson and Warped Fungus Colonies reimagined.
- **World generation and distribution**
  - Short Snow Grass and Snow Fern can now be found naturally in snowy taiga and snowy plains.
  - Large Snow Fern can now be found naturally in snowy taiga.
  - Tiny Cactus will not generate in forests anymore. (Apologies to the 3 people who liked it previously)
    - Tiny Cactus can be found in deserts and badlands.
  - Cattails can now be placed and generated above gravel and sand if on water.
- **Beacon base blocks:** Iron, Gold, Diamond, Emerald and Netherite Bricks, Cut and Pillar can now be used as Beacon base block. (This is not applied for Cracked variations.)
- **Conduit activation:** Polished, Chiseled, Pillar, Tiles, Mossy Bricks and Smooth Prismarine variations can now be used as Conduit activator. (This is not applied for Cracked variations.)
- **Technical adjustments**
  - `tiny_cactus_placeable.json` was renamed to `cactus_plants_placeable.json`.
  - All the Biome Tags with `generates_*.json` format was moved to `generates/*.json` folder. This will affect how the id of this biome tags are; Check all the available Biome Tags [here](https://github.com/Seface-Studios/some-more-blocks/tree/1.21.4/common/src/main/generated/data/somemoreblocks/tags/worldgen/biome).
    - `generates_tiny_cactus.json` was renamed to `generates/cactus_plants.json`.
  - We are now fully using the Fabric Data Generation.
  - Custom Platform Service for better development.
  - **`[1.21.4 only]`** Bumped the minimum Fabric version from `0.110.5+1.21.4` to `0.117.0+1.21.4`.
  - **`[1.20.4 only]`** The Experimental Update 1.21 texture will not be applied automatically with `Update 1.21` datapack enabled in the world.
    - The Resource Pack stills built-in in the mod, you can enable manually on Resource Packs menu.
- **`[1.21.5 only] Leaf Litter Integrations`** - Since Minecraft 1.21.5 adds the Leaf Litter block, we did a little rework on our version. Now you can hold up to 32 leaves in one bucket and place 4 in the same spot. The _SMB_ Leaf Litters will dry over time until turn into the Vanilla Leaf Litter.

### Removed
- All the Parent Block Tags for all leaf litters type. The parent leaves are now set on Configured Feature file of the leaf litter.

### Fixed
- The swapped textures between Blue Concrete Bricks and Blue Concrete Tiles. [#11](https://github.com/Seface-Studios/some-more-blocks/issues/11)
- Using Bucket of Leaves on a relative block that does not have a full hitbox would remove that block. [#15](https://github.com/Seface-Studios/some-more-blocks/issues/15)

---
<div>
  <img align="right" height="64" width="64" src="https://raw.githubusercontent.com/Seface-Studios/some-more-blocks/refs/heads/main/.github/assets/animated_icon.gif" title="Some More Blocks Icon" />
  <h3>Seface Studios</h3>
  <p><a href="mailto:contact@sefacestudios.net">contact@sefacestudios.net</a> · <a title="X (FKA Twitter)" href="https://x.com/SefaceStudios">@SefaceStudios</a></p>
</div>