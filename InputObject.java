package Object_Counting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputObject {

    private StringBuilder text = new StringBuilder();           //write filtered records from buffer

    public String read() {
        RandomAccessFile file = null;
        try {
            file = new RandomAccessFile("text.txt", "r");   //file for only read
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            System.out.println(e.getStackTrace());
        }

        try (
                FileChannel channel = file.getChannel();) {
            ByteBuffer buffer = ByteBuffer.allocate(25);     //Buffer with capacity 25
            int byteRead = channel.read(buffer);             //return count object; read info from channel in buffer
            while (byteRead > 0) {                           //if there is something to read
                buffer.flip();                               //change mode to buffer and into read mode
                while (buffer.hasRemaining()) {               //if there is something in buffer
                    text.append((char) buffer.get());          //add 1 byte into text
                }
                buffer.clear();                               //change mode into write
                byteRead = channel.read(buffer);              //take 25 bytes

            }
        } catch (IOException e) {
            System.out.println(e.getStackTrace());

        }
        return text.toString();
    }

    public int count(String word, String text) {  //count the number of matches of a word in the text and text
        Pattern pattern = Pattern.compile("\\b" + word + "\\b");   //word search pattern
        Matcher matcher = pattern.matcher(text);
        int count = 0;                      //number of matches
        while (matcher.find()) {               //if there are matches, then count++
            count++;
        }
        return count;
    }
}
