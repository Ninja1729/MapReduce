package wordcount;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.apache.hadoop.mrunit.mapreduce.MapReduceDriver;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import wordcount.WordCount;

import java.io.IOException;

import static junit.framework.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
class AppTest
{
    MapDriver<Object, Text, Text, IntWritable> mapDriver;
    ReduceDriver<Text, IntWritable, Text, IntWritable> reduceDriver;



    public void setUp() {
        WordCount.TokenizerMapper mapper = new WordCount.TokenizerMapper();
        WordCount.IntSumReducer reducer = new WordCount.IntSumReducer();

        mapDriver = MapDriver.newMapDriver(mapper);
        reduceDriver = ReduceDriver.newReduceDriver(reducer);

    }

    public void testMapper() throws IOException {
        mapDriver.withInput(new Object(), new Text(
                "hello hello hello"));
        mapDriver.withOutput(new Text("hello"), new IntWritable(4));
        mapDriver.runTest();
    }
}
