import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class StudentSort {
    public static  class cmp implements Comparator <Student>{

       @Override
       public int compare(Student o1, Student o2) {
           return 0;
       }
   }
    public static void insertSort(Student[] students){
        for(int i=1;i<students.length;i++){
            Student key=students[i];
            int j=i-1;
            for(;j>=0&&((Comparable<Student>)students[j]).compareTo(key)>0;j--){
                students[j+1]=students[j];
            }
            students[j+1]=key;
        }
    }
public static void insertSort(Student[]students,Comparator<Student> cmp){
    for(int i=1;i<students.length;i++){
        Student key=students[i];
        int j=i-1;
        for(;j>=0&&cmp.compare(students[j],key)>0;j--){
            students[j+1]=students[j];
        }
        students[j+1]=key;
    }
}
    public static void main(String[] args) {
        Student[] students = { new Student(), new Student(), new Student()};
        //insertSort(students);
        //Arrays.sort(students);
        //insertSort(students, new Cmp());
        Arrays.sort(students, new cmp());
    }
}
