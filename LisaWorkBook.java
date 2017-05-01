import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LisaWorkBook {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int chapters = scanner.nextInt();
        int problemsPerPage = scanner.nextInt();
        int pageNo = 1;
        int[] noOfProblems = new int[chapters];
        for(int i = 0 ; i < chapters;i++){
        	noOfProblems[i] = scanner.nextInt();
        }
        int currentPage = 1;
        int pages = 1;
        for(int i = 0 ; i < noOfProblems.length;i++){
        	int pagesNeeded = 0;
        	if(noOfProblems[i]<problemsPerPage)
        		pagesNeeded = 1;
        	else{
        		pagesNeeded = noOfProblems[i]/problemsPerPage;
        		if(pagesNeeded!=0)
        			pagesNeeded++;
        	}
        	pages +=pagesNeeded;
        	while(currentPage<=pages){
        		if(currentPage>noOfProblems[i])
        			break;
        	}
        	
        }
        scanner.close();
    }
}