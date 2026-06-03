# Spinbot Mod for Minecraft 1.21.10 (Fabric)

A feature-rich spinbot mod with menu UI, hotkey controls, and RGB FOV circle visualization.

## Features
- **Spinbot Toggle**: Automatically rotates your character
- **Menu System**: User-friendly GUI for mod controls
- **Hotkey Bindings**:
  - **R Key**: Toggle spinbot on/off
  - **M Key**: Open spinbot menu
- **Speed Control**: Adjust spin speed via slider in menu
- **RGB FOV Circle**: Visual feedback with rainbow-colored field of view circle

## Installation

### Prerequisites
- Java 21+ installed
- Minecraft 1.21.10 with Fabric Loader

### Build Instructions

1. Open PowerShell/Terminal in the spinbot-mod directory
2. Run the following command to build:
   ```
   gradlew.bat build
   ```
   (On Linux/Mac, use `./gradlew build`)

3. The compiled mod JAR will be in `build/libs/spinbot-mod-1.0.0.jar`

4. Copy the JAR file to your Minecraft mods folder:
   ```
   C:\Users\[YourUsername]\AppData\Roaming\.minecraft\mods\
   ```

## Usage

1. Launch Minecraft with Fabric Loader
2. Load into a world
3. Press **M** to open the Spinbot Menu
4. Enable spinbot or press **R** to toggle it on/off
5. Use the speed slider to adjust rotation speed
6. The RGB FOV circle will be visible when spinbot is active

## Configuration

- **Speed**: Adjustable from 0-20 degrees per tick
- **RGB Circle**: Visual indicator of FOV when spinbot is enabled

## Development

### Project Structure
```
spinbot-mod/
├── src/main/java/com/spinbot/mod/
│   ├── SpinbotMod.java              # Main mod class
│   ├── SpinbotModClient.java        # Client initializer
│   ├── features/
│   │   ├── SpinbotFeature.java      # Core spinbot logic
│   │   ├── KeyBindManager.java      # Hotkey management
│   │   └── TickHandler.java         # Game tick handler
│   └── gui/
│       ├── SpinbotMenu.java         # Menu screen
│       └── RenderManager.java       # RGB circle rendering
├── build.gradle                     # Gradle build config
├── gradle.properties                # Gradle properties
└── settings.gradle                  # Gradle settings
```

### Modifying Features

- **Change hotkeys**: Edit `KeyBindManager.java`
- **Adjust spin speed**: Modify `SpinbotFeature.java`
- **Customize menu**: Edit `SpinbotMenu.java`
- **RGB circle style**: Modify `RenderManager.java`

## License

MIT License - Feel free to modify and distribute!
