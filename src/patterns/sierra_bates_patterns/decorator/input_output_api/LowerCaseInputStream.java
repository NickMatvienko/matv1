package patterns.sierra_bates_patterns.decorator.input_output_api;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by a on 15.02.17.
 */
public class LowerCaseInputStream extends FilterInputStream {

    public LowerCaseInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        return (c==-1?c:Character.toLowerCase((char)c));
    }

    @Override
    public int read(byte[] b, int offset, int length) throws IOException {
 int result = super.read(b, offset, length);
 for (int i=offset; i<offset+result; i++) {
     b[i] = (byte)Character.toLowerCase((char)b[i]);
 }
 return result;
    }
}
