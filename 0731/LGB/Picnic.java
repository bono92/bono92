import java.util.Scanner;

public class Picnic {
 static Scanner s = new Scanner(System.in);
 static int T;
 static int stuNum;
 static int pairs;
 static int[] stuCount = new int[10];
 static int[][] studPair = new int[10][10];
 static int ans;
 
 static void findPair(int x) {
  
  //다 세면 ans 올리고 나감
  for(int i=0 ; i<stuNum; i++) {
   if(stuCount[i] == 1) {
    if(i==stuNum-1) {
     for(int tt=0; tt<10; tt++) {
      System.out.print(stuCount[tt]);
     }
     System.out.println();
     ans++;
     return;
    }
   }else break; 
  }
  
  //찾기
  while(x<stuNum) {
   for(int i=0; i<stuNum; i++) {
    
    System.out.println("x, y:"+x+" "+i);
    if(studPair[x][i] == 1 && stuCount[x] != 1 && stuCount[i] != 1) {
     stuCount[x] = stuCount[i] = 1;
     System.out.println("found!");
     findPair(++x);
     --x;
     stuCount[x] = stuCount[i] = 0;
    } 
   }
   x++;
  }
 }
 
 public static void main(String[] args) {
  T = s.nextInt();
  
  for(int testCase=0; testCase<T; testCase++) {
   //배열 초기화
   for(int i=0; i<10; i++) {
    for(int j=0; j<10; j++)
     studPair[i][j] = 0;
    stuCount[i] = 0;
   }
   ans = 0;
   
   stuNum = s.nextInt();
   pairs = s.nextInt();
   
   for(int pairsNum=0; pairsNum<pairs; pairsNum++) {
    studPair[s.nextInt()][s.nextInt()] = 1;
   }
   
   //찾기 디스이스레알
   findPair(0);
   
  }
  
  
  
  System.out.println("ans: "+ans);
 }

