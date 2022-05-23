import java.lang.reflect.*;
import java.io.*;
import static java.lang.Math.random;


public class IOConsole {

    public static void terminalInput() throws IOException {
        // input two chars without spaces
        char input_char1, input_char2;
        input_char1 = (char) System.in.read();
        input_char2 = (char) System.in.read();
        System.out.println("From terminal1 inputed: " + input_char1 + " | " + input_char2);
    }

    public static void terminalInputAnother() {
        // input single char
        char input_char;
        try {
            input_char = (char) System.in.read();
            System.out.println("From terminal2 inputed: " + input_char);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void happyChance() throws IOException {
        // a -> 97, z -> 122, take random char for 'a' to 'z'
        // char rnd_char = (char)(25 * random() + 97); // also work
        int attempt = 3;
        char answer, ignore;
        char rnd_char = (char)(('z' - 'a') * random() + 'a');
        System.out.println("Guess character [a-z]\nSecret char: " + rnd_char);
        do {
            answer = (char) System.in.read();
            do {
                ignore = (char) System.in.read();
            } while(ignore != '\n');
            if(answer == rnd_char) {
                System.out.println("Yes!");
                break;
            }
            attempt--;
        } while(attempt > 0);
    }

    public static void readingBytes() throws IOException {
        byte[] data = new byte[10];
        System.out.println("Please input bytes.");
        System.in.read(data);
        for(int i=0; i < data.length; i++) {
            System.out.print((char)data[i]);
        }
        System.out.println();

        // Output X into console
        int x = 'X';
        System.out.write(x);
        System.out.write('\n');
    }

    public static void readerChr() throws IOException {
        char chr;
        BufferedReader bufRead = new BufferedReader(
            new InputStreamReader(System.in)
        );
        System.out.println("Input string contains '.'");
        do {
            chr = (char)bufRead.read();
            System.out.println(chr);
        } while(chr != '.'); // read chars from console until enter '.' in input string
    }

    public static void readerStr() throws IOException {
        String s = "";
        BufferedReader bufRead = new BufferedReader(
            new InputStreamReader(System.in)
        );
        System.out.println("Stop string -> stop");
        while(!s.equals("stop")) { // read lines from console until enter 'stop' word
            s = bufRead.readLine();
            System.out.println(s);
        }
    }

    public static void customOutput() throws IOException {
        PrintWriter pw = new PrintWriter(System.out, true);
        pw.println("Printer writer string here"); // for agile output strings out languages
    }

    public static void main(String[] args) {
        String[] methods = {
            "terminalInput",
            "terminalInputAnother",
            "happyChance",
            "readingBytes",
            "readerChr",
            "readerStr",
            "customOutput"
        };

        IOConsole ioconsole = new IOConsole();
        Method nextMethod;
        for(String method : methods) {
            try {
                nextMethod = ioconsole.getClass().getMethod(method);
                nextMethod.invoke(ioconsole);
            } catch(NoSuchMethodException | InvocationTargetException | IllegalAccessException err) {
                System.out.println("Method not found or you have not access to this method!");
            }
        }
    }
}