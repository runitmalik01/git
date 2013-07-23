/**
 * $RCSfile$
 * $Revision: 16357 $
 * $Date: 2005-06-10 14:37:23 -0700 (Fri, 10 Jun 2005) $
 *
 * Copyright (C) 1999-2004 Jive Software. All rights reserved.
 *
 * This software is the proprietary information of Jive Software.
 * Use is subject to license terms.
 */

package com.mootly.wcm.it.workflow.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class to peform common String manipulation algorithms.
 */
public class StringUtils {
	
	private static Logger log = LoggerFactory.getLogger(StringUtils.class);
	
    // Constants used by escapeHTMLTags
    private static final char[] QUOTE_ENCODE = "&quot;".toCharArray();
    private static final char[] AMP_ENCODE = "&amp;".toCharArray();
    private static final char[] LT_ENCODE = "&lt;".toCharArray();
    private static final char[] GT_ENCODE = "&gt;".toCharArray();
    // patterns for the email address checks
    private static Pattern basicAddressPattern;
    private static Pattern validUserPattern;
    private static Pattern domainPattern;
    private static Pattern ipDomainPattern;
    private static Pattern tldPattern;
    private static final String EMAIL_DOMAINS = "com|net|org|edu|int|mil|gov|arpa|biz|aero|name|coop|info|pro|museum";

    public static String getValidEmailDomains() {
        return EMAIL_DOMAINS;
    }

    // prepare the patterns
    static {
        // constants used in the parsing of email addresses
        String basicAddress = "^([\\w\\.-]+)@([\\w\\.-]+)$";
        String specialChars = "\\(\\)><@,;:\\\\\\\"\\.\\[\\]";
        String validChars = "[^ \f\n\r\t" + specialChars + "]";
        String atom = validChars + "+";
        String quotedUser = "(\"[^\"]+\")";
        String word = "(" + atom + "|" + quotedUser + ")";
        String validUser = "^" + word + "(\\." + word + ")*$";
        String domain = "^" + atom + "(\\." + atom + ")+$";
        String ipDomain = "^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$";
        // from http://www.icann.org/tlds/
        String knownTLDs = "^\\.(" + EMAIL_DOMAINS + ")$";


        basicAddressPattern = Pattern.compile(basicAddress, Pattern.CASE_INSENSITIVE);
        validUserPattern = Pattern.compile(validUser, Pattern.CASE_INSENSITIVE);
        domainPattern = Pattern.compile(domain, Pattern.CASE_INSENSITIVE);
        ipDomainPattern = Pattern.compile(ipDomain, Pattern.CASE_INSENSITIVE);
        tldPattern = Pattern.compile(knownTLDs, Pattern.CASE_INSENSITIVE);
    }

    // Utility class - only static methods.
    private StringUtils() { }

    /**
     * Replaces all instances of oldString with newString in string.
     *
     * @param string the String to search to perform replacements on
     * @param oldString the String that should be replaced by newString
     * @param newString the String that will replace all instances of oldString
     *
     * @return a String will all instances of oldString replaced by newString
     */
    public static final String replace(String string, String oldString, String newString) {
        if (string == null) {
            return null;
        }
        // If the newString is null or zero length, just return the string since there's nothing
        // to replace.
        if (newString == null) {
            return string;
        }
        int i=0;
        // Make sure that oldString appears at least once before doing any processing.
        if ( ( i=string.indexOf(oldString, i) ) >= 0 ) {
            // Use char []'s, as they are more efficient to deal with.
            char [] string2 = string.toCharArray();
            char [] newString2 = newString.toCharArray();
            int oLength = oldString.length();
            StringBuffer buf = new StringBuffer(string2.length);
            buf.append(string2, 0, i).append(newString2);
            i += oLength;
            int j = i;
            // Replace all remaining instances of oldString with newString.
            while ( ( i=string.indexOf(oldString, i) ) > 0 ) {
                buf.append(string2, j, i-j).append(newString2);
                i += oLength;
                j = i;
            }
            buf.append(string2, j, string2.length - j);
            return buf.toString();
        }
        return string;
    }

    /**
     * Replaces all instances of oldString with newString in line with the
     * added feature that matches of newString in oldString ignore case.
     *
     * @param line the String to search to perform replacements on
     * @param oldString the String that should be replaced by newString
     * @param newString the String that will replace all instances of oldString
     *
     * @return a String will all instances of oldString replaced by newString
     */
    public static final String replaceIgnoreCase(String line, String oldString, String newString) {
        if (line == null) {
            return null;
        }
        String lcLine = line.toLowerCase();
        String lcOldString = oldString.toLowerCase();
        int i=0;
        if ((i=lcLine.indexOf(lcOldString, i)) >= 0) {
            char [] line2 = line.toCharArray();
            char [] newString2 = newString.toCharArray();
            int oLength = oldString.length();
            StringBuffer buf = new StringBuffer(line2.length);
            buf.append(line2, 0, i).append(newString2);
            i += oLength;
            int j = i;
            while ((i=lcLine.indexOf(lcOldString, i)) > 0) {
                buf.append(line2, j, i-j).append(newString2);
                i += oLength;
                j = i;
            }
            buf.append(line2, j, line2.length - j);
            return buf.toString();
        }
        return line;
    }

