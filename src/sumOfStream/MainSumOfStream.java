package sumOfStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainSumOfStream {
    public static void main(String[] args) throws Exception {
        byte[] input = {1, 2, 4, 10, 0, -1};
        InputStream inputStream = new ByteArrayInputStream(input);
        int result = sumOfStream(inputStream);
        System.out.println(result);
        String str = "Ы";
        byte[] b = str.getBytes();
        for(int i = 0; i < b.length; i++){
            System.out.println(((int) b[i] ^ -1 << 8) + " ");
        }

    }

    public static int sumOfStream(InputStream inputStream) throws IOException {
        int result = 0;
        int  inputByte;
        while ((inputByte =  inputStream.read()) != -1) {
            result += (byte) inputByte;
        }
        return result;
    }
}


