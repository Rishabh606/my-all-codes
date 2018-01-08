package collegework;

import java.util.Scanner;
import java.util.Arrays;
 
/* Name - Rishabh Gupta
 Rollno- 16CS01018*/
 
class Point
{
    int x, y;
}
 

public class convexhull
{    
    private boolean CCW(Point p, Point q, Point r)
    {
        int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
 
         if (val >= 0)
             return false;
         return true;
    }
    public void convexHull(Point[] points)
    {
        int n = points.length;
        // if less than 3 points return         
        if (n < 3) 
            return;     
        int[] next = new int[n];
        Arrays.fill(next, -1);
 
//         find the leftmost point 
        int leftMost = 0;
        for (int i = 1; i < n; i++)
            if (points[i].x < points[leftMost].x)
                leftMost = i;
        int p = leftMost, q;
//         iterate till p becomes leftMost 
        do
        {
            // wrapping 
            q = (p + 1) % n;
            for (int i = 0; i < n; i++)
              if (CCW(points[p], points[i], points[q]))
                 q = i;
 
            next[p] = q;  
            p = q; 
        } while (p != leftMost);
 
//         Display result 
        display(points, next);
    }
    public void display(Point[] points, int[] next)
    {
        System.out.println("\nConvex Hull points : ");
        for (int i = 0; i < next.length; i++)
            if (next[i] != -1)
               System.out.println("("+ points[i].x +", "+ points[i].y +")");
    }
    
    public static void main (String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("convexhull Algorithm Test\n");
        // Make an object of convexhull class 
        convexhull j = new convexhull();        
 
        System.out.println("Enter number of points n :");
        int n = scan.nextInt();
        Point[] points = new Point[n];
        System.out.println("Enter "+ n +" x, y cordinates");
        for (int i = 0; i < n; i++)
        {
            points[i] = new Point();
            points[i].x = scan.nextInt();
            points[i].y = scan.nextInt();
        }        
        j.convexHull(points);        
    }
}