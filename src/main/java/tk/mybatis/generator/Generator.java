package tk.mybatis.generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: tanyu
 * @date: 2019-08-03 13:24
 * @describe: Java方式mybatis生成代码
 */
public class Generator {
    public static void main(String[] args) throws Exception {
        List<String> warming = new ArrayList<String>();//警告内容集合
        boolean overWrite = true;//是否覆盖原有存在的类
        //读取配置文件
        InputStream is = Generator.class.getResourceAsStream("/generatorConfig.xml");
        //创建解析器
        ConfigurationParser parser = new ConfigurationParser(warming);
        Configuration config = parser.parseConfiguration(is);
        is.close();
        DefaultShellCallback back = new DefaultShellCallback(overWrite);
        //创建MBG
        MyBatisGenerator gen = new MyBatisGenerator(config,back,warming);
        gen.generate(null);
        for(String warning : warming) {
            System.out.println("warning:"+warning);
        }
    }
}
