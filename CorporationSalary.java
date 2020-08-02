package hblee;

public class CorporationSalary {

//	static String[] realations = {"NNYN","NNYN","NNNN","NYYN"};
	static String[] realations = {"NNNNN",
								 "YNYNNY",
								 "YNNNNY",
								 "NNYNNN",
								 "YNYNNN",
								 "YNNYNN",
								 };
	static long[] arr = new long[realations.length];

	public static void main(String[] args) {
		CorporationSalary cs = new CorporationSalary();

		cs.totalSalary(realations);
		
	}
	
	public long totalSalary(String[] relations) {
		long sum = 0;

		for(int i=0; i<realations.length; i++) {
			sum += dfs(i);
		}
	
		for (int i = 0; i < relations.length; i++) {
			System.out.print(arr[i]);
		}
		System.out.println(" "+sum);
		return sum;
	}
	
	long dfs(int i) {
		if(arr[i] != 0) return arr[i];
	
		if(realations[i].indexOf('Y'-0) == -1) {
			arr[i] = 1;
			return arr[i];
		}

		for(int j = 0; j< realations.length;j++) {
			System.out.println(i+"_"+realations[i].charAt(j));
			if(realations[i].charAt(j) =='Y') {
				arr[i] +=  dfs(j);
			}
		}

		return arr[i];
	}
}
