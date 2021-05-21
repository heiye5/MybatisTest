import com.kuang.dao.UserMapper;
import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.queryById(1);
        System.out.println(user);

//        mapper.updateUser(new User(2,"we","23342"));

        //清理缓存
        sqlSession.clearCache();

        System.out.println("----------------");
        User user2 = mapper.queryById(2);
        System.out.println(user2);

        System.out.println(user == user2);

        sqlSession.close();
    }


    @Test
    public void cacheTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserMapper mapper2 = sqlSession.getMapper(UserMapper.class);

        User user = mapper.queryById(1);
        System.out.println(user);
        User user2 = mapper2.queryById(1);
        System.out.println(user2);

        sqlSession.close();
        sqlSession2.close();
    }

}