    /**
     * Replaces all instances of oldString with newString in line with the
     * added feature that matches of newString in oldString ignore case.
     * The count paramater is set to the number of replaces performed.
     *
     * @param line the String to search to perform replacements on
     * @param oldString the String that should be replaced by newString
     * @param newString the String that will replace all instances of oldString
     * @param count a value that will be updated with the number of replaces
     *      performed.
     *
     * @return a String will all instances of oldString replaced by newString
     */
    public static final String replaceIgnoreCase(String line, String oldString,
            String newString, int [] count)
    {
        if (line == null) {
            return null;
        }
        String lcLine = line.toLowerCase();
        String lcOldString = oldString.toLowerCase();
        int i=0;
        if ((i=lcLine.indexOf(lcOldString, i)) >= 0) {
            int counter = 1;
            char [] line2 = line.toCharArray();
            char [] newString2 = newString.toCharArray();
            int oLength = oldString.length();
            StringBuffer buf = new StringBuffer(line2.length);
            buf.append(line2, 0, i).append(newString2);
            i += oLength;
            int j = i;
            while ((i=lcLine.indexOf(lcOldString, i)) > 0) {
                counter++;
                buf.append(line2, j, i-j).append(newString2);
                i += oLength;
                j = i;
            }
            buf.append(line2, j, line2.length - j);
            count[0] = counter;
            return buf.toString();
        }
        return line;
    }

   /**
    * Replaces all instances of oldString with newString in line.
    * The count Integer is updated with number of replaces.
    *
    * @param line the String to search to perform replacements on
    * @param oldString the String that should be replaced by newString
    * @param newString the String that will replace all instances of oldString
    *
    * @return a String will all instances of oldString replaced by newString
    */
    public static final String replace(String line, String oldString,
            String newString, int[] count)
    {
        if (line == null) {
            return null;
        }
        int i=0;
        if ((i=line.indexOf(oldString, i)) >= 0) {
            int counter = 1;
            char [] line2 = line.toCharArray();
            char [] newString2 = newString.toCharArray();
            int oLength = oldString.length();
            StringBuffer buf = new StringBuffer(line2.length);
            buf.append(line2, 0, i).append(newString2);
            i += oLength;
            int j = i;
            while ((i=line.indexOf(oldString, i)) > 0) {
                counter++;
                buf.append(line2, j, i-j).append(newString2);
                i += oLength;
                j = i;
            }
            buf.append(line2, j, line2.length-j);
            count[0] = counter;
            return buf.toString();
        }
        return line;
    }

    /**
     * This method takes a string and strips out all tags except <br> tags while still leaving
     * the tag body intact.
     *
     * @param in the text to be converted.
     * @return the input string with all tags removed.
     */
    public static final String stripTags(String in) {
        if (in == null) {
            return null;
        }

        return stripTags(in, false);
    }

    /**
     * This method takes a string and strips out all tags while still leaving
     * the tag body intact.
     *
     * @param in the text to be converted.
     * @return the input string with all tags removed.
     */
    public static final String stripTags(String in, boolean stripBRTag) {
        if (in == null) {
            return null;
        }
        char ch;
        int i=0;
        int last=0;
        char[] input = in.toCharArray();
        int len = input.length;
        StringBuffer out = new StringBuffer((int)(len*1.3));
        for (; i < len; i++) {
            ch = input[i];
            if (ch > '>') {
                continue;
            }
            else if (ch == '<') {
                if (!stripBRTag && i + 3 < len && input[i+1] == 'b' && input[i+2] == 'r' && input[i+3] == '>') {
                    i += 3;
                    continue;
                }
                if (i > last) {
                    if (last > 0) {
                        out.append(" ");
                    }
                    out.append(input, last, i - last);
                }
                last = i + 1;
            }
            else if (ch == '>') {
                last = i + 1;
            }
        }
        if (last == 0) {
            return in;
        }
        if (i > last) {
            out.append(input, last, i - last);
        }
        return out.toString();
    }

    /**
     * This method takes a string which may contain HTML tags (ie, &lt;b&gt;,
     * &lt;table&gt;, etc) and converts the '&lt'' and '&gt;' characters to
     * their HTML escape sequences.
     *
     * @param in the text to be converted.
     * @return the input string with the characters '&lt;' and '&gt;' replaced
     *  with their HTML escape sequences.
     */
    public static final String escapeHTMLTags(String in) {
        if (in == null) {
            return null;
        }
        char ch;
        int i=0;
        int last=0;
        char[] input = in.toCharArray();
        int len = input.length;
        StringBuffer out = new StringBuffer((int)(len*1.3));
        for (; i < len; i++) {
            ch = input[i];
            if (ch > '>') {
                continue;
            } else if (ch == '<') {
                if (i > last) {
                    out.append(input, last, i - last);
                }
                last = i + 1;
                out.append(LT_ENCODE);
            } else if (ch == '>') {
                if (i > last) {
                    out.append(input, last, i - last);
                }
                last = i + 1;
                out.append(GT_ENCODE);
            } else if (ch == '"') {
                if (i > last) {
                    out.append(input, last, i - last);
                }
                last = i + 1;
                out.append(QUOTE_ENCODE);
            }
        }
        if (last == 0) {
            return in;
        }
        if (i > last) {
            out.append(input, last, i - last);
        }
        return out.toString();
    }

    /**
     * Used by the hash method.
     */
    private static MessageDigest digest = null;

