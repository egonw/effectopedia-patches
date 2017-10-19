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
DisableDirPage=yes

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
Name: "FirewallExceptionRules"; Description: "Firewall exception rules"; Components: Application Documentation

[Components]
Name: "Documentation"; Description: "Manual updated as of version 0.9.1"; Types: Full
Name: "Application"; Description: "Effectopedia Appliation"; Types: Full Custom


[Registry]
Root: "HKLM"; Subkey: "SYSTEM\CurrentControlSet\Services\SharedAccess\Parameters\FirewallPolicy\FirewallRules"; ValueType: string; ValueName: "{{511177C6-6B1E-487D-A197-55164191E25E}"; ValueData: "v2.0|Action=Allow|Active=TRUE|Dir=In|Protocol=6|Profile=Public|App={app}\Effectopedia.exe|Name=Effectopedia|Edge=FALSE|"; Flags: dontcreatekey uninsdeletevalue; MinVersion: 6.0,6.0; OnlyBelowVersion: 6.1,6.1; Tasks: FirewallExceptionRules
Root: "HKLM"; Subkey: "SYSTEM\CurrentControlSet\Services\SharedAccess\Parameters\FirewallPolicy\FirewallRules"; ValueType: string; ValueName: "{{8626057C-C2D5-41B0-BC4E-A7D1D6A5149F}"; ValueData: "v2.0|Action=Allow|Active=TRUE|Dir=In|Protocol=17|Profile=Public|App={app}\Effectopedia.exe|Name=Effectopedia|Edge=FALSE|"; Flags: dontcreatekey uninsdeletevalue; MinVersion: 6.0,6.0; OnlyBelowVersion: 6.1,6.1; Tasks: FirewallExceptionRules
Root: "HKLM"; Subkey: "SYSTEM\ControlSet001\Services\SharedAccess\Parameters\FirewallPolicy\FirewallRules"; ValueType: string; ValueName: "{{511177C6-6B1E-487D-A197-55164191E25E}"; ValueData: "v2.0|Action=Allow|Active=TRUE|Dir=In|Protocol=6|Profile=Public|App={app}\Effectopedia.exe|Name=Effectopedia|Edge=FALSE|"; Flags: dontcreatekey uninsdeletevalue; MinVersion: 6.0,6.0; OnlyBelowVersion: 6.1,6.1
Root: "HKLM"; Subkey: "SYSTEM\ControlSet001\Services\SharedAccess\Parameters\FirewallPolicy\FirewallRules"; ValueType: string; ValueName: "{{8626057C-C2D5-41B0-BC4E-A7D1D6A5149F}"; ValueData: "v2.0|Action=Allow|Active=TRUE|Dir=In|Protocol=17|Profile=Public|App={app}\Effectopedia.exe|Name=Effectopedia|Edge=FALSE|"; Flags: dontcreatekey uninsdeletevalue; MinVersion: 6.0,6.0; OnlyBelowVersion: 6.1,6.1
Root: "HKLM"; Subkey: "SYSTEM\CurrentControlSet\Services\SharedAccess\Parameters\FirewallPolicy\FirewallRules"; ValueType: string; ValueName: "{{52503BA3-AC06-45E4-B368-511215BFB0A9}"; ValueData: "v2.10|Action=Allow|Active=TRUE|Dir=In|Protocol=6|Profile=Public|App={app}\Effectopedia.exe|Name=Effectopedia|"; Flags: dontcreatekey uninsdeletevalue; MinVersion: 6.1,6.1; Tasks: FirewallExceptionRules
Root: "HKLM"; Subkey: "SYSTEM\CurrentControlSet\Services\SharedAccess\Parameters\FirewallPolicy\FirewallRules"; ValueType: string; ValueName: "{{59778DD4-9ADD-498C-8AA1-E56E067FF75C}"; ValueData: "v2.10|Action=Allow|Active=TRUE|Dir=In|Protocol=17|Profile=Public|App={app}\Effectopedia.exe|Name=Effectopedia|"; Flags: dontcreatekey uninsdeletevalue; MinVersion: 6.1,6.1; Tasks: FirewallExceptionRules
Root: "HKLM"; Subkey: "SYSTEM\CurrentControlSet\Services\SharedAccess\Parameters\FirewallPolicy\FirewallRules"; ValueType: string; ValueName: "{{5328AFFC-2A68-46C4-8255-811F8A97B5CB}"; ValueData: "v2.10|Action=Allow|Active=FALSE|Dir=In|Protocol=6|Profile=Domain|App={app}\Effectopedia.exe|Name=Effectopedia|"; Flags: dontcreatekey uninsdeletevalue; MinVersion: 6.1,6.1; Tasks: FirewallExceptionRules
Root: "HKLM"; Subkey: "SYSTEM\CurrentControlSet\Services\SharedAccess\Parameters\FirewallPolicy\FirewallRules"; ValueType: string; ValueName: "{{7780929A-00B1-4C7F-B0DC-8E67B03F6B5B}"; ValueData: "v2.10|Action=Allow|Active=FALSE|Dir=In|Protocol=17|Profile=Domain|App={app}\Effectopedia.exe|Name=Effectopedia|"; Flags: dontcreatekey uninsdeletevalue; MinVersion: 6.1,6.1; Tasks: FirewallExceptionRules
Root: "HKLM"; Subkey: "SYSTEM\CurrentControlSet\Services\SharedAccess\Parameters\FirewallPolicy\FirewallRules"; ValueType: string; ValueName: "{{09C1985B-87AC-462B-8CB8-03E54EEFFFF4}"; ValueData: "v2.10|Action=Allow|Active=TRUE|Dir=In|Protocol=6|Profile=Private|Profile=Public|App={app}\Effectopedia.exe|Name=Effectopedia|"; Flags: dontcreatekey uninsdeletevalue; MinVersion: 6.1,6.1; Tasks: FirewallExceptionRules
Root: "HKLM"; Subkey: "SYSTEM\CurrentControlSet\Services\SharedAccess\Parameters\FirewallPolicy\FirewallRules"; ValueType: string; ValueName: "{{C71D8241-4C37-4E4D-B8AD-9C242158D258}"; ValueData: "v2.10|Action=Allow|Active=TRUE|Dir=In|Protocol=17|Profile=Private|Profile=Public|App={app}\Effectopedia.exe|Name=Effectopedia|"; Flags: dontcreatekey uninsdeletevalue; MinVersion: 6.1,6.1; Tasks: FirewallExceptionRules
Root: "HKLM"; Subkey: "SYSTEM\CurrentControlSet\Services\SharedAccess\Parameters\FirewallPolicy\FirewallRules"; ValueType: string; ValueName: "{{BAA73750-A6BB-4829-A0EB-30AD5D5565FB}"; ValueData: "v2.10|Action=Allow|Active=FALSE|Dir=In|Protocol=6|Profile=Domain|App={app}\Effectopedia.exe|Name=Effectopedia|"; Flags: dontcreatekey uninsdeletevalue; MinVersion: 6.1,6.1; Tasks: FirewallExceptionRules
Root: "HKLM"; Subkey: "SYSTEM\CurrentControlSet\Services\SharedAccess\Parameters\FirewallPolicy\FirewallRules"; ValueType: string; ValueName: "{{E7806D97-C07F-420A-BDF6-DAB6173AA365}"; ValueData: "v2.10|Action=Allow|Active=FALSE|Dir=In|Protocol=17|Profile=Domain|App={app}\Effectopedia.exe|Name=Effectopedia|"; Flags: dontcreatekey uninsdeletevalue; MinVersion: 6.1,6.1; Tasks: FirewallExceptionRules
Root: "HKLM"; Subkey: "SYSTEM\ControlSet001\services\SharedAccess\Parameters\FirewallPolicy\FirewallRules"; ValueType: string; ValueName: "{{52503BA3-AC06-45E4-B368-511215BFB0A9}"; ValueData: "v2.10|Action=Allow|Active=TRUE|Dir=In|Protocol=6|Profile=Public|App={app}\Effectopedia.exe|Name=Effectopedia|"; Flags: dontcreatekey uninsdeletevalue; MinVersion: 6.1,6.1; Tasks: FirewallExceptionRules
Root: "HKLM"; Subkey: "SYSTEM\ControlSet001\services\SharedAccess\Parameters\FirewallPolicy\FirewallRules"; ValueType: string; ValueName: "{{59778DD4-9ADD-498C-8AA1-E56E067FF75C}"; ValueData: "v2.10|Action=Allow|Active=TRUE|Dir=In|Protocol=17|Profile=Public|App={app}\Effectopedia.exe|Name=Effectopedia|"; Flags: dontcreatekey uninsdeletevalue; MinVersion: 6.1,6.1; Tasks: FirewallExceptionRules
Root: "HKLM"; Subkey: "SYSTEM\ControlSet001\services\SharedAccess\Parameters\FirewallPolicy\FirewallRules"; ValueType: string; ValueName: "{{5328AFFC-2A68-46C4-8255-811F8A97B5CB}"; ValueData: "v2.10|Action=Allow|Active=FALSE|Dir=In|Protocol=6|Profile=Domain|App={app}\Effectopedia.exe|Name=Effectopedia|"; Flags: dontcreatekey uninsdeletevalue; MinVersion: 6.1,6.1; Tasks: FirewallExceptionRules
Root: "HKLM"; Subkey: "SYSTEM\ControlSet001\services\SharedAccess\Parameters\FirewallPolicy\FirewallRules"; ValueType: string; ValueName: "{{7780929A-00B1-4C7F-B0DC-8E67B03F6B5B}"; ValueData: "v2.10|Action=Allow|Active=FALSE|Dir=In|Protocol=17|Profile=Domain|App={app}\Effectopedia.exe|Name=Effectopedia|"; Flags: dontcreatekey uninsdeletevalue; MinVersion: 6.1,6.1; Tasks: FirewallExceptionRules
Root: "HKLM"; Subkey: "SYSTEM\ControlSet001\services\SharedAccess\Parameters\FirewallPolicy\FirewallRules"; ValueType: string; ValueName: "{{09C1985B-87AC-462B-8CB8-03E54EEFFFF4}"; ValueData: "v2.10|Action=Allow|Active=TRUE|Dir=In|Protocol=6|Profile=Private|Profile=Public|App={app}\Effectopedia.exe|Name=Effectopedia|"; Flags: dontcreatekey uninsdeletevalue; MinVersion: 6.1,6.1; Tasks: FirewallExceptionRules
Root: "HKLM"; Subkey: "SYSTEM\ControlSet001\services\SharedAccess\Parameters\FirewallPolicy\FirewallRules"; ValueType: string; ValueName: "{{C71D8241-4C37-4E4D-B8AD-9C242158D258}"; ValueData: "v2.10|Action=Allow|Active=TRUE|Dir=In|Protocol=17|Profile=Private|Profile=Public|App={app}\Effectopedia.exe|Name=Effectopedia|"; Flags: dontcreatekey uninsdeletevalue; MinVersion: 6.1,6.1; Tasks: FirewallExceptionRules
Root: "HKLM"; Subkey: "SYSTEM\ControlSet001\services\SharedAccess\Parameters\FirewallPolicy\FirewallRules"; ValueType: string; ValueName: "{{BAA73750-A6BB-4829-A0EB-30AD5D5565FB}"; ValueData: "v2.10|Action=Allow|Active=FALSE|Dir=In|Protocol=6|Profile=Domain|App={app}\Effectopedia.exe|Name=Effectopedia|"; Flags: dontcreatekey uninsdeletevalue; MinVersion: 6.1,6.1; Tasks: FirewallExceptionRules
Root: "HKLM"; Subkey: "SYSTEM\ControlSet001\services\SharedAccess\Parameters\FirewallPolicy\FirewallRules"; ValueType: string; ValueName: "{{E7806D97-C07F-420A-BDF6-DAB6173AA365}"; ValueData: "v2.10|Action=Allow|Active=FALSE|Dir=In|Protocol=17|Profile=Domain|App={app}\Effectopedia.exe|Name=Effectopedia|"; Flags: dontcreatekey uninsdeletevalue; MinVersion: 6.1,6.1; Tasks: FirewallExceptionRules
