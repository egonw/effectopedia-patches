@echo off
cls
echo The Explorer process must be killed to delete the Icon DB. 
echo Please SAVE ALL OPEN WORK FIRST
pause
taskkill /IM explorer.exe /F 
echo Attempting to delete Icon DB...
If exist %userprofile%\AppData\Local\IconCache.db goto delID
echo Previous Icon DB not found...trying to build a new one
goto :main

:delID
cd /d %userprofile%\AppData\Local
del IconCache.db /a
pause
echo Icon DB successfully deleted
goto main

:main
echo Windows 7 must be restarted to rebuild the Icon DB. 
echo Restart now? (Y/N):
set /p choice=
If %choice% == y goto end
echo Shutdown aborted...please close this window
explorer.exe

:end
shutdown /r /t 0
exit