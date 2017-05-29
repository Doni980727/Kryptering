import java.io.*;
import java.nio.file.DirectoryNotEmptyException;

/**
 * Created by Fedi14 on 2017-05-12.
 */
public class Filhanterare {
    public static void main(String[] args) throws IOException {

        String filnamn = "minfil.txt";
        String nyckelFil = "nyckel.txt";

        try {

            FileReader fr = new FileReader(filnamn);

            BufferedReader inFil = new BufferedReader(fr);

            FileReader fr2 = new FileReader(nyckelFil);

            BufferedReader keyFil = new BufferedReader(fr2);

// Nu kan inFil användas för att läsa från filen

            String rad = inFil.readLine();
            String rad2 = keyFil.readLine();

// Om filen är slut blir rad null och vi måste sluta

            while (rad != null) {

                String result = "";
                for(int i = 0; i < rad.length(); i++) {
                    result += (char)((rad.charAt(i) ^ rad2.charAt(i)));
                }

                String content = result;

                File file = new File("crypted.txt");
                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);

                bw.write(content);
                bw.close();



                rad = inFil.readLine();


            }



// För att det inte ska bli problem med systemet stängsfilen

// när den inte ska användas längre

            inFil.close();
            keyFil.close();

        }

        catch(FileNotFoundException e1) {

            System.out.println("Filen hittades inte!");

        }

        catch(IOException e2) {

            System.out.println(e2);

        }

    }

}
