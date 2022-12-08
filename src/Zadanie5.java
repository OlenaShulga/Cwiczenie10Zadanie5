import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Zadanie5 {
    public static void main(String[] args) {
        String acc;
        boolean found = false;
        try(BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("Please, enter 3 first numbers of account : ");
            acc = br1.readLine();
            URL url = new URL("https://ewib.nbp.pl/plewibnra?dokNazwa=plewibnra.txt");
            try (BufferedReader br2 = new BufferedReader(new InputStreamReader(url.openStream()))) {
                String line;
                while ((line = br2.readLine()) != null) {
                    String[] values = line.split("\t");
                    if (values[0].trim().equals(acc)) {
                        System.out.println("\nYour bank is : " + values[1]);
                        found = true;
                        break;
                    }
                }
            }
        }catch(MalformedURLException e){
            System.out.println("Error in url");
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        if(!found)
            System.out.println("You entered wrong value");
    }
}
