package org.qsari.effectopedia.utils;

import java.util.Arrays;

public class HexCharByteConverter
	{
		static private final int				HALFASCII	= 128;
		static private final byte   INVALIDHEXSYMBOL = -1;
		static private final char[]	HEX_CHARS	= "0123456789ABCDEF".toCharArray();
		static private final byte[]	HEX_BYTES	= new byte[HALFASCII];
		
		static
			{
				Arrays.fill(HEX_BYTES, INVALIDHEXSYMBOL);
				for (int i = '9'; i >= '0'; i--)
					HEX_BYTES[i] = (byte) (i - '0');
				for (int i = 'F'; i >= 'A'; i--)
					HEX_BYTES[i] = (byte) (i - 'A' + 10);
				for (int i = 'f'; i >= 'a'; i--)
					HEX_BYTES[i] = (byte) (i - 'a' + 10);
			}
		
		public static char[] convert(byte[] bytes)
			{
				if (bytes == null)
					return null;
				int cnt = bytes.length;
				char[] chars = new char[cnt << 1];
				int index = 0;
				int bt;
				for (int i = 0; i < cnt; i++)
					{
						bt = bytes[i];
						if (bt < 0)
							bt += 256;
						chars[index++] = HEX_CHARS[((byte) (bt >>> 4))];
						chars[index++] = HEX_CHARS[((byte) (bt & 0x0F))];
					}
				return chars;
			}
		
		public static byte[] convert(char[] chars)
			{
				if (chars == null)
					return null;
				int cnt = chars.length;
				if ((cnt & 1) == 1)
					return null;
    cnt >>= 1; 
				int index = 0;
				byte[] bytes = new byte[cnt];
				byte byte1, byte2;
				char c;
				for (int i = 0; i < cnt; i++)
					{
						c = chars[index++];
						if ((c >= HALFASCII)||((byte1 = HEX_BYTES[c])==INVALIDHEXSYMBOL))
							return null;
						c = chars[index++];
						if ((c >= HALFASCII)||((byte2 = HEX_BYTES[c])==INVALIDHEXSYMBOL))
							return null;
						bytes[i] = (byte) ((byte1 << 4) | byte2);
					}
				return bytes;
			}
	}
