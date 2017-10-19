package org.qsari.effectopedia.utils;

import java.io.File;

public class FileNameophobe
	{
		public interface NamePattern
			{
				public boolean match(File file);
			}
		
		public static class ProvisionalFile implements NamePattern
			{
				public static final ProvisionalFile	PATTERN					= new ProvisionalFile();
				public static final String										PROVISIONAL	= "p";
				
				private ProvisionalFile()
					{
						
					}
				
				public boolean match(File file)
					{
						String name = file.getName();
						return name.startsWith(PROVISIONAL);
					}
			}
		
		public static class BigIDFile implements NamePattern
			{
				public BigIDFile(long maxID)
					{
						this.maxID = maxID;
					}
				
				public boolean match(File file)
					{
						String name = file.getName();
						try
							{
								int p = name.lastIndexOf(".");
								name = name.substring(0, p);
								Long fileID = Long.parseLong(name);
								return fileID > maxID;
							}
						catch (Exception e)
							{
								return false;
							}
					}
				
				public final long	maxID;
			}
		
		public static void deleteFiles(String path, NamePattern pattern)
			{
				File root = (new File(path));
				File[] files = root.listFiles();
				deletionErrors = files == null;
				if (!deletionErrors)
					deleteFiles(files, pattern);
			}
		
		protected static void deleteFiles(File[] files, NamePattern pattern)
			{
				for (File file : files)
					if (file.isDirectory())
						deleteFiles(file.listFiles(), pattern);
				for (File file : files)
					if (!file.isDirectory() && !file.isHidden() && (file.getName().toLowerCase().endsWith(".xml")) && (pattern.match(file)))
						try
							{
								file.delete();
							}
						catch (Exception e)
							{
								deletionErrors = true;
							}
				
			}
		
		public static boolean	deletionErrors	= false;
	}
