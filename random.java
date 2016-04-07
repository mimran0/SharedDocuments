package P;




import java.util.Random;

public class random {

	public static void main(String[] args) {

		int a[]=new int[11];
		
		Random rm=new Random();
	
		 //System.out.println(rm.getClass());
		for (int i=1;i<11;i++){
		 int abc = rm.nextInt();
		System.out.println(abc);
		a[i]=abc;
		System.out.println(i+ " index holds the value : "+a[i]);
		}
		
		
		for (int abc:a){
			
			System.out.println(abc);
		}
		
	}

}
