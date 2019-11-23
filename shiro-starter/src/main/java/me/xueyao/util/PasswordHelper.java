package me.xueyao.util;

import me.xueyao.entity.User;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @author Simon.Xue
 * @date 2019-11-22 16:04
 **/
public class PasswordHelper {
    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    /**
     * 基础散列算法
     */
    public static final String ALGORITHM_NAME = "md5";
    /**
     * 自定义散列次数
     */
    public static final int HASH_ITERATIONS = 2;

    /**
     * 加密密码
     * @param user
     */
    public void encryptPassword(User user) {
        // 随机字符串作为salt因子，实际参与运算的salt我们还引入其它干扰因子
        user.setSalt(randomNumberGenerator.nextBytes().toHex());
        String newPassword = new SimpleHash(ALGORITHM_NAME, user.getPassword(),
                ByteSource.Util.bytes(user.getCredentialsSalt()), HASH_ITERATIONS).toHex();
        user.setPassword(newPassword);
    }
}
