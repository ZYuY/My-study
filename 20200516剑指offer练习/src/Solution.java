public class Solution {

//select * from employees where hire_date=(select max(hire_date) from employees)
    /**
     * limit n   是从第1条开始取n条数据  索引是从1开始的
     * limit m,n  是从m+1条开始取n条数据
     * select * from employees order by hire_date desc limit 2,1;
     * select salaries.*,dept_manager.dept_no from salaries join dept_manager on salaries.to_date='9999-01-01'
     * and  dept_manager.to_date='9999-01-01' and salaries.emp_no=dept_manager.emp_no;
     *
     * select e.last_name,e.first_name,d.dept_no from employees as e join dept_emp as d on
     * e.emp_no=d.emp_no;
     *
     * select e.last_name,e.first_name,d.dept_no from employees as e left join dept_emp as d
     * on e.emp_no=d.emp_no;
     *
     * select emp_no from employees where emp_no not in(select emp_no from dept_manager)
     *
     *
     */
}
