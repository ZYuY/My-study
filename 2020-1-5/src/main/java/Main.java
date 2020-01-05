import org.fusesource.jansi.AnsiConsole ;

import java.sql.SQLOutput;

import static org.fusesource.jansi.Ansi .ansi ;
import static org.fusesource.jansi.Ansi .Color .*;
public class Main {
    public static void main(String[] args) {
        AnsiConsole .systemInstall();
        System.out.println(ansi().fg(BLUE).bg(GREEN));
    }
}
