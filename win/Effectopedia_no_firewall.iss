[Files]
Source: "D:\JAVA\org.qsari.effectopedia\win\Effectopedia.exe"; DestDir: "{app}"; DestName: "Effectopedia.exe"; Flags: 32bit; Components: Application Documentation; Tasks: DesktopIcon; Permissions: admins-full
Source: "D:\JAVA\org.qsari.effectopedia\win\Effectopedia_Help.pdf"; DestDir: "{app}"; Components: Documentation

[Setup]
AppName=Effectopedia
AppVersion=0.9.28
AppCopyright=International QSAR Foundation GPL v3.0
DefaultDirName={pf}\Effectopedia
LicenseFile=D:\JAVA\org.qsari.effectopedia\win\gpl-3.0.txt
AppPublisher=International QSAR Foundation
AppPublisherURL=http://effectopedia.org/
AppSupportURL=http://sourceforge.net/p/effectopedia/discussion/
AppUpdatesURL=http://sourceforge.net/projects/effectopedia/files/
AppContact=Hristo Aladjov
AppSupportPhone=+35928626515,+19174289557
AppReadmeFile=readme.txt
VersionInfoVersion=0.9.28
VersionInfoCompany=International QSAR Foundation
VersionInfoDescription=Online encyclopedia for adverse outcome pathways
VersionInfoProductTextVersion=0.9.28 Alpha
OutputBaseFilename=e-setup
AppId={{980347D9-783B-4319-BEF4-C2622E3FA59E}
DefaultGroupName=Effectopedia

[Icons]
Name: "{group}\Effectopedia"; Filename: "{app}\Effectopedia.exe"; WorkingDir: "{tmp}"; IconFilename: "{app}\Effectopedia.exe"; Components: Application Documentation
Name: "{group}\Uninstaller"; Filename: "{uninstallexe}"
Name: "{group}\Manual"; Filename: "{app}\Effectopedia_Help.pdf"; Components: Documentation
Name: "{commondesktop}\Effectopedia"; Filename: "{app}\Effectopedia.exe"; IconFilename: "{app}\Effectopedia.exe"; Tasks: DesktopIcon

[Types]
Name: "Full"; Description: "Application and Documentation"
Name: "Custom"; Description: "Custom installation"; Flags: iscustom

[Tasks]
Name: "DesktopIcon"; Description: "Create a desktop icon"; GroupDescription: "Additional icons:"; Components: Application

[Components]
Name: "Documentation"; Description: "Manual updated as of version 0.9.1"; Types: Full
Name: "Application"; Description: "Effectopedia Appliation"; Types: Full Custom


[Registry]
