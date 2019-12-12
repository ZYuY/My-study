import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 统计每个文件夹所有文件的大小
 */
public class TreeNode {
    File file;
    long totallength;//汇总了文件夹下所有文件总大小
    List<TreeNode> children=new ArrayList<>();
}
