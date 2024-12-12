package Exceptions;
/*
Section 11: Handling Exception
Topic: Describe Exception Handling and types of exceptions
Sub-Topic: Methods with throws Clause
S1: Execute initially catch(Throwable e), S2: change Throwable to RTE, compiler error in methodthree throwable
so add throws clause in declaration of main method throws Throwable. Now, execution gets stopped after method3.
S3: Add 3 catch clause including RTE, S4: Order of execution is important from most specific to least specific
what if we have RTE and customRTE, then compiler error occurs order important change it ot customRTE , RTE
S5: Throw ACustomRunTimeException in methodTwo
S6: Handle multiple exceptions in methodThree
 */
public class ThrowClauseExample {
    // Custom RunTimeException
    class ACustomRunTimeException extends RuntimeException{
        ACustomRunTimeException(String message){
            super(message);
        }
    }
    // Custom Exception (not RunTimeException)
    class ACustomCheckedException extends Exception{
        ACustomCheckedException(String message){
            super(message);
        }
    }
    // Custom Throwable
    class ACustomThrowable extends Throwable{
        ACustomThrowable(String message){
            super(message);
        }
    }
    // Custom Error
    class AnError extends Error{
        AnError(String message){
            super(message);
        }
    }
    public static void main(String[] args){
        ThrowClauseExample t = new ThrowClauseExample();

        // for loop allows to test each exception throws
        for (int i = 0; i < 4; i++){
            try{
                switch (i){
                    case 0:
                        t.methodOne();
                        break;
                    case 1:
                        t.methodTwo();
                        break;
                    case 2:
                        t.methodThree();
                        break;
                    case 3:
                        t.methodFour();
                        break;
                }
                // Catch clause is inside for loop, so execution of
                // for loop continues after we catch the exception.
            }
//            catch (RuntimeException e){
//                System.out.println("In the catch clause of main(): "+e);
//            }
            catch (ACustomThrowable e){
                System.out.println("In the catch clause for ACustomThrowable in main(): "+e);
            }catch (AnError e){
                System.out.println("In the catch clause for AnError in main(): "+e);
            }catch (ACustomRunTimeException e){
                System.out.println("In the catch clause of ACustomRunTimeException(): "+e);
            }catch (RuntimeException e){
                System.out.println("In the catch clause of main(): "+e);
            }

        }
    }

    // Unchecked Runtime Exception Throws
    private void methodOne() {
        throw new ACustomRunTimeException("Error in methodOne");
    }

    // Checked - must satisfy catch or specify - here we catch.
    private void methodTwo() {
        try {
            throw new ACustomCheckedException("Error in methodTwo");
        } catch (Exception e) {
            System.out.println("In the catch clause of methodTwo(): "+e);
            throw new ACustomRunTimeException("Changed methodTwo to throw ACustomRuntimeExcpetion");
        }
    }

    // Checked - must satisfy the catch or specify - here we specify in the throws clause
//    private void methodThree() throws ACustomThrowable {
//        throw new ACustomThrowable("Error in methodThree");
//    }
    private void methodThree() throws ACustomThrowable,ACustomRunTimeException {
        if (10%3==0)
            throw new ACustomThrowable("Error in methodThree");
        else
            throw new ACustomRunTimeException("Error in methodThree");
    }

    // Unchecked Error thrown
    private void methodFour() {
        throw new AnError("Error in methodFour");
    }

}
