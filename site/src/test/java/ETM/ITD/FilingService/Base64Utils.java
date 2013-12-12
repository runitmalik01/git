package ETM.ITD.FilingService;



/**
* The Class Base64Utils.
*/
public class Base64Utils {

/** The m base64 dec map. */
private static byte[] mBase64EncMap, mBase64DecMap;

/**
 * Class initializer. Initializes the Base64 alphabet
 * s(specified in RFC-2045).
 */
static
{
  final byte[] base64Map =
    {(byte) 'A', (byte) 'B', (byte) 'C', (byte) 'D', (byte) 'E', (byte) 'F',
      (byte) 'G', (byte) 'H', (byte) 'I', (byte) 'J', (byte) 'K', (byte) 'L',
      (byte) 'M', (byte) 'N', (byte) 'O', (byte) 'P', (byte) 'Q', (byte) 'R',
      (byte) 'S', (byte) 'T', (byte) 'U', (byte) 'V', (byte) 'W', (byte) 'X',
      (byte) 'Y', (byte) 'Z', (byte) 'a', (byte) 'b', (byte) 'c', (byte) 'd',
      (byte) 'e', (byte) 'f', (byte) 'g', (byte) 'h', (byte) 'i', (byte) 'j',
      (byte) 'k', (byte) 'l', (byte) 'm', (byte) 'n', (byte) 'o', (byte) 'p',
      (byte) 'q', (byte) 'r', (byte) 's', (byte) 't', (byte) 'u', (byte) 'v',
      (byte) 'w', (byte) 'x', (byte) 'y', (byte) 'z', (byte) '0', (byte) '1',
      (byte) '2', (byte) '3', (byte) '4', (byte) '5', (byte) '6', (byte) '7',
      (byte) '8', (byte) '9', (byte) '+', (byte) '/' };

  mBase64EncMap = base64Map;
  mBase64DecMap = new byte[128];
  for (int i = 0; i < mBase64EncMap.length; i++) {
    mBase64DecMap[mBase64EncMap[i]] = (byte) i;
  }
}

/**
 * Encodes the given byte[] using the Base64-encoding,
 * as specified in RFC-2045 (Section 6.8).
 *
 * @param strData the data to be encoded
 * @return the Base64-encoded
 */
public static String base64Encode(final byte[] strData) {
  if ((strData == null) || (strData.length == 0)) {
    throw new IllegalArgumentException("Can not encode "
        + "NULL or Empty byte array.");
  }

  final byte encodedBuf[] = new byte[((strData.length + 2) / 3) * 4];

  // 3-byte to 4-byte conversion
  int iSrcIndex, iDestIndex;
  for (iSrcIndex = 0, iDestIndex = 0; iSrcIndex < strData.length - 2;
      iSrcIndex += 3) {
    encodedBuf[iDestIndex++] =
        mBase64EncMap[(strData[iSrcIndex] >>> 2) & 077];
    encodedBuf[iDestIndex++] =
        mBase64EncMap[(strData[iSrcIndex + 1] >>> 4) & 017
                      | (strData[iSrcIndex] << 4) & 077];
    encodedBuf[iDestIndex++] =
        mBase64EncMap[(strData[iSrcIndex + 2] >>> 6) & 003
                      | (strData[iSrcIndex + 1] << 2) & 077];
    encodedBuf[iDestIndex++] = mBase64EncMap[strData[iSrcIndex + 2]
        & 077];
  }

  // Convert the last 1 or 2 bytes
  if (iSrcIndex < strData.length) {
    encodedBuf[iDestIndex++] =
        mBase64EncMap[(strData[iSrcIndex] >>> 2) & 077];
    if (iSrcIndex < strData.length - 1) {
      encodedBuf[iDestIndex++] =
          mBase64EncMap[(strData[iSrcIndex + 1] >>> 4) & 017
                        | (strData[iSrcIndex] << 4) & 077];
      encodedBuf[iDestIndex++] =
          mBase64EncMap[(strData[iSrcIndex + 1] << 2) & 077];
    } else {
      encodedBuf[iDestIndex++] =
          mBase64EncMap[(strData[iSrcIndex] << 4) & 077];
    }
  }

  // Add padding to the end of encoded data
  while (iDestIndex < encodedBuf.length) {
    encodedBuf[iDestIndex] = '=';
    iDestIndex++;
  }
  final String strResult = new String(encodedBuf);

  return strResult;
}

/**
 * Decodes the given Base64-encoded data,
 * as specified in RFC-2045 (Section 6.8).
 *
 * @param strData the Base64-encoded strData.
 * @return the decoded <var>strData
 */
public static byte[] base64Decode(final String strData) {
  if ((strData == null) || (strData.length() == 0)) {
    throw new IllegalArgumentException("Can not decode NULL or "
        + "Empty string.");
  }

  final byte[] byData = strData.getBytes();

  // Skip padding from the end of encoded data
  int tail = byData.length;
  while (byData[tail - 1] == '=') {
    tail--;
  }

  final byte decodedBuf[] = new byte[tail - byData.length / 4];

  // ASCII-printable to 0-63 conversion
  for (int i = 0; i < byData.length; i++) {
    byData[i] = mBase64DecMap[byData[i]];
  }

  // 4-byte to 3-byte conversion
  int iSrcIndex, iDestIndex;
  for (iSrcIndex = 0, iDestIndex = 0; iDestIndex < decodedBuf.length - 2;
      iSrcIndex += 4, iDestIndex += 3) {
    decodedBuf[iDestIndex] =
        (byte) (((byData[iSrcIndex] << 2) & 255)
            | ((byData[iSrcIndex + 1] >>> 4) & 003));
    decodedBuf[iDestIndex + 1] =
        (byte) (((byData[iSrcIndex + 1] << 4) & 255)
            | ((byData[iSrcIndex + 2] >>> 2) & 017));
    decodedBuf[iDestIndex + 2] =
        (byte) (((byData[iSrcIndex + 2] << 6) & 255)
            | (byData[iSrcIndex + 3] & 077));
  }

  // Handle last 1 or 2 bytes
  if (iDestIndex < decodedBuf.length) {
    decodedBuf[iDestIndex] =
        (byte) (((byData[iSrcIndex] << 2) & 255)
            | ((byData[iSrcIndex + 1] >>> 4) & 003));
  }
  if (++iDestIndex < decodedBuf.length) {
    decodedBuf[iDestIndex] =
        (byte) (((byData[iSrcIndex + 1] << 4) & 255) | (
            (byData[iSrcIndex + 2] >>> 2) & 017));
  }

  return decodedBuf;
}
}
