import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj10825_1 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Student> students = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int korea = Integer.parseInt(st.nextToken());
			int english = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			
			students.add(new Student(name, korea, english, math));
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			sb.append(students.poll().name).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static class Student implements Comparable<Student>{
		String name;
		int korea;
		int english;
		int math;
		
		@Override
		public int compareTo(Student o) {
			if(o.korea == this.korea) {
				if(o.english == this.english) {
					if(o.math == this.math) return this.name.compareTo(o.name);
					return o.math - this.math;
				}
				return this.english - o.english;
			}
			return o.korea - this.korea;
		}

		public Student(String name, int korea, int english, int math) {
			this.name = name;
			this.korea = korea;
			this.english = english;
			this.math = math;
		}
	}
}