    /**
     * Hashes a String using the Md5 algorithm and returns the result as a
     * String of hexadecimal numbers. This method is synchronized to avoid
     * excessive MessageDigest object creation. If calling this method becomes
     * a bottleneck in your code, you may wish to maintain a pool of
     * MessageDigest objects instead of using this method.
     * <p>
     * A hash is a one-way function -- that is, given an
     * input, an output is easily computed. However, given the output, the
     * input is almost impossible to compute. This is useful for passwords
     * since we can store the hash and a hacker will then have a very hard time
     * determining the original password.
     * <p>
     * In Jive, every time a user logs in, we simply
     * take their plain text password, compute the hash, and compare the
     * generated hash to the stored hash. Since it is almost impossible that
     * two passwords will generate the same hash, we know if the user gave us
     * the correct password or not. The only negative to this system is that
     * password recovery is basically impossible. Therefore, a reset password
     * method is used instead.
     *
     * @param data the String to compute the hash of.
     * @return a hashed version of the passed-in String
     */
    public synchronized static final String hash(String data) {
        if (digest == null) {
            try {
                digest = MessageDigest.getInstance("MD5");
            }
            catch (NoSuchAlgorithmException nsae) {
               log.error("Failed to load the MD5 MessageDigest. " +
                "Jive will be unable to function normally.", nsae);
            }
        }
        // Now, compute hash.
        try {
            digest.update(data.getBytes("utf-8"));
        }
        catch (UnsupportedEncodingException e) {
           log.error("Error",e);
            throw new UnsupportedOperationException("Error computing hash: " + e.getMessage());
        }
        return encodeHex(digest.digest());
    }

    /**
     * Turns an array of bytes into a String representing each byte as an
     * unsigned hex number.
     * <p>
     * Method by Santeri Paavolainen, Helsinki Finland 1996<br>
     * (c) Santeri Paavolainen, Helsinki Finland 1996<br>
     * Distributed under LGPL.
     *
     * @param bytes an array of bytes to convert to a hex-string
     * @return generated hex string
     */
    public static final String encodeHex(byte[] bytes) {
        StringBuffer buf = new StringBuffer(bytes.length * 2);
        int i;

        for (i = 0; i < bytes.length; i++) {
            if (((int) bytes[i] & 0xff) < 0x10) {
                buf.append("0");
            }
            buf.append(Long.toString((int) bytes[i] & 0xff, 16));
        }
        return buf.toString();
    }

    /**
     * Turns a hex encoded string into a byte array. It is specifically meant
     * to "reverse" the toHex(byte[]) method.
     *
     * @param hex a hex encoded String to transform into a byte array.
     * @return a byte array representing the hex String[
     */
    public static final byte[] decodeHex(String hex) {
        char [] chars = hex.toCharArray();
        byte[] bytes = new byte[chars.length/2];
        int byteCount = 0;
        for (int i=0; i<chars.length; i+=2) {
            int newByte = 0x00;
            newByte |= hexCharToByte(chars[i]);
            newByte <<= 4;
            newByte |= hexCharToByte(chars[i+1]);
            bytes[byteCount] = (byte)newByte;
            byteCount++;
        }
        return bytes;
    }

    /**
     * Returns the the byte value of a hexadecmical char (0-f). It's assumed
     * that the hexidecimal chars are lower case as appropriate.
     *
     * @param ch a hexedicmal character (0-f)
     * @return the byte value of the character (0x00-0x0F)
     */
    private static final byte hexCharToByte(char ch) {
        switch(ch) {
            case '0': return 0x00;
            case '1': return 0x01;
            case '2': return 0x02;
            case '3': return 0x03;
            case '4': return 0x04;
            case '5': return 0x05;
            case '6': return 0x06;
            case '7': return 0x07;
            case '8': return 0x08;
            case '9': return 0x09;
            case 'a': return 0x0A;
            case 'b': return 0x0B;
            case 'c': return 0x0C;
            case 'd': return 0x0D;
            case 'e': return 0x0E;
            case 'f': return 0x0F;
        }
        return 0x00;
    }

    /**
     * Encodes a String as a base64 String.
     *
     * @param data a String to encode.
     * @return a base64 encoded String.
     */
    public static String encodeBase64(String data) {
        byte [] bytes = null;
        try {
            bytes = data.getBytes("UTF-8");
        }
        catch (UnsupportedEncodingException uee) {
           log.error("Error",uee);
        }
        return encodeBase64(bytes);
    }

    /**
     * Decodes a base64 String.
     *
     * @param data a base64 encoded String to decode.
     * @return the decoded String.
     */
    public static String decodeBase64(String data) {
        try {
            byte [] bytes = data.getBytes("UTF-8");
            return new String(decodeBase64(bytes), "UTF-8");
        }
        catch (UnsupportedEncodingException uee) {
           log.error("Error",uee);
            return "";
        }
    }

    /**
     * The methods below are under the following license
     * ==============
     * Copyright (c) 2004, Mikael Grev, MiG InfoCom AB. (base64@miginfocom.com)
     * All rights reserved.
     *
     * Redistribution and use in source and binary forms, with or without modification,
     * are permitted provided that the following conditions are met:
     * Redistributions of source code must retain the above copyright notice, this list
     * of conditions and the following disclaimer.
     * Redistributions in binary form must reproduce the above copyright notice, this
     * list of conditions and the following disclaimer in the documentation and/or other
     * materials provided with the distribution.
     * Neither the name of the MiG InfoCom AB nor the names of its contributors may be
     * used to endorse or promote products derived from this software without specific
     * prior written permission.
     *
     * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
     * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
     * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
     * IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
     * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
     * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA,
     * OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
     * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
     * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY
     * OF SUCH DAMAGE.
     *
     * version: 2.2
     * author: Mikael Grev
     *         Date: 2004-aug-02
     *         Time: 11:31:11
     */

