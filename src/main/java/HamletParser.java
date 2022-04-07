import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }

    public String ChangeHamletToLeon(){

        if(!FindHoratio(hamletData)) return hamletData;
        return replace_word("Hamlet","Leon");
    }

    public String ChangeHoratioToTariq(){

        if(!FindHoratio(hamletData)) return hamletData;
        return replace_word("Horatio","Tariq");
    }

    public boolean FindHoratio(String text){
        String regex = ".*Horatio.*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        return matcher.find();
    }

    public boolean FindHamlet(String text) {
        String regex = ".*Hamlet.*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        return matcher.find();
    }

    public String replace_word(String old_word, String new_word){

        String text = hamletData+ " ";
        String regex = old_word;
        String new_string = "";

        Pattern pattern = Pattern.compile(regex);

        char c;
        String word = "";

        for(int i=0; i<text.length(); i++){
            c = text.charAt(i);

            if(c==' ' || c=='\n'){
                Matcher matcher = pattern.matcher(word);
                while(matcher.find()){
                    word = replace(word, new_word, matcher.start(), matcher.end());
                }

                if(c=='\n') word+='\n';
                else if(i != text.length()-1)word+= " ";
                new_string += word;

                word = "";
            }else{
                word += c;
            }
        }

        return new_string;
    }

    public String replace(String original, String toBeReplaced, int startIndex, int endIndex){
        String first = "";
        for(int j =0; j<startIndex; j++){
            first += original.charAt(j);
        }
        String second ="";
        for(int j =endIndex; j<original.length(); j++){
            second += original.charAt(j);
        }
        return first+toBeReplaced+second;
    }

}
