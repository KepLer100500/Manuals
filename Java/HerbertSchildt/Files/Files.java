import java.io.*;


public class Files {
    public static void copy() {
        int chr;
        FileInputStream inputFile = null;
        FileOutputStream outputFile = null;
        try {
            inputFile = new FileInputStream(".\\Files\\text.txt");
            outputFile = new FileOutputStream(".\\Files\\text_copy.txt");
            do {
                chr = inputFile.read();
                System.out.print((char)chr);
                if(chr != -1) {
                    outputFile.write(chr);
                }
            } while(chr != -1); // (eof) end of file
        }
        catch(IOException err) {
            System.out.println("Input / output error: " + err);
        }
        finally {
            try {
                if(inputFile != null) {
                    inputFile.close();
                }
            }
            catch(IOException err) {
                System.out.println("Close error");
            }
            try {
                if(outputFile != null) {
                    outputFile.close();
                }
            }
            catch(IOException err) {
                System.out.println("Close error");
            }
        }
    }

    public static void copyExtTry() {
        int chr;
        // try with resources
        try (FileInputStream inputFile = new FileInputStream(".\\Files\\text.txt");
            FileOutputStream outputFile = new FileOutputStream(".\\Files\\text_copy2.txt")) {
            do {
                chr = inputFile.read();
                System.out.print((char)chr);
                if(chr != -1) {
                    outputFile.write(chr);
                }
            } while(chr != -1); // (eof) end of file
        }
        catch(IOException err) {
            System.out.println("Input / output error: " + err);
        }
    }

    public static void rwdata() {
        int a = 5;
        double b = 10.2;
        boolean c = true;
        // write binary file
        try (DataOutputStream fout = new DataOutputStream(
            new FileOutputStream(".\\Files\\different_types.txt"))) {
            fout.writeInt(a);
            fout.writeDouble(b);
            fout.writeBoolean(c);
        }
        catch(IOException err) {
            System.out.println("Error on write file");
        }
        // read binary file
        try (DataInputStream fin = new DataInputStream(
            new FileInputStream(".\\Files\\different_types.txt"))) {
            a = fin.readInt();
            b = fin.readDouble();
            c = fin.readBoolean();
            System.out.println(a + "\n" + b + "\n" + c);
        }
        catch(IOException err) {
            System.out.println("Error on read file");
        }
    }

    public static void randomRW() {
        // int - 4 bytes
        // double - 8 bytes
        int[] data = {0, 1, 2, 3, 4, 5, 6, 7};
        int outData;
        try(RandomAccessFile raf = new RandomAccessFile(".\\Files\\random_access_file.txt", "rw")) {
            // write bytes to file
            for(int elem: data) {
                raf.writeInt(elem);
            }
            // read bytes from file
            raf.seek(0); // start position in file
            outData = raf.readInt();
            System.out.println("First item: " + outData);

            raf.seek(4); // int = 4 byte
            outData = raf.readInt();
            System.out.println("Second item: " + outData);

            for(int i=0; i < data.length;i += 2) {
                raf.seek(i * 4);
                outData = raf.readInt();
                System.out.print(outData + " ");
            }
        }
        catch(IOException err) {
            System.out.println("Error on read file");
        }
    }

    public static void writerBuffer() {
        String s = "";
        BufferedReader bufRead = new BufferedReader(
            new InputStreamReader(System.in)
        );
        try(FileWriter fw = new FileWriter(".\\Files\\strings_for_cli.txt", false)) { 
            // true - append text to file
            // false - create new file
            // first step is write info to file
            System.out.println("Stop string -> stop");
            do {
                s = bufRead.readLine();
                if(s.equals("stop")) {
                    break;
                }
                fw.write(s + "\r\n");
            } while(!s.equals("stop"));
            //second step is read file
            
        }
        catch(IOException err) {
            System.out.println("Error on write file");
        }
    }

    public static void readerBuffer() {
        String s;
        try(BufferedReader bufRead = new BufferedReader(new FileReader(".\\Files\\strings_for_cli.txt"))) {
            while((s = bufRead.readLine()) != null) {
                System.out.println(s);    
            }
        } 
        catch(IOException err) {
            System.out.println("Error on read file");
        }
    }

    // print absolute path to all files contains folder
    public static void printFilesInPath() {
        File dir = new File("C:\\Users\\k.repin\\Java");
        File[] arrFiles = dir.listFiles();
        for(File path : arrFiles) {
            System.out.println(path.getPath());
        }
    }

    public static void getDomainName() {
        System.out.println(System.getProperty("user.name")); // domain name
    }

    public static void main(String[] args) throws IOException {
        getDomainName();
        copy();
        copyExtTry();
        rwdata();
        randomRW();
        writerBuffer(); // input from cli some text, and input "stop"
        readerBuffer();
        printFilesInPath();
    }
}
