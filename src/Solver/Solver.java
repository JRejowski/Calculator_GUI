package Solver;

import Exceptions.WrongExpressionException;

import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class Solver implements ISolver{

    private List<String> onp = new Vector<>();

    public void setOnp(List<String> onp)
    {
        this.onp = onp;
    }

    private Double simpleSolve(Double x, Double y, Character z)
    {
        if (z == '+')
        {
            return y + x;
        }
        if (z == '-')
        {
            return y - x;
        }
        if (z == '*')
        {
            return y * x;
        }
        if (z == '/')
        {
            return y / x;
        }

        return 0.;
    }

    @Override
    public Double solve() throws WrongExpressionException
    {
        Stack<Double> numbers = new Stack<>();

        for (int i = 0; i < this.onp.size(); i++)
        {
            double temp;
            try
            {
                temp = Double.parseDouble(this.onp.get(i));
                numbers.push(temp);
            }
            catch (NumberFormatException e)
            {
                Double a;
                Double b;
                try
                {
                    a = numbers.pop();
                    b = numbers.pop();
                }
                catch (EmptyStackException err)
                {
                    throw new WrongExpressionException();
                }

                numbers.push(simpleSolve(a, b, this.onp.get(i).charAt(0)));
            }
        }
        try
        {
            return numbers.elementAt(0);
        }
        catch (ArrayIndexOutOfBoundsException err)
        {
            throw new WrongExpressionException();
        }

    }

}


