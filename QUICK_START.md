# Spinbot Mod - Complete Setup Guide

Your Spinbot mod is ready! Here's how to build and use it:

## ✅ What's Included

Your mod has:
- **Spinbot Core**: Auto-spinning character rotation
- **Menu System**: Press M to open GUI
- **Hotkeys**: R to toggle spinbot on/off
- **RGB FOV Circle**: Visual indicator
- **GitHub Actions**: Cloud-based building (no command prompt needed!)

## 🚀 Quick Start (GitHub Actions Method)

### Option A: Using Git Bash/Command Line
1. Open Git Bash in the mod folder
2. Run: `./setup-github.bat`
3. Follow the prompts to push to GitHub
4. Build happens automatically in the cloud ☁️

### Option B: Manual Steps
1. Create a new repository at https://github.com/new (name: `spinbot-mod`)
2. In the mod folder, initialize Git:
   ```bash
   git init
   git add .
   git commit -m "Spinbot mod"
   git remote add origin YOUR_REPO_URL
   git push -u origin main
   ```
3. GitHub Actions builds automatically
4. Download the JAR from the Actions tab

## 📦 Installing the Mod

Once built:
1. Go to your GitHub repo → Actions tab
2. Click the latest successful build
3. Download `build-artifacts`
4. Extract the ZIP file
5. Find `spinbot-mod-1.0.0.jar`
6. Copy to: `C:\Users\trent.brown\AppData\Roaming\.minecraft\mods\`
7. Launch Minecraft with Fabric Loader

## 🎮 Using the Mod

In-game:
- **M Key**: Open Spinbot Menu
- **R Key**: Toggle spinbot on/off
- Use menu to adjust spin speed (0-20 degrees/tick)
- RGB circle appears when enabled

## 📝 Project Structure

```
spinbot-mod/
├── src/main/java/com/spinbot/mod/
│   ├── SpinbotMod.java              # Main class
│   ├── SpinbotModClient.java        # Client init
│   ├── features/
│   │   ├── SpinbotFeature.java      # Core logic
│   │   ├── KeyBindManager.java      # Hotkeys (R, M)
│   │   └── TickHandler.java         # Rotation updater
│   └── gui/
│       ├── SpinbotMenu.java         # Menu screen
│       └── RenderManager.java       # RGB circle
├── build.gradle                     # Build config
├── gradle.properties                # Version info
└── .github/workflows/build.yml      # Auto-build setup
```

## 🔧 Building Locally (if restrictions are lifted)

If your admin enables command prompt:
```powershell
cd C:\Users\trent.brown\AppData\Roaming\.minecraft\mods\spinbot-mod
.\gradlew.bat build
```

JAR will be in `build\libs\spinbot-mod-1.0.0.jar`

## 📚 Customization

Want to change things?
- **Hotkeys**: Edit `KeyBindManager.java` (R and M keys)
- **Spin Speed**: Modify `SpinbotFeature.java`
- **Menu UI**: Customize `SpinbotMenu.java`
- **RGB Circle**: Adjust `RenderManager.java`

Then push to GitHub and it auto-builds! 🚀

## ❓ Troubleshooting

**Build failed on GitHub?**
- Check the workflow log: Actions tab → click run → scroll down

**JAR not downloading?**
- Make sure build succeeded (green checkmark on Actions)
- Download `build-artifacts` not the workflow itself

**Mod not loading?**
- Verify Java 21+ is installed in Minecraft launcher
- Ensure Fabric Loader is installed
- Check Minecraft logs for errors

---

**Need help?** Check the individual class files - they're well-commented! 📖
