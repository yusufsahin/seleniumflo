package tr.com.flo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        int a = 5;
        double b=5;
        float c= 5F;
        byte d= 127;
        boolean e=true;
        String isim= "John Doe";

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(isim);

        if(a>0)
        {
            System.out.println("a pozitif bir sayıdır");
        }
        else {
            System.out.println("a negatif bir sayıdır");
        }

        int ay = 4;
        switch (ay) {
            case 1: System.out.println("Ocak");
                break;
            case 2: System.out.println("Şubat");
                break;
            case 3: System.out.println("Mart");
                break;
            case 4: System.out.println("Nisan");
                break;
            // Diğer aylar için case'ler eklenebilir
            default: System.out.println("Geçersiz ay");
        }

        int not = 85;

        if (not >= 90) {
            System.out.println("Harf notunuz: A");
        } else if (not >= 80) {
            System.out.println("Harf notunuz: B");
        } else if (not >= 70) {
            System.out.println("Harf notunuz: C");
        } else if (not >= 60) {
            System.out.println("Harf notunuz: D");
        } else {
            System.out.println("Harf notunuz: F");
        }

        for (int i = 1; i <= 5; i++) {
            System.out.println("i'nin değeri: " + i);
        }

        int i = 0;

        while (i < 5) {
            System.out.println("i'nin değeri: " + i);
            i++;
        }
        int x = 0;

        do {
            System.out.println("x'nin değeri: " + x);
            x++;
        } while (x < 5);

        System.out.println(topla(5,4));

        Musteri musteri= new Musteri();
        musteri.setId(1);
        musteri.setAd("John");
        System.out.println(musteri.getAd());

        musteri.setAd("Jane");
        System.out.println(musteri.getAd());

        Musteri m2= new Musteri(2);



    }

    static int topla(int a, int b)
    {
        return  a+b;
    }
}
