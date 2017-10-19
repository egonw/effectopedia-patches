package org.qsari.effectopedia.gui.util;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ClipboardUtilities implements Transferable
	{
		
		public static String getClipboard()
			{
				Transferable t = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
				try
					{
						if (t != null && t.isDataFlavorSupported(DataFlavor.stringFlavor))
							{
								String text = (String) t.getTransferData(DataFlavor.stringFlavor);
								return text;
							}
					}
				catch (UnsupportedFlavorException e)
					{
					}
				catch (IOException e)
					{
					}
				return null;
			}
		
		public static void setClipboard(String text)
			{
				StringSelection stringSelection = new StringSelection(text);
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			}
		
		public static String getHTMLClipboard()
			{
				Transferable t = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
				try
					{
						DataFlavor[] df = Toolkit.getDefaultToolkit().getSystemClipboard().getAvailableDataFlavors();
						//for (DataFlavor d : df)
						//	System.out.println(d.getMimeType());
						DataFlavor htmlFlavor = new DataFlavor("text/html; class=java.io.InputStream; charset=UTF-8");
						if (t != null && t.isDataFlavorSupported(htmlFlavor))
							{
								InputStream is = (InputStream) t.getTransferData(htmlFlavor);
								BufferedReader br = new BufferedReader(new InputStreamReader(is));
								StringBuilder lines = new StringBuilder();
								String line;
								while ((line = br.readLine()) != null)
									lines.append(line);
								return lines.toString();
							}
					}
				catch (UnsupportedFlavorException e)
					{
						e.printStackTrace();
					}
				catch (IOException e)
					{
						e.printStackTrace();
					}
				catch (ClassNotFoundException e)
					{
						e.printStackTrace();
					}
				return null;
			}
		
		public static void setMultiFlavorClipboard()
			{
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new ClipboardUtilities(), null);
			}
		
		public static boolean pasteDescriptionSections()
			{
				return (sectionTitles.size() > 0) && (sectionContents.size() == sectionTitles.size());
			}
		
		public static boolean parseDescriptionSections()
			{
				if (!parseDescriptionSectionsFromHTML())
					return parseDescriptionSectionsFromPlainText();
				return true;
			}
		
		public static void clear()
			{
				sectionTitles.clear();
				sectionContents.clear();
				sectionTitleStartPosition.clear();
				sectionTitleEndPosition.clear();
			}
		
		public static void addDescriptionSection(String title, String content)
			{
				sectionTitles.add(title);
				sectionContents.add(content);
			}
		
		public Object getTransferData(DataFlavor df) throws UnsupportedFlavorException, IOException
			{
				if (df.getMimeType().contains("text/html"))
					return new ByteArrayInputStream(generateHTMLSectionDescription().getBytes());
				else if (df.getMimeType().contains("text/plain"))
					return new ByteArrayInputStream(generatePlainTextSectionDescription().getBytes());
				else
					throw new UnsupportedFlavorException(df);
			}
		
		private String generateHTMLSectionDescription()
			{
				StringBuilder sb = new StringBuilder();
				sb.append("<html>\n");
				if (sectionContents.size() == sectionTitles.size())
					for (int i = 0; i < sectionTitles.size(); i++)
						{
							sb.append(openingTagsPrefix[1]);
							sb.append(openingTagsSuffix);
							sb.append(sectionTitles.get(i));
							sb.append(closingTags[1]);
							sb.append(sectionContents.get(i));
						}
				sb.append("\n</html>");
				return sb.toString();
			}
		
		private String generatePlainTextSectionDescription()
			{
				StringBuilder sb = new StringBuilder();
				if (sectionContents.size() == sectionTitles.size())
					for (int i = 0; i < sectionTitles.size(); i++)
						{
							sb.append(sectionTitles.get(i));
							sb.append("\n\n");
							sb.append(sectionContents.get(i));
							sb.append("\n\n");
						}
				return sb.toString();
			}
		
		private static boolean parseDescriptionSectionsFromHTML()
			{
				String html = getHTMLClipboard();
				if (html == null)
					return false;
				clear();
				detectTitles(html);
				extractSectionsContent(html);
				return (sectionTitles.size() > 0) && (sectionContents.size() == sectionTitles.size());
			}
		
		private static boolean parseDescriptionSectionsFromPlainText()
			{
				String text = getClipboard();
				if (text == null)
					return false;
				clear();
				detectTitlesInText(text);
				extractSectionsContentFromPlainText(text);
				return (sectionTitles.size() > 0) && (sectionContents.size() == sectionTitles.size());
			}
		
		private static void detectTitles(String html)
			{
				int tagRangeLo = 0;
				int tagRangeHi = 5;
				if (html.contains(MSOffice))
					{
						tagRangeLo = 6;
						tagRangeHi = 7;
					}
				int processed = 0;
				int pos = Integer.MAX_VALUE;
				
				do
					{
						int index = -1;
						pos = Integer.MAX_VALUE;
						for (int i = tagRangeLo; i <= tagRangeHi; i++)
							{
								int p = html.indexOf(openingTagsPrefix[i], processed);
								if ((p != -1) && (p < pos))
									{
										pos = p;
										index = i;
									}
							}
						if (pos < Integer.MAX_VALUE)
							{
								int p = html.indexOf(openingTagsSuffix, pos);
								if (p != -1)
									{
										int q = html.indexOf(closingTags[index], p);
										if (q != -1)
											{
												processed = q + closingTags[index].length();
												sectionTitles.add(stripTags(html.substring(p + openingTagsSuffix.length(), q)));
												sectionTitleStartPosition.add(pos);
												sectionTitleEndPosition.add(processed);
											}
									}
							}
					}
				while (pos < Integer.MAX_VALUE);
			}
		
		private static void extractSectionsContent(String html)
			{
				int numberOfSections = sectionTitles.size();
				for (int section = 0; section <= numberOfSections - 2; section++)
					sectionContents.add(stripTags(html.substring(sectionTitleEndPosition.get(section), sectionTitleStartPosition.get(section + 1))));
				if (sectionTitles.size() > 0)
					sectionContents.add(stripTags(html.substring(sectionTitleEndPosition.get(numberOfSections - 1), html.length())));
			}
		
		private static String stripTags(String html)
			{
				//System.out.println("\n\n original:\n\n" + html);
				//System.out.println(html);
				String text = html.replaceAll("<br>", "\n").replaceAll("</br>", "\n").replaceAll("</p>", "\n");
				//System.out.println("\n\n introduction of new lines:\n\n" + html);
				//System.out.println("\n\n\n tags deleted:\n\n" + text.replaceAll("\\<.*?>", ""));
				return text.replaceAll("\\<.*?>", "");
			}
		
		private static void detectTitlesInText(String text)
			{
				int processed = 0;
				int p = text.indexOf(titleSeparator, processed);
				if (p != -1)
					{
						sectionTitles.add(text.substring(0, p));
						sectionTitleStartPosition.add(0);
						processed = p + titleSeparator.length();
						sectionTitleEndPosition.add(processed);
					}
				p = text.indexOf(titleSeparator, processed);
				while (p != -1)
					{
						p += titleSeparator.length();
						int q = text.indexOf(titleSeparator, p + titleSeparator.length());
						if (q != -1)
							{
								sectionTitles.add(text.substring(p, q));
								sectionTitleStartPosition.add(p);
								processed = q + titleSeparator.length();
								sectionTitleEndPosition.add(processed);
							}
						else
							processed = text.length();
						p = text.indexOf(titleSeparator, processed);
					}
			}
		
		private static void extractSectionsContentFromPlainText(String text)
			{
				int numberOfSections = sectionTitles.size();
				for (int section = 0; section <= numberOfSections - 2; section++)
					sectionContents.add(text.substring(sectionTitleEndPosition.get(section), sectionTitleStartPosition.get(section + 1)));
				if (sectionTitles.size() > 0)
					sectionContents.add(text.substring(sectionTitleEndPosition.get(numberOfSections - 1), text.length()));
			}
		
		public boolean isDataFlavorSupported(DataFlavor df)
			{
				if (df.getMimeType().contains("text/html") || df.getMimeType().contains("text/plain"))
					return true;
				else
					return false;
			}
		
		public DataFlavor[] getTransferDataFlavors()
			{
				return flavors;
			}
		
		public static final ArrayList<String>			sectionTitles													= new ArrayList<String>();
		public static final ArrayList<String>			sectionContents											= new ArrayList<String>();
		
		private static final ArrayList<Integer>	sectionTitleStartPosition	= new ArrayList<Integer>();
		private static final ArrayList<Integer>	sectionTitleEndPosition			= new ArrayList<Integer>();
		private static final String													MSOffice																		= "Microsoft Word";
		private static final String[]											openingTagsPrefix									= new String[]
																																																																					{ "<h1", "<h2", "<h3", "<H1", "<H2", "<H3", "<p class=MsoTitle", "<p class=MsoSubtitle" };
		private static final String													openingTagsSuffix									= ">";
		private static final String													titleSeparator												= "\n\n";
		private static final String[]											closingTags															= new String[]
																																																																					{ "</h1>", "</h2>", "</h3>", "</H1>", "</H2>", "</H3>", "</p>", "</p>" };
		// Plain favor
		private static final DataFlavor									PLAIN_FLAVOR														= new DataFlavor("text/plain; charset=UTF-8", "Plain Flavor");
		// RTF flavor
		private static final DataFlavor									HTML_FLAVOR															= new DataFlavor("text/html; charset=UTF-8", "HTML Formatted Text");
		// Array of data flavors
		private static final DataFlavor									flavors[]																	=
																																																																					{ HTML_FLAVOR, PLAIN_FLAVOR };
	}
