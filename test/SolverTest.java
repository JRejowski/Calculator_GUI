import Exceptions.MissmatchedBracketsException;
import Exceptions.WrongExpressionException;
import ONP.ONP;
import Solver.Solver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SolverTest {

    @Test
    public void testSolverEasy()
    {
        ONP ONP = new ONP();
        ONP.setInput("2+3+76");

        try
        {
            ONP.toONP();
        }
        catch (MissmatchedBracketsException e)
        {
            throw new RuntimeException(e);
        }
        Solver a = new Solver();
        a.setOnp(ONP.getONP());

        try
        {
            assertEquals(81,a.solve());
        }
        catch (WrongExpressionException e)
        {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void testSolverWithBrackets()
    {
        ONP ONP = new ONP();
        ONP.setInput("(2*8)+3");
        try
        {
            ONP.toONP();
        }
        catch (MissmatchedBracketsException e)
        {
            throw new RuntimeException(e);
        }

        Solver a = new Solver();
        a.setOnp(ONP.getONP());

        try
        {
            assertEquals(19,a.solve());
        }
        catch (WrongExpressionException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testSolverLongerExpression()
    {
        ONP onp = new ONP();
        onp.setInput("((2*2)+3*3+(10/4)+(8/10))");

        try
        {
            onp.toONP();
        }
        catch (MissmatchedBracketsException e)
        {
            throw new RuntimeException(e);
        }

        Solver a = new Solver();
        a.setOnp(onp.getONP());

        try
        {
            assertEquals(16.3,a.solve());
        }
        catch (WrongExpressionException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testItThrowsExceptionOnWrongExpressionException()
    {
        assertThrows(WrongExpressionException.class, new Executable()
        {
            @Override
            public void execute() throws Throwable
            {
                ONP a = new ONP();
                a.setInput("testing");
                a.toONP();
                Solver solver = new Solver();
                solver.setOnp(a.getONP());
                solver.solve();

            }
        });
    }
}

