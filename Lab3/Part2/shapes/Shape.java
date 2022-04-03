/**
 * Abstract Shape class that implements locatble interface.
 * Has 2 child classes Circle and Rectangle.
 *
 * Name: Anıl İlağa Date: 03.11.2021
 */
package shapes;

public abstract class Shape implements Locatable{
    public int x,y;
    public abstract double getArea();
}

interface Locatable{
    public int getX();
    public int getY();
    public void setLocation(int x,int y);
}
