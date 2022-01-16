package thread.questions.file_blocks;

import java.util.*;
import java.util.concurrent.*;

/**
 interface Reader {
 byte[] read(int offset, int n)
 }

 interface Writer {
 void write(byte[] data, int offset)
 }

 // start is inclusive and end is exclusive
 class Block {
 int start;
 int end;
 }


 // blocks: [(1, 10), (100, 1000), (10000, 50000)]
 void copyChangedBlocks(Reader reader, Writer writer, Block[] blocks) {
 // implement this
 }

 Assumptions:
 1. Blocks is sorted and non-overlapping.

 Requirements:
 1. The reader is really slow, so you should use multiple threads to read
 from the reader.
 2. The writer is not thread-safe, so you must use a single thread to write to the writer.
 */

public class MainRunner {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        File file1 = new File();
        file1.fill();

        Reader reader = new FileReader(file1);

        File file2 = new File();
        Writer writer = new FileWriter(file2);

        Block[] blocks = new Block[]{new Block(0,5) , new Block(10,15)};

        copyChangedBlocks(reader, writer, blocks);

    }

    // blocks: [(1, 10), (100, 1000), (10000, 50000)]
    public  static  void copyChangedBlocks(Reader reader, Writer writer, Block[] blocks) throws InterruptedException, ExecutionException {
        // implement this ???

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Set<Callable<BlockBytes>> callables = new HashSet<>();
        for(Block block: blocks){
            callables.add( ()-> new BlockBytes(block,reader.read(block.start, block.end - block.start)));
        }

        List<Future<BlockBytes>> futures = executorService.invokeAll(callables);
        for(Future<BlockBytes> future: futures){
            BlockBytes blockBytes = future.get();
            writer.write(blockBytes.bytes, blockBytes.block.start);
        }

        executorService.shutdown();
    }
}
