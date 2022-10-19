package ONP;

import Exceptions.MissmatchedBracketsException;

import java.util.List;

public interface IONP {
    public void setInput(String input);
    public List<String> getONP();
    public void toONP() throws MissmatchedBracketsException;
}