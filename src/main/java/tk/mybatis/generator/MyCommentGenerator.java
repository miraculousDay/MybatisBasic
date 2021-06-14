package tk.mybatis.generator;

import org.mybatis.generator.internal.DefaultCommentGenerator;

import java.util.Properties;

/**
 * @author : tanyu
 * create at:  2019-08-11  20:04
 * @description: generator字段注解配置
 */
public class MyCommentGenerator extends DefaultCommentGenerator {
    private boolean suppressAllComments;
    private boolean addRemarkComments;

    public void addConfigurationProperties(Properties properties) {
        super.addConfigurationProperties(properties);
//        suppressAllComments = isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_ALL_COMMENTS));
    }

}
