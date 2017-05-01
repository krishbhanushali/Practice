import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	
        int[] arr = new int[43391];
        int count = 1;
        boolean kittyTurn = false;
        boolean kattyTurn = false;
        for(int i=1;i<=arr.length;i++){
        	arr[i-1] = i;
        }
        while(arr.length!=1){
        	if(count%2==1)
        		kittyTurn = true;
        	else
        		kattyTurn = true;
        	if(kittyTurn){
        		arr = new Solution().kittyPlaying(arr);
        		System.out.println(arr.length);
        		if(arr.length==1)
        			kittyTurn = true;
        		else
        			kittyTurn = false;
        	}
        	if(kattyTurn){
        		arr = new Solution().kattyPlaying(arr);
        		System.out.println(arr.length);
        		if(arr.length==1)
        			kattyTurn = true;
        		else
        			kattyTurn = false;
        	}
        	count++;
        }
        if(arr.length==1){
        	if(arr[0]%3 == 1){
                System.out.println("Kitty");
            }
            else if(arr[0]%3 == 2){
                System.out.println("Katty");
            }
            else if(arr[0]%3 == 0){
                if(kittyTurn){
                    System.out.println("Kitty");
                }
                if(kattyTurn){
                    System.out.println("Katty");
                }
            }
        }
    }
    
    int[] kittyPlaying(int[] arr){
    	int num1 = 0;
    	int num2 = 0;
    	int sum = 0;
    	int[] newArr = arr;  
    	if(newArr.length!=1){
    		for(int i=0;i<=newArr.length-1;i++){
    			for(int j=0;j<newArr.length-1;j++){
    				if(i!=j){
    					num1 = newArr[i];
    					num2 = newArr[j];
    					sum = getSum(newArr, num1, num2);
    					if(sum%3==1){
    						break;
    					}
    				}
    			}
    		}
    		
    		newArr = new int[arr.length-1];
	    	int diff = num1 - num2;
	    	for(int i=0;i<=newArr.length-1;i++){
	    		if(arr[i]==num1){
	    			newArr[i] = diff;
	    		}
	    		if(arr[i]!=num2){
	    			for(int j=0;j<=newArr.length-1;j++){
	    				if(newArr[j]==0){
		    				newArr[j] = arr[i];
		    				break;
	    				}
	    			}
	    		}
	    	}
    	}
    	return newArr;
    }
    int[] kattyPlaying(int[] arr){
    	int num1 = 0;
    	int num2 = 0;
    	int sum = 0;
    	int[] newArr = arr;
    	if(newArr.length!=1){
    		for(int i=0;i<=newArr.length-1;i++){
    			for(int j=0;j<newArr.length-1;j++){
    				if(i!=j){
    					num1 = newArr[i];
    					num2 = newArr[j];
    					sum = getSum(newArr, num1, num2);
    					if(sum%3==1){
    						break;
    					}
    				}
    			}
    		}
    		newArr = new int[arr.length-1];
	    	int diff = num1 - num2;
	    	for(int i=0;i<=newArr.length-1;i++){
	    		if(arr[i]==num1){
	    			newArr[i] = diff;
	    		}
	    		if(arr[i]!=num1 && arr[i]!=num2){
	    			for(int j=0;j<=newArr.length-1;j++){
	    				if(newArr[j]==0){
		    				newArr[j] = arr[i];
		    				break;
	    				}
	    			}
	    		}
	    	}    	
    	}
    	return newArr;
    }
    int getSum(int[] arr,int num1,int num2){
    	int sum = 0;
    	for(int i =0;i<arr.length;i++){
    		if(arr[i]!=num1 && arr[i]!=num2)
    			sum+=arr[i];
    	}
    	sum = sum + (num1-num2);
    	return sum;
    }
    int chooseNumber2(int[] arr, int num1){
    	Random ran = new Random();
    	int num2 = ran.nextInt(arr.length)+arr[0];
    	if(num1==num2){
    		return chooseNumber2(arr, num1);
    	}
    	return num2;
    }
    int chooseNumber1(int[] arr){
    	Random ran = new Random();
    	int num1 = ran.nextInt(arr.length)+arr[0];
    	return num1;
    }
}