    private static final char[] CA =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
    private static final int[] IA = new int[256];
    static {
        Arrays.fill(IA, -1);
        for (int i = 0, iS = CA.length; i < iS; i++) {
            IA[CA[i]] = i;
        }
        IA['='] = 0;
    }

    /**
     * Encodes a byte array into a base64 String.
     *
     * @param data a byte array to encode.
     * @return a base64 encode String.
     */
    public static String encodeBase64(byte[] data) {
        boolean lineSep = false;
        // Check special case
		int sLen = data != null ? data.length : 0;
		if (sLen == 0)
			return new String("");

		int eLen = (sLen / 3) * 3;              // Length of even 24-bits.
		int cCnt = ((sLen - 1) / 3 + 1) << 2;   // Returned character count
		int dLen = cCnt + (lineSep ? (cCnt - 1) / 76 << 1 : 0); // Length of returned array
		char[] dArr = new char[dLen];

		// Encode even 24-bits
		for (int s = 0, d = 0, cc = 0; s < eLen;) {
			// Copy next three bytes into lower 24 bits of int, paying attension to sign.
			int i = (data[s++] & 0xff) << 16 | (data[s++] & 0xff) << 8 | (data[s++] & 0xff);

			// Encode the int into four chars
			dArr[d++] = CA[(i >>> 18) & 0x3f];
			dArr[d++] = CA[(i >>> 12) & 0x3f];
			dArr[d++] = CA[(i >>> 6) & 0x3f];
			dArr[d++] = CA[i & 0x3f];

			// Add optional line separator
			if (lineSep && ++cc == 19 && d < dLen - 2) {
				dArr[d++] = '\r';
				dArr[d++] = '\n';
				cc = 0;
			}
		}

		// Pad and encode last bits if source isn't even 24 bits.
		int left = sLen - eLen; // 0 - 2.
		if (left > 0) {
			// Prepare the int
			int i = ((data[eLen] & 0xff) << 10) | (left == 2 ? ((data[sLen - 1] & 0xff) << 2) : 0);

			// Set last four chars
			dArr[dLen - 4] = CA[i >> 12];
			dArr[dLen - 3] = CA[(i >>> 6) & 0x3f];
			dArr[dLen - 2] = left == 2 ? CA[i & 0x3f] : '=';
			dArr[dLen - 1] = '=';
		}
		return new String(dArr);
    }

    /**
     * Decodes a BASE64 encoded byte array.
     *
	 * @param bytes the source array.
	 * @return the decoded array of bytes.
	 */
	public final static byte[] decodeBase64(byte[] bytes) {
		// Check special case
		int sLen = bytes.length;

		// Count illegal characters (including '\r', '\n') to know what size the returned
        // array will be, so we don't have to reallocate & copy it later.
		int sepCnt = 0; // Number of separator characters. (Actually illegal characters, but that's a bonus...)
		for (int i = 0; i < sLen; i++)      // If input is "pure" (I.e. no line separators or illegal chars) base64 this loop can be commented out.
			if (IA[bytes[i] & 0xff] < 0)
				sepCnt++;

		// Check so that legal chars (including '=') are evenly divideable by 4 as specified in RFC 2045.
		if ((sLen - sepCnt) % 4 != 0)
			return null;

		int pad = 0;
		for (int i = sLen; i > 1 && IA[bytes[--i] & 0xff] <= 0;)
			if (bytes[i] == '=')
				pad++;

		int len = ((sLen - sepCnt) * 6 >> 3) - pad;

		byte[] dArr = new byte[len];       // Preallocate byte[] of exact length

		for (int s = 0, d = 0; d < len;) {
			// Assemble three bytes into an int from four "valid" characters.
			int i = 0;
			for (int j = 0; j < 4; j++) {   // j only increased if a valid char was found.
				int c = IA[bytes[s++] & 0xff];
				if (c >= 0)
				    i |= c << (18 - j * 6);
				else
					j--;
			}

			// Add the bytes
			dArr[d++] = (byte) (i >> 16);
			if (d < len) {
				dArr[d++]= (byte) (i >> 8);
				if (d < len)
					dArr[d++] = (byte) i;
			}
		}

		return dArr;
	}

    /**
     * The method below is under the following license
     *
     * ====================================================================
     *
     * The Apache Software License, Version 1.1
     *
     * Copyright (c) 2002-2003 The Apache Software Foundation.  All rights
     * reserved.
     *
     * Redistribution and use in source and binary forms, with or without
     * modification, are permitted provided that the following conditions
     * are met:
     *
     * 1. Redistributions of source code must retain the above copyright
     *    notice, this list of conditions and the following disclaimer.
     *
     * 2. Redistributions in binary form must reproduce the above copyright
     *    notice, this list of conditions and the following disclaimer in
     *    the documentation and/or other materials provided with the
     *    distribution.
     *
     * 3. The end-user documentation included with the redistribution, if
     *    any, must include the following acknowlegement:
     *       "This product includes software developed by the
     *        Apache Software Foundation (http://www.apache.org/)."
     *    Alternately, this acknowlegement may appear in the software itself,
     *    if and wherever such third-party acknowlegements normally appear.
     *
     * 4. The names "The Jakarta Project", "Commons", and "Apache Software
     *    Foundation" must not be used to endorse or promote products derived
     *    from this software without prior written permission. For written
     *    permission, please contact apache@apache.org.
     *
     * 5. Products derived from this software may not be called "Apache"
     *    nor may "Apache" appear in their names without prior written
     *    permission of the Apache Group.
     *
     * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
     * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
     * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
     * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
     * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
     * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
     * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
     * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
     * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
     * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
     * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
     * SUCH DAMAGE.
     * ====================================================================
     *
     * This software consists of voluntary contributions made by many
     * individuals on behalf of the Apache Software Foundation.  For more
     * information on the Apache Software Foundation, please see
     * <http://www.apache.org/>.
     */
    private static final BitSet allowed_query = new BitSet(256);

