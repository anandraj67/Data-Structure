package thread.questions.file_blocks;

public class FileWriter implements Writer{
    File file;

    public FileWriter(File file) {
        this.file = file;
    }

    @Override
    public void write(byte[] data, int offset) {
        System.out.println("writing to offset " + offset);
        for (int i =0; i<data.length; i++){
            file.bytes[offset+i] = data[i];
        }
    }
}
