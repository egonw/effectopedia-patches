The user interface of Effectopedia uses Java Swing which might not scale correctly on some high DPI displays. To fix this problem for all Java applications using Swing in Windows you will need administrative privileges. Please follow the instructions below:
	1) Download the three files available in this directory to a location of your choice.
	2) Right click on the prefer_external_manifest.reg file and select Merge from the menu
	3) Confirm that you want to make the changes to the registry
	4) Find the location of your Java run-time environment. 
	  a) Open command prompt and type:
		java -verbose 
	  b) The first line of the output will contain the full path to your java.exe and javaw.exe files
	5) Open the bin directory of your Java Run Time environment 
	6) Copy the two manifest files (java.exe.manifest and javaw.exe.manifest) to this directory 
Next time you start Effectopedia or any other application using Swing it should be properly scaled. 