    static {
        for (int i = '0'; i <= '9'; i++) {
            allowed_query.set(i);
        }

        for (int i = 'a'; i <= 'z'; i++) {
            allowed_query.set(i);
        }
        for (int i = 'A'; i <= 'Z'; i++) {
            allowed_query.set(i);
        }

        allowed_query.set('-');
        allowed_query.set('_');
        allowed_query.set('.');
        allowed_query.set('!');
        allowed_query.set('~');
        allowed_query.set('*');
        allowed_query.set('\'');
        allowed_query.set('(');
        allowed_query.set(')');
    }

    /**
     * Encodes URI string. This is a replacement for the java.net.URLEncode#encode(String, String)
     * class which is broken under JDK 1.3.
     * <p>
     *
     * @param original the original character sequence
     * @param charset the protocol charset
     * @return URI character sequence
     * @throws UnsupportedEncodingException unsupported character encoding
     */
    public static String URLEncode(String original, String charset)
                throws UnsupportedEncodingException
    {
        // encode original to uri characters.
        if (original == null) {
            return null;
        }

        // escape octet to uri characters.
        byte[] octets;

        try {
            octets = original.getBytes(charset);
        }
        catch (UnsupportedEncodingException error) {
            throw new UnsupportedEncodingException();
        }

        StringBuffer buf = new StringBuffer(octets.length);

        for (int i = 0; i < octets.length; i++) {
            char c = (char) octets[i];
            if (allowed_query.get(c)) {
                buf.append(c);
            }
            else {
                buf.append('%');
                byte b = octets[i]; // use the original byte value
                char hexadecimal = Character.forDigit((b >> 4) & 0xF, 16);
                buf.append(Character.toUpperCase(hexadecimal)); // high
                hexadecimal = Character.forDigit(b & 0xF, 16);
                buf.append(Character.toUpperCase(hexadecimal)); // low
            }
        }

        return buf.toString();
    }

    /**
     * Converts a line of text into an array of lower case words using a
     * BreakIterator.wordInstance(). <p>
     *
     * This method is under the Jive Open Source Software License and was
     * written by Mark Imbriaco.
     *
     * @param text a String of text to convert into an array of words
     * @return text broken up into an array of words.
     */
    public static final String [] toLowerCaseWordArray(String text) {
        if (text == null || text.length() == 0) {
                return new String[0];
        }

        ArrayList wordList = new ArrayList();
        BreakIterator boundary = BreakIterator.getWordInstance();
        boundary.setText(text);
        int start = 0;

        for (int end = boundary.next(); end != BreakIterator.DONE;
                start = end, end = boundary.next())
        {
            String tmp = text.substring(start,end).trim();
            // Remove characters that are not needed.
            tmp = replace(tmp, "+", "");
            tmp = replace(tmp, "/", "");
            tmp = replace(tmp, "\\", "");
            tmp = replace(tmp, "#", "");
            tmp = replace(tmp, "*", "");
            tmp = replace(tmp, ")", "");
            tmp = replace(tmp, "(", "");
            tmp = replace(tmp, "&", "");
            if (tmp.length() > 0) {
                wordList.add(tmp);
            }
        }
        return (String[]) wordList.toArray(new String[wordList.size()]);
    }

    /**
     * Pseudo-random number generator object for use with randomString().
     * The Random class is not considered to be cryptographically secure, so
     * only use these random Strings for low to medium security applications.
     */
    private static Random randGen = new Random();

    /**
     * Array of numbers and letters of mixed case. Numbers appear in the list
     * twice so that there is a more equal chance that a number will be picked.
     * We can use the array to get a random number or letter by picking a random
     * array index.
     */
    private static char[] numbersAndLetters = ("0123456789abcdefghijklmnopqrstuvwxyz" +
                    "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();

    /**
     * Returns a random String of numbers and letters (lower and upper case)
     * of the specified length. The method uses the Random class that is
     * built-in to Java which is suitable for low to medium grade security uses.
     * This means that the output is only pseudo random, i.e., each number is
     * mathematically generated so is not truly random.<p>
     *
     * The specified length must be at least one. If not, the method will return
     * null.
     *
     * @param length the desired length of the random String to return.
     * @return a random String of numbers and letters of the specified length.
     */
    public static final String randomString(int length) {
        if (length < 1) {
            return null;
        }
        // Create a char buffer to put random letters and numbers in.
        char [] randBuffer = new char[length];
        for (int i=0; i<randBuffer.length; i++) {
            randBuffer[i] = numbersAndLetters[randGen.nextInt(71)];
        }
        return new String(randBuffer);
    }

    /**
     * Unintelligently chops a string at a given length. If characters of a string are
     * chopped, elipses will be appended.
     *
     * @param string the string to chop.
     * @param length the maximum number of characters to show.
     * @return the string chopped to the specified length with elipses at the end if the string
     *      was longer than the given length.
     */
    public static final String chop(String string, int length) {
        if (string == null) {
            return null;
        }
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be > 0");
        }
        if (string.length() <= length+2) {
            return string;
        }
        else {
            StringBuffer buf = new StringBuffer(string.substring(0, length));
            buf.append("...");
            return buf.toString();
        }
    }

