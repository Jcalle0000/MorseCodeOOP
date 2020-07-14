public class MorseCode
{
    /* char is a primitive data type used to represent alpha numeric information
       (characters ) // uses the unicode to encode characters
    * */
    private char character;
    private String encoding;

    //2 - parameter constructor - why is this public? - can we omit the public keyword
    public MorseCode(char character, String encoding)
    {
        this.character = character; // for this object we are looking at the character
        this.encoding = encoding;

        try
        {
            if (character < 32 || character > 90)
            {
                throw new IllegalArgumentException(); // not sure why the new is necessary
            }
        }
//            character=temp_1;
        catch (IllegalArgumentException e)
        {
            System.out.printf("%s %s %s %n", "The character", character , "is not a supported Morse Character");
        }

    }

    public char getCharacter()
    {
        return character;
    }

    public String getEncoding()
    {
        return encoding;
    }

    public void setEncoding(String line)
    {
        encoding=line;
    }

    public void setCharacter(char temp_1) throws IllegalArgumentException
    {
        try
        {
            if (temp_1 < 32 || temp_1 > 90)
            {
                throw new IllegalArgumentException(); // not sure why the new is necessary
            }
            else
                character = temp_1;
        }
//            character=temp_1;
        catch (IllegalArgumentException e)
        {
            System.out.printf("%s %s %s %n", "The character", temp_1, "is not a supported Morse Character");
        }
    }

    public static void main(String [] args)
    {
        MorseCodeConvert morseCodeConvert = new MorseCodeConvert("MorseCodes.txt");
        morseCodeConvert.printEncodingList();
        morseCodeConvert.encodeString("Hello what");
        System.out.printf("%n");
        System.out.printf("%s %n","Finis with string");
        morseCodeConvert.encodeFile("Mobile computers.txt");

//    TestMorseConverter object = new TestMorseConverter();

    }

}

