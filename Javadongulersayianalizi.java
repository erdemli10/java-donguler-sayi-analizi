
import java.util.Scanner;

public class Javadongulersayianalizi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] sayilar = new int[100];
        int adet = 0;

        System.out.println("Sayilari girin, bitirmek icin 0 a bas");

        int s = 1;
        while (s != 0) {
            System.out.print("Sayi: ");
            s = sc.nextInt();

            if (s != 0) {
                if (adet < 100) {
                    sayilar[adet] = s;
                    adet++;
                }
            }
        }

        boolean devam = true;
        if (adet == 0) {
            System.out.println("Hic sayi girmediniz");
            devam = false;
        }

        if (devam) {
            int poz = 0;
            int neg = 0;
            int tek = 0;
            int cift = 0;
            int toplam = 0;
            int max = sayilar[0];
            int min = sayilar[0];

            for (int i = 0; i < adet; i++) {
                int sayi = sayilar[i];
                toplam += sayi;

                if (sayi > 0) {
                    poz++;
                } else {
                    if (sayi < 0) {
                        neg++;
                    }
                }

                if (sayi % 2 == 0) {
                    cift++;
                } else {
                    tek++;
                }

                if (sayi > max) {
                    max = sayi;
                }
                if (sayi < min) {
                    min = sayi;
                }
            }

            double ort = (double) toplam / adet;

            System.out.println("\nBilgiler:");
            System.out.println("Toplam sayi adedi: " + adet);
            System.out.println("Pozitif sayi: " + poz);
            System.out.println("Negatif sayi: " + neg);
            System.out.println("Tek sayi: " + tek);
            System.out.println("Cift sayi: " + cift);
            System.out.println("En buyuk sayi: " + max);
            System.out.println("En kucuk sayi: " + min);
            System.out.println("Toplam: " + toplam);
            System.out.println("Ortalama: " + ort);

            System.out.println("\nOzel Durumlar:");
            for (int i = 0; i < adet; i++) {
                int sayi = sayilar[i];
                
                boolean asal = true;
                if (sayi <= 1) {
                    asal = false;
                } else {
                    for (int j = 2; j < sayi; j++) {
                        if (sayi % j == 0) {
                            asal = false;
                            break;
                        }
                    }
                }

                boolean mukemmel = false;
                if (sayi > 1) {
                    int bolenToplami = 0;
                    for (int j = 1; j <= sayi / 2; j++) {
                        if (sayi % j == 0) {
                            bolenToplami += j;
                        }
                    }
                    if (bolenToplami == sayi) {
                        mukemmel = true;
                    }
                }

                int bas = 0;
                int temp = sayi;
                if (temp == 0) {
                    bas = 1;
                } else {
                    if (temp < 0) {
                        temp = -temp;
                    }
                    while (temp > 0) {
                        temp = temp / 10;
                        bas++;
                    }
                }

                String asalYazi = "Hayir";
                if (asal) {
                    asalYazi = "Evet";
                }

                String mukemmelYazi = "Hayir";
                if (mukemmel) {
                    mukemmelYazi = "Evet";
                }

                System.out.println("Sayi: " + sayi + " Asal: " + asalYazi + " Mukemmel: " + mukemmelYazi + " Basamak: " + bas);
            }
        }
    }
}