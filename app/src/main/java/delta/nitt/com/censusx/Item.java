package delta.nitt.com.censusx;

import java.util.ArrayList;

/**
 * Created by rb on 12/12/15.
 */
public class Item
{
    String title;
    String text;
    String subtext;
    ArrayList<String> array1;
    ArrayList<String> array2;
    String descp;

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public ArrayList<String> getArray1()
    {
        return array1;
    }

    public void setArray1(ArrayList<String> array1)
    {
        this.array1 = array1;
    }

    public ArrayList<String> getArray2()
    {
        return array2;
    }

    public void setArray2(ArrayList<String> array2)
    {
        this.array2 = array2;
    }

    public String getDescp()
    {
        return descp;
    }

    public void setDescp(String descp)
    {
        this.descp = descp;
    }

    public String getSubtext()
    {
        return subtext;
    }

    public void setSubtext(String subtext)
    {
        this.subtext = subtext;
    }
}