   /**
    * Intelligently chops a String at a word boundary (whitespace) that occurs
    * at the specified index in the argument or before. However, if there is a
    * newline character before <code>length</code>, the String will be chopped
    * there. If no newline or whitespace is found in <code>string</code> up to
    * the index <code>length</code>, the String will chopped at <code>length</code>.
    * <p>
    * For example, chopAtWord("This is a nice String", 10, -1) will return
    * "This is a" which is the first word boundary less than or equal to 10
    * characters into the original String.
    *
    * @param string the String to chop.
    * @param length the index in <code>string</code> to start looking for a
    *       whitespace boundary at.
    * @param minLength the minimum length the word should be chopped at. This is helpful
    *       for words with no natural boundaries, ie: "thisisareallylonglonglongword".
    *       This must be smaller than length and can be -1 if no minLength is wanted
    * @return a substring of <code>string</code> whose length is less than or
    *       equal to <code>length</code>, and that is chopped at whitespace.
    */
    public static final String chopAtWord(String string, int length, int minLength) {
        // guard clauses
        if (length < 2) {
            throw new IllegalArgumentException("Length specified (" + length + ") must be > 2");
        }
        else if (minLength >= length) {
            throw new IllegalArgumentException("minLength must be smaller than length");
        }

        int sLength = (string == null) ? -1 : string.length();

        // shortcircuit clauses
        if (sLength < 1) {
            return string;
        }
        // minLength specified, string is smaller than the minLength, return the string
        else if (minLength != -1 && sLength < minLength) {
            return string;
        }
        // no minLength specified, string is smaller than length
        else if (minLength == -1 && sLength < length) {
           return string;
        }

        char [] charArray = string.toCharArray();

        // String is longer than the length specified, attempt to find a newline
        // or a space
        if (sLength > length) {
            sLength = length;

            // First check if there is a newline character before length; if so,
            // chop word there.
            for (int i = 0; i < sLength - 1; i++) {
                // Windows
                if (charArray[i] == '\r' && charArray[i + 1] == '\n') {
                    return string.substring(0, i + 1);
                }
                // Unix
                else if (charArray[i] == '\n') {
                    return string.substring(0, i);
                }
            }
            // Also check boundary case of Unix newline
            if (charArray[sLength - 1] == '\n') {
                return string.substring(0, sLength - 1);
            }

            // No newline, so chop at the first whitespace.
            for (int i = sLength - 1; i > 0; i--) {
                if (charArray[i] == ' ') {
                    return string.substring(0, i).trim();
                }
            }
        }
        // String is shorter than length but longer than minLength,
        // make sure there is a space in the string before minLength
        else if (minLength != -1 && sLength > minLength) {
            for (int i = 0; i < minLength; i++) {
                if (charArray[i] == ' ') {
                    return string;
                }
            }
        }

        // Did not find a word boundary, so return a string at the min length, if a min
        // length was specified:
        if (minLength > -1 && minLength <= string.length()) {
            return string.substring(0, minLength);
        }

        // Did not find word boundary or min length so return original String chopped at
        // specified length.
        return string.substring(0, length);
    }

    /**
     * Intelligently chops a String at a word boundary (whitespace) that occurs
     * at the specified index in the argument or before. However, if there is a
     * newline character before <code>length</code>, the String will be chopped
     * there. If no newline or whitespace is found in <code>string</code> up to
     * the index <code>length</code>, the String will chopped at <code>length</code>.
     * <p>
     * For example, chopAtWord("This is a nice String", 10) will return
     * "This is a" which is the first word boundary less than or equal to 10
     * characters into the original String.
     *
     * @param string the String to chop.
     * @param length the index in <code>string</code> to start looking for a
     *       whitespace boundary at.
     * @return a substring of <code>string</code> whose length is less than or
     *       equal to <code>length</code>, and that is chopped at whitespace.
     */
    public static final String chopAtWord(String string, int length) {
        return chopAtWord(string, length, -1);
    }

    /**
     * Returns a substring of the given string which represents the words around the given word.
     * For example, passing in "This is a quick test a test", "{a,test}" and 5 would return a string
     * of "This is a quick" - that's 5 characters (or to the end of the word, whichever
     * is greater) on either side of "a". Also, since {a,test} is passed in a "a" is found
     * first in the string, we base the substring off of the position of "a". The wordList is
     * really just a list of strings to try - the first one found is used.<p>
     *
     * Note: The wordList passed in should be lowercase.
     *
     * @param input The string to parse.
     * @param wordList The words to look for - the first one found in the string is used.
     * @param numChars The number of characters on either side to include in the chop.
     * @return a substring of the given string matching the criteria, otherwise "".
     */
    public static String chopAtWordsAround(String input, String[] wordList, int numChars) {
        if (input == null || "".equals(input.trim()) || wordList == null
                || wordList.length == 0 || numChars == 0)
        {
            return "";
        }
        String lc = input.toLowerCase();
        for (int i=0; i<wordList.length; i++) {
            int pos = lc.indexOf(wordList[i]);
            if (pos > -1) {
                int beginIdx = pos - numChars;
                if (beginIdx < 0) { beginIdx = 0; }
                int endIdx = pos + numChars;
                if (endIdx > input.length()-1) { endIdx = input.length()-1; }
                char[] chars = input.toCharArray();
                while (beginIdx > 0 && chars[beginIdx] != ' ' && chars[beginIdx] != '\n'
                        && chars[beginIdx] != '\r')
                {
                    beginIdx--;
                }
                while (endIdx < input.length() && chars[endIdx] != ' '
                        && chars[endIdx] != '\n' && chars[endIdx] != '\r')
                {
                    endIdx++;
                }
                return input.substring(beginIdx, endIdx);
            }
        }
        return input.substring(0, (input.length() >= 200) ? 200 : input.length());
    }

