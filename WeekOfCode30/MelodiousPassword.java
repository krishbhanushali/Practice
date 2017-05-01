package WeekOfCode30;

import java.util.Scanner;

public class MelodiousPassword {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		char[] vowels = {'a','e','i','o','u'};
		char[] consonants = {'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','z'};
		if(n==1){
			for(int i = 0 ; i < consonants.length;i++)
				System.out.println(consonants[i]);
			for(int i = 0; i<vowels.length;i++)
				System.out.println(vowels[i]);
		}
		if(n==2){
			for(int i = 0 ; i < consonants.length;i++)
				for(int j =0;j<vowels.length;j++)
					System.out.println(""+consonants[i]+vowels[j]);
			for(int i = 0 ; i < vowels.length;i++)
				for(int j=0;j<consonants.length;j++)
					System.out.println(""+vowels[i]+consonants[j]);
		}
		if(n==3){

			for(int i = 0 ; i < consonants.length;i++)
				for(int j =0;j<vowels.length;j++)
					for(int k = 0; k < consonants.length;k++)
						System.out.println(""+consonants[i]+vowels[j]+consonants[k]);
			for(int i = 0 ; i < vowels.length;i++)
				for(int j=0;j<consonants.length;j++)
					for(int k = 0 ; k<vowels.length;k++)
						System.out.println(""+vowels[i]+consonants[j]+vowels[k]);
		}
		if(n==4){
			for(int i = 0 ; i < consonants.length;i++)
				for(int j =0;j<vowels.length;j++)
					for(int k = 0; k < consonants.length;k++)
						for(int l=0;l<vowels.length;l++)
							System.out.println(""+consonants[i]+vowels[j]+consonants[k]+vowels[l]);
			for(int i = 0 ; i < vowels.length;i++)
				for(int j=0;j<consonants.length;j++)
					for(int k = 0 ; k<vowels.length;k++)
						for(int l =0;l<consonants.length;l++)
							System.out.println(""+vowels[i]+consonants[j]+vowels[k]+consonants[l]);
		}
		if(n==5){
			for(int i = 0 ; i < consonants.length;i++)
				for(int j =0;j<vowels.length;j++)
					for(int k = 0; k < consonants.length;k++)
						for(int l=0;l<vowels.length;l++)
							for(int m=0;m<consonants.length;m++)
								System.out.println(""+consonants[i]+vowels[j]+consonants[k]+vowels[l]+consonants[m]);
			for(int i = 0 ; i < vowels.length;i++)
				for(int j=0;j<consonants.length;j++)
					for(int k = 0 ; k<vowels.length;k++)
						for(int l =0;l<consonants.length;l++)
							for(int m = 0;m<vowels.length;m++)
								System.out.println(""+vowels[i]+consonants[j]+vowels[k]+consonants[l]+vowels[m]);
		}
		if(n==6){
			for(int i = 0 ; i < consonants.length;i++)
				for(int j =0;j<vowels.length;j++)
					for(int k = 0; k < consonants.length;k++)
						for(int l=0;l<vowels.length;l++)
							for(int m=0;m<consonants.length;m++)
								for(int o=0;o<vowels.length;o++)
								System.out.println(""+consonants[i]+vowels[j]+consonants[k]+vowels[l]+consonants[m]+vowels[o]);
			for(int i = 0 ; i < vowels.length;i++)
				for(int j=0;j<consonants.length;j++)
					for(int k = 0 ; k<vowels.length;k++)
						for(int l =0;l<consonants.length;l++)
							for(int m = 0;m<vowels.length;m++)
								for(int o=0;o<consonants.length;o++)
								System.out.println(""+vowels[i]+consonants[j]+vowels[k]+consonants[l]+vowels[m]+consonants[o]);
		}
		/*else{
			for(int i = 0 ; i < consonants.length-1;i++){
				int tempI = i+1;
				
				for(int j = 0 ; j < vowels.length-1;j++){
					int tempJ = j+1;
					String str1 = "";
					String str3 = "";
					for(int k=n;k>0;k=k-2){
						if(k>=2){
							str1+=""+vowels[j]+consonants[i];
							str3+=""+vowels[j]+consonants[tempI];
						}
						else{
							str1+=""+vowels[j];
							str3+=""+vowels[tempJ];
						}
						tempI++;
						tempJ++;
					}
					System.out.println(str1);
					String str2 = "";
					for(int k = n ; k >0;k=k-2){
						if(k>=2){
							str2+=""+consonants[i]+vowels[j];
						}
						else{							
							str2+=""+consonants[i];
						}
					}
					System.out.println(str2);
				}
			}
		}*/
		
		scanner.close();
	}
}
