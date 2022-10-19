import Exceptions.MissmatchedBracketsException;
import ONP.ONP;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.testng.AssertJUnit.assertEquals;

public class OnpTest {

    @Test
    public void ONPIsGood()
    {
        ONP onp = new ONP();
        onp.setInput("1+15*(2*8)");

        try
        {
            onp.toONP();
        }
        catch (MissmatchedBracketsException e)
        {
            throw new RuntimeException(e);
        }
        assertEquals("[1, 15, 2, 8, *, *, +]",onp.getONP().toString());
    }

    @Test
    public void ONPThrowsMissmatchedBracketsException()
    {
        assertThrows(MissmatchedBracketsException.class, new Executable() {
            @Override
            public void execute() throws Throwable
            {
                ONP a = new ONP();
                a.setInput("(1*(2*3)))");
                a.toONP();
            }
        });
    }
}

