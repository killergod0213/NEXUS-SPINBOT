# GitHub Actions Build Setup

This Spinbot Mod project is configured to build automatically on GitHub using GitHub Actions.

## Quick Start

### 1. Initialize Git Repository (if not already done)
```powershell
cd C:\Users\trent.brown\AppData\Roaming\.minecraft\mods\spinbot-mod
git init
git add .
git commit -m "Initial commit: Spinbot mod"
```

### 2. Create GitHub Repository
1. Go to https://github.com/new
2. Create a new repository named `spinbot-mod`
3. Copy the repository URL

### 3. Push Code to GitHub
```powershell
git remote add origin https://github.com/YOUR_USERNAME/spinbot-mod.git
git branch -M main
git push -u origin main
```

### 4. Automatic Build
- Every time you push code to `main` or `master` branch, GitHub Actions will automatically build the mod
- The compiled JAR will be available in the "Artifacts" section of the workflow run

### 5. Download Your Mod
1. Go to your repository on GitHub
2. Click on "Actions" tab
3. Find the latest successful build
4. Download the `build-artifacts` zip file
5. Extract and find `spinbot-mod-1.0.0.jar` in the `libs` folder
6. Copy it to your Minecraft mods folder:
   ```
   C:\Users\trent.brown\AppData\Roaming\.minecraft\mods\
   ```

## Creating Releases

To create a release with automatic asset upload:

```powershell
git tag -a v1.0.0 -m "Release version 1.0.0"
git push origin v1.0.0
```

The JAR will automatically be attached to the GitHub Release.

## Workflow Features

- ✅ Automatically builds on every push
- ✅ Runs on Linux (no system restrictions)
- ✅ Compiles with Java 21
- ✅ Caches dependencies for faster builds
- ✅ Uploads artifacts automatically
- ✅ Creates releases with downloadable JARs

## Manual Workflow Trigger

You can also manually trigger a build:
1. Go to "Actions" tab on GitHub
2. Select "Build Spinbot Mod" workflow
3. Click "Run workflow"
4. Choose branch and click "Run"

No command prompt access needed! 🎉
