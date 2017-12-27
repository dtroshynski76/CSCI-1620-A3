package exceptions;

public class InvalidCharacterException extends RuntimeException
{
    public InvalidCharacterException(char c)
    {
        super("Invalid Character " + c);
    }
}
