import java.io.File;

public class Scanner {
    public static void scannerDirectory(TreeNode node){
        File[]files=node.file.listFiles();
        if(files==null)
            return;
        for(File file:files){
            TreeNode child=new TreeNode();
            child.file=file;
            if(file.isDirectory()){
                scannerDirectory(child);
            }else{
                child.totallength=file.length();
            }
            node.totallength=child.totallength;
            node.children.add(child);
        }
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode();
        root.file=new File("D:\\c#");
        scannerDirectory(root);
        report(root,0);
    }

    private static void report(TreeNode root,int level) {
        for(int i=0;i<level*4;i++){
            System.out.println(" ");
        }
        if(root.file.isDirectory()){
            System.out.println("\\");
        }
        System.out.println(" "+root.totallength);
        System.out.println(root.file.getName());
        for(TreeNode node:root.children){
            report(node,level+1);
        }
    }
}
