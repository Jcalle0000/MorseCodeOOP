import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConvert
{
    final ArrayList<MorseCode> listMorseCodes=new ArrayList<>();
    // Pros about arraylist over regular arrays is that theyre dynamic, they can increase or decrease
    // This arraylist will hold the objects of type Morsecode

    public MorseCodeConvert(String fileName) // throws FileNotFoundException// fileName=MorseCode.txt
    {
        try
        {
            File file = new File(fileName);
            // Would everything after this point stop working since fileName wasent found?
            Scanner sc = new Scanner(file);
            char letter;
            String substring;
            int i=0;
         //   MorseCode temp = new MorseCode('h', "..." ); // initialzing object
            while (sc.hasNextLine() )
            {
                substring = sc.nextLine();
                if(substring.length()>2) // means we have a character a starting the string
                {
                    MorseCode temp = new MorseCode(substring.charAt(0), substring.substring(2) ); // objects need to be built
//                    temp.setCharacter(substring.charAt(0) );          // setCharacter has error message //  objects can have the same name
//                    temp.setEncoding(substring.substring(2));
                    listMorseCodes.add( temp ) ; // would we be adding the same object?
//                    System.out.printf("%s %s %n",temp.getCharacter(),temp.getEncoding() );
                    i++;                         // and therefore our arraylist would be 1?
                } // end of if block
            } // end of while block
//            sc.close();
//            System.out.printf("%s %n","Success!");
        } // end of try block

        catch (FileNotFoundException e)
        {
            System.out.printf("%s %s  %n","Failed to open file: ", fileName);
        }

    }

    /*Expected Outcome
The character \ is not a supported Morse Character
The character ^ is not a supported Morse Character
The character ` is not a supported Morse Character
     */

    public void printEncodingList()
    {
//        System.out.printf("%s %n",listMorseCodes.size() );
        for(int i=0;i<listMorseCodes.size();i++)
        {
            MorseCode morseCode = listMorseCodes.get(i);
            System.out.printf("%10s %10s %n", morseCode.getCharacter(),morseCode.getEncoding() );
        }
    }


    //ArrayIndexoutofBounds - need to understand why j++ is increasing too much
    // what about a string with multiple words?

    public void encodeString (String input)
    {

        ArrayList<MorseCode> temporary=new ArrayList<>();

        input=input.toUpperCase(); // Always capitializing the string
        char object;
        char[] arrLetters = input.toCharArray(); // the string is then divded into individual char letters

        // check if letter is in morsecode
        MorseCode morseCode = new MorseCode('B',"...");// initialzing datatype
        int j=0;
        while(j<arrLetters.length)
        {
            if(arrLetters[j] == ' ')
            {
                morseCode.setCharacter(' ');
                morseCode.setEncoding(" ");
                temporary.add(morseCode);
            }

            for (int i = 0; i < listMorseCodes.size(); i++)
            {
                morseCode = listMorseCodes.get(i); // will iterate though the list, checking one by one
                // System.out.printf("%10s %10s %n", morseCode.getCharacter(),morseCode.getEncoding() );
                if (arrLetters[j] == morseCode.getCharacter())
                {
                    temporary.add(morseCode);
//                    j++;
                }
            }

            j++; // after finishing going through the foor loop, it will go the next character
//            System.out.printf("%n"); // new line to indicate that its a new word
        }

        for(int i=0;i<temporary.size();i++)
        {
            morseCode=temporary.get(i);
            System.out.printf(" %s" ,morseCode.getEncoding() );
        }

    }

    public void encodeFile(String fileName) // throws FileNotFoundException
    {
        try
        {
            File file = new File(fileName);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String input;
            while ( (input=br.readLine()) != null)
            {
//
//                System.out.printf("%s %n",input);
                encodeString( input );
                System.out.printf("%n");
            }
            System.out.printf("%n");

        }
        catch(IOException e)
        {
            System.out.println("Error file not found");
        }
    }


}



