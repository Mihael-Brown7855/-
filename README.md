# Dragon Mod

Fabric mod for Minecraft 1.20.1 that adds a hostile fire dragon.

## Ready-to-use jar

If you only want to play the mod, download `dist/dragonmod-1.0.0.jar` and put it into your Minecraft `mods` folder.

## Features

- Fire Dragon entity with high health, armor, melee damage, fire immunity, flame particles, and dragon sounds.
- Fire Dragon Spawn Egg in a custom "Dragon Mod" creative tab.
- Dragon Scale item dropped by player-killed dragons.
- Basic client model, renderer, texture, item model, and loot table.

## Build

Use Java 17 or newer, then run:

```bash
./gradlew build
```

The built mod jar will be created under `build/libs/`.

## Install

1. Install Fabric Loader for Minecraft 1.20.1.
2. Install Fabric API for Minecraft 1.20.1.
3. Copy the generated Dragon Mod jar into the Minecraft `mods` folder.
