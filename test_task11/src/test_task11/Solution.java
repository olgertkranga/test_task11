package test_task11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;

public class Solution {

	public static void main(String[] args) {

		String shaStr;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {

			shaStr = br.readLine();

			System.out.println(sha256(shaStr));

		} catch (IOException ioe) {
			System.out.println(ioe);
		}

	}

	public static String sha256(String base) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(base.getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer();

			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}

			return hexString.toString();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

}