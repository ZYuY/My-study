import java.io.File;

public class Scanner {
    public static void scannerDirector(TreeNode node){
        File[]files=node.file.listFiles();
        if(files==null)
            return ;
        for(File i:files){
            TreeNode child=new TreeNode();
            child.file=i;
            if(i.isDirectory()){
                scannerDirector(child);
            }else{
                child.totallength=i.length();
            }
            node.totallength+=child.totallength;
            node.children.add(child);
        }

    }
}
