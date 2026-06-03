# GitHub Setup Script for Spinbot Mod
# Run this script to initialize Git and prepare for GitHub Actions

Write-Host "====================================" -ForegroundColor Cyan
Write-Host "Spinbot Mod - GitHub Setup Script" -ForegroundColor Cyan
Write-Host "====================================" -ForegroundColor Cyan
Write-Host ""

# Check if Git is installed
try {
    $gitVersion = git --version
    Write-Host "Git found: $gitVersion" -ForegroundColor Green
}
catch {
    Write-Host "ERROR: Git is not installed or not in PATH" -ForegroundColor Red
    Write-Host "Download from: https://git-scm.com/download/win" -ForegroundColor Yellow
    Read-Host "Press Enter to exit"
    exit 1
}

Write-Host ""
Write-Host "Step 1: Initializing Git repository..." -ForegroundColor Yellow

try {
    git init
    git config user.name "Spinbot Developer"
    git config user.email "dev@spinbot.local"
    Write-Host "Git initialized" -ForegroundColor Green
}
catch {
    Write-Host "Error initializing Git" -ForegroundColor Red
    exit 1
}

Write-Host ""
Write-Host "Step 2: Adding files to staging..." -ForegroundColor Yellow

try {
    git add .
    git commit -m "Initial commit: Spinbot mod for Minecraft 1.21.10"
    Write-Host "Files committed" -ForegroundColor Green
}
catch {
    Write-Host "Error committing files" -ForegroundColor Red
    exit 1
}

Write-Host ""
Write-Host "====================================" -ForegroundColor Cyan
Write-Host "NEXT STEPS:" -ForegroundColor Cyan
Write-Host "====================================" -ForegroundColor Cyan
Write-Host ""
Write-Host "1. Create a GitHub repository:" -ForegroundColor White
Write-Host "   - Go to https://github.com/new" -ForegroundColor Gray
Write-Host "   - Name it 'spinbot-mod'" -ForegroundColor Gray
Write-Host "   - Copy the HTTPS URL" -ForegroundColor Gray
Write-Host ""
Write-Host "2. Run these commands (replace with your URL):" -ForegroundColor White
Write-Host "   git remote add origin [YOUR_REPO_URL]" -ForegroundColor Gray
Write-Host "   git branch -M main" -ForegroundColor Gray
Write-Host "   git push -u origin main" -ForegroundColor Gray
Write-Host ""
Write-Host "3. GitHub Actions will automatically:" -ForegroundColor White
Write-Host "   - Build your mod" -ForegroundColor Gray
Write-Host "   - Create downloadable artifacts" -ForegroundColor Gray
Write-Host "   - Attach JARs to releases" -ForegroundColor Gray
Write-Host ""
Write-Host "4. Download your mod:" -ForegroundColor White
Write-Host "   - GitHub Actions tab > latest build > build-artifacts" -ForegroundColor Gray
Write-Host "   - Extract and copy JAR to mods folder" -ForegroundColor Gray
Write-Host ""
Write-Host "====================================" -ForegroundColor Cyan
Write-Host "Ready! Press any key to continue..." -ForegroundColor Cyan
Read-Host ""
