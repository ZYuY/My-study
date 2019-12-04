public class Text {
        public String replaceSpace(StringBuffer str) {
            StringBuffer e=new StringBuffer();
            for(int i=0;i<str.length();i++){
                char a=str.charAt(i);
                if(a==' '){
                    e.append("%20") ;
                }else{
                    e.append(a);
                }
            }
            return e.toString();
        }
}
