package ONP;

import Exceptions.MissmatchedBracketsException;

import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class ONP implements IONP {

    private String in;
    private List<String> onp = new Vector<>();

    @Override
    public void setInput(String in) {
        this.in = in;
    }

    @Override
    public List<String> getONP() {
        return onp;
    }

    @Override
    public void toONP() throws MissmatchedBracketsException {
        Stack<Character> operators = new Stack<>();
        String temp = "";

        for (int i = 0; i < this.in.length(); i++)
        {

            char character = this.in.charAt(i);

            if (Character.isDigit(character) || character == '.')
            {
                temp += character;
            }
            else
            {

                if (!temp.equals(""))
                {
                    this.onp.add(temp);
                    temp = "";
                }

                if (character == '(')
                {
                    operators.push(character);
                }
                else if (character == ')')
                {
                    Character top;
                    while (true)
                    {
                        try
                        {
                            top = operators.pop();
                        }
                        catch (EmptyStackException e)
                        {
                            throw new MissmatchedBracketsException();
                        }

                        if (top != '(')
                        {
                            this.onp.add(top.toString());
                        }
                        else
                        {
                            break;
                        }
                    }

                }
                else
                {
                    while (!operators.empty() && operators.peek() != '(' && operators.peek() != null && precedence(operators.peek()) > precedence(character))
                    {
                        this.onp.add(operators.peek().toString());
                        operators.pop();
                    }
                    operators.push(character);
                }
            }
        }

        if (!temp.equals(""))
        {
            this.onp.add(temp);
        }

        while (!operators.empty())
        {
            this.onp.add(operators.pop().toString());
        }
    }

    private int precedence(Character c)
    {
        if (c == '+' || c == '-')
        {
            return 2;
        }
        else return 3;
    }
}