    /**
     * Reformats a string where lines that are longer than <tt>width</tt>
     * are split apart at the earliest wordbreak or at maxLength, whichever is
     * sooner. If the width specified is less than 5 or greater than the input
     * Strings length the string will be returned as is.
     * <p>
     * Please note that this method can be lossy - trailing spaces on wrapped
     * lines may be trimmed.
     *
     * @param input the String to reformat.
     * @param width the maximum length of any one line.
     * @return a new String with reformatted as needed.
     */
    public static String wordWrap(String input, int width, Locale locale) {
        // protect ourselves
        if (input == null) {
            return "";
        }
        else if (width < 5) {
            return input;
        }
        else if (width >= input.length()) {
            return input;
        }

        // default locale
        if (locale == null) {
            locale = SymbolGlobals.getLocale();
        }

        StringBuffer buf  = new StringBuffer(input);
        boolean endOfLine = false;
        int lineStart     = 0;

        for (int i = 0; i < buf.length(); i++) {
            if (buf.charAt(i) == '\n') {
                lineStart = i + 1;
                endOfLine = true;
            }

            // handle splitting at width character
            if (i > lineStart + width - 1) {
                if (!endOfLine) {
                    int limit = i - lineStart - 1;
                    BreakIterator breaks = BreakIterator.getLineInstance(locale);
                    breaks.setText(buf.substring(lineStart, i));
                    int end = breaks.last();

                    // if the last character in the search string isn't a space,
                    // we can't split on it (looks bad). Search for a previous
                    // break character
                   if (end == limit + 1) {
                        if (!Character.isWhitespace(buf.charAt(lineStart + end))) {
                            end = breaks.preceding(end - 1);
                        }
                    }

                    // if the last character is a space, replace it with a \n
                    if (end != BreakIterator.DONE && end == limit + 1) {
                        buf.replace(lineStart + end, lineStart + end + 1, "\n");
                        lineStart = lineStart + end;
                    }
                    // otherwise, just insert a \n
                    else if (end != BreakIterator.DONE && end != 0) {
                        buf.insert(lineStart + end, '\n');
                        lineStart = lineStart + end + 1;
                    }
                    else {
                        buf.insert(i, '\n');
                        lineStart = i + 1;
                    }
                }
                else {
                    buf.insert(i, '\n');
                    lineStart = i + 1;
                    endOfLine = false;
                }
            }
        }

        return buf.toString();
    }

    /**
     * Highlights words in a string. Words matching ignores case. The actual
     * higlighting method is specified with the start and end higlight tags.
     * Those might be beginning and ending HTML bold tags, or anything else.<p>
     *
     * This method is under the Jive Open Source Software License and was
     * written by Mark Imbriaco.
     *
     * @param string the String to highlight words in.
     * @param words an array of words that should be highlighted in the string.
     * @param startHighlight the tag that should be inserted to start highlighting.
     * @param endHighlight the tag that should be inserted to end highlighting.
     * @return a new String with the specified words highlighted.
     */
    public static final String highlightWords(String string, String[] words,
        String startHighlight, String endHighlight)
    {
        if (string == null || words == null || startHighlight == null || endHighlight == null) {
            return null;
        }

        StringBuffer regexp = new StringBuffer();
        regexp.append("(?i)\\b(");

        // Iterate through each word and generate a word list for the regexp.
        for (int x = 0; x < words.length; x++) {
            // Escape "$", "|", ".", "/", and "?" to keep us out of trouble in our regexp.
            words[x] = words[x].replaceAll("([\\$\\?\\|\\/\\.])", "\\\\$1");
            regexp.append(words[x]);

            if (x != words.length -1) {
                regexp.append("|");
            }
        }
        regexp.append(")");

        return string.replaceAll(regexp.toString(), startHighlight + "$1" + endHighlight);
    }

    /**
     * Escapes all necessary characters in the String so that it can be used in SQL
     *
     * @param string the string to escape.
     * @return the string with appropriate characters escaped.
     */
    public static final String escapeForSQL(String string) {
        if (string == null) {
            return null;
        }
        else if (string.length() == 0) {
            return string;
        }

        char ch;
        char[] input = string.toCharArray();
        int i = 0;
        int last = 0;
        int len = input.length;
        StringBuffer out = null;
        for (; i < len; i++) {
            ch = input[i];

            if (ch == '\'') {
                if (out == null) {
                     out = new StringBuffer(len + 2);
                }
                if (i > last) {
                    out.append(input, last, i - last);
                }
                last = i + 1;
                out.append('\'').append('\'');
            }
        }

        if (out == null) {
            return string;
        }
        else if (i > last) {
            out.append(input, last, i - last);
        }

        return out.toString();
    }

