package Exceptionhandling;

public class ExceptionHandling
{
    public static void main(String[] args) throws ClassNotFoundException
    {
//        try
//        {
//            int result = 10/0;
//        }
//        catch (ArrayIndexOutOfBoundsException e)
//        {
//            System.out.println(e.getMessage()+" oob");
//        }
//        catch(RuntimeException e)
//        {
//            System.out.println(e.getMessage()+" runtime");
//        }
//        catch (Exception e)
//        {
//            System.out.println(e.getMessage()+" general");
//        }
//        finally {
//            System.out.println("hello");
//        }

        ExceptionPropogation exceptionPropogation = new ExceptionPropogation();
        exceptionPropogation.example();

//            throw new InsufficientFundsException(23.25);
    }
}

//custom exceptions
class InsufficientFundsException extends RuntimeException
{
    private double amount;
    public InsufficientFundsException(double amount)
    {
        super("Insufficeint fund amount"+ amount);
    }
}

//exception propogation
//checked or compiler exception
class ExceptionPropogation
{
    public void example() throws ClassNotFoundException {
        throw new ClassNotFoundException();
    }
}





