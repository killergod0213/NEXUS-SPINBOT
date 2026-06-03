@echo off
REM Initialize Git repository and push to GitHub
REM This script helps you set up GitHub Actions build for Spinbot Mod

echo ====================================
echo Spinbot Mod - GitHub Setup Script
echo ====================================
echo.

REM Check if Git is installed
where git >nul 2>nul
if %ERRORLEVEL% NEQ 0 (
    echo ERROR: Git is not installed or not in PATH
    echo Please install Git from: https://git-scm.com/download/win
    pause
    exit /b 1
)

echo Step 1: Initializing Git repository...
git init
if %ERRORLEVEL% NEQ 0 goto error

git config user.name "Spinbot Developer"
git config user.email "dev@spinbot.local"

echo Step 2: Adding files...
git add .
if %ERRORLEVEL% NEQ 0 goto error

git commit -m "Initial commit: Spinbot mod for Minecraft 1.21.10"
if %ERRORLEVEL% NEQ 0 goto error

echo.
echo ====================================
echo NEXT STEPS:
echo ====================================
echo 1. Go to https://github.com/new
echo 2. Create a new repository named 'spinbot-mod'
echo 3. Copy the repository HTTPS URL
echo 4. Run this command:
echo.
echo    git remote add origin [YOUR_REPO_URL]
echo    git branch -M main
echo    git push -u origin main
echo.
echo 5. Go to your repository Actions tab to watch the build
echo.
echo After pushing, GitHub Actions will automatically:
echo   - Build your mod
echo   - Create artifacts for download
echo   - Make it available in releases
echo.
echo ====================================
pause
exit /b 0

:error
echo ERROR: An error occurred during Git setup
pause
exit /b 1
