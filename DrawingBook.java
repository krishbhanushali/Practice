
import java.util.*;
/*
 Brie’s Drawing teacher asks her class to open their -page book to page number . Brie can either start turning pages from the front of the book (i.e., page number ) or from the back of the book (i.e., page number ), and she always turns pages one-by-one (as opposed to skipping through multiple pages at once). When she opens the book, page  is always on the right side:

image

Each page in the book has two sides, front and back, except for the last page which may only have a front side depending on the total number of pages of the book (see the Explanation sections below for additional diagrams).

Given n and p, find and print the minimum number of pages Brie must turn in order to arrive at page .
 * */
public class DrawingBook {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        // your code goes here
        int countFromFront = 0;
        int countFromBack = 0;
        for(int i = 1 ; i < n ; i=i+2){
            if(i>=p){
                break;
            }
            else{
                countFromFront++;
            }
        }
        for(int i = n ; i > 0 ; i=i-2){
            if(i<=p+1){
                break;
            }
            else{
                countFromBack++;
            }
        }
        System.out.println(Math.min(countFromBack,countFromFront));
        in.close();
    }
}
