package thread.questions.file_blocks;

public class File {
    byte [] bytes;

    public File() {
        bytes = new byte[100];
    }

    public void fill(){
        for(int b=0;b<100;b++){
            bytes[b] = (byte) b;
        }
    }
}
