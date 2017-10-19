package org.qsari.effectopedia.data.formats;

public class FormatFlavour
	{
		public FormatFlavour(String defaultExtension, String description, int flavour)
			{
				this.defaultExtension = defaultExtension;
				this.description = description;
				this.flavour = flavour;
			}
		
		public final int												flavour;
		public final String									defaultExtension;
		public final String									description;
		
		public static final int					ALL									= -1;
		public static final int					UNDEFINED			= 0;
		public static final int					SINGLE_FILE	= 1;
		public static final int					MULTI_FILE		= 2;
		
		public static FormatFlavour	XML									= new FormatFlavour("xml", "Adverse Outcome Pathway Multi File Format", MULTI_FILE);
		public static FormatFlavour	AOP									= new FormatFlavour("aop", "Adverse Outcome Pathway File Format", SINGLE_FILE);
		public static FormatFlavour	AOPZ								= new FormatFlavour("aopz", "Zipped Adverse Outcome Pathway File Format", SINGLE_FILE);
		public static FormatFlavour	AOPZM							= new FormatFlavour("aopz", "Zipped Adverse Outcome Pathway File Format", MULTI_FILE);
		public static FormatFlavour	JSON								= new FormatFlavour("json", "JSON Single file representaion of Effectopedia generated AOPs", SINGLE_FILE);
		public static FormatFlavour	HTML								= new FormatFlavour("html", "HTML AOP file format", SINGLE_FILE);
	}
