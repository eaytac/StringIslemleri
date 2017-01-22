package com.vektorel.java.string;

public class StringIslemleri {

	public static void main(String[] args) {
		final String metin = 
				"#PatNo:1234@Pat: Taner TEMEL@Age:45@HBG:65@AG:45@#"
				+ "#PatNo:1235@Pat: Kemal TEMEL@Age:34@HBG:65@AG:45@#"
				+ "#PatNo:1236@Pat: Cemal TEMEL@Age:23@HBG:65@AG:45@#"
				+ "#PatNo:1237@Pat: Ayþe TEMEL@Age:5@HBG:65@AG:45@#"
				+ "#PatNo:1238@Pat: Fatma TEMEL@Age:75@HBG:65@AG:45@#";
	
		String[] satirlar = metin.split("#");
		
		for (int i = 0; i < satirlar.length; i++) {
			String[] kelimeler = satirlar[i].split("@");

			for (int j = 0; j < kelimeler.length; j++) {
				System.out.println("Hasta No: " + kelimeler[j].split(":")[1]);
				System.out.println("Adý Soyadý: ");
				System.out.println("Yaþý: ");
				System.out.println("HBG: ");
				System.out.println("AG: ");			
			}
			
			
		}
		
		
	
	}
	

}
