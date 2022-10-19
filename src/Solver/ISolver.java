package Solver;

import Exceptions.WrongExpressionException;

public interface ISolver {
    public Double solve() throws WrongExpressionException;
}
