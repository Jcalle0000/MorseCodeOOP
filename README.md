# MorseCodeOOP

Morse code is a method used in telecommunications to encode text as standarized sequences of two different signal durations, called dots and dashes or dits and dahs.

Code is commented for vairables, methods and major steps
java.util.scanner is used to read input from the command line and a textfile

Non-default constructor accepts values b/w 32 and 90 encoding values that are not NULL and of length at least one
If either criteria is NOT met, EXCEPTION is thrown
Message:”𝑇h𝑒 𝑐h𝑎𝑟𝑎𝑐𝑡𝑒𝑟 ≪ 𝑡h𝑒 𝑖𝑛𝑣𝑎𝑙𝑖𝑑 𝑐h𝑎𝑟𝑎𝑐𝑡𝑒𝑟 ≫ 𝑖𝑠 𝑛𝑜𝑡 𝑎 𝑠𝑢𝑝𝑝𝑜𝑟𝑡𝑒𝑑 𝑀𝑜𝑟𝑠𝑒 𝑐h𝑎𝑟𝑎𝑐𝑡𝑒𝑟”

DS: ArrayList
Methods: printEncodingList, encodeString, encodeFile

TestMorseConverter --> MorseCodeConvert -->MorseCode
