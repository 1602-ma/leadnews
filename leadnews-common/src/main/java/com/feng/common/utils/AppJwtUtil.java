package com.feng.common.utils;

import com.feng.common.constants.SystemConstants;
import io.jsonwebtoken.*;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.*;

/**
 * @author f
 * @date 2022/8/2 22:11
 */
public class AppJwtUtil {

    /** token有效期一天 */
    private static final int TOKEN_TIME_OUT = 3600;
    /** 加密key */
    private static final String TOKEN_EN_KEY = "ll";
    /** 最小刷新间隔 */
    private static final int REFRESH_TIME = 300;

    /**
     * createToken
     * @param id id
     * @return token
     */
    public static String createToken(Long id) {
        Map<String, Object> claimMaps = new HashMap<>(26);
        claimMaps.put("id", id);
        long currentTime = System.currentTimeMillis();
        return Jwts.builder()
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(new Date(currentTime))
                .setSubject("system")
                .setIssuer("git")
                .setAudience("app")
                .compressWith(CompressionCodecs.GZIP)
                .signWith(SignatureAlgorithm.HS512, generalKey())
                .setExpiration(new Date(currentTime + TOKEN_TIME_OUT * 1000))
                .addClaims(claimMaps)
                .compact();
    }

    /**
     * 获取payload body
     * @param token token
     * @return body
     */
    private static Claims getClaimsBody(String token) {
        return getJws(token).getBody();
    }

    /**
     * 获取token中的claims信息
     * @param token token
     * @return claims
     */
    private static Jws<Claims> getJws(String token) {
        return Jwts.parser()
                .setSigningKey(generalKey())
                .parseClaimsJws(token);
    }

    /**
     * 获取header body
     * @param token token
     * @return header
     */
    public static JwsHeader getHeaderBody(String token) {
        return getJws(token).getHeader();
    }

    /**
     * 由字符串生成加密key
     * @return key
     */
    public static SecretKey generalKey() {
        byte[] encodeKey = Base64.getEncoder().encode(TOKEN_EN_KEY.getBytes());
        return new SecretKeySpec(encodeKey, 0, encodeKey.length, "ASE");
    }

    /**
     * 是否过期
     * @param token token
     * @return  0-无效 1-有效 2-已过期
     */
    public static Integer verifyToken(String token) {
        try {
            Claims claims = AppJwtUtil.getClaimsBody(token);
            if (null == claims) {
                return SystemConstants.JWT_FAIL;
            }
            return SystemConstants.JWT_OK;
        } catch (Exception e) {
            return SystemConstants.JWT_FAIL;
        }
    }
}
