package thread.questions.file_blocks;

import sun.jvm.hotspot.runtime.Bytes;

public class FileReader implements Reader{
    File file;

    public FileReader(File file) {
        this.file = file;
    }

    @Override
    public byte[] read(int offset, int n) {
        System.out.println("reading from offset " + offset);
        byte[] bytes = new byte[n];
        for (int i = 0; i < n ;i++){
            bytes[i] = file.bytes[offset+i];
        }
        return bytes;
    }
}