    /**
     * Escapes all necessary characters in the String so that it can be used
     * in an XML doc.
     *
     * @param string the string to escape.
     * @return the string with appropriate characters escaped.
     */
    public static final String escapeForXML(String string) {
        if (string == null) {
            return null;
        }
        char ch;
        int i=0;
        int last=0;
        char[] input = string.toCharArray();
        int len = input.length;
        StringBuffer out = new StringBuffer((int)(len*1.3));
        for (; i < len; i++) {
            ch = input[i];

            if (ch > '>') {
                continue;
            } else if (ch == '<') {
                if (i > last) {
                    out.append(input, last, i - last);
                }
                last = i + 1;
                out.append(LT_ENCODE);
            } else if (ch == '>') {
                if (i > last) {
                    out.append(input, last, i - last);
                }
                last = i + 1;
                out.append(GT_ENCODE);
            } else if (ch == '&') {
                if (i > last) {
                    out.append(input, last, i - last);
                }
                last = i + 1;
                out.append(AMP_ENCODE);
            } else if (ch == '"') {
                if (i > last) {
                    out.append(input, last, i - last);
                }
                last = i + 1;
                out.append(QUOTE_ENCODE);
            } else if (ch == 10 || ch == 13 || ch == 9) {
                continue;
            } else if (ch < 32) {
                // Disallow all ASCII control characters, except space,
                // enter characters and tabs:
                if (i > last) {
                    out.append(input, last, i - last);
                }
                last = i + 1;
            }
        }
        if (last == 0) {
            return string;
        }
        if (i > last) {
            out.append(input, last, i - last);
        }
        return out.toString();
    }

    /**
     * Unescapes the String by converting XML escape sequences back into normal
     * characters.
     *
     * @param string the string to unescape.
     * @return the string with appropriate characters unescaped.
     */
    public static final String unescapeFromXML(String string) {
        string = replace(string, "&lt;", "<");
        string = replace(string, "&gt;", ">");
        string = replace(string, "&quot;", "\"");
        return replace(string, "&amp;", "&");
    }

    private static final char[] zeroArray =
            "0000000000000000000000000000000000000000000000000000000000000000".toCharArray();

    /**
     * Pads the supplied String with 0's to the specified length and returns
     * the result as a new String. For example, if the initial String is
     * "9999" and the desired length is 8, the result would be "00009999".
     * This type of padding is useful for creating numerical values that need
     * to be stored and sorted as character data. Note: the current
     * implementation of this method allows for a maximum <tt>length</tt> of
     * 64.
     *
     * @param string the original String to pad.
     * @param length the desired length of the new padded String.
     * @return a new String padded with the required number of 0's.
     */
    public static final String zeroPadString(String string, int length) {
        if (string == null || string.length() > length) {
            return string;
        }
        StringBuffer buf = new StringBuffer(length);
        buf.append(zeroArray, 0, length-string.length()).append(string);
        return buf.toString();
     }

    /**
     * Formats a Date as a String. Depending on how Dates are defined in the database
     * (character data or numberic), the format return will either be a fifteen character long String
     * made up of the Date's padded millisecond value, or will simply be the Date's millesecond value.
     *
     * @return a Date encoded as a String.
     */
    /*
    public static final String dateToMillis(Date date) {
        if (ConnectionManager.getDateType() == Types.VARCHAR) {
            return zeroPadString(Long.toString(date.getTime()), 15);
        }
        else {
            return Long.toString(date.getTime());
        }
    }
    */

    /**
     * Validate an email address. This isn't 100% perfect but should handle just about everything
     * that is in common use.
     *
     * @param addr the email address to validate
     * @return true if the address is valid, false otherwise
     */
    public static boolean isValidEmailAddress(String addr) {
        if (addr == null) {
            return false;
        }

        addr = addr.trim();

        if (addr.length() == 0) {
            return false;
        }

        // basic address check
        Matcher matcher = basicAddressPattern.matcher(addr);
        if (!matcher.matches()) {
            return false;
        }
        String userPart = matcher.group(1);
        String domainPart = matcher.group(2);

        // user address check
        matcher = validUserPattern.matcher(userPart);
        if (!matcher.matches()) {
            return false;
        }

        // ip domain check
        matcher = ipDomainPattern.matcher(domainPart);
        if (matcher.matches()) {
            // if the pattern matched, check to make sure that the ip range is valid
            for (int i = 1; i < 5; i++) {
                String num = matcher.group(i);

                if (num == null) {
                    return false;
                }

                if (Integer.parseInt(num) > 254) {
                    return false;
                }
            }
            return true;
        }

        // symbolic domain check
        matcher = domainPattern.matcher(domainPart);
        if (matcher.matches()) {
            String tld = matcher.group(matcher.groupCount());

            // Permit top-level-domains of 3 (includes dot separator) because these could be
            // country codes which we are not going to check for.
            matcher = tldPattern.matcher(tld);
            if (tld.length() != 3 && !matcher.matches()) {
                return false;
            }
        }
        else {
            return false;
        }

        // all tests passed
        return true;
    }

    /**
     * <p>
     * Removes any character in the given input which are 'ignorable identifiers' in the
     * Java and Unicode language character sets. This is helpful for things like RSS feeds
     * which sends a message body out which might contain high-order characters. This might happen
     * if the messages has content pasted from MS Word or other applications.
     * </p>
     *
     * <p>
     * This internally calls {@link Character#isIdentifierIgnorable(char)} to determine if
     * a character is ignorable. Please read the Javadocs on that method for a list of ignorable
     * characters.
     * </p>
     *
     * @param input the input to test.
     * @return the input with any ignoreable characters removed.
     */
    public static String removeIgnorableCharacters(String input) {
        if (input == null) {
            return input;
        }
        else {
            StringBuffer buf = new StringBuffer();
            char[] chars = input.toCharArray();
            for (int i=0,n=input.length(); i<n; i++) {
                // if this test is true, it's high-bit char
                if (Character.isIdentifierIgnorable(chars[i])) {
                    continue;  // skip the bad character
                }
                else {
                    buf.append(chars[i]);
                }
            }
            return buf.toString();
        }
    }
}