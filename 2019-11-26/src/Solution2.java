import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
class Student{
    String name;
    int score;

    public Student(String name,int score) {
        this.name = name;
        this.score=score;
    }
}
public class Solution2 {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        while(input.hasNext()){
            int n=input.nextInt();
            int k=input.nextInt();
            List<Student> list=new ArrayList<>();
            for(int i=0;i<n;i++){
                list.add(new Student(input.next(),input.nextInt()));
            }
            //降序
            if(k==0) {
                list.sort((o1, o2) -> o2.score - o1.score);
            } else{//升序
                list.sort((o1,o2) -> o1.score-o2.score);
            }
            for(Student student :list ){
                System.out.println(student.name+" "+student.score);
            }
        }
    }

    private static int compare(Student o1, Student o2) {
        return o2.score - o1.score;
    }
}
