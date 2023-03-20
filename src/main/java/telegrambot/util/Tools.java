package telegrambot.util;

import java.text.Normalizer;

public class Tools {
	public static String MD5(String md5) {
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			byte[] array = md.digest(md5.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; ++i) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
			}
			return sb.toString();
		} catch (java.security.NoSuchAlgorithmException e) {

		}
		return null;
	}

	public static String Capitular(String s) {
		var cap = s.toLowerCase();
		return cap.substring(0, 1).toUpperCase() + cap.substring(1);
	}

	public static String removerAcentos(String str) {
		return Normalizer.normalize(str.toLowerCase(), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}

}
