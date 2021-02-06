import java.util.Scanner;

public class Main {

	static int[][] rushHour= {{420,600},{900,1140}};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int startTime=readInput();
		if (startTime<rushHour[0][1]) {
			int endTime=getEndTime(startTime,rushHour[0]);
			printTime(endTime);
		} else if (startTime<rushHour[1][1]) {
			int endTime=getEndTime(startTime,rushHour[1]);
			printTime(endTime);
		} else {
			printTime(startTime+120);
		}

	}
	private static int getEndTime(int startTime, int[] rushHour) {
		// TODO Auto-generated method stub
		//distance unit: distance/min in rush hour. total distance: 120*2
		int t1=rushHour[0]-startTime;
		if (t1<0) t1=0;
		int remainDistance=240;
		if (t1>=2) {
			return (startTime+t1);
		}
		
		remainDistance-=t1*2;
		int t2=rushHour[1]-rushHour[0];
		if (remainDistance<=t2*1) {
			t2=remainDistance/1;
		} 
		remainDistance-=t2*1;
		if (remainDistance<=0) {
			return startTime+t1+t2;
		}
		int t3=remainDistance/2;
		return (startTime+t1+t2+t3);
		
		
		
	}
	private static void printTime(int time) {
		// TODO Auto-generated method stub

		int h=time/60;
		int m=time%60;
		
		System.out.printf("%02d:%02d\n\r",h%24,m);
		
	}
	private static int readInput() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String line=sc.nextLine();
		String[] sAr=line.split(":");
		return Integer.parseInt(sAr[0])*60+Integer.parseInt(sAr[1]);
	}

}
