//Visa Identity Access Management Dev - VE

import java.util.*;

interface Rectangle {  
    public int area(int height, int width);
}  

interface Circle {
    public double area(int radius);
}


//Java Interface II
// Geometry "implements" the Rectangle and Circle interface
class Geometry implements Rectangle, Circle {
    public int area(int height, int width) {
        return height * width;
    }
    
    public double area(int radius) {
        return 3.14 * radius*radius;
    }
}

public class Solution {
    public static void main(String[] args) {
        Geometry g = new Geometry();
        System.out.println("I implemented: ");	
        implementedInterfaceNames(g);
        
        Scanner in = new Scanner(System.in);
        int height = in.nextInt();
        int width = in.nextInt();
        int radius = in.nextInt();
        System.out.println("Rectangle area = " + g.area(height,width));
        System.out.println("Circle area = " + g.area(radius));
        in.close();
    }
    
    /*
    *  Takes an Object and prints the name of the interfaces it implemented
    */
    static void implementedInterfaceNames(Object o) {
        Class[] interfaces = o.getClass().getInterfaces();
        Arrays.sort(interfaces, new Comparator<Class>() {
            public int compare(Class o1, Class o2) {
                return o1.getName().compareTo(o2.getName());
            }
        } );
        for (Class c : interfaces) {
            System.out.println(c.getName());
        }
    }
}